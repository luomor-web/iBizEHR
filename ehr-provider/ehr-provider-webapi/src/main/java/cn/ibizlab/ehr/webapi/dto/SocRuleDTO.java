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
 * 服务DTO对象[SocRuleDTO]
 */
@Data
public class SocRuleDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SOCRULEID]
     *
     */
    @JSONField(name = "socruleid")
    @JsonProperty("socruleid")
    private String socruleid;

    /**
     * 属性 [SOCRULENAME]
     *
     */
    @JSONField(name = "socrulename")
    @JsonProperty("socrulename")
    private String socrulename;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

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
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [NYEAR]
     *
     */
    @JSONField(name = "nyear")
    @JsonProperty("nyear")
    private Integer nyear;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [SOCAREAID]
     *
     */
    @JSONField(name = "socareaid")
    @JsonProperty("socareaid")
    private String socareaid;

    /**
     * 属性 [SOCAREANAME]
     *
     */
    @JSONField(name = "socareaname")
    @JsonProperty("socareaname")
    private String socareaname;

    /**
     * 属性 [STATE]
     *
     */
    @JSONField(name = "state")
    @JsonProperty("state")
    private String state;


    /**
     * 设置 [SOCRULENAME]
     */
    public void setSocrulename(String  socrulename){
        this.socrulename = socrulename ;
        this.modify("socrulename",socrulename);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [NYEAR]
     */
    public void setNyear(Integer  nyear){
        this.nyear = nyear ;
        this.modify("nyear",nyear);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [SOCAREAID]
     */
    public void setSocareaid(String  socareaid){
        this.socareaid = socareaid ;
        this.modify("socareaid",socareaid);
    }

    /**
     * 设置 [STATE]
     */
    public void setState(String  state){
        this.state = state ;
        this.modify("state",state);
    }


}

