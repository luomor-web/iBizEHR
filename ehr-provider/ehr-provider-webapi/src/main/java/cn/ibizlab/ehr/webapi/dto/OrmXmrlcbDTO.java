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
 * 服务DTO对象[OrmXmrlcbDTO]
 */
@Data
public class OrmXmrlcbDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ZZMC]
     *
     */
    @JSONField(name = "zzmc")
    @JsonProperty("zzmc")
    private String zzmc;

    /**
     * 属性 [XM]
     *
     */
    @JSONField(name = "xm")
    @JsonProperty("xm")
    private String xm;

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
     * 属性 [XCRY_COLOR]
     *
     */
    @JSONField(name = "xcry_color")
    @JsonProperty("xcry_color")
    private String xcryColor;

    /**
     * 属性 [XMSJRY_COLOR]
     *
     */
    @JSONField(name = "xmsjry_color")
    @JsonProperty("xmsjry_color")
    private String xmsjryColor;

    /**
     * 属性 [ORMXMRLCBNAME]
     *
     */
    @JSONField(name = "ormxmrlcbname")
    @JsonProperty("ormxmrlcbname")
    private String ormxmrlcbname;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [XMJHZCCB]
     *
     */
    @JSONField(name = "xmjhzccb")
    @JsonProperty("xmjhzccb")
    private Double xmjhzccb;

    /**
     * 属性 [XCED]
     *
     */
    @JSONField(name = "xced")
    @JsonProperty("xced")
    private Double xced;

    /**
     * 属性 [XMSJRY]
     *
     */
    @JSONField(name = "xmsjry")
    @JsonProperty("xmsjry")
    private Integer xmsjry;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ORMXMRLCBID]
     *
     */
    @JSONField(name = "ormxmrlcbid")
    @JsonProperty("ormxmrlcbid")
    private String ormxmrlcbid;

    /**
     * 属性 [XMSJZCCB]
     *
     */
    @JSONField(name = "xmsjzccb")
    @JsonProperty("xmsjzccb")
    private Double xmsjzccb;

    /**
     * 属性 [XCRY]
     *
     */
    @JSONField(name = "xcry")
    @JsonProperty("xcry")
    private Integer xcry;

    /**
     * 属性 [XMJHRY]
     *
     */
    @JSONField(name = "xmjhry")
    @JsonProperty("xmjhry")
    private Integer xmjhry;

    /**
     * 属性 [XMB]
     *
     */
    @JSONField(name = "xmb")
    @JsonProperty("xmb")
    private String xmb;


    /**
     * 设置 [ZZMC]
     */
    public void setZzmc(String  zzmc){
        this.zzmc = zzmc ;
        this.modify("zzmc",zzmc);
    }

    /**
     * 设置 [XM]
     */
    public void setXm(String  xm){
        this.xm = xm ;
        this.modify("xm",xm);
    }

    /**
     * 设置 [ORMXMRLCBNAME]
     */
    public void setOrmxmrlcbname(String  ormxmrlcbname){
        this.ormxmrlcbname = ormxmrlcbname ;
        this.modify("ormxmrlcbname",ormxmrlcbname);
    }

    /**
     * 设置 [XMJHZCCB]
     */
    public void setXmjhzccb(Double  xmjhzccb){
        this.xmjhzccb = xmjhzccb ;
        this.modify("xmjhzccb",xmjhzccb);
    }

    /**
     * 设置 [XCED]
     */
    public void setXced(Double  xced){
        this.xced = xced ;
        this.modify("xced",xced);
    }

    /**
     * 设置 [XMSJRY]
     */
    public void setXmsjry(Integer  xmsjry){
        this.xmsjry = xmsjry ;
        this.modify("xmsjry",xmsjry);
    }

    /**
     * 设置 [XMSJZCCB]
     */
    public void setXmsjzccb(Double  xmsjzccb){
        this.xmsjzccb = xmsjzccb ;
        this.modify("xmsjzccb",xmsjzccb);
    }

    /**
     * 设置 [XCRY]
     */
    public void setXcry(Integer  xcry){
        this.xcry = xcry ;
        this.modify("xcry",xcry);
    }

    /**
     * 设置 [XMJHRY]
     */
    public void setXmjhry(Integer  xmjhry){
        this.xmjhry = xmjhry ;
        this.modify("xmjhry",xmjhry);
    }

    /**
     * 设置 [XMB]
     */
    public void setXmb(String  xmb){
        this.xmb = xmb ;
        this.modify("xmb",xmb);
    }


}

