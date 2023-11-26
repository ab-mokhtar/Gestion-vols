package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.Role;
import de.tekup.locationappb.entites.User;
import de.tekup.locationappb.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@AllArgsConstructor
@Controller
public class UserController {
    private UserService userService;
    @PostConstruct
    public void init(){
        userService.initRolesAndUsers();
    }

    @PostMapping("/registerNewUser")
    @ResponseBody
    public User registerNewUser(@RequestBody User user){

        user.setUserPassword(userService.getEncodedPassword(user.getUserPassword()));
        return userService.userRegister(user);
    }

    @GetMapping("/foradmin")
    @PreAuthorize("hasRole('Admin')")
    @ResponseBody
    public String forAdmin(){
        System.out.println("wselet");
        return "this is for admin";
    }

    @GetMapping("/foruser")
    @ResponseBody
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "this is for user";
    }

    @GetMapping("/allUsers")
    @PreAuthorize("hasRole('Admin')")

    @ResponseBody
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @DeleteMapping("/deleteUser/{id}")
    public boolean deleteUser(@PathVariable String id){
        User user = userService.getUserById(id);
        if(user != null){
             for (Role role : user.getRole()) {
                 user.getRole().remove(role);

            }
            userService.deleteUser(user);
            return true;
        }
        return false;
    }
}
