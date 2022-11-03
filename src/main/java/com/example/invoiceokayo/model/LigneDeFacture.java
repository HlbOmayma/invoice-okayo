package com.example.invoiceokayo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LigneDeFacture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long tva;
    private int quantite;

    @Column(name = "p_u_ht")
    private float prixUnitaire;

    @Column(name = "total_ht")
    private float totalHT;

    private String designation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestation")
    private Prestation prestation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facture")
    private Facture facture;

}
