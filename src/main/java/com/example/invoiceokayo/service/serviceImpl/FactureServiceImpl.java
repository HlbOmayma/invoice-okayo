package com.example.invoiceokayo.service.serviceImpl;

import com.example.invoiceokayo.model.Facture;
import com.example.invoiceokayo.model.LigneDeFacture;
import com.example.invoiceokayo.repository.FactureRepository;
import com.example.invoiceokayo.service.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class FactureServiceImpl implements IFactureService {
    @Autowired
    private FactureRepository factureRepository;

    @Override
    public void createFacture(Facture facture) {
        factureRepository.save(facture);
    }

    @Override
    public void updateFacture(Long id, Facture facture) {
        try {
            final Facture factureTemp = factureRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
            factureTemp.setClient(facture.getClient());
            factureTemp.setDateFacturation(facture.getDateFacturation());
            factureTemp.setLignesDeFacture((ArrayList<LigneDeFacture>) facture.getLignesDeFacture());
            factureTemp.setDevise(facture.getDevise());
            factureTemp.setTotalTTC(facture.getTotalTTC());
            factureTemp.setTotalHT(facture.getTotalHT());
            factureTemp.setDateEcheance(facture.getDateEcheance());
            factureTemp.setReference(facture.getReference());

            factureRepository.save(factureTemp);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public Collection<Facture> getFactures() {
        return factureRepository.findAll();
    }

    /*
    @Override
    public List<LigneDeFacture> updateTotal(Long idFacture){
        System.out.println("wiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"+factureRepository.findById(idFacture).orElseThrow().getLignesDeFacture());
            return factureRepository.findById(idFacture).orElseThrow().getLignesDeFacture();

    }

    */

}
