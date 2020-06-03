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
 * 服务DTO对象[TrmTrainPlantermDTO]
 */
@Data
public class TrmTrainPlantermDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PXRS]
     *
     */
    @JSONField(name = "pxrs")
    @JsonProperty("pxrs")
    private Integer pxrs;

    /**
     * 属性 [PXMB]
     *
     */
    @JSONField(name = "pxmb")
    @JsonProperty("pxmb")
    private String pxmb;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [JHJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhjssj" , format="yyyy-MM-dd")
    @JsonProperty("jhjssj")
    private Timestamp jhjssj;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PXFS]
     *
     */
    @JSONField(name = "pxfs")
    @JsonProperty("pxfs")
    private String pxfs;

    /**
     * 属性 [PXDXLB]
     *
     */
    @JSONField(name = "pxdxlb")
    @JsonProperty("pxdxlb")
    private String pxdxlb;

    /**
     * 属性 [PXCS]
     *
     */
    @JSONField(name = "pxcs")
    @JsonProperty("pxcs")
    private Integer pxcs;

    /**
     * 属性 [BJZT]
     *
     */
    @JSONField(name = "bjzt")
    @JsonProperty("bjzt")
    private String bjzt;

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
     * 属性 [PXLB]
     *
     */
    @JSONField(name = "pxlb")
    @JsonProperty("pxlb")
    private String pxlb;

    /**
     * 属性 [JHXBM]
     *
     */
    @JSONField(name = "jhxbm")
    @JsonProperty("jhxbm")
    private String jhxbm;

    /**
     * 属性 [JSCC]
     *
     */
    @JSONField(name = "jscc")
    @JsonProperty("jscc")
    private String jscc;

    /**
     * 属性 [FYYS]
     *
     */
    @JSONField(name = "fyys")
    @JsonProperty("fyys")
    private Double fyys;

    /**
     * 属性 [PXSC]
     *
     */
    @JSONField(name = "pxsc")
    @JsonProperty("pxsc")
    private Double pxsc;

    /**
     * 属性 [BZR]
     *
     */
    @JSONField(name = "bzr")
    @JsonProperty("bzr")
    private String bzr;

    /**
     * 属性 [SPYJ]
     *
     */
    @JSONField(name = "spyj")
    @JsonProperty("spyj")
    private String spyj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ZT]
     *
     */
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;

    /**
     * 属性 [PXFZ]
     *
     */
    @JSONField(name = "pxfz")
    @JsonProperty("pxfz")
    private String pxfz;

    /**
     * 属性 [SFQDPXXY]
     *
     */
    @JSONField(name = "sfqdpxxy")
    @JsonProperty("sfqdpxxy")
    private String sfqdpxxy;

    /**
     * 属性 [JHKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhkssj" , format="yyyy-MM-dd")
    @JsonProperty("jhkssj")
    private Timestamp jhkssj;

    /**
     * 属性 [TRMTRAINPLANTERMID]
     *
     */
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;

    /**
     * 属性 [PXNR]
     *
     */
    @JSONField(name = "pxnr")
    @JsonProperty("pxnr")
    private String pxnr;

    /**
     * 属性 [TRMTRAINPLANTERMNAME]
     *
     */
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;

    /**
     * 属性 [TRMDEMDEFTIONNAME]
     *
     */
    @JSONField(name = "trmdemdeftionname")
    @JsonProperty("trmdemdeftionname")
    private String trmdemdeftionname;

    /**
     * 属性 [TRMTRAINAGENCYNAME]
     *
     */
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [TRMTRAINCOURSENAME]
     *
     */
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;

    /**
     * 属性 [PXDD]
     *
     */
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;

    /**
     * 属性 [PXKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxkssj" , format="yyyy-MM-dd")
    @JsonProperty("pxkssj")
    private Timestamp pxkssj;

    /**
     * 属性 [PXJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjssj" , format="yyyy-MM-dd")
    @JsonProperty("pxjssj")
    private Timestamp pxjssj;

    /**
     * 属性 [TRMTRAINTEACHERNAME]
     *
     */
    @JSONField(name = "trmtrainteachername")
    @JsonProperty("trmtrainteachername")
    private String trmtrainteachername;

    /**
     * 属性 [TRMTRAINPLANNAME]
     *
     */
    @JSONField(name = "trmtrainplanname")
    @JsonProperty("trmtrainplanname")
    private String trmtrainplanname;

    /**
     * 属性 [TRMTRAINPLANID]
     *
     */
    @JSONField(name = "trmtrainplanid")
    @JsonProperty("trmtrainplanid")
    private String trmtrainplanid;

    /**
     * 属性 [TRMTRAINTEACHERID]
     *
     */
    @JSONField(name = "trmtrainteacherid")
    @JsonProperty("trmtrainteacherid")
    private String trmtrainteacherid;

    /**
     * 属性 [TRMTRAINAGENCYID]
     *
     */
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;

    /**
     * 属性 [TRMTRAINCOURSEID]
     *
     */
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;


    /**
     * 设置 [PXRS]
     */
    public void setPxrs(Integer  pxrs){
        this.pxrs = pxrs ;
        this.modify("pxrs",pxrs);
    }

    /**
     * 设置 [PXMB]
     */
    public void setPxmb(String  pxmb){
        this.pxmb = pxmb ;
        this.modify("pxmb",pxmb);
    }

    /**
     * 设置 [JHJSSJ]
     */
    public void setJhjssj(Timestamp  jhjssj){
        this.jhjssj = jhjssj ;
        this.modify("jhjssj",jhjssj);
    }

    /**
     * 设置 [PXFS]
     */
    public void setPxfs(String  pxfs){
        this.pxfs = pxfs ;
        this.modify("pxfs",pxfs);
    }

    /**
     * 设置 [PXDXLB]
     */
    public void setPxdxlb(String  pxdxlb){
        this.pxdxlb = pxdxlb ;
        this.modify("pxdxlb",pxdxlb);
    }

    /**
     * 设置 [PXCS]
     */
    public void setPxcs(Integer  pxcs){
        this.pxcs = pxcs ;
        this.modify("pxcs",pxcs);
    }

    /**
     * 设置 [BJZT]
     */
    public void setBjzt(String  bjzt){
        this.bjzt = bjzt ;
        this.modify("bjzt",bjzt);
    }

    /**
     * 设置 [PXLB]
     */
    public void setPxlb(String  pxlb){
        this.pxlb = pxlb ;
        this.modify("pxlb",pxlb);
    }

    /**
     * 设置 [JHXBM]
     */
    public void setJhxbm(String  jhxbm){
        this.jhxbm = jhxbm ;
        this.modify("jhxbm",jhxbm);
    }

    /**
     * 设置 [JSCC]
     */
    public void setJscc(String  jscc){
        this.jscc = jscc ;
        this.modify("jscc",jscc);
    }

    /**
     * 设置 [FYYS]
     */
    public void setFyys(Double  fyys){
        this.fyys = fyys ;
        this.modify("fyys",fyys);
    }

    /**
     * 设置 [PXSC]
     */
    public void setPxsc(Double  pxsc){
        this.pxsc = pxsc ;
        this.modify("pxsc",pxsc);
    }

    /**
     * 设置 [BZR]
     */
    public void setBzr(String  bzr){
        this.bzr = bzr ;
        this.modify("bzr",bzr);
    }

    /**
     * 设置 [SPYJ]
     */
    public void setSpyj(String  spyj){
        this.spyj = spyj ;
        this.modify("spyj",spyj);
    }

    /**
     * 设置 [ZT]
     */
    public void setZt(String  zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [PXFZ]
     */
    public void setPxfz(String  pxfz){
        this.pxfz = pxfz ;
        this.modify("pxfz",pxfz);
    }

    /**
     * 设置 [SFQDPXXY]
     */
    public void setSfqdpxxy(String  sfqdpxxy){
        this.sfqdpxxy = sfqdpxxy ;
        this.modify("sfqdpxxy",sfqdpxxy);
    }

    /**
     * 设置 [JHKSSJ]
     */
    public void setJhkssj(Timestamp  jhkssj){
        this.jhkssj = jhkssj ;
        this.modify("jhkssj",jhkssj);
    }

    /**
     * 设置 [PXNR]
     */
    public void setPxnr(String  pxnr){
        this.pxnr = pxnr ;
        this.modify("pxnr",pxnr);
    }

    /**
     * 设置 [TRMTRAINPLANTERMNAME]
     */
    public void setTrmtrainplantermname(String  trmtrainplantermname){
        this.trmtrainplantermname = trmtrainplantermname ;
        this.modify("trmtrainplantermname",trmtrainplantermname);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [TRMTRAINPLANID]
     */
    public void setTrmtrainplanid(String  trmtrainplanid){
        this.trmtrainplanid = trmtrainplanid ;
        this.modify("trmtrainplanid",trmtrainplanid);
    }

    /**
     * 设置 [TRMTRAINTEACHERID]
     */
    public void setTrmtrainteacherid(String  trmtrainteacherid){
        this.trmtrainteacherid = trmtrainteacherid ;
        this.modify("trmtrainteacherid",trmtrainteacherid);
    }

    /**
     * 设置 [TRMTRAINAGENCYID]
     */
    public void setTrmtrainagencyid(String  trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }

    /**
     * 设置 [TRMTRAINCOURSEID]
     */
    public void setTrmtraincourseid(String  trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }


}

