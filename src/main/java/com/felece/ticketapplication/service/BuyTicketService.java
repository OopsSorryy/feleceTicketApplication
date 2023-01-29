package com.felece.ticketapplication.service;

import com.felece.ticketapplication.core.constant.Constant;
import com.felece.ticketapplication.core.exception.BuyTicketNotFoundException;
import com.felece.ticketapplication.core.exception.SeatNumberAlreadyTaken;
import com.felece.ticketapplication.core.exception.VehicleIsFullException;
import com.felece.ticketapplication.model.BuyTicket;
import com.felece.ticketapplication.model.Customer;
import com.felece.ticketapplication.model.Statue;
import com.felece.ticketapplication.model.Trip;
import com.felece.ticketapplication.model.converter.BuyTicketConverter;
import com.felece.ticketapplication.model.request.CreateBuyTicketRequest;
import com.felece.ticketapplication.model.response.BuyTicketResponse;
import com.felece.ticketapplication.repository.BuyTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuyTicketService {

    private final BuyTicketRepository buyTicketRepository;
    private final BuyTicketConverter buyTicketConverter;

    private final TripService tripService;
    private final CustomerService customerService;

    private final VehicleService vehicleService;

    public List<BuyTicketResponse> findBuyTicketByCustomer_CustomerId(int customerId){
        return buyTicketConverter.convert(buyTicketRepository.findBuyTicketByCustomer_CustomerId(customerId));
    }

    public List<BuyTicketResponse> findBuyTicketByCustomer_CustomerIdAndTrip_DepartureDate(int customerId,String departureDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(departureDate, formatter);

        return buyTicketConverter.convert(
                buyTicketRepository.findBuyTicketByCustomer_CustomerIdAndTrip_DepartureDate(customerId,localDate));
     }

    public List<BuyTicketResponse> findBuyTicketByCustomer_CustomerIdAndTrip_Route_RouteId(int customerId,int routeId){
        return buyTicketConverter.convert(
                buyTicketRepository.findBuyTicketByCustomer_CustomerIdAndTrip_Route_RouteId(customerId,routeId));
     }

    public List<BuyTicketResponse> findBuyTicketByCustomer_CustomerIdAndStatue(int customerId,Statue statue){
        return buyTicketConverter.convert(buyTicketRepository.findBuyTicketByCustomer_CustomerIdAndStatue(customerId,statue));
    }

    public BuyTicketResponse createBuyTicket(CreateBuyTicketRequest createBuyTicketRequest){
        Customer customer = customerService.getCustomerByCustomerId(createBuyTicketRequest.getCustomerId());
        Trip trip = tripService.findTripById(createBuyTicketRequest.getTripId());

        BuyTicket buyTicket = new BuyTicket
                (
                        createBuyTicketRequest.getSeatNumber(),
                        Statue.BOUGHT,
                        trip,
                        customer
                );

        if (buyTicket.getTrip().getVehicle().getCapacity()==0){
            throw new VehicleIsFullException(Constant.VEHICLE_IS_FULL);
        }

        List<BuyTicket> tickets = buyTicketRepository.findBuyTicketByTrip_Vehicle_VehicleId(
                buyTicket.getTrip().getVehicle().getVehicleId());

        List<BuyTicket> collect = tickets.stream()
                        .filter(buyTicket1 -> buyTicket1.getSeatNumber() == buyTicket.getSeatNumber())
                                .collect(Collectors.toList());

        if (collect.size()!=0){
            throw new SeatNumberAlreadyTaken(Constant.SEAT_NUMBER_ALREADY_TAKEN);
        }

        int capacity1 = vehicleService.
                findVehicleById(buyTicket.getTrip().getVehicle().getVehicleId()).getCapacity();

        vehicleService.updateVehicle(buyTicket.getTrip().getVehicle().getVehicleId(),capacity1-1);
        return buyTicketConverter.convert(buyTicketRepository.save(buyTicket));
    }

    public BuyTicketResponse updateStatueForCancelled(int buyTicketId){
        BuyTicket buyTicket = findBuyTicketById(buyTicketId);
        buyTicket.setStatue(Statue.CANCELLED);

        return buyTicketConverter.convert(buyTicketRepository.save(buyTicket));
    }

    public BuyTicketResponse updateStatueForPostponed(int buyTicketId){
        BuyTicket buyTicket = findBuyTicketById(buyTicketId);
        buyTicket.setStatue(Statue.POSTPONED);

        return buyTicketConverter.convert(buyTicketRepository.save(buyTicket));
    }

    protected BuyTicket findBuyTicketById(int buyTicketId){
        return buyTicketRepository.findById(buyTicketId).orElseThrow(()->
                new BuyTicketNotFoundException(Constant.BUY_TICKET_NOT_FOUND));
    }

    public BuyTicketResponse findById(int buyTicketId){
        BuyTicket buyTicket1 = buyTicketRepository.findById(buyTicketId).orElseThrow(() ->
                new BuyTicketNotFoundException(Constant.BUY_TICKET_NOT_FOUND));
        return buyTicketConverter.convert(buyTicket1);
    }

}
