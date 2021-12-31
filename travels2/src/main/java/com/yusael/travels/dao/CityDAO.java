package com.yusael.travels.dao;

import com.yusael.travels.entity.City;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CityDAO extends BaseDAO<City, String> {
}
