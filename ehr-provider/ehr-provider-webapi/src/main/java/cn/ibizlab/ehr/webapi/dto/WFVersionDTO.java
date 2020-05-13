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
 * 服务DTO对象[WFVersionDTO]
 */
@Data
public class WFVersionDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [WFVERSION]
     *
     */
    @JSONField(name = "wfversion")
    @JsonProperty("wfversion")
    private Integer wfversion;

    /**
     * 属性 [WFWFVERSIONNAME]
     *
     */
    @JSONField(name = "wfversionname")
    @JsonProperty("wfversionname")
    private String wfversionname;

    /**
     * 属性 [WFVERLANRESTAG]
     *
     */
    @JSONField(name = "wfverlanrestag")
    @JsonProperty("wfverlanrestag")
    private String wfverlanrestag;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [WFWFVERSIONID]
     *
     */
    @JSONField(name = "wfversionid")
    @JsonProperty("wfversionid")
    private String wfversionid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

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
     * 属性 [WFMODEL]
     *
     */
    @JSONField(name = "wfmodel")
    @JsonProperty("wfmodel")
    private String wfmodel;

    /**
     * 属性 [WFWFNAME]
     *
     */
    @JSONField(name = "wfwfname")
    @JsonProperty("wfwfname")
    private String wfwfname;

    /**
     * 属性 [WFWFID]
     *
     */
    @JSONField(name = "wfwfid")
    @JsonProperty("wfwfid")
    private String wfwfid;


    /**
     * 设置 [WFVERSION]
     */
    public void setWfversion(Integer  wfversion){
        this.wfversion = wfversion ;
        this.modify("wfversion",wfversion);
    }

    /**
     * 设置 [WFWFVERSIONNAME]
     */
    public void setWfversionname(String  wfversionname){
        this.wfversionname = wfversionname ;
        this.modify("wfwfversionname",wfversionname);
    }

    /**
     * 设置 [WFVERLANRESTAG]
     */
    public void setWfverlanrestag(String  wfverlanrestag){
        this.wfverlanrestag = wfverlanrestag ;
        this.modify("wfverlanrestag",wfverlanrestag);
    }

    /**
     * 设置 [WFMODEL]
     */
    public void setWfmodel(String  wfmodel){
        this.wfmodel = wfmodel ;
        this.modify("wfmodel",wfmodel);
    }

    /**
     * 设置 [WFWFID]
     */
    public void setWfwfid(String  wfwfid){
        this.wfwfid = wfwfid ;
        this.modify("wfwfid",wfwfid);
    }


}

