package converter.example;

import org.springframework.stereotype.Component;

@Component("ConverterBean")

public class Converter {

    public String text(final String word) {
        StringBuilder result = new StringBuilder();
        char[] symbol = word.toCharArray();

        for (int i = 0; i < symbol.length; ++i) {

            if (i % 2 == 0) {
                result.append(Character.toLowerCase(symbol[i]));
            } else {
                result.append(Character.toUpperCase(symbol[i]));
            }
        }

        return result.toString();
    }

}
