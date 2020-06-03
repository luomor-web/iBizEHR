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
 * 服务DTO对象[PcmPcmSgqMgrDTO]
 */
@Data
public class PcmPcmSgqMgrDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SGQMGRNAME]
     *
     */
    @JSONField(name = "sgqmgrname")
    @JsonProperty("sgqmgrname")
    private String sgqmgrname;

    /**
     * 属性 [SGQMGRID]
     *
     */
    @JSONField(name = "sgqmgrid")
    @JsonProperty("sgqmgrid")
    private String sgqmgrid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [KSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kssj" , format="yyyy-MM-dd")
    @JsonProperty("kssj")
    private Timestamp kssj;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [JSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [SFTGSH]
     *
     */
    @JSONField(name = "sftgsh")
    @JsonProperty("sftgsh")
    private Integer sftgsh;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PCMBDSQDMXID]
     *
     */
    @JSONField(name = "pcmbdsqdmxid")
    @JsonProperty("pcmbdsqdmxid")
    private String pcmbdsqdmxid;


    /**
     * 设置 [SGQMGRNAME]
     */
    public void setSgqmgrname(String  sgqmgrname){
        this.sgqmgrname = sgqmgrname ;
        this.modify("sgqmgrname",sgqmgrname);
    }

    /**
     * 设置 [KSSJ]
     */
    public void setKssj(Timestamp  kssj){
        this.kssj = kssj ;
        this.modify("kssj",kssj);
    }

    /**
     * 设置 [JSSJ]
     */
    public void setJssj(Timestamp  jssj){
        this.jssj = jssj ;
        this.modify("jssj",jssj);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [SFTGSH]
     */
    public void setSftgsh(Integer  sftgsh){
        this.sftgsh = sftgsh ;
        this.modify("sftgsh",sftgsh);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [PCMBDSQDMXID]
     */
    public void setPcmbdsqdmxid(String  pcmbdsqdmxid){
        this.pcmbdsqdmxid = pcmbdsqdmxid ;
        this.modify("pcmbdsqdmxid",pcmbdsqdmxid);
    }


}

