package de.tekup.locationappb.entites;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class FlightDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightName;
    private String origin;
    private String destination;
    private String duration;
    private LocalDate departureDate;
    private String departureTime;
    private LocalDate returnDate;
    private String returnTime;
    private boolean isEconomyClass;
    private boolean isBusinessClass;
    private boolean isFirstClass;
    private int economyClassSeats;
    private int ResrvedeconomyClassSeats;
    private double economyClassTicketPrice;
    private int businessClassSeats;
    private int ResrvedbusinessClassSeats;
    private double businessClassTicketPrice;
    private int firstClassSeats;
    private int ResrvedfirstClassSeats;

    private double firstClassTicketPrice;

    public void setResrvedeconomyClassSeats(int resrvedeconomyClassSeats) {
        ResrvedeconomyClassSeats += resrvedeconomyClassSeats;
    }

    public void setResrvedbusinessClassSeats(int resrvedbusinessClassSeats) {
        ResrvedbusinessClassSeats += resrvedbusinessClassSeats;
    }

    public void setResrvedfirstClassSeats(int resrvedfirstClassSeats) {
        ResrvedfirstClassSeats += resrvedfirstClassSeats;
    }
}
