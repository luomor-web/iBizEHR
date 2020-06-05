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
 * 服务DTO对象[PcmTestResultDTO]
 */
@Data
public class PcmTestResultDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [TESTRESULTNAME]
     *
     */
    @JSONField(name = "testresultname")
    @JsonProperty("testresultname")
    private String testresultname;

    /**
     * 属性 [MATCHDEGREE]
     *
     */
    @JSONField(name = "matchdegree")
    @JsonProperty("matchdegree")
    private Double matchdegree;

    /**
     * 属性 [PSYCHOLOGYSTATUS]
     *
     */
    @JSONField(name = "psychologystatus")
    @JsonProperty("psychologystatus")
    private String psychologystatus;

    /**
     * 属性 [ABILITYSCORE]
     *
     */
    @JSONField(name = "abilityscore")
    @JsonProperty("abilityscore")
    private Double abilityscore;

    /**
     * 属性 [BBSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;

    /**
     * 属性 [ABILITYSCOREREPORTS]
     *
     */
    @JSONField(name = "abilityscorereports")
    @JsonProperty("abilityscorereports")
    private String abilityscorereports;

    /**
     * 属性 [ABILITYGRADE]
     *
     */
    @JSONField(name = "abilitygrade")
    @JsonProperty("abilitygrade")
    private String abilitygrade;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PSYCHOLOGYHEALTHYLEVEL]
     *
     */
    @JSONField(name = "psychologyhealthylevel")
    @JsonProperty("psychologyhealthylevel")
    private String psychologyhealthylevel;

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
     * 属性 [JOBFITDEGREE]
     *
     */
    @JSONField(name = "jobfitdegree")
    @JsonProperty("jobfitdegree")
    private String jobfitdegree;

    /**
     * 属性 [FLAG]
     *
     */
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;

    /**
     * 属性 [FIRSTTEST]
     *
     */
    @JSONField(name = "firsttest")
    @JsonProperty("firsttest")
    private String firsttest;

    /**
     * 属性 [EXAMSCORE]
     *
     */
    @JSONField(name = "examscore")
    @JsonProperty("examscore")
    private Double examscore;

    /**
     * 属性 [EXAMSCOREREPORTS]
     *
     */
    @JSONField(name = "examscorereports")
    @JsonProperty("examscorereports")
    private String examscorereports;

    /**
     * 属性 [SECONDTEST]
     *
     */
    @JSONField(name = "secondtest")
    @JsonProperty("secondtest")
    private String secondtest;

    /**
     * 属性 [PSYCHOLOGYHEALTHYLEVELREPORTS]
     *
     */
    @JSONField(name = "psychologyhealthylevelreports")
    @JsonProperty("psychologyhealthylevelreports")
    private String psychologyhealthylevelreports;

    /**
     * 属性 [TESTRESULTID]
     *
     */
    @JSONField(name = "testresultid")
    @JsonProperty("testresultid")
    private String testresultid;

    /**
     * 属性 [MATCHDEGREEREPORTS]
     *
     */
    @JSONField(name = "matchdegreereports")
    @JsonProperty("matchdegreereports")
    private String matchdegreereports;

    /**
     * 属性 [PCMPROFILENAME]
     *
     */
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;

    /**
     * 属性 [CERTIFICATENUMBER]
     *
     */
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;

    /**
     * 属性 [PCMPROFILEID]
     *
     */
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;


    /**
     * 设置 [TESTRESULTNAME]
     */
    public void setTestresultname(String  testresultname){
        this.testresultname = testresultname ;
        this.modify("testresultname",testresultname);
    }

    /**
     * 设置 [MATCHDEGREE]
     */
    public void setMatchdegree(Double  matchdegree){
        this.matchdegree = matchdegree ;
        this.modify("matchdegree",matchdegree);
    }

    /**
     * 设置 [PSYCHOLOGYSTATUS]
     */
    public void setPsychologystatus(String  psychologystatus){
        this.psychologystatus = psychologystatus ;
        this.modify("psychologystatus",psychologystatus);
    }

    /**
     * 设置 [ABILITYSCORE]
     */
    public void setAbilityscore(Double  abilityscore){
        this.abilityscore = abilityscore ;
        this.modify("abilityscore",abilityscore);
    }

    /**
     * 设置 [BBSJ]
     */
    public void setBbsj(Timestamp  bbsj){
        this.bbsj = bbsj ;
        this.modify("bbsj",bbsj);
    }

    /**
     * 设置 [ABILITYSCOREREPORTS]
     */
    public void setAbilityscorereports(String  abilityscorereports){
        this.abilityscorereports = abilityscorereports ;
        this.modify("abilityscorereports",abilityscorereports);
    }

    /**
     * 设置 [ABILITYGRADE]
     */
    public void setAbilitygrade(String  abilitygrade){
        this.abilitygrade = abilitygrade ;
        this.modify("abilitygrade",abilitygrade);
    }

    /**
     * 设置 [PSYCHOLOGYHEALTHYLEVEL]
     */
    public void setPsychologyhealthylevel(String  psychologyhealthylevel){
        this.psychologyhealthylevel = psychologyhealthylevel ;
        this.modify("psychologyhealthylevel",psychologyhealthylevel);
    }

    /**
     * 设置 [JOBFITDEGREE]
     */
    public void setJobfitdegree(String  jobfitdegree){
        this.jobfitdegree = jobfitdegree ;
        this.modify("jobfitdegree",jobfitdegree);
    }

    /**
     * 设置 [FLAG]
     */
    public void setFlag(String  flag){
        this.flag = flag ;
        this.modify("flag",flag);
    }

    /**
     * 设置 [FIRSTTEST]
     */
    public void setFirsttest(String  firsttest){
        this.firsttest = firsttest ;
        this.modify("firsttest",firsttest);
    }

    /**
     * 设置 [EXAMSCORE]
     */
    public void setExamscore(Double  examscore){
        this.examscore = examscore ;
        this.modify("examscore",examscore);
    }

    /**
     * 设置 [EXAMSCOREREPORTS]
     */
    public void setExamscorereports(String  examscorereports){
        this.examscorereports = examscorereports ;
        this.modify("examscorereports",examscorereports);
    }

    /**
     * 设置 [SECONDTEST]
     */
    public void setSecondtest(String  secondtest){
        this.secondtest = secondtest ;
        this.modify("secondtest",secondtest);
    }

    /**
     * 设置 [PSYCHOLOGYHEALTHYLEVELREPORTS]
     */
    public void setPsychologyhealthylevelreports(String  psychologyhealthylevelreports){
        this.psychologyhealthylevelreports = psychologyhealthylevelreports ;
        this.modify("psychologyhealthylevelreports",psychologyhealthylevelreports);
    }

    /**
     * 设置 [MATCHDEGREEREPORTS]
     */
    public void setMatchdegreereports(String  matchdegreereports){
        this.matchdegreereports = matchdegreereports ;
        this.modify("matchdegreereports",matchdegreereports);
    }

    /**
     * 设置 [PCMPROFILEID]
     */
    public void setPcmprofileid(String  pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}

