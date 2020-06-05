package cn.ibizlab.ehr.util.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.util.security.AuthenticationUser;
import cn.ibizlab.ehr.util.errors.BadRequestAlertException;
import cn.ibizlab.ehr.util.helper.CachedBeanCopier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import cn.ibizlab.ehr.util.mapper.IBZUSERMapper;
import cn.ibizlab.ehr.util.domain.IBZUSER;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * 实体[IBZUSER] 服务对象接口实现
 */
@Service("IBZUSERService")
@ConditionalOnExpression("(!${ibiz.enablePermissionValid:false})&&'${ibiz.auth.service:SimpleUserService}'.equals('IBZUSERService')")
public class IBZUSERServiceImpl extends ServiceImpl<IBZUSERMapper, IBZUSER> implements IBZUSERService,AuthenticationUserService{

	@Value("${ibiz.auth.pwencrymode:0}")
	private int pwencrymode;

	@Override
	public AuthenticationUser loadUserByUsername(String username) {
		if(StringUtils.isEmpty(username))
			throw new UsernameNotFoundException("用户名为空");
		QueryWrapper<IBZUSER> conds=new QueryWrapper<IBZUSER>();
		String[] data=username.split("[|]");
		String loginname="";
		String domains="";
		if(data.length>0)
			loginname=data[0].trim();
		if(data.length>1)
			domains=data[1].trim();
		if(!StringUtils.isEmpty(loginname))
			conds.eq("loginname",loginname);
		if(!StringUtils.isEmpty(domains))
			conds.eq("domains",domains);
		IBZUSER user = this.getOne(conds);
		if (user == null) {
			throw new UsernameNotFoundException("用户" + username + "未找到");
		}
		else {
			user.setUsername(username);
			return createUserDetails(user);
		}
	}

	@Override
	public AuthenticationUser loadUserByLogin(String username, String password){
		AuthenticationUser authuserdetail = loadUserByUsername(username);
		if(pwencrymode==1)
			password = DigestUtils.md5DigestAsHex(password.getBytes());
		else if(pwencrymode==2)
			password = DigestUtils.md5DigestAsHex(String.format("%1$s||%2$s", username, password).getBytes());
		if(!authuserdetail.getPassword().equals( password )){
			throw new BadRequestAlertException("用户名密码错误","IBZUSER",username);
		}
		return authuserdetail;
	}


	public void resetByUsername(String username) {

	}

	public  AuthenticationUser createUserDetails(IBZUSER user) {
		AuthenticationUser userdatail = new AuthenticationUser();
		CachedBeanCopier.copy(user,userdatail);
    	if(userdatail.getSuperuser()==1){
    		userdatail.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_SUPERADMIN"));
    	}
		return userdatail;
	}
}