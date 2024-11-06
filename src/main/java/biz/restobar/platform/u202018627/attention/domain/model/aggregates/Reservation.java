package biz.restobar.platform.u202018627.attention.domain.model.aggregates;

import biz.restobar.platform.u202018627.attention.domain.model.commands.CreateReservationCommand;
import biz.restobar.platform.u202018627.attention.domain.model.entities.Client;
import biz.restobar.platform.u202018627.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.util.Date;

@Getter
@Entity
public class Reservation extends AuditableAbstractAggregateRoot<Reservation> {
    private String nameRestaurant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private Date dateReservation;
    private Long countPerson;

    public Reservation() {
        this.nameRestaurant = Strings.EMPTY;
        this.client = null;
        this.dateReservation = new Date();
        this.countPerson = 0L;
    }

    public Reservation(String nameRestaurant, Client client, Date dateReservation, Long countPerson) {
        this();
        this.nameRestaurant = nameRestaurant;
        this.client = client;
        this.dateReservation = dateReservation;
        this.countPerson = countPerson;
    }

    public Reservation(CreateReservationCommand command, Client client) {
        this();
        this.nameRestaurant = command.nameRestaurant();
        this.client = client;
        this.dateReservation = command.dateReservation();
        this.countPerson = command.countPerson();
    }
}