package de.tekup.locationappb.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private FlightDetails flightDetails;
    private int economyClassTickets;
    private int businessClassTickets;
    private int firstClassTickets;
    private LocalDate date;
    private double totalCost;

}
