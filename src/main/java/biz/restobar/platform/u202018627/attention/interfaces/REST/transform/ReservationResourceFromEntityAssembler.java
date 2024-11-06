package biz.restobar.platform.u202018627.attention.interfaces.REST.transform;

import biz.restobar.platform.u202018627.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u202018627.attention.interfaces.REST.resources.ReservationResource;

public class ReservationResourceFromEntityAssembler {
    public static ReservationResource toResourceFromEntity(Reservation reservation) {
        return new ReservationResource(reservation.getId(), reservation.getNameRestaurant(), reservation.getClient().getId(),reservation.getDateReservation(),reservation.getCountPerson());
    }
}
