package tema1.ejercicio05.service;

import tema1.ejercicio05.modelo.User;

public interface UserService {
	public void changePswd(Long id, String pswd, String newPswd);
	
	public User registerUser(User user);
	
	public User login(String login, String pswd);
	
	public User consultUser(Long id);
}
