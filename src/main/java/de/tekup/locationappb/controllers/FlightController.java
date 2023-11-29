package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.FlightDetails;
import de.tekup.locationappb.services.FlightDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightDetailsService flightDetailsService;

    @PostMapping("/add")
    public ResponseEntity<FlightDetails> addFlight(@RequestBody FlightDetails flightDetails) {
        FlightDetails addedFlight = flightDetailsService.addFlight(flightDetails);
        return new ResponseEntity<>(addedFlight, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FlightDetails>> getAllFlights() {
        List<FlightDetails> allFlights = flightDetailsService.getAll();
        return new ResponseEntity<>(allFlights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDetails> getFlightById(@PathVariable Long id) {
        FlightDetails flightDetails = flightDetailsService.findById(id);
        return new ResponseEntity<>(flightDetails, HttpStatus.OK);
    }
    @GetMapping("/by/{from}/{to}/{d1}/{d2}")
    public ResponseEntity<List<FlightDetails>> get(@PathVariable String from ,@PathVariable  String to ,@PathVariable  String d1,@PathVariable  String d2) {
        LocalDate d11=LocalDate.parse(d1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate d22=LocalDate.parse(d2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<FlightDetails> flightDetails = flightDetailsService.getByDateAndDestination(from,to,d11,d22);
        return new ResponseEntity<>(flightDetails, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FlightDetails> deleteFlight(@PathVariable Long id) {
        FlightDetails deletedFlight = flightDetailsService.delete(id);
        return new ResponseEntity<>(deletedFlight, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDetails> update(@RequestBody FlightDetails flightDetails){
        FlightDetails fly = flightDetailsService.update(flightDetails);
        return new ResponseEntity<>(fly, HttpStatus.OK);
    }

}
