package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.Booking;
import de.tekup.locationappb.entites.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue,Long> {
    List<Issue> findByUser_Username(String Id);
}
