package com.phisoft.bookstand.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "This is a data transfer object when more than one book is expected")
public class BooksResponse {


    @JsonProperty(value="books")
    @ApiModelProperty(notes = "This is list of books to be sent to client")
    private List<BookResponseDto> bookResponseDto;

}
