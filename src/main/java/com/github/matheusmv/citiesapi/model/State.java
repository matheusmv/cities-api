package com.github.matheusmv.citiesapi.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "estado")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@NoArgsConstructor
@Getter
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    @ManyToOne
    @JoinColumn(
            name = "pais",
            referencedColumnName = "id"
    )
    private Country country;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(
            name = "ddd",
            columnDefinition = "jsonb"
    )
    private List<Integer> ddd;
}
