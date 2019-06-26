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
* [Parametrize scenarios with test data](/src/test/resources/features/wikipedia/SearchWikipedia.feature)
* [Parametrize test steps with data tables](/src/test/resources/features/wikipedia/DisplayCharacterInformation.feature)

### Test reporting
* [Create test execution report](/src/test/java/net/testwork/demos/cucumber/wikipedia/SearchWikipediaTest.java)
* [Add screenshot to report](/src/main/java/net/testwork/demos/cucumber/config/AllureReport.java)

### Test execution
* [Run selected test scenarios](/src/test/java/net/testwork/demos/cucumber/wikipedia/SmokeTest.java)
* Run all tests - execute 'mvn clean verify' command
* Run tests with different environment configuration - execute 'mvn clean verify -Dspring.profiles.active=dev' command
* Run tests in headless mode - set com.codeborne.selenide.Configuration.headless = true
* Run tests in parallel - set maven-surefire-plugin <forkCount> configuration parameter to value higher that 1 
* Run tests in CI - TODO
* [Use custom WedDriver](/src/main/java/net/testwork/demos/cucumber/config/CustomChromeDriver.java)
* Use hooks - TODO

### Test data
* [Share data between test steps](/src/main/java/net/testwork/demos/cucumber/steps/StarWarsSteps.java)
* Share data between test scenarios - TODO
* [Use REST API to get test data](/src/main/java/net/testwork/demos/cucumber/rest/PlanetsRestService.java)
* Use DB to get test data - TODO
* Test data cleanup - TODO
