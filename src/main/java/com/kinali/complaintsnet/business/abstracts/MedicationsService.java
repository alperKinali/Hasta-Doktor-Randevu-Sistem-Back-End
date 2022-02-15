package com.kinali.complaintsnet.business.abstracts;

import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.entities.concretes.Medications;

import java.util.List;

public interface MedicationsService extends BaseEntityService<Medications>{


    DataResult<List<Medications>> getByPatientRegistiration_Patient_Id(int patientId);
}
