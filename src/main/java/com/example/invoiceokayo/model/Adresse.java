package com.example.invoiceokayo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private String rue;

    @Column(name = "code_postal")
    private String codePostal;
    private String ville;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entite", referencedColumnName = "id")
    private Entite entite;

}
