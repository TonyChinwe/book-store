package com.phisoft.bookstand.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="CATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ID")
    @JsonProperty(value="book__category_id")
    private Long id;

    @Column(name="NAME")
    @JsonProperty(value="book_category_name")
    private String name;

}
