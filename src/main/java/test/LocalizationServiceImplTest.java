import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import package ru.netology;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTest {

    @Test
    public void testLocale_RussianCountry_ReturnsRussianText() {
        // Arrange
        LocalizationService localizationService = new LocalizationServiceImpl();

        // Act
        String localizedText = localizationService.locale(Country.RUSSIA);

        // Assert
        assertEquals("Привет, мир!", localizedText);
    }

    @Test
    public void testLocale_AmericanCountry_ReturnsEnglishText() {
        // Arrange
        LocalizationService localizationService = new LocalizationServiceImpl();

        // Act
        String localizedText = localizationService.locale(Country.USA);

        // Assert
        assertEquals("Hello, World!", localizedText);
    }
}
