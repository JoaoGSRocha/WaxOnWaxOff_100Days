package com.joaogsrocha._SpringREST.experiment;

import com.joaogsrocha._SpringREST.skin.Skin;

import java.util.List;

public interface ISkinDao {
    List<Skin> searchSkin(List<SearchCriteria> params);

    void save(Skin entity);
}
