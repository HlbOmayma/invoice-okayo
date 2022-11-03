package com.example.invoiceokayo.service;

import com.example.invoiceokayo.model.CompteBancaire;
import com.example.invoiceokayo.model.Prestation;

import java.util.Collection;

public interface ICompteBancaireService {

    public void createCompteBancaire(CompteBancaire compteBancaire);
    public void updateCompteBancaire(Long id, CompteBancaire compteBancaire);
    public void deleteCompteBancaire(Long id);
    public Collection<CompteBancaire> getCompteBancaires();
}
