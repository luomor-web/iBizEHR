package cn.ibizlab.ehr.core.trm.domain;

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
 * 实体[讲师授课记录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTEACHERTRAIN",resultMap = "TrmTeacherTrainResultMap")
public class TrmTeacherTrain extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评价
     */
    @TableField(value = "pj")
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 讲师授课记录标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmteachertrainid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmteachertrainid")
    @JsonProperty("trmteachertrainid")
    private String trmteachertrainid;
    /**
     * 积分
     */
    @TableField(value = "jf")
    @JSONField(name = "jf")
    @JsonProperty("jf")
    private Double jf;
    /**
     * 讲师授课记录
     */
    @TableField(value = "trmteachertrainname")
    @JSONField(name = "trmteachertrainname")
    @JsonProperty("trmteachertrainname")
    private String trmteachertrainname;
    /**
     * 授课课程
     */
    @TableField(exist = false)
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;
    /**
     * 授课地点
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainaddressname")
    @JsonProperty("trmtrainaddressname")
    private String trmtrainaddressname;
    /**
     * 授课讲师
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainteachername")
    @JsonProperty("trmtrainteachername")
    private String trmtrainteachername;
    /**
     * 授课班级
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;
    /**
     * 授课结束时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjssj" , format="yyyy-MM-dd")
    @JsonProperty("pxjssj")
    private Timestamp pxjssj;
    /**
     * 授课时长
     */
    @TableField(exist = false)
    @JSONField(name = "pxsc")
    @JsonProperty("pxsc")
    private Double pxsc;
    /**
     * 授课开始时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxkssj" , format="yyyy-MM-dd")
    @JsonProperty("pxkssj")
    private Timestamp pxkssj;
    /**
     * 培训计划项标识
     */
    @TableField(value = "trmtrainplantermid")
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;
    /**
     * 培训课程标识
     */
    @TableField(value = "trmtraincourseid")
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;
    /**
     * 培训教师标识
     */
    @TableField(value = "trmtrainteacherid")
    @JSONField(name = "trmtrainteacherid")
    @JsonProperty("trmtrainteacherid")
    private String trmtrainteacherid;
    /**
     * 培训地点标识
     */
    @TableField(value = "trmtrainaddressid")
    @JSONField(name = "trmtrainaddressid")
    @JsonProperty("trmtrainaddressid")
    private String trmtrainaddressid;

    /**
     * 培训地点
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress trmtrainaddress;

    /**
     * 培训课程
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse trmtraincourse;

    /**
     * 培训班级
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm trmtrainplanterm;

    /**
     * 培训讲师
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainTeacher trmtrainteacher;



    /**
     * 设置 [评价]
     */
    public void setPj(String pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [积分]
     */
    public void setJf(Double jf){
        this.jf = jf ;
        this.modify("jf",jf);
    }

    /**
     * 设置 [讲师授课记录]
     */
    public void setTrmteachertrainname(String trmteachertrainname){
        this.trmteachertrainname = trmteachertrainname ;
        this.modify("trmteachertrainname",trmteachertrainname);
    }

    /**
     * 设置 [培训计划项标识]
     */
    public void setTrmtrainplantermid(String trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }

    /**
     * 设置 [培训课程标识]
     */
    public void setTrmtraincourseid(String trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }

    /**
     * 设置 [培训教师标识]
     */
    public void setTrmtrainteacherid(String trmtrainteacherid){
        this.trmtrainteacherid = trmtrainteacherid ;
        this.modify("trmtrainteacherid",trmtrainteacherid);
    }

    /**
     * 设置 [培训地点标识]
     */
    public void setTrmtrainaddressid(String trmtrainaddressid){
        this.trmtrainaddressid = trmtrainaddressid ;
        this.modify("trmtrainaddressid",trmtrainaddressid);
    }


}


