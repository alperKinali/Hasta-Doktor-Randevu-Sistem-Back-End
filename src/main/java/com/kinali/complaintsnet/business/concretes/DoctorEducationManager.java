package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.DoctorEducationService;
import com.kinali.complaintsnet.core.utilities.*;
import com.kinali.complaintsnet.dataAccess.abstracts.DoctorEducationDao;
import com.kinali.complaintsnet.entities.concretes.DoctorEducation;
import com.kinali.complaintsnet.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorEducationManager implements DoctorEducationService {
    private DoctorEducationDao doctorEducationDao;

    public DoctorEducationManager(DoctorEducationDao doctorEducationDao) {
        this.doctorEducationDao = doctorEducationDao;
    }

    @Override
    public Result add(DoctorEducation doctorEducation) {
        this.doctorEducationDao.save(doctorEducation);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(DoctorEducation doctorEducation) {
        this.doctorEducationDao.save(doctorEducation);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.doctorEducationDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<DoctorEducation>> getAll() {
        return new SuccessDataResult<List<User>>(this.doctorEducationDao.findAll());
    }

    @Override
    public DataResult<DoctorEducation> getById(int id) {
        return new SuccessDataResult<User>(this.doctorEducationDao.getById(id),Messages.dataListed);
    }

    @Override
    public DataResult<DoctorEducation> getByDoctor_Id(int doctorId) {
        return  new SuccessDataResult<DoctorEducation>(this.doctorEducationDao.getByDoctor_Id(doctorId),Messages.dataListed);
    }
}
