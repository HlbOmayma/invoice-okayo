package com.example.invoiceokayo.service.serviceImpl;

import com.example.invoiceokayo.model.Adresse;
import com.example.invoiceokayo.model.Client;
import com.example.invoiceokayo.model.Facture;
import com.example.invoiceokayo.repository.ClientRepository;
import com.example.invoiceokayo.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Long id, Client client) {

        try {
            final Client clientTemp = clientRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
            clientTemp.setCodeClient(client.getCodeClient());
            clientTemp.setAdresses((ArrayList<Adresse>) client.getAdresses());
            clientTemp.setFactures((ArrayList<Facture>) client.getFactures());
            clientTemp.setNom(client.getNom());

            clientRepository.save(clientTemp);

        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Collection<Client> getClients() {
        return clientRepository.findAll();
    }

}
