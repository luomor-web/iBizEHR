package cn.ibizlab.ehr.util.rest;

import cn.ibizlab.ehr.util.errors.BadRequestAlertException;
import cn.ibizlab.ehr.util.service.IBZConfigService;
import com.alibaba.fastjson.JSONObject;
import cn.ibizlab.ehr.util.security.AuthenticationUser;
import cn.ibizlab.ehr.util.service.AuthenticationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(value = "")
public class AppController {

	@Value("${ibiz.enablePermissionValid:false}")
    boolean enablePermissionValid;  //是否开启权限校验

    @Value("${ibiz.systemid:ehr}")
	private String systemId;


	@Autowired
	private AuthenticationUserService userDetailsService;

	@RequestMapping(method = RequestMethod.GET, value = "/appdata")
	public ResponseEntity<JSONObject> getAppData() {

		JSONObject appData = new JSONObject() ;
		Set<String> appMenu = new HashSet();
		Set<String> uniRes = new HashSet();

		AuthenticationUser curUser = AuthenticationUser.getAuthenticationUser();
		if(enablePermissionValid){
			Collection<GrantedAuthority> authorities=curUser.getAuthorities();
				Iterator it = authorities.iterator();
				while(it.hasNext()) {
					GrantedAuthority authority = (GrantedAuthority)it.next();
					String strAuthority=authority.getAuthority();
					if(strAuthority.startsWith("UNIRES_"+systemId))
						uniRes.add(strAuthority.substring(systemId.length()+8));
					else if(strAuthority.startsWith("APPMENU_"+systemId))
						appMenu.add(strAuthority.substring(systemId.length()+9));
				}
		}
		Map<String,Object> context = new HashMap<>();
		context.putAll(curUser.getSessionParams());
		context.put("srfusername",curUser.getPersonname());
		appData.put("context",context);
		appData.put("unires",uniRes);
    	appData.put("appmenu",appMenu);
		appData.put("enablepermissionvalid",enablePermissionValid);
		return ResponseEntity.status(HttpStatus.OK).body(appData);
	}

    @RequestMapping(method = RequestMethod.GET, value = "${ibiz.auth.logoutpath:v7/logout}")
    public void logout() {
		if(AuthenticationUser.getAuthenticationUser()!=null){
			userDetailsService.resetByUsername(AuthenticationUser.getAuthenticationUser().getUsername());
    	}
    }

    @Autowired
	private IBZConfigService ibzConfigService;

	@RequestMapping(method = RequestMethod.PUT, value = "/configs/{configType}/{targetType}")
	public ResponseEntity<Boolean> saveConfig(@PathVariable("configType") String configType, @PathVariable("targetType") String targetType, @RequestBody JSONObject config) {
		String userId=AuthenticationUser.getAuthenticationUser().getUserid();
		if(StringUtils.isEmpty(userId))
			throw new BadRequestAlertException("保存配置失败，参数缺失","IBZConfig",configType);
		return ResponseEntity.ok(ibzConfigService.saveConfig(configType,targetType,userId,config));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/configs/{configType}/{targetType}")
	public ResponseEntity<JSONObject> getConfig(@PathVariable("configType") String configType, @PathVariable("targetType") String targetType) {
		String userId=AuthenticationUser.getAuthenticationUser().getUserid();
		if(StringUtils.isEmpty(userId))
			throw new BadRequestAlertException("获取配置失败，参数缺失","IBZConfig",configType);
		return ResponseEntity.ok(ibzConfigService.getConfig(configType,targetType,userId));
	}
}
