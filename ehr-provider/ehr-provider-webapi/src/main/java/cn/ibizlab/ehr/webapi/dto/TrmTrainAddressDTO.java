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
 * 服务DTO对象[TrmTrainAddressDTO]
 */
@Data
public class TrmTrainAddressDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [JS]
     *
     */
    @JSONField(name = "js")
    @JsonProperty("js")
    private String js;

    /**
     * 属性 [PXLX]
     *
     */
    @JSONField(name = "pxlx")
    @JsonProperty("pxlx")
    private String pxlx;

    /**
     * 属性 [GXFW]
     *
     */
    @JSONField(name = "gxfw")
    @JsonProperty("gxfw")
    private String gxfw;

    /**
     * 属性 [EMAIL]
     *
     */
    @JSONField(name = "email")
    @JsonProperty("email")
    private String email;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [TRMTRAINADDRESSID]
     *
     */
    @JSONField(name = "trmtrainaddressid")
    @JsonProperty("trmtrainaddressid")
    private String trmtrainaddressid;

    /**
     * 属性 [DZ]
     *
     */
    @JSONField(name = "dz")
    @JsonProperty("dz")
    private String dz;

    /**
     * 属性 [SFQY]
     *
     */
    @JSONField(name = "sfqy")
    @JsonProperty("sfqy")
    private Integer sfqy;

    /**
     * 属性 [HJZK]
     *
     */
    @JSONField(name = "hjzk")
    @JsonProperty("hjzk")
    private String hjzk;

    /**
     * 属性 [SF]
     *
     */
    @JSONField(name = "sf")
    @JsonProperty("sf")
    private String sf;

    /**
     * 属性 [LXR]
     *
     */
    @JSONField(name = "lxr")
    @JsonProperty("lxr")
    private String lxr;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SFKP]
     *
     */
    @JSONField(name = "sfkp")
    @JsonProperty("sfkp")
    private Integer sfkp;

    /**
     * 属性 [XZ]
     *
     */
    @JSONField(name = "xz")
    @JsonProperty("xz")
    private String xz;

    /**
     * 属性 [XJ]
     *
     */
    @JSONField(name = "xj")
    @JsonProperty("xj")
    private String xj;

    /**
     * 属性 [TRMTRAINADDRESSNAME]
     *
     */
    @JSONField(name = "trmtrainaddressname")
    @JsonProperty("trmtrainaddressname")
    private String trmtrainaddressname;

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
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [S]
     *
     */
    @JSONField(name = "s")
    @JsonProperty("s")
    private String s;

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
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [JS]
     */
    public void setJs(String  js){
        this.js = js ;
        this.modify("js",js);
    }

    /**
     * 设置 [PXLX]
     */
    public void setPxlx(String  pxlx){
        this.pxlx = pxlx ;
        this.modify("pxlx",pxlx);
    }

    /**
     * 设置 [GXFW]
     */
    public void setGxfw(String  gxfw){
        this.gxfw = gxfw ;
        this.modify("gxfw",gxfw);
    }

    /**
     * 设置 [EMAIL]
     */
    public void setEmail(String  email){
        this.email = email ;
        this.modify("email",email);
    }

    /**
     * 设置 [DZ]
     */
    public void setDz(String  dz){
        this.dz = dz ;
        this.modify("dz",dz);
    }

    /**
     * 设置 [SFQY]
     */
    public void setSfqy(Integer  sfqy){
        this.sfqy = sfqy ;
        this.modify("sfqy",sfqy);
    }

    /**
     * 设置 [HJZK]
     */
    public void setHjzk(String  hjzk){
        this.hjzk = hjzk ;
        this.modify("hjzk",hjzk);
    }

    /**
     * 设置 [SF]
     */
    public void setSf(String  sf){
        this.sf = sf ;
        this.modify("sf",sf);
    }

    /**
     * 设置 [LXR]
     */
    public void setLxr(String  lxr){
        this.lxr = lxr ;
        this.modify("lxr",lxr);
    }

    /**
     * 设置 [SFKP]
     */
    public void setSfkp(Integer  sfkp){
        this.sfkp = sfkp ;
        this.modify("sfkp",sfkp);
    }

    /**
     * 设置 [XZ]
     */
    public void setXz(String  xz){
        this.xz = xz ;
        this.modify("xz",xz);
    }

    /**
     * 设置 [XJ]
     */
    public void setXj(String  xj){
        this.xj = xj ;
        this.modify("xj",xj);
    }

    /**
     * 设置 [TRMTRAINADDRESSNAME]
     */
    public void setTrmtrainaddressname(String  trmtrainaddressname){
        this.trmtrainaddressname = trmtrainaddressname ;
        this.modify("trmtrainaddressname",trmtrainaddressname);
    }

    /**
     * 设置 [LXDH]
     */
    public void setLxdh(String  lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [S]
     */
    public void setS(String  s){
        this.s = s ;
        this.modify("s",s);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

