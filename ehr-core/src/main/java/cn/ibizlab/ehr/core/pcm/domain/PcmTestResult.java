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
 * 实体[测评结果摘要信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TESTRESULT",resultMap = "PcmTestResultResultMap")
public class PcmTestResult extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 测评结果信息名称
     */
    @TableField(value = "testresultname")
    @JSONField(name = "testresultname")
    @JsonProperty("testresultname")
    private String testresultname;
    /**
     * 胜任力（岗位匹配等级）
     */
    @TableField(value = "matchdegree")
    @JSONField(name = "matchdegree")
    @JsonProperty("matchdegree")
    private Double matchdegree;
    /**
     * 心理健康
     */
    @TableField(value = "psychologystatus")
    @JSONField(name = "psychologystatus")
    @JsonProperty("psychologystatus")
    private String psychologystatus;
    /**
     * 能力（能力倾向得分）
     */
    @TableField(value = "abilityscore")
    @JSONField(name = "abilityscore")
    @JsonProperty("abilityscore")
    private Double abilityscore;
    /**
     * 版本时间
     */
    @TableField(value = "bbsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;
    /**
     * 能力得分报告
     */
    @TableField(value = "abilityscorereports")
    @JSONField(name = "abilityscorereports")
    @JsonProperty("abilityscorereports")
    private String abilityscorereports;
    /**
     * 能力
     */
    @TableField(value = "abilitygrade")
    @JSONField(name = "abilitygrade")
    @JsonProperty("abilitygrade")
    private String abilitygrade;
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
     * 心理健康等级
     */
    @TableField(value = "psychologyhealthylevel")
    @JSONField(name = "psychologyhealthylevel")
    @JsonProperty("psychologyhealthylevel")
    private String psychologyhealthylevel;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 胜任力
     */
    @TableField(value = "jobfitdegree")
    @JSONField(name = "jobfitdegree")
    @JsonProperty("jobfitdegree")
    private String jobfitdegree;
    /**
     * 是否有效
     */
    @DEField(defaultValue = "1")
    @TableField(value = "flag")
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;
    /**
     * 第一次测试
     */
    @TableField(value = "firsttest")
    @JSONField(name = "firsttest")
    @JsonProperty("firsttest")
    private String firsttest;
    /**
     * 考试得分
     */
    @TableField(value = "examscore")
    @JSONField(name = "examscore")
    @JsonProperty("examscore")
    private Double examscore;
    /**
     * 考试报告
     */
    @TableField(value = "examscorereports")
    @JSONField(name = "examscorereports")
    @JsonProperty("examscorereports")
    private String examscorereports;
    /**
     * 第二次测试
     */
    @TableField(value = "secondtest")
    @JSONField(name = "secondtest")
    @JsonProperty("secondtest")
    private String secondtest;
    /**
     * 心理健康报告
     */
    @TableField(value = "psychologyhealthylevelreports")
    @JSONField(name = "psychologyhealthylevelreports")
    @JsonProperty("psychologyhealthylevelreports")
    private String psychologyhealthylevelreports;
    /**
     * 测评结果信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "testresultid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "testresultid")
    @JsonProperty("testresultid")
    private String testresultid;
    /**
     * 胜任力测试报告
     */
    @TableField(value = "matchdegreereports")
    @JSONField(name = "matchdegreereports")
    @JsonProperty("matchdegreereports")
    private String matchdegreereports;
    /**
     * 姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;
    /**
     * 应聘者ID
     */
    @TableField(value = "pcmprofileid")
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;

    /**
     * 应聘者信息-测评结果摘要信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile;



    /**
     * 设置 [测评结果信息名称]
     */
    public void setTestresultname(String testresultname){
        this.testresultname = testresultname ;
        this.modify("testresultname",testresultname);
    }

    /**
     * 设置 [胜任力（岗位匹配等级）]
     */
    public void setMatchdegree(Double matchdegree){
        this.matchdegree = matchdegree ;
        this.modify("matchdegree",matchdegree);
    }

    /**
     * 设置 [心理健康]
     */
    public void setPsychologystatus(String psychologystatus){
        this.psychologystatus = psychologystatus ;
        this.modify("psychologystatus",psychologystatus);
    }

    /**
     * 设置 [能力（能力倾向得分）]
     */
    public void setAbilityscore(Double abilityscore){
        this.abilityscore = abilityscore ;
        this.modify("abilityscore",abilityscore);
    }

    /**
     * 设置 [版本时间]
     */
    public void setBbsj(Timestamp bbsj){
        this.bbsj = bbsj ;
        this.modify("bbsj",bbsj);
    }

    /**
     * 格式化日期 [版本时间]
     */
    public String formatBbsj(){
        if (this.bbsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(bbsj);
    }
    /**
     * 设置 [能力得分报告]
     */
    public void setAbilityscorereports(String abilityscorereports){
        this.abilityscorereports = abilityscorereports ;
        this.modify("abilityscorereports",abilityscorereports);
    }

    /**
     * 设置 [能力]
     */
    public void setAbilitygrade(String abilitygrade){
        this.abilitygrade = abilitygrade ;
        this.modify("abilitygrade",abilitygrade);
    }

    /**
     * 设置 [心理健康等级]
     */
    public void setPsychologyhealthylevel(String psychologyhealthylevel){
        this.psychologyhealthylevel = psychologyhealthylevel ;
        this.modify("psychologyhealthylevel",psychologyhealthylevel);
    }

    /**
     * 设置 [胜任力]
     */
    public void setJobfitdegree(String jobfitdegree){
        this.jobfitdegree = jobfitdegree ;
        this.modify("jobfitdegree",jobfitdegree);
    }

    /**
     * 设置 [是否有效]
     */
    public void setFlag(String flag){
        this.flag = flag ;
        this.modify("flag",flag);
    }

    /**
     * 设置 [第一次测试]
     */
    public void setFirsttest(String firsttest){
        this.firsttest = firsttest ;
        this.modify("firsttest",firsttest);
    }

    /**
     * 设置 [考试得分]
     */
    public void setExamscore(Double examscore){
        this.examscore = examscore ;
        this.modify("examscore",examscore);
    }

    /**
     * 设置 [考试报告]
     */
    public void setExamscorereports(String examscorereports){
        this.examscorereports = examscorereports ;
        this.modify("examscorereports",examscorereports);
    }

    /**
     * 设置 [第二次测试]
     */
    public void setSecondtest(String secondtest){
        this.secondtest = secondtest ;
        this.modify("secondtest",secondtest);
    }

    /**
     * 设置 [心理健康报告]
     */
    public void setPsychologyhealthylevelreports(String psychologyhealthylevelreports){
        this.psychologyhealthylevelreports = psychologyhealthylevelreports ;
        this.modify("psychologyhealthylevelreports",psychologyhealthylevelreports);
    }

    /**
     * 设置 [胜任力测试报告]
     */
    public void setMatchdegreereports(String matchdegreereports){
        this.matchdegreereports = matchdegreereports ;
        this.modify("matchdegreereports",matchdegreereports);
    }

    /**
     * 设置 [应聘者ID]
     */
    public void setPcmprofileid(String pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}


