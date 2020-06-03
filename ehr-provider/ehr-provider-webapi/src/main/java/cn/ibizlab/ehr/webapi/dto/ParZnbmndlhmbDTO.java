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
 * 服务DTO对象[ParZnbmndlhmbDTO]
 */
@Data
public class ParZnbmndlhmbDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SSTZ]
     *
     */
    @JSONField(name = "sstz")
    @JsonProperty("sstz")
    private String sstz;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [PARZNBMNDLHMBNAME]
     *
     */
    @JSONField(name = "parznbmndlhmbname")
    @JsonProperty("parznbmndlhmbname")
    private String parznbmndlhmbname;

    /**
     * 属性 [BMFZR]
     *
     */
    @JSONField(name = "bmfzr")
    @JsonProperty("bmfzr")
    private String bmfzr;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PARZNBMNDLHMBID]
     *
     */
    @JSONField(name = "parznbmndlhmbid")
    @JsonProperty("parznbmndlhmbid")
    private String parznbmndlhmbid;

    /**
     * 属性 [JXJD]
     *
     */
    @JSONField(name = "jxjd")
    @JsonProperty("jxjd")
    private String jxjd;

    /**
     * 属性 [MC]
     *
     */
    @JSONField(name = "mc")
    @JsonProperty("mc")
    private String mc;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [SSORG]
     *
     */
    @JSONField(name = "ssorg")
    @JsonProperty("ssorg")
    private String ssorg;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;


    /**
     * 设置 [SSTZ]
     */
    public void setSstz(String  sstz){
        this.sstz = sstz ;
        this.modify("sstz",sstz);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [PARZNBMNDLHMBNAME]
     */
    public void setParznbmndlhmbname(String  parznbmndlhmbname){
        this.parznbmndlhmbname = parznbmndlhmbname ;
        this.modify("parznbmndlhmbname",parznbmndlhmbname);
    }

    /**
     * 设置 [BMFZR]
     */
    public void setBmfzr(String  bmfzr){
        this.bmfzr = bmfzr ;
        this.modify("bmfzr",bmfzr);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [JXJD]
     */
    public void setJxjd(String  jxjd){
        this.jxjd = jxjd ;
        this.modify("jxjd",jxjd);
    }

    /**
     * 设置 [MC]
     */
    public void setMc(String  mc){
        this.mc = mc ;
        this.modify("mc",mc);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}

