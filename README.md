# GameFlix Application

A Spring Boot backend for the GameFlix platform/

## How to Build and Run with Docker

### Build the image:
```bash
docker-compose up --build
```

## Workflow Process

Workflow actions automatically execute upon push or pull request. Contains steps to:
- Checkout repository
- Setup JDK 17
- Install MySQL Client
- Wait for MySQL
- Build with Maven
- Build Docker Image

