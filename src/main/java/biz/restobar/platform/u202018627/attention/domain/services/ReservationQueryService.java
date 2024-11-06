package biz.restobar.platform.u202018627.attention.domain.services;

import biz.restobar.platform.u202018627.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u202018627.attention.domain.model.queries.GetAllReservationQuery;
import biz.restobar.platform.u202018627.attention.domain.model.queries.GetReservationByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ReservationQueryService {
    Optional<Reservation> handle(GetReservationByIdQuery query);
    List<Reservation> handle(GetAllReservationQuery query);
}
