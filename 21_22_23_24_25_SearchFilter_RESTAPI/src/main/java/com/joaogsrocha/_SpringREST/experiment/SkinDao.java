package com.joaogsrocha._SpringREST.experiment;

import com.joaogsrocha._SpringREST.skin.Skin;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class SkinDao implements ISkinDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Skin> searchSkin(List<SearchCriteria> params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Skin> query = builder.createQuery(Skin.class);
        Root r = query.from(Skin.class);

        Predicate predicate = builder.conjunction();

        SkinSearchQueryCriteriaConsumer searchConsumer =
                new SkinSearchQueryCriteriaConsumer(predicate, builder, r);
        params.stream().forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        List<Skin> result = entityManager.createQuery(query).getResultList();
        return result;
    }

    @Override
    public void save(Skin entity) {
        entityManager.persist(entity);
    }
}
