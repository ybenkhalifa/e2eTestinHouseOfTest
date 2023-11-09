### Usage with Eclipse

1. **Clone this repository to your local machine.**

2. **Open Eclipse IDE.**

3. **Import the project into Eclipse:**
   - Click on "File" -> "Import."
   - In the "Import" dialog, expand the "Maven" category and select "Existing Maven Projects."
   - Click "Next."
   - Browse to the directory where you cloned the project, select the project folder, and click "Finish."

4. **Configure ChromeDriver path (if not already configured):**
   - Open the `pom.xml` file in your project.
   - Locate the following section:

```xml
     <configuration>
         <systemPropertyVariables>
             <!-- Specify the path to ChromeDriver executable -->
             <webdriver.chrome.driver>C:\tmp\chromedriver.exe</webdriver.chrome.driver>
         </systemPropertyVariables>
     </configuration>
  ```

   - Replace `C:\tmp\chromedriver.exe` with the correct path to your ChromeDriver executable (version 119) on your local machine. This ensures that the tests can launch the Chrome browser correctly.

5. **Running TestNG Tests:**
   - In Eclipse, open the "Project Explorer" or "Package Explorer" view.
   - Navigate to the project's source directory (where test classes are located).
   - Right-click on the test class you want to run (e.g., `ContactTester.java`) and select "Run As" -> "TestNG Test."
   - If you want to run all the suite, right-click on the testng.xml and select "Run As" -> "TestNG Test"

6. **View Test Results:**
   - Eclipse will execute the selected TestNG test class, and the test results will be displayed in the "TestNG Results" tab at the bottom.

7. **Repeat Step 5 for Other Test Classes:**
   - Repeat step 5 for other test classes as needed (e.g., `HomePageTester.java`, `JoinUsTester.java`, `ServiceTester.java`).

8. **Automatic WebDriver Management:**
   - After running the tests, Eclipse will automatically manage the WebDriver instance and browser. You do not need to manually close the browser; it will be closed after the test execution.

**Author:** Yassin ben Khalifa

**Version:** 1.0

Please make sure to replace `<webdriver.chrome.driver>C:\tmp\chromedriver.exe</webdriver.chrome.driver>` with the actual path to your ChromeDriver executable in your `pom.xml` file before running the tests.
