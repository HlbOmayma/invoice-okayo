package com.example.invoiceokayo.service;

import com.example.invoiceokayo.model.Prestation;
import com.example.invoiceokayo.model.Societe;

import java.util.Collection;

public interface ISocieteService {

    public void createSociete(Societe societe);
    public void updateSociete(Long id, Societe societe);
    public void deleteSociete(Long id);
    public Collection<Societe> getSocietes();
}
