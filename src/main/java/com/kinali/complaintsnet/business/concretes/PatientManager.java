package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.PatientService;
import com.kinali.complaintsnet.business.abstracts.PatientValidService;
import com.kinali.complaintsnet.core.services.MernisService;
import com.kinali.complaintsnet.core.utilities.*;
import com.kinali.complaintsnet.dataAccess.abstracts.PatientDao;
import com.kinali.complaintsnet.entities.concretes.Patient;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientManager implements PatientService {

    private PatientDao patientDao;
    private PatientValidService patientValidService;
    private MernisService mernisService;


    // bu anotasyon ile otomatik larak new ledik
    @Autowired
    public  PatientManager(PatientDao patientDao,PatientValidService patientValidService,MernisService mernisService){
        this.patientDao=patientDao;
        this.patientValidService=patientValidService;
        this.mernisService=mernisService;
    }

    // iki çeşit kayıt işlemi olacak
    // ilk olarak doktorlar için
    // ikinci olarak ise kullanıcılar için
    // ilk olarak kullanıcılar için olan kayıt işlemi
    @Override
    public Result register(Patient patient)throws  Exception{
        List<Patient> patients=this.patientDao.findAll();
        if (this.mernisService.ifRealPerson(patient)){
            // eğer seçili kullanıcımernis servisine göre gerçek bir kullanıcı ise
            if (checkIfUserExist(patients, patient).isSuccess()){
                if (this.patientValidService.validate(patient).isSuccess()){
                    // eğer seçili hasta mernis listesinin içerisinde ki servis de
                    // mevcut ise hasta sisteme kayıt ediliyor.
                    this.patientDao.save(patient);
                    // eğer değerler doğru ise burada save işlemi yaptı
                    return new SuccessResult(Messages.registrationIsSuccessful);
                }
                return this.patientValidService.validate(patient);
            }
            return checkIfUserExist(patients, patient);
        }
        return new ErrorResult(Messages.informationIsIncorrect);
    }
    // kullanıcı kaydı oluşturulurken
    @Override
    public Result login(String eMail, String passwordAgain) throws Exception{
        List<Patient> patients =this.patientDao.findAll();
        // öncelikle hasta kullanıcıları getirilmekte
        for (Patient dbPatient:patients){
            if (dbPatient.getEmail().equals(eMail)){
                // ilk email bakıldı
                if (dbPatient.getPassword().equals(passwordAgain)){
                    // hasta kullanıcısı için em şifre doğru ise
                    // hemde e mail doğru ise
                    // sisteme giriş sağlanır.
                    return new SuccessResult(Messages.loginIsSuccessful);
                }
            }
        }
        return new ErrorResult(Messages.informationIsIncorrect);
    }




    @Override
    public Result add(Patient patient) {
        this.patientDao.save(patient);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Patient patient) {
        this.patientDao.save(patient);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.patientDao.deleteById(id);
        return new SuccessResult("Kayıt silindi.");

    }

    @Override
    public DataResult<List<Patient>> getAll() {
        return new SuccessDataResult<List<Patient>>(this.patientDao.findAll(), "data listelendi");
    }

    @Override
    public DataResult<Patient> getById(int id) {
        return new SuccessDataResult<Patient>(this.patientDao.getById(id), "data listelendi");
    }


    @Override
    public DataResult<Patient> getByIdentityNumber(String identityNumber) {
        return new SuccessDataResult<Patient>(this.patientDao.getByIdentityNumber(identityNumber));
    }
    private Result checkIfUserExist(List<Patient> patients, Patient checkPatient)
    {
        for (Patient patient:patients){
            if (patient.getEmail().equals(checkPatient.getEmail())){
                return new ErrorResult(Messages.registeredEmail);
            }
            if (patient.getIdentityNumber().equals(checkPatient.getIdentityNumber())){
                return new ErrorResult(Messages.registeredID);
            }

        }
        return new SuccessResult();

    }
}
