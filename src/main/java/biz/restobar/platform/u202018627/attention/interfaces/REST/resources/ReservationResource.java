package biz.restobar.platform.u202018627.attention.interfaces.REST.resources;

import java.util.Date;

public record ReservationResource(Long id, String nameRestaurant, Long clientId, Date dateReservation, Long countPerson) {
}
