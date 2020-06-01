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
 * 服务DTO对象[TrmCouarrangeDTO]
 */
@Data
public class TrmCouarrangeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PJ]
     *
     */
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;

    /**
     * 属性 [TRMCOUARRANGEID]
     *
     */
    @JSONField(name = "trmcouarrangeid")
    @JsonProperty("trmcouarrangeid")
    private String trmcouarrangeid;

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
     * 属性 [CKZL]
     *
     */
    @JSONField(name = "ckzl")
    @JsonProperty("ckzl")
    private String ckzl;

    /**
     * 属性 [SKKSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "skksrq" , format="yyyy-MM-dd")
    @JsonProperty("skksrq")
    private Timestamp skksrq;

    /**
     * 属性 [KCXS]
     *
     */
    @JSONField(name = "kcxs")
    @JsonProperty("kcxs")
    private Double kcxs;

    /**
     * 属性 [SKJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "skjssj" , format="yyyy-MM-dd")
    @JsonProperty("skjssj")
    private Timestamp skjssj;

    /**
     * 属性 [TRMCOUARRANGENAME]
     *
     */
    @JSONField(name = "trmcouarrangename")
    @JsonProperty("trmcouarrangename")
    private String trmcouarrangename;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SKKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "skkssj" , format="yyyy-MM-dd")
    @JsonProperty("skkssj")
    private Timestamp skkssj;

    /**
     * 属性 [YBZS]
     *
     */
    @JSONField(name = "ybzs")
    @JsonProperty("ybzs")
    private String ybzs;

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
     * 属性 [KCNR]
     *
     */
    @JSONField(name = "kcnr")
    @JsonProperty("kcnr")
    private String kcnr;

    /**
     * 属性 [TRMTRAINAGENCYNAME]
     *
     */
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;

    /**
     * 属性 [TRMTRAINPLANTERMNAME]
     *
     */
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;

    /**
     * 属性 [TRMTRAINACTAPPLYNAME]
     *
     */
    @JSONField(name = "trmtrainactapplyname")
    @JsonProperty("trmtrainactapplyname")
    private String trmtrainactapplyname;

    /**
     * 属性 [TRMTRAINADDRESSNAME]
     *
     */
    @JSONField(name = "trmtrainaddressname")
    @JsonProperty("trmtrainaddressname")
    private String trmtrainaddressname;

    /**
     * 属性 [TRMTRIANPERSONNAME]
     *
     */
    @JSONField(name = "trmtrianpersonname")
    @JsonProperty("trmtrianpersonname")
    private String trmtrianpersonname;

    /**
     * 属性 [TRMTRAINCOURSENAME]
     *
     */
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;

    /**
     * 属性 [TRMCOURSESYSTEMNAME]
     *
     */
    @JSONField(name = "trmcoursesystemname")
    @JsonProperty("trmcoursesystemname")
    private String trmcoursesystemname;

    /**
     * 属性 [TRMTRAINFACIESNAME]
     *
     */
    @JSONField(name = "trmtrainfaciesname")
    @JsonProperty("trmtrainfaciesname")
    private String trmtrainfaciesname;

    /**
     * 属性 [TRMTRAINTEACHERNAME]
     *
     */
    @JSONField(name = "trmtrainteachername")
    @JsonProperty("trmtrainteachername")
    private String trmtrainteachername;

    /**
     * 属性 [TRMAGENCYRECORDNAME]
     *
     */
    @JSONField(name = "trmagencyrecordname")
    @JsonProperty("trmagencyrecordname")
    private String trmagencyrecordname;

    /**
     * 属性 [TRMTRIANPERSONID]
     *
     */
    @JSONField(name = "trmtrianpersonid")
    @JsonProperty("trmtrianpersonid")
    private String trmtrianpersonid;

    /**
     * 属性 [TRMTRAINTEACHERID]
     *
     */
    @JSONField(name = "trmtrainteacherid")
    @JsonProperty("trmtrainteacherid")
    private String trmtrainteacherid;

    /**
     * 属性 [TRMTRAINFACIESID]
     *
     */
    @JSONField(name = "trmtrainfaciesid")
    @JsonProperty("trmtrainfaciesid")
    private String trmtrainfaciesid;

    /**
     * 属性 [TRMTRAINAGENCYID]
     *
     */
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;

    /**
     * 属性 [TRMTRAINPLANTERMID]
     *
     */
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;

    /**
     * 属性 [TRMTRAINACTAPPLYID]
     *
     */
    @JSONField(name = "trmtrainactapplyid")
    @JsonProperty("trmtrainactapplyid")
    private String trmtrainactapplyid;

    /**
     * 属性 [TRMTRAINADDRESSID]
     *
     */
    @JSONField(name = "trmtrainaddressid")
    @JsonProperty("trmtrainaddressid")
    private String trmtrainaddressid;

    /**
     * 属性 [TRMAGENCYRECORDID]
     *
     */
    @JSONField(name = "trmagencyrecordid")
    @JsonProperty("trmagencyrecordid")
    private String trmagencyrecordid;

    /**
     * 属性 [TRMTRAINCOURSEID]
     *
     */
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;

    /**
     * 属性 [TRMCOURSESYSTEMID]
     *
     */
    @JSONField(name = "trmcoursesystemid")
    @JsonProperty("trmcoursesystemid")
    private String trmcoursesystemid;


    /**
     * 设置 [PJ]
     */
    public void setPj(String  pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [CKZL]
     */
    public void setCkzl(String  ckzl){
        this.ckzl = ckzl ;
        this.modify("ckzl",ckzl);
    }

    /**
     * 设置 [SKKSRQ]
     */
    public void setSkksrq(Timestamp  skksrq){
        this.skksrq = skksrq ;
        this.modify("skksrq",skksrq);
    }

    /**
     * 设置 [KCXS]
     */
    public void setKcxs(Double  kcxs){
        this.kcxs = kcxs ;
        this.modify("kcxs",kcxs);
    }

    /**
     * 设置 [SKJSSJ]
     */
    public void setSkjssj(Timestamp  skjssj){
        this.skjssj = skjssj ;
        this.modify("skjssj",skjssj);
    }

    /**
     * 设置 [TRMCOUARRANGENAME]
     */
    public void setTrmcouarrangename(String  trmcouarrangename){
        this.trmcouarrangename = trmcouarrangename ;
        this.modify("trmcouarrangename",trmcouarrangename);
    }

    /**
     * 设置 [SKKSSJ]
     */
    public void setSkkssj(Timestamp  skkssj){
        this.skkssj = skkssj ;
        this.modify("skkssj",skkssj);
    }

    /**
     * 设置 [YBZS]
     */
    public void setYbzs(String  ybzs){
        this.ybzs = ybzs ;
        this.modify("ybzs",ybzs);
    }

    /**
     * 设置 [KCNR]
     */
    public void setKcnr(String  kcnr){
        this.kcnr = kcnr ;
        this.modify("kcnr",kcnr);
    }

    /**
     * 设置 [TRMTRIANPERSONID]
     */
    public void setTrmtrianpersonid(String  trmtrianpersonid){
        this.trmtrianpersonid = trmtrianpersonid ;
        this.modify("trmtrianpersonid",trmtrianpersonid);
    }

    /**
     * 设置 [TRMTRAINTEACHERID]
     */
    public void setTrmtrainteacherid(String  trmtrainteacherid){
        this.trmtrainteacherid = trmtrainteacherid ;
        this.modify("trmtrainteacherid",trmtrainteacherid);
    }

    /**
     * 设置 [TRMTRAINFACIESID]
     */
    public void setTrmtrainfaciesid(String  trmtrainfaciesid){
        this.trmtrainfaciesid = trmtrainfaciesid ;
        this.modify("trmtrainfaciesid",trmtrainfaciesid);
    }

    /**
     * 设置 [TRMTRAINAGENCYID]
     */
    public void setTrmtrainagencyid(String  trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }

    /**
     * 设置 [TRMTRAINPLANTERMID]
     */
    public void setTrmtrainplantermid(String  trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }

    /**
     * 设置 [TRMTRAINACTAPPLYID]
     */
    public void setTrmtrainactapplyid(String  trmtrainactapplyid){
        this.trmtrainactapplyid = trmtrainactapplyid ;
        this.modify("trmtrainactapplyid",trmtrainactapplyid);
    }

    /**
     * 设置 [TRMTRAINADDRESSID]
     */
    public void setTrmtrainaddressid(String  trmtrainaddressid){
        this.trmtrainaddressid = trmtrainaddressid ;
        this.modify("trmtrainaddressid",trmtrainaddressid);
    }

    /**
     * 设置 [TRMAGENCYRECORDID]
     */
    public void setTrmagencyrecordid(String  trmagencyrecordid){
        this.trmagencyrecordid = trmagencyrecordid ;
        this.modify("trmagencyrecordid",trmagencyrecordid);
    }

    /**
     * 设置 [TRMTRAINCOURSEID]
     */
    public void setTrmtraincourseid(String  trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }

    /**
     * 设置 [TRMCOURSESYSTEMID]
     */
    public void setTrmcoursesystemid(String  trmcoursesystemid){
        this.trmcoursesystemid = trmcoursesystemid ;
        this.modify("trmcoursesystemid",trmcoursesystemid);
    }


}

