package mshop.user.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import mshop.common.dao.AbstractDAO;


@Repository("userDAO")
public class UserDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public Map<String, Object> openLoginSession(Map<String, Object> commandMap) {
		 return (Map<String, Object>) selectOne("login.openLoginSession", commandMap);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateUser(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("login.updateUser", map);
	}

	public void deleteUser(Map<String, Object> map) {
		 update("login.deleteUser", map);		
	}

}
