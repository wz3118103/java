package software.mybatis.demo.mapper;

import org.apache.ibatis.annotations.Param;
import software.mybatis.demo.entity.EmailSexBean;
import software.mybatis.demo.entity.TUser;

import java.util.List;
import java.util.Map;

public interface TUserMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert1(TUser record);
    
    int insert2(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    
    
    List<TUser> selectUserPosition1();
    
    List<TUser> selectUserPosition2();
    
    List<TUser> selectUserJobs1();
    
    List<TUser> selectUserJobs2();
    
    List<TUser> selectUserHealthReport();
    
    List<TUser> selectUserRole();
    
    List<TUser> selectByEmailAndSex1(Map<String, Object> param);
    
    List<TUser> selectByEmailAndSex2(@Param("email") String email, @Param("sex") Byte sex);
    
    List<TUser> selectByEmailAndSex3(EmailSexBean esb);
    
    
    List<TUser> selectBySymbol(@Param("tableName") String tableName,
                               @Param("inCol") String inCol,
                               @Param("orderStr") String orderStr,
                               @Param("sex") Byte sex);
    
    List<TUser> selectIfOper(@Param("email") String email, @Param("sex") Byte sex);
    
    
    List<TUser> selectIfandWhereOper(@Param("email") String email, @Param("sex") Byte sex);
    
    List<TUser> selectChooseOper(@Param("email") String email, @Param("sex") Byte sex);
    
    int updateIfOper(TUser record);
    
    int updateIfAndSetOper(TUser record);
    
    int insertIfOper(TUser record);
    
    List<TUser> selectForeach4In(String[] names);
    
    int insertForeach4Batch(List<TUser> users);
    
    
    
    
    
}