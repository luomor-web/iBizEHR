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
 * 服务DTO对象[PcmAwardsWonsDTO]
 */
@Data
public class PcmAwardsWonsDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [AWARDLEVEL]
     *
     */
    @JSONField(name = "awardlevel")
    @JsonProperty("awardlevel")
    private String awardlevel;

    /**
     * 属性 [FLAG]
     *
     */
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [AWARDNAME]
     *
     */
    @JSONField(name = "awardname")
    @JsonProperty("awardname")
    private String awardname;

    /**
     * 属性 [AWARDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "awardtime" , format="yyyy-MM-dd")
    @JsonProperty("awardtime")
    private Timestamp awardtime;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [AWARDDESCRIPTION]
     *
     */
    @JSONField(name = "awarddescription")
    @JsonProperty("awarddescription")
    private String awarddescription;

    /**
     * 属性 [PCMAWARDSWONSNAME]
     *
     */
    @JSONField(name = "pcmawardswonsname")
    @JsonProperty("pcmawardswonsname")
    private String pcmawardswonsname;

    /**
     * 属性 [PCMAWARDSWONSID]
     *
     */
    @JSONField(name = "pcmawardswonsid")
    @JsonProperty("pcmawardswonsid")
    private String pcmawardswonsid;

    /**
     * 属性 [BBSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [JUDGEORG]
     *
     */
    @JSONField(name = "judgeorg")
    @JsonProperty("judgeorg")
    private String judgeorg;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CERTIFICATENUMBER]
     *
     */
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;

    /**
     * 属性 [PCMPROFILENAME]
     *
     */
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;

    /**
     * 属性 [PCMPROFILEID]
     *
     */
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;


    /**
     * 设置 [AWARDLEVEL]
     */
    public void setAwardlevel(String  awardlevel){
        this.awardlevel = awardlevel ;
        this.modify("awardlevel",awardlevel);
    }

    /**
     * 设置 [FLAG]
     */
    public void setFlag(String  flag){
        this.flag = flag ;
        this.modify("flag",flag);
    }

    /**
     * 设置 [AWARDNAME]
     */
    public void setAwardname(String  awardname){
        this.awardname = awardname ;
        this.modify("awardname",awardname);
    }

    /**
     * 设置 [AWARDTIME]
     */
    public void setAwardtime(Timestamp  awardtime){
        this.awardtime = awardtime ;
        this.modify("awardtime",awardtime);
    }

    /**
     * 设置 [AWARDDESCRIPTION]
     */
    public void setAwarddescription(String  awarddescription){
        this.awarddescription = awarddescription ;
        this.modify("awarddescription",awarddescription);
    }

    /**
     * 设置 [PCMAWARDSWONSNAME]
     */
    public void setPcmawardswonsname(String  pcmawardswonsname){
        this.pcmawardswonsname = pcmawardswonsname ;
        this.modify("pcmawardswonsname",pcmawardswonsname);
    }

    /**
     * 设置 [BBSJ]
     */
    public void setBbsj(Timestamp  bbsj){
        this.bbsj = bbsj ;
        this.modify("bbsj",bbsj);
    }

    /**
     * 设置 [JUDGEORG]
     */
    public void setJudgeorg(String  judgeorg){
        this.judgeorg = judgeorg ;
        this.modify("judgeorg",judgeorg);
    }

    /**
     * 设置 [PCMPROFILEID]
     */
    public void setPcmprofileid(String  pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}

