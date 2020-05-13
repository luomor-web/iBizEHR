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
 * 服务DTO对象[UserGroupDTO]
 */
@Data
public class UserGroupDTO extends DTOBase implements Serializable {

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
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [OWNERID]
     *
     */
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [SUBTYPE]
     *
     */
    @JSONField(name = "subtype")
    @JsonProperty("subtype")
    private String subtype;

    /**
     * 属性 [USEROBJECTTYPE]
     *
     */
    @JSONField(name = "userobjecttype")
    @JsonProperty("userobjecttype")
    private String userobjecttype;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [USEROBJECTLEVEL]
     *
     */
    @JSONField(name = "userobjectlevel")
    @JsonProperty("userobjectlevel")
    private Integer userobjectlevel;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [USERGROUPNAME]
     *
     */
    @JSONField(name = "usergroupname")
    @JsonProperty("usergroupname")
    private String usergroupname;

    /**
     * 属性 [OWNERTYPE]
     *
     */
    @JSONField(name = "ownertype")
    @JsonProperty("ownertype")
    private String ownertype;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [USERGROUPID]
     *
     */
    @JSONField(name = "usergroupid")
    @JsonProperty("usergroupid")
    private String usergroupid;


    /**
     * 设置 [USERGROUPNAME]
     */
    public void setUsergroupname(String  usergroupname){
        this.usergroupname = usergroupname ;
        this.modify("usergroupname",usergroupname);
    }


}

