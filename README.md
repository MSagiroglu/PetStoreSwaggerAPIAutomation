# Pet Store Swagger API Automation with Java & Rest Assured & Maven & TestNG

---
## Project Description
This project is designed to perform various automation tests on Petstore APIs. It includes both positive and negative test scenarios to ensure the API endpoints are working correctly. The test scenarios are implemented using TestNG and Rest-Assured.

## Project Structure
The project structure is as follows:
```
src
├── main
│   ├── java
│   │   ├── base_url
│   │   │   └── PetStoreApiBaseUrl.java
│   │   ├── pojos
│   │   │   ├── petPojos
│   │   │   │   ├── positivePetPojo
│   │   │   │   │   ├── CategoryPojo.java
│   │   │   │   │   ├── PetPojo.java
│   │   │   │   │   ├── TagsPojo.java
│   │   │   │   ├── negativePetPojos
│   │   │   │   │   ├── NegativeCategoryPojo.java
│   │   │   │   │   ├── NegativePetPojo.java
│   │   │   │   │   ├── NegativeTagsPojo.java
│   │   │   │   │   └── negativePostResponsePojo
│   │   │   │   │       └── NegativeResponsePetPojo.java
│   │   │   ├── storePojos
│   │   │   │   ├── InventoryPojo.java
│   │   │   │   ├── OrderPostPojo.java
│   │   │   ├── userPojos
│   │   │       └── UserPojo.java
│   │   ├── requests
│   │   │   ├── petsAPIRequests
│   │   │   │   ├── PetAPITestWithDataProvider
│   │   │   │   │   └── Pet_API_Requests_With_Data_Providers.java
│   │   │   │   ├── PetAPITestWithFaker
│   │   │   │   │   ├── Pet_API_Requests_Negative_Test_Scenarios.java
│   │   │   │   │   └── Pet_API_Requests_Positive_Test_Scenarios.java
│   │   │   ├── storeAPIRequests
│   │   │   │   └── Order_API_Requests.java
│   │   │   ├── userAPIRequests
│   │   │       └── User_API_Requests.java
│   │   ├── utilities
│   │       ├── DataProviderUtil.java
│   │       ├── ExtentReport.java
│   │       ├── Listener.java
└── testng.xml
```

## Technologies and Dependencies
- **Java 17**
- **TestNG 7.7.1**
- **Rest-Assured 5.3.1**
- **ExtentReports 4.1.7**
- **Jackson Databind 2.15.2**
- **JavaFaker 1.0.2**
- **Maven**

## Setup Instructions
1. Clone the project to your local machine:
   ```sh
   git clone <https://github.com/MSagiroglu/PetStoreSwaggerAPIAutomation.git>
   ```
2. Download the Maven dependencies:
   ```sh
   mvn clean install
   ```

## Usage
1. To run the tests, use the following command:
   ```sh
   mvn test
   ```
2. View the test results in the HTML reports created in the `raporlar` directory.

## CI/CD Configuration
The project uses GitHub Actions for automated test execution. The project uses GitHub Actions to automate the execution of tests. 
The workflow runs on every push to the main branch and at scheduled intervals (14:00 and 22:00 UTC daily). 
The workflow configuration is as follows:

```yaml
name: Pet Store Swagger API Automation Tests With Java & Rest Assured & Maven & TestNG

on:
  push:
    branches:
      - main
  schedule:
    - cron: '0 14 * * *'
    - cron: '0 22 * * *'

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v2

      - name: Set up JDK
        uses: actions/setup-java@v1
        with:
          java-version: '17'
          distribution: 'adopt'

      - name: Build with Maven
        run: mvn clean install

      - name: Run tests
        run: mvn test
```

## Test Scenarios and Explanations
- **Positive Test Scenarios:**
    - `Pet_API_Requests_With_Data_Providers`: Tests POST, GET, PUT, and DELETE requests with different data sets.
    - `Pet_API_Requests_Positive_Test_Scenarios`: Uses Faker to execute positive test scenarios.
- **Negative Test Scenarios:**
    - `Pet_API_Requests_Negative_Test_Scenarios`: Tests invalid data requests for proper error responses.
- **User Test Scenarios:**
    - `User_API_Requests`: Tests various requests for user APIs.
- **Order Test Scenarios:**
    - `Order_API_Requests`: Tests various requests for order APIs.
## Test Reports
- The project uses ExtentReports to generate detailed test reports. Here are some sample screenshots of the test reports:
![img.png](img.png)

- Overview of the test results.
![img_1.png](img_1.png)

- Detailed view of  test class List. 
![img_2.png](img_2.png)

## Contributors
- **Mustafa SAĞIROĞLU**
- **Software Automation Tester**
- **[Linkedin](https://www.linkedin.com/in/mustafa-sagiroglu-manual-automation-tester/)**
- **[Portfolio](https://linktr.ee/Mustafa_Sagiroglu)**

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details.

---

