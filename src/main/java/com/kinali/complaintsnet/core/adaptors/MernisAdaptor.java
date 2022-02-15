package com.kinali.complaintsnet.core.adaptors;

import com.kinali.complaintsnet.core.services.MernisService;
import com.kinali.complaintsnet.entities.concretes.Doctor;
import com.kinali.complaintsnet.entities.concretes.Patient;

import com.kinali.complaintsnet.mernis.ORVKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class MernisAdaptor implements MernisService {
    @Override
    public boolean ifRealPerson(Patient patient) throws Exception {
        ORVKPSPublicSoap soap =new ORVKPSPublicSoap();
        return soap.TCKimlikNoDogrula(Long.parseLong(patient.getIdentityNumber()),patient.getFirstName(),patient.getLastName(),patient.getAgeOfYear());
    }
}
