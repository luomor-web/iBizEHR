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
import cn.ibizlab.ehr.util.security.AuthenticationUser;

@RestController
@RequestMapping(value = "")
public class AppController {

	@Value("${ibiz.enablePermissionValid:false}")
    boolean enablePermissionValid;  //是否开启权限校验

	@RequestMapping(method = RequestMethod.GET, value = "/appdata")
	public ResponseEntity<JSONObject> getAppData() {

		JSONObject appData = new JSONObject() ;
		JSONArray uniRes=new JSONArray();
		if(enablePermissionValid){
			JSONObject userPermission=AuthenticationUser.getAuthenticationUser().getPermissionList();
			if(!ObjectUtils.isEmpty(userPermission)){
				uniRes = userPermission.getJSONArray("unires");
			}
		}
		appData.put("unires",uniRes);
		appData.put("enablepermissionvalid",enablePermissionValid);
		return ResponseEntity.status(HttpStatus.OK).body(appData);
	}
}
