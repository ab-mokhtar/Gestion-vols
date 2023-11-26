package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.Role;
import de.tekup.locationappb.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
    List<User> findUserByRole(Role role); //containing =  like %'k'%


}
