package com.kinali.complaintsnet.core.services;

import com.kinali.complaintsnet.entities.concretes.Doctor;
import com.kinali.complaintsnet.entities.concretes.Patient;

public interface MernisService {
    public boolean ifRealPerson(Patient patient) throws Exception;
}
