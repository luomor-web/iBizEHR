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
 * 服务DTO对象[UserRoleDetailDTO]
 */
@Data
public class UserRoleDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [USERROLEDETAILID]
     *
     */
    @JSONField(name = "userroledetailid")
    @JsonProperty("userroledetailid")
    private String userroledetailid;

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
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [USERTAG]
     *
     */
    @JSONField(name = "usertag")
    @JsonProperty("usertag")
    private String usertag;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [USERROLEDETAILNAME]
     *
     */
    @JSONField(name = "userroledetailname")
    @JsonProperty("userroledetailname")
    private String userroledetailname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [USEROBJECTNAME]
     *
     */
    @JSONField(name = "userobjectname")
    @JsonProperty("userobjectname")
    private String userobjectname;

    /**
     * 属性 [UESRROLENAME]
     *
     */
    @JSONField(name = "userrolename")
    @JsonProperty("userrolename")
    private String userrolename;

    /**
     * 属性 [USEROBJECTID]
     *
     */
    @JSONField(name = "userobjectid")
    @JsonProperty("userobjectid")
    private String userobjectid;

    /**
     * 属性 [USERROLEID]
     *
     */
    @JSONField(name = "userroleid")
    @JsonProperty("userroleid")
    private String userroleid;


    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [USERTAG]
     */
    public void setUsertag(String  usertag){
        this.usertag = usertag ;
        this.modify("usertag",usertag);
    }

    /**
     * 设置 [USERROLEDETAILNAME]
     */
    public void setUserroledetailname(String  userroledetailname){
        this.userroledetailname = userroledetailname ;
        this.modify("userroledetailname",userroledetailname);
    }

    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String  userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }

    /**
     * 设置 [USEROBJECTID]
     */
    public void setUserobjectid(String  userobjectid){
        this.userobjectid = userobjectid ;
        this.modify("userobjectid",userobjectid);
    }

    /**
     * 设置 [USERROLEID]
     */
    public void setUserroleid(String  userroleid){
        this.userroleid = userroleid ;
        this.modify("userroleid",userroleid);
    }


}

