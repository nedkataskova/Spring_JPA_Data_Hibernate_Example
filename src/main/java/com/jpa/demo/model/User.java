package com.jpa.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "users")
//@NamedQuery - specifies a static, named query in the Java Persistence query language JPQL
// Query names are scoped to the persistence unit.
// The NamedQueries annotation can be applied to an entity or mapped superclass.
@NamedQuery(name = "User.findByEmailAddress", query = "select u from User u where u.emailAddress = ?1")
//@NamedQueries - specify multiple @NamedQueries
@NamedQueries(value = {
        @NamedQuery(name = "User.findByLastname", query = "select u from User u where u.lastname = ?1")
})
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_generator"
    )

    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence_name",
            allocationSize = 1
    )
    private long id;
    private String firstname;
    private String lastname;
    private Date startDate;
    private String emailAddress;
    private int age;
    private boolean active;

    @Override
    public String toString() {
        return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", startDate=" + startDate +
                ", emailAddress=" + emailAddress + ", age=" + age + ", active=" + active + "]";
    }
}