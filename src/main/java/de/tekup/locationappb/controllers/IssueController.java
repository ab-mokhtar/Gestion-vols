package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.Booking;
import de.tekup.locationappb.entites.FlightDetails;
import de.tekup.locationappb.entites.Issue;
import de.tekup.locationappb.entites.User;
import de.tekup.locationappb.services.IssueService;
import de.tekup.locationappb.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/issue")
public class IssueController {
    private final IssueService issueService;
    private final UserService userService;
    @PostMapping("/add")
    public ResponseEntity<Issue> addIssue(@RequestBody Issue issue) {
        User u=userService.getUserById(issue.getUser().getUsername());
        issue.setUser(u);
        issue.setDate(LocalDate.now());
        Issue issuecreated = issueService.add(issue);
        return new ResponseEntity<>(issuecreated, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Issue>> getAllIssues() {
        List<Issue> issues = issueService.getAll();
        return new ResponseEntity<>(issues, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public List<Issue> getBookingByUserId(@PathVariable String id) {
        return issueService.getByUserId(id);
    }

}
