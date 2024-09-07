package com.example.ticketbookingconcurrent.Entity;

import com.example.ticketbookingconcurrent.enums.Feature;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name="screens")
public class Screen extends BaseModel{
    private String name;
    //Screen : Theatre
    //1 : 1
    //M : 1
    @ManyToOne
    private Theatre theatre;

    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
