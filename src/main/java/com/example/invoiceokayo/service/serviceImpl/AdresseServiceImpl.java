package com.example.invoiceokayo.service.serviceImpl;

import com.example.invoiceokayo.model.Adresse;
import com.example.invoiceokayo.repository.AdresseRepository;
import com.example.invoiceokayo.service.IAdresseService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class AdresseServiceImpl implements IAdresseService {

    private AdresseRepository adresseRepository;

    @Override
    public void createAdresse(Adresse adresse) {
        adresseRepository.save(adresse);
    }

    @Override
    public void updateAdresse(Long id, Adresse adresse) {
        try {
            final Adresse adresseTemp = adresseRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            adresseTemp.setEntite(adresse.getEntite());
            adresseTemp.setRue(adresse.getRue());
            adresseTemp.setNumero(adresse.getNumero());
            adresseTemp.setVille(adresse.getVille());
            adresseTemp.setCodePostal(adresse.getCodePostal());

            adresseRepository.save(adresseTemp);

        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAdresse(Long id) {
        adresseRepository.deleteById(id);
    }

    @Override
    public Collection<Adresse> getAdresses() {
        return adresseRepository.findAll();
    }
}
