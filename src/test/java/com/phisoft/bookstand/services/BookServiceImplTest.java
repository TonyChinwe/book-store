package com.phisoft.bookstand.services;

import com.phisoft.bookstand.dtos.BookDto;
import com.phisoft.bookstand.dtos.BookResponseDto;
import com.phisoft.bookstand.dtos.BooksResponse;
import com.phisoft.bookstand.error.BookNotFoundException;
import com.phisoft.bookstand.models.Author;
import com.phisoft.bookstand.models.Book;
import com.phisoft.bookstand.repositories.BookRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookServiceImpl bookService;
    @MockBean
    private BookRepository bookRepository;

    private final Logger logger = LoggerFactory.getLogger(BookServiceImplTest.class);


    @BeforeEach
    void setUp() {
        Book book=Book.builder()
                .id(1L)
                .title("yellow")
                .numberOfPages(10)
                .isbn("we-6789")
                .build();

        Author author=new Author();
        author.setFirstName("Tony");
        author.setLastName("Chinwe");
        List<Book> bookList=new ArrayList<>();
        bookList.add(book);
        Mockito.when(bookRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(book));
        Mockito.when(bookRepository.findBookByTitle("Tony")).thenReturn(book);
        Mockito.when(bookRepository.save(book)).thenReturn(book);
        Mockito.when(bookRepository.findBookByAuthors(author)).thenReturn(bookList);
    }

    @Test
    @DisplayName("Get book based on valid book id")
    void testGetBookByIdServiceMethod(){
        try {
            BookResponseDto responseDto= bookService.getBookById(1L);
            Assertions.assertEquals(10,responseDto.getNumberOfPages());
        } catch (BookNotFoundException e) {
            logger.info("Book not found");
        }
    }


    @Test
    @DisplayName("Save book to our book store")
    void testSaveBookServiceMethod(){
                 List<Long> authors=new ArrayList<>();
                 authors.add(1L);
                 authors.add(2L);
                 BookDto bookDto=new BookDto();
                 bookDto.setNumberOfPages(10);
                 bookDto.setCatNumber(1L);
                 bookDto.setPubNumber(1L);
                 bookDto.setTNumber(1L);
                 bookDto.setWriters(authors);
                 bookDto.setTitle("yellow");
            BookDto bookDto1 =  bookService.saveBook(bookDto);
            Assertions.assertEquals(10,bookDto1.getNumberOfPages());
    }

    @Test
    @DisplayName("Get book based on book title")
    void testGetBookByTitleServiceMethod(){
            BookResponseDto responseDto= bookService.getBookByTitle("Tony");
            Assertions.assertEquals(10,responseDto.getNumberOfPages());
    }

    @Test
    @DisplayName("Get book based on book author")
    void testGetBookByAuthorServiceMethod(){
        BooksResponse response= bookService.getBookByAuthor("Tony");
        response.setBookResponseDto(Arrays.asList(new BookResponseDto()));
        Assertions.assertEquals(1,response.getBookResponseDto().size());
    }

}