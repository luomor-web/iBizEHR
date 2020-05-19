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
 * 服务DTO对象[WFUserAssistDTO]
 */
@Data
public class WFUserAssistDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [WFUSERASSISTNAME]
     *
     */
    @JSONField(name = "wfuserassistname")
    @JsonProperty("wfuserassistname")
    private String wfuserassistname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [WFSTEP]
     *
     */
    @JSONField(name = "wfstep")
    @JsonProperty("wfstep")
    private String wfstep;

    /**
     * 属性 [WFUSERASSISTID]
     *
     */
    @JSONField(name = "wfuserassistid")
    @JsonProperty("wfuserassistid")
    private String wfuserassistid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [WFMAJORUSERNAME]
     *
     */
    @JSONField(name = "wfmajorusername")
    @JsonProperty("wfmajorusername")
    private String wfmajorusername;

    /**
     * 属性 [WFMINORUSERNAME]
     *
     */
    @JSONField(name = "wfminorusername")
    @JsonProperty("wfminorusername")
    private String wfminorusername;

    /**
     * 属性 [WFWORKFLOWNAME]
     *
     */
    @JSONField(name = "wfworkflowname")
    @JsonProperty("wfworkflowname")
    private String wfworkflowname;

    /**
     * 属性 [WFMINORUSERID]
     *
     */
    @JSONField(name = "wfminoruserid")
    @JsonProperty("wfminoruserid")
    private String wfminoruserid;

    /**
     * 属性 [WFWORKFLOWID]
     *
     */
    @JSONField(name = "wfworkflowid")
    @JsonProperty("wfworkflowid")
    private String wfworkflowid;

    /**
     * 属性 [WFMAJORUSERID]
     *
     */
    @JSONField(name = "wfmajoruserid")
    @JsonProperty("wfmajoruserid")
    private String wfmajoruserid;


    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [WFUSERASSISTNAME]
     */
    public void setWfuserassistname(String  wfuserassistname){
        this.wfuserassistname = wfuserassistname ;
        this.modify("wfuserassistname",wfuserassistname);
    }

    /**
     * 设置 [WFSTEP]
     */
    public void setWfstep(String  wfstep){
        this.wfstep = wfstep ;
        this.modify("wfstep",wfstep);
    }

    /**
     * 设置 [WFMINORUSERID]
     */
    public void setWfminoruserid(String  wfminoruserid){
        this.wfminoruserid = wfminoruserid ;
        this.modify("wfminoruserid",wfminoruserid);
    }

    /**
     * 设置 [WFWORKFLOWID]
     */
    public void setWfworkflowid(String  wfworkflowid){
        this.wfworkflowid = wfworkflowid ;
        this.modify("wfworkflowid",wfworkflowid);
    }

    /**
     * 设置 [WFMAJORUSERID]
     */
    public void setWfmajoruserid(String  wfmajoruserid){
        this.wfmajoruserid = wfmajoruserid ;
        this.modify("wfmajoruserid",wfmajoruserid);
    }


}

