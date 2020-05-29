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
 * 服务DTO对象[TrmDepartNeedsDTO]
 */
@Data
public class TrmDepartNeedsDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PXDFS]
     *
     */
    @JSONField(name = "pxdfs")
    @JsonProperty("pxdfs")
    private String pxdfs;

    /**
     * 属性 [PXNR]
     *
     */
    @JSONField(name = "pxnr")
    @JsonProperty("pxnr")
    private String pxnr;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [YJKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "yjkssj" , format="yyyy-MM-dd")
    @JsonProperty("yjkssj")
    private Timestamp yjkssj;

    /**
     * 属性 [TRMDEPARTNEEDSNAME]
     *
     */
    @JSONField(name = "trmdepartneedsname")
    @JsonProperty("trmdepartneedsname")
    private String trmdepartneedsname;

    /**
     * 属性 [TRMDEPARTNEEDSID]
     *
     */
    @JSONField(name = "trmdepartneedsid")
    @JsonProperty("trmdepartneedsid")
    private String trmdepartneedsid;

    /**
     * 属性 [PXSCDW]
     *
     */
    @JSONField(name = "pxscdw")
    @JsonProperty("pxscdw")
    private String pxscdw;

    /**
     * 属性 [YJJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "yjjssj" , format="yyyy-MM-dd")
    @JsonProperty("yjjssj")
    private Timestamp yjjssj;

    /**
     * 属性 [PXLB]
     *
     */
    @JSONField(name = "pxlb")
    @JsonProperty("pxlb")
    private String pxlb;

    /**
     * 属性 [PXMB]
     *
     */
    @JSONField(name = "pxmb")
    @JsonProperty("pxmb")
    private String pxmb;

    /**
     * 属性 [SPYJ]
     *
     */
    @JSONField(name = "spyj")
    @JsonProperty("spyj")
    private String spyj;

    /**
     * 属性 [XQYY]
     *
     */
    @JSONField(name = "xqyy")
    @JsonProperty("xqyy")
    private String xqyy;

    /**
     * 属性 [YJFYZE]
     *
     */
    @JSONField(name = "yjfyze")
    @JsonProperty("yjfyze")
    private Double yjfyze;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PXDD]
     *
     */
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;

    /**
     * 属性 [JPCD]
     *
     */
    @JSONField(name = "jpcd")
    @JsonProperty("jpcd")
    private String jpcd;

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
     * 属性 [PXSC]
     *
     */
    @JSONField(name = "pxsc")
    @JsonProperty("pxsc")
    private Double pxsc;

    /**
     * 属性 [TBSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tbsj" , format="yyyy-MM-dd")
    @JsonProperty("tbsj")
    private Timestamp tbsj;

    /**
     * 属性 [YJCXRS]
     *
     */
    @JSONField(name = "yjcxrs")
    @JsonProperty("yjcxrs")
    private Integer yjcxrs;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [TRMTRAINAGENCYNAME]
     *
     */
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;

    /**
     * 属性 [TRMTRAINCOURSENAME]
     *
     */
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;

    /**
     * 属性 [TRMTRAINCOURSEID]
     *
     */
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;

    /**
     * 属性 [TRMTRAINAGENCYID]
     *
     */
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;


    /**
     * 设置 [PXDFS]
     */
    public void setPxdfs(String  pxdfs){
        this.pxdfs = pxdfs ;
        this.modify("pxdfs",pxdfs);
    }

    /**
     * 设置 [PXNR]
     */
    public void setPxnr(String  pxnr){
        this.pxnr = pxnr ;
        this.modify("pxnr",pxnr);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [YJKSSJ]
     */
    public void setYjkssj(Timestamp  yjkssj){
        this.yjkssj = yjkssj ;
        this.modify("yjkssj",yjkssj);
    }

    /**
     * 设置 [TRMDEPARTNEEDSNAME]
     */
    public void setTrmdepartneedsname(String  trmdepartneedsname){
        this.trmdepartneedsname = trmdepartneedsname ;
        this.modify("trmdepartneedsname",trmdepartneedsname);
    }

    /**
     * 设置 [PXSCDW]
     */
    public void setPxscdw(String  pxscdw){
        this.pxscdw = pxscdw ;
        this.modify("pxscdw",pxscdw);
    }

    /**
     * 设置 [YJJSSJ]
     */
    public void setYjjssj(Timestamp  yjjssj){
        this.yjjssj = yjjssj ;
        this.modify("yjjssj",yjjssj);
    }

    /**
     * 设置 [PXLB]
     */
    public void setPxlb(String  pxlb){
        this.pxlb = pxlb ;
        this.modify("pxlb",pxlb);
    }

    /**
     * 设置 [PXMB]
     */
    public void setPxmb(String  pxmb){
        this.pxmb = pxmb ;
        this.modify("pxmb",pxmb);
    }

    /**
     * 设置 [SPYJ]
     */
    public void setSpyj(String  spyj){
        this.spyj = spyj ;
        this.modify("spyj",spyj);
    }

    /**
     * 设置 [XQYY]
     */
    public void setXqyy(String  xqyy){
        this.xqyy = xqyy ;
        this.modify("xqyy",xqyy);
    }

    /**
     * 设置 [YJFYZE]
     */
    public void setYjfyze(Double  yjfyze){
        this.yjfyze = yjfyze ;
        this.modify("yjfyze",yjfyze);
    }

    /**
     * 设置 [PXDD]
     */
    public void setPxdd(String  pxdd){
        this.pxdd = pxdd ;
        this.modify("pxdd",pxdd);
    }

    /**
     * 设置 [JPCD]
     */
    public void setJpcd(String  jpcd){
        this.jpcd = jpcd ;
        this.modify("jpcd",jpcd);
    }

    /**
     * 设置 [PXSC]
     */
    public void setPxsc(Double  pxsc){
        this.pxsc = pxsc ;
        this.modify("pxsc",pxsc);
    }

    /**
     * 设置 [TBSJ]
     */
    public void setTbsj(Timestamp  tbsj){
        this.tbsj = tbsj ;
        this.modify("tbsj",tbsj);
    }

    /**
     * 设置 [YJCXRS]
     */
    public void setYjcxrs(Integer  yjcxrs){
        this.yjcxrs = yjcxrs ;
        this.modify("yjcxrs",yjcxrs);
    }

    /**
     * 设置 [TRMTRAINCOURSEID]
     */
    public void setTrmtraincourseid(String  trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }

    /**
     * 设置 [TRMTRAINAGENCYID]
     */
    public void setTrmtrainagencyid(String  trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}

