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
 * 服务DTO对象[PcmMspjxxDTO]
 */
@Data
public class PcmMspjxxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [OFFICER]
     *
     */
    @JSONField(name = "officer")
    @JsonProperty("officer")
    private String officer;

    /**
     * 属性 [INTERVIEWTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "interviewtime" , format="yyyy-MM-dd")
    @JsonProperty("interviewtime")
    private Timestamp interviewtime;

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
     * 属性 [PCMMSPJXXNAME]
     *
     */
    @JSONField(name = "pcmmspjxxname")
    @JsonProperty("pcmmspjxxname")
    private String pcmmspjxxname;

    /**
     * 属性 [EVALUATE]
     *
     */
    @JSONField(name = "evaluate")
    @JsonProperty("evaluate")
    private String evaluate;

    /**
     * 属性 [INTERVIEWID]
     *
     */
    @JSONField(name = "interviewid")
    @JsonProperty("interviewid")
    private Integer interviewid;

    /**
     * 属性 [PCMMSPJXXID]
     *
     */
    @JSONField(name = "pcmmspjxxid")
    @JsonProperty("pcmmspjxxid")
    private String pcmmspjxxid;

    /**
     * 属性 [INTERVIEWRESULTID]
     *
     */
    @JSONField(name = "interviewresultid")
    @JsonProperty("interviewresultid")
    private Integer interviewresultid;

    /**
     * 属性 [EVALUATETIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "evaluatetime" , format="yyyy-MM-dd")
    @JsonProperty("evaluatetime")
    private Timestamp evaluatetime;

    /**
     * 属性 [SCORE]
     *
     */
    @JSONField(name = "score")
    @JsonProperty("score")
    private Double score;

    /**
     * 属性 [CONCLUSION]
     *
     */
    @JSONField(name = "conclusion")
    @JsonProperty("conclusion")
    private String conclusion;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [OFFICEREMAIL]
     *
     */
    @JSONField(name = "officeremail")
    @JsonProperty("officeremail")
    private String officeremail;

    /**
     * 属性 [LOCATION]
     *
     */
    @JSONField(name = "location")
    @JsonProperty("location")
    private String location;


    /**
     * 设置 [OFFICER]
     */
    public void setOfficer(String  officer){
        this.officer = officer ;
        this.modify("officer",officer);
    }

    /**
     * 设置 [INTERVIEWTIME]
     */
    public void setInterviewtime(Timestamp  interviewtime){
        this.interviewtime = interviewtime ;
        this.modify("interviewtime",interviewtime);
    }

    /**
     * 设置 [PCMMSPJXXNAME]
     */
    public void setPcmmspjxxname(String  pcmmspjxxname){
        this.pcmmspjxxname = pcmmspjxxname ;
        this.modify("pcmmspjxxname",pcmmspjxxname);
    }

    /**
     * 设置 [EVALUATE]
     */
    public void setEvaluate(String  evaluate){
        this.evaluate = evaluate ;
        this.modify("evaluate",evaluate);
    }

    /**
     * 设置 [INTERVIEWID]
     */
    public void setInterviewid(Integer  interviewid){
        this.interviewid = interviewid ;
        this.modify("interviewid",interviewid);
    }

    /**
     * 设置 [INTERVIEWRESULTID]
     */
    public void setInterviewresultid(Integer  interviewresultid){
        this.interviewresultid = interviewresultid ;
        this.modify("interviewresultid",interviewresultid);
    }

    /**
     * 设置 [EVALUATETIME]
     */
    public void setEvaluatetime(Timestamp  evaluatetime){
        this.evaluatetime = evaluatetime ;
        this.modify("evaluatetime",evaluatetime);
    }

    /**
     * 设置 [SCORE]
     */
    public void setScore(Double  score){
        this.score = score ;
        this.modify("score",score);
    }

    /**
     * 设置 [CONCLUSION]
     */
    public void setConclusion(String  conclusion){
        this.conclusion = conclusion ;
        this.modify("conclusion",conclusion);
    }

    /**
     * 设置 [OFFICEREMAIL]
     */
    public void setOfficeremail(String  officeremail){
        this.officeremail = officeremail ;
        this.modify("officeremail",officeremail);
    }

    /**
     * 设置 [LOCATION]
     */
    public void setLocation(String  location){
        this.location = location ;
        this.modify("location",location);
    }


}

