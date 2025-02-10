package com.example.demo.controllers;

import com.example.demo.models.Registration;
import com.example.demo.services.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Registration registerForEvent(@Valid @RequestBody Registration registration) {
        return registrationService.register(registration);
    }

    @GetMapping("/{id}")
    public Registration getRegistrationById(@PathVariable Long id) {
        return registrationService.getRegistrationById(id);
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelRegistration(@PathVariable Long id) {
        registrationService.cancelRegistration(id);
    }

    @DeleteMapping("/email/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelRegistrationByEmail(@PathVariable String email) {
        registrationService.cancelRegistrationByEmail(email);
    }

    @GetMapping("/event/{eventName}")
    public List<Registration> getRegistrationsByEvent(@PathVariable String eventName) {
        return registrationService.getRegistrationsByEvent(eventName);
    }
}
