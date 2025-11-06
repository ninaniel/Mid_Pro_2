# TBC Bank Loans Test Automation Framework

## Overview
A comprehensive test automation framework for TBC Bank's loan products and services. The framework provides end-to-end testing capabilities including UI automation, API testing, and performance measurement for loan calculators, mortgage services, and refinancing features.

## Quick demo (recorded)
![Auto Loan Test Demo](videos/gif_temp.gif)

```powershell
mvn -Dtest=RefinanceCalculatorTest test
```

Or run full suite with:

```powershell
mvn test -DsuiteXmlFile=testng.xml
```

Notes:
- If the video does not play in your environment, download it from `video/23e3732c043c25ca5fffc5bbccdf68ea.webm` and open it in a local player.
- The recorded run was captured in a controlled environment; timings and exact UI pixels may differ locally or in CI.

## Technology Stack

### Core Technologies
- Java 17
- Maven 3.x
- Playwright 1.52.0
- TestNG 7.10.1
- REST Assured 5.5.0
- Allure Framework 2.24.0
- k6 (JavaScript-based performance testing)

### Additional Tools & Libraries
- Lombok - For reducing boilerplate code
- AspectJ - For advanced logging and monitoring
- JSON Schema Validator - For API response validation

## Project Structure

```plaintext
├── src/
│   ├── main/java/ge/tbc/testautomation/
│   │   ├── data/           # Data models and constants
│   │   ├── pages/          # Page Object Models
│   │   ├── steps/          # Step definitions and business logic
│   │   └── utils/          # Utility classes and helpers
│   ├── test/
│   │   ├── java/          # Test implementations
│   │   └── resources/     # Test configurations and data
│   └── performance/       # k6 performance test scripts
├── allure-results/        # Test execution results
└── testng.xml            # TestNG suite configuration
```

## Features

### UI Automation
- Page Object Model implementation
- Visual regression testing capability
- Cross-browser testing support
- Parallel test execution
- Screenshot capture on failures
- Geolocation mocking support

### API Testing
- REST API validation
- JSON Schema verification
- Response data validation
- Authentication handling
- Error scenario testing

### Performance Testing
- Page load time measurements
- Navigation timing metrics
- Custom performance harness
- k6 load testing integration

## Setup & Configuration

### Prerequisites
1. JDK 17
2. Maven 3.x
3. Node.js (for k6)
4. Git

### Installation
```bash
# Clone the repository
git clone [repository-url]

# Install dependencies
mvn clean install

# Install Playwright browsers
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install --with-deps"
```

## Running Tests

### All Tests
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Specific Test Categories
```bash
# UI Tests
mvn test -Dgroups=ui

# API Tests
mvn test -Dgroups=api

# Performance Tests
mvn test -Dgroups=performance
```

### Configuration Options
- `-Dheadless=true` - Run tests in headless mode
- `-Dbrowser=firefox` - Specify browser for UI tests
- `-DthreadCount=3` - Set parallel execution thread count

## Test Reports

### Allure Reports
```bash
# Generate Allure report
allure generate allure-results -o allure-report --clean

# Open report
allure serve allure-results
```

### Performance Reports
Performance test results are available in:
- Allure reports with timing metrics
- k6 output with detailed performance statistics
- Custom performance summary in test output

## CI/CD Integration

The project includes Azure DevOps pipeline configuration with:
- Automated test execution
- Parallel test runs
- Report generation
- Artifact publishing
- Test result tracking

## Best Practices

### Code Organization
- Separation of concerns (Page Objects, Steps, Utils)
- Clear package structure
- Consistent naming conventions
- Proper exception handling

### Test Design
- Independent test cases
- Readable test methods
- Meaningful assertions
- Data-driven approach
- Proper test categories

### Performance Considerations
- ThreadLocal usage for parallel execution
- Resource cleanup
- Efficient page object initialization
- Smart wait strategies

## Known Limitations
- Visual testing requires baseline images
- Performance metrics may vary by environment
- Some tests require specific browser versions

## Contributing
1. Follow the existing code structure
2. Write tests for new features
3. Update documentation
4. Create detailed pull requests
5. Maintain test independence

## Troubleshooting
- Check Allure reports for test failures
- Verify environment setup
- Review browser compatibility
- Check network connectivity
- Validate test data