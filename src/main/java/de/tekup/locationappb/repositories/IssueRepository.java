package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {
}
