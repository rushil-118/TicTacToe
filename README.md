# 🎮 TicTacToe — DevSecOps CI/CD with Kubernetes

A Java-based TicTacToe application engineered with a **production-style DevSecOps CI/CD pipeline** using **GitHub Actions, Docker, Security Scanning, and Kubernetes (KIND)**.

This project demonstrates **real-world CI/CD practices** including:

- Automated build, test, and quality checks
- Static code analysis (SAST) using CodeQL
- Container vulnerability scanning using Trivy
- Docker image build and publishing to DockerHub
- Automated deployment to Kubernetes using GitHub Actions (CD)
- Server-mode execution for long-running Kubernetes workloads

---

## 📌 Project Objectives

- Demonstrate **end-to-end DevSecOps automation**
- Enforce **quality gates** before deployment
- Use **immutable container artifacts**
- Perform **automated Kubernetes deployment**

---

## 🏗️ Architecture Overview

```
Developer Push
      ↓
CI Pipeline (GitHub Actions)
 - Build (Maven)
 - Test (JUnit)
 - Lint (Checkstyle)
 - SAST (CodeQL)
 - Docker Build
 - Container Scan (Trivy)
 - Smoke Test
 - Push to DockerHub
      ↓
CD Pipeline (GitHub Actions)
 - Create KIND cluster
 - Deploy to Kubernetes
 - Verify Pods & Logs
```

---

## 🧰 Tech Stack

- Java 17
- Maven
- JUnit 5
- Docker
- GitHub Actions
- Kubernetes (KIND)
- Trivy
- CodeQL

---

## 📁 Project Structure

```
TicTacToe/
 ├── src/
 │   ├── main/java/...
 │   └── test/java/...
 ├── k8s/
 │   └── deployment.yml
 ├── .github/workflows/
 │   ├── ci.yml
 │   └── cd.yml
 ├── Dockerfile
 ├── pom.xml
 └── README.md
```

---

## ▶️ Running the Application

### Normal CLI mode:

```bash
java -jar target/TicTacToe-1.0-SNAPSHOT.jar
```

### Server mode (for Kubernetes):

```bash
java -jar target/TicTacToe-1.0-SNAPSHOT.jar --server
```

---

## 🐳 Docker

### Build Image:

```bash
docker build -t rushil118/tictactoe:latest .
```

### Run Container:

```bash
docker run rushil118/tictactoe:latest
```

---

## ☸️ Kubernetes Deployment (Local)

This project uses **KIND (Kubernetes in Docker)** for deployment.

### Create cluster:

```bash
kind create cluster --name devops-cluster
```

### Deploy:

```bash
kubectl apply -f k8s/deployment.yml
```

### Check:

```bash
kubectl get pods
kubectl logs <pod-name>
```

---

## 🤖 CI/CD Pipelines

### CI Pipeline

Runs on every push and performs:

- Maven build & tests
- Code quality checks
- CodeQL security scan (SAST)
- Docker image build
- Trivy container vulnerability scan
- Container smoke test
- Push to DockerHub

### CD Pipeline

- Runs only after CI succeeds
- Creates a temporary Kubernetes cluster using KIND
- Deploys the application
- Verifies pod status and logs

---

## 🔐 DevSecOps & Security

| Layer | Tool | Purpose |
|------|------|---------|
Code Quality | Checkstyle | Enforce coding standards |
SAST | CodeQL | Static security analysis |
Container Scan | Trivy | Detect OS & library vulnerabilities |
Testing | JUnit | Prevent regressions |

---

## 📦 Docker Image

Published to:

```
rushil118/tictactoe:latest
```

---

## 🏆 Key DevOps Concepts Demonstrated

- CI/CD separation
- Shift-left security
- Quality gates
- Immutable artifacts
- Kubernetes deployment

---

## 📈 Future Improvements

- Cloud Kubernetes deployment (EKS/GKE/AKS)
- DAST integration

