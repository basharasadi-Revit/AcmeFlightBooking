# AcmeFlightBooking
Acme Flight booking Application

Java Selenium Automation 
Tests for Baggage Allowance

Selenium is a tool to automate end-to-end web testing. In IntelliJ IDEA, Java/Maven project is created to implement the Page Object Model. TestNG is used for assertions.
Further help on the relevant topics can be found on the web.

Documentation
As per the document provided a total of 5 tests are provided. Ports and baggage allowance is passed as parameters in the test methods.
1.	FlightBookingAdd_OneBag
2.	FlightBookingAdd_TwoBags
3.	FlightBookingAdd_ThreeBags
4.	FlightBookingAdd_FourBags
5.	FlightBookingAdd_FiveBags

Test Data: Input data is configured in “./utils/CommonVars” class. Singleton implementation is provided to avoid any issues while parallel executing the scripts.
Some data can also be configured in the resources “config.properties” file as well.
Ports and baggage allowance is passed as parameters in the test methods.

Running Tests:
Main test file is “FlightSearchTests” which has five test cases – and can be found in 
“./main/java/tests” folder.

Run Tests in IntelliJ IDEA
Press Shift+Alt+F10 to see the list of available run configurations or Shift+Alt+F9 for debug configurations to the right of the list.
Alternatively, select Run | Run Shift+F10 or Run | Debug Shift+F9 from the main menu.

Run All Tests in Commandline
1.	Open a terminal window and change directory to your Maven project. You should be in a directory that contains pom.xml file,
2.	Run the below command: mvn -Dtest= FlightSearchTests test. where the FlightSearchTests is a Test class with test methods.


