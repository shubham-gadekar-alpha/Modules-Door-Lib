<p align="center">
    <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" align="center" width="30%">
</p>
<p align="center"><h1 align="center">MODULES-DOOR-LIB</h1></p>
<p align="center">
	<em>**"Modules-Door-Lib: Unlocking Seamless Integration, One Module at a Time!"**</em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/shubham-gadekar-alpha/Modules-Door-Lib?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/shubham-gadekar-alpha/Modules-Door-Lib?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/shubham-gadekar-alpha/Modules-Door-Lib?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/shubham-gadekar-alpha/Modules-Door-Lib?style=default&color=0080ff" alt="repo-language-count">
</p>
<p align="center"><!-- default option, no dependency badges. -->
</p>
<p align="center">
	<!-- default option, no dependency badges. -->
</p>
<br>

## 🔗 Table of Contents

- [📍 Overview](#-overview)
- [👾 Features](#-features)
- [📁 Project Structure](#-project-structure)
  - [📂 Project Index](#-project-index)
- [🚀 Getting Started](#-getting-started)
  - [☑️ Prerequisites](#-prerequisites)
  - [⚙️ Installation](#-installation)
  - [🤖 Usage](#🤖-usage)
  - [🧪 Testing](#🧪-testing)
- [📌 Project Roadmap](#-project-roadmap)
- [🔰 Contributing](#-contributing)
- [🎗 License](#-license)
- [🙌 Acknowledgments](#-acknowledgments)

---

## 📍 Overview

This library provides a structured way to build multi-module Android applications, enabling seamless communication between independent modules.
At the core of the library is the DoorEntry abstract class, which acts as the entry point for every module integrated with this library.
Each module defines its own implementation of DoorEntry.

All transactions between modules (messages and events) flow through this entry point.
To establish communication, every module must declare its messageList and eventList within DoorEntry. These lists define what kind of messages a module can send and what events it can handle.

This ensures:
- 🔗 Clear and centralized communication between modules.
- 🧩 Decoupled module design – modules don’t depend on each other directly.
- 📦 Scalability – easy to add, remove, or update modules without breaking the app.

---

## 👾 Features

|      | Feature         | Summary       |
| :--- | :---:           | :---          |
| ⚙️  | **Architecture**  | <ul><li>Utilizes Kotlin primarily, with support for Android development.</li><li>Centralized configuration via `build.gradle.kts` for plugins and dependencies.</li><li>Structured into main application and modules, managed by `settings.gradle.kts`.</li></ul> |
| 🔩 | **Code Quality**  | <ul><li>Incorporates Detekt and ktlint for static code analysis and linting.</li><li>Follows strict repository mode to ensure clean dependency management.</li><li>Codebase predominantly consists of Kotlin files, ensuring modern practices and language features are used.</li></ul> |
| 📄 | **Documentation** | <ul><li>Documentation includes a `Readme.me` file providing an overview and setup instructions.</li><li>Documentation is not extensive but covers basic installation and usage commands.</li><li>Primary documentation language is Kotlin, with additional scripts and configuration files documented.</li></ul> |
| 🔌 | **Integrations**  | <ul><li>Integrates with Gradle for build management.</li><li>Supports Android development with specific plugins and dependencies.</li><li>Uses Dagger Hilt for dependency injection, enhancing modularity and maintainability.</li></ul> |
| 🧩 | **Modularity**    | <ul><li>Project is structured into multiple modules, enhancing separation of concerns.</li><li>Uses Gradle to manage module dependencies and configurations.</li><li>Modular architecture supports scalable and maintainable codebase.</li></ul> |
| 🧪 | **Testing**       | <ul><li>Includes commands for running tests using Gradle.</li><li>Testing strategy and framework details are not explicitly mentioned but are likely integrated within the Gradle setup.</li><li>Focus on testing is implied through the use of modern development practices.</li></ul> |
| ⚡️  | **Performance**   | <ul><li>Performance considerations are managed through efficient dependency management and modular architecture.</li><li>Uses Kotlin, which is known for its concise syntax and efficient JVM performance.</li><li>Specific performance metrics or optimizations are not detailed.</li></ul> |
| 🛡️ | **Security**      | <ul><li>Strict repository mode in Gradle settings enhances security by avoiding untrusted repositories.</li><li>Security practices specific to Android development are likely adhered to, given the project's structure and dependencies.</li><li>Detailed security practices are not explicitly documented.</li></ul> |
| 📦 | **Dependencies**  | <ul><li>Depends on several key technologies including Gradle, Kotlin, and Android-specific libraries.</li><li>Uses a `libs.versions.toml` file for managing library versions centrally.</li><li>Dependency management is streamlined through Gradle scripts.</li></ul> |

---

## 📁 Project Structure

```sh
└── Modules-Door-Lib/
    ├── Readme.me
    ├── build.gradle.kts
    ├── config
    │   └── detekt
    │       └── detekt.yml
    ├── data
    │   ├── .gitignore
    │   ├── build.gradle.kts
    │   ├── consumer-rules.pro
    │   ├── proguard-rules.pro
    │   └── src
    │       ├── androidTest
    │       │   └── java
    │       │       └── com
    │       ├── main
    │       │   ├── AndroidManifest.xml
    │       │   └── java
    │       │       └── com
    │       └── test
    │           └── java
    │               └── com
    ├── demo-app
    │   ├── .gitignore
    │   ├── build.gradle.kts
    │   ├── proguard-rules.pro
    │   └── src
    │       ├── androidTest
    │       │   └── java
    │       │       └── com
    │       ├── main
    │       │   ├── AndroidManifest.xml
    │       │   ├── java
    │       │   │   └── com
    │       │   └── res
    │       │       ├── drawable
    │       │       ├── mipmap-anydpi-v26
    │       │       ├── mipmap-hdpi
    │       │       ├── mipmap-mdpi
    │       │       ├── mipmap-xhdpi
    │       │       ├── mipmap-xxhdpi
    │       │       ├── mipmap-xxxhdpi
    │       │       ├── values
    │       │       └── xml
    │       └── test
    │           └── java
    │               └── com
    ├── gradle
    │   ├── libs.versions.toml
    │   └── wrapper
    │       ├── gradle-wrapper.jar
    │       └── gradle-wrapper.properties
    ├── gradle.properties
    ├── gradlew
    ├── gradlew.bat
    ├── modulesDoor
    │   ├── .gitignore
    │   ├── build.gradle.kts
    │   ├── consumer-rules.pro
    │   ├── proguard-rules.pro
    │   └── src
    │       ├── androidTest
    │       │   └── java
    │       │       └── com
    │       ├── main
    │       │   ├── AndroidManifest.xml
    │       │   └── java
    │       │       └── com
    │       └── test
    │           └── java
    │               └── com
    ├── readme.md
    └── settings.gradle.kts
```


### 📂 Project Index
<details open>
	<summary><b><code>MODULES-DOOR-LIB/</code></b></summary>
	<details> <!-- __root__ Submodule -->
		<summary><b>__root__</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/gradlew.bat'>gradlew.bat</a></b></td>
				<td>- Gradlew.bat serves as the startup script for Gradle on Windows within the project, facilitating the initialization and configuration of the Gradle environment<br>- It ensures the Java installation is correctly set up, manages JVM options, and executes Gradle tasks, thereby streamlining the build process and dependency management for developers.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/build.gradle.kts'>build.gradle.kts</a></b></td>
				<td>- Establishes a centralized configuration for the entire project, specifying common plugins and dependencies essential for all sub-projects or modules<br>- It includes settings for Android development, Kotlin, and code quality tools like Detekt and ktlint, alongside dependencies for Dagger Hilt and the Android Gradle plugin.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/settings.gradle.kts'>settings.gradle.kts</a></b></td>
				<td>- Manages plugin and dependency configurations for the "Modules-Door-Lib" project, ensuring that only specific Google and Android-related artifacts are included from the configured repositories<br>- It also sets a strict repository mode to prevent project-level repositories from interfering, and organizes the project structure by defining the main application and its modules.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/Readme.me'>Readme.me</a></b></td>
				<td>- Serves as the introductory guide and overview for the entire project, providing essential information on the project's purpose, setup instructions, and usage<br>- It is crucial for new users and contributors to understand the project's scope and how to navigate its components effectively.</td>
			</tr>
			</table>
		</blockquote>
	</details>
	<details> <!-- config Submodule -->
		<summary><b>config</b></summary>
		<blockquote>
			<details>
				<summary><b>detekt</b></summary>
				<blockquote>
					<table>
					<tr>
						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/config/detekt/detekt.yml'>detekt.yml</a></b></td>
						<td>- Configures the Detekt static code analysis tool for the project, setting stringent quality controls with a zero-tolerance policy on issues<br>- It customizes rules for code style, complexity, and formatting to ensure high standards, including specific thresholds for method length and parameters, while disabling certain checks like documentation requirements and function naming conventions.</td>
					</tr>
					</table>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<details> <!-- demo-app Submodule -->
		<summary><b>demo-app</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/build.gradle.kts'>build.gradle.kts</a></b></td>
				<td>- Configures the build environment for the 'demo-app' module within a larger Android application project, specifying dependencies, plugins, and build settings<br>- It sets up essential tools and libraries for Android development, including Kotlin, Jetpack Compose, Hilt, Retrofit, and Room, ensuring robust, maintainable, and scalable application architecture<br>- Additionally, it integrates quality assurance tools like Jacoco, Detekt, and ktlint to maintain code quality and consistency.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/proguard-rules.pro'>proguard-rules.pro</a></b></td>
				<td>- ProGuard configuration rules specific to the demo-app are defined to optimize and secure its Android application by minimizing and obfuscating the code<br>- These settings manage how the app's Java bytecode is processed, enhancing its performance and protecting it from reverse engineering<br>- Adjustments can be made in the build.gradle to tailor protection features.</td>
			</tr>
			</table>
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<details>
												<summary><b>alpha</b></summary>
												<blockquote>
													<details>
														<summary><b>books_explorer</b></summary>
														<blockquote>
															<table>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/BooksExplorerApplication.kt'>BooksExplorerApplication.kt</a></b></td>
																<td>- BooksExplorerApplication serves as the main entry point for the Android application within the Books Explorer project<br>- It initializes the application's environment using Dagger Hilt for dependency injection and sets up necessary modules through the DoorInitializer component, ensuring all dependencies are properly managed and operational at launch.</td>
															</tr>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/MainAppDoor.kt'>MainAppDoor.kt</a></b></td>
																<td>- MainAppDoor in the Books Explorer app serves as a central communication hub, managing interactions related to book data<br>- It handles tasks such as fetching, updating, and subscribing to changes in book lists and individual book details, facilitating real-time data flow and updates across the application's various components.</td>
															</tr>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/MainActivity.kt'>MainActivity.kt</a></b></td>
																<td>- MainActivity serves as the primary entry point for the Books Explorer application, initializing the user interface within a Compose-based architecture<br>- It sets up a theme and navigation host, ensuring a seamless edge-to-edge experience on devices<br>- This activity is crucial for orchestrating the visual and navigational aspects of the app.</td>
															</tr>
															</table>
															<details>
																<summary><b>di</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/di/DoorModule.kt'>DoorModule.kt</a></b></td>
																		<td>- DoorModule in the demo-app's dependency injection layer facilitates the initialization and provision of core components such as context, platform-specific functionalities, and initialization logic for the application<br>- It ensures that essential services like Door and DoorInitializer are available as singletons throughout the application, enhancing maintainability and scalability.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
															<details>
																<summary><b>platform</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/platform/Messages.kt'>Messages.kt</a></b></td>
																		<td>- Defines a set of internal messages used across the `books_explorer` module in the demo application<br>- These messages, including initiating data retrieval for students and processing payments, facilitate communication and control flow within the application, ensuring modular and clear interactions between different components of the system.</td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/platform/DoorInitializerImpl.kt'>DoorInitializerImpl.kt</a></b></td>
																		<td>- DoorInitializerImpl serves as a crucial component within the Books Explorer app, managing the initialization and setup of various modules through the Door interface<br>- It orchestrates the integration of data and main application functionalities, ensuring they are correctly initialized with the necessary context and dependencies for the app's operation.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
															<details>
																<summary><b>domain</b></summary>
																<blockquote>
																	<details>
																		<summary><b>model</b></summary>
																		<blockquote>
																			<table>
																			<tr>
																				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/domain/model/Book.kt'>Book.kt</a></b></td>
																				<td>- Defines the core data structures for representing books within the Books Explorer application, specifically focusing on encapsulating book details such as title, authors, and publishing information<br>- These structures are crucial for managing and accessing book data throughout the application, ensuring that book-related operations are streamlined and consistent.</td>
																			</tr>
																			</table>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
															<details>
																<summary><b>presentation</b></summary>
																<blockquote>
																	<details>
																		<summary><b>navigation</b></summary>
																		<blockquote>
																			<table>
																			<tr>
																				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/navigation/NavGraph.kt'>NavGraph.kt</a></b></td>
																				<td>- MyAppNavHost serves as the central navigation hub for the Books Explorer app, orchestrating transitions between different user interfaces such as the Home, Search, Profile, Wishlist, and Book Details screens<br>- It utilizes a navigation controller to manage the app's flow and ensures appropriate padding is applied for UI consistency.</td>
																			</tr>
																			</table>
																		</blockquote>
																	</details>
																	<details>
																		<summary><b>ui</b></summary>
																		<blockquote>
																			<table>
																			<tr>
																				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/CommonUi.kt'>CommonUi.kt</a></b></td>
																				<td>- CommonUi.kt provides the user interface components for displaying book lists and individual book cards within the Books Explorer app<br>- It includes a dynamic list that shows books or a message when empty, and clickable cards that navigate to detailed views of each book, enhancing user interaction and navigation within the app.</td>
																			</tr>
																			</table>
																			<details>
																				<summary><b>profile</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/profile/ProfileScreen.kt'>ProfileScreen.kt</a></b></td>
																						<td>- ProfileScreen.kt serves as the user interface component within the Books Explorer app, specifically managing the display and interaction within the user's profile page<br>- It facilitates navigation, displays user details, and provides links to other sections like the user's wishlist, enhancing the overall user experience by integrating with the app's navigation and state management systems.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/profile/ProfileViewModel.kt'>ProfileViewModel.kt</a></b></td>
																						<td>- ProfileViewModel, located within the Books Explorer app's profile UI module, manages user profile data using reactive state flows<br>- It facilitates the dynamic updating of user first and last names, maintaining responsiveness and state consistency across the user interface, thereby enhancing the user experience in profile management.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>theme</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/theme/Theme.kt'>Theme.kt</a></b></td>
																						<td>- BookExplorerTheme, defined within the Books Explorer app's theme management, dynamically adjusts the UI's color scheme based on system settings and Android version<br>- It supports both light and dark themes, incorporating a dynamic color feature for devices running Android 12 and above, enhancing visual consistency and user experience across the application.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/theme/Type.kt'>Type.kt</a></b></td>
																						<td>- Defines the typography settings for the Books Explorer app, establishing a consistent visual style across the user interface<br>- It configures text attributes such as font family, weight, size, and spacing, utilizing the Material Design typography system<br>- This setup ensures a uniform appearance and readability throughout the application's various screens and components.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/theme/Color.kt'>Color.kt</a></b></td>
																						<td>- Defines the color palette for the user interface theme of the Books Explorer application, ensuring visual consistency across the app<br>- Colors such as Purple80, PurpleGrey80, and Pink80 are specified for lighter themes, while Purple40, PurpleGrey40, and Pink40 cater to darker themes, enhancing the aesthetic appeal and user experience.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>search</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/search/SearchScreen.kt'>SearchScreen.kt</a></b></td>
																						<td>- SearchScreen.kt facilitates user interaction for book searches within the Books Explorer app<br>- It provides a user interface where users can enter search queries, view results, and manage pagination of book lists<br>- The screen handles loading states, displays errors, and supports navigation back to previous screens, enhancing the app's usability and functionality in searching and displaying book data.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/search/SearchUiState.kt'>SearchUiState.kt</a></b></td>
																						<td>- SearchUiState.kt defines the state management for the search functionality within the Books Explorer app, managing UI states such as loading indicators, pagination loading, and search results<br>- It encapsulates the state of book search operations, including error handling and tracking whether a search query has been executed.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/search/SearchViewModel.kt'>SearchViewModel.kt</a></b></td>
																						<td>- SearchViewModel in the Books Explorer app manages the search functionality for books<br>- It handles user input to update search queries, controls pagination of search results, and maintains the state of the UI during data fetching<br>- The ViewModel interacts with the main application logic to fetch and display books based on user searches.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>details</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/details/BookDetailViewModel.kt'>BookDetailViewModel.kt</a></b></td>
																						<td>- BookDetailViewModel orchestrates the user interactions with book details within the application, managing state related to individual book information, wishlist, and reading list status<br>- It handles data fetching, updates, and synchronization tasks by interfacing with the MainAppDoor, ensuring a responsive and accurate user experience in the book details view.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/details/BookDetailsUiState.kt'>BookDetailsUiState.kt</a></b></td>
																						<td>- BookDetailsUiState.kt defines the UI state for the book details view in the Books Explorer app, managing the display of loading indicators, book information, and error messages<br>- It encapsulates the state management for the book details component, ensuring a responsive and informative user interface within the app's architecture.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/details/BookDetailScreen.kt'>BookDetailScreen.kt</a></b></td>
																						<td>- BookDetailScreen in the Books Explorer app provides a detailed view of a selected book, allowing users to view comprehensive information including title, author, and description<br>- It supports interactive features like sharing book details, adding to a wishlist, and managing a reading list, enhancing user engagement and functionality within the app's broader architecture.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>wishList</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/wishList/WishlistViewModel.kt'>WishlistViewModel.kt</a></b></td>
																						<td>- WishlistViewModel manages the user interface state for the wishlist feature in the Books Explorer app<br>- It interacts with the main application logic to fetch and display a list of favorite books, handling both loading states and potential errors<br>- The ViewModel updates the UI reactively based on changes in the favorite books data.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/wishList/WishlistScreen.kt'>WishlistScreen.kt</a></b></td>
																						<td>- WishlistScreen in the Books Explorer app serves as a user interface component for displaying a user's wishlist of books<br>- It integrates with the app's navigation and state management to show loading indicators, error messages, or a list of books, depending on the current state<br>- The screen allows users to navigate back to previous pages and manage their wishlist effectively.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>home</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/home/HomeUiState.kt'>HomeUiState.kt</a></b></td>
																						<td>- HomeUiState.kt defines the UI state for the home screen of the Books Explorer app, managing the display of book data<br>- It encapsulates whether the data is loading, the list of books retrieved, and any errors encountered during data fetching, ensuring a responsive and informative user interface in the app's home module.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/home/HomeViewModel.kt'>HomeViewModel.kt</a></b></td>
																						<td>- HomeViewModel, part of the Books Explorer's UI layer, manages the home screen's state by loading and displaying a list of books<br>- It interacts with the MainAppDoor to fetch and handle the reading list asynchronously, updating the UI state based on the data received or errors encountered, ensuring a responsive user experience.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/main/java/com/alpha/books_explorer/presentation/ui/home/HomeScreen.kt'>HomeScreen.kt</a></b></td>
																						<td>- HomeScreen.kt serves as the primary user interface within the Books Explorer app, orchestrating the display of the home screen<br>- It integrates navigation controls and dynamic content rendering based on the application state, facilitating user interactions such as searching for books and accessing user profiles, while handling loading states and potential errors effectively.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>androidTest</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<details>
												<summary><b>alpha</b></summary>
												<blockquote>
													<details>
														<summary><b>books_explorer</b></summary>
														<blockquote>
															<table>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/androidTest/java/com/alpha/books_explorer/ExampleInstrumentedTest.kt'>ExampleInstrumentedTest.kt</a></b></td>
																<td>- ExampleInstrumentedTest.kt conducts instrumented tests on an Android device to verify the application context within the Books Explorer app<br>- It ensures the app's package name matches the expected identifier, serving as a basic check that the app under test is correctly installed and running on the device.</td>
															</tr>
															</table>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<details>
												<summary><b>alpha</b></summary>
												<blockquote>
													<details>
														<summary><b>books_explorer</b></summary>
														<blockquote>
															<table>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/MainDispatcherRule.kt'>MainDispatcherRule.kt</a></b></td>
																<td>- MainDispatcherRule, located within the test suite of the Books Explorer application, manages the coroutine dispatchers for unit tests<br>- It sets a specific dispatcher before each test begins and resets it afterward, ensuring that the main dispatcher is properly configured and isolated during test execution, which is crucial for reliable, consistent test results.</td>
															</tr>
															</table>
															<details>
																<summary><b>presenatation</b></summary>
																<blockquote>
																	<details>
																		<summary><b>ui</b></summary>
																		<blockquote>
																			<details>
																				<summary><b>profile</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/presenatation/ui/profile/ProfileViewModelTest.kt'>ProfileViewModelTest.kt</a></b></td>
																						<td>- ProfileViewModelTest.kt conducts unit tests on the ProfileViewModel within the Books Explorer application, ensuring that user profile updates are handled correctly<br>- It verifies the functionality of loading and updating user profiles, specifically testing changes to first and last names and their correct reflection in the system.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>wishlist</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/presenatation/ui/wishlist/WishlistViewModelTest.kt'>WishlistViewModelTest.kt</a></b></td>
																						<td>- WishlistViewModelTest in the demo-app tests the WishlistViewModel's functionality, specifically its ability to load and manage a user's favorite books list<br>- It verifies the UI state transitions and data integrity when fetching books through the FetchFavListUseCase, ensuring the application correctly handles both empty and populated data scenarios.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>search</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/presenatation/ui/search/SearchViewModelTest.kt'>SearchViewModelTest.kt</a></b></td>
																						<td>- SearchViewModelTest in the demo-app's test suite evaluates the functionality of the SearchViewModel, specifically testing the asynchronous retrieval and exposure of book data as paging information<br>- It ensures that the ViewModel correctly interacts with the GetBooksUseCase to fetch and update book search results based on user queries.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>details</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/presenatation/ui/details/BookDetailViewModelTest.kt'>BookDetailViewModelTest.kt</a></b></td>
																						<td>- BookDetailViewModelTest in the demo-app/src/test/java directory validates the functionality of the BookDetailViewModel, ensuring it correctly manages book details, wishlist, and reading list states<br>- It tests state changes upon fetching, adding, and removing books, confirming the integration and behavior of various use cases with the view model.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>home</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/presenatation/ui/home/HomeViewModelTest.kt'>HomeViewModelTest.kt</a></b></td>
																						<td>- HomeViewModelTest in the demo-app's test suite validates the HomeViewModel functionality, specifically focusing on the asynchronous fetching and state management of a reading list<br>- It ensures the UI state accurately reflects loading states and content updates, using mocked instances of FetchReadingListUseCase to simulate real-world data interactions and flow behavior.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
															<details>
																<summary><b>domain</b></summary>
																<blockquote>
																	<details>
																		<summary><b>usecases</b></summary>
																		<blockquote>
																			<table>
																			<tr>
																				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/domain/usecases/GetBooksUseCaseTest.kt'>GetBooksUseCaseTest.kt</a></b></td>
																				<td>- GetBooksUseCaseTest evaluates the functionality of the GetBooksUseCase within the domain layer, ensuring it correctly interacts with the BookRepository to fetch books based on an identifier<br>- It employs mocking techniques to simulate repository responses and verify the use case's behavior under controlled conditions, contributing to the robustness of the application's business logic.</td>
																			</tr>
																			<tr>
																				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/domain/usecases/GetBookByIdUserCaseTest.kt'>GetBookByIdUserCaseTest.kt</a></b></td>
																				<td>- GetBookByIdUserCaseTest evaluates the functionality of retrieving a specific book by its ID within the domain layer of the Books Explorer application<br>- It ensures the GetBookByIdUserCase interacts correctly with the BookRepository to fetch and return book details, using mocked responses to simulate repository behavior during tests.</td>
																			</tr>
																			</table>
																			<details>
																				<summary><b>readingList</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/domain/usecases/readingList/IsBookPresentInReadingListUseCaseTest.kt'>IsBookPresentInReadingListUseCaseTest.kt</a></b></td>
																						<td>- IsBookPresentInReadingListUseCaseTest evaluates the functionality of checking a book's presence in a reading list within the domain layer of the Books Explorer application<br>- It uses a mocked BookRepository to simulate database interactions, ensuring the use case correctly interprets the presence status of books based on repository responses.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/domain/usecases/readingList/AddIntoReadingListUseCaseTest.kt'>AddIntoReadingListUseCaseTest.kt</a></b></td>
																						<td>- AddIntoReadingListUseCaseTest in the demo-app's test suite validates the functionality of adding books to a reading list<br>- It ensures that the AddIntoReadingListUseCase interacts correctly with the BookRepository to store books, using mocked objects to simulate repository behavior and verify the use case execution under controlled conditions.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/domain/usecases/readingList/RemoveFromReadingListUseCaseTest.kt'>RemoveFromReadingListUseCaseTest.kt</a></b></td>
																						<td>- RemoveFromReadingListUseCaseTest evaluates the functionality of removing a book from a user's reading list within the Books Explorer application<br>- It ensures that the associated BookRepository correctly handles the deletion operation, using a mocked environment to simulate repository interactions and verify the use case execution under controlled conditions.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/domain/usecases/readingList/FetchReadingListUseCaseTest.kt'>FetchReadingListUseCaseTest.kt</a></b></td>
																						<td>- FetchReadingListUseCaseTest, located within the demo-app's test suite, validates the functionality of FetchReadingListUseCase, which retrieves a user's reading list from the BookRepository<br>- It ensures that the use case correctly interacts with the repository to fetch and return a list of books, using mock objects and coroutine testing tools to simulate repository behavior.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																			<details>
																				<summary><b>favList</b></summary>
																				<blockquote>
																					<table>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/domain/usecases/favList/IsBookPresentInFavListUserCaseTest.kt'>IsBookPresentInFavListUserCaseTest.kt</a></b></td>
																						<td>- IsBookPresentInFavListUserCaseTest evaluates the functionality of checking a book's presence in a favorite list within the application's domain layer<br>- It sets up a mock environment to simulate interactions with the BookRepository and verifies the behavior of the IsBookPresentInFavListUserCase use case through unit testing.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/domain/usecases/favList/AddIntoFavListUseCaseTest.kt'>AddIntoFavListUseCaseTest.kt</a></b></td>
																						<td>- AddIntoFavListUseCaseTest, located within the demo-app's test suite, validates the functionality of adding books to a favorite list<br>- It ensures that the AddIntoFavListUseCase interacts correctly with the BookRepository to perform this operation, using mocked objects to simulate repository behavior and verify the use case execution under controlled conditions.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/domain/usecases/favList/FetchFavListUseCaseTest.kt'>FetchFavListUseCaseTest.kt</a></b></td>
																						<td>- FetchFavListUseCaseTest evaluates the functionality of FetchFavListUseCase within the domain layer of the Books Explorer application<br>- It verifies the use case's ability to retrieve a favorite list of books from the repository, ensuring the integration and data flow are handled correctly under test conditions.</td>
																					</tr>
																					<tr>
																						<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/demo-app/src/test/java/com/alpha/books_explorer/domain/usecases/favList/RemoveFromFavListUseCaseTest.kt'>RemoveFromFavListUseCaseTest.kt</a></b></td>
																						<td>- RemoveFromFavListUseCaseTest in the demo-app/src/test/java directory is dedicated to verifying the functionality of removing books from a user's favorite list within the application<br>- It tests the interaction with the BookRepository to ensure that the deletion process is handled correctly, using mock objects to simulate repository behavior.</td>
																					</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<details> <!-- gradle Submodule -->
		<summary><b>gradle</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/gradle/libs.versions.toml'>libs.versions.toml</a></b></td>
				<td>- Centralizes and manages the versioning of dependencies across the project, ensuring consistency and ease of updates for libraries, plugins, and toolsets used in development<br>- It streamlines the maintenance and upgrade processes by defining a single source of truth for all component versions within the software architecture.</td>
			</tr>
			</table>
		</blockquote>
	</details>
	<details> <!-- modulesDoor Submodule -->
		<summary><b>modulesDoor</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/build.gradle.kts'>build.gradle.kts</a></b></td>
				<td>- Configures the build environment for the 'modulesDoor' Android library module within the project, specifying dependencies, Android SDK versions, and build options<br>- It integrates essential libraries and tools such as AndroidX, Material Design, Gson, Coroutines, and Dagger-Hilt for dependency injection, ensuring the module is equipped for robust Android development and testing.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/consumer-rules.pro'>consumer-rules.pro</a></b></td>
				<td>- Manages the operational rules for consumer interactions within the door modules, ensuring that user inputs are processed according to predefined protocols<br>- Positioned within the broader system, it plays a critical role in maintaining the integrity and functionality of user interactions, aligning with the project's architectural standards for module communication and data handling.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/proguard-rules.pro'>proguard-rules.pro</a></b></td>
				<td>- ProGuard configuration settings specific to the project are defined in modulesDoor/proguard-rules.pro, guiding the obfuscation and optimization process for Android builds<br>- It includes options to maintain debugging effectiveness, such as preserving line number information and managing JavaScript interface classes within WebViews, enhancing both security and maintainability of the application.</td>
			</tr>
			</table>
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<details>
												<summary><b>alpha</b></summary>
												<blockquote>
													<details>
														<summary><b>modulesDoor</b></summary>
														<blockquote>
															<table>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/src/main/java/com/alpha/modulesDoor/DoorInitializer.kt'>DoorInitializer.kt</a></b></td>
																<td>- DoorInitializer in the modulesDoor component serves as a foundational interface for initializing door-related functionalities within the application<br>- It defines a list of door entries and a setup method, essential for configuring door modules as part of the broader system architecture, ensuring seamless integration and management of door operations across the platform.</td>
															</tr>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/src/main/java/com/alpha/modulesDoor/DoorCommand.kt'>DoorCommand.kt</a></b></td>
																<td>- DoorCommand.kt defines a data class in the modulesDoor component, crucial for handling door-related commands within the system<br>- It encapsulates command details such as the message name and optional payload and door identifiers, facilitating structured communication and processing of door operations across the application's architecture.</td>
															</tr>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/src/main/java/com/alpha/modulesDoor/Door.kt'>Door.kt</a></b></td>
																<td>- Door.kt serves as a central component within the modulesDoor package, responsible for initializing the door management system in the application<br>- It leverages dependency injection to manage singleton instances and orchestrates the setup process through the DoorKernel class, ensuring the door system is ready for use across the application.</td>
															</tr>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/src/main/java/com/alpha/modulesDoor/DoorEntry.kt'>DoorEntry.kt</a></b></td>
																<td>- DoorEntry serves as an abstract base for handling door-related communications within the app, managing message and event types specific to door operations<br>- It facilitates initialization, message reception, and the publishing and subscribing of door commands using a shared flow mechanism, integrating closely with the MessageSender for communication tasks.</td>
															</tr>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/src/main/java/com/alpha/modulesDoor/DoorKernel.kt'>DoorKernel.kt</a></b></td>
																<td>- DoorKernel in the modulesDoor component orchestrates the initialization and event handling for door-related operations<br>- It sets up communication channels, initializes doors with their respective settings, and manages event subscriptions and publications, ensuring that events are correctly registered and handled across different doors within the system.</td>
															</tr>
															</table>
															<details>
																<summary><b>messageSender</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/src/main/java/com/alpha/modulesDoor/messageSender/MessageSender.kt'>MessageSender.kt</a></b></td>
																		<td>- Defines an interface within the `modulesDoor` component of the codebase, responsible for sending door commands<br>- The `MessageSender` interface specifies a method for transmitting `DoorCommand` objects, facilitating communication and control mechanisms across different modules that manage door operations in the system<br>- This setup enhances modularity and interaction within the application architecture.</td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/src/main/java/com/alpha/modulesDoor/messageSender/MessageSenderImpl.kt'>MessageSenderImpl.kt</a></b></td>
																		<td>- MessageSenderImpl in the modulesDoor component manages communication between different door modules by initializing message routing and handling the sending process<br>- It maps messages to specific doors, ensuring that messages are sent to and received by the correct door entities based on predefined configurations<br>- This setup facilitates efficient and accurate message distribution within the system.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
															<details>
																<summary><b>messageTypes</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/src/main/java/com/alpha/modulesDoor/messageTypes/MessageType.kt'>MessageType.kt</a></b></td>
																		<td>- Defines the structure for message types within the door module, specifically for sending and receiving door-related messages<br>- Each message type, whether sending or receiving, includes a message name and a door entry, facilitating clear communication protocols between different components of the door management system in the broader application architecture.</td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/src/main/java/com/alpha/modulesDoor/messageTypes/EventType.kt'>EventType.kt</a></b></td>
																		<td>- Defines event types for door-related actions within the modulesDoor component of the codebase<br>- EventType.kt introduces two main event classes, PublishType and SubscribeType, each encapsulating an event name and a door entry, facilitating event-driven communication and handling in the door management system.</td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>androidTest</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<details>
												<summary><b>alpha</b></summary>
												<blockquote>
													<details>
														<summary><b>myplatformdoor</b></summary>
														<blockquote>
															<table>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/src/androidTest/java/com/alpha/myplatformdoor/ExampleInstrumentedTest.kt'>ExampleInstrumentedTest.kt</a></b></td>
																<td>- ExampleInstrumentedTest in the modulesDoor/src/androidTest directory conducts instrumented tests on Android devices to verify the application context<br>- Specifically, it checks that the application's package name matches the expected value, ensuring the app's environment is correctly configured for further testing and development within the project's architecture.</td>
															</tr>
															</table>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<details>
												<summary><b>alpha</b></summary>
												<blockquote>
													<details>
														<summary><b>myplatformdoor</b></summary>
														<blockquote>
															<table>
															<tr>
																<td><b><a href='https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/blob/master/modulesDoor/src/test/java/com/alpha/myplatformdoor/ExampleUnitTest.kt'>ExampleUnitTest.kt</a></b></td>
																<td>- ExampleUnitTest.kt in the modulesDoor/src/test/java/com/alpha/myplatformdoor directory serves as a local unit test for the MyPlatformDoor module, verifying basic arithmetic operations directly on the developer's machine<br>- It ensures that foundational functionalities within the module perform as expected, supporting the module's reliability in the broader application architecture.</td>
															</tr>
															</table>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

---
## 🚀 Getting Started

### ☑️ Prerequisites

Before getting started with Modules-Door-Lib, ensure your runtime environment meets the following requirements:

- **Programming Language:** Kotlin
- **Package Manager:** Gradle


### ⚙️ Installation

Install Modules-Door-Lib using one of the following methods:

**Build from source:**

1. Clone the Modules-Door-Lib repository:
```sh
❯ git clone https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/
```

2. Navigate to the project directory:
```sh
❯ cd Modules-Door-Lib
```

3. Install the project dependencies:


**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle build
```




### 🤖 Usage
Run Modules-Door-Lib using the following command:
**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle run
```


### 🧪 Testing
Run the test suite using the following command:
**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle test
```


---
## 📌 Project Roadmap

- [X] **`Task 1`**: <strike>Implement feature one.</strike>
- [ ] **`Task 2`**: Implement feature two.
- [ ] **`Task 3`**: Implement feature three.

---

## 🔰 Contributing

- **💬 [Join the Discussions](https://github.com/shubham-gadekar-alpha/Modules-Door-Lib/discussions)**: Share your insights, provide feedback, or ask questions.
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

## 🎗 License

This project is protected under the [SELECT-A-LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

## 🙌 Acknowledgments

- List any resources, contributors, inspiration, etc. here.

---
