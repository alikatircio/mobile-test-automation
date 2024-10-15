# Appium Test Automation Project

This project demonstrates a scalable and maintainable test automation framework using Java, Appium, Selenium, and TestNG. It is designed to follow best practices to ensure readability, reusability, and ease of maintenance.

## Project Structure
The project follows a modular architecture implementing the Page Object Model (POM) to ensure ease of maintenance.

```
appium-automation-project/
|
├── src/
│   ├── main/
│   │   └── java/
│   ├── test/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   └── BaseTest.java             
│   │   │   ├── pages/
│   │   │   │   ├── ContextMenuPage.java      
│   │   │   │   ├── CustomTitlePage.java      
│   │   │   │   ├── HideShowPage.java         
│   │   │   │   ├── ListDialogPage.java       
│   │   │   │   ├── NotificationPage.java     
│   │   │   │   ├── TabsPage.java             
│   │   │   ├── tests/
│   │   │   │   ├── ContextMenuTest.java      
│   │   │   │   ├── CustomTitleTest.java      
│   │   │   │   ├── HideShowTest.java         
│   │   │   │   ├── ListDialogTest.java       
│   │   │   │   ├── NotificationTest.java     
│   │   │   │   ├── TabsTest.java             
│   │   │   ├── utils/
│   │   │   │   ├── AssertionHelper.java      
│   │   │   │   ├── Config.java               
│   │   │   │   ├── DriverManager.java        
│   │   │   │   ├── LogUtils.java             
│   │   │   │   ├── SeleniumHelper.java       
│   │   │   │   ├── WaitHelper.java           
│   └── resources/
│       ├── config.properties                 
│       └── log4j2.xml                        
|
├── pom.xml                                    
└── README.md                                  
```

## Prerequisites
1. **Java JDK 11 or above**: Ensure Java is installed and configured in your environment.
2. **Maven**: Install Apache Maven for dependency management and running tests.
3. **Android SDK**: Install Android SDK and make sure `adb` is available in your system's PATH.
4. **Appium Server**: Install Appium globally using npm:
   ```bash
   npm install -g appium
   ```
5. **Android Emulator or Real Device**: Set up an Android emulator or connect a real Android device with USB debugging enabled.
6. **IntelliJ IDEA**: Recommended IDE for running and debugging the tests.
7. **UIAutomator2**: This project uses UIAutomator2 as the automation engine for Android. It is included by default with Appium, and you must ensure that your device or emulator supports this automation framework for proper functioning of the tests.

## Project Setup
1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd appium-automation-project
   ```

2. **Install Dependencies**
   Run the following command to install all the required dependencies:
   ```bash
   mvn clean install
   ```

3. **Update Configuration**
   Update the `src/main/resources/config.properties` file with the following details:
    - `platformName`: Name of the platform (e.g., `Android`).
    - `deviceName`: Name of the device or emulator.
    - `appPath`: Path to the application APK.
    - `appiumServerURL`: URL of the Appium server (e.g., `http://localhost:4723/wd/hub`).

## Running the Tests

1. **Start Appium Server**
   Start the Appium server to listen for incoming connections:
   ```bash
   appium
   ```

2. **Run Tests Using Maven**
   Execute the following command to run all tests:
   ```bash
   mvn clean test
   ```

   You can also run a specific test class by specifying the class name:
   ```bash
   mvn -Dtest=TabsTest test
   ```

3. **View Test Results**
   After executing the tests, reports are generated in the `target/surefire-reports` directory. You can find detailed logs and test execution results here.

## Running the Tests from IntelliJ IDEA

1. **Open the Project in IntelliJ**
   Import the cloned project into IntelliJ IDEA.

2. **Run Tests**
   Navigate to the test class you want to execute (e.g., `TabsTest.java`) and click on the run icon next to the class or method name.

## Logs and Debugging
- **Logging**: Logs are managed using Log4j. Log messages, including test steps, are printed to the console to help in debugging and understanding test execution flow.
- **Custom Log Messages**: You can view actions like clicking elements, entering text, and verification directly in the console log output.

## Project Features and Best Practices
1. **Page Object Model (POM)**: Each page in the app has a corresponding class that contains the element locators and methods to interact with those elements, promoting reusability and maintainability.
2. **SOLID Principles**: Classes have a single responsibility and follow the open/closed principle, allowing easy extension without modification.
3. **Configuration Management**: Centralized configuration allows for easy changes in environment-specific data without changing the core code.
4. **Logging**: The `LogUtils` class provides methods for logging information, warnings, and errors, making it easier to debug and understand test execution.

## Troubleshooting
- **Device Offline Error**: If the device appears as "offline," restart the device/emulator and ensure `adb` recognizes it (`adb devices`).
- **Appium Server Issues**: Ensure the Appium server is running and accessible at the URL specified in `config.properties`.
- **Capabilities Not Working**: Verify the desired capabilities in `DriverManager.java` are set correctly for your device and app.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Author
Ali Katırcıo - [GitHub Profile](https://github.com/alikatircio)