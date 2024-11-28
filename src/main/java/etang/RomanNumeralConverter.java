package etang;

public class RomanNumeralConverter {

    public static String convertToRoman(int arabicNumber) {
        if (arabicNumber < 1 || arabicNumber > 100) {
            return String.valueOf(arabicNumber);
        }

        int[] arabicValues = {100, 50, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"C", "L", "X", "IX", "V", "IV", "I"};

        StringBuilder romanBuilder = new StringBuilder();

        for (int i = 0; i < arabicValues.length; i++) {
            while (arabicNumber >= arabicValues[i]) {
                romanBuilder.append(romanSymbols[i]);
                arabicNumber -= arabicValues[i];
            }
        }

        return romanBuilder.toString();
    }
}
