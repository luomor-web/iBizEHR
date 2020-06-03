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
 * 服务DTO对象[PcmYdgzmxDTO]
 */
@Data
public class PcmYdgzmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CHECKSTATUS]
     *
     */
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;

    /**
     * 属性 [ZZID]
     *
     */
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;

    /**
     * 属性 [WBGW]
     *
     */
    @JSONField(name = "wbgw")
    @JsonProperty("wbgw")
    private String wbgw;

    /**
     * 属性 [SYYF_COLOR]
     *
     */
    @JSONField(name = "syyf_color")
    @JsonProperty("syyf_color")
    private String syyfColor;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [JSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;

    /**
     * 属性 [GZTYPE]
     *
     */
    @JSONField(name = "gztype")
    @JsonProperty("gztype")
    private String gztype;

    /**
     * 属性 [BMID]
     *
     */
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;

    /**
     * 属性 [WWZZID]
     *
     */
    @JSONField(name = "wwzzid")
    @JsonProperty("wwzzid")
    private String wwzzid;

    /**
     * 属性 [CSRQ]
     *
     */
    @JSONField(name = "csrq")
    @JsonProperty("csrq")
    private Timestamp csrq;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [KSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ksrq" , format="yyyy-MM-dd")
    @JsonProperty("ksrq")
    private Timestamp ksrq;

    /**
     * 属性 [PCMYDGZMXNAME]
     *
     */
    @JSONField(name = "pcmydgzmxname")
    @JsonProperty("pcmydgzmxname")
    private String pcmydgzmxname;

    /**
     * 属性 [YRANK]
     *
     */
    @JSONField(name = "yrank")
    @JsonProperty("yrank")
    private String yrank;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [CZ]
     *
     */
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;

    /**
     * 属性 [SFDQ]
     *
     */
    @JSONField(name = "sfdq")
    @JsonProperty("sfdq")
    private String sfdq;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SXRQ]
     *
     */
    @JSONField(name = "sxrq")
    @JsonProperty("sxrq")
    private Timestamp sxrq;

    /**
     * 属性 [YGW]
     *
     */
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;

    /**
     * 属性 [FINISHED]
     *
     */
    @JSONField(name = "finished")
    @JsonProperty("finished")
    private Integer finished;

    /**
     * 属性 [SYYF]
     *
     */
    @JSONField(name = "syyf")
    @JsonProperty("syyf")
    private Integer syyf;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [PCMYDGZMXID]
     *
     */
    @JSONField(name = "pcmydgzmxid")
    @JsonProperty("pcmydgzmxid")
    private String pcmydgzmxid;

    /**
     * 属性 [PCMYDMXTYPE]
     *
     */
    @JSONField(name = "pcmydmxtype")
    @JsonProperty("pcmydmxtype")
    private String pcmydmxtype;

    /**
     * 属性 [PCMPROFILEID]
     *
     */
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;

    /**
     * 属性 [WBZZ]
     *
     */
    @JSONField(name = "wbzz")
    @JsonProperty("wbzz")
    private String wbzz;

    /**
     * 属性 [WBZW]
     *
     */
    @JSONField(name = "wbzw")
    @JsonProperty("wbzw")
    private String wbzw;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [WBBM]
     *
     */
    @JSONField(name = "wbbm")
    @JsonProperty("wbbm")
    private String wbbm;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [NL]
     *
     */
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [YZW]
     *
     */
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;


    /**
     * 设置 [WBGW]
     */
    public void setWbgw(String  wbgw){
        this.wbgw = wbgw ;
        this.modify("wbgw",wbgw);
    }

    /**
     * 设置 [JSRQ]
     */
    public void setJsrq(Timestamp  jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 设置 [GZTYPE]
     */
    public void setGztype(String  gztype){
        this.gztype = gztype ;
        this.modify("gztype",gztype);
    }

    /**
     * 设置 [WWZZID]
     */
    public void setWwzzid(String  wwzzid){
        this.wwzzid = wwzzid ;
        this.modify("wwzzid",wwzzid);
    }

    /**
     * 设置 [KSRQ]
     */
    public void setKsrq(Timestamp  ksrq){
        this.ksrq = ksrq ;
        this.modify("ksrq",ksrq);
    }

    /**
     * 设置 [PCMYDGZMXNAME]
     */
    public void setPcmydgzmxname(String  pcmydgzmxname){
        this.pcmydgzmxname = pcmydgzmxname ;
        this.modify("pcmydgzmxname",pcmydgzmxname);
    }

    /**
     * 设置 [CZ]
     */
    public void setCz(String  cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [PCMPROFILEID]
     */
    public void setPcmprofileid(String  pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }

    /**
     * 设置 [WBZZ]
     */
    public void setWbzz(String  wbzz){
        this.wbzz = wbzz ;
        this.modify("wbzz",wbzz);
    }

    /**
     * 设置 [WBZW]
     */
    public void setWbzw(String  wbzw){
        this.wbzw = wbzw ;
        this.modify("wbzw",wbzw);
    }

    /**
     * 设置 [WBBM]
     */
    public void setWbbm(String  wbbm){
        this.wbbm = wbbm ;
        this.modify("wbbm",wbbm);
    }


}

