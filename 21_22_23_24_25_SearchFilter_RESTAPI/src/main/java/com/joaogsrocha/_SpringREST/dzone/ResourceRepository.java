package com.joaogsrocha._SpringREST.dzone;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface ResourceRepository<T, I extends Serializable> extends JpaRepository<T, I> {
    Page<T> findAll(Query query, Pageable pageable);
    List<T> findAll(Query query);
}