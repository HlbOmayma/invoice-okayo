package com.example.invoiceokayo.service;

import com.example.invoiceokayo.model.LigneDeFacture;

import java.util.Collection;

public interface ILigneDeFactureService {

    public void createLigneDeFacture(LigneDeFacture ligneDeFacture);
    public void updateLigneDeFacture(Long id, LigneDeFacture ligneDeFacture);
    public void deleteLigneDeFacture(Long id);
    public Collection<LigneDeFacture> getLignesDeFactures();
}
