package com.joaogsrocha._SpringREST.dao;

import com.joaogsrocha._SpringREST.skin.Skin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface SkinRepository extends JpaRepository<Skin, Long> {
    Page<Skin> findByExpansionId(@RequestParam("id") Long id, Pageable pageable);
}
