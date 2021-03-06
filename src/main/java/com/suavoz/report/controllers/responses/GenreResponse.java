package com.suavoz.report.controllers.responses;

import com.suavoz.report.domain.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenreResponse {
    private Long id;
    private String name;

    public GenreResponse(Genre genre) {
        id = genre.getId();
        name = genre.getName();
    }
}
