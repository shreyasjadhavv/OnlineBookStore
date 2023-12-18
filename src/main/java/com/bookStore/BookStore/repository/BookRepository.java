package com.bookStore.BookStore.repository;

import com.bookStore.BookStore.Entity.Book;
/*import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;*/
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends SpannerRepository<Book,String>  {

}
