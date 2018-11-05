package tests;

import junit.framework.TestCase;
import lection.StringUtils;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;


//Тесты написаные с использованием JUnit4 чтобы показать отличие от JUnit3

public class StringUtilsTestWithJUnit4 extends TestCase {

    private static final Map<String, byte[]> toHexStringData = new HashMap<String, byte[]>();

    @Before
    public static void setUpToHexStringData() {
        toHexStringData.put("", new byte[0]);
        toHexStringData.put("01020d112d7f", new byte[] { 1, 2, 13, 17, 45, 127 });
        toHexStringData.put("00fff21180", new byte[] { 0, -1, -14, 17, -128 });

    }

    @After
    public static void tearDownToHexStringData() {
        toHexStringData.clear();
    }

    @Test
    public void testToHexString() {
        for (Map.Entry<String, byte[]> entry : toHexStringData.entrySet()) {
            final byte[] testData = entry.getValue();
            final String expected = entry.getKey();
            final String actual = StringUtils.toHexString(testData);
            assertEquals(expected, actual);
        }
    }

}