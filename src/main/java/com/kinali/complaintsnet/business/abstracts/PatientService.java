package com.kinali.complaintsnet.business.abstracts;

import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.Patient;

public interface PatientService extends BaseEntityService<Patient>{
    DataResult<Patient> getByIdentityNumber(String identityNumber);
    Result register(Patient patient) throws Exception;
    Result login(String eMail, String passwordAgain) throws Exception;


}
