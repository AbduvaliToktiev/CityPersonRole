package com.example.citypersonrole.controller;

import com.example.citypersonrole.entity.City;
import com.example.citypersonrole.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping(value = "/saveCity")
    public String save(@RequestBody City city) {
        city.setCreateDate(new Date());
        this.cityService.save(city);
        return "SUCCESS!";
    }

    @DeleteMapping(value = "/deleteCity")
    public String delete(@RequestParam(name = "id") Long id) {
        try {
            this.cityService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "FAILED!";
        }
        return "SUCCESS!";
    }

    @GetMapping(value = "/getAllCity")
    public List<City> cityList() {
       return this.cityService.cityList();
    }

    @PutMapping(value = "/updateCity/{isCapital}/{cityName}/{population}/{id}")
    public String updateCity(@PathVariable Boolean isCapital,
                             @PathVariable String cityName,
                             @PathVariable Integer population,
                             @PathVariable Long id) {
        try {
            this.cityService.updateCity(isCapital, cityName, population, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "FAILED!";
        }
        return "SUCCESS!";
    }
}
