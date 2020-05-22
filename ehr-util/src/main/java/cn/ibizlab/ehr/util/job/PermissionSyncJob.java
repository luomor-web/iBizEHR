package cn.ibizlab.ehr.util.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import cn.ibizlab.ehr.util.client.IBZUAAFeignClient;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

/**
 * 权限：向uaa同步当前系统菜单、权限资源任务类
 */
//@Component   //开启此类需要保证Main中开启了feign ：EnableFeignClients
public class PermissionSyncJob implements ApplicationRunner {

    private Log log = LogFactory.getLog(PermissionSyncJob.class);

    @Autowired
    private IBZUAAFeignClient client;

    @Value("${ibiz.enablePermissionValid:false}")
    boolean enablePermissionValid;  //是否开启权限校验

    @Value("${ibiz.systemid:ehr}")
    private String systemId;

    @Override
    public void run(ApplicationArguments args) {
        if(enablePermissionValid){
            try {
                InputStream permission= this.getClass().getResourceAsStream("/permission/systemResource.json"); //获取当前系统所有实体资源能力
                String permissionResult = IOUtils.toString(permission,"UTF-8");
                JSONObject jsonNodePermission = JSONObject.parseObject(permissionResult);
                Map<String,Object> map=new HashMap<>();
                map.put("permission",jsonNodePermission);
                JSONObject syncResult=client.pushSystemPermissionData(map,systemId);
                if(syncResult.getInteger("code")==1){
                    log.info("向[UAA]同步系统资源成功");
                }else{
                    log.info(String.format("向[UAA]同步系统资源失败，失败原因为[%s]",syncResult.getString("msg")));
                }
            }
            catch (Exception ex) {
                log.error(String.format("向[UAA]同步系统资源失败，请检查[UAA]服务是否正常! [%s]",ex));
            }
        }
    }
}