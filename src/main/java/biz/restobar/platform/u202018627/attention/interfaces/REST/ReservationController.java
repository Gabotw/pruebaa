package biz.restobar.platform.u202018627.attention.interfaces.REST;

import biz.restobar.platform.u202018627.attention.domain.model.queries.GetAllReservationQuery;
import biz.restobar.platform.u202018627.attention.domain.model.queries.GetReservationByIdQuery;
import biz.restobar.platform.u202018627.attention.domain.services.ReservationCommandService;
import biz.restobar.platform.u202018627.attention.domain.services.ReservationQueryService;
import biz.restobar.platform.u202018627.attention.interfaces.REST.resources.CreateReservationResource;
import biz.restobar.platform.u202018627.attention.interfaces.REST.resources.ReservationResource;
import biz.restobar.platform.u202018627.attention.interfaces.REST.transform.CreateReservationCommandFromAssembler;
import biz.restobar.platform.u202018627.attention.interfaces.REST.transform.ReservationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/reservation", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Reservation", description = "Reservation Management Endpoints")
public class ReservationController {
    private final ReservationCommandService reservationCommandService;
    private final ReservationQueryService reservationQueryService;

    public ReservationController(ReservationCommandService reservationCommandService, ReservationQueryService reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }
    @PostMapping
    public ResponseEntity<ReservationResource> createReservation(@RequestBody CreateReservationResource createReservationResource) {
        var createReservationCommand = CreateReservationCommandFromAssembler.toCommandFromResource(createReservationResource);
        var reservationId = reservationCommandService.handle(createReservationCommand);
        if(reservationId==null) {
            return ResponseEntity.badRequest().build();
        }
        var getReservationByIdQuery = new GetReservationByIdQuery(reservationId);
        var reservation = reservationQueryService.handle(getReservationByIdQuery);
        if(reservation.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var reservationResource = ReservationResourceFromEntityAssembler.toResourceFromEntity(reservation.get());
        return new ResponseEntity<>(reservationResource, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ReservationResource>> getAllReservations() {
        var getAllReservationQuery = new GetAllReservationQuery();
        var reservation = reservationQueryService.handle(getAllReservationQuery);
        var reservationResource = reservation.stream().map(ReservationResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(reservationResource);
    }
}
