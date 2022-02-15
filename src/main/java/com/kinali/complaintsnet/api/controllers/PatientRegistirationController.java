package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.PatientRegistirationService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.PatientRegistiration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patientregistiration")
@CrossOrigin
public class PatientRegistirationController {
    private PatientRegistirationService patientRegistirationService;

    @Autowired
    public PatientRegistirationController(PatientRegistirationService patientRegistirationService) {
        this.patientRegistirationService = patientRegistirationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody PatientRegistiration patientRegistiration){
        return this.patientRegistirationService.add(patientRegistiration);
    }

    @PutMapping("/update")
    public Result update(@RequestBody PatientRegistiration patientRegistiration){
        return this.patientRegistirationService.update(patientRegistiration);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.patientRegistirationService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<PatientRegistiration>> getAll(){
        return this.patientRegistirationService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<PatientRegistiration> getById(int id){
        return this.patientRegistirationService.getById(id);
    }

    @GetMapping("/getbypatientid")
    public DataResult<List<PatientRegistiration>> getByPatient_Id(int patientId){
        return this.patientRegistirationService.getByPatient_Id(patientId);
    }

}
