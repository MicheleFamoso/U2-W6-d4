package it.Epicode.U2_W6_d4.dto;

import lombok.Data;

@Data
public class BlogPostDto {
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private int autoreId;
}
