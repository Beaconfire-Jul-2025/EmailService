# 📧 Email Service

This is a Spring Boot-based microservice responsible for sending emails in the HR & Employee Onboarding system. It is designed to receive messages via RabbitMQ and send email notifications using an SMTP provider (default is Gmail).

---

## 🚀 How to Run

### 🔧 Prerequisites

- Java 8
- Maven
- RabbitMQ running locally or accessible remotely
- A Gmail account (with an [App Password](https://myaccount.google.com/apppasswords)) or other SMTP credentials

### ✅ Required Environment Variables

Before running the application, set the following environment variables:

| Variable        | Description                               |
|----------------|-------------------------------------------|
| `MAIL_USERNAME`| Your email address (e.g. `you@gmail.com`) |
| `MAIL_PASSWORD`| Your password (app password for Gmail)    |
| `MAIL_HOST`    | Mail server host (e.g. `smtp.gmail.com`)  |
| `MAIL_PORT`    | Mail server port (e.g. `587` for TLS)     |

> **Note:** If using Gmail, make sure you [enable App Passwords](https://myaccount.google.com/apppasswords) instead of your regular password.

---

### 🧪 Run with Maven

```bash
export MAIL_USERNAME=your_email@gmail.com
export MAIL_PASSWORD=your_app_password
export MAIL_HOST=smtp.gmail.com
export MAIL_PORT=587

./mvnw spring-boot:run
````

---

### 🐳 Run with Docker

This service includes a `Dockerfile`. You can build and run it using:

```bash
# Build the image
docker build -t email-service .

# Run the container
docker run -d \
  -e MAIL_USERNAME=your_email@gmail.com \
  -e MAIL_PASSWORD=your_app_password \
  -e MAIL_HOST=smtp.gmail.com \
  -e MAIL_PORT=587 \
  -p 8085:8085 \
  email-service
```

The service will be accessible at: `http://localhost:8085`

---

## 📬 RabbitMQ Configuration

This service listens to RabbitMQ messages to trigger email sending.

* **Exchange Name:** `emailExchange`
* **Queue Name:** `emailQueue`
* **Exchange Type:** `direct`

You must ensure that RabbitMQ is running and the appropriate exchange and queue are created. The service will attempt to create these automatically on startup if they don’t exist.

## ✅ Example Use Case

Send a message to RabbitMQ with a payload similar to:

```json
{
  "to": "recipient@example.com",
  "subject": "Welcome!",
  "body": "Thank you for joining us!"
}
```

The service will consume this message and send an email using the configured SMTP provider.