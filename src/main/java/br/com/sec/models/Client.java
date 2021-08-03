package br.com.sec.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private Long age;

    @Column(name="first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name="last_name", nullable = false, length = 80)
    private String lastName;
}
