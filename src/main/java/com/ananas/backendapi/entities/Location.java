package com.ananas.backendapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Location entity
 */

@Entity
@Getter
@AllArgsConstructor
public class Location {
    private String unit;
    private Timestamp time = new Timestamp(System.currentTimeMillis());

    public Location() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
