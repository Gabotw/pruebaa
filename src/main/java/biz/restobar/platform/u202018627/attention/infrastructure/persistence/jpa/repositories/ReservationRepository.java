package biz.restobar.platform.u202018627.attention.infrastructure.persistence.jpa.repositories;

import biz.restobar.platform.u202018627.attention.domain.model.aggregates.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findById(Long id);
    boolean existsReservationByNameRestaurant(String nameRestaurant);
}
