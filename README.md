# 📝 TaskList API Documentation

This document outlines the setup, authentication, and available endpoints for the TaskList API.

## 🛠️ Setup

### **1. Environment File**

Create a file named **`.env`** in the root directory and add your secret key:


SECRET_KEY=YOUR_SECRET_KEY


## 🔐 Authentication Flow

### **Step 1: User Registration (Sign Up)**

* **Action:** Register a new user.
* **Request Body:** An object containing `name`, `email`, and `password`.

### **Step 2: User Login**

* **Action:** Log in with the registered credentials.
* **Request Body:** An object containing the user's `email` and `password`.
* **Response:** A **JWT Token** will be generated and returned in the response body.

### **Step 3: Using the Token**

For **all** subsequent tasklist endpoint requests, you must include the generated **JWT Token** in the `Authorization` header using the **Bearer Token** scheme:

* **Header:** `Authorization: Token <YOUR_JWT_TOKEN>`

## 🌐 Endpoints

| Method | Endpoint | Description | Request Body            |
| :--- | :--- | :--- |:------------------------|
| **GET** | `/tasklist/task` | Retrieve all tasks for the authenticated user. | **None**                |
| **POST** | `/tasklist/task` | Create a new task. | **Task object**         |
| **GET** | `/tasklist/task/id` | Retrieve a specific task by its ID. | **None**                |
| **PUT** | `/tasklist/task/id` | Completely update a specific task by its ID. | **Updated Task object** |
| **DELETE** | `/tasklist/task/id` | Delete a specific task by its ID. | **None**                |
| **PATCH** | `/tasklist/task/id` | Partially update the status or other fields of a task by its ID. | **None**                |

*Note: Replace `id` in the endpoint path with the actual ID of the task.*