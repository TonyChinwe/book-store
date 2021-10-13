package com.phisoft.bookstand.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "This is a data transfer object for a particular book")
public class BookDto {

    @JsonProperty(value="book_title")
    @NotBlank(message = "The book must have title")
    @NotNull(message = "The book must have title")
    @Length(min = 4,message = "What you entered cannot be a book title")
    @ApiModelProperty(notes = "Book title")
    private String title;

    @JsonProperty(value="book_num_pages")
    @Min(value = 1,message = "The number of pages must be more than one")
    @Positive
    @ApiModelProperty(notes = "Book number of pages")
    private int numberOfPages;

    @JsonProperty(value="book_published_date")
    @Past
    @ApiModelProperty(notes = "Book published date")
    private LocalDate publishedDate;

    @JsonProperty(value="book_author_id")
    @Size(min = 1,message = "A book must have at least one author")
    @NotNull(message = "A book must have at least one author")
    @ApiModelProperty(notes = "List of id belonging to authors that wrote the book")
    private List<Long> writers;

    @JsonProperty(value="book_category_id")
    @NotNull(message = "A book must belong to a category")
    @Positive
    @ApiModelProperty(notes = "This is the id of the subject the book belong to")
    private Long catNumber;

    @JsonProperty(value="book_publisher_id")
    @NotNull(message = "A book must have a publisher")
    @Positive
    @ApiModelProperty(notes = "This specifies the id of the book publisher")
    private Long pubNumber;

    @JsonProperty(value="book_type_id")
    @NotNull(message = "A book must belong to a type")
    @Positive
    @ApiModelProperty(notes = "This specifies the id of the book type like fiction, non-fiction")
    private Long tNumber;

}
