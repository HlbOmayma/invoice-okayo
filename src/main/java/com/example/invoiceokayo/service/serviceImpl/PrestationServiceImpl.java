package com.example.invoiceokayo.service.serviceImpl;

import com.example.invoiceokayo.model.*;
import com.example.invoiceokayo.repository.PrestationRepository;
import com.example.invoiceokayo.service.IPrestationService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class PrestationServiceImpl implements IPrestationService {

    public PrestationRepository prestationRepository;

    @Override
    public void createPrestation(Prestation prestation) {
        prestationRepository.save(prestation);
    }

    @Override
    public void updatePrestation(Long id, Prestation prestation) {
        try {
            final Prestation prestationTemp = prestationRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
            prestationTemp.setDesignation(prestation.getDesignation());
            prestationTemp.setLignesDeFacture((ArrayList<LigneDeFacture>) prestation.getLignesDeFacture());
            prestationTemp.setTva(prestation.getTva());
            prestationTemp.setSociete(prestation.getSociete());
            prestationTemp.setPrixUnitaireHT(prestation.getPrixUnitaireHT());

            prestationRepository.save(prestationTemp);

        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePrestation(Long id) {
        prestationRepository.deleteById(id);
    }

    @Override
    public Collection<Prestation> getPrestations() {
        return prestationRepository.findAll();
    }
}
