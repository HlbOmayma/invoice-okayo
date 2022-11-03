package com.example.invoiceokayo.controller;

import com.example.invoiceokayo.model.LigneDeFacture;
import com.example.invoiceokayo.service.ILigneDeFactureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ligne-de-facture")
@AllArgsConstructor
public class LigneDeFactureController {
    
    private ILigneDeFactureService ligneDeFactureService;

    @GetMapping(value = "/list")
    public List<LigneDeFacture> findAll() {
        return (List<LigneDeFacture>) ligneDeFactureService.getLignesDeFactures();
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody LigneDeFacture ligneDeFacture){
        ligneDeFactureService.createLigneDeFacture(ligneDeFacture);
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable Long id, LigneDeFacture ligneDeFacture){
        ligneDeFactureService.updateLigneDeFacture(id, ligneDeFacture);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        ligneDeFactureService.deleteLigneDeFacture(id);
    }
}
