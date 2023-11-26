package de.tekup.locationappb.controllers;


import de.tekup.locationappb.entites.JwtRequest;
import de.tekup.locationappb.entites.JwtResponse;
import de.tekup.locationappb.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    @ResponseBody
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
