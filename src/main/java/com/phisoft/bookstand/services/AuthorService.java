package com.phisoft.bookstand.services;


import com.phisoft.bookstand.error.NotAuthorizedException;
import com.phisoft.bookstand.models.Author;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * Service contract for fetching all the book authors in our store
 */
public interface AuthorService {
    /**
     * Finds all the authors that can have their  books in our book store
     * @return list of authors that can have their books in our book store
     */
    public List<Author> findAllAuthors();


}
