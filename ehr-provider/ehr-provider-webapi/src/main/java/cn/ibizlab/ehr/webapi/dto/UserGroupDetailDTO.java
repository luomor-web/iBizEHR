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
 * 服务DTO对象[UserGroupDetailDTO]
 */
@Data
public class UserGroupDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [USERGROUPDETAILNAME]
     *
     */
    @JSONField(name = "usergroupdetailname")
    @JsonProperty("usergroupdetailname")
    private String usergroupdetailname;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [USERGROUPDETAILID]
     *
     */
    @JSONField(name = "usergroupdetailid")
    @JsonProperty("usergroupdetailid")
    private String usergroupdetailid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [USEROBJECTNAME]
     *
     */
    @JSONField(name = "userobjectname")
    @JsonProperty("userobjectname")
    private String userobjectname;

    /**
     * 属性 [USERGROUPNAME]
     *
     */
    @JSONField(name = "usergroupname")
    @JsonProperty("usergroupname")
    private String usergroupname;

    /**
     * 属性 [USERGROUPID]
     *
     */
    @JSONField(name = "usergroupid")
    @JsonProperty("usergroupid")
    private String usergroupid;

    /**
     * 属性 [USEROBJECTID]
     *
     */
    @JSONField(name = "userobjectid")
    @JsonProperty("userobjectid")
    private String userobjectid;


    /**
     * 设置 [USERGROUPDETAILNAME]
     */
    public void setUsergroupdetailname(String  usergroupdetailname){
        this.usergroupdetailname = usergroupdetailname ;
        this.modify("usergroupdetailname",usergroupdetailname);
    }

    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String  userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }

    /**
     * 设置 [USERGROUPID]
     */
    public void setUsergroupid(String  usergroupid){
        this.usergroupid = usergroupid ;
        this.modify("usergroupid",usergroupid);
    }

    /**
     * 设置 [USEROBJECTID]
     */
    public void setUserobjectid(String  userobjectid){
        this.userobjectid = userobjectid ;
        this.modify("userobjectid",userobjectid);
    }


}

