package com.example.invoiceokayo.service;

import com.example.invoiceokayo.model.Facture;
import com.example.invoiceokayo.model.Prestation;

import java.util.Collection;

public interface IPrestationService {

    public void createPrestation(Prestation prestation);
    public void updatePrestation(Long id, Prestation prestation);
    public void deletePrestation(Long id);
    public Collection<Prestation> getPrestations();
}
