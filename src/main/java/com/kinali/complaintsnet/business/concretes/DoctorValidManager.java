package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.DoctorValidService;
import com.kinali.complaintsnet.core.business.BusinessRules;
import com.kinali.complaintsnet.core.utilities.ErrorResult;
import com.kinali.complaintsnet.core.utilities.Messages;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.core.utilities.SuccessResult;
import com.kinali.complaintsnet.entities.concretes.Doctor;
import org.springframework.stereotype.Service;

@Service
public class DoctorValidManager implements DoctorValidService {

    @Override
    public Result validate(Doctor doctor) throws Exception {
        Result[] results = BusinessRules.run(
                checkFirstNameNotNull(doctor.getFirstName()),
                checkLastNameNotNull(doctor.getLastName()),
                checkEmailNotNull(doctor.getEmail()),
                checkPasswordNotNull(doctor.getPassword()),
                checkHospitalNameNotNull(doctor.getHospitalName()),
                checkHospitalAddressNotNull(doctor.getHospitalAddress()),
                checKDoctorDegreeNotNull(doctor.getDoctorDegree()),
                checkDoctorTittleNotNull(doctor.getDoctorTitle())
        );

        for (Result result : results) {
            if (!result.isSuccess()) {
                return result;
                // doğru olan result değerlerini success içerisinden
                // dönülmesi sağlandı
            }
        }
        return new SuccessResult();
    }

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
    private Result checkDoctorTittleNotNull(String doctorTitle) {
        if (doctorTitle==null){
            return new ErrorResult(Messages.DoctorTittleNotNull);
        }
        return new SuccessResult();
    }

    private Result checKDoctorDegreeNotNull(String doctorDegree) {
        if (doctorDegree==null){
            return new ErrorResult(Messages.DoctorDegreeNotNull);

        }
        return new SuccessResult();
    }

    private Result checkHospitalNameNotNull(String hospitalName) {
        if (hospitalName==null){
            return new ErrorResult(Messages.HospitalNameNotNull);
        }
        return new SuccessResult();
    }

    private Result checkHospitalAddressNotNull(String hospitalAddress){
        if (hospitalAddress==null){
            return new ErrorResult(Messages.HospitalAddressNotNull);
        }
        return new SuccessResult();

    }
}
