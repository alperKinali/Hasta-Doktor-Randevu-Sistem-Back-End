package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.ImageService;
import com.kinali.complaintsnet.business.abstracts.UserService;
import com.kinali.complaintsnet.core.services.CloudinaryService;
import com.kinali.complaintsnet.core.utilities.*;
import com.kinali.complaintsnet.dataAccess.abstracts.ImageDao;
import com.kinali.complaintsnet.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class ImageManager implements ImageService {
    private ImageDao imageDao;
    private CloudinaryService cloudinaryService;
    private UserService userService;


    @Autowired
    public ImageManager(ImageDao imageDao,CloudinaryService cloudinaryService,UserService userService) {
        this.imageDao = imageDao;
        this.cloudinaryService=cloudinaryService;
        this.userService=userService;
    }

    @Override
    public Result add(Image image) {
        this.imageDao.save(image);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Image image) {
        this.imageDao.save(image);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        Image image = getById(id).getData();
        String[] splitImageUrlArray = image.getUrl().split("/");
        int indexOfExtension = splitImageUrlArray[splitImageUrlArray.length - 1].indexOf(".");
        String publicIdOfImage = splitImageUrlArray[splitImageUrlArray.length - 1].substring(0, indexOfExtension);
        cloudinaryService.delete(publicIdOfImage);
        imageDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<Image> getById(int id) {
        return new SuccessDataResult<Image>(this.imageDao.getById(id), Messages.dataListed);
    }

    @Override
    public Result upload(int userId, File file) {
        Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryService.upload(file).getData();
        Image image = new Image();
        image.setUser(userService.getById(userId).getData());
        image.setUrl(uploadImage.get("url").toString());

        return add(image);
    }

    @Override
    public DataResult<List<Image>> getByUser_Id(int userId) {
        return new SuccessDataResult<List<Image>>(this.imageDao.getByUser_Id(userId),Messages.dataListed);
    }
}
