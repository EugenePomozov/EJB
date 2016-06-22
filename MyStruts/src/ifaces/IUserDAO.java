package ifaces;

import beans.User;

public interface IUserDAO {
	public User getUser(String login, String password);
	public boolean checkUserName(String login);
}
