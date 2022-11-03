package com.example.invoiceokayo.repository;

import com.example.invoiceokayo.model.LigneDeFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneDeFactureRepository extends JpaRepository<LigneDeFacture, Long> {
}
