package com.felece.ticketapplication.repository;


import com.felece.ticketapplication.model.BuyTicket;
import com.felece.ticketapplication.model.Statue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BuyTicketRepository extends JpaRepository<BuyTicket,Integer> {

    List<BuyTicket> findBuyTicketByCustomer_CustomerId(int customerId);

    List<BuyTicket> findBuyTicketByCustomer_CustomerIdAndTrip_DepartureDate(int customerId,LocalDate localDate);

    List<BuyTicket> findBuyTicketByCustomer_CustomerIdAndTrip_Route_RouteId(int customerId,int routeId);

    List<BuyTicket> findBuyTicketByCustomer_CustomerIdAndStatue(int customerId,Statue statue);

    List<BuyTicket> findBuyTicketByTrip_Vehicle_VehicleId(int vehicleId);
}
