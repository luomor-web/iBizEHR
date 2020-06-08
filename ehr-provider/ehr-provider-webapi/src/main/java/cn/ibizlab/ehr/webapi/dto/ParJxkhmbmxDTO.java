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
 * 服务DTO对象[ParJxkhmbmxDTO]
 */
@Data
public class ParJxkhmbmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PARJXKHMBMXNAME]
     *
     */
    @JSONField(name = "parjxkhmbmxname")
    @JsonProperty("parjxkhmbmxname")
    private String parjxkhmbmxname;

    /**
     * 属性 [ZDFZ]
     *
     */
    @JSONField(name = "zdfz")
    @JsonProperty("zdfz")
    private Double zdfz;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PARJXKHMBMXID]
     *
     */
    @JSONField(name = "parjxkhmbmxid")
    @JsonProperty("parjxkhmbmxid")
    private String parjxkhmbmxid;

    /**
     * 属性 [FZ]
     *
     */
    @JSONField(name = "fz")
    @JsonProperty("fz")
    private String fz;

    /**
     * 属性 [ZB]
     *
     */
    @JSONField(name = "zb")
    @JsonProperty("zb")
    private String zb;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

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
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [ZXFZ]
     *
     */
    @JSONField(name = "zxfz")
    @JsonProperty("zxfz")
    private Double zxfz;

    /**
     * 属性 [PARJXKHMBNAME]
     *
     */
    @JSONField(name = "parjxkhmbname")
    @JsonProperty("parjxkhmbname")
    private String parjxkhmbname;

    /**
     * 属性 [PARJXKHMBID]
     *
     */
    @JSONField(name = "parjxkhmbid")
    @JsonProperty("parjxkhmbid")
    private String parjxkhmbid;


    /**
     * 设置 [PARJXKHMBMXNAME]
     */
    public void setParjxkhmbmxname(String  parjxkhmbmxname){
        this.parjxkhmbmxname = parjxkhmbmxname ;
        this.modify("parjxkhmbmxname",parjxkhmbmxname);
    }

    /**
     * 设置 [ZDFZ]
     */
    public void setZdfz(Double  zdfz){
        this.zdfz = zdfz ;
        this.modify("zdfz",zdfz);
    }

    /**
     * 设置 [FZ]
     */
    public void setFz(String  fz){
        this.fz = fz ;
        this.modify("fz",fz);
    }

    /**
     * 设置 [ZB]
     */
    public void setZb(String  zb){
        this.zb = zb ;
        this.modify("zb",zb);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [ZXFZ]
     */
    public void setZxfz(Double  zxfz){
        this.zxfz = zxfz ;
        this.modify("zxfz",zxfz);
    }

    /**
     * 设置 [PARJXKHMBID]
     */
    public void setParjxkhmbid(String  parjxkhmbid){
        this.parjxkhmbid = parjxkhmbid ;
        this.modify("parjxkhmbid",parjxkhmbid);
    }


}

