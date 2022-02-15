package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.MedicationsService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.Medications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
@CrossOrigin
public class MedicationsController {
    private MedicationsService medicationsService;

    @Autowired
    public MedicationsController(MedicationsService medicationsService) {
        this.medicationsService = medicationsService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody Medications education){
        return this.medicationsService.add(education);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Medications education){
        return this.medicationsService.update(education);
    }
    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.medicationsService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Medications>> getAll(){
        return this.medicationsService.getAll();
    }
    @GetMapping("/getbyid")
    public DataResult<Medications> getById(int id){
        return this.medicationsService.getById(id);
    }
    @GetMapping("/getebypatientregistirationpatientid")
    public DataResult<List<Medications>> getByPatientRegistiration_Patient_Id(int patientId){
        return this.medicationsService.getByPatientRegistiration_Patient_Id(patientId);
    }




}
