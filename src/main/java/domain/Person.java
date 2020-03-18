package main.java.domain;

import java.util.List;

public class Person {
	
    private int id;
    private String displayName;
    private boolean isTeam;
    private List<Person> members;

    public Person(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
        this.isTeam = false;
    }

    public Person(int id, String displayName, List<Person> members) {
        this.id = id;
        this.displayName = displayName;
        this.members = members;
        this.isTeam = members != null && members.size() > 0;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isTeam() {
        return isTeam;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void addMember(Person person) {
        this.members.add(person);
    }

    public void removeMember(Person person) {
        this.members.remove(person);
    }
}