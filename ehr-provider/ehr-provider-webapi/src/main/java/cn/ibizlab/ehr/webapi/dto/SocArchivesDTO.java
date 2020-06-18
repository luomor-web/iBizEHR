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
 * 服务DTO对象[SocArchivesDTO]
 */
@Data
public class SocArchivesDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SOCARCHIVESID]
     *
     */
    @JSONField(name = "socarchivesid")
    @JsonProperty("socarchivesid")
    private String socarchivesid;

    /**
     * 属性 [SOCARCHIVESNAME]
     *
     */
    @JSONField(name = "socarchivesname")
    @JsonProperty("socarchivesname")
    private String socarchivesname;

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
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [SOCACCOUNTID]
     *
     */
    @JSONField(name = "socaccountid")
    @JsonProperty("socaccountid")
    private String socaccountid;

    /**
     * 属性 [SOCACCOUNTNAME]
     *
     */
    @JSONField(name = "socaccountname")
    @JsonProperty("socaccountname")
    private String socaccountname;

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
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [STATE]
     *
     */
    @JSONField(name = "state")
    @JsonProperty("state")
    private String state;

    /**
     * 属性 [YGZT]
     *
     */
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;


    /**
     * 设置 [SOCARCHIVESNAME]
     */
    public void setSocarchivesname(String  socarchivesname){
        this.socarchivesname = socarchivesname ;
        this.modify("socarchivesname",socarchivesname);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [SOCACCOUNTID]
     */
    public void setSocaccountid(String  socaccountid){
        this.socaccountid = socaccountid ;
        this.modify("socaccountid",socaccountid);
    }

    /**
     * 设置 [SOCRULEID]
     */
    public void setSocruleid(String  socruleid){
        this.socruleid = socruleid ;
        this.modify("socruleid",socruleid);
    }

    /**
     * 设置 [STATE]
     */
    public void setState(String  state){
        this.state = state ;
        this.modify("state",state);
    }


}

