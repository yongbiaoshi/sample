package com.my.sample.controller;

import com.my.sample.dao.repository.CarLocationRepository;
import com.my.sample.entity.document.CarLocation;
import org.springframework.data.domain.Range;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("location")
public class CarLocationController {

    @Resource
    CarLocationRepository carLocationRepository;

    @GetMapping("near")
    public GeoResults<CarLocation> findCar(double lon, double lat) {
        Range.Bound<Distance> min = Range.Bound.inclusive(new Distance(5, Metrics.KILOMETERS));
        Range.Bound<Distance> max = Range.Bound.inclusive(new Distance(10, Metrics.KILOMETERS));

        Range<Distance> range = Range.of(min, max);
        return carLocationRepository.findByLocationNear(new Point(lon, lat), range);
    }
}
