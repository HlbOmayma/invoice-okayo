package com.example.invoiceokayo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Prestation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private float tva;

    @Column(name = "p_u_ht")
    private float prixUnitaireHT;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_societe")
    private Societe societe;

    @OneToMany(mappedBy = "prestation", cascade = CascadeType.ALL)
    private List<LigneDeFacture> lignesDeFacture = new ArrayList<>();

}
