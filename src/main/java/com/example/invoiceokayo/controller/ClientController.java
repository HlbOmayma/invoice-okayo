package com.example.invoiceokayo.controller;

import com.example.invoiceokayo.model.Client;
import com.example.invoiceokayo.model.Facture;
import com.example.invoiceokayo.service.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/client")
@AllArgsConstructor
public class ClientController {

    private IClientService clientService;

    @PostMapping(value = "/add")
    public void create(@RequestBody Client client){
        clientService.createClient(client);
        //clientService.createClient(new Client(4L,"12365","XXX",null,null));
    }

    @GetMapping(value = "/list")
    public List<Client> findAll() {
        return  (List<Client>) clientService.getClients();
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable Long id, Client client){
        clientService.updateClient(id, client);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        clientService.deleteClient(id);
    }
}
