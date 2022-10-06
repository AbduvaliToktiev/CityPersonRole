package com.example.citypersonrole.service;

import com.example.citypersonrole.dao.CityRepository;
import com.example.citypersonrole.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public void save(City city) {
        this.cityRepository.save(city);
    }

    public void delete(Long id) {
        this.cityRepository.deleteById(id);
    }

    public List<City> cityList() {
        return this.cityRepository.findAll();
    }

    public void updateCity(Boolean isCapital, String cityName, Integer population, Long id) {
        this.cityRepository.updateCity(isCapital, cityName, population, id);
    }
}
