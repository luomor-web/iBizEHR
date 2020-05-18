package cn.ibizlab.ehr.core.wf.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
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
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;


/**
 * 实体[工作流用户候选者]
 */
@Data
@TableName(value = "T_SRFWFUSERCANDIDATE",resultMap = "WFUserCandidateResultMap")
public class WFUserCandidate extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工作流用户候选者名称
     */
    @TableField(value = "wfusercandidatename")
    @JSONField(name = "wfusercandidatename")
    @JsonProperty("wfusercandidatename")
    private String wfusercandidatename;
    /**
     * 候选次序
     */
    @TableField(value = "candidateorder")
    @JSONField(name = "candidateorder")
    @JsonProperty("candidateorder")
    private Integer candidateorder;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 工作流用户候选者标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfusercandidateid",type=IdType.UUID)
    @JSONField(name = "wfusercandidateid")
    @JsonProperty("wfusercandidateid")
    private String wfusercandidateid;
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
     * 用户数据2
     */
    @TableField(value = "userdata2")
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
    /**
     * 用户数据
     */
    @TableField(value = "userdata")
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 工作流主用户
     */
    @TableField(exist = false)
    @JSONField(name = "wfmajorusername")
    @JsonProperty("wfmajorusername")
    private String wfmajorusername;
    /**
     * 工作流候选用户
     */
    @TableField(exist = false)
    @JSONField(name = "wfminorusername")
    @JsonProperty("wfminorusername")
    private String wfminorusername;
    /**
     * 工作流候选用户
     */
    @TableField(value = "wfminoruserid")
    @JSONField(name = "wfminoruserid")
    @JsonProperty("wfminoruserid")
    private String wfminoruserid;
    /**
     * 工作流主用户
     */
    @TableField(value = "wfmajoruserid")
    @JSONField(name = "wfmajoruserid")
    @JsonProperty("wfmajoruserid")
    private String wfmajoruserid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFUser wfmajoruser;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFUser wfminoruser;



    /**
     * 设置 [工作流用户候选者名称]
     */
    public void setWfusercandidatename(String wfusercandidatename){
        this.wfusercandidatename = wfusercandidatename ;
        this.modify("wfusercandidatename",wfusercandidatename);
    }
    /**
     * 设置 [候选次序]
     */
    public void setCandidateorder(Integer candidateorder){
        this.candidateorder = candidateorder ;
        this.modify("candidateorder",candidateorder);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [用户数据2]
     */
    public void setUserdata2(String userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }
    /**
     * 设置 [用户数据]
     */
    public void setUserdata(String userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }
    /**
     * 设置 [工作流候选用户]
     */
    public void setWfminoruserid(String wfminoruserid){
        this.wfminoruserid = wfminoruserid ;
        this.modify("wfminoruserid",wfminoruserid);
    }
    /**
     * 设置 [工作流主用户]
     */
    public void setWfmajoruserid(String wfmajoruserid){
        this.wfmajoruserid = wfmajoruserid ;
        this.modify("wfmajoruserid",wfmajoruserid);
    }

}


