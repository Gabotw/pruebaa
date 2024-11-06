package biz.restobar.platform.u202018627.attention.application.internal.queryservices;

import biz.restobar.platform.u202018627.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u202018627.attention.domain.model.queries.GetAllReservationQuery;
import biz.restobar.platform.u202018627.attention.domain.model.queries.GetReservationByIdQuery;
import biz.restobar.platform.u202018627.attention.domain.services.ReservationQueryService;
import biz.restobar.platform.u202018627.attention.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationQueryServiceImpl implements ReservationQueryService {
    private final ReservationRepository reservationRepository;

    public ReservationQueryServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Optional<Reservation> handle(GetReservationByIdQuery query) {
        return reservationRepository.findById(query.id());
    }

    @Override
    public List<Reservation> handle(GetAllReservationQuery query) {
        return reservationRepository.findAll();
    }
}
