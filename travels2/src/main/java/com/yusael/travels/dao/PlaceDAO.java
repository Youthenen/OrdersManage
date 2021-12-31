package com.yusael.travels.dao;

import com.yusael.travels.entity.Place;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlaceDAO extends BaseDAO<Place, String> {
    // 根据省份Id 进行分页查询
    List<Place> findByCityIdPage(@Param("start") Integer start, @Param("rows") Integer rows, @Param("cityId") String cityId);
    // 查询总记录条数
    Integer findByCityIdCounts(String cityId);
}
