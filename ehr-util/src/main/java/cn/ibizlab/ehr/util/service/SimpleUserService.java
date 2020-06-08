package cn.ibizlab.ehr.util.service;

import cn.ibizlab.ehr.util.security.AuthenticationUser;
import cn.ibizlab.ehr.util.client.IBZUAAFeignClient;
import cn.ibizlab.ehr.util.client.IBZOUFeignClient;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.security.core.authority.AuthorityUtils;
/**
 * 实体[IBZUSER] 服务对象接口实现
 */
@Primary
@Service("SimpleUserService")
@ConditionalOnExpression("(!${ibiz.enablePermissionValid:false})&&'${ibiz.auth.service:SimpleUserService}'.equals('SimpleUserService')")
public class SimpleUserService implements AuthenticationUserService{

	@Override
	public AuthenticationUser loadUserByUsername(String username) {
		AuthenticationUser user = new AuthenticationUser();
		String[] data=username.split("[|]");
		String loginname=username;
		String domains="";
		String password="";

		if(data.length==2) {
			loginname=data[0].trim();
			domains=data[1].trim();
		}

		user.setUserid(username);
		user.setUsercode(loginname);
		user.setUsername(username);
		user.setLoginname(loginname);
		user.setPersonname(loginname);
		user.setDomain(domains);
		user.setPassword(password);
		user.setOrgid(domains);
		user.setOrgcode(domains);
		user.setOrgname(domains);
		user.setSuperuser(1);
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_SUPERADMIN"));

		return user;
	}

	@Override
	public AuthenticationUser loadUserByLogin(String username, String password) {
		AuthenticationUser authuserdetail = loadUserByUsername(username);
		return authuserdetail;
	}



	@Override
	public void resetByUsername(String username) {

	}

}
