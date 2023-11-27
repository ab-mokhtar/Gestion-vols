package de.tekup.locationappb.services;

import de.tekup.locationappb.entites.FlightDetails;
import de.tekup.locationappb.repositories.FlightDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class FlightDetailsService {
    FlightDetailsRepository flightDetailsRepository;
    public FlightDetails addFlight(FlightDetails fly){
        return flightDetailsRepository.save(fly);
    }
    public List<FlightDetails> getAll(){
        return flightDetailsRepository.findAll();
    }
    public List<FlightDetails> getByDateAndDestination(String from , String to , LocalDate d1,LocalDate d2){
        return flightDetailsRepository.findByOriginAndDestinationAndDepartureDateIsBetween(from,to,d1,d2);
    }
    public  FlightDetails delete(Long id){
        FlightDetails deleted=flightDetailsRepository.findById(id).orElseThrow();
        flightDetailsRepository.deleteById(id);
        return deleted;
    }
    public FlightDetails findById(Long id){
        return flightDetailsRepository.findById(id).orElseThrow();
    }
     public FlightDetails update(FlightDetails flightDetails){return flightDetailsRepository.save(flightDetails);}
}
