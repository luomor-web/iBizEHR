package cn.ibizlab.ehr.util.client;

import cn.ibizlab.ehr.util.security.AuthenticationUser;
import cn.ibizlab.ehr.util.security.AuthorizationLogin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@FeignClient(value = "ibzuaa-api",fallback = IBZUAAFallback.class)
public interface IBZUAAFeignClient
{
	/**
	 * 推送系统权限数据到uaa
	 * @param systemPermissionData
	 * @param systemId
	 * @return
	 */
	@PostMapping("/uaa/permission/save")
	Map<String,Object> pushSystemPermissionData(@RequestBody Map<String, Object> systemPermissionData,  @RequestParam("systemid") String systemId);

	/**
	 * 用户登录
	 * @param authorizationLogin 登录信息
	 * @return
	 */
	@PostMapping(value = "/uaa/login")
	AuthenticationUser login(@RequestBody AuthorizationLogin authorizationLogin);


	@PostMapping(value = "/uaa/loginbyusername")
	AuthenticationUser loginByUsername(@RequestBody String username);
}
