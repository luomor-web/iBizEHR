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
 * 实体[培训讲师]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINTEACHER",resultMap = "TrmTrainTeacherResultMap")
public class TrmTrainTeacher extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 执教开始时间
     */
    @TableField(value = "zjkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zjkssj" , format="yyyy-MM-dd")
    @JsonProperty("zjkssj")
    private Timestamp zjkssj;
    /**
     * 培训教师标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainteacherid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainteacherid")
    @JsonProperty("trmtrainteacherid")
    private String trmtrainteacherid;
    /**
     * 是否共享
     */
    @TableField(value = "sfgx")
    @JSONField(name = "sfgx")
    @JsonProperty("sfgx")
    private Integer sfgx;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 培训讲师级别
     */
    @TableField(value = "pxjsjb")
    @JSONField(name = "pxjsjb")
    @JsonProperty("pxjsjb")
    private String pxjsjb;
    /**
     * 照片
     */
    @TableField(value = "zp")
    @JSONField(name = "zp")
    @JsonProperty("zp")
    private String zp;
    /**
     * 积分
     */
    @TableField(value = "jf")
    @JSONField(name = "jf")
    @JsonProperty("jf")
    private Double jf;
    /**
     * 讲师介绍
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 教师类别
     */
    @TableField(value = "jslb")
    @JSONField(name = "jslb")
    @JsonProperty("jslb")
    private String jslb;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 讲授课程
     */
    @TableField(value = "jskc")
    @JSONField(name = "jskc")
    @JsonProperty("jskc")
    private String jskc;
    /**
     * 特征
     */
    @TableField(value = "tz")
    @JSONField(name = "tz")
    @JsonProperty("tz")
    private String tz;
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
     * 教师编码
     */
    @TableField(value = "jsbm")
    @JSONField(name = "jsbm")
    @JsonProperty("jsbm")
    private String jsbm;
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
     * 讲师类型
     */
    @TableField(value = "jslx")
    @JSONField(name = "jslx")
    @JsonProperty("jslx")
    private String jslx;
    /**
     * 培训教师名称
     */
    @TableField(value = "trmtrainteachername")
    @JSONField(name = "trmtrainteachername")
    @JsonProperty("trmtrainteachername")
    private String trmtrainteachername;
    /**
     * 等级
     */
    @TableField(value = "dj")
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private String dj;
    /**
     * 创建公司
     */
    @TableField(value = "cjgs")
    @JSONField(name = "cjgs")
    @JsonProperty("cjgs")
    private String cjgs;
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
     * 评价
     */
    @TableField(value = "pj")
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 年龄
     */
    @TableField(value = "nl")
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 所属机构
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 性别
     */
    @TableField(value = "xb")
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;
    /**
     * 证件号码
     */
    @TableField(value = "zjhm")
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 姓名
     */
    @TableField(value = "pimpersonname")
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 联系电话
     */
    @TableField(value = "lxdh")
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 机构性质
     */
    @TableField(value = "jglb")
    @JSONField(name = "jglb")
    @JsonProperty("jglb")
    private String jglb;
    /**
     * 职务
     */
    @TableField(exist = false)
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 特长
     */
    @TableField(value = "ahtc")
    @JSONField(name = "ahtc")
    @JsonProperty("ahtc")
    private String ahtc;
    /**
     * 电子邮箱
     */
    @TableField(value = "dzyx")
    @JSONField(name = "dzyx")
    @JsonProperty("dzyx")
    private String dzyx;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 培训机构标识
     */
    @TableField(value = "trmtrainagencyid")
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;

    /**
     * 工作单位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 教师姓名
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 培训师资
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency;



    /**
     * 设置 [执教开始时间]
     */
    public void setZjkssj(Timestamp zjkssj){
        this.zjkssj = zjkssj ;
        this.modify("zjkssj",zjkssj);
    }

    /**
     * 格式化日期 [执教开始时间]
     */
    public String formatZjkssj(){
        if (this.zjkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(zjkssj);
    }
    /**
     * 设置 [是否共享]
     */
    public void setSfgx(Integer sfgx){
        this.sfgx = sfgx ;
        this.modify("sfgx",sfgx);
    }

    /**
     * 设置 [培训讲师级别]
     */
    public void setPxjsjb(String pxjsjb){
        this.pxjsjb = pxjsjb ;
        this.modify("pxjsjb",pxjsjb);
    }

    /**
     * 设置 [照片]
     */
    public void setZp(String zp){
        this.zp = zp ;
        this.modify("zp",zp);
    }

    /**
     * 设置 [积分]
     */
    public void setJf(Double jf){
        this.jf = jf ;
        this.modify("jf",jf);
    }

    /**
     * 设置 [讲师介绍]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [教师类别]
     */
    public void setJslb(String jslb){
        this.jslb = jslb ;
        this.modify("jslb",jslb);
    }

    /**
     * 设置 [讲授课程]
     */
    public void setJskc(String jskc){
        this.jskc = jskc ;
        this.modify("jskc",jskc);
    }

    /**
     * 设置 [特征]
     */
    public void setTz(String tz){
        this.tz = tz ;
        this.modify("tz",tz);
    }

    /**
     * 设置 [教师编码]
     */
    public void setJsbm(String jsbm){
        this.jsbm = jsbm ;
        this.modify("jsbm",jsbm);
    }

    /**
     * 设置 [讲师类型]
     */
    public void setJslx(String jslx){
        this.jslx = jslx ;
        this.modify("jslx",jslx);
    }

    /**
     * 设置 [培训教师名称]
     */
    public void setTrmtrainteachername(String trmtrainteachername){
        this.trmtrainteachername = trmtrainteachername ;
        this.modify("trmtrainteachername",trmtrainteachername);
    }

    /**
     * 设置 [等级]
     */
    public void setDj(String dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }

    /**
     * 设置 [创建公司]
     */
    public void setCjgs(String cjgs){
        this.cjgs = cjgs ;
        this.modify("cjgs",cjgs);
    }

    /**
     * 设置 [是否封存]
     */
    public void setSffc(Integer sffc){
        this.sffc = sffc ;
        this.modify("sffc",sffc);
    }

    /**
     * 设置 [评价]
     */
    public void setPj(String pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [年龄]
     */
    public void setNl(Integer nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [性别]
     */
    public void setXb(String xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [证件号码]
     */
    public void setZjhm(String zjhm){
        this.zjhm = zjhm ;
        this.modify("zjhm",zjhm);
    }

    /**
     * 设置 [姓名]
     */
    public void setPimpersonname(String pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [联系电话]
     */
    public void setLxdh(String lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [机构性质]
     */
    public void setJglb(String jglb){
        this.jglb = jglb ;
        this.modify("jglb",jglb);
    }

    /**
     * 设置 [特长]
     */
    public void setAhtc(String ahtc){
        this.ahtc = ahtc ;
        this.modify("ahtc",ahtc);
    }

    /**
     * 设置 [电子邮箱]
     */
    public void setDzyx(String dzyx){
        this.dzyx = dzyx ;
        this.modify("dzyx",dzyx);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [培训机构标识]
     */
    public void setTrmtrainagencyid(String trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}


