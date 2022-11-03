package com.example.invoiceokayo.service;


import com.example.invoiceokayo.model.Facture;
import com.example.invoiceokayo.model.LigneDeFacture;

import java.util.Collection;
import java.util.List;

public interface IFactureService {

    public void createFacture(Facture facture);
    public void updateFacture(Long id, Facture facture);
    public void deleteFacture(Long id);
    public Collection<Facture> getFactures();
    //public List<LigneDeFacture> updateTotal(Long idFacture);

}
