# SauceDemo E2E Automation Framework

## Overview
This repository contains an automated functional testing framework for the SauceDemo (Swag Labs) website. The goal is to automate the end-to-end user journey—from login to order completion—using industry-standard practices.

## Project Structure
The framework follows the **Page Object Model (POM)** to keep the code clean and maintainable:
* **src/main/java**: Contains Page Objects (Locators and Action methods).
* **src/test/java**: Contains TestNG test scripts and Base Setup.
* **reports/**: Stores the generated Extent Reports.
* **screenShots/**: Captures screenshots automatically on test failure.

## Tech Stack
* **Language**: Java
* **Tool**: Selenium WebDriver 
* **Framework**: TestNG
* **Build Tool**: Maven
* **Reporting**: Extent Reports 

## Key Features Implemented
1. **Hybrid Execution**: Supports cross-browser testing (Chrome, Edge, Firefox) via `testng.xml`.
2. **Data-Driven Testing**: Uses TestNG `@DataProvider` to test multiple login credentials (Valid/Invalid).
3. **Synchronization**: Replaced `Thread.sleep` with `WebDriverWait` (Explicit Wait) for faster and more stable execution.
4. **Smart Reporting**: Integrated Listeners to attach screenshots only when a test fails.

