package com.example.invoiceokayo.service.serviceImpl;

import com.example.invoiceokayo.model.Facture;
import com.example.invoiceokayo.model.LigneDeFacture;
import com.example.invoiceokayo.repository.FactureRepository;
import com.example.invoiceokayo.repository.LigneDeFactureRepository;
import com.example.invoiceokayo.service.ILigneDeFactureService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class LigneDeFactureImpl implements ILigneDeFactureService {

    private LigneDeFactureRepository ligneDeFactureRepository;
    private FactureRepository factureRepository;

    @Override
    public void createLigneDeFacture(LigneDeFacture ligneDeFacture) {
        ligneDeFacture.setTotalHT(ligneDeFacture.getPrixUnitaire()*ligneDeFacture.getQuantite());
        ligneDeFactureRepository.save(ligneDeFacture);
        try{
            Facture facturetemp =  factureRepository.findById(ligneDeFacture.getFacture().getId()).orElseThrow(ChangeSetPersister.NotFoundException::new);

        }catch(ChangeSetPersister.NotFoundException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateLigneDeFacture(Long id, LigneDeFacture ligneDeFacture) {
        try {
            final LigneDeFacture ligneDeFactureTemp = ligneDeFactureRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            ligneDeFactureTemp.setFacture(ligneDeFacture.getFacture());
            ligneDeFactureTemp.setDesignation(ligneDeFacture.getDesignation());
            ligneDeFactureTemp.setPrestation(ligneDeFacture.getPrestation());
            ligneDeFactureTemp.setQuantite(ligneDeFacture.getQuantite());
            ligneDeFactureTemp.setPrixUnitaire(ligneDeFacture.getPrixUnitaire());
            ligneDeFactureTemp.setTva(ligneDeFacture.getTva());
            ligneDeFactureTemp.setTotalHT(ligneDeFacture.getPrixUnitaire()*ligneDeFacture.getQuantite());

            ligneDeFactureRepository.save(ligneDeFactureTemp);

        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteLigneDeFacture(Long id) {
        ligneDeFactureRepository.deleteById(id);
    }

    @Override
    public Collection<LigneDeFacture> getLignesDeFactures() {
        return ligneDeFactureRepository.findAll();
    }
}
