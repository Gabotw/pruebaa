package biz.restobar.platform.u202018627.attention.application.internal.commandservices;

import biz.restobar.platform.u202018627.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u202018627.attention.domain.model.commands.CreateReservationCommand;
import biz.restobar.platform.u202018627.attention.domain.model.entities.Client;
import biz.restobar.platform.u202018627.attention.domain.services.ReservationCommandService;
import biz.restobar.platform.u202018627.attention.infrastructure.persistence.jpa.repositories.ClientRepository;
import biz.restobar.platform.u202018627.attention.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {
    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;

    public ReservationCommandServiceImpl(ReservationRepository reservationRepository, ClientRepository clientRepository) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Long handle(CreateReservationCommand command) {
        if (reservationRepository.existsReservationByNameRestaurant(command.nameRestaurant())) {
            throw new IllegalArgumentException("Reservation already exists");
        }

        Client client = clientRepository.findById(command.clientId())
                .orElseGet(() -> {
                    Client newClient = new Client();
                    clientRepository.save(newClient);
                    return newClient;
                });

        var reservation = new Reservation(command.nameRestaurant(), client, command.dateReservation(), command.countPerson());
        try {
            reservationRepository.save(reservation);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving reservation: " + e.getMessage());
        }
        return reservation.getId();
    }
}