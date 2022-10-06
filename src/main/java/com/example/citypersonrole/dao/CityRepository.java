package com.example.citypersonrole.dao;

import com.example.citypersonrole.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Modifying
    @Transactional
    @Query(value = "update city_person.cities set " +
            "is_capital = :is_capital, " +
            "created_date = current_timestamp, " +
            "city_name = :city_name, " +
            "population = :population " +
            "where id = :id", nativeQuery = true)
    void updateCity(@Param(value = "is_capital") Boolean isCapital,
                    @Param(value = "city_name") String cityName,
                    @Param(value = "population") Integer population,
                    @Param(value = "id") Long id);
}
