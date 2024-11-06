package biz.restobar.platform.u202018627.attention.domain.services;

import biz.restobar.platform.u202018627.attention.domain.model.commands.CreateReservationCommand;

public interface ReservationCommandService {
    Long handle(CreateReservationCommand command);
}
