package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.DoctorService;
import com.kinali.complaintsnet.business.abstracts.DoctorValidService;
import com.kinali.complaintsnet.core.utilities.*;
import com.kinali.complaintsnet.dataAccess.abstracts.DoctorDao;
import com.kinali.complaintsnet.entities.concretes.Doctor;
import com.kinali.complaintsnet.entities.concretes.Patient;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorManager implements DoctorService {

    private DoctorDao doctorDao;
    private DoctorValidService doctorValidService;

    @Autowired
    public DoctorManager(DoctorDao doctorDao, DoctorValidService doctorValidService) {
        this.doctorDao = doctorDao;
        this.doctorValidService = doctorValidService;
    }

    @Override
    public Result register(Doctor doctor) throws Exception {
        List<Doctor> doctors = this.doctorDao.findAll();
        if (checkIfUserExist(doctors,doctor).isSuccess()){
            if (this.doctorValidService.validate(doctor).isSuccess()){
                this.doctorDao.save(doctor);
                return new SuccessResult(Messages.registrationIsSuccessful);
            }
            return this.doctorValidService.validate(doctor);
        }
        return checkIfUserExist(doctors, doctor);
    }

    @Override
    public Result login(String eMail, String passwordAgain) throws Exception {
        List<Doctor> doctors =this.doctorDao.findAll();
        // öncelikle hasta kullanıcıları getirilmekte
        for (Doctor dbDoctor:doctors){
            if (dbDoctor.getEmail().equals(eMail)){
                // ilk email bakıldı
                if (dbDoctor.getPassword().equals(passwordAgain)){
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
    public Result add(Doctor doctor) {
        this.doctorDao.save(doctor);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Doctor doctor) {
        this.doctorDao.save(doctor);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.doctorDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Doctor>> getAll() {
        return new SuccessDataResult<List<Doctor>>(this.doctorDao.findAll(),Messages.dataListed);
    }

    @Override
    public DataResult<Doctor> getById(int id) {
        return new SuccessDataResult<Doctor>(this.doctorDao.getById(id),Messages.dataListed);
    }

    private Result checkIfUserExist(List<Doctor> doctors, Doctor checkDoctor)
    {
        for (Doctor doctor:doctors){
            if (doctor.getEmail().equals(checkDoctor.getEmail())){
                return new ErrorResult(Messages.registeredEmail);
            }
        }
        return new SuccessResult();

    }

}
