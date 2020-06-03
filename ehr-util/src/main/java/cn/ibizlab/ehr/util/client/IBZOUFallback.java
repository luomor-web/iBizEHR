package cn.ibizlab.ehr.util.client;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class IBZOUFallback implements IBZOUFeignClient {

    @Override
    public Map<String, Set<String>> getOUMapsByUserId(String userId) {
        return null;
    }
}
