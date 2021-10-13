package com.phisoft.bookstand.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "BOOK_TYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @JsonProperty(value="book_type_id")
    private Long id;

    @Column(name = "NAME")
    @JsonProperty(value="book_type_name")
    private String name;

}
