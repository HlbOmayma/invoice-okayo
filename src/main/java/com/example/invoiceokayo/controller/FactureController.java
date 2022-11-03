package com.example.invoiceokayo.controller;

import com.example.invoiceokayo.model.Facture;
import com.example.invoiceokayo.model.LigneDeFacture;
import com.example.invoiceokayo.service.IFactureService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/facture")
@AllArgsConstructor
public class FactureController {

    private IFactureService factureService;

    @GetMapping(value = "/list")
    public List<Facture> findAll() {
        return (List<Facture>) factureService.getFactures();
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody Facture facture){
        //new Facture(1L,"ABC",new Date(),new Date(),147.2f,100.3f,"EUR",null,null)
        factureService.createFacture(facture);
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable Long id, Facture facture){
        factureService.updateFacture(id, facture);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        factureService.deleteFacture(id);
    }
/*
    @GetMapping(value = "/lignes/{id}")
    public List<LigneDeFacture> getLignes(@PathVariable Long id){
        return factureService.updateTotal(id);
    }

 */
}
