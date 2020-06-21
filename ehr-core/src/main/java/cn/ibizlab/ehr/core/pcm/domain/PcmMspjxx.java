package cn.ibizlab.ehr.core.pcm.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[面试评价信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMMSPJXX",resultMap = "PcmMspjxxResultMap")
public class PcmMspjxx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 面试官名称
     */
    @TableField(value = "officer")
    @JSONField(name = "officer")
    @JsonProperty("officer")
    private String officer;
    /**
     * 面试时间
     */
    @TableField(value = "interviewtime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "interviewtime" , format="yyyy-MM-dd")
    @JsonProperty("interviewtime")
    private Timestamp interviewtime;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 面试评价信息名称
     */
    @TableField(value = "pcmmspjxxname")
    @JSONField(name = "pcmmspjxxname")
    @JsonProperty("pcmmspjxxname")
    private String pcmmspjxxname;
    /**
     * 面试评价
     */
    @TableField(value = "evaluate")
    @JSONField(name = "evaluate")
    @JsonProperty("evaluate")
    private String evaluate;
    /**
     * 面试Id
     */
    @TableField(value = "interviewid")
    @JSONField(name = "interviewid")
    @JsonProperty("interviewid")
    private Integer interviewid;
    /**
     * 面试评价信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmmspjxxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmmspjxxid")
    @JsonProperty("pcmmspjxxid")
    private String pcmmspjxxid;
    /**
     * 面试结果ID
     */
    @TableField(value = "interviewresultid")
    @JSONField(name = "interviewresultid")
    @JsonProperty("interviewresultid")
    private Integer interviewresultid;
    /**
     * 面试评价时间
     */
    @TableField(value = "evaluatetime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "evaluatetime" , format="yyyy-MM-dd")
    @JsonProperty("evaluatetime")
    private Timestamp evaluatetime;
    /**
     * 面试分数
     */
    @TableField(value = "score")
    @JSONField(name = "score")
    @JsonProperty("score")
    private Double score;
    /**
     * 面试结果
     */
    @TableField(value = "conclusion")
    @JSONField(name = "conclusion")
    @JsonProperty("conclusion")
    private String conclusion;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 面试官邮箱
     */
    @TableField(value = "officeremail")
    @JSONField(name = "officeremail")
    @JsonProperty("officeremail")
    private String officeremail;
    /**
     * 面试地点
     */
    @TableField(value = "location")
    @JSONField(name = "location")
    @JsonProperty("location")
    private String location;



    /**
     * 设置 [面试官名称]
     */
    public void setOfficer(String officer){
        this.officer = officer ;
        this.modify("officer",officer);
    }

    /**
     * 设置 [面试时间]
     */
    public void setInterviewtime(Timestamp interviewtime){
        this.interviewtime = interviewtime ;
        this.modify("interviewtime",interviewtime);
    }

    /**
     * 格式化日期 [面试时间]
     */
    public String formatInterviewtime(){
        if (this.interviewtime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(interviewtime);
    }
    /**
     * 设置 [面试评价信息名称]
     */
    public void setPcmmspjxxname(String pcmmspjxxname){
        this.pcmmspjxxname = pcmmspjxxname ;
        this.modify("pcmmspjxxname",pcmmspjxxname);
    }

    /**
     * 设置 [面试评价]
     */
    public void setEvaluate(String evaluate){
        this.evaluate = evaluate ;
        this.modify("evaluate",evaluate);
    }

    /**
     * 设置 [面试Id]
     */
    public void setInterviewid(Integer interviewid){
        this.interviewid = interviewid ;
        this.modify("interviewid",interviewid);
    }

    /**
     * 设置 [面试结果ID]
     */
    public void setInterviewresultid(Integer interviewresultid){
        this.interviewresultid = interviewresultid ;
        this.modify("interviewresultid",interviewresultid);
    }

    /**
     * 设置 [面试评价时间]
     */
    public void setEvaluatetime(Timestamp evaluatetime){
        this.evaluatetime = evaluatetime ;
        this.modify("evaluatetime",evaluatetime);
    }

    /**
     * 格式化日期 [面试评价时间]
     */
    public String formatEvaluatetime(){
        if (this.evaluatetime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(evaluatetime);
    }
    /**
     * 设置 [面试分数]
     */
    public void setScore(Double score){
        this.score = score ;
        this.modify("score",score);
    }

    /**
     * 设置 [面试结果]
     */
    public void setConclusion(String conclusion){
        this.conclusion = conclusion ;
        this.modify("conclusion",conclusion);
    }

    /**
     * 设置 [面试官邮箱]
     */
    public void setOfficeremail(String officeremail){
        this.officeremail = officeremail ;
        this.modify("officeremail",officeremail);
    }

    /**
     * 设置 [面试地点]
     */
    public void setLocation(String location){
        this.location = location ;
        this.modify("location",location);
    }


}


