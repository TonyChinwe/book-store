package com.phisoft.bookstand.repositories;

import com.phisoft.bookstand.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Book's category repository
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
