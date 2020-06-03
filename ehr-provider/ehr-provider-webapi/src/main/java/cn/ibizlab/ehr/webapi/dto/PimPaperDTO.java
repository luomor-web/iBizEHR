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
 * 服务DTO对象[PimPaperDTO]
 */
@Data
public class PimPaperDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [GRZLWZZZDPM]
     *
     */
    @JSONField(name = "grzlwzzzdpm")
    @JsonProperty("grzlwzzzdpm")
    private Integer grzlwzzzdpm;

    /**
     * 属性 [JLGLBH]
     *
     */
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [JLCZZ]
     *
     */
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;

    /**
     * 属性 [PIMPAPERID]
     *
     */
    @JSONField(name = "pimpaperid")
    @JsonProperty("pimpaperid")
    private String pimpaperid;

    /**
     * 属性 [JLSPZT]
     *
     */
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;

    /**
     * 属性 [REASON]
     *
     */
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;

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
     * 属性 [KWMC]
     *
     */
    @JSONField(name = "kwmc")
    @JsonProperty("kwmc")
    private String kwmc;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [FBSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "fbsj" , format="yyyy-MM-dd")
    @JsonProperty("fbsj")
    private Timestamp fbsj;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [PIMPAPERNAME]
     *
     */
    @JSONField(name = "pimpapername")
    @JsonProperty("pimpapername")
    private String pimpapername;

    /**
     * 属性 [KWQS]
     *
     */
    @JSONField(name = "kwqs")
    @JsonProperty("kwqs")
    private Integer kwqs;

    /**
     * 属性 [CBS]
     *
     */
    @JSONField(name = "cbs")
    @JsonProperty("cbs")
    private String cbs;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [CBSHKWMC]
     *
     */
    @JSONField(name = "cbshkwmc")
    @JsonProperty("cbshkwmc")
    private String cbshkwmc;

    /**
     * 属性 [JLSS]
     *
     */
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [GRZLWZZZDPM]
     */
    public void setGrzlwzzzdpm(Integer  grzlwzzzdpm){
        this.grzlwzzzdpm = grzlwzzzdpm ;
        this.modify("grzlwzzzdpm",grzlwzzzdpm);
    }

    /**
     * 设置 [JLGLBH]
     */
    public void setJlglbh(String  jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [JLCZZ]
     */
    public void setJlczz(String  jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [JLSPZT]
     */
    public void setJlspzt(String  jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [REASON]
     */
    public void setReason(String  reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [KWMC]
     */
    public void setKwmc(String  kwmc){
        this.kwmc = kwmc ;
        this.modify("kwmc",kwmc);
    }

    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [FBSJ]
     */
    public void setFbsj(Timestamp  fbsj){
        this.fbsj = fbsj ;
        this.modify("fbsj",fbsj);
    }

    /**
     * 设置 [PIMPAPERNAME]
     */
    public void setPimpapername(String  pimpapername){
        this.pimpapername = pimpapername ;
        this.modify("pimpapername",pimpapername);
    }

    /**
     * 设置 [KWQS]
     */
    public void setKwqs(Integer  kwqs){
        this.kwqs = kwqs ;
        this.modify("kwqs",kwqs);
    }

    /**
     * 设置 [CBS]
     */
    public void setCbs(String  cbs){
        this.cbs = cbs ;
        this.modify("cbs",cbs);
    }

    /**
     * 设置 [CBSHKWMC]
     */
    public void setCbshkwmc(String  cbshkwmc){
        this.cbshkwmc = cbshkwmc ;
        this.modify("cbshkwmc",cbshkwmc);
    }

    /**
     * 设置 [JLSS]
     */
    public void setJlss(String  jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

