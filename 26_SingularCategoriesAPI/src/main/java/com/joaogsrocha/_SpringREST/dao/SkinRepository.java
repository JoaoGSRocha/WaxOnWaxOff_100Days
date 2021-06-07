package com.joaogsrocha._SpringREST.dao;

import com.joaogsrocha._SpringREST.skin.Skin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SkinRepository extends JpaRepository<Skin, Long>, JpaSpecificationExecutor<Skin> {
}
