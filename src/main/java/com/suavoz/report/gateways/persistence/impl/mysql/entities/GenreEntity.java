package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.domain.Genre;
import com.suavoz.report.domain.Report;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "TB_GENRE")
@NoArgsConstructor
public class GenreEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<ReportEntity> reportEntities = new ArrayList<>();

    public GenreEntity(Genre genre) {
        id = genre.getId();
        name = genre.getName();
    }

    public Genre toDomain(boolean loadReports) {
        List<Report> reports = loadReports ? reportEntities.stream().map(ReportEntity::toDomain)
                .collect(Collectors.toList()) : List.of();
        return Genre.builder()
                .id(id)
                .name(name)
                .reports(reports)
                .build();
    }
}
