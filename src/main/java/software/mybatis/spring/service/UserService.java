package software.mybatis.spring.service;

import software.mybatis.spring.entity.TUser;

public interface UserService {
	
	TUser getUserById(Integer id);

}
