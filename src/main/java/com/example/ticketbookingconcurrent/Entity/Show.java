package com.example.ticketbookingconcurrent.Entity;

import com.example.ticketbookingconcurrent.enums.Feature;
import com.example.ticketbookingconcurrent.enums.ShowStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity(name="shows")
public class Show extends BaseModel{

    //Show : Movie
    //1 : 1
    //M : 1
    @ManyToOne
    private Movie movie;
    //Show : Screen
    //1 : 1
    //M : 1
    @ManyToOne
    private Screen screen;
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    @Enumerated
    private ShowStatus showStatus;

}
