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
 * 实体[员工培训报名]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMEMPLOYEERETION",resultMap = "TrmEmployeeRetionResultMap")
public class TrmEmployeeRetion extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 培训内容
     */
    @TableField(value = "pxnr")
    @JSONField(name = "pxnr")
    @JsonProperty("pxnr")
    private String pxnr;
    /**
     * 员工培训报名名称
     */
    @DEField(name = "trmemployeeretionname")
    @TableField(value = "trmemployeeretionname")
    @JSONField(name = "trmemployretionname")
    @JsonProperty("trmemployretionname")
    private String trmemployretionname;
    /**
     * 报名条件
     */
    @TableField(value = "bmtj")
    @JSONField(name = "bmtj")
    @JsonProperty("bmtj")
    private String bmtj;
    /**
     * 报名截止日期
     */
    @TableField(value = "bmjzrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bmjzrq" , format="yyyy-MM-dd")
    @JsonProperty("bmjzrq")
    private Timestamp bmjzrq;
    /**
     * 报名开始时间
     */
    @TableField(value = "bmkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bmkssj" , format="yyyy-MM-dd")
    @JsonProperty("bmkssj")
    private Timestamp bmkssj;
    /**
     * 培训地点
     */
    @TableField(value = "pxdd")
    @JSONField(name = "pxdd")
    @JsonProperty("pxdd")
    private String pxdd;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 员工培训报名标识
     */
    @DEField(name = "trmemployeeretionid" , isKeyField=true)
    @TableId(value= "trmemployeeretionid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmemployretionid")
    @JsonProperty("trmemployretionid")
    private String trmemployretionid;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 培训开始日期
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "skksrq" , format="yyyy-MM-dd")
    @JsonProperty("skksrq")
    private Timestamp skksrq;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 培训活动编码
     */
    @TableField(exist = false)
    @JSONField(name = "pxhdbm")
    @JsonProperty("pxhdbm")
    private String pxhdbm;
    /**
     * 课程安排名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmcouarrangename")
    @JsonProperty("trmcouarrangename")
    private String trmcouarrangename;
    /**
     * 培训结束日期
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "skjssj" , format="yyyy-MM-dd")
    @JsonProperty("skjssj")
    private Timestamp skjssj;
    /**
     * 培训机构名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 培训活动申请名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainactapplyname")
    @JsonProperty("trmtrainactapplyname")
    private String trmtrainactapplyname;
    /**
     * 培训学时
     */
    @TableField(exist = false)
    @JSONField(name = "kcxs")
    @JsonProperty("kcxs")
    private Double kcxs;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 课程安排标识
     */
    @TableField(value = "trmcouarrangeid")
    @JSONField(name = "trmcouarrangeid")
    @JsonProperty("trmcouarrangeid")
    private String trmcouarrangeid;
    /**
     * 培训活动申请标识
     */
    @TableField(value = "trmtrainactapplyid")
    @JSONField(name = "trmtrainactapplyid")
    @JsonProperty("trmtrainactapplyid")
    private String trmtrainactapplyid;
    /**
     * 培训机构标识
     */
    @TableField(value = "trmtrainagencyid")
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;

    /**
     * 发布公司
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 课程安排
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmCouarrange trmcouarrange;

    /**
     * 培训活动
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainActapply trmtrainactapply;

    /**
     * 培训机构
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency;



    /**
     * 设置 [培训内容]
     */
    public void setPxnr(String pxnr){
        this.pxnr = pxnr ;
        this.modify("pxnr",pxnr);
    }

    /**
     * 设置 [员工培训报名名称]
     */
    public void setTrmemployretionname(String trmemployretionname){
        this.trmemployretionname = trmemployretionname ;
        this.modify("trmemployeeretionname",trmemployretionname);
    }

    /**
     * 设置 [报名条件]
     */
    public void setBmtj(String bmtj){
        this.bmtj = bmtj ;
        this.modify("bmtj",bmtj);
    }

    /**
     * 设置 [报名截止日期]
     */
    public void setBmjzrq(Timestamp bmjzrq){
        this.bmjzrq = bmjzrq ;
        this.modify("bmjzrq",bmjzrq);
    }

    /**
     * 格式化日期 [报名截止日期]
     */
    public String formatBmjzrq(){
        if (this.bmjzrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(bmjzrq);
    }
    /**
     * 设置 [报名开始时间]
     */
    public void setBmkssj(Timestamp bmkssj){
        this.bmkssj = bmkssj ;
        this.modify("bmkssj",bmkssj);
    }

    /**
     * 格式化日期 [报名开始时间]
     */
    public String formatBmkssj(){
        if (this.bmkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(bmkssj);
    }
    /**
     * 设置 [培训地点]
     */
    public void setPxdd(String pxdd){
        this.pxdd = pxdd ;
        this.modify("pxdd",pxdd);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [课程安排标识]
     */
    public void setTrmcouarrangeid(String trmcouarrangeid){
        this.trmcouarrangeid = trmcouarrangeid ;
        this.modify("trmcouarrangeid",trmcouarrangeid);
    }

    /**
     * 设置 [培训活动申请标识]
     */
    public void setTrmtrainactapplyid(String trmtrainactapplyid){
        this.trmtrainactapplyid = trmtrainactapplyid ;
        this.modify("trmtrainactapplyid",trmtrainactapplyid);
    }

    /**
     * 设置 [培训机构标识]
     */
    public void setTrmtrainagencyid(String trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}


