package com.joaogsrocha._SpringREST.experiment2;

import com.joaogsrocha._SpringREST.experiment.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemberRepository
        extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {}
