package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.ComplaintService;
import com.kinali.complaintsnet.core.utilities.*;
import com.kinali.complaintsnet.dataAccess.abstracts.ComplaintDao;
import com.kinali.complaintsnet.entities.concretes.Complaint;
import com.kinali.complaintsnet.entities.concretes.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintManager implements ComplaintService {
    private ComplaintDao complaintDao;

    @Autowired
    public ComplaintManager(ComplaintDao complaintDao){
        this.complaintDao=complaintDao;
    }
    @Override
    public Result add(Complaint complaint) {
        this.complaintDao.save(complaint);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Complaint complaint) {
        this.complaintDao.save(complaint);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.complaintDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Complaint>> getAll() {
        return new SuccessDataResult<List<Complaint>>(this.complaintDao.findAll(),Messages.dataListed);
    }

    @Override
    public DataResult<Complaint> getById(int id) {
        return new SuccessDataResult<Complaint>(this.complaintDao.getById(id), Messages.dataListed);
    }
}
