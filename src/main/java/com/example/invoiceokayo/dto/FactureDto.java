package com.example.invoiceokayo.dto;

import com.example.invoiceokayo.model.Client;
import com.example.invoiceokayo.model.LigneDeFacture;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactureDto {

    private String reference;
    private Date dateFacturation;
    private Date dateEcheance;
    private float totalHT;
    private float totalTTC;
    private String devise;
    private Client client;

    private List<LigneDeFacture> lignesDeFacture = new ArrayList<>();

    /*
    public FactureDTO mapEntity(@Valid Candidate entity) {
        return CandidateDTO.builder()
                .status(entity.getStatus())
                .level(entity.getLevel())
                .businessKey(entity.getBusinessKey())
                .id(entity.getId())
                .userId(entity.getUserId())
                .module(entity.getModule())
                .issueDate(entity.getIssueDate())
                .modifiedDate(entity.getModifiedDate())
                .shortResume(entity.getShortResume())
                .references(mapReferences(entity.getReferences()))
                .skills(mapSkills(entity.getSkills()))
                .education(mapEducations(entity.getEducation()))
                .build();
    }

     */
}
