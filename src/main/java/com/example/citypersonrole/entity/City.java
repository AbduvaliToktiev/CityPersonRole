package com.example.citypersonrole.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = City.TABLE_NAME)
public class City {

    public static final String TABLE_NAME = "CITIES";
    public static final String SEQ_NAME = TABLE_NAME + "_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "CITY_NAME")
    private String name;

    @Column(name = "CREATED_DATE")
    private Date createDate;

    @Column(name = "POPULATION")
    private Integer population;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "IS_CAPITAL")
    private Boolean isCapital = Boolean.FALSE;
}
