# Cucumber Java Project

## Overview
This project is a Cucumber-based Java application that demonstrates behavior-driven development (BDD) using Cucumber and JUnit. It includes a simple application with feature files, step definitions, and a test runner.

## Project Structure
```
cucumber-java-project
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── App.java
│   │   │           └── StepDefinitions.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── RunCucumberTest.java
│       └── resources
│           └── features
│               └── example.feature
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd cucumber-java-project
   ```

2. **Build the Project**
   Make sure you have Maven installed. Run the following command to build the project:
   ```bash
   mvn clean install
   ```

3. **Run the Tests**
   To execute the Cucumber tests, use the following command:
   ```bash
   mvn test
   ```

## Usage
- The `App.java` file contains the main application logic.
- The `StepDefinitions.java` file defines the steps for the Cucumber tests.
- The `example.feature` file contains the feature definitions in Gherkin syntax.
- Modify the `application.properties` file for any application-specific configurations.

## Dependencies
This project uses the following dependencies:
- Cucumber
- JUnit

Make sure to check the `pom.xml` file for the complete list of dependencies and their versions.

## Contributing
Feel free to submit issues or pull requests for improvements or bug fixes.
# BDDPipeline
Sample BDD Repo. Uses Java, Selenium, Cucumber, Extent Reports, POM design pattern
