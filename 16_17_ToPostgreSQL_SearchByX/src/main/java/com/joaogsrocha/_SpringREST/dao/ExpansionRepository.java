package com.joaogsrocha._SpringREST.dao;

import com.joaogsrocha._SpringREST.skin.expansion.Expansion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "expansion", path = "expansion")
public interface ExpansionRepository extends JpaRepository<Expansion, Long> {

}
