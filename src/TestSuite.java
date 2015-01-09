import java.util.ArrayList;
import java.util.List;


public class TestSuite implements Test{

	private List<TestCase> tests;
	
	public TestSuite(){
		tests = new ArrayList<TestCase>();
	}

	public void add(TestCase test) {
		this.tests.add(test);
	}

	public void run(TestResult result) throws Exception {
		for (TestCase test : tests) {
			test.run(result);
		}
	}

	@Override
	public int countTestCases() {
		return tests.size();
	}

}
