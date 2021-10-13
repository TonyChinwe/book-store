package com.phisoft.bookstand.models;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOOKS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false,unique = true)
    private Long id;

    @Column(name="TITLE",nullable = false,unique = true)
    private String title;

    @Column(name="ISBN",nullable = false,unique = true)
    private String isbn;

    @Column(name="NUMBER_OF_PAGES")
    private int numberOfPages;

    @Column(name="PUBLISH_DATE")
    private LocalDate publishedDate;

    @ManyToMany
    @JoinTable(name ="BOOK_AUTHOR_TABLE",joinColumns = @JoinColumn(name="BOOK_ID"),inverseJoinColumns = @JoinColumn(name="AUTHOR_ID"))
    private List<Author> authors=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="CATEGORY")
    private Category category;

    @ManyToOne
    @JoinColumn(name="OWNER")
    private Account account;


    @ManyToOne
    @JoinColumn(name="PUBLISHER")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name="TYPE")
    private BookType type;

}
