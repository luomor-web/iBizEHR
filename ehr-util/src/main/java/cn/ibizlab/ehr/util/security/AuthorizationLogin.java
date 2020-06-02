package cn.ibizlab.ehr.util.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizationLogin
{

    private String domain;

    @NotBlank(message="用户名不能为空")
    private String loginname;

    @NotBlank(message="密码不能为空")
    private String password;


    public String getUsername()
    {
        if(!StringUtils.isEmpty(domain))
            return loginname+"|"+domain;
        return loginname;
    }


    @Override
    public String toString()
    {
        return "AuthorizationLogin{" +
                "domain='" + domain + '\'' +
                ", loginname='" + loginname + '\'' +
                ", password='××××××'}";
    }
}
