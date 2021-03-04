package pl.lcappsdev.restfulwebservices.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.lcappsdev.restfulwebservices.model.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Adam", LocalDate.now()));
		users.add(new User(2, "Eve", LocalDate.now()));
		users.add(new User(3, "Jack", LocalDate.now()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		
		if(user.getId()==null)
			user.setId(users.size());
		
		users.add(user);
		
		return user;
	}
	
	public User findOne(int id) {

		return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
	}
}


