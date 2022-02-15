package com.kinali.complaintsnet.business.abstracts;

import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.Patient;

public interface PatientValidService {
    Result validate(Patient patient) throws Exception;
}
