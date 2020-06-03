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
 * 服务DTO对象[TrmTrainPersonDTO]
 */
@Data
public class TrmTrainPersonDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [TRMTRIANPERSONNAME]
     *
     */
    @JSONField(name = "trmtrianpersonname")
    @JsonProperty("trmtrianpersonname")
    private String trmtrianpersonname;

    /**
     * 属性 [SFZS]
     *
     */
    @JSONField(name = "sfzs")
    @JsonProperty("sfzs")
    private Integer sfzs;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PXBJ]
     *
     */
    @JSONField(name = "pxbj")
    @JsonProperty("pxbj")
    private String pxbj;

    /**
     * 属性 [PXJG]
     *
     */
    @JSONField(name = "pxjg")
    @JsonProperty("pxjg")
    private String pxjg;

    /**
     * 属性 [PXKC]
     *
     */
    @JSONField(name = "pxkc")
    @JsonProperty("pxkc")
    private String pxkc;

    /**
     * 属性 [TRMTRIANPERSONID]
     *
     */
    @JSONField(name = "trmtrianpersonid")
    @JsonProperty("trmtrianpersonid")
    private String trmtrianpersonid;

    /**
     * 属性 [JSFS]
     *
     */
    @JSONField(name = "jsfs")
    @JsonProperty("jsfs")
    private String jsfs;

    /**
     * 属性 [FS]
     *
     */
    @JSONField(name = "fs")
    @JsonProperty("fs")
    private Double fs;

    /**
     * 属性 [TRAINBEGIN]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "trainbegin" , format="yyyy-MM-dd")
    @JsonProperty("trainbegin")
    private Timestamp trainbegin;

    /**
     * 属性 [TRAINEND]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "trainend" , format="yyyy-MM-dd")
    @JsonProperty("trainend")
    private Timestamp trainend;

    /**
     * 属性 [FJH]
     *
     */
    @JSONField(name = "fjh")
    @JsonProperty("fjh")
    private String fjh;

    /**
     * 属性 [TRAINRES]
     *
     */
    @JSONField(name = "trainres")
    @JsonProperty("trainres")
    private String trainres;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [JHXBM]
     *
     */
    @JSONField(name = "jhxbm")
    @JsonProperty("jhxbm")
    private String jhxbm;

    /**
     * 属性 [PXJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjssj" , format="yyyy-MM-dd")
    @JsonProperty("pxjssj")
    private Timestamp pxjssj;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [TRMTRAINTEACHERNAME]
     *
     */
    @JSONField(name = "trmtrainteachername")
    @JsonProperty("trmtrainteachername")
    private String trmtrainteachername;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [XB]
     *
     */
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;

    /**
     * 属性 [TRMTRAINAGENCYNAME]
     *
     */
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [TRMTRAINCOURSENAME]
     *
     */
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;

    /**
     * 属性 [BZR]
     *
     */
    @JSONField(name = "bzr")
    @JsonProperty("bzr")
    private String bzr;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [TRMTRAINPLANTERMNAME]
     *
     */
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;

    /**
     * 属性 [PXKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxkssj" , format="yyyy-MM-dd")
    @JsonProperty("pxkssj")
    private Timestamp pxkssj;

    /**
     * 属性 [NJ]
     *
     */
    @JSONField(name = "nj")
    @JsonProperty("nj")
    private Integer nj;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [TRMTRAINPLANTERMID]
     *
     */
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;


    /**
     * 设置 [TRMTRIANPERSONNAME]
     */
    public void setTrmtrianpersonname(String  trmtrianpersonname){
        this.trmtrianpersonname = trmtrianpersonname ;
        this.modify("trmtrianpersonname",trmtrianpersonname);
    }

    /**
     * 设置 [SFZS]
     */
    public void setSfzs(Integer  sfzs){
        this.sfzs = sfzs ;
        this.modify("sfzs",sfzs);
    }

    /**
     * 设置 [GW]
     */
    public void setGw(String  gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [PXBJ]
     */
    public void setPxbj(String  pxbj){
        this.pxbj = pxbj ;
        this.modify("pxbj",pxbj);
    }

    /**
     * 设置 [PXJG]
     */
    public void setPxjg(String  pxjg){
        this.pxjg = pxjg ;
        this.modify("pxjg",pxjg);
    }

    /**
     * 设置 [PXKC]
     */
    public void setPxkc(String  pxkc){
        this.pxkc = pxkc ;
        this.modify("pxkc",pxkc);
    }

    /**
     * 设置 [JSFS]
     */
    public void setJsfs(String  jsfs){
        this.jsfs = jsfs ;
        this.modify("jsfs",jsfs);
    }

    /**
     * 设置 [FS]
     */
    public void setFs(Double  fs){
        this.fs = fs ;
        this.modify("fs",fs);
    }

    /**
     * 设置 [TRAINBEGIN]
     */
    public void setTrainbegin(Timestamp  trainbegin){
        this.trainbegin = trainbegin ;
        this.modify("trainbegin",trainbegin);
    }

    /**
     * 设置 [TRAINEND]
     */
    public void setTrainend(Timestamp  trainend){
        this.trainend = trainend ;
        this.modify("trainend",trainend);
    }

    /**
     * 设置 [FJH]
     */
    public void setFjh(String  fjh){
        this.fjh = fjh ;
        this.modify("fjh",fjh);
    }

    /**
     * 设置 [TRAINRES]
     */
    public void setTrainres(String  trainres){
        this.trainres = trainres ;
        this.modify("trainres",trainres);
    }

    /**
     * 设置 [PXJSSJ]
     */
    public void setPxjssj(Timestamp  pxjssj){
        this.pxjssj = pxjssj ;
        this.modify("pxjssj",pxjssj);
    }

    /**
     * 设置 [ZW]
     */
    public void setZw(String  zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [LXDH]
     */
    public void setLxdh(String  lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [XB]
     */
    public void setXb(String  xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [TRMTRAINAGENCYNAME]
     */
    public void setTrmtrainagencyname(String  trmtrainagencyname){
        this.trmtrainagencyname = trmtrainagencyname ;
        this.modify("trmtrainagencyname",trmtrainagencyname);
    }

    /**
     * 设置 [PIMPERSONNAME]
     */
    public void setPimpersonname(String  pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [TRMTRAINCOURSENAME]
     */
    public void setTrmtraincoursename(String  trmtraincoursename){
        this.trmtraincoursename = trmtraincoursename ;
        this.modify("trmtraincoursename",trmtraincoursename);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [TRMTRAINPLANTERMNAME]
     */
    public void setTrmtrainplantermname(String  trmtrainplantermname){
        this.trmtrainplantermname = trmtrainplantermname ;
        this.modify("trmtrainplantermname",trmtrainplantermname);
    }

    /**
     * 设置 [PXKSSJ]
     */
    public void setPxkssj(Timestamp  pxkssj){
        this.pxkssj = pxkssj ;
        this.modify("pxkssj",pxkssj);
    }

    /**
     * 设置 [NJ]
     */
    public void setNj(Integer  nj){
        this.nj = nj ;
        this.modify("nj",nj);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [TRMTRAINPLANTERMID]
     */
    public void setTrmtrainplantermid(String  trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }


}

