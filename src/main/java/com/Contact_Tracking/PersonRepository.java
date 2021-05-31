package com.Contact_Tracking;

import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person findByFirstNameAndLastName(String firstName, String lastName);

    // What people did X have contact with?
    @Query("MATCH (p:Person {firstName: $firstName, lastName: $lastName})-[r:HAD_CONTACT_WITH]-(p2:Person) RETURN p,p2")
    public List<Person> getPersons(@Param("firstName") String name, @Param("lastName") String lastName);

    // What locations did person X visit in the last Y days?
    @Query("MATCH (l:Location) -[r:HAD_VISITED]-(p:Person {firstName: $firstName, lastName: $lastName}) WHERE r.date = $date RETURN o")
    public List<Person> getLocations(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("date") int date);

    // Which people were at location Y on day X?
    @Query("MATCH (l:Location {name: $name})-[r:HAD_VISITED]-(p:Person) WHERE r.date = $date RETURN p,o")
    public List<Person> getPersonsAtPlaceOnDay(@Param("name") String name, @Param("date") int date);

    // What are all the contact paths from person X to person Y?"(i.e. also including indirect contacts included)
    @Query("MATCH p=(p1:Person{firstName: $firstName, lastName: $lastName})-[r2:HAD_CONTACT_WITH*]-(p2:Person) RETURN p")
    public List<Person> getAllPathsBetweenXAndY(@Param("firstName") String firstName, @Param("lastName") String lastName);

    // What is the shortest contact path from person X to person Y? (i.e. also including indirect contacts)
    @Query("OPTIONAL MATCH (p1:Person{firstName: $firstName1}),(p2:Person{firstName: $firstName2}) p = shortestPath((p1)-[*..15]-(p2)) RETURN p")
    public List<Person> getShortestPath(@Param("firstName1") String firstName1, @Param("firstName2") String firstName2);

    // Which persons could have infected person X directly or indirectly? We assume that an infection occurs with at least 15 minutes of direct
    @Query("MATCH p=(p1:Person{firstName: $firstName, lastName: $lastName})-[r2:HAD_CONTACT_WITH*]-(p2:Person) WHERE ALL (r IN r2 WHERE r.duration >= 0.25) RETURN p")
    public List<Person> getAllDirectAndIndirectContacts(@Param("firstName") String firstName, @Param("lastName") String lastName);
}