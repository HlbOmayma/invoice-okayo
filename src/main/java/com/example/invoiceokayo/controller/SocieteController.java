package com.example.invoiceokayo.controller;

import com.example.invoiceokayo.model.Societe;
import com.example.invoiceokayo.service.ISocieteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/societe")
@AllArgsConstructor
public class SocieteController {
    
    private ISocieteService societeService;

    @GetMapping(value = "/list")
    public List<Societe> findAll() {
        return (List<Societe>) societeService.getSocietes();
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody Societe societe){
        societeService.createSociete(societe);
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable Long id, Societe societe){
        societeService.updateSociete(id, societe);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        societeService.deleteSociete(id);
    }
}
