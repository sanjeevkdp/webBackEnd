package com.niit.dao;

import java.util.List;

import com.niit.model.Users;

public interface UsersDao {
void saveOrUpdate(Users users);

void editUsers(Users users);
	
	Users get(String user_id);
	
	List<Users> list();
	
	Users getUsersByUserName(String userName);


}
