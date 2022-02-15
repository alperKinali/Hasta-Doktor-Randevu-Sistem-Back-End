package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.DoctorEducationService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.DoctorEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/api/doctoreducation")
@CrossOrigin
public class DoctorEducationController {
    private DoctorEducationService doctorEducationService;

    @Autowired
    public DoctorEducationController(DoctorEducationService doctorEducationService) {
        this.doctorEducationService = doctorEducationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody DoctorEducation doctorEducation){
        return this.doctorEducationService.add(doctorEducation);

    }

    @PutMapping("/update")
    public Result update(@RequestBody DoctorEducation doctorEducation){
        return  this.doctorEducationService.update(doctorEducation);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.doctorEducationService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<DoctorEducation>> getAll(){
        return this.doctorEducationService.getAll();

    }

    @GetMapping("/getbyid")
    DataResult<DoctorEducation> getById(int id){
        return this.doctorEducationService.getById(id);
    }
    @GetMapping("getbydoctorid")
    public DataResult<DoctorEducation> getByDoctor_Id(int doctorId){
        return this.doctorEducationService.getByDoctor_Id(doctorId);
    }


}
