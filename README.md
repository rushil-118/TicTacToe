# TicTacToe (Java)

A simple Java-based Tic Tac Toe game project, structured and prepared for a professional CI/CD pipeline with testing, quality checks, containerization, and security scanning.

---

## 📦 Project Overview

This is a Java Tic Tac Toe game (console-based) built using Maven.  
The project is intentionally structured to demonstrate:

- Clean build process
- Unit testing
- Code quality checks
- Docker containerization
- CI/CD readiness

---

## 🛠️ Tech Stack

- Java 17+
- Maven
- JUnit 5 (for testing)
- Docker

---

## 📁 Project Structure

```
TicTacToe/
 ├── src/
 │   ├── main/java/...
 │   └── test/java/...
 ├── Dockerfile
 ├── pom.xml
 ├── README.md
 └── .gitignore
```

---

## 🚀 How to Build

Make sure you have Java and Maven installed.

```bash
mvn clean package
```

---

## 🧪 How to Run Tests

```bash
mvn test
```

---

## ▶️ How to Run the Application

After building:

```bash
java -jar target/*.jar
```

---

## 🐳 How to Run with Docker

### Build Docker image:

```bash
docker build -t tictactoe .
```

### Run container:

```bash
docker run tictactoe
```

---

## 🤖 CI/CD

This project is designed to be used with a CI/CD pipeline that includes:

- Build & Test
- Linting / Code Quality
- Security Scanning
- Docker Image Build
- Container Scanning
- Image Publishing
- Deployment

---
