package tema1.ejercicio05.service;

import tema1.ejercicio05.dao.UserDao;
import tema1.ejercicio05.modelo.User;

public class UserServiceImpl extends Service implements UserService{
	
	private UserDao userDao;
	private static final
	

	public UserServiceImpl() {
		userDao = new UserDao();
	}

	@Override
	public void changePswd(Long id, String pswd, String newPswd) {
		
	}

	@Override
	public User registerUser(User user) {
		
		return null;
	}

	@Override
	public User login(String login, String pswd) {
		
		return null;
	}

	@Override
	public User consultUser(Long id) {
		
		return null;
	}

}
