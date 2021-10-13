package com.phisoft.bookstand.controllers;
import com.phisoft.bookstand.error.NotAuthorizedException;
import com.phisoft.bookstand.models.Author;
import com.phisoft.bookstand.models.BookType;
import com.phisoft.bookstand.models.Category;
import com.phisoft.bookstand.models.Publisher;
import com.phisoft.bookstand.services.AuthorService;
import com.phisoft.bookstand.services.BookTypeService;
import com.phisoft.bookstand.services.CategoryService;
import com.phisoft.bookstand.services.PublisherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * This is the Api layer that exposes all the Api endpoints for all the book's attribute in our store
 * Like Authors, categories of books, types of books and book publishers
 *
 */
@RestController
@RequestMapping("/api/v1/attributes")
@Api(value="books-attribute", description="Operations that enables us to get different attributes pertaining to books. Like book's author, publishers,etc")
public class BookAttributeController {

    private final Logger logger= LoggerFactory.getLogger(BookAttributeController.class);
    private AuthorService authorService;
    private CategoryService categoryService;
    private PublisherService publisherService;
    private BookTypeService bookTypeService;

    @Autowired
   public BookAttributeController(@Qualifier("author-impl-one") AuthorService authorService,
                                  @Qualifier("category-impl-one") CategoryService categoryService,
                                  @Qualifier("publisher-impl-one") PublisherService publisherService,
                                  @Qualifier("book-type-impl-one") BookTypeService bookTypeService) {
       this.authorService=authorService;
       this.categoryService=categoryService;
       this.publisherService=publisherService;
       this.bookTypeService=bookTypeService;

   }

    @GetMapping("/authors")
    @ApiOperation(value = "Fetches all the authors of books in our store",notes = "This fetches all the authors of books in our store.")
    public List<Author> getAllAuthors(Authentication authentication)throws NotAuthorizedException {
        logger.info("Inside the book attribute controller in the get-all-authors method fetching all the authors that have books in our store");
        return authorService.findAllAuthors();
    }

    @GetMapping("/categories")
    @ApiOperation(value = "Fetches all books categories in our store",notes = "This fetches all books categories in our store.")
    public List<Category> getAllBookCategories(){
        logger.info("Inside the book attribute controller in the get-all-book-category method fetching all the book categories registered in our book store");
        return categoryService.findAllBookCategory();
    }

    @GetMapping("/publishers")
    @ApiOperation(value = "Fetches all books publishers in our store",notes = "This fetches all books publishers in our store.")
    public List<Publisher> getAlBookPublishers(){
        logger.info("Inside the book attribute controller in the get-all-book-publishers method fetching all the book publishers registered in our book store");
        return publisherService.findAllBookPublisher();
    }

    @GetMapping("/book-type")
    @ApiOperation(value = "Fetches all books types registered in our store",notes = "This fetches all books types registered in our store.")
    public List<BookType> getAllBookTypes(){
        logger.info("Inside the book attribute controller in the get-all-book-type method fetching all the book types registered in our store");
        return bookTypeService.findAllBookTypes();
    }

}
