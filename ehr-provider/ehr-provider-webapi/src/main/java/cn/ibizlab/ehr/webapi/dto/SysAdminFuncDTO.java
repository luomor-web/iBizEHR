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
 * 服务DTO对象[SysAdminFuncDTO]
 */
@Data
public class SysAdminFuncDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PARAM]
     *
     */
    @JSONField(name = "param")
    @JsonProperty("param")
    private String param;

    /**
     * 属性 [FUNCID]
     *
     */
    @JSONField(name = "funcid")
    @JsonProperty("funcid")
    private String funcid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SYSADMINFUNCID]
     *
     */
    @JSONField(name = "sysadminfuncid")
    @JsonProperty("sysadminfuncid")
    private String sysadminfuncid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [SYSADMINFUNCNAME]
     *
     */
    @JSONField(name = "sysadminfuncname")
    @JsonProperty("sysadminfuncname")
    private String sysadminfuncname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [SYSADMINNAME]
     *
     */
    @JSONField(name = "sysadminname")
    @JsonProperty("sysadminname")
    private String sysadminname;

    /**
     * 属性 [ADMINOBJECT]
     *
     */
    @JSONField(name = "adminobject")
    @JsonProperty("adminobject")
    private String adminobject;

    /**
     * 属性 [SYSADMINID]
     *
     */
    @JSONField(name = "sysadminid")
    @JsonProperty("sysadminid")
    private String sysadminid;


    /**
     * 设置 [PARAM]
     */
    public void setParam(String  param){
        this.param = param ;
        this.modify("param",param);
    }

    /**
     * 设置 [FUNCID]
     */
    public void setFuncid(String  funcid){
        this.funcid = funcid ;
        this.modify("funcid",funcid);
    }

    /**
     * 设置 [SYSADMINFUNCNAME]
     */
    public void setSysadminfuncname(String  sysadminfuncname){
        this.sysadminfuncname = sysadminfuncname ;
        this.modify("sysadminfuncname",sysadminfuncname);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [SYSADMINID]
     */
    public void setSysadminid(String  sysadminid){
        this.sysadminid = sysadminid ;
        this.modify("sysadminid",sysadminid);
    }


}

