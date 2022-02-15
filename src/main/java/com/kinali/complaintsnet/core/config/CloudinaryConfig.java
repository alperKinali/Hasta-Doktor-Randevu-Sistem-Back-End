package com.kinali.complaintsnet.core.config;

import com.cloudinary.utils.ObjectUtils;
import com.kinali.complaintsnet.core.adaptors.CloudinaryAdaptor;
import com.kinali.complaintsnet.core.services.CloudinaryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.*;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinaryAccount() {
        return new Cloudinary(ObjectUtils.asMap(
               // gerekli bilgiler
        ));
    }

    @Bean
    public CloudinaryService cloudinaryService() {
        return new CloudinaryAdaptor(cloudinaryAccount());
    }

}
