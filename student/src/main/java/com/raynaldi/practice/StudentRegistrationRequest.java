package com.raynaldi.practice;

public record StudentRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
