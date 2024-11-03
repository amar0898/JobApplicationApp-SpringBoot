# Job Application App - Spring Boot Microservices 🚀
Welcome to the Job Application App – a Spring Boot-based project, initially built as a monolithic application, then refactored into microservices for enhanced scalability and modularity. This repository demonstrates the complete transition from a monolithic architecture to a microservices architecture, integrated with a variety of modern tools and frameworks.

## 🌟 Project Overview
This Job Application App consists of three core microservices:

#### 1. Job Service - Manages job-related data and functionalities.
#### 2. Company Service - Manages company information and related operations.
#### 3. Review Service - Handles reviews for jobs and companies.

## 🔑 Key Features
#### Transition from Monolithic to Microservices Architecture 📦
#### Databases:
#####  · H2 for in-memory storage in development ⚙️
#####  · PostgreSQL for persistent data storage in production 🗄️
#####  · Message Queue Integration with RabbitMQ 📬
#####  · Distributed Tracing using Zipkin 🕵️‍♂️
#####  · Docker and Kubernetes Deployment 🐳

## 🛠 Tech Stack
 • Backend: Spring Boot, Java 17
 • Databases: H2 (Dev), PostgreSQL (Prod)
 • Message Queue: RabbitMQ
 • Tracing: Zipkin
 • Containerization: Docker, Docker Compose
 • Orchestration: Kubernetes

## ⚙️ Setup and Deployment
#### Prerequisites
 • Java 17 or higher
 • Docker installed
 • Kubernetes installed (e.g., Minikube or any Kubernetes cluster)

### Running the Application Locally

#### 1. Clone the repository:
git clone https://github.com/amar0898/JobApplicationApp-SpringBoot.git
cd JobApplicationApp-SpringBoot

#### 2. Docker Deployment:
Run the application with Docker Compose:
docker-compose up --build

#### 3. Kubernetes Deployment:
Deploy to a Kubernetes cluster using the configurations in /k8s:
kubectl apply -f k8s/

#### 4. Accessing the Services:
The services will be accessible at the respective endpoints defined in the /k8s or Docker Compose configuration.
Run below commands in kubernetes shell:
- minikube service job --url
- minikube service company --url
- minikube service review --url
- minikube service postgres --url
- minikube service rabbitmq  --url
- minikube service zipkin --url

## 🏛️ Microservices Architecture
Each microservice in this project is modular, with its own REST API:

• Job Service: Handles job listings and operations (/jobs).
• Company Service: Manages company data (/companies).
• Review Service: Deals with user reviews (/reviews).

Services communicate asynchronously through RabbitMQ, enhancing reliability and loose coupling. Distributed tracing is managed by Zipkin, providing insights into request flows and performance bottlenecks.

## 🔗 API Endpoints
Here are some key API endpoints for each service:

### 1. Job Service:

• GET /jobs - Retrieve all job postings
• POST /jobs - Create a new job entry
• DELETE /jobs - Delete a specefic job
• PUT /jobs - Update a specefic job

### 2. Company Service:

• GET /companies - Get a list of companies
• POST /companies - Add a new company
• DELETE /companies - Delete a specefic company
• PUT /companies - Update a specefic company

### 3. Review Service:

• GET /reviews - List all reviews
• POST /reviews - Submit a review for a job or company
• DELETE /reviews - Delete a specefic review
• PUT /reviews - Update a specefic review

## 🕵️ Observability
With Zipkin integrated, distributed tracing allows for monitoring of request flows across services. This helps in identifying latency issues, optimizing performance, and troubleshooting.

## 🔮 Future Enhancements
• CI/CD Pipeline: Integrate a CI/CD pipeline to automate testing and deployment. 🛠️
• Enhanced Security: Add authentication and authorization mechanisms. 🔐
• Monitoring and Metrics: Integrate Prometheus and Grafana for advanced monitoring. 📊

Feel free to reach out if you have any questions or suggestions! 😊
