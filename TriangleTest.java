import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by linus on 20/2/17.
 */

public class TriangleTest {
    // used for checking output of System.out.println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    Triangle t;

    @Before
    public void setUpStreams() {
        // create new triangle
        t = new Triangle();
        // reset streams for checking output
        resetStreams();
    }

    @After
    public void cleanUpStreams() {
        // remove streams for checking output
        System.setOut(null);
        System.setErr(null);
    }

    public void resetStreams() {
        // create streams for checking output
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        outContent.reset();
        errContent.reset();
    }

    @Test
    public void print_single_asterisk() {
        t.printAsterisk();
        assertEquals("*\n", outContent.toString());
    }

    @Test
    public void print_horizontal_line() {
        t.printHorizontalLine(0);
        assertEquals("\n", outContent.toString());

        resetStreams(); // does this to get a frest system.out.println

        t.printHorizontalLine(8);
        assertEquals("********\n", outContent.toString());
    }

    @Test
    public void print_vertical_line() {
        t.printVerticalLine(0);
        assertEquals("", outContent.toString());

        resetStreams(); // does this to get a frest system.out.println

        t.printVerticalLine(3);
        assertEquals("*\n*\n*\n", outContent.toString());
    }

    @Test
    public void print_right_triangle() {
        t.print_right_triangle(0);
        assertEquals("", outContent.toString());

        resetStreams(); // does this to get a frest system.out.println

        t.print_right_triangle(3);
        assertEquals("*\n**\n***\n", outContent.toString());
    }

}
