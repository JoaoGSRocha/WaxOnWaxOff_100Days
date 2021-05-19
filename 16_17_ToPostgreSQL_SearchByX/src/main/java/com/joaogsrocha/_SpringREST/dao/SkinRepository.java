package com.joaogsrocha._SpringREST.dao;

import com.joaogsrocha._SpringREST.skin.Skin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface SkinRepository extends JpaRepository<Skin, Long> {
/*    Page<Skin> findbyExpansionCodeId(@RequestParam("id") Long id, Pageable pageable);*/
}
