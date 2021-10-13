package com.phisoft.bookstand.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.phisoft.bookstand.models.Author;
import com.phisoft.bookstand.models.BookType;
import com.phisoft.bookstand.models.Category;
import com.phisoft.bookstand.models.Publisher;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "This is a data transfer object for a particular book")
public class BookResponseDto {

    @JsonProperty(value="book_title")
    @ApiModelProperty(notes = "Book title")
    private String title;

    @JsonProperty(value="book_isbn")
    @ApiModelProperty(notes = "This is the Book isbn(International Standard Book Number)")
    private String isbn;

    @JsonProperty(value="book_num_pages")
    private int numberOfPages;

    @JsonProperty(value="book_publish_date")
    @ApiModelProperty(notes = "The date the book was published")
    private LocalDate publishedDate;

    @JsonProperty(value="book_authors")
    @ApiModelProperty(notes = "List of authors that wrote the book")
    private List<Author> authors=new ArrayList<>();

    @JsonProperty(value="book_category")
    @ApiModelProperty(notes = "This is the kind of the subject the book belong to")
    private Category category;

    @JsonProperty(value="book_publisher")
    @ApiModelProperty(notes = "This is the publisher of the book")
    private Publisher publisher;

    @JsonProperty(value="book_type")
    @ApiModelProperty(notes = "This is the type of book the book belond to. Like fiction or non-fiction")
    private BookType type;

}
