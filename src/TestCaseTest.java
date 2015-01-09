

public class TestCaseTest extends TestCase{
	
	public TestCaseTest(String methodName) {
		super(methodName);
	}

	WasRun test;
	
	private TestResult result;
	public void setUp() {
		test = new WasRun("testMethod");
		result = new TestResult();
		
	}
	
	public void testTemplateMethod() throws Exception{
		test = new WasRun("testMethod");
		test.run(result);
		assert test.log.equals("setUp testMethod tearDown ");
	}
	
	public void testResult() throws Exception{
		test = new WasRun("testMethod");  
		test.run(result);
		assert "1 run, 0 failed" == result.summary();
	}
	
	public void testFailedResult() throws Exception{
		test = new WasRun("testMethod");  
		test.run(result);
		assert "1 run, 1 failed" == result.summary();
	}
	
	public void testFailedResultFormatting(){
		result.testStarted();
		result.testFailed();
		assert "1 run, 1 failed" == result.summary();
	}
	
	public void testSuite() throws Exception{ 
		TestSuite suite = new TestSuite();
		suite.add(new WasRun("testMethod"));
		suite.add(new WasRun("testBrokenMethod"));
		suite.run(result);
		assert "2 run, 1 failed" == result.summary(); 
	}

	public static void main(String args[]) throws Exception{	
		TestSuite suite = new TestSuite();
		TestResult result = new TestResult();
		suite.add(new TestCaseTest("testTemplateMethod"));
		suite.add(new TestCaseTest("testResult"));
		suite.add(new TestCaseTest("testFailedResult"));
		suite.add(new TestCaseTest("testFailedResultFormatting"));
		suite.add(new TestCaseTest("testSuite"));
		suite.run(result);
		System.out.println(result.summary());
	}
}
	