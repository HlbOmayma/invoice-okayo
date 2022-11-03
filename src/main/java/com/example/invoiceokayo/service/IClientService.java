package com.example.invoiceokayo.service;

import com.example.invoiceokayo.model.Client;
import com.example.invoiceokayo.model.Societe;

import java.util.Collection;

public interface IClientService {

    public void createClient(Client client);
    public void updateClient(Long id, Client client);
    public void deleteClient(Long id);
    public Collection<Client> getClients();
}
