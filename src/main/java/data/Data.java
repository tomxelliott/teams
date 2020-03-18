package main.java.data;

import main.java.domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    public Person alice = new Person(0, "Alice");
    public Person bob = new Person(1, "Bob");
    public Person carlos = new Person(2, "Carlos");
    public Person carol = new Person(3, "Carol");
    public Person charlie = new Person(4, "Charlie");
    public Person chuck = new Person(5, "Chuck");
    public Person dave = new Person(6, "Dave");
    public Person eve = new Person(7, "Eve");
    public Person mallory = new Person(8, "Mallory");
    public Person peggy = new Person(9, "Peggy");
    public Person trent = new Person(10, "Trent");
    public Person victor = new Person(11, "Victor");
    public Person walter = new Person(12, "Walter");

    public Person aTeam = new Person(90, "The A-Team", new ArrayList<>(Arrays.asList(alice, bob, carlos)));
    public Person bTeam = new Person(91, "The B-Team", new ArrayList<>(Arrays.asList(peggy, trent, victor, bob)));
    public Person cTeam = new Person(92, "The C-Team", new ArrayList<>(Arrays.asList(charlie, eve, alice, bob)));

    public List<Person> data = Arrays.asList(
            alice,
            bob,
            carlos,
            carol,
            charlie,
            chuck,
            dave,
            eve,
            mallory,
            peggy,
            trent,
            victor,
            walter,
            aTeam,
            bTeam,
            cTeam
    );
}
