package com.tommy.microservices.customer_microservices.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequest(
        @NotBlank(message = "El espacio de DNI no puede estar vacío.")
        String dni,

        @NotBlank(message = "El espacio de nombre no puede estar vacío.")
        String nombre,

        @NotBlank(message = "El espacio de apellido no puede estar vacío.")
        String apellido,

        @Email(message = "email invalido.")
        String email
        ) {
}
