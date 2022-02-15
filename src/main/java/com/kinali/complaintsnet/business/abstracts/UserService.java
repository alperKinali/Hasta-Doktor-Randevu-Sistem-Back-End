package com.kinali.complaintsnet.business.abstracts;

import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService extends BaseEntityService<User> {
    DataResult<User> getByEmail(String email);

}
