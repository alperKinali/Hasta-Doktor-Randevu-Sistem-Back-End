package com.kinali.complaintsnet.dataAccess.abstracts;

import com.kinali.complaintsnet.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
    // bu kısma bir şey yazmamıza gererk yok !!

}
