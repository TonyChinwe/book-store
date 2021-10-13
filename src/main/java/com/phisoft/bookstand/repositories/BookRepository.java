package com.phisoft.bookstand.repositories;

import com.phisoft.bookstand.models.Author;
import com.phisoft.bookstand.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Book's repository
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    /**
     * Fetch book using book's title
     * @param title book's title
     * @return Book
     */
     Book findBookByTitle(String title);

    /**
     * fetch book using author
     * @param author book's author
     * @return list of authors
     */
     List<Book> findBookByAuthors(Author author);
}
