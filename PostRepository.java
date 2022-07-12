package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//For CRUD operations
@Repository
//Long refers to the data type of primary key to search.
public interface PostRepository extends JpaRepository<Post,Long>{

}
