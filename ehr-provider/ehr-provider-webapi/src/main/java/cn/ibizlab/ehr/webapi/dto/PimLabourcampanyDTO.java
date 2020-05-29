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
 * 服务DTO对象[PimLabourcampanyDTO]
 */
@Data
public class PimLabourcampanyDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [LXFS]
     *
     */
    @JSONField(name = "lxfs")
    @JsonProperty("lxfs")
    private String lxfs;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [LEGALPEROSN]
     *
     */
    @JSONField(name = "legalperosn")
    @JsonProperty("legalperosn")
    private String legalperosn;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [REGCAPITAL]
     *
     */
    @JSONField(name = "regcapital")
    @JsonProperty("regcapital")
    private String regcapital;

    /**
     * 属性 [PIMLABOURCAMPANYNAME]
     *
     */
    @JSONField(name = "pimlabourcampanyname")
    @JsonProperty("pimlabourcampanyname")
    private String pimlabourcampanyname;

    /**
     * 属性 [JYFW]
     *
     */
    @JSONField(name = "jyfw")
    @JsonProperty("jyfw")
    private String jyfw;

    /**
     * 属性 [PIMLABOURCAMPANYID]
     *
     */
    @JSONField(name = "pimlabourcampanyid")
    @JsonProperty("pimlabourcampanyid")
    private String pimlabourcampanyid;

    /**
     * 属性 [LXR]
     *
     */
    @JSONField(name = "lxr")
    @JsonProperty("lxr")
    private String lxr;

    /**
     * 属性 [GSJJ]
     *
     */
    @JSONField(name = "gsjj")
    @JsonProperty("gsjj")
    private String gsjj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [LXDZ]
     *
     */
    @JSONField(name = "lxdz")
    @JsonProperty("lxdz")
    private String lxdz;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [LXFS]
     */
    public void setLxfs(String  lxfs){
        this.lxfs = lxfs ;
        this.modify("lxfs",lxfs);
    }

    /**
     * 设置 [LEGALPEROSN]
     */
    public void setLegalperosn(String  legalperosn){
        this.legalperosn = legalperosn ;
        this.modify("legalperosn",legalperosn);
    }

    /**
     * 设置 [REGCAPITAL]
     */
    public void setRegcapital(String  regcapital){
        this.regcapital = regcapital ;
        this.modify("regcapital",regcapital);
    }

    /**
     * 设置 [PIMLABOURCAMPANYNAME]
     */
    public void setPimlabourcampanyname(String  pimlabourcampanyname){
        this.pimlabourcampanyname = pimlabourcampanyname ;
        this.modify("pimlabourcampanyname",pimlabourcampanyname);
    }

    /**
     * 设置 [JYFW]
     */
    public void setJyfw(String  jyfw){
        this.jyfw = jyfw ;
        this.modify("jyfw",jyfw);
    }

    /**
     * 设置 [LXR]
     */
    public void setLxr(String  lxr){
        this.lxr = lxr ;
        this.modify("lxr",lxr);
    }

    /**
     * 设置 [GSJJ]
     */
    public void setGsjj(String  gsjj){
        this.gsjj = gsjj ;
        this.modify("gsjj",gsjj);
    }

    /**
     * 设置 [LXDZ]
     */
    public void setLxdz(String  lxdz){
        this.lxdz = lxdz ;
        this.modify("lxdz",lxdz);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

