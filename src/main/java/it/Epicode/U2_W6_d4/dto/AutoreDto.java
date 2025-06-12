package it.Epicode.U2_W6_d4.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {
    @NotEmpty(message = "non puo essere vuoto")
    private String nome;
    @NotEmpty(message = "non puo essere vuoto")
    private String cognome;
    @Email(message = "l'email deve essere valida!")
    private String email;
    @NotNull(message = "Campo ")
    private LocalDate dataDiNascita;
}
