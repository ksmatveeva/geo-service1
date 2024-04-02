import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MessageSenderImplTest {

    private GeoService geoService;
    private LocalizationService localizationService;
    private MessageSenderImpl messageSender;

    @BeforeEach
    void setUp() {
        geoService = mock(GeoService.class);
        localizationService = mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    void testSendRussianMessage() {
        String ipAddress = "172.123.12.19";
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipAddress);

        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        when(geoService.byIp(ipAddress)).thenReturn(location);
        when(localizationService.locale(location.getCountry())).thenReturn("Привет");

        String message = messageSender.send(headers);

        assertEquals("Привет", message);
    }

    @Test
    void testSendEnglishMessage() {
        String ipAddress = "96.44.183.149";
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipAddress);

        Location location = new Location("New York", Country.USA, "10th Avenue", 32);
        when(geoService.byIp(ipAddress)).thenReturn(location);
        when(localizationService.locale(location.getCountry())).thenReturn("Hello");

        String message = messageSender.send(headers);

        assertEquals("Hello", message);
    }
}
