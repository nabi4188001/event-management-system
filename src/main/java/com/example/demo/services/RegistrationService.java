package com.example.demo.services;

import com.example.demo.models.Registration;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private final List<Registration> registrations = new ArrayList<>();

    public RegistrationService() {
        registrations.add(new Registration("John Doe", "johndoe@example.com", "Spring Boot Workshop"));
        registrations.add(new Registration("Jane Smith", "janesmith@example.com", "Java Programming"));
    }

    public Registration register(Registration registration) {
        registrations.add(registration);
        return registration;
    }

    public List<Registration> getRegistrationsByEvent(String eventName) {
        return registrations.stream()
                .filter(reg -> reg.getEventName().equalsIgnoreCase(eventName))
                .collect(Collectors.toList());
    }

    public List<Registration> getAllRegistrations() {
        return new ArrayList<>(registrations); // Return a copy of all registrations
    }

    public void cancelRegistration(String email) {
        registrations.removeIf(reg -> reg.getEmail().equalsIgnoreCase(email));
    }
}
