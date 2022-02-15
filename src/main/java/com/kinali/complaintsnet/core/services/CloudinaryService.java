package com.kinali.complaintsnet.core.services;

import com.kinali.complaintsnet.core.utilities.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface CloudinaryService {
    DataResult<?> upload(File file);

    DataResult<?> delete(String publicIdOfImage);
}
