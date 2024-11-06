package biz.restobar.platform.u202018627.attention.interfaces.REST.transform;

import biz.restobar.platform.u202018627.attention.domain.model.commands.CreateReservationCommand;
import biz.restobar.platform.u202018627.attention.interfaces.REST.resources.CreateReservationResource;

public class CreateReservationCommandFromAssembler {
    public static CreateReservationCommand toCommandFromResource(CreateReservationResource resource) {
        return new CreateReservationCommand(resource.nameRestaurant(), resource.clientId(), resource.dateReservation(), resource.countPerson());
    }
}
