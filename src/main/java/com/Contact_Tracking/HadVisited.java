package com.Contact_Tracking;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class HadVisited {

    @Id
    @GeneratedValue
    private Long id;

    private double duration;
    private int date;
    private int time;

    @TargetNode
    private Location location;

    public HadVisited(){
    }

    public HadVisited(Location location, double duration, int date, int time){
        this.duration = duration;
        this.location = location;
        this.date = date;
        this.time = time;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
