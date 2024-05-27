Tools being used:
 Java: Java is used as programming language.

 Selenium: Selenium provides support for the automation of web browsers,
helps with imitating user interaction with browsers etc.
 WebDriver Manager: This is an automated driver management, and it provides
helper features for Selenium WebDriver in Java.
 TestNG is used for assertion and verification purposes.
 TestNG Reporting: This produces reports that contain information about what
scenarios have passed or failed.
---- Approach:
 Test-Driven Development (TDD) is implemented
 I used Page Object Model (POM) Design Pattern for my framework. By using
POM, I located the Web Elements beforehand under "pages package" which
helps with the code reusability (each Web Element is located only once - no
duplication) and improved the code maintenance.
 I passed my URL ,email,password and browser in "configuration.properties"; to avoid hard
coding.
 "utils"; package consist of 3 classes. "ConfigurationReader"; is used to read
the configuration.properties file. "Driver"; class is where I created my driver
instance as well as getDriver and closeDriver methods. Helper; has the
common and reusable methods.
 I used Singleton Design Pattern when creating my driver instance. This
ensures that the same instance of the driver is called everytime I call it,
regardless of where and when I call it.