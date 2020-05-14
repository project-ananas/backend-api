package com.ananas.backendapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Location entity
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private String unit;
    private Timestamp time = new Timestamp(System.currentTimeMillis());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

}
