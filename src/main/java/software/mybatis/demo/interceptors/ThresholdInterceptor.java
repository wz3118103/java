package software.mybatis.demo.interceptors;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.jdbc.PreparedStatementLogger;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

@Intercepts({
        // query(Statement statement, ResultHandler resultHandler)
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})
})
public class ThresholdInterceptor implements Interceptor {

    private long threshold;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long begin = System.currentTimeMillis();
        Object ret = invocation.proceed();
        long end = System.currentTimeMillis();
        long runtime = end - begin;
        if (runtime > threshold) {
            Object[] args = invocation.getArgs();
            Statement stmt = (Statement) args[0];
            MetaObject metaObject = SystemMetaObject.forObject(stmt);
            PreparedStatementLogger logger = (PreparedStatementLogger)metaObject.getValue("h");
            Statement real = logger.getPreparedStatement();
            System.out.println("sql语句： " + real.toString() + ", 执行时间： " + runtime + "毫秒， 超过阈值"  + threshold);
        }
        return ret;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.threshold = Long.valueOf(properties.getProperty("threshold"));
    }
}
