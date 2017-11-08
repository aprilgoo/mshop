package mshop.user.service;

import java.util.Map;

public interface UserService  {

	Map<String, Object> openLoginSession(Map<String, Object> map) throws Exception;

	Map<String, Object> updateUser(Map<String, Object> map) throws Exception;

	void deleteUser(Map<String, Object> map) throws Exception;

}
