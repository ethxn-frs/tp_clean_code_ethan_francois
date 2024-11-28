package etang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralConverterTest {

    @Test
    public void testConvertToRoman() {
        assertEquals("I", RomanNumeralConverter.convertToRoman(1));
        assertEquals("V", RomanNumeralConverter.convertToRoman(5));
        assertEquals("VII", RomanNumeralConverter.convertToRoman(7));
        assertEquals("IX", RomanNumeralConverter.convertToRoman(9));
        assertEquals("X", RomanNumeralConverter.convertToRoman(10));
        assertEquals("XIX", RomanNumeralConverter.convertToRoman(19));
        assertEquals("XXIX", RomanNumeralConverter.convertToRoman(29));
        assertEquals("L", RomanNumeralConverter.convertToRoman(50));
        assertEquals("LIX", RomanNumeralConverter.convertToRoman(59));
        assertEquals("LXXXIX", RomanNumeralConverter.convertToRoman(89));
        assertEquals("C", RomanNumeralConverter.convertToRoman(100));
    }
}
