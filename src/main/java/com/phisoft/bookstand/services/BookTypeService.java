package com.phisoft.bookstand.services;

import com.phisoft.bookstand.models.BookType;

import java.util.List;
/**
 * Service contract for fetching all the book types in our store
 */
public interface BookTypeService {
    /**
     * Finds all the types a book can belong to in our store
     * @return list of book types in our store
     */
    public List<BookType> findAllBookTypes();
}
