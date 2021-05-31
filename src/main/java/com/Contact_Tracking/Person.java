package com.Contact_Tracking;

import java.util.*;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
public class Person {

    @Id @GeneratedValue private Long id;

    private String firstName;

    private String lastName;

    private Person() {
    };

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Relationship(type = "HAD_CONTACT_WITH")
    public Set<HadContactWith> contactPersons;

    @Relationship(type = "HAD_VISITED")
    public Set<HadVisited> visitedLocations;

    public void hadContactWith(HadContactWith hadContactWith) {
        if (contactPersons == null) {
            contactPersons = new HashSet<>();
        }
        contactPersons.add(hadContactWith);
    }

    public void hadVisited(HadVisited hadVisited) {
        if (visitedLocations == null) {
            visitedLocations = new HashSet<>();
        }
        visitedLocations.add(hadVisited);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}