package mshop.user.service;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import mshop.user.dao.UserDAO;

@Service("userService")
public class UserServiceImpl
  implements UserService
{
  @Resource(name="userDAO")
  private UserDAO userDAO;
  
  public Map<String, Object> openLoginSession(Map<String, Object> commandMap)
    throws Exception
  {
    return userDAO.openLoginSession(commandMap);
  }
  
  public Map<String, Object> updateUser(Map<String, Object> map)
    throws Exception
  {
    return userDAO.updateUser(map);
  }
  
  public void deleteUser(Map<String, Object> map)
    throws Exception
  {
    userDAO.deleteUser(map);
  }
}
