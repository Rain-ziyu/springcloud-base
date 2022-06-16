package top.yzzy.snowflake.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class HuToolUtil {
    private Long workId = 20L;
    private Long dataCenterId = 1L;
    private Snowflake snowflake =  IdUtil.getSnowflake(workId, dataCenterId);
//    这个方法的workID的赋值还没有执行，就已经跟随Autowire进行了snowflake的实例创建
    @PostConstruct
    public void  init(){
        log.info("workId:"+workId);

        try {
            workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("获取本地ip作为workId正常"+workId);
        } catch (Exception e) {
            log.info("获取不到本地地址");
            workId = Long.valueOf(NetUtil.getLocalhostStr().hashCode());
            throw new RuntimeException(e);
        }
        workId = 30L;
//        在init方法中重新赋值进行覆盖之前的snowflake对象
        snowflake =  IdUtil.getSnowflake(workId, dataCenterId);
        log.info("workId:"+snowflake.getWorkerId(workId));

    }
    public synchronized Long getSnowflakeId(){
       return snowflake.nextId();
    }
    public synchronized Long getAnotherSnowflakeId(Long workId,Long dataCenterId ){
      return   IdUtil.getSnowflake(workId, dataCenterId).nextId();
    }


}
