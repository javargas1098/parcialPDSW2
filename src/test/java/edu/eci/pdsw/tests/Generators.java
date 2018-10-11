package edu.eci.pdsw.tests;

import org.quicktheories.core.Gen;
import static org.quicktheories.generators.SourceDSL.strings;

import edu.eci.pdsw.entities.User;


public class Generators {
	static public Gen<User> users() {
		return strings().allPossible().ofLengthBetween(1, 20)
				.zip(strings().allPossible().ofLengthBetween(10, 50),
						strings().allPossible().ofLengthBetween(10, 50),
						(login,name, lastName) -> new User(login,name,lastName));
	}
}
