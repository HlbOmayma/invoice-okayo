package com.example.invoiceokayo.service.serviceImpl;

import com.example.invoiceokayo.model.CompteBancaire;
import com.example.invoiceokayo.repository.CompteBancaireRepository;
import com.example.invoiceokayo.service.ICompteBancaireService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CompteBancaireServiceImpl implements ICompteBancaireService {

    private CompteBancaireRepository compteBancaireRepository;

    @Override
    public void createCompteBancaire(CompteBancaire compteBancaire) {
        compteBancaireRepository.save(compteBancaire);
    }

    @Override
    public void updateCompteBancaire(Long id, CompteBancaire compteBancaire) {
        try {
            final CompteBancaire compteBancaireTemp = compteBancaireRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            compteBancaireTemp.setDomiciliation(compteBancaire.getDomiciliation());
            compteBancaireTemp.setIban(compteBancaire.getIban());
            compteBancaireTemp.setBicSwift(compteBancaire.getBicSwift());
            compteBancaireTemp.setSociete(compteBancaire.getSociete());
            compteBancaireTemp.setProprietaire(compteBancaire.getProprietaire());

            compteBancaireRepository.save(compteBancaireTemp);

        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCompteBancaire(Long id) {
        compteBancaireRepository.deleteById(id);
    }

    @Override
    public Collection<CompteBancaire> getCompteBancaires() {
        return compteBancaireRepository.findAll();
    }
}
