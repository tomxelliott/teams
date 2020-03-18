package test.java.service;

import main.java.domain.Person;
import main.java.service.TeamsService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TeamsServiceTest {

    private TeamsService teamsService;

    private static final Person tom = new Person(1, "Tom");
    private static final Person elliott = new Person(2, "Elliott");
    private static final Person larry = new Person(3, "Larry");
    private static final Person david = new Person(4, "David");

    private static final Person avengers = new Person(91, "The Avengers", new ArrayList<>(Arrays.asList(tom, larry, david)));
    private static final Person justiceLeague = new Person(92, "The Justice League", new ArrayList<>(Arrays.asList(tom, avengers)));

    private List<Person> people = Arrays.asList(tom, elliott, larry, david, avengers, justiceLeague);

    @Before
    public void setUp() {
        teamsService = new TeamsService();
    }

    @Test
    public void exercise1ContainsTest() {
        List<Person> result = teamsService.exercise1(tom, people);
        assertEquals(2, result.size());
        assertTrue(result.contains(avengers));
        assertTrue(result.contains(justiceLeague));
    }

    @Test
    public void exercise1NotContainsTest() {
        List<Person> result = teamsService.exercise1(elliott, people);
        assertEquals(0, result.size());
    }

    @Test
    public void getPeopleTest() {
        List<Person> result = teamsService.getPeople(justiceLeague);
        assertEquals(3, result.size());
        assertTrue(result.contains(tom));
        assertTrue(result.contains(larry));
        assertTrue(result.contains(david));
        assertFalse(result.contains(avengers));
    }

    @Test
    public void getPeopleEmptyTest() {
        List<Person> result = teamsService.getPeople(tom);
        assertTrue(result.isEmpty());
    }
}