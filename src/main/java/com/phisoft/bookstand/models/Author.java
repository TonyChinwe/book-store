package com.phisoft.bookstand.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "AUTHORS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    @JsonProperty(value="author_id")
    private Long id;

    @Column(name="FIRST_NAME")
    @JsonProperty(value="author_first_name")
    private String firstName;

    @Column(name = "LAST_NAME")
    @JsonProperty(value="author_last_name")
    private String lastName;



}
