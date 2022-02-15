package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.ImageService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin
public class ImageController {
    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Image image){
        return this.imageService.add(image);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Image image){
        return this.imageService.update(image);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.imageService.delete(id);
    }
    @PostMapping("/upload")
    public Result upload(int userId, @RequestBody File file){
        return this.imageService.upload(userId,file);
    }
    @GetMapping("/getall")
    public DataResult<List<Image>> getAll(){
        return this.imageService.getAll();
    }
    @GetMapping("/getbyid")
    public DataResult<Image> getById(int id){
        return this.imageService.getById(id);
    }
    @GetMapping("/getbyuserid")
    public DataResult<List<Image>> getByUser_Id(int userId){
        return this.imageService.getByUser_Id(userId);
    }

}
