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
 * 实体[培训立项]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINPLANTERM",resultMap = "TrmTrainPlantermResultMap")
public class TrmTrainPlanterm extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 培训人数
     */
    @TableField(value = "pxrs")
    @JSONField(name = "pxrs")
    @JsonProperty("pxrs")
    private Integer pxrs;
    /**
     * 培训目标
     */
    @TableField(value = "pxmb")
    @JSONField(name = "pxmb")
    @JsonProperty("pxmb")
    private String pxmb;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 计划结束时间
     */
    @TableField(value = "jhjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhjssj" , format="yyyy-MM-dd")
    @JsonProperty("jhjssj")
    private Timestamp jhjssj;
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
     * 培训方式
     */
    @TableField(value = "pxfs")
    @JSONField(name = "pxfs")
    @JsonProperty("pxfs")
    private String pxfs;
    /**
     * 培训对象类别
     */
    @TableField(value = "pxdxlb")
    @JSONField(name = "pxdxlb")
    @JsonProperty("pxdxlb")
    private String pxdxlb;
    /**
     * 培训次数
     */
    @TableField(value = "pxcs")
    @JSONField(name = "pxcs")
    @JsonProperty("pxcs")
    private Integer pxcs;
    /**
     * 班级状态
     */
    @DEField(defaultValue = "10")
    @TableField(value = "bjzt")
    @JSONField(name = "bjzt")
    @JsonProperty("bjzt")
    private String bjzt;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 培训类别
     */
    @TableField(value = "pxlb")
    @JSONField(name = "pxlb")
    @JsonProperty("pxlb")
    private String pxlb;
    /**
     * 计划项编码
     */
    @TableField(value = "jhxbm")
    @JSONField(name = "jhxbm")
    @JsonProperty("jhxbm")
    private String jhxbm;
    /**
     * 教师出处
     */
    @TableField(value = "jscc")
    @JSONField(name = "jscc")
    @JsonProperty("jscc")
    private String jscc;
    /**
     * 费用预算
     */
    @TableField(value = "fyys")
    @JSONField(name = "fyys")
    @JsonProperty("fyys")
    private Double fyys;
    /**
     * 培训时长
     */
    @TableField(value = "pxsc")
    @JSONField(name = "pxsc")
    @JsonProperty("pxsc")
    private Double pxsc;
    /**
     * 班主任
     */
    @TableField(value = "bzr")
    @JSONField(name = "bzr")
    @JsonProperty("bzr")
    private String bzr;
    /**
     * 审批意见
     */
    @TableField(value = "spyj")
    @JSONField(name = "spyj")
    @JsonProperty("spyj")
    private String spyj;
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
     * 状态
     */
    @TableField(value = "zt")
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;
    /**
     * 培训备注
     */
    @TableField(value = "pxfz")
    @JSONField(name = "pxfz")
    @JsonProperty("pxfz")
    private String pxfz;
    /**
     * 是否签订培训协议
     */
    @TableField(value = "sfqdpxxy")
    @JSONField(name = "sfqdpxxy")
    @JsonProperty("sfqdpxxy")
    private String sfqdpxxy;
    /**
     * 计划开始时间
     */
    @TableField(value = "jhkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhkssj" , format="yyyy-MM-dd")
    @JsonProperty("jhkssj")
    private Timestamp jhkssj;
    /**
     * 培训立项标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainplantermid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;
    /**
     * 培训内容
     */
    @TableField(value = "pxnr")
    @JSONField(name = "pxnr")
    @JsonProperty("pxnr")
    private String pxnr;
    /**
     * 培训立项名称
     */
    @TableField(value = "trmtrainplantermname")
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;
    /**
     * 班级名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmdemdeftionname")
    @JsonProperty("trmdemdeftionname")
    private String trmdemdeftionname;
    /**
     * 培训机构名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 课程
     */
    @TableField(exist = false)
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;
    /**
     * 培训地点
     */
    @TableField(exist = false)
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;
    /**
     * 培训开始时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxkssj" , format="yyyy-MM-dd")
    @JsonProperty("pxkssj")
    private Timestamp pxkssj;
    /**
     * 培训结束时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjssj" , format="yyyy-MM-dd")
    @JsonProperty("pxjssj")
    private Timestamp pxjssj;
    /**
     * 讲师
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainteachername")
    @JsonProperty("trmtrainteachername")
    private String trmtrainteachername;
    /**
     * 培训立项名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainplanname")
    @JsonProperty("trmtrainplanname")
    private String trmtrainplanname;
    /**
     * 培训计划标识
     */
    @TableField(value = "trmtrainplanid")
    @JSONField(name = "trmtrainplanid")
    @JsonProperty("trmtrainplanid")
    private String trmtrainplanid;
    /**
     * 培训教师标识
     */
    @TableField(value = "trmtrainteacherid")
    @JSONField(name = "trmtrainteacherid")
    @JsonProperty("trmtrainteacherid")
    private String trmtrainteacherid;
    /**
     * 培训机构标识
     */
    @TableField(value = "trmtrainagencyid")
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;
    /**
     * 培训课程标识
     */
    @TableField(value = "trmtraincourseid")
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;

    /**
     * 培训班级
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
     * 培训计划
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainPlan trmtrainplan;

    /**
     * 讲师
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainTeacher trmtrainteacher;



    /**
     * 设置 [培训人数]
     */
    public void setPxrs(Integer pxrs){
        this.pxrs = pxrs ;
        this.modify("pxrs",pxrs);
    }

    /**
     * 设置 [培训目标]
     */
    public void setPxmb(String pxmb){
        this.pxmb = pxmb ;
        this.modify("pxmb",pxmb);
    }

    /**
     * 设置 [计划结束时间]
     */
    public void setJhjssj(Timestamp jhjssj){
        this.jhjssj = jhjssj ;
        this.modify("jhjssj",jhjssj);
    }

    /**
     * 格式化日期 [计划结束时间]
     */
    public String formatJhjssj(){
        if (this.jhjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jhjssj);
    }
    /**
     * 设置 [培训方式]
     */
    public void setPxfs(String pxfs){
        this.pxfs = pxfs ;
        this.modify("pxfs",pxfs);
    }

    /**
     * 设置 [培训对象类别]
     */
    public void setPxdxlb(String pxdxlb){
        this.pxdxlb = pxdxlb ;
        this.modify("pxdxlb",pxdxlb);
    }

    /**
     * 设置 [培训次数]
     */
    public void setPxcs(Integer pxcs){
        this.pxcs = pxcs ;
        this.modify("pxcs",pxcs);
    }

    /**
     * 设置 [班级状态]
     */
    public void setBjzt(String bjzt){
        this.bjzt = bjzt ;
        this.modify("bjzt",bjzt);
    }

    /**
     * 设置 [培训类别]
     */
    public void setPxlb(String pxlb){
        this.pxlb = pxlb ;
        this.modify("pxlb",pxlb);
    }

    /**
     * 设置 [计划项编码]
     */
    public void setJhxbm(String jhxbm){
        this.jhxbm = jhxbm ;
        this.modify("jhxbm",jhxbm);
    }

    /**
     * 设置 [教师出处]
     */
    public void setJscc(String jscc){
        this.jscc = jscc ;
        this.modify("jscc",jscc);
    }

    /**
     * 设置 [费用预算]
     */
    public void setFyys(Double fyys){
        this.fyys = fyys ;
        this.modify("fyys",fyys);
    }

    /**
     * 设置 [培训时长]
     */
    public void setPxsc(Double pxsc){
        this.pxsc = pxsc ;
        this.modify("pxsc",pxsc);
    }

    /**
     * 设置 [班主任]
     */
    public void setBzr(String bzr){
        this.bzr = bzr ;
        this.modify("bzr",bzr);
    }

    /**
     * 设置 [审批意见]
     */
    public void setSpyj(String spyj){
        this.spyj = spyj ;
        this.modify("spyj",spyj);
    }

    /**
     * 设置 [状态]
     */
    public void setZt(String zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [培训备注]
     */
    public void setPxfz(String pxfz){
        this.pxfz = pxfz ;
        this.modify("pxfz",pxfz);
    }

    /**
     * 设置 [是否签订培训协议]
     */
    public void setSfqdpxxy(String sfqdpxxy){
        this.sfqdpxxy = sfqdpxxy ;
        this.modify("sfqdpxxy",sfqdpxxy);
    }

    /**
     * 设置 [计划开始时间]
     */
    public void setJhkssj(Timestamp jhkssj){
        this.jhkssj = jhkssj ;
        this.modify("jhkssj",jhkssj);
    }

    /**
     * 格式化日期 [计划开始时间]
     */
    public String formatJhkssj(){
        if (this.jhkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jhkssj);
    }
    /**
     * 设置 [培训内容]
     */
    public void setPxnr(String pxnr){
        this.pxnr = pxnr ;
        this.modify("pxnr",pxnr);
    }

    /**
     * 设置 [培训立项名称]
     */
    public void setTrmtrainplantermname(String trmtrainplantermname){
        this.trmtrainplantermname = trmtrainplantermname ;
        this.modify("trmtrainplantermname",trmtrainplantermname);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [培训计划标识]
     */
    public void setTrmtrainplanid(String trmtrainplanid){
        this.trmtrainplanid = trmtrainplanid ;
        this.modify("trmtrainplanid",trmtrainplanid);
    }

    /**
     * 设置 [培训教师标识]
     */
    public void setTrmtrainteacherid(String trmtrainteacherid){
        this.trmtrainteacherid = trmtrainteacherid ;
        this.modify("trmtrainteacherid",trmtrainteacherid);
    }

    /**
     * 设置 [培训机构标识]
     */
    public void setTrmtrainagencyid(String trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }

    /**
     * 设置 [培训课程标识]
     */
    public void setTrmtraincourseid(String trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }


}


