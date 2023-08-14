package converter;

import converter.example.Converter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {
    @Test
    void testConvertWord() {
        //Given
        Converter converter = new Converter();

        //When && Then
        assertEquals("tEsT", converter.text("test"));
    }
}
