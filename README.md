# NewMonster Jobs

## Language and Framework
![Java](https://img.shields.io/badge/Language-Java-green)
![Spring Boot](https://img.shields.io/badge/Framework-Spring%20Boot-brightgreen)

## Description
Welcome to the NewMonster Jobs application! This open-source project is a Java-based application built using the Spring Boot framework. The NewMonster Jobs application allows you to manage job listings through a set of APIs. With these APIs, you can perform various operations such as adding jobs, retrieving jobs by different criteria, updating job information, and more.

## Entity
The core entity in this application is the "Job" class. It includes the following properties:

- **id (Long):** Unique identifier for each job.
- **title (String):** Job title.
- **description (String):** Job description.
- **location (String):** Job location.
- **salary (Double):** Job salary (minimum 200,000).
- **companyEmail (String):** Email address of the hiring company (validated with a regular expression).
- **companyName (String):** Name of the hiring company.
- **employerName (String):** Name of the employer.
- **jobTypes (Enum):** Type of job (e.g., IT, HR, Sales, Marketing, Finance).
- **postDate (Date):** Date when the job was applied.

## Repository
The "IJobRepo" interface extends the "CrudRepository" and provides custom query methods for interacting with the H2 database. It includes queries such as:

- **findByJobTypes(JobTypes type):** Retrieve jobs by job type.
- **findBySalaryGreaterThanEqualOrderBySalaryDesc(Double salary):** Retrieve jobs with salaries greater than or equal to a specified value, sorted by salary in descending order.
- **findByJobTypesAndSalaryGreaterThanEqualOrderBySalaryDesc(JobTypes type, Double salary):** Retrieve jobs by job type and with salaries greater than or equal to a specified value, sorted by salary in descending order.

## Controller
The "JobCurdAPI" class serves as the API controller for the NewMonster Jobs application. It provides various endpoints for managing job listings, including:

- **POST /job:** Add a new job by providing job details in the request body.
- **GET /jobs:** Retrieve a list of all jobs.
- **GET /job/id/{id}:** Retrieve job information by job ID.
- **GET /jobs/type/{type}:** Filter jobs by job type.
- **GET /jobs/salary/{salary}:** Filter jobs by minimum salary.
- **GET /jobs/type/salary:** Filter jobs by job type and minimum salary.
- **PUT /jobs/type/hike:** Increase job salaries for a specific job type. Provide jobType and hike as request parameters.
- **PUT /job/id:** Update job details by providing the job ID and optional parameters for title, description, location, salary, companyEmail, companyName, employerName, jobTypes, and appliedDate.
- **DELETE /job/id:** Delete the Job record for corresponding ID
- **DELETE job/date/{date}:** Delete all the Jobs which has been posted before given date




## Database Schema
The database schema for the "Job" entity is as follows:

- **Job (Table):**
  - id (integer, primary key)
  - title (string)
  - description (string)
  - location (string)
  - salary (double)
  - companyEmail (string)
  - companyName (string)
  - employerName (string)
  - jobTypes (enum)
  - postDate (date)

## Getting Started
To start using the NewMonster Jobs application, follow the installation steps below.

## Prerequisites
Make sure you have the following prerequisites installed on your system:

- Java Development Kit (JDK)
- Maven
- Spring Boot Dependencies

## Installation
1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/your-username/newmonster-jobs.git
   
2. Navigate to the project directory

    ```bash
    cd newmonster-jobs

  
## Usage
You can use the NewMonster Jobs application by making HTTP requests to the provided API endpoints using your preferred API testing tool or framework.

## Swagger UI
For a more interactive experience and to explore the available APIs, you can use the Swagger UI at http://localhost:8080/swagger-ui/index.html when running the application on your local system.

Enjoy using NewMonster Jobs to efficiently manage job listings!

