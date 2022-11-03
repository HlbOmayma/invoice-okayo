package com.example.invoiceokayo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CompteBancaire {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String domiciliation;
    private String proprietaire;
    private String iban;

    @Column(name = "bic_swift")
    private String bicSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entite")
    private Societe societe;

}
