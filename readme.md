<p align="center">
    <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" align="center" width="30%">
</p>
<p align="center"><h1 align="center">MODULES-DOOR-LIB</h1></p>
<p align="center">
	<em>
	Lightweight Android library for seamless inter-module communication using a unified event and message system.  
	</em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/shubham-gadekar-alpha/Modules-Door-Lib?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/shubham-gadekar-alpha/Modules-Door-Lib?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/shubham-gadekar-alpha/Modules-Door-Lib?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/shubham-gadekar-alpha/Modules-Door-Lib?style=default&color=0080ff" alt="repo-language-count">
	<img src="https://jitpack.io/v/shubham-gadekar-alpha/Modules-Door-Lib.svg">
</p>
<br>

[[](https://jitpack.io/v/shubham-gadekar-alpha/Modules-Door-Lib.svg)](https://jitpack.io/#shubham-gadekar-alpha/Modules-Door-Lib)


## 🔗 Table of Contents

- [📍 Overview](#-overview)
- [👾 Features](#-features)
- [🔑 Core Concepts](#-core-concepts)
- [🚀 Getting Started](#-getting-started)
  - [☑️ Prerequisites](#-prerequisites)
  - [⚙️ Installation](#-installation)
  - [🤖 Usage](#🤖-usage)
  - [🏗️ Application Setup](#️-application-setup)
  - [🧪 Testing](#🧪-testing)
- [📌 Project Roadmap](#-project-roadmap)
- [🔰 Contributing](#-contributing)
- [🎗 License](#-license)
- [🙌 Acknowledgments](#-acknowledgments)

---

## 📍 Overview

**Modules-Door-Lib** is a lightweight Android library designed for **multi-module projects**, enabling **seamless communication** between modules.

At the core is the abstract class `DoorEntry`, the **single entry point** of each module.  
All **transactions** (commands and events) flow through this class, keeping your architecture **decoupled and scalable**.

Developers only need to register:
- **`messageList`** → Defines which messages a module can send or receive.
- **`eventList`** → Defines which events a module can publish or subscribe to.

👉 Initialization, event publishing, and subscription handling are fully managed by the **kernel**, so you don’t need to write any boilerplate.

---

## 👾 Features

|      | Feature         | Summary       |
| :--- | :---:           | :---          |
| 🔗 | **Communication** | <ul><li>Command-based messaging (send/receive).</li><li>Flow-based streaming (publish/subscribe).</li><li>Json-based payloads for safe module-to-module transfer.</li></ul> |
| 🧩 | **Decoupling**    | <ul><li>Only `DoorEntry` is exposed – all other classes can be marked `internal`.</li><li>No direct dependency between modules.</li></ul> |
| 🚀 | **Scalability**   | <ul><li>Easily add, remove, or update modules without breaking the app.</li><li>Future support for UI (Jetpack Compose) planned.</li></ul> |
| ⚙️ | **Simplicity**    | <ul><li>No need to manage event lifecycle manually.</li><li>Kernel handles initialization, publish, and subscribe logic.</li></ul> |

---

## 🔑 Core Concepts

1. **Door Entry**
  - The entry point of a module. Extend `DoorEntry` once per module.

2. **Door Command**
  - Object passed between modules. Fields:
    - `messageName` → identifier
    - `payload` → optional Json data
    - `doorName` → target module

3. **MessageType**
  - `SendType`: Outgoing command
  - `ReceiveType`: Incoming command

4. **EventType**
  - `PublishType`: Publish a flow event
  - `SubscribeType`: Subscribe to a flow

5. **Door (Initializer Class)**
  - Responsible for initializing internal processes with all DoorEntry classes.
  - Should be initialized once inside your Application class.
  - Accepts a list of all DoorEntry implementations across modules.

6. **Kernel (Internal Engine)**
  - Handles:
    - Event publishing & subscribing
    - Message passing between modules
  - Transparent to developers (no manual setup required).


---
## ✅ Advantages
- Plug & Play: Just register DoorEntry classes with all messages and events
- Kernel-managed communication (publish/subscribe handled internally)
- Error reduction: Only need to declare events & messages correctly
- Scalable: Works seamlessly as modules grow

--- 
## 🚀 Getting Started

### ☑️ Prerequisites
- **Language**: Kotlin
- **Build Tool**: Gradle

### ⚙️ Installation

**Build from source:**

```sh
❯ git clone https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/
❯ cd Modules-Door-Lib
❯ gradle build
```

## 🤖 Usage

### Implement DoorEntry in your module:

```sh
@Singleton
class DataDoor @Inject internal constructor(
    private val bookRepository: BookRepository,
) : DoorEntry() {

    override val eventList: List<EventType>
        get() = listOf(
            EventType.PublishType("SubscribeBookById", this),
            EventType.PublishType("SubscribeReadingList", this),
        )

    override val messageList: List<MessageType>
        get() = listOf(
            MessageType.ReceiveType("GetBookById", this),
            MessageType.SendType("ReceivedBookByIdResponse", this),
        )

    override fun init() { /* Custom init if needed */ }

    override fun onReceive(message: DoorCommand) {
        // Handle incoming message here
    }

    override fun publish(message: DoorCommand): SharedFlow<DoorCommand> =
        throw NotImplementedError("Handled internally by kernel")

    override fun subscribe(subscription: SharedFlow<DoorCommand>, featureCommand: DoorCommand) =
        throw NotImplementedError("Handled internally by kernel")
}
```

---
## 🏗️ Application Setup

#### Finally, you need to collect all your doors in the Application class and initialize the Door kernel.

```
@HiltAndroidApp
class BooksExplorerApplication : Application() {

    @Inject
    lateinit var door: Door

    @Inject
    lateinit var door1: DoorEntry1

    @Inject
    lateinit var door2: DoorEntry2

    private val doorList: List<DoorEntry>
        get() = listOf(
            door1,
            door2
        )

    override fun onCreate() {
        super.onCreate()
        door.init(doorList) // Initializes all registered doors
    }
}

```
### 👉 This step is mandatory for the library to process all transactions behind the scenes.
---
## ⚙️ Installation

Add the following dependency to your **module-level `build.gradle`** file:

```gradle
implementation("com.github.shubham-gadekar-alpha:Modules-Door-Lib:v1.0.1")
```

Also make sure you have JitPack added to your project-level settings.gradle (or build.gradle if using older Gradle):

```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

```
---
## 📌 Project Roadmap

- [X] Support command-based messaging
- [x] Support flow-based event streaming
- [ ] Add support for Jetpack Compose UI sharing
- [ ] Advanced debugging & logging tools

---


## 🔰 Contributing

- **🐛 [Report Issues](https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/issues)**: Submit bugs found or log feature requests for the `Modules-Door-Lib` project.
- **💡 [Submit Pull Requests](https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/shubham-gadekar-alpha/Modules-Door-Lib/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=shubham-gadekar-alpha/Modules-Door-Lib">
   </a>
</p>
</details>

---

## 🙌 Acknowledgments

- List any resources, contributors, inspiration, etc. here.
- Inspired by the need for **clean multi-module Android architecture.**

---
