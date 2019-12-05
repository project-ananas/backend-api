package com.ananas.backendapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Location entity
 */

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private String location;
    private int total;
    private Timestamp time = new Timestamp(System.currentTimeMillis());

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
