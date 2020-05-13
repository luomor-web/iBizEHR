package cn.ibizlab.ehr.webapi.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.ehr.util.domain.DTOBase;
import lombok.Data;

/**
 * 服务DTO对象[UserRoleResDTO]
 */
@Data
public class UserRoleResDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [ISALLOW]
     *
     */
    @JSONField(name = "isallow")
    @JsonProperty("isallow")
    private Integer isallow;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [USERROLERESID]
     *
     */
    @JSONField(name = "userroleresid")
    @JsonProperty("userroleresid")
    private String userroleresid;

    /**
     * 属性 [USERROLERESNAME]
     *
     */
    @JSONField(name = "userroleresname")
    @JsonProperty("userroleresname")
    private String userroleresname;

    /**
     * 属性 [USERROLENAME]
     *
     */
    @JSONField(name = "userrolename")
    @JsonProperty("userrolename")
    private String userrolename;

    /**
     * 属性 [UNIRESNAME]
     *
     */
    @JSONField(name = "uniresname")
    @JsonProperty("uniresname")
    private String uniresname;

    /**
     * 属性 [UNIRESTYPE]
     *
     */
    @JSONField(name = "unirestype")
    @JsonProperty("unirestype")
    private String unirestype;

    /**
     * 属性 [USERROLEID]
     *
     */
    @JSONField(name = "userroleid")
    @JsonProperty("userroleid")
    private String userroleid;

    /**
     * 属性 [UNIRESID]
     *
     */
    @JSONField(name = "uniresid")
    @JsonProperty("uniresid")
    private String uniresid;


    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [ISALLOW]
     */
    public void setIsallow(Integer  isallow){
        this.isallow = isallow ;
        this.modify("isallow",isallow);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [USERROLERESNAME]
     */
    public void setUserroleresname(String  userroleresname){
        this.userroleresname = userroleresname ;
        this.modify("userroleresname",userroleresname);
    }

    /**
     * 设置 [USERROLEID]
     */
    public void setUserroleid(String  userroleid){
        this.userroleid = userroleid ;
        this.modify("userroleid",userroleid);
    }

    /**
     * 设置 [UNIRESID]
     */
    public void setUniresid(String  uniresid){
        this.uniresid = uniresid ;
        this.modify("uniresid",uniresid);
    }


}

