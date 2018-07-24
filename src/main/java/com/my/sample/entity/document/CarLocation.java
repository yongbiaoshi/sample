package com.my.sample.entity.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "car_location")
public class CarLocation {

    @Id
    private String id;

    /**
     * 车辆id
     */
    @Indexed(unique = true, name = "uk_carId")
    private Long carId;

    /**
     * 经纬度（x、y）
     */
    @GeoSpatialIndexed(name = "geo_2d_location", type = GeoSpatialIndexType.GEO_2DSPHERE)
    private Double[] location;

    /**
     * 高度
     */
    private Double altitude;

    /**
     * 速度
     */
    private Double speed;

    /**
     * 方向
     */
    private Integer direction;

    /**
     * 设备上报时间
     */
    private Date statusTime;

    /**
     * 创建时间
     */
    @LastModifiedDate
    private Date lastUpdateTime;
}
