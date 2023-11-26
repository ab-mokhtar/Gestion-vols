package de.tekup.locationappb.services;

import de.tekup.locationappb.entites.Role;
import de.tekup.locationappb.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private RoleRepository roleRepository;
    public Role addRole(Role role){
        return roleRepository.save(role);
    }

}
