package com.kinali.complaintsnet.business.abstracts;

import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.entities.concretes.DiseaseHistory;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface DiseaseHistoryService extends BaseEntityService<DiseaseHistory>{

    DataResult<List<DiseaseHistory>> getByPatientRegistiration_Id(int patientRegistirationId);



}
