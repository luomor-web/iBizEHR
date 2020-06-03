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
 * 服务DTO对象[OrmPostLibDTO]
 */
@Data
public class OrmPostLibDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MUSTEXCYEAR]
     *
     */
    @JSONField(name = "mustexcyear")
    @JsonProperty("mustexcyear")
    private Integer mustexcyear;

    /**
     * 属性 [POSTNATURE]
     *
     */
    @JSONField(name = "postnature")
    @JsonProperty("postnature")
    private String postnature;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [JOBDESC]
     *
     */
    @JSONField(name = "jobdesc")
    @JsonProperty("jobdesc")
    private String jobdesc;

    /**
     * 属性 [ORMPOSTLIBID]
     *
     */
    @JSONField(name = "ormpostlibid")
    @JsonProperty("ormpostlibid")
    private String ormpostlibid;

    /**
     * 属性 [GWFLAG]
     *
     */
    @JSONField(name = "gwflag")
    @JsonProperty("gwflag")
    private String gwflag;

    /**
     * 属性 [SUGEXCYEAR]
     *
     */
    @JSONField(name = "sugexcyear")
    @JsonProperty("sugexcyear")
    private Integer sugexcyear;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [GWTYPE]
     *
     */
    @JSONField(name = "gwtype")
    @JsonProperty("gwtype")
    private String gwtype;

    /**
     * 属性 [ISCONFIDENTIAL]
     *
     */
    @JSONField(name = "isconfidential")
    @JsonProperty("isconfidential")
    private String isconfidential;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ORMPOSTLIBNAME]
     *
     */
    @JSONField(name = "ormpostlibname")
    @JsonProperty("ormpostlibname")
    private String ormpostlibname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;


    /**
     * 设置 [MUSTEXCYEAR]
     */
    public void setMustexcyear(Integer  mustexcyear){
        this.mustexcyear = mustexcyear ;
        this.modify("mustexcyear",mustexcyear);
    }

    /**
     * 设置 [POSTNATURE]
     */
    public void setPostnature(String  postnature){
        this.postnature = postnature ;
        this.modify("postnature",postnature);
    }

    /**
     * 设置 [JOBDESC]
     */
    public void setJobdesc(String  jobdesc){
        this.jobdesc = jobdesc ;
        this.modify("jobdesc",jobdesc);
    }

    /**
     * 设置 [GWFLAG]
     */
    public void setGwflag(String  gwflag){
        this.gwflag = gwflag ;
        this.modify("gwflag",gwflag);
    }

    /**
     * 设置 [SUGEXCYEAR]
     */
    public void setSugexcyear(Integer  sugexcyear){
        this.sugexcyear = sugexcyear ;
        this.modify("sugexcyear",sugexcyear);
    }

    /**
     * 设置 [GWTYPE]
     */
    public void setGwtype(String  gwtype){
        this.gwtype = gwtype ;
        this.modify("gwtype",gwtype);
    }

    /**
     * 设置 [ISCONFIDENTIAL]
     */
    public void setIsconfidential(String  isconfidential){
        this.isconfidential = isconfidential ;
        this.modify("isconfidential",isconfidential);
    }

    /**
     * 设置 [ORMPOSTLIBNAME]
     */
    public void setOrmpostlibname(String  ormpostlibname){
        this.ormpostlibname = ormpostlibname ;
        this.modify("ormpostlibname",ormpostlibname);
    }


}

