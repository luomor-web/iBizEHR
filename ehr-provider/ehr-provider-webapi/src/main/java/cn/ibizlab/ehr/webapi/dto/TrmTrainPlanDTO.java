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
 * 服务DTO对象[TrmTrainPlanDTO]
 */
@Data
public class TrmTrainPlanDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [LCLX]
     *
     */
    @JSONField(name = "lclx")
    @JsonProperty("lclx")
    private String lclx;

    /**
     * 属性 [SDFY]
     *
     */
    @JSONField(name = "sdfy")
    @JsonProperty("sdfy")
    private Double sdfy;

    /**
     * 属性 [YSZE]
     *
     */
    @JSONField(name = "ysze")
    @JsonProperty("ysze")
    private Double ysze;

    /**
     * 属性 [SHFS]
     *
     */
    @JSONField(name = "shfs")
    @JsonProperty("shfs")
    private String shfs;

    /**
     * 属性 [JHKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhkssj" , format="yyyy-MM-dd")
    @JsonProperty("jhkssj")
    private Timestamp jhkssj;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private String xh;

    /**
     * 属性 [JHYD]
     *
     */
    @JSONField(name = "jhyd")
    @JsonProperty("jhyd")
    private String jhyd;

    /**
     * 属性 [BZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bzsj" , format="yyyy-MM-dd")
    @JsonProperty("bzsj")
    private Timestamp bzsj;

    /**
     * 属性 [NPXQS]
     *
     */
    @JSONField(name = "npxqs")
    @JsonProperty("npxqs")
    private String npxqs;

    /**
     * 属性 [JHND]
     *
     */
    @JSONField(name = "jhnd")
    @JsonProperty("jhnd")
    private String jhnd;

    /**
     * 属性 [JHJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhjssj" , format="yyyy-MM-dd")
    @JsonProperty("jhjssj")
    private Timestamp jhjssj;

    /**
     * 属性 [JHJB]
     *
     */
    @JSONField(name = "jhjb")
    @JsonProperty("jhjb")
    private String jhjb;

    /**
     * 属性 [BMJZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bmjzsj" , format="yyyy-MM-dd")
    @JsonProperty("bmjzsj")
    private Timestamp bmjzsj;

    /**
     * 属性 [JHBM]
     *
     */
    @JSONField(name = "jhbm")
    @JsonProperty("jhbm")
    private String jhbm;

    /**
     * 属性 [TRMTRAINPLANID]
     *
     */
    @JSONField(name = "trmtrainplanid")
    @JsonProperty("trmtrainplanid")
    private String trmtrainplanid;

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
     * 属性 [JHLX]
     *
     */
    @JSONField(name = "jhlx")
    @JsonProperty("jhlx")
    private String jhlx;

    /**
     * 属性 [TRMTRAINPLANNAME]
     *
     */
    @JSONField(name = "trmtrainplanname")
    @JsonProperty("trmtrainplanname")
    private String trmtrainplanname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [NPXKS]
     *
     */
    @JSONField(name = "npxks")
    @JsonProperty("npxks")
    private Double npxks;

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
     * 属性 [JHJD]
     *
     */
    @JSONField(name = "jhjd")
    @JsonProperty("jhjd")
    private String jhjd;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [PXDX]
     *
     */
    @JSONField(name = "pxdx")
    @JsonProperty("pxdx")
    private String pxdx;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [TRMPLANFORMUNAME]
     *
     */
    @JSONField(name = "trmplanformuname")
    @JsonProperty("trmplanformuname")
    private String trmplanformuname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [TRMDEMDEFTIONNAME]
     *
     */
    @JSONField(name = "trmdemdeftionname")
    @JsonProperty("trmdemdeftionname")
    private String trmdemdeftionname;

    /**
     * 属性 [PXRS]
     *
     */
    @JSONField(name = "pxrs")
    @JsonProperty("pxrs")
    private Integer pxrs;

    /**
     * 属性 [PXZYNR]
     *
     */
    @JSONField(name = "pxzynr")
    @JsonProperty("pxzynr")
    private String pxzynr;

    /**
     * 属性 [PXKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxkssj" , format="yyyy-MM-dd")
    @JsonProperty("pxkssj")
    private Timestamp pxkssj;

    /**
     * 属性 [PXDD]
     *
     */
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;

    /**
     * 属性 [PXJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjssj" , format="yyyy-MM-dd")
    @JsonProperty("pxjssj")
    private Timestamp pxjssj;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [TRMDEMDEFTIONID]
     *
     */
    @JSONField(name = "trmdemdeftionid")
    @JsonProperty("trmdemdeftionid")
    private String trmdemdeftionid;

    /**
     * 属性 [TRMPLANFORMUID]
     *
     */
    @JSONField(name = "trmplanformuid")
    @JsonProperty("trmplanformuid")
    private String trmplanformuid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PXADRESS]
     *
     */
    @JSONField(name = "pxadress")
    @JsonProperty("pxadress")
    private String pxadress;

    /**
     * 属性 [PXCONTENT]
     *
     */
    @JSONField(name = "pxcontent")
    @JsonProperty("pxcontent")
    private String pxcontent;

    /**
     * 属性 [PXNUM]
     *
     */
    @JSONField(name = "pxnum")
    @JsonProperty("pxnum")
    private Integer pxnum;

    /**
     * 属性 [APPROVALSTATUS]
     *
     */
    @JSONField(name = "approvalstatus")
    @JsonProperty("approvalstatus")
    private String approvalstatus;


    /**
     * 设置 [LCLX]
     */
    public void setLclx(String  lclx){
        this.lclx = lclx ;
        this.modify("lclx",lclx);
    }

    /**
     * 设置 [SDFY]
     */
    public void setSdfy(Double  sdfy){
        this.sdfy = sdfy ;
        this.modify("sdfy",sdfy);
    }

    /**
     * 设置 [YSZE]
     */
    public void setYsze(Double  ysze){
        this.ysze = ysze ;
        this.modify("ysze",ysze);
    }

    /**
     * 设置 [SHFS]
     */
    public void setShfs(String  shfs){
        this.shfs = shfs ;
        this.modify("shfs",shfs);
    }

    /**
     * 设置 [JHKSSJ]
     */
    public void setJhkssj(Timestamp  jhkssj){
        this.jhkssj = jhkssj ;
        this.modify("jhkssj",jhkssj);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(String  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [JHYD]
     */
    public void setJhyd(String  jhyd){
        this.jhyd = jhyd ;
        this.modify("jhyd",jhyd);
    }

    /**
     * 设置 [BZSJ]
     */
    public void setBzsj(Timestamp  bzsj){
        this.bzsj = bzsj ;
        this.modify("bzsj",bzsj);
    }

    /**
     * 设置 [NPXQS]
     */
    public void setNpxqs(String  npxqs){
        this.npxqs = npxqs ;
        this.modify("npxqs",npxqs);
    }

    /**
     * 设置 [JHND]
     */
    public void setJhnd(String  jhnd){
        this.jhnd = jhnd ;
        this.modify("jhnd",jhnd);
    }

    /**
     * 设置 [JHJSSJ]
     */
    public void setJhjssj(Timestamp  jhjssj){
        this.jhjssj = jhjssj ;
        this.modify("jhjssj",jhjssj);
    }

    /**
     * 设置 [JHJB]
     */
    public void setJhjb(String  jhjb){
        this.jhjb = jhjb ;
        this.modify("jhjb",jhjb);
    }

    /**
     * 设置 [BMJZSJ]
     */
    public void setBmjzsj(Timestamp  bmjzsj){
        this.bmjzsj = bmjzsj ;
        this.modify("bmjzsj",bmjzsj);
    }

    /**
     * 设置 [JHBM]
     */
    public void setJhbm(String  jhbm){
        this.jhbm = jhbm ;
        this.modify("jhbm",jhbm);
    }

    /**
     * 设置 [JHLX]
     */
    public void setJhlx(String  jhlx){
        this.jhlx = jhlx ;
        this.modify("jhlx",jhlx);
    }

    /**
     * 设置 [TRMTRAINPLANNAME]
     */
    public void setTrmtrainplanname(String  trmtrainplanname){
        this.trmtrainplanname = trmtrainplanname ;
        this.modify("trmtrainplanname",trmtrainplanname);
    }

    /**
     * 设置 [NPXKS]
     */
    public void setNpxks(Double  npxks){
        this.npxks = npxks ;
        this.modify("npxks",npxks);
    }

    /**
     * 设置 [JHJD]
     */
    public void setJhjd(String  jhjd){
        this.jhjd = jhjd ;
        this.modify("jhjd",jhjd);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [TRMDEMDEFTIONID]
     */
    public void setTrmdemdeftionid(String  trmdemdeftionid){
        this.trmdemdeftionid = trmdemdeftionid ;
        this.modify("trmdemdeftionid",trmdemdeftionid);
    }

    /**
     * 设置 [TRMPLANFORMUID]
     */
    public void setTrmplanformuid(String  trmplanformuid){
        this.trmplanformuid = trmplanformuid ;
        this.modify("trmplanformuid",trmplanformuid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [PXADRESS]
     */
    public void setPxadress(String  pxadress){
        this.pxadress = pxadress ;
        this.modify("pxadress",pxadress);
    }

    /**
     * 设置 [PXCONTENT]
     */
    public void setPxcontent(String  pxcontent){
        this.pxcontent = pxcontent ;
        this.modify("pxcontent",pxcontent);
    }

    /**
     * 设置 [PXNUM]
     */
    public void setPxnum(Integer  pxnum){
        this.pxnum = pxnum ;
        this.modify("pxnum",pxnum);
    }

    /**
     * 设置 [APPROVALSTATUS]
     */
    public void setApprovalstatus(String  approvalstatus){
        this.approvalstatus = approvalstatus ;
        this.modify("approvalstatus",approvalstatus);
    }


}

