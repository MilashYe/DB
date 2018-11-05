package tests;


import junit.framework.TestCase;
import lection.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Тесты для JUnit3

public class StringUtilsTest extends TestCase {

    private final Map toHexStringData = new HashMap();

    //Разделяем логику и данные
    //Инициализируем значения для всех тестов

    public void setUp() throws Exception {
        toHexStringData.put("", new byte[0]);
        toHexStringData.put("01020d112d7f", new byte[] { 1, 2, 13, 17, 45, 127 });
        toHexStringData.put("00fff21180", new byte[] { 0, -1, -14, 17, -128 });
    }

    public void tearDown() throws Exception {
        toHexStringData.clear();
    }

    //Тест который проверяет работу isEmpty

    public void testIsEmpty() {
        boolean actual = StringUtils.isEmpty(null);
        assertTrue(actual);

        actual = StringUtils.isEmpty("");
        assertTrue(actual);

        actual = StringUtils.isEmpty(" ");
        assertFalse(actual);

        actual = StringUtils.isEmpty("some string");
        assertFalse(actual);
    }

    //Тест для метода ToHexString

    public void testToHexString() {
        for ( Iterator iterator = toHexStringData.keySet().iterator(); iterator.hasNext();) {
            final String expected = (String) iterator.next();
            final byte[] testData = (byte[]) toHexStringData.get(expected);
            final String actual = StringUtils.toHexString(testData);
            assertEquals(expected, actual);
        }
    }
}