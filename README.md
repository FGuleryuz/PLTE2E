Tools being used:
● Java: Java is used as the programming language.
● Selenium: Selenium provides support for the automation of web browsers,
helps with imitating user interaction with browsers, etc.
● WebDriver Manager: This is an automated driver management, and it provides
helper features for Selenium WebDriver in Java.
● TestNG is used for assertion and verification purposes.
● TestNG Reporting: This produces reports that contain information about what
scenarios have passed or failed.
---- Approach:
● Test-Driven Development (TDD) is implemented
● I used the Page Object Model (POM) Design Pattern for my framework. By using
POM, I located the Web Elements beforehand under "pages package," which
helps with code reusability (each Web Element is located only once, with no
duplication) and improved code maintenance.
● I passed my URL, email, password and browser in "configuration.properties" to avoid hard
coding.
● The "utils" package consists of 3 classes. "ConfigurationReader" is used to read
the configuration.properties file. In the "Driver" class, I created my driver
instance and getDriver and closeDriver methods. Helper has 
common and reusable methods.
● I used the Singleton Design Pattern when creating my driver instance. This
ensures that the same instance of the driver is called every time I call it,
regardless of where and when.
