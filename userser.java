package service;

import java.util.List;

import models.user;

public interface userser {
	public void addUser(String mdp,String role);
	public void editUser(long id,String mdp,String role);
	public void deleteUser(long id);
	public user getUser(long id);
	public List<user>getAllUser();

}
