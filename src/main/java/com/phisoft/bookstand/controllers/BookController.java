package com.phisoft.bookstand.controllers;
import com.phisoft.bookstand.dtos.BookDto;
import com.phisoft.bookstand.dtos.BookResponseDto;
import com.phisoft.bookstand.dtos.BooksResponse;
import com.phisoft.bookstand.dtos.UpdateBookDto;
import com.phisoft.bookstand.error.BookNotFoundException;
import com.phisoft.bookstand.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/books")
@Api(value="books-store", description="Operations pertaining to books in our book store. Like uploading books,searching for books and a lot more ")
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;

    @Autowired
    public BookController(@Qualifier("book-impl-one") BookService bookService){
        this.bookService=bookService;
    }

    @PostMapping("/save")
    @ApiOperation(value = "Saves a book in our book store",notes = "This saves a particular book to our book store", response = BookDto.class)
    public BookDto saveBook(@Valid @RequestBody BookDto bookDto){
        logger.info("Inside book controller in the saveBook method Saving a book in the repository");
        return bookService.saveBook(bookDto);
    }

    @GetMapping("/all-books")
    @ApiOperation(value = "Fetches books from the book store based on certain filters",notes = "This fetches book from the book store based on certain filters. It alse applies pagination", response = BooksResponse.class)
    public BooksResponse getAllBooks(@RequestParam(required = false,name = "page",defaultValue = "1") int page,
                                     @RequestParam(required = false,name = "size", defaultValue = "5")int size,
                                     @RequestParam(required = false,name = "sortField",defaultValue = "id")String sortField,
                                     @RequestParam(required = false,name = "direction",defaultValue = "ascend")String direction){
        logger.info("Inside book controller in the getAllBook method fetching all the books");
        return bookService.allBooks(page,size,sortField,direction);
    }

    @GetMapping("/book/{id}")
    @ApiOperation(value = "Fetches a book from our book store based on the id of the book",notes = "This fetches a particular book from our book store based on the id of the book", response = BookResponseDto.class)
    public BookResponseDto getBookById(@PathVariable("id") Long bookId) throws BookNotFoundException {
        logger.info("Inside book controller in the getBookById method fetching a particular book based on id");
        return bookService.getBookById(bookId);

    }
    @DeleteMapping("/book/{id}")
    @ApiOperation(value = "Deletes a book from our book store using id",notes = "This deletes a book from our book store using id", response = String.class)
    public String deleteBookById(@PathVariable("id") Long bookId){
        logger.info("Inside book controller in the deleteBookById method Trying to delete a book based on id");
        bookService.deleteBookById(bookId);
        return "Book deleted";
   }

   @PutMapping("/book/{id}")
   @ApiOperation(value = "Updates a book from our book store using id",notes = "This Updates a book from our book store using id", response = BookResponseDto.class)
   public BookResponseDto updateBook( @PathVariable("id") Long bookId,@Valid @RequestBody UpdateBookDto bookDto){
       logger.info("Inside book controller in the updateBook method Trying to update a book in the repository");
       return bookService.updateBook(bookId,bookDto);
   }

    @GetMapping("/book/title/{title}")
    @ApiOperation(value = "Fetches a book from our book store based on the title of the book",notes = "This fetches a particular book from our book store based on the title of the book", response = BookResponseDto.class)
    public BookResponseDto getBookByTitle(@PathVariable("title") String title){
        logger.info("Inside book controller in the getBookByTitle method Trying to fetch a book using the book title");
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/author/first-name/{firstName}")
    @ApiOperation(value = "Fetches books from the book store written by a particular author",notes = "This fetches books from the book store written by a particular author . It does it using the author's first-name", response = BooksResponse.class)
    public BooksResponse getBookByAuthor(@PathVariable("firstName") String authorFirstName){
        logger.info("Inside book controller in the getBookByAuthor method Trying to fetch a book using the book author first name");
        return bookService.getBookByAuthor(authorFirstName);
    }

}
