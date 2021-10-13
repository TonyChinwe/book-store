package com.phisoft.bookstand.controllers;

import com.phisoft.bookstand.dtos.BookDto;
import com.phisoft.bookstand.dtos.BookResponseDto;
import com.phisoft.bookstand.dtos.BooksResponse;
import com.phisoft.bookstand.error.BookNotFoundException;
import com.phisoft.bookstand.models.Book;
import com.phisoft.bookstand.services.BookService;
import com.phisoft.bookstand.services.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


/**
 * Book Controller class tested without security
 */
@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("book-impl-one")
    private BookService bookService;
    private BooksResponse booksResponse;
    private BookDto book;
    private BookResponseDto bookResponseDto;
    @BeforeEach
    void setUp() {
    book= BookDto.builder()
                .title("yellow")
                .numberOfPages(10)
                .build();

      bookResponseDto=  BookResponseDto.builder()
                .title("Things fall apart")
                 .numberOfPages(500)
                .build();

    }

    @Test
    void saveBook() throws Exception {
        BookDto bookDto=BookDto.builder()
                .title("yellow")
                .numberOfPages(10)
                .build();
        Mockito.when(bookService.saveBook(bookDto)).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/books/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"book_title\":\"things fall apart\",\n" +
                        "\"book_num_pages\":1,\n" +
                        "\"book_published_date\":\"2021-06-02\",\n" +
                        "\"book_author_id\":[6,1,2],\n" +
                        "\"book_category_id\":3,\n" +
                        "\"book_publisher_id\":3,\n" +
                        "\"book_type_id\":2\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getBookById() throws Exception {
        Mockito.when(bookService.getBookById(1L)).thenReturn(bookResponseDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/book/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.book_num_pages").value(bookResponseDto.getNumberOfPages()));
    }


    @Test
    void getBookByTitle() throws Exception {
        Mockito.when(bookService.getBookByTitle("yellow")).thenReturn(bookResponseDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/book/title/yellow")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.book_num_pages").value(bookResponseDto.getNumberOfPages()));
    }


    @Test
    void getBookByAuthor() throws Exception {
        Mockito.when(bookService.getBookByAuthor("achebe")).thenReturn(booksResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/author/first-name/achebe")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.book_num_pages").value(bookResponseDto.getNumberOfPages()));
    }


}