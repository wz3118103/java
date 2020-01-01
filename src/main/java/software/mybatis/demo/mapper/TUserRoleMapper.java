package software.mybatis.demo.mapper;

import software.mybatis.demo.entity.TUserRoleKey;

public interface TUserRoleMapper {
    int deleteByPrimaryKey(TUserRoleKey key);

    int insert(TUserRoleKey record);

    int insertSelective(TUserRoleKey record);
}