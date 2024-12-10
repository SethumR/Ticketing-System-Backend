# Real-Time Ticket Simulation Backend

This repository contains the backend for the Real-Time Ticket Simulation System, built with Spring Boot. The backend listens for requests from the frontend, processes 
the ticket simulation logic in real-time, and sends updates to the frontend for display. The user inputs are saved in a .json file for persistence.

---

## 🚀 Introduction

The Real-Time Ticket Simulation System backend handles the processing of ticket simulation based on user input received from the frontend. It takes configuration values 
(such as ticket release rate, customer retrieval rate, etc.) and runs the simulation in the terminal, passing real-time updates back to the frontend. This system allows 
the frontend to display the current ticket array size, with configuration data saved as a .json file for future use.

---

## ⚙️ Setup Instructions

### Prerequisites

Before running the application, ensure you have the following installed:

- Java 17 (or higher)
- Maven (for dependency management and project build)
- Spring Boot (the application is already built with Spring Boot)

---

### Steps to Build and Run the Application

#### 1. Clone the Repository

```bash
git clone https://github.com/SethumR/Ticketing-System-Backend.git
cd Ticketing-System-Backend
```

#### 2. Build the project using Maven:

```bash
mvn clean install
```

### 3. Run the Spring Boot application:

```bash
mvn spring-boot:run
```

### 4. The backend will be available at http://localhost:8080.

---

## Usage Instructions

### Configuring and Starting the System

- The frontend will send a POST request to the backend with the configuration values entered by the user.
- The backend receives these values, processes the ticket simulation in real time, and outputs logs to the terminal.
- The backend sends real-time updates back to the frontend via WebSocket, which are then displayed to the user.

### Saving Configuration 

- The configuration values entered by the user are saved to a .json file on the server for persistence, allowing users to load previous configurations

### API Endpoints

- POST /start-simulation: Starts the ticket simulation with the user-provided configuration.
- GET /load-configuration: Loads the most recent configuration from the .json file.
- WebSocket: Real-time updates about the ticket array size are pushed to the frontend.

--- 

## 💻 System Architecture

### Frontend: React.js and Tailwind CSS
- Handles user inputs and displays real-time updates.
### Backend: Spring Boot
- Handles simulation logic and WebSocket communication.
### Real-Time Communication: WebSocket for sending updates to the frontend.
### Data Persistence: The configuration is stored in a .json file.

---

## 🌟 Features

- Real-Time Ticket Simulation: Simulates ticket processing and sends updates to the frontend.
- Configuration Persistence: Saves user configurations in a .json file.
- WebSocket Communication: Pushes real-time updates to the frontend.

---

## ☎️ Contact
- Name : Sethum Ruberu
- Email : Sethumgelaka6@gmail.com


