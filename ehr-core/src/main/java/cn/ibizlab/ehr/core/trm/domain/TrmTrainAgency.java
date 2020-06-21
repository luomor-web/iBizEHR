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
 * 实体[培训机构]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINAGENCY",resultMap = "TrmTrainAgencyResultMap")
public class TrmTrainAgency extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开户行名称
     */
    @TableField(value = "khhmc")
    @JSONField(name = "khhmc")
    @JsonProperty("khhmc")
    private String khhmc;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 纳税人识别号
     */
    @TableField(value = "nsrsbh")
    @JSONField(name = "nsrsbh")
    @JsonProperty("nsrsbh")
    private String nsrsbh;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 培训次数
     */
    @TableField(value = "pxcs")
    @JSONField(name = "pxcs")
    @JsonProperty("pxcs")
    private Integer pxcs;
    /**
     * 开户行
     */
    @TableField(value = "khh")
    @JSONField(name = "khh")
    @JsonProperty("khh")
    private String khh;
    /**
     * 机构等级
     */
    @TableField(value = "jgdj")
    @JSONField(name = "jgdj")
    @JsonProperty("jgdj")
    private String jgdj;
    /**
     * 机构类型
     */
    @TableField(value = "jglx")
    @JSONField(name = "jglx")
    @JsonProperty("jglx")
    private String jglx;
    /**
     * 是否封存
     */
    @TableField(value = "sffc")
    @JSONField(name = "sffc")
    @JsonProperty("sffc")
    private Integer sffc;
    /**
     * 是否共享
     */
    @TableField(value = "sfgx")
    @JSONField(name = "sfgx")
    @JsonProperty("sfgx")
    private Integer sfgx;
    /**
     * 培训机构名称
     */
    @TableField(value = "trmtrainagencyname")
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 联系人
     */
    @TableField(value = "lxr")
    @JSONField(name = "lxr")
    @JsonProperty("lxr")
    private String lxr;
    /**
     * 机构编码
     */
    @TableField(value = "jgbm")
    @JSONField(name = "jgbm")
    @JsonProperty("jgbm")
    private String jgbm;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 网址
     */
    @TableField(value = "wz")
    @JSONField(name = "wz")
    @JsonProperty("wz")
    private String wz;
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
     * 开票类型
     */
    @TableField(value = "kplx")
    @JSONField(name = "kplx")
    @JsonProperty("kplx")
    private String kplx;
    /**
     * 机构性质
     */
    @TableField(value = "jglb")
    @JSONField(name = "jglb")
    @JsonProperty("jglb")
    private String jglb;
    /**
     * 注册信息
     */
    @TableField(value = "zcxx")
    @JSONField(name = "zcxx")
    @JsonProperty("zcxx")
    private String zcxx;
    /**
     * 开户行账号
     */
    @TableField(value = "khhzh")
    @JSONField(name = "khhzh")
    @JsonProperty("khhzh")
    private String khhzh;
    /**
     * 培训总时长
     */
    @TableField(value = "pxzsc")
    @JSONField(name = "pxzsc")
    @JsonProperty("pxzsc")
    private Double pxzsc;
    /**
     * 培训模块范围
     */
    @TableField(value = "kctxfw")
    @JSONField(name = "kctxfw")
    @JsonProperty("kctxfw")
    private String kctxfw;
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
     * 电话
     */
    @TableField(value = "kprdh")
    @JSONField(name = "kprdh")
    @JsonProperty("kprdh")
    private String kprdh;
    /**
     * 开票信息
     */
    @TableField(value = "kpxx")
    @JSONField(name = "kpxx")
    @JsonProperty("kpxx")
    private String kpxx;
    /**
     * 电子信箱
     */
    @TableField(value = "dzxx")
    @JSONField(name = "dzxx")
    @JsonProperty("dzxx")
    private String dzxx;
    /**
     * 简介
     */
    @TableField(value = "jj")
    @JSONField(name = "jj")
    @JsonProperty("jj")
    private String jj;
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
     * 评价
     */
    @TableField(value = "pj")
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;
    /**
     * 培训机构标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainagencyid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;
    /**
     * 开票人
     */
    @TableField(value = "kpr")
    @JSONField(name = "kpr")
    @JsonProperty("kpr")
    private String kpr;
    /**
     * 开票名称
     */
    @TableField(value = "kpmc")
    @JSONField(name = "kpmc")
    @JsonProperty("kpmc")
    private String kpmc;
    /**
     * 地址
     */
    @TableField(value = "kpdz")
    @JSONField(name = "kpdz")
    @JsonProperty("kpdz")
    private String kpdz;
    /**
     * 联系电话
     */
    @TableField(value = "lxdh")
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 上级机构
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainagencyname2")
    @JsonProperty("trmtrainagencyname2")
    private String trmtrainagencyname2;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 培训机构标识
     */
    @TableField(value = "trmtrainagencyid2")
    @JSONField(name = "trmtrainagencyid2")
    @JsonProperty("trmtrainagencyid2")
    private String trmtrainagencyid2;

    /**
     * 创建公司
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 联系人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 上级机构
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency2;



    /**
     * 设置 [开户行名称]
     */
    public void setKhhmc(String khhmc){
        this.khhmc = khhmc ;
        this.modify("khhmc",khhmc);
    }

    /**
     * 设置 [纳税人识别号]
     */
    public void setNsrsbh(String nsrsbh){
        this.nsrsbh = nsrsbh ;
        this.modify("nsrsbh",nsrsbh);
    }

    /**
     * 设置 [培训次数]
     */
    public void setPxcs(Integer pxcs){
        this.pxcs = pxcs ;
        this.modify("pxcs",pxcs);
    }

    /**
     * 设置 [开户行]
     */
    public void setKhh(String khh){
        this.khh = khh ;
        this.modify("khh",khh);
    }

    /**
     * 设置 [机构等级]
     */
    public void setJgdj(String jgdj){
        this.jgdj = jgdj ;
        this.modify("jgdj",jgdj);
    }

    /**
     * 设置 [机构类型]
     */
    public void setJglx(String jglx){
        this.jglx = jglx ;
        this.modify("jglx",jglx);
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
     * 设置 [培训机构名称]
     */
    public void setTrmtrainagencyname(String trmtrainagencyname){
        this.trmtrainagencyname = trmtrainagencyname ;
        this.modify("trmtrainagencyname",trmtrainagencyname);
    }

    /**
     * 设置 [联系人]
     */
    public void setLxr(String lxr){
        this.lxr = lxr ;
        this.modify("lxr",lxr);
    }

    /**
     * 设置 [机构编码]
     */
    public void setJgbm(String jgbm){
        this.jgbm = jgbm ;
        this.modify("jgbm",jgbm);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [网址]
     */
    public void setWz(String wz){
        this.wz = wz ;
        this.modify("wz",wz);
    }

    /**
     * 设置 [开票类型]
     */
    public void setKplx(String kplx){
        this.kplx = kplx ;
        this.modify("kplx",kplx);
    }

    /**
     * 设置 [机构性质]
     */
    public void setJglb(String jglb){
        this.jglb = jglb ;
        this.modify("jglb",jglb);
    }

    /**
     * 设置 [注册信息]
     */
    public void setZcxx(String zcxx){
        this.zcxx = zcxx ;
        this.modify("zcxx",zcxx);
    }

    /**
     * 设置 [开户行账号]
     */
    public void setKhhzh(String khhzh){
        this.khhzh = khhzh ;
        this.modify("khhzh",khhzh);
    }

    /**
     * 设置 [培训总时长]
     */
    public void setPxzsc(Double pxzsc){
        this.pxzsc = pxzsc ;
        this.modify("pxzsc",pxzsc);
    }

    /**
     * 设置 [培训模块范围]
     */
    public void setKctxfw(String kctxfw){
        this.kctxfw = kctxfw ;
        this.modify("kctxfw",kctxfw);
    }

    /**
     * 设置 [电话]
     */
    public void setKprdh(String kprdh){
        this.kprdh = kprdh ;
        this.modify("kprdh",kprdh);
    }

    /**
     * 设置 [开票信息]
     */
    public void setKpxx(String kpxx){
        this.kpxx = kpxx ;
        this.modify("kpxx",kpxx);
    }

    /**
     * 设置 [电子信箱]
     */
    public void setDzxx(String dzxx){
        this.dzxx = dzxx ;
        this.modify("dzxx",dzxx);
    }

    /**
     * 设置 [简介]
     */
    public void setJj(String jj){
        this.jj = jj ;
        this.modify("jj",jj);
    }

    /**
     * 设置 [评价]
     */
    public void setPj(String pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [开票人]
     */
    public void setKpr(String kpr){
        this.kpr = kpr ;
        this.modify("kpr",kpr);
    }

    /**
     * 设置 [开票名称]
     */
    public void setKpmc(String kpmc){
        this.kpmc = kpmc ;
        this.modify("kpmc",kpmc);
    }

    /**
     * 设置 [地址]
     */
    public void setKpdz(String kpdz){
        this.kpdz = kpdz ;
        this.modify("kpdz",kpdz);
    }

    /**
     * 设置 [联系电话]
     */
    public void setLxdh(String lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [培训机构标识]
     */
    public void setTrmtrainagencyid2(String trmtrainagencyid2){
        this.trmtrainagencyid2 = trmtrainagencyid2 ;
        this.modify("trmtrainagencyid2",trmtrainagencyid2);
    }


}


