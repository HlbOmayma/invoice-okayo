package com.example.invoiceokayo.service.serviceImpl;

import com.example.invoiceokayo.model.*;
import com.example.invoiceokayo.repository.SocieteRepository;
import com.example.invoiceokayo.service.ISocieteService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class SocieteServiceImpl implements ISocieteService {

    private SocieteRepository societeRepository;

    @Override
    public void createSociete(Societe societe) {
        societeRepository.save(societe);
    }

    @Override
    public void updateSociete(Long id, Societe societe) {
        try {
            final Societe societeTemp = societeRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
            societeTemp.setAdresses((ArrayList<Adresse>) societe.getAdresses());
            societeTemp.setComptes((ArrayList<CompteBancaire>) societe.getComptes());
            societeTemp.setDomiciliation(societe.getDomiciliation());
            societeTemp.setLogo(societe.getLogo());
            societeTemp.setNom(societe.getNom());
            societeTemp.setPrestations((ArrayList<Prestation>) societe.getPrestations());
            societeTemp.setSiteweb(societe.getSiteweb());
            societeTemp.setTelephone(societe.getTelephone());

            societeRepository.save(societeTemp);

        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteSociete(Long id) {
        societeRepository.deleteById(id);
    }

    @Override
    public Collection<Societe> getSocietes() {
        return societeRepository.findAll();
    }
}
