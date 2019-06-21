# Test automation framework demo project

The goal of this initiative is to provide exemplary project that covers typical cases faced when setting up framework for test automation.

## Technology stack

* Java
* JUnit
* Cucumber JVM
* Selenide
* Allure
* RestAssured
* AssertJ
* Spring
* Maven

## Test automation cases

### Test specification

* [Create executable test specification](/src/test/java/net/testwork/demos/cucumber/wikipedia/OpenWikipediaTest.java)
* Parametrize scenarios with test data
* Parametrize test steps with test data
* Run selected tests

### Test reporting
* Create test execution report
* Add screenshot to report

### Test execution
* Run single test scenario
* Run all tests
* Run tests with different environment configuration
* Run tests in headless mode
* Run tests in parallel
* Run tests in CI
* Use custom WedDriver
* Use hooks

### Test data
* Share data between test steps
* Use REST API to get test data
* Use DB to get test data
* Test data cleanup
