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
 * 实体[培训记录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMCOUARRANGE",resultMap = "TrmCouarrangeResultMap")
public class TrmCouarrange extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评价
     */
    @TableField(value = "pj")
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;
    /**
     * 课程安排标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmcouarrangeid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmcouarrangeid")
    @JsonProperty("trmcouarrangeid")
    private String trmcouarrangeid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 参考资料
     */
    @TableField(value = "ckzl")
    @JSONField(name = "ckzl")
    @JsonProperty("ckzl")
    private String ckzl;
    /**
     * 授课开始日期
     */
    @TableField(value = "skksrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "skksrq" , format="yyyy-MM-dd")
    @JsonProperty("skksrq")
    private Timestamp skksrq;
    /**
     * 课程学时
     */
    @TableField(value = "kcxs")
    @JSONField(name = "kcxs")
    @JsonProperty("kcxs")
    private Double kcxs;
    /**
     * 授课结束时间
     */
    @TableField(value = "skjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "skjssj" , format="yyyy-MM-dd")
    @JsonProperty("skjssj")
    private Timestamp skjssj;
    /**
     * 课程安排名称
     */
    @TableField(value = "trmcouarrangename")
    @JSONField(name = "trmcouarrangename")
    @JsonProperty("trmcouarrangename")
    private String trmcouarrangename;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 授课开始时间
     */
    @TableField(value = "skkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "skkssj" , format="yyyy-MM-dd")
    @JsonProperty("skkssj")
    private Timestamp skkssj;
    /**
     * 预备知识
     */
    @TableField(value = "ybzs")
    @JSONField(name = "ybzs")
    @JsonProperty("ybzs")
    private String ybzs;
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
     * 课程内容
     */
    @TableField(value = "kcnr")
    @JSONField(name = "kcnr")
    @JsonProperty("kcnr")
    private String kcnr;
    /**
     * 培训机构
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 班级
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;
    /**
     * 培训活动申请名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainactapplyname")
    @JsonProperty("trmtrainactapplyname")
    private String trmtrainactapplyname;
    /**
     * 培训场地
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainaddressname")
    @JsonProperty("trmtrainaddressname")
    private String trmtrainaddressname;
    /**
     * 参培人员
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrianpersonname")
    @JsonProperty("trmtrianpersonname")
    private String trmtrianpersonname;
    /**
     * 课程
     */
    @TableField(exist = false)
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;
    /**
     * 名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmcoursesystemname")
    @JsonProperty("trmcoursesystemname")
    private String trmcoursesystemname;
    /**
     * 会议室
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainfaciesname")
    @JsonProperty("trmtrainfaciesname")
    private String trmtrainfaciesname;
    /**
     * 讲师
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainteachername")
    @JsonProperty("trmtrainteachername")
    private String trmtrainteachername;
    /**
     * 培训记录
     */
    @TableField(exist = false)
    @JSONField(name = "trmagencyrecordname")
    @JsonProperty("trmagencyrecordname")
    private String trmagencyrecordname;
    /**
     * 培训人员标识
     */
    @TableField(value = "trmtrianpersonid")
    @JSONField(name = "trmtrianpersonid")
    @JsonProperty("trmtrianpersonid")
    private String trmtrianpersonid;
    /**
     * 培训教师标识
     */
    @TableField(value = "trmtrainteacherid")
    @JSONField(name = "trmtrainteacherid")
    @JsonProperty("trmtrainteacherid")
    private String trmtrainteacherid;
    /**
     * 培训设施标识
     */
    @TableField(value = "trmtrainfaciesid")
    @JSONField(name = "trmtrainfaciesid")
    @JsonProperty("trmtrainfaciesid")
    private String trmtrainfaciesid;
    /**
     * 培训机构标识
     */
    @TableField(value = "trmtrainagencyid")
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;
    /**
     * 培训计划项标识
     */
    @TableField(value = "trmtrainplantermid")
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;
    /**
     * 培训活动申请标识
     */
    @TableField(value = "trmtrainactapplyid")
    @JSONField(name = "trmtrainactapplyid")
    @JsonProperty("trmtrainactapplyid")
    private String trmtrainactapplyid;
    /**
     * 培训地点标识
     */
    @TableField(value = "trmtrainaddressid")
    @JSONField(name = "trmtrainaddressid")
    @JsonProperty("trmtrainaddressid")
    private String trmtrainaddressid;
    /**
     * 机构培训记录标识
     */
    @TableField(value = "trmagencyrecordid")
    @JSONField(name = "trmagencyrecordid")
    @JsonProperty("trmagencyrecordid")
    private String trmagencyrecordid;
    /**
     * 培训课程标识
     */
    @TableField(value = "trmtraincourseid")
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;
    /**
     * 课程体系标识
     */
    @TableField(value = "trmcoursesystemid")
    @JSONField(name = "trmcoursesystemid")
    @JsonProperty("trmcoursesystemid")
    private String trmcoursesystemid;

    /**
     * 机构培训记录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmAgencyRecord trmagencyrecord;

    /**
     * 培训记录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmCourseSystem trmcoursesystem;

    /**
     * 培训活动
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainActapply trmtrainactapply;

    /**
     * 培训地点
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress trmtrainaddress;

    /**
     * 培训记录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency;

    /**
     * 培训课程
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse trmtraincourse;

    /**
     * 培训设施
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainFacies trmtrainfacies;

    /**
     * 培训班级
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm trmtrainplanterm;

    /**
     * 教师姓名
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainTeacher trmtrainteacher;

    /**
     * 培训记录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainPerson trmtrianperson;



    /**
     * 设置 [评价]
     */
    public void setPj(String pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [参考资料]
     */
    public void setCkzl(String ckzl){
        this.ckzl = ckzl ;
        this.modify("ckzl",ckzl);
    }

    /**
     * 设置 [授课开始日期]
     */
    public void setSkksrq(Timestamp skksrq){
        this.skksrq = skksrq ;
        this.modify("skksrq",skksrq);
    }

    /**
     * 格式化日期 [授课开始日期]
     */
    public String formatSkksrq(){
        if (this.skksrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(skksrq);
    }
    /**
     * 设置 [课程学时]
     */
    public void setKcxs(Double kcxs){
        this.kcxs = kcxs ;
        this.modify("kcxs",kcxs);
    }

    /**
     * 设置 [授课结束时间]
     */
    public void setSkjssj(Timestamp skjssj){
        this.skjssj = skjssj ;
        this.modify("skjssj",skjssj);
    }

    /**
     * 格式化日期 [授课结束时间]
     */
    public String formatSkjssj(){
        if (this.skjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(skjssj);
    }
    /**
     * 设置 [课程安排名称]
     */
    public void setTrmcouarrangename(String trmcouarrangename){
        this.trmcouarrangename = trmcouarrangename ;
        this.modify("trmcouarrangename",trmcouarrangename);
    }

    /**
     * 设置 [授课开始时间]
     */
    public void setSkkssj(Timestamp skkssj){
        this.skkssj = skkssj ;
        this.modify("skkssj",skkssj);
    }

    /**
     * 格式化日期 [授课开始时间]
     */
    public String formatSkkssj(){
        if (this.skkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(skkssj);
    }
    /**
     * 设置 [预备知识]
     */
    public void setYbzs(String ybzs){
        this.ybzs = ybzs ;
        this.modify("ybzs",ybzs);
    }

    /**
     * 设置 [课程内容]
     */
    public void setKcnr(String kcnr){
        this.kcnr = kcnr ;
        this.modify("kcnr",kcnr);
    }

    /**
     * 设置 [培训人员标识]
     */
    public void setTrmtrianpersonid(String trmtrianpersonid){
        this.trmtrianpersonid = trmtrianpersonid ;
        this.modify("trmtrianpersonid",trmtrianpersonid);
    }

    /**
     * 设置 [培训教师标识]
     */
    public void setTrmtrainteacherid(String trmtrainteacherid){
        this.trmtrainteacherid = trmtrainteacherid ;
        this.modify("trmtrainteacherid",trmtrainteacherid);
    }

    /**
     * 设置 [培训设施标识]
     */
    public void setTrmtrainfaciesid(String trmtrainfaciesid){
        this.trmtrainfaciesid = trmtrainfaciesid ;
        this.modify("trmtrainfaciesid",trmtrainfaciesid);
    }

    /**
     * 设置 [培训机构标识]
     */
    public void setTrmtrainagencyid(String trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }

    /**
     * 设置 [培训计划项标识]
     */
    public void setTrmtrainplantermid(String trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }

    /**
     * 设置 [培训活动申请标识]
     */
    public void setTrmtrainactapplyid(String trmtrainactapplyid){
        this.trmtrainactapplyid = trmtrainactapplyid ;
        this.modify("trmtrainactapplyid",trmtrainactapplyid);
    }

    /**
     * 设置 [培训地点标识]
     */
    public void setTrmtrainaddressid(String trmtrainaddressid){
        this.trmtrainaddressid = trmtrainaddressid ;
        this.modify("trmtrainaddressid",trmtrainaddressid);
    }

    /**
     * 设置 [机构培训记录标识]
     */
    public void setTrmagencyrecordid(String trmagencyrecordid){
        this.trmagencyrecordid = trmagencyrecordid ;
        this.modify("trmagencyrecordid",trmagencyrecordid);
    }

    /**
     * 设置 [培训课程标识]
     */
    public void setTrmtraincourseid(String trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }

    /**
     * 设置 [课程体系标识]
     */
    public void setTrmcoursesystemid(String trmcoursesystemid){
        this.trmcoursesystemid = trmcoursesystemid ;
        this.modify("trmcoursesystemid",trmcoursesystemid);
    }


}


