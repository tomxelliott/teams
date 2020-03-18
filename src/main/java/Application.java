package main.java;

import main.java.data.Data;
import main.java.domain.Person;
import main.java.service.TeamsService;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
	private static TeamsService ts = new TeamsService();
	private static Data data = new Data();

	public static void main(String[] args) {
		scenario1();
		scenario2();
		scenario3();
		scenario4();
	}

	private static void scenario1() {
		List<Person> result1 = ts.exercise1(data.alice, data.data);
		System.out.println(result1.stream().map(Person::getDisplayName).collect(Collectors.toList()));
	}

	private static void scenario2() {
		data.cTeam.removeMember(data.alice);
		data.cTeam.removeMember(data.bob);
		data.cTeam.addMember(data.aTeam);

		List<Person> result1 = ts.exercise1(data.alice, data.data);
		System.out.println(result1.stream().map(Person::getDisplayName).collect(Collectors.toList()));
	}

	private static void scenario3() {
		data.cTeam.removeMember(data.bob);

		List<Person> result2 = ts.getPeople(data.cTeam);
		System.out.println(result2.stream().map(Person::getDisplayName).collect(Collectors.toList()));
	}

	private static void scenario4() {
		data.aTeam.addMember(data.bTeam);
		data.bTeam.addMember(data.cTeam);
		List<Person> result3 = ts.getPeople(data.cTeam);
		System.out.println(result3.stream().map(Person::getDisplayName).collect(Collectors.toList()));
	}
}
