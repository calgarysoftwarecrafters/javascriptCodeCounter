import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SourceLineCounterTests {

	private javascriptCodeCounter counter;

	@BeforeEach
	void setUp() throws Exception {
		counter = new javascriptCodeCounter();
	}

	@Test
	void emptyFileShouldHaveZeroLines() {
		assertEquals(0, counter.countCodeLines(""));
	}

	@Test
	void newlineOnlyFileShouldHaveZeroLines() {
		assertEquals(0, counter.countCodeLines("\n"));
	}

	@Test
	void spaceOnlyFileShouldHaveZeroLines() {
		assertEquals(0, counter.countCodeLines(" \t\n"));
	}
	
	@Test
	void simpleJavascriptWithNoCommentOnlyLines() {
		String script = "var x, y, z;  // Declare 3 variables\n" + 
				"x = 5;    // Assign the value 5 to x\n" + 
				"y = 6;    // Assign the value 6 to y\n" + 
				"z = x + y;  // Assign the sum of x and y to z\n" + 
				"\n" + 
				"document.getElementById(\"demo\").innerHTML =\n" + 
				"\"The value of z is \" + z + \".\";\n" + 
				"";
		int lineCount = counter.countCodeLines(script);
		assertEquals(6, lineCount, "");
	}
}
