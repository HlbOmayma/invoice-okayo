package com.example.invoiceokayo.controller;

import com.example.invoiceokayo.model.Adresse;
import com.example.invoiceokayo.service.IAdresseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adresse")
@AllArgsConstructor
public class AdresseController {
    
    private IAdresseService adresseService;

    @GetMapping(value = "/list")
    public List<Adresse> findAll() {
        return (List<Adresse>) adresseService.getAdresses();
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody Adresse adresse){
        adresseService.createAdresse(adresse);
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable Long id, Adresse adresse){
        adresseService.updateAdresse(id, adresse);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        adresseService.deleteAdresse(id);
    }
}
