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
 * 服务DTO对象[TrmEmployeeRetionDTO]
 */
@Data
public class TrmEmployeeRetionDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PXNR]
     *
     */
    @JSONField(name = "pxnr")
    @JsonProperty("pxnr")
    private String pxnr;

    /**
     * 属性 [TRMEMPLOYEERETIONNAME]
     *
     */
    @JSONField(name = "trmemployretionname")
    @JsonProperty("trmemployretionname")
    private String trmemployretionname;

    /**
     * 属性 [BMTJ]
     *
     */
    @JSONField(name = "bmtj")
    @JsonProperty("bmtj")
    private String bmtj;

    /**
     * 属性 [BMJZRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bmjzrq" , format="yyyy-MM-dd")
    @JsonProperty("bmjzrq")
    private Timestamp bmjzrq;

    /**
     * 属性 [BMKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bmkssj" , format="yyyy-MM-dd")
    @JsonProperty("bmkssj")
    private Timestamp bmkssj;

    /**
     * 属性 [PXDD]
     *
     */
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [TRMEMPLOYEERETIONID]
     *
     */
    @JSONField(name = "trmemployretionid")
    @JsonProperty("trmemployretionid")
    private String trmemployretionid;

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
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [SKKSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "skksrq" , format="yyyy-MM-dd")
    @JsonProperty("skksrq")
    private Timestamp skksrq;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [PXHDBM]
     *
     */
    @JSONField(name = "pxhdbm")
    @JsonProperty("pxhdbm")
    private String pxhdbm;

    /**
     * 属性 [TRMCOUARRANGENAME]
     *
     */
    @JSONField(name = "trmcouarrangename")
    @JsonProperty("trmcouarrangename")
    private String trmcouarrangename;

    /**
     * 属性 [SKJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "skjssj" , format="yyyy-MM-dd")
    @JsonProperty("skjssj")
    private Timestamp skjssj;

    /**
     * 属性 [TRMTRAINAGENCYNAME]
     *
     */
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;

    /**
     * 属性 [TRMTRAINACTAPPLYNAME]
     *
     */
    @JSONField(name = "trmtrainactapplyname")
    @JsonProperty("trmtrainactapplyname")
    private String trmtrainactapplyname;

    /**
     * 属性 [KCXS]
     *
     */
    @JSONField(name = "kcxs")
    @JsonProperty("kcxs")
    private Double kcxs;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [TRMCOUARRANGEID]
     *
     */
    @JSONField(name = "trmcouarrangeid")
    @JsonProperty("trmcouarrangeid")
    private String trmcouarrangeid;

    /**
     * 属性 [TRMTRAINACTAPPLYID]
     *
     */
    @JSONField(name = "trmtrainactapplyid")
    @JsonProperty("trmtrainactapplyid")
    private String trmtrainactapplyid;

    /**
     * 属性 [TRMTRAINAGENCYID]
     *
     */
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;


    /**
     * 设置 [PXNR]
     */
    public void setPxnr(String  pxnr){
        this.pxnr = pxnr ;
        this.modify("pxnr",pxnr);
    }

    /**
     * 设置 [TRMEMPLOYEERETIONNAME]
     */
    public void setTrmemployretionname(String  trmemployretionname){
        this.trmemployretionname = trmemployretionname ;
        this.modify("trmemployeeretionname",trmemployretionname);
    }

    /**
     * 设置 [BMTJ]
     */
    public void setBmtj(String  bmtj){
        this.bmtj = bmtj ;
        this.modify("bmtj",bmtj);
    }

    /**
     * 设置 [BMJZRQ]
     */
    public void setBmjzrq(Timestamp  bmjzrq){
        this.bmjzrq = bmjzrq ;
        this.modify("bmjzrq",bmjzrq);
    }

    /**
     * 设置 [BMKSSJ]
     */
    public void setBmkssj(Timestamp  bmkssj){
        this.bmkssj = bmkssj ;
        this.modify("bmkssj",bmkssj);
    }

    /**
     * 设置 [PXDD]
     */
    public void setPxdd(String  pxdd){
        this.pxdd = pxdd ;
        this.modify("pxdd",pxdd);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [TRMCOUARRANGEID]
     */
    public void setTrmcouarrangeid(String  trmcouarrangeid){
        this.trmcouarrangeid = trmcouarrangeid ;
        this.modify("trmcouarrangeid",trmcouarrangeid);
    }

    /**
     * 设置 [TRMTRAINACTAPPLYID]
     */
    public void setTrmtrainactapplyid(String  trmtrainactapplyid){
        this.trmtrainactapplyid = trmtrainactapplyid ;
        this.modify("trmtrainactapplyid",trmtrainactapplyid);
    }

    /**
     * 设置 [TRMTRAINAGENCYID]
     */
    public void setTrmtrainagencyid(String  trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}

