# CodeBench Server
![image](https://github.com/user-attachments/assets/84c4531b-2c54-4b2e-a94e-cc1b4d514de8)

The **CodeBench Server** is the entry point of the CodeBench system.  
It accepts user-submitted source code via a REST API, pushes each submission to a Kafka topic for processing, and returns a unique ID for tracking the submission status.  
It also provides an API to query the status or result of a previously submitted code by its ID.

---

## 📌 Features

- **Submit Code:** Accepts source code submissions over a `POST` API.
- **Queue with Kafka:** Publishes submissions to a Kafka topic for asynchronous processing.
- **Query Status:** Provides a `GET` API to fetch the status or result of submitted code.
- **ID Generation:** Generates and returns a unique ID for each submission.


## 🚀 How to Run?
1. git clone https://github.com/Krauserkane/CodeBench-Server.git
2. cd CodeBench
3. docker-compose up --build
