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
 * 服务DTO对象[SocWelfareInfoDTO]
 */
@Data
public class SocWelfareInfoDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [SXSJ2]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxsj2" , format="yyyy-MM-dd")
    @JsonProperty("sxsj2")
    private Timestamp sxsj2;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [GRGJJZH]
     *
     */
    @JSONField(name = "grgjjzh")
    @JsonProperty("grgjjzh")
    private String grgjjzh;

    /**
     * 属性 [GRSBZH]
     *
     */
    @JSONField(name = "grsbzh")
    @JsonProperty("grsbzh")
    private String grsbzh;

    /**
     * 属性 [SOCWELFAREINFONAME]
     *
     */
    @JSONField(name = "socwelfareinfoname")
    @JsonProperty("socwelfareinfoname")
    private String socwelfareinfoname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SOCWELFAREINFOID]
     *
     */
    @JSONField(name = "socwelfareinfoid")
    @JsonProperty("socwelfareinfoid")
    private String socwelfareinfoid;

    /**
     * 属性 [SXSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxsj" , format="yyyy-MM-dd")
    @JsonProperty("sxsj")
    private Timestamp sxsj;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [SOCSELFAREBASENAME]
     *
     */
    @JSONField(name = "socselfarebasename")
    @JsonProperty("socselfarebasename")
    private String socselfarebasename;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [SOCCOMPANYWELNAME]
     *
     */
    @JSONField(name = "soccompanywelname")
    @JsonProperty("soccompanywelname")
    private String soccompanywelname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [SOCCOMPANYWELID]
     *
     */
    @JSONField(name = "soccompanywelid")
    @JsonProperty("soccompanywelid")
    private String soccompanywelid;


    /**
     * 设置 [SXSJ2]
     */
    public void setSxsj2(Timestamp  sxsj2){
        this.sxsj2 = sxsj2 ;
        this.modify("sxsj2",sxsj2);
    }

    /**
     * 设置 [GRGJJZH]
     */
    public void setGrgjjzh(String  grgjjzh){
        this.grgjjzh = grgjjzh ;
        this.modify("grgjjzh",grgjjzh);
    }

    /**
     * 设置 [GRSBZH]
     */
    public void setGrsbzh(String  grsbzh){
        this.grsbzh = grsbzh ;
        this.modify("grsbzh",grsbzh);
    }

    /**
     * 设置 [SOCWELFAREINFONAME]
     */
    public void setSocwelfareinfoname(String  socwelfareinfoname){
        this.socwelfareinfoname = socwelfareinfoname ;
        this.modify("socwelfareinfoname",socwelfareinfoname);
    }

    /**
     * 设置 [SXSJ]
     */
    public void setSxsj(Timestamp  sxsj){
        this.sxsj = sxsj ;
        this.modify("sxsj",sxsj);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [SOCCOMPANYWELID]
     */
    public void setSoccompanywelid(String  soccompanywelid){
        this.soccompanywelid = soccompanywelid ;
        this.modify("soccompanywelid",soccompanywelid);
    }


}

