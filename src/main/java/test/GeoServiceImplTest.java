import org.junit.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceImplTest {

    @Test
    public void testByIp_RussianIp_ReturnsMoscowLocation() {
        // Arrange
        String russianIp = "172.0.32.11";
        GeoService geoService = new GeoServiceImpl();

        // Act
        Location location = geoService.byIp(russianIp);

        // Assert
        assertEquals("Moscow", location.getCity());
        assertEquals(Country.RUSSIA, location.getCountry());
    }

    @Test
    public void testByIp_AmericanIp_ReturnsNewYorkLocation() {
        // Arrange
        String americanIp = "96.44.183.149";
        GeoService geoService = new GeoServiceImpl();

        // Act
        Location location = geoService.byIp(americanIp);

        // Assert
        assertEquals("New York", location.getCity());
        assertEquals(Country.USA, location.getCountry());
    }
}
