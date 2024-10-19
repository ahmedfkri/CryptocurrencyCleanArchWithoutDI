
# Cryptocurrency Clean Architecture (Without Dependency Injection)

Welcome to the **Cryptocurrency Clean Architecture** project, a simple yet structured cryptocurrency application developed using Clean Architecture principles without relying on Dependency Injection (DI). This repository showcases a modular and scalable way to organize your code in Android applications while adhering to Clean Architecture best practices.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture Overview](#architecture-overview)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The goal of this project is to demonstrate how to build an Android app using the **Clean Architecture** approach without relying on external libraries for dependency injection. This structure helps in creating a modular and maintainable codebase by separating concerns across different layers.

## Features

- Cryptocurrency listing with real-time updates.
- Follows Clean Architecture guidelines.
- Designed without using DI frameworks like Dagger or Hilt.
- Repository pattern for data management.
- Modularized codebase for easy maintenance and testing.

## Technologies Used

- **Kotlin** - Programming language for Android development.
- **Coroutines** - For managing asynchronous tasks.
- **Retrofit** - For API requests.
- **ViewModel** - To handle UI-related data in a lifecycle-conscious way.
- **LiveData** - To observe data changes and update UI.
- **Room** - To handle local data storage.
- **Clean Architecture** - For separation of concerns and modularity.

## Architecture Overview

This project follows the **Clean Architecture** pattern, which divides the codebase into multiple layers:

1. **Presentation Layer**: 
   - This layer contains the `ViewModels` and `UI` components.
   - UI components observe `LiveData` from `ViewModels` and react to data changes.

2. **Domain Layer**: 
   - Contains business logic, represented by `UseCases`.
   - This layer is independent of external libraries and frameworks.

3. **Data Layer**: 
   - Manages data sources like APIs and local databases.
   - Repository classes abstract data operations.

The absence of Dependency Injection libraries forces manual handling of object creation and dependencies, ensuring a deeper understanding of how DI works behind the scenes.

## Installation

To run the project locally:

1. Clone this repository:
   ```bash
   git clone https://github.com/ahmedfkri/CryptocurrencyCleanArchWithoutDI.git
   ```
2. Open the project in Android Studio.
3. Sync the project with Gradle files.
4. Run the app on an emulator or physical device.

## Usage

- Once installed, the app will fetch and display a list of cryptocurrencies.
- Users can view real-time data for each cryptocurrency.

## Contributing

Contributions are welcome! If you have any ideas, suggestions, or improvements, feel free to create a pull request or open an issue.

1. Fork the project.
2. Create a new branch for your feature:
   ```bash
   git checkout -b feature-branch
   ```
3. Make your modifications and commit changes:
   ```bash
   git commit -m "Added new feature"
   ```
4. Push to your branch:
   ```bash
   git push origin feature-branch
   ```
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for more details.
