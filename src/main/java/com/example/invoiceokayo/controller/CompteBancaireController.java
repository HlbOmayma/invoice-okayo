package com.example.invoiceokayo.controller;

import com.example.invoiceokayo.model.CompteBancaire;
import com.example.invoiceokayo.service.ICompteBancaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/compte-bancaire")
@AllArgsConstructor
public class CompteBancaireController {
    
    private ICompteBancaireService compteBancaireService;

    @GetMapping(value = "/list")
    public List<CompteBancaire> findAll() {
        return (List<CompteBancaire>) compteBancaireService.getCompteBancaires();
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody CompteBancaire compteBancaire){
        compteBancaireService.createCompteBancaire(compteBancaire);
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable Long id, CompteBancaire compteBancaire){
        compteBancaireService.updateCompteBancaire(id, compteBancaire);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        compteBancaireService.deleteCompteBancaire(id);
    }
}
