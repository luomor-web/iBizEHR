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
 * 服务DTO对象[SocSelfarebasemxDTO]
 */
@Data
public class SocSelfarebasemxDTO extends DTOBase implements Serializable {

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
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [GRBL]
     *
     */
    @JSONField(name = "grbl")
    @JsonProperty("grbl")
    private String grbl;

    /**
     * 属性 [SM]
     *
     */
    @JSONField(name = "sm")
    @JsonProperty("sm")
    private String sm;

    /**
     * 属性 [DWBL]
     *
     */
    @JSONField(name = "dwbl")
    @JsonProperty("dwbl")
    private String dwbl;

    /**
     * 属性 [SOCSELFAREBASEMXID]
     *
     */
    @JSONField(name = "socselfarebasemxid")
    @JsonProperty("socselfarebasemxid")
    private String socselfarebasemxid;

    /**
     * 属性 [SOCSELFAREBASEMXNAME]
     *
     */
    @JSONField(name = "socselfarebasemxname")
    @JsonProperty("socselfarebasemxname")
    private String socselfarebasemxname;

    /**
     * 属性 [SBFLLX]
     *
     */
    @JSONField(name = "sbfllx")
    @JsonProperty("sbfllx")
    private String sbfllx;

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
     * 属性 [DE]
     *
     */
    @JSONField(name = "de")
    @JsonProperty("de")
    private String de;

    /**
     * 属性 [SOCCOMPANYWELNAME]
     *
     */
    @JSONField(name = "soccompanywelname")
    @JsonProperty("soccompanywelname")
    private String soccompanywelname;

    /**
     * 属性 [SOCSELFAREBASEID]
     *
     */
    @JSONField(name = "socselfarebaseid")
    @JsonProperty("socselfarebaseid")
    private String socselfarebaseid;

    /**
     * 属性 [SOCCOMPANYWELID]
     *
     */
    @JSONField(name = "soccompanywelid")
    @JsonProperty("soccompanywelid")
    private String soccompanywelid;


    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [GRBL]
     */
    public void setGrbl(String  grbl){
        this.grbl = grbl ;
        this.modify("grbl",grbl);
    }

    /**
     * 设置 [SM]
     */
    public void setSm(String  sm){
        this.sm = sm ;
        this.modify("sm",sm);
    }

    /**
     * 设置 [DWBL]
     */
    public void setDwbl(String  dwbl){
        this.dwbl = dwbl ;
        this.modify("dwbl",dwbl);
    }

    /**
     * 设置 [SOCSELFAREBASEMXNAME]
     */
    public void setSocselfarebasemxname(String  socselfarebasemxname){
        this.socselfarebasemxname = socselfarebasemxname ;
        this.modify("socselfarebasemxname",socselfarebasemxname);
    }

    /**
     * 设置 [SBFLLX]
     */
    public void setSbfllx(String  sbfllx){
        this.sbfllx = sbfllx ;
        this.modify("sbfllx",sbfllx);
    }

    /**
     * 设置 [DE]
     */
    public void setDe(String  de){
        this.de = de ;
        this.modify("de",de);
    }

    /**
     * 设置 [SOCSELFAREBASEID]
     */
    public void setSocselfarebaseid(String  socselfarebaseid){
        this.socselfarebaseid = socselfarebaseid ;
        this.modify("socselfarebaseid",socselfarebaseid);
    }

    /**
     * 设置 [SOCCOMPANYWELID]
     */
    public void setSoccompanywelid(String  soccompanywelid){
        this.soccompanywelid = soccompanywelid ;
        this.modify("soccompanywelid",soccompanywelid);
    }


}

