package cl.goldenoddjobs.requests.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppRequestStatusTest {

    @Test
    void keepsTheStoredAndJsonValuesOfTheExistingContract() {
        assertEquals("PUBLICADA", AppRequestStatus.PUBLISHED.getValue());
        assertEquals("EN_NEGOCIACION", AppRequestStatus.IN_NEGOTIATION.getValue());
        assertEquals("CANCELADA", AppRequestStatus.CANCELLED.getValue());
    }

    @Test
    void converterMapsBetweenEnumAndColumnValue() {
        AppRequestStatusConverter converter = new AppRequestStatusConverter();
        assertEquals("PUBLICADA", converter.convertToDatabaseColumn(AppRequestStatus.PUBLISHED));
        assertEquals(AppRequestStatus.DELIVERED, converter.convertToEntityAttribute("ENTREGADA"));
        assertNull(converter.convertToEntityAttribute(null));
    }
}
