/*
package com.joaogsrocha._SpringREST;

import com.joaogsrocha._SpringREST.experiment.IMemberDao;
import com.joaogsrocha._SpringREST.experiment.Member;
import com.joaogsrocha._SpringREST.experiment.SearchCriteria;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class })
@Transactional
@Rollback
public class JPACriteriaQueryIntegrationTest {
*/
/*
    @Autowired
    private IMemberDao MemberApi;

    private Member MemberJohn;

    private Member MemberTom;

    @BeforeEach
    public void init() {
        MemberJohn = new Member();
        MemberJohn.setFirstName("john");
        MemberJohn.setLastName("doe");
        MemberJohn.setEmail("john@doe.com");
        MemberJohn.setAge(22);
        MemberApi.save(MemberJohn);

        MemberTom = new Member();
        MemberTom.setFirstName("tom");
        MemberTom.setLastName("doe");
        MemberTom.setEmail("tom@doe.com");
        MemberTom.setAge(26);
        MemberApi.save(MemberTom);
    }

    @Test
    public void givenFirstAndLastName_whenGettingListOfMembers_thenCorrect() {
        final List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("firstName", ":", "john"));
        params.add(new SearchCriteria("lastName", ":", "doe"));

        final List<Member> results = MemberApi.searchMember(params);

        assertThat(MemberJohn, isIn(results));
*//*
*/
/*        assertThat(MemberTom, not(isIn(results)));*//*
*/
/*
    }

    @Test
    public void givenLast_whenGettingListOfMembers_thenCorrect() {
        final List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("lastName", ":", "doe"));

        final List<Member> results = MemberApi.searchMember(params);
        assertThat(MemberJohn, isIn(results));
        assertThat(MemberTom, isIn(results));
    }

    @Test
    public void givenLastAndAge_whenGettingListOfMembers_thenCorrect() {
        final List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("lastName", ":", "doe"));
        params.add(new SearchCriteria("age", ">", "25"));

        final List<Member> results = MemberApi.searchMember(params);

        assertThat(MemberTom, isIn(results));
*//*
*/
/*        assertThat(MemberJohn, not(isIn(results)));*//*
*/
/*
    }

    @Test
    public void givenWrongFirstAndLast_whenGettingListOfMembers_thenCorrect() {
        final List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("firstName", ":", "adam"));
        params.add(new SearchCriteria("lastName", ":", "fox"));

        final List<Member> results = MemberApi.searchMember(params);
        assertThat(MemberJohn, not(isIn(results)));
        assertThat(MemberTom, not(isIn(results)));
    }

    @Test
    public void givenPartialFirst_whenGettingListOfMembers_thenCorrect() {
        final List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("firstName", ":", "jo"));

        final List<Member> results = MemberApi.searchMember(params);

        assertThat(MemberJohn, isIn(results));
*//*
*/
/*        assertThat(MemberTom, not(isIn(results)));*//*
*/
/*
    }*//*

}
*/
