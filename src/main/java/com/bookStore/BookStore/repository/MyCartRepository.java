package com.bookStore.BookStore.repository;
import com.bookStore.BookStore.Entity.MyCartList;
/*
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;*/
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MyCartRepository extends SpannerRepository<MyCartList,String>{

}
