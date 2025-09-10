package com.reservation.reservation_server.common;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

public enum ServiceStatus {
    PENDING, CONFIRMED, DELETED
}
