package com.kinali.complaintsnet.dataAccess.abstracts;

import com.kinali.complaintsnet.entities.concretes.DiseaseHistory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseHistoryDao extends JpaRepository<DiseaseHistory, Integer> {

    List<DiseaseHistory> getByPatientRegistiration_Id(int patientRegistirationId);



}
