package cn.ibizlab.ehr.util.service;


import cn.ibizlab.ehr.util.errors.BadRequestAlertException;
import cn.ibizlab.ehr.util.security.AuthenticationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface AuthenticationUserService extends UserDetailsService {


    @Override
    @Cacheable( value="ehr_users",key = "'getByUsername:'+#p0")
    AuthenticationUser loadUserByUsername(String username);

    @Cacheable( value="ehr_users",key = "'getByUsername:'+#p0")
    AuthenticationUser loadUserByLogin(String username,String password);

    @CacheEvict( value="ehr_users",key = "'getByUsername:'+#p0")
    void resetByUsername(String username);
}
