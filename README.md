# Spring Tracing Demo

## Overview

**Spring Tracing Demo** is a proof-of-concept project that demonstrates **distributed tracing and logging** in a Spring Boot application. It integrates with **Loki, Promtail, Tempo, and Grafana** for efficient log aggregation, monitoring, and distributed tracing.

### Features

- **Distributed Tracing** using OpenTelemetry & Tempo.
- **Centralized Logging** with Loki and Promtail.
- **Visualization & Monitoring** using Grafana.
- **Containerized Deployment** with Docker & Docker Compose.
- **Spring Boot Integration** for seamless logging and tracing.

---

## 🛠️ Tech Stack

The project uses the following technologies:

- **Spring Boot** – Backend framework for microservices.
- **OpenTelemetry** – Collects traces for distributed systems.
- **Loki** – Log aggregation system.
- **Promtail** – Log collector for forwarding logs to Loki.
- **Tempo** – Distributed tracing backend.
- **Grafana** – Visualization & monitoring dashboard.
- **Docker & Docker Compose** – Containerized deployment.

---

## 🔧 Prerequisites

Before running the application, ensure you have installed:

- **Java 17+**
- **Maven 3+**
- **Docker & Docker Compose**
- **Grafana (optional for visualization)**

---

## 🚀 Installation & Setup

### 1️⃣ Clone the Repository

First, clone the project to your local machine:

```sh
git clone https://github.com/MazenAbonokta/spring-tracing-demo.git
cd spring-tracing-demo
```

### 2️⃣ Build the Project

Run the following command to build the project:

```sh
mvn clean install
```

### 3️⃣ Run the Application

You can run the Spring Boot application using:

```sh
mvn spring-boot:run
```

### 4️⃣ Run the Application with Docker

To **build and run** all services using Docker, execute:

```sh
docker/docker-compose up --build -d
```

This will:
- **Build the Spring Boot application** and containerize it.
- **Start all services**, including:
  - **Spring Boot application** on `http://localhost:8089`
  - **Grafana** on `http://localhost:3000` (Default credentials: `admin/admin`)
  - **Prometheus** on `http://localhost:9090`
  - **Loki** on `http://localhost:3100`
  - **Tempo** on `http://localhost:3200`

### 🛑 Stop the Stack

To stop and remove the running containers, run:

```sh
docker/docker-compose down
```

---

## ⚙️ Configuration & Deployment

The **docker/docker-compose.yml** file is used to deploy the full observability stack, including:
- **Spring Boot Application** (`spring-tracing-demo`)
- **Loki** (for log aggregation)
- **Promtail** (to collect logs and forward to Loki)
- **Tempo** (for distributed tracing)
- **Prometheus** (for metrics collection)
- **Grafana** (for visualization)

#### 📄 **docker/docker-compose.yml**

See the `docker/docker-compose.yml` file for the complete configuration.

---

## 📂 Observability Configuration Files

The following configuration files are located in `docker/observability/`:

### 🔧 **Loki Configuration (`loki-config.yml`)**
Defines how logs are stored and queried in Loki.

### 🔧 **Prometheus Configuration (`prometheus.yml`)**
Defines Prometheus scraping jobs and metrics collection settings.

### 🔧 **Promtail Configuration (`promtail-config.yml`)**
Configures Promtail to collect logs and send them to Loki.

### 🔧 **Tempo Configuration (`tempo.yml`)**
Configures Tempo for distributed tracing.

These configuration files ensure proper integration and observability of logs and traces.

---

## 🔗 API Endpoints

| HTTP Method | Endpoint               | Description                                   |
|------------|------------------------|-----------------------------------------------|
| GET        | `/api/test`             | Generates a new UUID, logs it, and returns it. |
| POST       | `/api/data`             | Accepts a JSON payload and returns a response message. |

### 🔍 Testing API with cURL

#### 🟢 **GET `/api/test`**
Fetch a test response with a new UUID:

```sh
curl -X GET http://localhost:8089/api/test
```

**Response Example:**
```json
"Test [123e4567-e89b-12d3-a456-426614174000]"
```

---

#### 🟢 **POST `/api/data`**
Send a JSON request containing a message:

```sh
curl -X POST http://localhost:8089/api/data \
     -H "Content-Type: application/json" \
     -d '{"message": "Hello, tracing!"}'
```

**Request Body:**
```json
{
  "message": "Hello, tracing!"
}
```

**Response Example:**
```json
"Received: Hello, tracing!"
```


