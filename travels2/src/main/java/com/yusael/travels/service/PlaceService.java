package com.yusael.travels.service;

import com.yusael.travels.entity.Place;

import java.util.List;

public interface PlaceService {

    List<Place> findByCityIdPage(Integer page, Integer rows, String cityId);

    Integer findByCityIdCounts(String cityId);

    void save(Place place);

    void delete(String id);

    Place findOne(String id);

    void update(Place place);
}
