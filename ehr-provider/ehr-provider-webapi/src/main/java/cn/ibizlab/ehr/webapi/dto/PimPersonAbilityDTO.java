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
 * 服务DTO对象[PimPersonAbilityDTO]
 */
@Data
public class PimPersonAbilityDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PIMPERSONABILITYID]
     *
     */
    @JSONField(name = "pimpersonabilityid")
    @JsonProperty("pimpersonabilityid")
    private String pimpersonabilityid;

    /**
     * 属性 [PERFORMSCORE]
     *
     */
    @JSONField(name = "performscore")
    @JsonProperty("performscore")
    private Double performscore;

    /**
     * 属性 [TECHSCORE]
     *
     */
    @JSONField(name = "techscore")
    @JsonProperty("techscore")
    private String techscore;

    /**
     * 属性 [YEAR]
     *
     */
    @JSONField(name = "year")
    @JsonProperty("year")
    private Integer year;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PRACSCORE]
     *
     */
    @JSONField(name = "pracscore")
    @JsonProperty("pracscore")
    private Double pracscore;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [RECORDDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "recorddate" , format="yyyy-MM-dd")
    @JsonProperty("recorddate")
    private Timestamp recorddate;

    /**
     * 属性 [MONTH]
     *
     */
    @JSONField(name = "month")
    @JsonProperty("month")
    private Integer month;

    /**
     * 属性 [TRAINRESULTSCORE]
     *
     */
    @JSONField(name = "trainresultscore")
    @JsonProperty("trainresultscore")
    private Double trainresultscore;

    /**
     * 属性 [EDUSCORE]
     *
     */
    @JSONField(name = "eduscore")
    @JsonProperty("eduscore")
    private Double eduscore;

    /**
     * 属性 [PIMPERSONABILITYNAME]
     *
     */
    @JSONField(name = "pimpersonabilityname")
    @JsonProperty("pimpersonabilityname")
    private String pimpersonabilityname;

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
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [PERFORMSCORE]
     */
    public void setPerformscore(Double  performscore){
        this.performscore = performscore ;
        this.modify("performscore",performscore);
    }

    /**
     * 设置 [TECHSCORE]
     */
    public void setTechscore(String  techscore){
        this.techscore = techscore ;
        this.modify("techscore",techscore);
    }

    /**
     * 设置 [YEAR]
     */
    public void setYear(Integer  year){
        this.year = year ;
        this.modify("year",year);
    }

    /**
     * 设置 [PRACSCORE]
     */
    public void setPracscore(Double  pracscore){
        this.pracscore = pracscore ;
        this.modify("pracscore",pracscore);
    }

    /**
     * 设置 [RECORDDATE]
     */
    public void setRecorddate(Timestamp  recorddate){
        this.recorddate = recorddate ;
        this.modify("recorddate",recorddate);
    }

    /**
     * 设置 [MONTH]
     */
    public void setMonth(Integer  month){
        this.month = month ;
        this.modify("month",month);
    }

    /**
     * 设置 [TRAINRESULTSCORE]
     */
    public void setTrainresultscore(Double  trainresultscore){
        this.trainresultscore = trainresultscore ;
        this.modify("trainresultscore",trainresultscore);
    }

    /**
     * 设置 [EDUSCORE]
     */
    public void setEduscore(Double  eduscore){
        this.eduscore = eduscore ;
        this.modify("eduscore",eduscore);
    }

    /**
     * 设置 [PIMPERSONABILITYNAME]
     */
    public void setPimpersonabilityname(String  pimpersonabilityname){
        this.pimpersonabilityname = pimpersonabilityname ;
        this.modify("pimpersonabilityname",pimpersonabilityname);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

