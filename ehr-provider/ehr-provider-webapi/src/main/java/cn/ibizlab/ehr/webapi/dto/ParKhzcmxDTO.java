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
 * 服务DTO对象[ParKhzcmxDTO]
 */
@Data
public class ParKhzcmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SZQZ]
     *
     */
    @JSONField(name = "szqz")
    @JsonProperty("szqz")
    private Double szqz;

    /**
     * 属性 [PARKHZCMXID]
     *
     */
    @JSONField(name = "parkhzcmxid")
    @JsonProperty("parkhzcmxid")
    private String parkhzcmxid;

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
     * 属性 [SFQY]
     *
     */
    @JSONField(name = "sfqy")
    @JsonProperty("sfqy")
    private Integer sfqy;

    /**
     * 属性 [PARKHZCMXNAME]
     *
     */
    @JSONField(name = "parkhzcmxname")
    @JsonProperty("parkhzcmxname")
    private String parkhzcmxname;

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
     * 属性 [KHDX]
     *
     */
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;

    /**
     * 属性 [PARJXKHJCSZNAME]
     *
     */
    @JSONField(name = "parjxkhjcszname")
    @JsonProperty("parjxkhjcszname")
    private String parjxkhjcszname;

    /**
     * 属性 [PARJXKHJCSZID]
     *
     */
    @JSONField(name = "parjxkhjcszid")
    @JsonProperty("parjxkhjcszid")
    private String parjxkhjcszid;

    /**
     * 属性 [PARASSESSTEMPLATEID]
     *
     */
    @JSONField(name = "parassesstemplateid")
    @JsonProperty("parassesstemplateid")
    private String parassesstemplateid;

    /**
     * 属性 [PARASSESSTEMPLATENAME]
     *
     */
    @JSONField(name = "parassesstemplatename")
    @JsonProperty("parassesstemplatename")
    private String parassesstemplatename;

    /**
     * 属性 [KHNR]
     *
     */
    @JSONField(name = "khnr")
    @JsonProperty("khnr")
    private String khnr;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;


    /**
     * 设置 [SZQZ]
     */
    public void setSzqz(Double  szqz){
        this.szqz = szqz ;
        this.modify("szqz",szqz);
    }

    /**
     * 设置 [SFQY]
     */
    public void setSfqy(Integer  sfqy){
        this.sfqy = sfqy ;
        this.modify("sfqy",sfqy);
    }

    /**
     * 设置 [PARKHZCMXNAME]
     */
    public void setParkhzcmxname(String  parkhzcmxname){
        this.parkhzcmxname = parkhzcmxname ;
        this.modify("parkhzcmxname",parkhzcmxname);
    }

    /**
     * 设置 [PARJXKHJCSZID]
     */
    public void setParjxkhjcszid(String  parjxkhjcszid){
        this.parjxkhjcszid = parjxkhjcszid ;
        this.modify("parjxkhjcszid",parjxkhjcszid);
    }

    /**
     * 设置 [PARASSESSTEMPLATEID]
     */
    public void setParassesstemplateid(String  parassesstemplateid){
        this.parassesstemplateid = parassesstemplateid ;
        this.modify("parassesstemplateid",parassesstemplateid);
    }

    /**
     * 设置 [KHNR]
     */
    public void setKhnr(String  khnr){
        this.khnr = khnr ;
        this.modify("khnr",khnr);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }


}

