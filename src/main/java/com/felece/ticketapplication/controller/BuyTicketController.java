package com.felece.ticketapplication.controller;


import com.felece.ticketapplication.model.Statue;
import com.felece.ticketapplication.model.request.CreateBuyTicketRequest;
import com.felece.ticketapplication.model.response.BuyTicketResponse;
import com.felece.ticketapplication.service.BuyTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/buyTicket")
@RequiredArgsConstructor
public class BuyTicketController {

    private final BuyTicketService buyTicketService;


    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{customerId}")
    public ResponseEntity<List<BuyTicketResponse>> findBuyTicketByCustomer_Id(@PathVariable int customerId){
        return new ResponseEntity<>(buyTicketService.findBuyTicketByCustomer_CustomerId(customerId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{customerId}/departureDate/{departureDate}")
    public ResponseEntity<List<BuyTicketResponse>> findBuyTicketByCustomer_IdAndTrip_DepartureDate(
            @PathVariable int customerId,@PathVariable String departureDate){
        return new ResponseEntity<>(buyTicketService.findBuyTicketByCustomer_CustomerIdAndTrip_DepartureDate(
                customerId,departureDate), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{customerId}/{routeId}")
    public ResponseEntity<List<BuyTicketResponse>> findBuyTicketByCustomer_IdAndTrip_Route_RouteId(
            @PathVariable int customerId,@PathVariable int routeId){
        return new ResponseEntity<>(buyTicketService.findBuyTicketByCustomer_CustomerIdAndTrip_Route_RouteId(
                customerId,routeId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{customerId}/statue/{statue}")
    public ResponseEntity<List<BuyTicketResponse>> findBuyTicketByCustomer_IdAndStatue(
            @PathVariable int customerId, @PathVariable Statue statue){
        return new ResponseEntity<>(buyTicketService.findBuyTicketByCustomer_CustomerIdAndStatue(
                customerId,statue), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("ticketId/{ticketId}")
    public ResponseEntity<BuyTicketResponse> findBuyTicketByTicketId(
            @PathVariable int ticketId){
        return new ResponseEntity<>(buyTicketService.findById(
                ticketId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping
    public ResponseEntity<BuyTicketResponse> createBuyTicket(@RequestBody @Valid CreateBuyTicketRequest createBuyTicketRequest){
        return new ResponseEntity<>(buyTicketService.createBuyTicket(createBuyTicketRequest),HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/cancelled")
    public ResponseEntity<BuyTicketResponse> updateStatueForCancelled(@RequestParam("buyTicketId") int buyTicketId){
        return new ResponseEntity<>(buyTicketService.updateStatueForCancelled(buyTicketId),HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/postponed")
    public ResponseEntity<BuyTicketResponse> updateStatueForPostponed(@RequestParam("buyTicketId") int buyTicketId){
        return new ResponseEntity<>(buyTicketService.updateStatueForPostponed(buyTicketId),HttpStatus.CREATED);
    }
}
