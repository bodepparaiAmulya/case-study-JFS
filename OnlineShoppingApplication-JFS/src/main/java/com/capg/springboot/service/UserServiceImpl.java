package com.capg.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.springboot.Exceptions.UserNotFoundException;
import com.capg.springboot.entity.User;
import com.capg.springboot.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository login_repo;
  
    /* Method: addUser 
	 * Description: It adds the user information.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the user.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021 
     */
  @Override
  public User addUser(User user) {
	  User user_info=login_repo.save(user);
	  return user_info;
  }
  
    /* Method: removeUser 
	 * Description: It removes the user information.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the user.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021 
     */
  
  @Override
  public User removeUser(User user) {
	  
	  login_repo.delete(user);
	  return user;
  }
    /* Method: validateUser 
	 * Description: It validates the user information.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the user.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */
  
  @Override
  public User validateUser(String id) throws UserNotFoundException {
	  User user_info=login_repo.findByUserId(id);
	  if(user_info==null)
		  throw new UserNotFoundException("User Not Found");
	  return user_info;
  }
}
