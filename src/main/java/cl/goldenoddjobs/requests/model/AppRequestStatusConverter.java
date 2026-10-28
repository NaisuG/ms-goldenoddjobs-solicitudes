package cl.goldenoddjobs.requests.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AppRequestStatusConverter implements AttributeConverter<AppRequestStatus, String> {

    @Override
    public String convertToDatabaseColumn(AppRequestStatus status) {
        return status == null ? null : status.getValue();
    }

    @Override
    public AppRequestStatus convertToEntityAttribute(String value) {
        return value == null ? null : AppRequestStatus.fromValue(value);
    }
}
