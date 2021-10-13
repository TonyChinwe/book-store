package com.phisoft.bookstand.dtos;
import com.phisoft.bookstand.models.Book;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

    private String firstName;
    private String lastName;
    private List<Book> books;

}
