package com.example.demo.services;

import com.example.demo.models.Registration;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private final List<Registration> registrations = new ArrayList<>();
    private Long nextId = 1L;

    public RegistrationService() {
        register(new Registration("John Doe", "johndoe@example.com", "Spring Boot Workshop"));
        register(new Registration("Jane Smith", "janesmith@example.com", "Java Programming"));
    }

    public Registration register(Registration registration) {
        registration.setId(nextId++);
        registrations.add(registration);
        return registration;
    }

    public Registration getRegistrationById(Long id) {
        return registrations.stream()
                .filter(reg -> reg.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Registration not found"));
    }

    public List<Registration> getAllRegistrations() {
        return new ArrayList<>(registrations);
    }

    public void cancelRegistration(Long id) {
        registrations.removeIf(reg -> reg.getId().equals(id));
    }

    public void cancelRegistrationByEmail(String email) {
        registrations.removeIf(reg -> reg.getEmail().equalsIgnoreCase(email));
    }

    public List<Registration> getRegistrationsByEvent(String eventName) {
        return registrations.stream()
                .filter(reg -> reg.getEventName().equalsIgnoreCase(eventName))
                .collect(Collectors.toList());
    }
}