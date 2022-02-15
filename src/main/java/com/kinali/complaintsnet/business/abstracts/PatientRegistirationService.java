package com.kinali.complaintsnet.business.abstracts;

import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.entities.concretes.PatientRegistiration;

import java.util.List;

public interface PatientRegistirationService extends BaseEntityService<PatientRegistiration>{

    DataResult<List<PatientRegistiration>> getByPatient_Id(int patientId);
}
