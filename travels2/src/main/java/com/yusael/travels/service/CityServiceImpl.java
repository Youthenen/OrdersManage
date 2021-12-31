package com.yusael.travels.service;

import com.yusael.travels.dao.CityDAO;
import com.yusael.travels.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Override
    public List<City> findByPage(Integer page, Integer rows) {
        // 传入的是当前页数, 以及页面显示的数量
        // 所以要根据这两个参数计算从mysql中查询数据要从第几行开始查几条
        int start = (page - 1) * rows; // 计算要查询的数据是从第几条数据开始的
        return cityDAO.findByPage(start, rows);
    }

    @Override
    public City findOne(String id) {
        return cityDAO.findOne(id);
    }

    @Override
    public void update(City city) {
        cityDAO.update(city);
    }

    @Override
    public void delete(String id) {
        cityDAO.delete(id);
    }

    @Override
    public void save(City city) {
        city.setPlacecounts(0); //景点个数为零
        cityDAO.save(city);
    }

    @Override
    public Integer findTotals() {
        return cityDAO.findTotals();
    }
}
