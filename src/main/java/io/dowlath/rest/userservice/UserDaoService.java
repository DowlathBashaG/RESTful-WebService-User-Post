package io.dowlath.rest.userservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import io.dowlath.rest.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"Dowlath",new Date()));
		users.add(new User(2,"Basha",new Date()));
		users.add(new User(3,"Arsh",new Date()));
		users.add(new User(4,"Ariz",new Date()));
		users.add(new User(5,"Naveeda",new Date()));
		
	}
	
	private static int userCounts = 6;
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCounts);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User usr = iterator.next();
			if(usr.getId() == id) {
				iterator.remove();
				return usr;
			}
		}
		return null;
	}

}
