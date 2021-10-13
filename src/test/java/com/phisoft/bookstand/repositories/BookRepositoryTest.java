package com.phisoft.bookstand.repositories;

import com.phisoft.bookstand.models.Author;
import com.phisoft.bookstand.models.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;



    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Author author=new Author();
        author.setFirstName("Tony");
        author.setLastName("Chinwe");
        author.setId(1L);
        Book book=Book.builder()
                .title("yellow")
                .numberOfPages(10)
                .isbn("we-6789")
                .authors(Arrays.asList(author))
                .build();
        entityManager.persist(book);
    }


    @Test
    void findBookByIdInRepository(){
        Book book=bookRepository.findById(1L).get();
        Assertions.assertEquals(10,book.getNumberOfPages());
    }

    @Test
    void findBookByTitleInRepository(){
        Book book=bookRepository.findBookByTitle("yellow");
        Assertions.assertEquals(10,book.getNumberOfPages());

    }

    @Test
    void findBookByAuthorInRepository(){
        Author author=new Author();
        author.setFirstName("Tony");
        author.setLastName("Chinwe");
        author.setId(1L);
        List<Book> books=bookRepository.findBookByAuthors(author);
        Assertions.assertEquals(1,books.size());

    }
}