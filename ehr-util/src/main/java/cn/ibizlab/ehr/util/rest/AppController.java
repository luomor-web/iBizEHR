package cn.ibizlab.ehr.util.rest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import cn.ibizlab.ehr.util.security.AuthenticationUser;
import cn.ibizlab.ehr.util.service.AuthenticationUserService;

@RestController
@RequestMapping(value = "")
public class AppController {

	@Value("${ibiz.enablePermissionValid:false}")
    boolean enablePermissionValid;  //是否开启权限校验

	@Autowired
	private AuthenticationUserService userDetailsService;

	@RequestMapping(method = RequestMethod.GET, value = "/appdata")
	public ResponseEntity<JSONObject> getAppData() {

		JSONObject appData = new JSONObject() ;
		JSONArray uniRes=new JSONArray();
    	JSONArray appMenu=new JSONArray();
		if(enablePermissionValid){
			JSONObject userPermission=AuthenticationUser.getAuthenticationUser().getPermissionList();
			if(!ObjectUtils.isEmpty(userPermission)){
				uniRes = userPermission.getJSONArray("unires");
    			appMenu = userPermission.getJSONArray("appmenu");
			}
		}
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
}
