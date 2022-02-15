package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.PatientValidService;
import com.kinali.complaintsnet.core.business.BusinessRules;
import com.kinali.complaintsnet.core.utilities.ErrorResult;
import com.kinali.complaintsnet.core.utilities.Messages;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.core.utilities.SuccessResult;
import com.kinali.complaintsnet.entities.concretes.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientValidManager implements PatientValidService {
    @Override
    public Result validate(Patient patient) throws Exception {
        Result[] results= BusinessRules.run(
                checkFirstNameNotNull(patient.getFirstName()),
                checkLastNameNotNull(patient.getLastName()),
                checkNationalIdNotNull(patient.getIdentityNumber()),
                checkAgeOfYearNotNull(patient.getAgeOfYear()),
                checkEmailNotNull(patient.getEmail()),
                checkPasswordNotNull(patient.getPassword())
        );
        for (Result result:results){
            if(!result.isSuccess()){
                return result;
                // doğru olan result değerlerini success içerisinden
                // dönülmesi sağlandı
            }
        }
        return new SuccessResult();
    }


// string değerler için null
    // int değerler için ise 0 olması kontrol edilerek
    // çeşitli mesajlar kullanıcıya gösteriliyor.

    private Result checkFirstNameNotNull(String firstName) {
        if (firstName==null){
            return new ErrorResult(Messages.firstNameNotNull);
            // bu bir result gödermektedir.

        }
        return new SuccessResult();
    }
    private Result checkLastNameNotNull(String lastName) {
        if (lastName==null){
            return new ErrorResult(Messages.lastNameNotNull);
        }
        return new SuccessResult();
    }
    private Result checkNationalIdNotNull(String identityNumber) {
        if (identityNumber==null){
            return new ErrorResult(Messages.lastNameNotNull);
        }
        return new SuccessResult();
    }
    private Result checkAgeOfYearNotNull(int ageOfYear) {
        if (ageOfYear==0){
            return  new ErrorResult(Messages.yearOfBirtNotNull);
        }
        return new SuccessResult();
    }
    private Result checkEmailNotNull(String email) {
        if (email==null){
            return new ErrorResult(Messages.emailNotNull);
        }
        return new SuccessResult();
        // hata oluşmass ise yeni bir başarı mesajı gösterilir.

    }

    private Result checkPasswordNotNull(String password) {
        if (password==null){
            return  new ErrorResult(Messages.passwordNotNull);
        }
        return new SuccessResult();
    }
}
