This readme is an introduction of testing for an API given below:

API = https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false.

1. Acceptance Criteria:

The test should cover below test 3 criterias:

	1) Name = "Carbon credits"
	2) CanRelist = true
	3)The Promotions element with Name = "Gallery" has a Description that contains the text "2x larger image"


2. Design

2.1 project design
	Through google, I find the above API comes from trademe sandbox rest API test system. At  https://developer.trademe.co.nz/, I can find all detail information about this API. I know it can be accessed by GET and response is JSON. And each JSON resource has a detailed description 
	at the page: https://developer.trademe.co.nz/api-reference/catalogue-methods/retrieve-detailed-information-about-a-single-category/.
	
	
	So, I decided to use some restful API tools to do this test. Below are the details:
	1) Chose Java as the basic development language; 
	2) Use maven manage all the dependence, build and test;
	3) Use TestNG + rest-Assured to construct the automation framework;
	4) Use TestNG's default result&report to display the test result;
	5) Use log4j as log tool;
	6) Use Github as source code control;

2.2 case design 
	1) Use 3 test cases to verify 3 test criterias;
	2) One test java class should be developed since all test cases will test the same API;
	3) Use "priority" annotation to control test sequence in test class;
	4) Use testng.xml to config the test case and scope; at the same time it is the maven test config item;
	5) Before the test, add responseSatusCode check to make sure the response content/format is consistent with trademe's definition. 
	

3. How to run the test
  3.1 Prepare test environment
    1) Before run the test, make sure Java installed on the computer and JAVE_HOME has been configured;
    2) Make sure the maven has been installed and configured correctly;
    3) Make sure Git has been installed and configured correctly;
      
  3.2 Download source code from GitHub
    Use the command :  git clone https://github.com/liyu10/api_test.git 
    
  3.3 Run the test
    1) mvn clean
    2) mvn test
    
  3.4 Check test result:
    The console can show the result summary like : 
    ===============================================
    Default test
    Tests run: 4, Failures: 0, Skips: 0
	===============================================
	
	Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.248 sec - in TestSuite
	
	Results :
	
	Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
	
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time:  9.496 s
	[INFO] Finished at: 2019-03-09T22:48:21+13:00
	[INFO] ------------------------------------------------------------------------
    
    And, detailed information can be found at  ~/api_test/api_test_project/target/surefire-reports/index.html.   