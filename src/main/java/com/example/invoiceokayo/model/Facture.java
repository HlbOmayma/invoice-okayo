package com.example.invoiceokayo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;

    private Date dateFacturation;

    private Date dateEcheance;

    private float totalHT;

    private float totalTTC;

    private String devise;

    @Column(name = "id_adr_facturation")
    private Long idAdresseFacturation;

    @Column(name = "id_adr_emetteur")
    private Long idAdresseEmetteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", referencedColumnName = "codeClient")
    private Client client;

    @OneToMany(mappedBy = "facture")
    private List<LigneDeFacture> lignesDeFacture = new ArrayList<>();

}
