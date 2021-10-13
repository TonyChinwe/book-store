package com.phisoft.bookstand.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="PUBLISHERS")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Publisher {

    @Setter @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @JsonProperty(value="book_publisher_id")
    private Long id;

    @Setter @Getter
    @Column(name = "NAME")
    @JsonProperty(value="book_publisher_name")
    private String name;

}
