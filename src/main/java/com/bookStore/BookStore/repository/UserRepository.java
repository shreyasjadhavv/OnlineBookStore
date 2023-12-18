package com.bookStore.BookStore.repository;
/*
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;*/

import com.bookStore.BookStore.Entity.User;
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends SpannerRepository<User, String> {
 

}