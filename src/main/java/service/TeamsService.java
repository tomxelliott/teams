package main.java.service;

import main.java.domain.Person;

import java.util.*;
import java.util.stream.Collectors;

public class TeamsService {

    /**
     * This method takes a person and a list of all people/teams and returns
     * a list of all the teams of which that person is a member of
     *
     * @param person the person we want to find out team membership for
     * @param people the list of people and teams we want to use to search for membership
     * @return list of teams that the person is a member of
     */
    public List<Person> exercise1(Person person, List<Person> people) {
        return people
                .stream()
                .filter(Person::isTeam)
                .filter(team -> team.getMembers().contains(person))
                .collect(Collectors.toList());
    }

    /**
     * This method gets all the people who are direct and indirect members of a team
     * The test spec specified two different names for this function (get_people and get_members)
     *
     * @param team the team that we want to find all direct and indirect members of
     * @return a list of people directly or indirectly associated with team
     */
    public List<Person> getPeople(Person team) {
        List<Person> people = new ArrayList<>();

        if (!team.isTeam()) {
            return people;
        }

        team.getMembers().forEach(person -> {
            if (person.isTeam()) {
                // do I need this here. I guess it prevents an extra loop through the starting team if it is referenced in another team members list
                people.add(person);
                people.addAll(recursiveTeamSearch(team, person.getMembers(), people));
            } else {
                people.add(person);
            }
        });
        people.sort(Comparator.comparing(Person::getDisplayName));
        return people.stream().filter(p -> !p.isTeam()).distinct().collect(Collectors.toList());
    }

    /**
     *
     *
     * @param baseTeam the team we are currently searching for direct and indirect members of
     * @param teamMembers the members of team to be added to the people list
     * @param people list of people containing the accumulated people associated with baseTeam
     * @return the list of people associated with baseTeam
     */
    private List<Person> recursiveTeamSearch(Person baseTeam, List<Person> teamMembers, List<Person> people) {
        teamMembers.forEach(person -> {
            if (person == baseTeam || people.contains(person)) {
                // this is essentially the base case of the recursive flow and prevents a stack overflow scenario
                return;
            } else if (person.isTeam()) {
                people.add(person);
                people.addAll(recursiveTeamSearch(baseTeam, person.getMembers(), people));
            } else {
                people.add(person);
            }
        });
        return people;
    }
}
