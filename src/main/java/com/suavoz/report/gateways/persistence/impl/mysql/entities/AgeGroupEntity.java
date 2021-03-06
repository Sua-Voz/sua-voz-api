package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.domain.AgeGroup;
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
@Table(name = "TB_AGE_GROUP")
@NoArgsConstructor
public class AgeGroupEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AGES")
    private String ages;

    @OneToMany(mappedBy = "ageGroup")
    private List<ReportEntity> reportEntities = new ArrayList<>();

    public AgeGroupEntity(AgeGroup ageGroup) {
        id = ageGroup.getId();
        ages = ageGroup.getAges();
    }


    public AgeGroup toDomain(boolean loadReports) {
        List<Report> reports = loadReports ? reportEntities.stream().map(ReportEntity::toDomain)
                .collect(Collectors.toList()) : List.of();
        return AgeGroup.builder()
                .id(id)
                .ages(ages)
                .reports(reports)
                .build();
    }
}
