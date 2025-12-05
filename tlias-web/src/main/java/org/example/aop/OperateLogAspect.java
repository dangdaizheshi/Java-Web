package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.pojo.OperateLog;
import org.example.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.example.mapper.OperateLogMapper;
import java.time.LocalDateTime;

@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(org.example.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 创建操作日志对象
        OperateLog operateLog = new OperateLog();
        // 记录操作开始时间
        long startTime = System.currentTimeMillis();

        try {
            // 执行目标方法
            Object result = joinPoint.proceed();

            // 记录操作结束时间
            long endTime = System.currentTimeMillis();

            // 设置日志信息
            operateLog.setOperateTime(LocalDateTime.now());
            operateLog.setClassName(joinPoint.getTarget().getClass().getName());
            operateLog.setMethodName(joinPoint.getSignature().getName());
            operateLog.setMethodParams(arrayToString(joinPoint.getArgs()));
            operateLog.setReturnValue(result != null ? result.toString() : "");
            operateLog.setCostTime(endTime - startTime);
            // 操作人ID需要从安全上下文中获取，这里设置为默认值1
            operateLog.setOperateEmpId(getCurrentUserId());

            // 保存日志到数据库
            operateLogMapper.insert(operateLog);

            return result;
        } catch (Throwable throwable) {
            // 发生异常时也记录日志
            long endTime = System.currentTimeMillis();

            operateLog.setOperateTime(LocalDateTime.now());
            operateLog.setClassName(joinPoint.getTarget().getClass().getName());
            operateLog.setMethodName(joinPoint.getSignature().getName());
            operateLog.setMethodParams(arrayToString(joinPoint.getArgs()));
            operateLog.setReturnValue("Exception: " + throwable.getMessage());
            operateLog.setCostTime(endTime - startTime);
            operateLog.setOperateEmpId(getCurrentUserId());

            // 保存日志到数据库
            operateLogMapper.insert(operateLog);

            throw throwable;
        }
    }

    /**
     * 将数组转换为字符串表示
     */
    private String arrayToString(Object[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 获取当前操作用户ID（需要根据实际的安全框架实现）
     * 这里只是一个示例实现
     */
    private Integer getCurrentUserId() {
        // TODO: 根据实际的安全框架（如Spring Security、JWT等）获取当前用户ID
        // 示例：可以从ThreadLocal、SecurityContext等地方获取
        //在这里先获取到当前用户的token，然后调用utils包下的JwtUtils类中的parseJwt方法解析出来用户的信息

        return CurrentHolder.getCurrentId(); // 默认返回1，实际应根据业务逻辑获取
    }
}