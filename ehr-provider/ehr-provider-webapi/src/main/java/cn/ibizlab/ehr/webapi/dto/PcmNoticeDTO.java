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
 * 服务DTO对象[PcmNoticeDTO]
 */
@Data
public class PcmNoticeDTO extends DTOBase implements Serializable {

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
     * 属性 [SXRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [NOTICETYPE]
     *
     */
    @JSONField(name = "noticetype")
    @JsonProperty("noticetype")
    private String noticetype;

    /**
     * 属性 [ROLETYPE]
     *
     */
    @JSONField(name = "roletype")
    @JsonProperty("roletype")
    private Integer roletype;

    /**
     * 属性 [DONE]
     *
     */
    @JSONField(name = "done")
    @JsonProperty("done")
    private Integer done;

    /**
     * 属性 [PCMNOTICENAME]
     *
     */
    @JSONField(name = "pcmnoticename")
    @JsonProperty("pcmnoticename")
    private String pcmnoticename;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SSFW]
     *
     */
    @JSONField(name = "ssfw")
    @JsonProperty("ssfw")
    private String ssfw;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [PCMNOTICEID]
     *
     */
    @JSONField(name = "pcmnoticeid")
    @JsonProperty("pcmnoticeid")
    private String pcmnoticeid;

    /**
     * 属性 [NOTICE]
     *
     */
    @JSONField(name = "notice")
    @JsonProperty("notice")
    private String notice;

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
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PIMDISTIRBUTIONID]
     *
     */
    @JSONField(name = "pimdistirbutionid")
    @JsonProperty("pimdistirbutionid")
    private String pimdistirbutionid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [SXRQ]
     */
    public void setSxrq(Timestamp  sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 设置 [NOTICETYPE]
     */
    public void setNoticetype(String  noticetype){
        this.noticetype = noticetype ;
        this.modify("noticetype",noticetype);
    }

    /**
     * 设置 [ROLETYPE]
     */
    public void setRoletype(Integer  roletype){
        this.roletype = roletype ;
        this.modify("roletype",roletype);
    }

    /**
     * 设置 [DONE]
     */
    public void setDone(Integer  done){
        this.done = done ;
        this.modify("done",done);
    }

    /**
     * 设置 [PCMNOTICENAME]
     */
    public void setPcmnoticename(String  pcmnoticename){
        this.pcmnoticename = pcmnoticename ;
        this.modify("pcmnoticename",pcmnoticename);
    }

    /**
     * 设置 [SSFW]
     */
    public void setSsfw(String  ssfw){
        this.ssfw = ssfw ;
        this.modify("ssfw",ssfw);
    }

    /**
     * 设置 [NOTICE]
     */
    public void setNotice(String  notice){
        this.notice = notice ;
        this.modify("notice",notice);
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
     * 设置 [PIMDISTIRBUTIONID]
     */
    public void setPimdistirbutionid(String  pimdistirbutionid){
        this.pimdistirbutionid = pimdistirbutionid ;
        this.modify("pimdistirbutionid",pimdistirbutionid);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

