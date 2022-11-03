package com.example.invoiceokayo.controller;

import com.example.invoiceokayo.model.Prestation;
import com.example.invoiceokayo.service.IPrestationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/prestation")
@AllArgsConstructor
public class PrestationController {

    private IPrestationService prestationService;

    @GetMapping(value = "/list")
    public List<Prestation> findAll() {
        return (List<Prestation>) prestationService.getPrestations();
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody Prestation prestation){
        prestationService.createPrestation(prestation);
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable Long id, Prestation prestation){
        prestationService.updatePrestation(id, prestation);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        prestationService.deletePrestation(id);
    }
}
