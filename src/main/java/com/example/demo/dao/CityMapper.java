package com.example.demo.dao;

import com.example.demo.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("select id,name,state,country  from city where state = #{state}")
    City findByState(String state);
}
