```

# **Senior Android IVI Project: NexusStream**

## **🎯 Project Goal**

This project is an implementation of a modern In-Vehicle Infotainment (IVI) dashboard application designed for high-performance, real-time data streaming. It demonstrates expertise in modern Android development best practices, Clean Architecture, Jetpack Compose, and Kotlin Coroutines/Flow, specifically tailored to the requirements of high-frequency vehicle telemetry data (e.g., speed, RPM, Pilot Assist status).

## **🏗️ Architecture: Clean Architecture (MVVM/MVI Principles)**

##### The application follows a strict **Clean Architecture** pattern, ensuring strict separation of concerns, high testability, and maintainability.The code is organized into three primary layers, ensuring **dependencies only flow inwards** (Presentation depends on Domain, Data depends on Domain, but Domain knows nothing about the others).

### **1. ⚙️ Domain Layer (The Rules)**

##### The innermost layer. This is pure Kotlin code and contains the core business logic of the application. It is the most stable part of the architecture and should never depend on Android frameworks or database/network implementations.


| **Sub-Package**     | **Content**                                       | **Rationale**                                                                                                             |
| ------------------- | ------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- |
| `domain/model`      | **Entities** (`VehicleState, PilotAssistStatus`). | The core data structures used universally across all layers.                                                              |
| `domain/repository` | **Repository Interfaces** (`VehicleRepository`).  | Contracts that define*what* the Data Layer must do (e.g., `getVehicleStateStream()`).                                     |
| `domain/usecase`    | **Use Cases** (`ObserveVehicleStateUseCase`).     | Encapsulate and orchestrate specific business logic tasks, acting as the bridge between the Presentation and Data layers. |

### **2. 💾 Data Layer (The Implementation)**

##### This layer is responsible for implementing the contracts defined in the Domain Layer. It handles data sources (local database, remote API, or, in our case, the simulated IVI stream).


| **Sub-Package**   | **Content**                                               | **Rationale**                                                                                                                                |
| ----------------- | --------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| `data/local`      | Future location for Room/DataStore implementations.       | Handles persistence of user settings or cached data.                                                                                         |
| `data/remote`     | Future location for Retrofit service interfaces and DTOs. | Handles external API communication (e.g., cloud configuration).                                                                              |
| `data/repository` | **Repository Implementations.**                           | Classes that implement the`VehicleRepository` interface, translating raw data into the Domain Entities. (e.g., `MockVehicleRepositoryImpl`). |
| `data/di`         | **Hilt Modules** for Data Layer providers.                | This package, created in the Data implementation phase, handles injecting the concrete Repository classes.                                   |

### **3. 🖥️ Presentation Layer (The View)**

##### The outermost layer. This layer is entirely responsible for displaying the data and handling user interaction. It depends on the Domain Layer (Use Cases) to fetch data but knows nothing about _where_ the data comes from (network, database, etc.)


| **Sub-Package**           | **Content**           | **Rationale**                                                                            |
| ------------------------- | --------------------- | ---------------------------------------------------------------------------------------- |
| `presentation/viewmodel`  | **State holders.**    | ViewModels that observe Use Cases, transform data into UI state, and handle user events. |
| `presentation/screens`    | **Composables (UI).** | The actual Jetpack Compose functions that render the UI based on the ViewModel state.    |
| `presentation/navigation` | **Navigation graph.** | Defines the flow between different screens of the application.                           |

## **🛠️ Technology Stack (Current)**

# - **Language:** Kotlin (2.2.21+)

- **Architecture:** Clean Architecture (TDA structure)
- **UI:** Jetpack Compose
- **DI:** Hilt (Dagger)
- **Concurrency:** Kotlin Coroutines & Flow
- **Build:** Gradle Kotlin DSL (KTS) with Version Catalogs

## **✅ Progress Checkpoint (P1 Complete)**


| **Component**        | **Status**      | **Notes**                                                                                     |
| -------------------- | --------------- | --------------------------------------------------------------------------------------------- |
| **Gradle Setup**     | COMPLETE        | Clean, warning-free build using KTS, Version Catalogs, Hilt, and KSP (Kotlin 2.0+ compliant). |
| **Hilt Application** | COMPLETE        | Application class created and Hilt setup finalized.                                           |
| **Architecture**     | FOLDERS CREATED | Tiered Directory Architecture (TDA) folders for Domain, Data, and Presentation are in place.  |
