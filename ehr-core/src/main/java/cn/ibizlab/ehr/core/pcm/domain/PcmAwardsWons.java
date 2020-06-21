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
 * 实体[获奖情况]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMAWARDSWONS",resultMap = "PcmAwardsWonsResultMap")
public class PcmAwardsWons extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 获奖等级
     */
    @TableField(value = "awardlevel")
    @JSONField(name = "awardlevel")
    @JsonProperty("awardlevel")
    private String awardlevel;
    /**
     * 是否有效
     */
    @DEField(defaultValue = "1")
    @TableField(value = "flag")
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;
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
     * 获奖名称
     */
    @TableField(value = "awardname")
    @JSONField(name = "awardname")
    @JsonProperty("awardname")
    private String awardname;
    /**
     * 获奖时间
     */
    @TableField(value = "awardtime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "awardtime" , format="yyyy-MM-dd")
    @JsonProperty("awardtime")
    private Timestamp awardtime;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 获奖情况
     */
    @TableField(value = "awarddescription")
    @JSONField(name = "awarddescription")
    @JsonProperty("awarddescription")
    private String awarddescription;
    /**
     * 获奖情况名称
     */
    @TableField(value = "pcmawardswonsname")
    @JSONField(name = "pcmawardswonsname")
    @JsonProperty("pcmawardswonsname")
    private String pcmawardswonsname;
    /**
     * 获奖情况标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmawardswonsid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmawardswonsid")
    @JsonProperty("pcmawardswonsid")
    private String pcmawardswonsid;
    /**
     * 版本时间
     */
    @TableField(value = "bbsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 评定机构
     */
    @TableField(value = "judgeorg")
    @JSONField(name = "judgeorg")
    @JsonProperty("judgeorg")
    private String judgeorg;
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
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;
    /**
     * 姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;
    /**
     * 应聘者ID
     */
    @TableField(value = "pcmprofileid")
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;

    /**
     * 应聘者信息-获奖情况
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile;



    /**
     * 设置 [获奖等级]
     */
    public void setAwardlevel(String awardlevel){
        this.awardlevel = awardlevel ;
        this.modify("awardlevel",awardlevel);
    }

    /**
     * 设置 [是否有效]
     */
    public void setFlag(String flag){
        this.flag = flag ;
        this.modify("flag",flag);
    }

    /**
     * 设置 [获奖名称]
     */
    public void setAwardname(String awardname){
        this.awardname = awardname ;
        this.modify("awardname",awardname);
    }

    /**
     * 设置 [获奖时间]
     */
    public void setAwardtime(Timestamp awardtime){
        this.awardtime = awardtime ;
        this.modify("awardtime",awardtime);
    }

    /**
     * 格式化日期 [获奖时间]
     */
    public String formatAwardtime(){
        if (this.awardtime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(awardtime);
    }
    /**
     * 设置 [获奖情况]
     */
    public void setAwarddescription(String awarddescription){
        this.awarddescription = awarddescription ;
        this.modify("awarddescription",awarddescription);
    }

    /**
     * 设置 [获奖情况名称]
     */
    public void setPcmawardswonsname(String pcmawardswonsname){
        this.pcmawardswonsname = pcmawardswonsname ;
        this.modify("pcmawardswonsname",pcmawardswonsname);
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
     * 设置 [评定机构]
     */
    public void setJudgeorg(String judgeorg){
        this.judgeorg = judgeorg ;
        this.modify("judgeorg",judgeorg);
    }

    /**
     * 设置 [应聘者ID]
     */
    public void setPcmprofileid(String pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}


