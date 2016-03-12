package com.altfatterz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.*;

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

	public Athlete(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Athlete[id=%d, firstName='%s', lastName='%s'", id, firstName, lastName);
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
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

}