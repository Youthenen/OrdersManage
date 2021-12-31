package com.yusael.travels.service;

import com.yusael.travels.entity.City;

import java.util.List;

public interface CityService {
    //page:当前页  //rows:每页显示记录数
    List<City> findByPage(Integer page, Integer rows);

    //查询总跳数
    Integer findTotals();

    //保存省份方法
    void save(City city);

    //删除省份的方法
    void delete(String id);

    //查询省份信息
    City findOne(String id);

    //修改省份信息
    void update(City city);
}
