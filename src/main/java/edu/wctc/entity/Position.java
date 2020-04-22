package edu.wctc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private int positionId;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(name = "featuredcrew_position",
            joinColumns = @JoinColumn(name = "position_id"),
            inverseJoinColumns = @JoinColumn(name = "featuredcrew_id"))
    private List<FeaturedCrew> featuredCrewList;

    public Position() {
        //no-arg constructor
    }

    public Position(String description) {
        this.description = description;
    }

    public void add(FeaturedCrew tempFeaturedCrew) {
        if (featuredCrewList == null) {
            featuredCrewList = new ArrayList<>();
        }
        featuredCrewList.add(tempFeaturedCrew);
    }

    public List<FeaturedCrew> getFeaturedCrewList(){
        return featuredCrewList;
    }

    public void setFeaturedCrewList(List<FeaturedCrew> featuredCrewList) {
        this.featuredCrewList = featuredCrewList;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Positions{" +
                "id=" + positionId +
                ", description='" + description + '\'' +
                '}';
    }
}
