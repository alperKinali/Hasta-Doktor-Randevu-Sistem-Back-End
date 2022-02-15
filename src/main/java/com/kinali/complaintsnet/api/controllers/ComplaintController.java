package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.ComplaintService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.RecursiveTask;

@RestController
@RequestMapping("/api/complaint")
@CrossOrigin
public class ComplaintController {
    private ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody Complaint complaint){
       return this.complaintService.add( complaint);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Complaint complaint){
        return this.complaintService.update(complaint);

    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.complaintService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Complaint>> getAll(){
        return this.complaintService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Complaint> getById(int id){
        return this.complaintService.getById(id);

    }

}
