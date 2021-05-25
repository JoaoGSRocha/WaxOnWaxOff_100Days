package com.joaogsrocha._SpringREST.experiment;

import java.util.List;

public interface IMemberDao {
    List<Member> searchMember(List<SearchCriteria> params);

    void save(Member entity);
}
