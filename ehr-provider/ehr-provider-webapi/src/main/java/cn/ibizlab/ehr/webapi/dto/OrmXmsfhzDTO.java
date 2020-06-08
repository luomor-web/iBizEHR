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
 * 服务DTO对象[OrmXmsfhzDTO]
 */
@Data
public class OrmXmsfhzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [AUGY_COLOR]
     *
     */
    @JSONField(name = "augy_color")
    @JsonProperty("augy_color")
    private String augyColor;

    /**
     * 属性 [MONTH]
     *
     */
    @JSONField(name = "month")
    @JsonProperty("month")
    private String month;

    /**
     * 属性 [YF_COLOR]
     *
     */
    @JSONField(name = "yf_color")
    @JsonProperty("yf_color")
    private String yfColor;

    /**
     * 属性 [AUGY]
     *
     */
    @JSONField(name = "augy")
    @JsonProperty("augy")
    private String augy;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [EY]
     *
     */
    @JSONField(name = "ey")
    @JsonProperty("ey")
    private String ey;

    /**
     * 属性 [JY]
     *
     */
    @JSONField(name = "jy")
    @JsonProperty("jy")
    private String jy;

    /**
     * 属性 [QY_COLOR]
     *
     */
    @JSONField(name = "qy_color")
    @JsonProperty("qy_color")
    private String qyColor;

    /**
     * 属性 [APY]
     *
     */
    @JSONField(name = "apy")
    @JsonProperty("apy")
    private String apy;

    /**
     * 属性 [YY]
     *
     */
    @JSONField(name = "yy")
    @JsonProperty("yy")
    private String yy;

    /**
     * 属性 [SYY_COLOR]
     *
     */
    @JSONField(name = "syy_color")
    @JsonProperty("syy_color")
    private String syyColor;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [ORMXMSFHZID]
     *
     */
    @JSONField(name = "ormxmsfhzid")
    @JsonProperty("ormxmsfhzid")
    private String ormxmsfhzid;

    /**
     * 属性 [XM]
     *
     */
    @JSONField(name = "xm")
    @JsonProperty("xm")
    private String xm;

    /**
     * 属性 [SYY]
     *
     */
    @JSONField(name = "syy")
    @JsonProperty("syy")
    private String syy;

    /**
     * 属性 [SY]
     *
     */
    @JSONField(name = "sy")
    @JsonProperty("sy")
    private String sy;

    /**
     * 属性 [SY_COLOR]
     *
     */
    @JSONField(name = "sy_color")
    @JsonProperty("sy_color")
    private String syColor;

    /**
     * 属性 [WY_COLOR]
     *
     */
    @JSONField(name = "wy_color")
    @JsonProperty("wy_color")
    private String wyColor;

    /**
     * 属性 [OCTY]
     *
     */
    @JSONField(name = "octy")
    @JsonProperty("octy")
    private String octy;

    /**
     * 属性 [RS]
     *
     */
    @JSONField(name = "rs")
    @JsonProperty("rs")
    private Integer rs;

    /**
     * 属性 [EY_COLOR]
     *
     */
    @JSONField(name = "ey_color")
    @JsonProperty("ey_color")
    private String eyColor;

    /**
     * 属性 [ORMXMSFHZNAME]
     *
     */
    @JSONField(name = "ormxmsfhzname")
    @JsonProperty("ormxmsfhzname")
    private String ormxmsfhzname;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [WY]
     *
     */
    @JSONField(name = "wy")
    @JsonProperty("wy")
    private String wy;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [LY]
     *
     */
    @JSONField(name = "ly")
    @JsonProperty("ly")
    private String ly;

    /**
     * 属性 [APY_COLOR]
     *
     */
    @JSONField(name = "apy_color")
    @JsonProperty("apy_color")
    private String apyColor;

    /**
     * 属性 [YY_COLOR]
     *
     */
    @JSONField(name = "yy_color")
    @JsonProperty("yy_color")
    private String yyColor;

    /**
     * 属性 [YF]
     *
     */
    @JSONField(name = "yf")
    @JsonProperty("yf")
    private String yf;

    /**
     * 属性 [JY_COLOR]
     *
     */
    @JSONField(name = "jy_color")
    @JsonProperty("jy_color")
    private String jyColor;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [LY_COLOR]
     *
     */
    @JSONField(name = "ly_color")
    @JsonProperty("ly_color")
    private String lyColor;

    /**
     * 属性 [QY]
     *
     */
    @JSONField(name = "qy")
    @JsonProperty("qy")
    private String qy;

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
     * 属性 [OCTY_COLOR]
     *
     */
    @JSONField(name = "octy_color")
    @JsonProperty("octy_color")
    private String octyColor;


    /**
     * 设置 [MONTH]
     */
    public void setMonth(String  month){
        this.month = month ;
        this.modify("month",month);
    }

    /**
     * 设置 [AUGY]
     */
    public void setAugy(String  augy){
        this.augy = augy ;
        this.modify("augy",augy);
    }

    /**
     * 设置 [EY]
     */
    public void setEy(String  ey){
        this.ey = ey ;
        this.modify("ey",ey);
    }

    /**
     * 设置 [JY]
     */
    public void setJy(String  jy){
        this.jy = jy ;
        this.modify("jy",jy);
    }

    /**
     * 设置 [APY]
     */
    public void setApy(String  apy){
        this.apy = apy ;
        this.modify("apy",apy);
    }

    /**
     * 设置 [YY]
     */
    public void setYy(String  yy){
        this.yy = yy ;
        this.modify("yy",yy);
    }

    /**
     * 设置 [GW]
     */
    public void setGw(String  gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [XM]
     */
    public void setXm(String  xm){
        this.xm = xm ;
        this.modify("xm",xm);
    }

    /**
     * 设置 [SYY]
     */
    public void setSyy(String  syy){
        this.syy = syy ;
        this.modify("syy",syy);
    }

    /**
     * 设置 [SY]
     */
    public void setSy(String  sy){
        this.sy = sy ;
        this.modify("sy",sy);
    }

    /**
     * 设置 [OCTY]
     */
    public void setOcty(String  octy){
        this.octy = octy ;
        this.modify("octy",octy);
    }

    /**
     * 设置 [RS]
     */
    public void setRs(Integer  rs){
        this.rs = rs ;
        this.modify("rs",rs);
    }

    /**
     * 设置 [ORMXMSFHZNAME]
     */
    public void setOrmxmsfhzname(String  ormxmsfhzname){
        this.ormxmsfhzname = ormxmsfhzname ;
        this.modify("ormxmsfhzname",ormxmsfhzname);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [WY]
     */
    public void setWy(String  wy){
        this.wy = wy ;
        this.modify("wy",wy);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [LY]
     */
    public void setLy(String  ly){
        this.ly = ly ;
        this.modify("ly",ly);
    }

    /**
     * 设置 [YF]
     */
    public void setYf(String  yf){
        this.yf = yf ;
        this.modify("yf",yf);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [QY]
     */
    public void setQy(String  qy){
        this.qy = qy ;
        this.modify("qy",qy);
    }


}

