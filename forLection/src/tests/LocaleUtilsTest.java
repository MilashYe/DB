package tests;

import lection.LocaleUtils;
import org.junit.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class LocaleUtilsTest extends Assert {
    private final Map<String, Locale> parseLocaleData = new HashMap<String, Locale>();

    @BeforeClass
    private void setUp() {
        parseLocaleData.put(null, null);
        parseLocaleData.put("", LocaleUtils.ROOT_LOCALE);
        parseLocaleData.put("en", Locale.ENGLISH);
        parseLocaleData.put("en_US", Locale.US);
        parseLocaleData.put("en_GB", Locale.UK);
        parseLocaleData.put("ru", new Locale("ru"));
        parseLocaleData.put("ru_RU_xxx", new Locale("ru", "RU", "xxx"));
    }

    @AfterTest
    void tearDown() {
        parseLocaleData.clear();
    }

    @Test
    public void testParseLocale() {
        for (Map.Entry<String, Locale> entry : parseLocaleData.entrySet()) {
            final Locale actual = LocaleUtils.parseLocale(entry.getKey());
            final Locale expected = entry.getValue();
            assertEquals(actual, expected);
        }
    }
}