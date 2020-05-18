package cn.ibizlab.ehr.util.client;

import cn.ibizlab.ehr.util.security.AuthenticationUser;
import cn.ibizlab.ehr.util.security.AuthorizationLogin;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;

@Component
public class IBZUAAFallback implements IBZUAAFeignClient {

    @Override
    public JSONObject pushSystemPermissionData(Map<String, Object> systemPermissionData, String systemId) {
        return null;
    }

    @Override
    public AuthenticationUser login(AuthorizationLogin authorizationLogin) {
        return null;
    }

	@Override
    public AuthenticationUser loginByUsername(String username) {
        return null;
    }
}
