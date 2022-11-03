package com.example.invoiceokayo.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Societe extends Entite {

    @OneToMany(mappedBy = "societe", cascade = CascadeType.ALL)
    private List<CompteBancaire> comptes = new ArrayList<>();

    @OneToMany(mappedBy = "societe", cascade = CascadeType.ALL)
    private List<Prestation> prestations = new ArrayList<>();

    private String siteweb;
    private String domiciliation;
    private byte[] logo;
    private String siret;
    private Long capital;
    private String nafTVA;
    private String numTVA;

}
