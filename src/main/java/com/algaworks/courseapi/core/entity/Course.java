package com.algaworks.courseapi.core.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import com.algaworks.courseapi.core.enums.CourseLevelEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "nivel")
    private CourseLevelEnum level;

    @Column(name = "nm_curso")
    private String name;

    @Column(name = "ds_curso")
    private String description;

    @Column(name = "preco_original")
    private Double originalPrice;

    @Column(name = "preco_promocional")
    private Double promotionalPrice;

    @Column(name = "porc_desconto")
    private Double percentageDiscount;

    @Column(name = "url_imagem")
    private String imageUrl;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Module> modules;

}
