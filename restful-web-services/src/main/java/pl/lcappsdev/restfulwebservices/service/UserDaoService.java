package pl.lcappsdev.restfulwebservices.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import pl.lcappsdev.restfulwebservices.model.User;

@Component
public class UserDaoService {

	private static Map<Integer, User> users = new HashMap<>();
	
	static {
		users.put(1, new User(1, "Adam", LocalDate.now()));
		users.put(2, new User(2, "Eve", LocalDate.now()));
		users.put(3, new User(3, "Jack", LocalDate.now()));
	}
	
	public List<User> findAll() {
		return new ArrayList<User>(users.values());
	}
	
	public User save(User user) {
		
		if(user.getId()==null)
			user.setId(users.size()+1);
		
		users.put(user.getId(), user);
		
		return user;
	}
	
	public User findOne(int id) {

		return users.get(id);
	}
	
	public User delete(int id) {

		return users.remove(id);
	}
}


