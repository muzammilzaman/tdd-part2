import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class WasRun extends TestCase{

	public boolean wasRun;
	private TestCase testCase;
	public boolean wasSetUp;
	public String log;

	public WasRun(String methodName) {
		super(methodName);
		this.wasRun = false;
		this.wasSetUp = Boolean.TRUE;
	}

	public void setUp(){
		this.wasRun = false;
		this.wasSetUp = true;
		this.log = "setUp ";
	}
	public void testMethod(){
		this.log = this.log.concat("testMethod " );
	}
	public void tearDown(){
		this.log = this.log.concat("tearDown " );
	}
	
	public void testBrokenMethod() throws Exception{
		throw new Exception();
	}
}
