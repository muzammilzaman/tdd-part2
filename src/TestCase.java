import java.lang.reflect.Method;


public class TestCase implements Test{
	private String methodName;
	private TestResult result;

	public TestCase(String methodName){
		this.methodName = methodName;
	}
	
	public void setUp(){
	}
	
	public void run(TestResult result) throws Exception{
		//result = new TestResult();
		result.testStarted();
		this.setUp();
		try {
			Method method = this.getClass().getMethod(this.methodName, null);
			method.invoke(this);
		} catch (Exception e) {
			result.testFailed();
		}
		this.tearDown();
	}

	public void tearDown() {
	}

	@Override
	public int countTestCases() {
		return 1;
	}
}
