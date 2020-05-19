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
 * 服务DTO对象[WFUserGroupDetailDTO]
 */
@Data
public class WFUserGroupDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [WFUSERGROUPDETAILID]
     *
     */
    @JSONField(name = "wfusergroupdetailid")
    @JsonProperty("wfusergroupdetailid")
    private String wfusergroupdetailid;

    /**
     * 属性 [WFUSERGROUPDETAILNAME]
     *
     */
    @JSONField(name = "wfusergroupdetailname")
    @JsonProperty("wfusergroupdetailname")
    private String wfusergroupdetailname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [WFUSERGROUPNAME]
     *
     */
    @JSONField(name = "wfusergroupname")
    @JsonProperty("wfusergroupname")
    private String wfusergroupname;

    /**
     * 属性 [WFUSERNAME]
     *
     */
    @JSONField(name = "wfusername")
    @JsonProperty("wfusername")
    private String wfusername;

    /**
     * 属性 [WFUSERID]
     *
     */
    @JSONField(name = "wfuserid")
    @JsonProperty("wfuserid")
    private String wfuserid;

    /**
     * 属性 [WFUSERGROUPID]
     *
     */
    @JSONField(name = "wfusergroupid")
    @JsonProperty("wfusergroupid")
    private String wfusergroupid;


    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [WFUSERGROUPDETAILNAME]
     */
    public void setWfusergroupdetailname(String  wfusergroupdetailname){
        this.wfusergroupdetailname = wfusergroupdetailname ;
        this.modify("wfusergroupdetailname",wfusergroupdetailname);
    }

    /**
     * 设置 [WFUSERID]
     */
    public void setWfuserid(String  wfuserid){
        this.wfuserid = wfuserid ;
        this.modify("wfuserid",wfuserid);
    }

    /**
     * 设置 [WFUSERGROUPID]
     */
    public void setWfusergroupid(String  wfusergroupid){
        this.wfusergroupid = wfusergroupid ;
        this.modify("wfusergroupid",wfusergroupid);
    }


}

