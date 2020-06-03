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
 * 服务DTO对象[TrmDemdeftionDTO]
 */
@Data
public class TrmDemdeftionDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DCBJB]
     *
     */
    @JSONField(name = "dcbjb")
    @JsonProperty("dcbjb")
    private String dcbjb;

    /**
     * 属性 [PXBMC]
     *
     */
    @JSONField(name = "pxbmc")
    @JsonProperty("pxbmc")
    private String pxbmc;

    /**
     * 属性 [SFFB]
     *
     */
    @JSONField(name = "sffb")
    @JsonProperty("sffb")
    private Integer sffb;

    /**
     * 属性 [BMJZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bmjzsj" , format="yyyy-MM-dd")
    @JsonProperty("bmjzsj")
    private Timestamp bmjzsj;

    /**
     * 属性 [DCSCJD]
     *
     */
    @JSONField(name = "dcscjd")
    @JsonProperty("dcscjd")
    private String dcscjd;

    /**
     * 属性 [PXJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjssj" , format="yyyy-MM-dd")
    @JsonProperty("pxjssj")
    private Timestamp pxjssj;

    /**
     * 属性 [PXDD]
     *
     */
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DCDXLX]
     *
     */
    @JSONField(name = "dcdxlx")
    @JsonProperty("dcdxlx")
    private String dcdxlx;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private String xh;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PXRS]
     *
     */
    @JSONField(name = "pxrs")
    @JsonProperty("pxrs")
    private Integer pxrs;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PXZYNR]
     *
     */
    @JSONField(name = "pxzynr")
    @JsonProperty("pxzynr")
    private String pxzynr;

    /**
     * 属性 [DCYGLB]
     *
     */
    @JSONField(name = "dcyglb")
    @JsonProperty("dcyglb")
    private String dcyglb;

    /**
     * 属性 [DCBLX]
     *
     */
    @JSONField(name = "dcblx")
    @JsonProperty("dcblx")
    private String dcblx;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [PXKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxkssj" , format="yyyy-MM-dd")
    @JsonProperty("pxkssj")
    private Timestamp pxkssj;

    /**
     * 属性 [XQFL]
     *
     */
    @JSONField(name = "xqfl")
    @JsonProperty("xqfl")
    private String xqfl;

    /**
     * 属性 [ZDSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zdsj" , format="yyyy-MM-dd")
    @JsonProperty("zdsj")
    private Timestamp zdsj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [TRMDEMDEFTIONNAME]
     *
     */
    @JSONField(name = "trmdemdeftionname")
    @JsonProperty("trmdemdeftionname")
    private String trmdemdeftionname;

    /**
     * 属性 [PXDX]
     *
     */
    @JSONField(name = "pxdx")
    @JsonProperty("pxdx")
    private String pxdx;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [DCJZRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dcjzrq" , format="yyyy-MM-dd")
    @JsonProperty("dcjzrq")
    private Timestamp dcjzrq;

    /**
     * 属性 [TRMDEMDEFTIONID]
     *
     */
    @JSONField(name = "trmdemdeftionid")
    @JsonProperty("trmdemdeftionid")
    private String trmdemdeftionid;

    /**
     * 属性 [DCSCND]
     *
     */
    @JSONField(name = "dcscnd")
    @JsonProperty("dcscnd")
    private String dcscnd;

    /**
     * 属性 [PXMK]
     *
     */
    @JSONField(name = "pxmk")
    @JsonProperty("pxmk")
    private String pxmk;

    /**
     * 属性 [TRMTRAINCOURSENAME]
     *
     */
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;

    /**
     * 属性 [TRMTRAINFILLINNAME]
     *
     */
    @JSONField(name = "trmtrainfillinname")
    @JsonProperty("trmtrainfillinname")
    private String trmtrainfillinname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [TRMDEPARTNAME]
     *
     */
    @JSONField(name = "trmdepartname")
    @JsonProperty("trmdepartname")
    private String trmdepartname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [TRMTRAINFILLINID]
     *
     */
    @JSONField(name = "trmtrainfillinid")
    @JsonProperty("trmtrainfillinid")
    private String trmtrainfillinid;

    /**
     * 属性 [TRMTRAINCOURSEID]
     *
     */
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;

    /**
     * 属性 [TRMDEPARTID]
     *
     */
    @JSONField(name = "trmdepartid")
    @JsonProperty("trmdepartid")
    private String trmdepartid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [DCBJB]
     */
    public void setDcbjb(String  dcbjb){
        this.dcbjb = dcbjb ;
        this.modify("dcbjb",dcbjb);
    }

    /**
     * 设置 [PXBMC]
     */
    public void setPxbmc(String  pxbmc){
        this.pxbmc = pxbmc ;
        this.modify("pxbmc",pxbmc);
    }

    /**
     * 设置 [SFFB]
     */
    public void setSffb(Integer  sffb){
        this.sffb = sffb ;
        this.modify("sffb",sffb);
    }

    /**
     * 设置 [BMJZSJ]
     */
    public void setBmjzsj(Timestamp  bmjzsj){
        this.bmjzsj = bmjzsj ;
        this.modify("bmjzsj",bmjzsj);
    }

    /**
     * 设置 [DCSCJD]
     */
    public void setDcscjd(String  dcscjd){
        this.dcscjd = dcscjd ;
        this.modify("dcscjd",dcscjd);
    }

    /**
     * 设置 [PXJSSJ]
     */
    public void setPxjssj(Timestamp  pxjssj){
        this.pxjssj = pxjssj ;
        this.modify("pxjssj",pxjssj);
    }

    /**
     * 设置 [PXDD]
     */
    public void setPxdd(String  pxdd){
        this.pxdd = pxdd ;
        this.modify("pxdd",pxdd);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [DCDXLX]
     */
    public void setDcdxlx(String  dcdxlx){
        this.dcdxlx = dcdxlx ;
        this.modify("dcdxlx",dcdxlx);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(String  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [PXRS]
     */
    public void setPxrs(Integer  pxrs){
        this.pxrs = pxrs ;
        this.modify("pxrs",pxrs);
    }

    /**
     * 设置 [PXZYNR]
     */
    public void setPxzynr(String  pxzynr){
        this.pxzynr = pxzynr ;
        this.modify("pxzynr",pxzynr);
    }

    /**
     * 设置 [DCYGLB]
     */
    public void setDcyglb(String  dcyglb){
        this.dcyglb = dcyglb ;
        this.modify("dcyglb",dcyglb);
    }

    /**
     * 设置 [DCBLX]
     */
    public void setDcblx(String  dcblx){
        this.dcblx = dcblx ;
        this.modify("dcblx",dcblx);
    }

    /**
     * 设置 [PXKSSJ]
     */
    public void setPxkssj(Timestamp  pxkssj){
        this.pxkssj = pxkssj ;
        this.modify("pxkssj",pxkssj);
    }

    /**
     * 设置 [XQFL]
     */
    public void setXqfl(String  xqfl){
        this.xqfl = xqfl ;
        this.modify("xqfl",xqfl);
    }

    /**
     * 设置 [ZDSJ]
     */
    public void setZdsj(Timestamp  zdsj){
        this.zdsj = zdsj ;
        this.modify("zdsj",zdsj);
    }

    /**
     * 设置 [TRMDEMDEFTIONNAME]
     */
    public void setTrmdemdeftionname(String  trmdemdeftionname){
        this.trmdemdeftionname = trmdemdeftionname ;
        this.modify("trmdemdeftionname",trmdemdeftionname);
    }

    /**
     * 设置 [PXDX]
     */
    public void setPxdx(String  pxdx){
        this.pxdx = pxdx ;
        this.modify("pxdx",pxdx);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [DCJZRQ]
     */
    public void setDcjzrq(Timestamp  dcjzrq){
        this.dcjzrq = dcjzrq ;
        this.modify("dcjzrq",dcjzrq);
    }

    /**
     * 设置 [DCSCND]
     */
    public void setDcscnd(String  dcscnd){
        this.dcscnd = dcscnd ;
        this.modify("dcscnd",dcscnd);
    }

    /**
     * 设置 [PXMK]
     */
    public void setPxmk(String  pxmk){
        this.pxmk = pxmk ;
        this.modify("pxmk",pxmk);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [TRMTRAINFILLINID]
     */
    public void setTrmtrainfillinid(String  trmtrainfillinid){
        this.trmtrainfillinid = trmtrainfillinid ;
        this.modify("trmtrainfillinid",trmtrainfillinid);
    }

    /**
     * 设置 [TRMTRAINCOURSEID]
     */
    public void setTrmtraincourseid(String  trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }

    /**
     * 设置 [TRMDEPARTID]
     */
    public void setTrmdepartid(String  trmdepartid){
        this.trmdepartid = trmdepartid ;
        this.modify("trmdepartid",trmdepartid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

