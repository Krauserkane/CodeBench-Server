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


---

## 📌 Example Usage

### 1️⃣ Submit Code

```bash
curl --location 'http://localhost:8080/submit' \
--header 'Content-Type: application/json' \
--data '{
    "language": "Python",
    "code": "print(\"Hello, World!\")",
    "testCases": [
        {
            "input": "",
            "output": "Hello, World!\n",
            "testCaseId": "1"
        },
        {
            "input": "",
            "output": "Hello, World!\n",
            "testCaseId": "2"
        }
    ]
}
'
```

Response

``` bash
{
  "submissionId": "abc123"
}
```

---
### 2️⃣ Get the Status of the Submission

``` bash
curl --location 'http://localhost:8080/getStatus?submissionId=3585b450-faf5-432f-81d8-10faaf88bb82'
```

Response

```bash
[
    {
        "submissionId": {
            "submissionId": "8c5f4f28-76ed-49e9-bd2f-b4909c12b754",
            "testCaseId": 1
        },
        "input": "",
        "output": "Hello, World!\n",
        "stdout": "Hello, World!\n",
        "stderr": "OK (0.059 sec real, 0.175 sec wall)\n",
        "timeTaken": 0.175,
        "memoryTaken": 9508
    },
    {
        "submissionId": {
            "submissionId": "8c5f4f28-76ed-49e9-bd2f-b4909c12b754",
            "testCaseId": 2
        },
        "input": "",
        "output": "Hello, World!\n",
        "stdout": "Hello, World!\n",
        "stderr": "OK (0.022 sec real, 0.022 sec wall)\n",
        "timeTaken": 0.022,
        "memoryTaken": 9536
    }
]
```
