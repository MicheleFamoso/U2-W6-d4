package it.Epicode.U2_W6_d4.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BlogPostDto {
    @NotEmpty(message = "non puo essere vuoto")
    private String categoria;
    @NotEmpty(message = "non puo essere vuoto")
    private String titolo;
    @NotEmpty(message = "non puo essere vuoto")
    private String contenuto;
    private int tempoDiLettura;
    private int autoreId;
}
