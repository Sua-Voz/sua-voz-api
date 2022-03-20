package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import javax.persistence.*;

@Entity
@Table
public class GenreEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
}