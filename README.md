# Framework TechMahindra - Emiliano Badillo

This project is an automated testing framework for the site [Rahul Shetty Academy](https://rahulshettyacademy.com/client), built with **Selenium WebDriver**, **TestNG**, and **Java**.

## Project Structure

- **data**: Contains data provider classes for Excel and constant data files used in tests.
- **maps**: Contains mappings for different modules, including Checkout Page, Login Page, Main Page, and Orders List Page.
- **pages**: Implements the Page Object Model (POM) pattern similar to the maps structure, containing page classes for different functionalities.
- **test**: Contains test files, including the Shopping Test, which executes all test cases.
- **utils**: Provides utility classes, including:
  - **BaseTest**: Base class for all tests.
  - **CommonCommands**: Contains common actions that can be reused across tests.
  - **ExcelUtils**: For reading data from Excel files.
  - **ExtendReportsManager**: For managing report generation.
  - **JsonUtil**: For handling JSON data.
  - **ScreenshotUtil**: For capturing screenshots during test execution.
- **resources**: Contains the Excel file with login credentials (username and password) and keys for accessing the application. This folder also includes:
  - **Test Suites**: Both regression and smoke suites.
  - **log4j2**: Configuration for logging.

## Dependencies

This project uses the following dependencies, which can be found in the `pom.xml` file:

- **Java**: 11
- **Selenium WebDriver**
- **TestNG**
- **Apache POI**: For reading and writing Excel files.
- **log4j2**: For logging.
- **Allure Report**: For reporting.
- **AventStack**: For advanced reporting capabilities.

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/your-repo.git
   ```

2. Navigate to the project directory:

   ```bash
   cd your-repo
   ```

3. Install the dependencies using Maven:

   ```bash
   mvn clean install
   ```

4. Run your tests with:

   ```bash
   mvn test
   ```

