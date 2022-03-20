package com.suavoz.report.controller.responses;

import com.suavoz.report.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportResponse {

    private Long id;
    private String description;
    private AgeGroupResponse ageGroup;
    private GenreResponse genre;
    private ViolenceTypeResponse violenceType;
    private ZoneResponse zone;

    public ReportResponse(Report report) {
        id = report.getId();
        description = report.getDescription();
        ageGroup = new AgeGroupResponse(report.getAgeGroup());
        genre = new GenreResponse(report.getGenre());
        violenceType = new ViolenceTypeResponse(report.getViolenceType());
        zone = new ZoneResponse(report.getZone());
    }
}
