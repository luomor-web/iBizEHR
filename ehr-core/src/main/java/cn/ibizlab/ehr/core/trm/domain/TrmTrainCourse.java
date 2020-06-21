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
 * 实体[培训课程]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINCOURSE",resultMap = "TrmTrainCourseResultMap")
public class TrmTrainCourse extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 级别
     */
    @TableField(value = "jb")
    @JSONField(name = "jb")
    @JsonProperty("jb")
    private String jb;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 课程编码
     */
    @TableField(value = "kcbm")
    @JSONField(name = "kcbm")
    @JsonProperty("kcbm")
    private String kcbm;
    /**
     * 课程类别
     */
    @TableField(value = "kclb")
    @JSONField(name = "kclb")
    @JsonProperty("kclb")
    private String kclb;
    /**
     * 版本号
     */
    @TableField(value = "bbh")
    @JSONField(name = "bbh")
    @JsonProperty("bbh")
    private String bbh;
    /**
     * 培训目标
     */
    @TableField(value = "pxmb")
    @JSONField(name = "pxmb")
    @JsonProperty("pxmb")
    private String pxmb;
    /**
     * 课程介绍
     */
    @TableField(value = "kcjs")
    @JSONField(name = "kcjs")
    @JsonProperty("kcjs")
    private String kcjs;
    /**
     * 培训课程名称
     */
    @TableField(value = "trmtraincoursename")
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;
    /**
     * 培训课程标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtraincourseid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;
    /**
     * 授课方式
     */
    @TableField(value = "skfs")
    @JSONField(name = "skfs")
    @JsonProperty("skfs")
    private String skfs;
    /**
     * 版本
     */
    @TableField(value = "bb")
    @JSONField(name = "bb")
    @JsonProperty("bb")
    private String bb;
    /**
     * 累积学时
     */
    @TableField(value = "kcxs")
    @JSONField(name = "kcxs")
    @JsonProperty("kcxs")
    private Double kcxs;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 是否封存
     */
    @TableField(value = "sffc")
    @JSONField(name = "sffc")
    @JsonProperty("sffc")
    private Integer sffc;
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
     * 是否共享
     */
    @TableField(value = "sfgx")
    @JSONField(name = "sfgx")
    @JsonProperty("sfgx")
    private Integer sfgx;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 培训机构名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 培训内容
     */
    @TableField(exist = false)
    @JSONField(name = "nr")
    @JsonProperty("nr")
    private String nr;
    /**
     * 培训模块
     */
    @TableField(exist = false)
    @JSONField(name = "trmcoursesystemname")
    @JsonProperty("trmcoursesystemname")
    private String trmcoursesystemname;
    /**
     * 培训机构标识
     */
    @TableField(value = "trmtrainagencyid")
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 课程体系标识
     */
    @TableField(value = "trmcoursesystemid")
    @JSONField(name = "trmcoursesystemid")
    @JsonProperty("trmcoursesystemid")
    private String trmcoursesystemid;

    /**
     * 创建公司
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 培训模块
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmCourseSystem trmcoursesystem;

    /**
     * 培训课程
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency;



    /**
     * 设置 [级别]
     */
    public void setJb(String jb){
        this.jb = jb ;
        this.modify("jb",jb);
    }

    /**
     * 设置 [课程编码]
     */
    public void setKcbm(String kcbm){
        this.kcbm = kcbm ;
        this.modify("kcbm",kcbm);
    }

    /**
     * 设置 [课程类别]
     */
    public void setKclb(String kclb){
        this.kclb = kclb ;
        this.modify("kclb",kclb);
    }

    /**
     * 设置 [版本号]
     */
    public void setBbh(String bbh){
        this.bbh = bbh ;
        this.modify("bbh",bbh);
    }

    /**
     * 设置 [培训目标]
     */
    public void setPxmb(String pxmb){
        this.pxmb = pxmb ;
        this.modify("pxmb",pxmb);
    }

    /**
     * 设置 [课程介绍]
     */
    public void setKcjs(String kcjs){
        this.kcjs = kcjs ;
        this.modify("kcjs",kcjs);
    }

    /**
     * 设置 [培训课程名称]
     */
    public void setTrmtraincoursename(String trmtraincoursename){
        this.trmtraincoursename = trmtraincoursename ;
        this.modify("trmtraincoursename",trmtraincoursename);
    }

    /**
     * 设置 [授课方式]
     */
    public void setSkfs(String skfs){
        this.skfs = skfs ;
        this.modify("skfs",skfs);
    }

    /**
     * 设置 [版本]
     */
    public void setBb(String bb){
        this.bb = bb ;
        this.modify("bb",bb);
    }

    /**
     * 设置 [累积学时]
     */
    public void setKcxs(Double kcxs){
        this.kcxs = kcxs ;
        this.modify("kcxs",kcxs);
    }

    /**
     * 设置 [是否封存]
     */
    public void setSffc(Integer sffc){
        this.sffc = sffc ;
        this.modify("sffc",sffc);
    }

    /**
     * 设置 [是否共享]
     */
    public void setSfgx(Integer sfgx){
        this.sfgx = sfgx ;
        this.modify("sfgx",sfgx);
    }

    /**
     * 设置 [培训机构标识]
     */
    public void setTrmtrainagencyid(String trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [课程体系标识]
     */
    public void setTrmcoursesystemid(String trmcoursesystemid){
        this.trmcoursesystemid = trmcoursesystemid ;
        this.modify("trmcoursesystemid",trmcoursesystemid);
    }


}


