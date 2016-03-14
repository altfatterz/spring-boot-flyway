package com.zoltanaltfatter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.*;
import java.util.List;

@SpringBootApplication

/**
 * Available profiles --spring.profiles.active=h2 or --spring.profiles.active=postgresql
 *
 * http --pretty=colors --verbose :8080/v1/athletes
 */
public class SpringBootFlywayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFlywayApplication.class, args);
    }
}

@Entity
@Table(name = "athletes")
class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    // optional
    private String country;

    // for JPA to work
    protected Athlete() {
    }

    public Long getId() {
        return id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

@RepositoryRestResource(collectionResourceRel = "athletes", path = "/athletes")
interface AthleteRepository extends CrudRepository<Athlete, Long> {

    List<Athlete> findByFirstNameIgnoreCase(@Param("firstName") String firstName);

}