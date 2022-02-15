package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.DiseaseHistoryService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.DiseaseHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diseasehistory")
@CrossOrigin
public class DiseaseHistoryController {

    private DiseaseHistoryService diseaseHistoryService;

    @Autowired
    public DiseaseHistoryController(DiseaseHistoryService diseaseHistoryService) {
        this.diseaseHistoryService = diseaseHistoryService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody DiseaseHistory diseaseHistory){
        return this.diseaseHistoryService.add(diseaseHistory);
    }
    @PutMapping("/update")
    public Result update(@RequestBody DiseaseHistory diseaseHistory){
        return this.diseaseHistoryService.update(diseaseHistory);
    }
    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.diseaseHistoryService.delete(id);
    }
    @GetMapping("/getall")
    public DataResult<List<DiseaseHistory>> getAll(){
        return this.diseaseHistoryService.getAll();
    }
    @GetMapping("/getbyid")
    public DataResult<DiseaseHistory> getById(int id){
        return this.diseaseHistoryService.getById(id);
    }
    @GetMapping("/getbypatientregistirationid")
    public DataResult<List<DiseaseHistory>> getByResume_Id(int patientRegistirationId){
        return this.diseaseHistoryService.getByPatientRegistiration_Id(patientRegistirationId);
    }



}
