package com.example.invoiceokayo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nom;
    private String telephone;

    @OneToMany(mappedBy="entite", cascade = CascadeType.ALL)
    private List<Adresse> adresses = new ArrayList<>();
}
