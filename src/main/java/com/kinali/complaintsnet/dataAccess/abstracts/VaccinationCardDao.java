package com.kinali.complaintsnet.dataAccess.abstracts;

import com.kinali.complaintsnet.entities.concretes.DiseaseHistory;
import com.kinali.complaintsnet.entities.concretes.Patient;
import com.kinali.complaintsnet.entities.concretes.VaccinationCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccinationCardDao extends JpaRepository<VaccinationCard,Integer> {

    List<VaccinationCard> getByPatientRegistiration_Id(int patientRegistirationId);
}
