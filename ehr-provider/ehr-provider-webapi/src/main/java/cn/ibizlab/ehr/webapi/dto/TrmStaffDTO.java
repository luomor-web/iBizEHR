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
 * 服务DTO对象[TrmStaffDTO]
 */
@Data
public class TrmStaffDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

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
     * 属性 [TRMSTAFFNAME]
     *
     */
    @JSONField(name = "trmstaffname")
    @JsonProperty("trmstaffname")
    private String trmstaffname;

    /**
     * 属性 [XQLYLX]
     *
     */
    @JSONField(name = "xqlylx")
    @JsonProperty("xqlylx")
    private String xqlylx;

    /**
     * 属性 [SPFS]
     *
     */
    @JSONField(name = "spfs")
    @JsonProperty("spfs")
    private String spfs;

    /**
     * 属性 [TDRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tdrq" , format="yyyy-MM-dd")
    @JsonProperty("tdrq")
    private Timestamp tdrq;

    /**
     * 属性 [LCLX]
     *
     */
    @JSONField(name = "lclx")
    @JsonProperty("lclx")
    private String lclx;

    /**
     * 属性 [XQDBMA]
     *
     */
    @JSONField(name = "xqdbma")
    @JsonProperty("xqdbma")
    private String xqdbma;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [GZZZ]
     *
     */
    @JSONField(name = "gzzz")
    @JsonProperty("gzzz")
    private String gzzz;

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
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [TRMSTAFFID]
     *
     */
    @JSONField(name = "trmstaffid")
    @JsonProperty("trmstaffid")
    private String trmstaffid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [XL]
     *
     */
    @JSONField(name = "xl")
    @JsonProperty("xl")
    private String xl;

    /**
     * 属性 [PIMPERSONNAME2]
     *
     */
    @JSONField(name = "pimpersonname2")
    @JsonProperty("pimpersonname2")
    private String pimpersonname2;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PIMPERSONID2]
     *
     */
    @JSONField(name = "pimpersonid2")
    @JsonProperty("pimpersonid2")
    private String pimpersonid2;


    /**
     * 设置 [TRMSTAFFNAME]
     */
    public void setTrmstaffname(String  trmstaffname){
        this.trmstaffname = trmstaffname ;
        this.modify("trmstaffname",trmstaffname);
    }

    /**
     * 设置 [XQLYLX]
     */
    public void setXqlylx(String  xqlylx){
        this.xqlylx = xqlylx ;
        this.modify("xqlylx",xqlylx);
    }

    /**
     * 设置 [SPFS]
     */
    public void setSpfs(String  spfs){
        this.spfs = spfs ;
        this.modify("spfs",spfs);
    }

    /**
     * 设置 [TDRQ]
     */
    public void setTdrq(Timestamp  tdrq){
        this.tdrq = tdrq ;
        this.modify("tdrq",tdrq);
    }

    /**
     * 设置 [LCLX]
     */
    public void setLclx(String  lclx){
        this.lclx = lclx ;
        this.modify("lclx",lclx);
    }

    /**
     * 设置 [XQDBMA]
     */
    public void setXqdbma(String  xqdbma){
        this.xqdbma = xqdbma ;
        this.modify("xqdbma",xqdbma);
    }

    /**
     * 设置 [ZW]
     */
    public void setZw(String  zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [GZZZ]
     */
    public void setGzzz(String  gzzz){
        this.gzzz = gzzz ;
        this.modify("gzzz",gzzz);
    }

    /**
     * 设置 [GW]
     */
    public void setGw(String  gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [XL]
     */
    public void setXl(String  xl){
        this.xl = xl ;
        this.modify("xl",xl);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [PIMPERSONID2]
     */
    public void setPimpersonid2(String  pimpersonid2){
        this.pimpersonid2 = pimpersonid2 ;
        this.modify("pimpersonid2",pimpersonid2);
    }


}

