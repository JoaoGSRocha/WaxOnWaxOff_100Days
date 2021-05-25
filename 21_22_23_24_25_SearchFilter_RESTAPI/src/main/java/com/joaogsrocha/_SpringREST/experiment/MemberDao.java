package com.joaogsrocha._SpringREST.experiment;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MemberDao implements IMemberDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Member> searchMember(List<SearchCriteria> params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> query = builder.createQuery(Member.class);
        Root r = query.from(Member.class);

        Predicate predicate = builder.conjunction();

        MemberSearchQueryCriteriaConsumer searchConsumer =
                new MemberSearchQueryCriteriaConsumer(predicate, builder, r);
        params.stream().forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        List<Member> result = entityManager.createQuery(query).getResultList();
        return result;
    }

    @Override
    public void save(Member entity) {
        entityManager.persist(entity);
    }
}
