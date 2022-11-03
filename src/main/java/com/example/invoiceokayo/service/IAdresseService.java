package com.example.invoiceokayo.service;

import com.example.invoiceokayo.model.Adresse;

import java.util.Collection;

public interface IAdresseService {

    public void createAdresse(Adresse adresse);
    public void updateAdresse(Long id, Adresse adresse);
    public void deleteAdresse(Long id);
    public Collection<Adresse> getAdresses();
}
