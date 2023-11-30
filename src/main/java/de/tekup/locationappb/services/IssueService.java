package de.tekup.locationappb.services;

import de.tekup.locationappb.entites.Booking;
import de.tekup.locationappb.entites.Issue;
import de.tekup.locationappb.repositories.BookingRepository;
import de.tekup.locationappb.repositories.IssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IssueService {
    private  final IssueRepository issueRepository;

    public List<Issue> getAll(){
        return issueRepository.findAll();
    }

    public void delete(long id){
        issueRepository.deleteById(id);
    }
    public Issue getById(Long id){
        return issueRepository.findById(id).orElseThrow();
    }
    public Issue add(Issue issue){
        return issueRepository.save(issue);
    }
    public Issue update(Issue issue){return issueRepository.save(issue);}
}
