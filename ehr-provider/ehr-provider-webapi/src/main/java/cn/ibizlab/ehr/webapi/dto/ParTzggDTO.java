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
 * 服务DTO对象[ParTzggDTO]
 */
@Data
public class ParTzggDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PARTZGGID]
     *
     */
    @JSONField(name = "partzggid")
    @JsonProperty("partzggid")
    private String partzggid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [LHZBMB]
     *
     */
    @JSONField(name = "lhzbmb")
    @JsonProperty("lhzbmb")
    private String lhzbmb;

    /**
     * 属性 [ZQLX]
     *
     */
    @JSONField(name = "zqlx")
    @JsonProperty("zqlx")
    private String zqlx;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [YD]
     *
     */
    @JSONField(name = "yd")
    @JsonProperty("yd")
    private String yd;

    /**
     * 属性 [TZLX]
     *
     */
    @JSONField(name = "tzlx")
    @JsonProperty("tzlx")
    private String tzlx;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PARTZGGNAME]
     *
     */
    @JSONField(name = "partzggname")
    @JsonProperty("partzggname")
    private String partzggname;

    /**
     * 属性 [JZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jzsj" , format="yyyy-MM-dd")
    @JsonProperty("jzsj")
    private Timestamp jzsj;


    /**
     * 设置 [LHZBMB]
     */
    public void setLhzbmb(String  lhzbmb){
        this.lhzbmb = lhzbmb ;
        this.modify("lhzbmb",lhzbmb);
    }

    /**
     * 设置 [ZQLX]
     */
    public void setZqlx(String  zqlx){
        this.zqlx = zqlx ;
        this.modify("zqlx",zqlx);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [YD]
     */
    public void setYd(String  yd){
        this.yd = yd ;
        this.modify("yd",yd);
    }

    /**
     * 设置 [TZLX]
     */
    public void setTzlx(String  tzlx){
        this.tzlx = tzlx ;
        this.modify("tzlx",tzlx);
    }

    /**
     * 设置 [PARTZGGNAME]
     */
    public void setPartzggname(String  partzggname){
        this.partzggname = partzggname ;
        this.modify("partzggname",partzggname);
    }

    /**
     * 设置 [JZSJ]
     */
    public void setJzsj(Timestamp  jzsj){
        this.jzsj = jzsj ;
        this.modify("jzsj",jzsj);
    }


}

