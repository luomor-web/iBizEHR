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
 * 服务DTO对象[ParLhmbmxDTO]
 */
@Data
public class ParLhmbmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PARLHMBMXID]
     *
     */
    @JSONField(name = "parlhmbmxid")
    @JsonProperty("parlhmbmxid")
    private String parlhmbmxid;

    /**
     * 属性 [BZFZ]
     *
     */
    @JSONField(name = "bzfz")
    @JsonProperty("bzfz")
    private Double bzfz;

    /**
     * 属性 [PARLHMBMXNAME]
     *
     */
    @JSONField(name = "parlhmbmxname")
    @JsonProperty("parlhmbmxname")
    private String parlhmbmxname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [JZYQ]
     *
     */
    @JSONField(name = "jzyq")
    @JsonProperty("jzyq")
    private String jzyq;

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
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [WCBZ]
     *
     */
    @JSONField(name = "wcbz")
    @JsonProperty("wcbz")
    private String wcbz;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [KHBF]
     *
     */
    @JSONField(name = "khbf")
    @JsonProperty("khbf")
    private String khbf;

    /**
     * 属性 [PARJXLHMBNAME]
     *
     */
    @JSONField(name = "parjxlhmbname")
    @JsonProperty("parjxlhmbname")
    private String parjxlhmbname;

    /**
     * 属性 [PARJXLHMBID]
     *
     */
    @JSONField(name = "parjxlhmbid")
    @JsonProperty("parjxlhmbid")
    private String parjxlhmbid;


    /**
     * 设置 [BZFZ]
     */
    public void setBzfz(Double  bzfz){
        this.bzfz = bzfz ;
        this.modify("bzfz",bzfz);
    }

    /**
     * 设置 [PARLHMBMXNAME]
     */
    public void setParlhmbmxname(String  parlhmbmxname){
        this.parlhmbmxname = parlhmbmxname ;
        this.modify("parlhmbmxname",parlhmbmxname);
    }

    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [JZYQ]
     */
    public void setJzyq(String  jzyq){
        this.jzyq = jzyq ;
        this.modify("jzyq",jzyq);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [WCBZ]
     */
    public void setWcbz(String  wcbz){
        this.wcbz = wcbz ;
        this.modify("wcbz",wcbz);
    }

    /**
     * 设置 [KHBF]
     */
    public void setKhbf(String  khbf){
        this.khbf = khbf ;
        this.modify("khbf",khbf);
    }

    /**
     * 设置 [PARJXLHMBID]
     */
    public void setParjxlhmbid(String  parjxlhmbid){
        this.parjxlhmbid = parjxlhmbid ;
        this.modify("parjxlhmbid",parjxlhmbid);
    }


}

