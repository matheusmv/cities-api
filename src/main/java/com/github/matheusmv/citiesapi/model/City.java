package com.github.matheusmv.citiesapi.model;

import com.github.matheusmv.citiesapi.model.util.PointType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
@TypeDefs({
        @TypeDef(name = "point", typeClass = PointType.class)
})
@NoArgsConstructor
@Getter
public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    private String ibge;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;
}
