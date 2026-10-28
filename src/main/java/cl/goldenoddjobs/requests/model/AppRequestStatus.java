package cl.goldenoddjobs.requests.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AppRequestStatus {
    PUBLISHED("PUBLICADA"),
    IN_NEGOTIATION("EN_NEGOCIACION"),
    ACCEPTED("ACEPTADA"),
    IN_DEVELOPMENT("EN_DESARROLLO"),
    DELIVERED("ENTREGADA"),
    CLOSED("CERRADA"),
    CANCELLED("CANCELADA");

    private final String value;

    AppRequestStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static AppRequestStatus fromValue(String value) {
        for (AppRequestStatus status : values()) {
            if (status.value.equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown request status: " + value);
    }
}
