package com.my.sample.dao.repository;

import com.my.sample.entity.document.CarLocation;
import org.springframework.data.domain.Range;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarLocationRepository extends MongoRepository<CarLocation, String> {

    GeoResults<CarLocation> findByLocationNear(Point point, Range<Distance> range);
}
