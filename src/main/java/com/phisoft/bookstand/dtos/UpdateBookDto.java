package com.phisoft.bookstand.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "This is a data transfer object when updating a particular book")
public class UpdateBookDto {

    @JsonProperty(value="book_title")
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
    @ApiModelProperty(notes = "List of id belonging to authors that wrote the book")
    private List<Long> writers;

    @JsonProperty(value="book_category_id")
    @ApiModelProperty(notes = "This is the id of the subject the book belong to")
    private Long catNumber;

    @JsonProperty(value="book_publisher_id")
    @ApiModelProperty(notes = "This specifies the id of the book publisher")
    private Long pubNumber;

    @JsonProperty(value="book_type_id")
    @ApiModelProperty(notes = "This specifies the id of the book type like fiction, non-fiction")
    private Long tNumber;

}
