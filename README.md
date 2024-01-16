# About

#### Requirement(s) for running the test
1. Install an IDE (Eg: IntelliJ, VisualStudio Code)
2. GitBash for Windows user
3. Install Java SDK (https://www.oracle.com/java/technologies/downloads/)
4. Set environment variables for Java path (refer here: https://testsigma.com/blog/selenium-with-eclipse/#Download_and_Install_Java)
5. Install Maven and set environment variables for MAVEN_HOME (refer here: https://phoenixnap.com/kb/install-maven-windows)

#### Running the test
1. Clone project by executing command : git clone https://github.com/nadzainuddin/Assignment01.git on GitBash (for Windows user)
2. Once cloned, open the project in any IDE (Eg: IntelliJ, VisualStudio Code)
3. Go to 'src/test/java/api/<filename>' or 'src/test/java/ui/<filename>'
4. Execute the test by right click on test file (filename that ends with 'Test') and select 'Run...' option

#### Enhancement for UI Test
* Store user credentials and base url in 1 file [eg : application.properties file]
* Set beforeAll => Log into apps instead of set login method on beforeEach test 

#### Enhancement for API Test
* For request body, can either use Map or create model class
