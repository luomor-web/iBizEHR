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
 * 服务DTO对象[OrmXmxqhzDTO]
 */
@Data
public class OrmXmxqhzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [XM]
     *
     */
    @JSONField(name = "xm")
    @JsonProperty("xm")
    private String xm;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [ORMXMXQHZNAME]
     *
     */
    @JSONField(name = "ormxmxqhzname")
    @JsonProperty("ormxmxqhzname")
    private String ormxmxqhzname;

    /**
     * 属性 [ORMXMXQHZID]
     *
     */
    @JSONField(name = "ormxmxqhzid")
    @JsonProperty("ormxmxqhzid")
    private String ormxmxqhzid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [RS]
     *
     */
    @JSONField(name = "rs")
    @JsonProperty("rs")
    private Integer rs;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [XMID]
     *
     */
    @JSONField(name = "xmid")
    @JsonProperty("xmid")
    private String xmid;

    /**
     * 属性 [YF]
     *
     */
    @JSONField(name = "yf")
    @JsonProperty("yf")
    private String yf;


    /**
     * 设置 [XM]
     */
    public void setXm(String  xm){
        this.xm = xm ;
        this.modify("xm",xm);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [ORMXMXQHZNAME]
     */
    public void setOrmxmxqhzname(String  ormxmxqhzname){
        this.ormxmxqhzname = ormxmxqhzname ;
        this.modify("ormxmxqhzname",ormxmxqhzname);
    }

    /**
     * 设置 [RS]
     */
    public void setRs(Integer  rs){
        this.rs = rs ;
        this.modify("rs",rs);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [GW]
     */
    public void setGw(String  gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [XMID]
     */
    public void setXmid(String  xmid){
        this.xmid = xmid ;
        this.modify("xmid",xmid);
    }

    /**
     * 设置 [YF]
     */
    public void setYf(String  yf){
        this.yf = yf ;
        this.modify("yf",yf);
    }


}

