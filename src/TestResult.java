
public class TestResult {

	private int runCount;
	private int errorCount;

	public TestResult(){
		this.runCount = 0;
		this.errorCount = 0;
	}
	
	public String summary(){
		return this.runCount + " run, "+this.errorCount+" failed";
	}
	
	public void testStarted(){
		this.runCount++;
	}

	public void testFailed() {
		this.errorCount++;
	}
}
