package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[分配信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMDISTIRBUTION",resultMap = "PimDistirbutionResultMap")
public class PimDistirbution extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 调动状态
     */
    @TableField(exist = false)
    @JSONField(name = "ssfw")
    @JsonProperty("ssfw")
    private String ssfw;
    /**
     * 任职结束时间
     */
    @TableField(value = "rzjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzjssj" , format="yyyy-MM-dd")
    @JsonProperty("rzjssj")
    private Timestamp rzjssj;
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
     * 分配状态
     */
    @TableField(value = "fpzt")
    @JSONField(name = "fpzt")
    @JsonProperty("fpzt")
    private String fpzt;
    /**
     * 日志内容
     */
    @TableField(value = "logcontent")
    @JSONField(name = "logcontent")
    @JsonProperty("logcontent")
    private String logcontent;
    /**
     * 分配信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimdistirbutionid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimdistirbutionid")
    @JsonProperty("pimdistirbutionid")
    private String pimdistirbutionid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 任职开始时间
     */
    @TableField(value = "rzkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzkssj" , format="yyyy-MM-dd")
    @JsonProperty("rzkssj")
    private Timestamp rzkssj;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 原职务
     */
    @TableField(value = "yzw")
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;
    /**
     * 履历说明
     */
    @TableField(value = "record")
    @JSONField(name = "record")
    @JsonProperty("record")
    private String record;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 工作地区
     */
    @TableField(value = "gzdq")
    @JSONField(name = "gzdq")
    @JsonProperty("gzdq")
    private String gzdq;
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
     * 履历id
     */
    @TableField(value = "pimworkhistoryid")
    @JSONField(name = "pimworkhistoryid")
    @JsonProperty("pimworkhistoryid")
    private String pimworkhistoryid;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 外单位履历
     */
    @DEField(defaultValue = "1")
    @TableField(value = "isoutrecord")
    @JSONField(name = "isoutrecord")
    @JsonProperty("isoutrecord")
    private Integer isoutrecord;
    /**
     * 分配信息名称
     */
    @TableField(value = "pimdistirbutionname")
    @JSONField(name = "pimdistirbutionname")
    @JsonProperty("pimdistirbutionname")
    private String pimdistirbutionname;
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
     * 分配
     */
    @TableField(value = "fplx")
    @JSONField(name = "fplx")
    @JsonProperty("fplx")
    private String fplx;
    /**
     * 是否主要经历
     */
    @TableField(value = "experience")
    @JSONField(name = "experience")
    @JsonProperty("experience")
    private Integer experience;
    /**
     * 借调状态
     */
    @TableField(exist = false)
    @JSONField(name = "jdzt")
    @JsonProperty("jdzt")
    private String jdzt;
    /**
     * 异动明细id
     */
    @TableField(value = "ydmxid")
    @JSONField(name = "ydmxid")
    @JsonProperty("ydmxid")
    private String ydmxid;
    /**
     * 工作地点
     */
    @TableField(value = "gzdd")
    @JSONField(name = "gzdd")
    @JsonProperty("gzdd")
    private String gzdd;
    /**
     * 原岗位
     */
    @TableField(value = "ygw")
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 类型
     */
    @TableField(value = "cfplx")
    @JSONField(name = "cfplx")
    @JsonProperty("cfplx")
    private String cfplx;
    /**
     * 职级
     */
    @TableField(value = "rank")
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;
    /**
     * 岗位
     */
    @TableField(value = "ormpostname")
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 员工状态
     */
    @TableField(exist = false)
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;
    /**
     * 性别
     */
    @TableField(exist = false)
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 在岗标识
     */
    @TableField(exist = false)
    @JSONField(name = "zgcode")
    @JsonProperty("zgcode")
    private String zgcode;
    /**
     * 原组织
     */
    @TableField(value = "yzz")
    @JSONField(name = "yzz")
    @JsonProperty("yzz")
    private String yzz;
    /**
     * 组织
     */
    @TableField(value = "ormorgname")
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 岗位年限
     */
    @TableField(exist = false)
    @JSONField(name = "lgnx")
    @JsonProperty("lgnx")
    private Integer lgnx;
    /**
     * 原部门
     */
    @TableField(exist = false)
    @JSONField(name = "ybmshortname")
    @JsonProperty("ybmshortname")
    private String ybmshortname;
    /**
     * 政治面貌
     */
    @TableField(exist = false)
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 异动状态
     */
    @TableField(exist = false)
    @JSONField(name = "ydzt")
    @JsonProperty("ydzt")
    private String ydzt;
    /**
     * 年龄
     */
    @TableField(exist = false)
    @JSONField(name = "nj")
    @JsonProperty("nj")
    private Integer nj;
    /**
     * 原组织
     */
    @TableField(exist = false)
    @JSONField(name = "yzzzzdzs")
    @JsonProperty("yzzzzdzs")
    private String yzzzzdzs;
    /**
     * 部门
     */
    @TableField(value = "ormorgsectorname")
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 部门
     */
    @TableField(exist = false)
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 职务
     */
    @TableField(value = "ormdutyname")
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;
    /**
     * 原部门
     */
    @TableField(value = "ybm")
    @JSONField(name = "ybm")
    @JsonProperty("ybm")
    private String ybm;
    /**
     * 汇报关系
     */
    @TableField(exist = false)
    @JSONField(name = "ormpostname1")
    @JsonProperty("ormpostname1")
    private String ormpostname1;
    /**
     * 部门标识
     */
    @TableField(value = "ybmid")
    @JSONField(name = "ybmid")
    @JsonProperty("ybmid")
    private String ybmid;
    /**
     * 部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 岗位管理标识
     */
    @TableField(value = "ormpostid1")
    @JSONField(name = "ormpostid1")
    @JsonProperty("ormpostid1")
    private String ormpostid1;
    /**
     * 岗位管理标识
     */
    @TableField(value = "ormpostid")
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;
    /**
     * 职务管理标识
     */
    @TableField(value = "ormdutyid")
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;
    /**
     * 组织标识
     */
    @TableField(value = "yzzid")
    @JSONField(name = "yzzid")
    @JsonProperty("yzzid")
    private String yzzid;
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
     * 职务
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty;

    /**
     * 部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 原部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsectorYbm;

    /**
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 原组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorgYzz;

    /**
     * 岗位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost;

    /**
     * 汇报关系
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost1;

    /**
     * 分配信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [任职结束时间]
     */
    public void setRzjssj(Timestamp rzjssj){
        this.rzjssj = rzjssj ;
        this.modify("rzjssj",rzjssj);
    }

    /**
     * 格式化日期 [任职结束时间]
     */
    public String formatRzjssj(){
        if (this.rzjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(rzjssj);
    }
    /**
     * 设置 [分配状态]
     */
    public void setFpzt(String fpzt){
        this.fpzt = fpzt ;
        this.modify("fpzt",fpzt);
    }

    /**
     * 设置 [日志内容]
     */
    public void setLogcontent(String logcontent){
        this.logcontent = logcontent ;
        this.modify("logcontent",logcontent);
    }

    /**
     * 设置 [任职开始时间]
     */
    public void setRzkssj(Timestamp rzkssj){
        this.rzkssj = rzkssj ;
        this.modify("rzkssj",rzkssj);
    }

    /**
     * 格式化日期 [任职开始时间]
     */
    public String formatRzkssj(){
        if (this.rzkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(rzkssj);
    }
    /**
     * 设置 [原职务]
     */
    public void setYzw(String yzw){
        this.yzw = yzw ;
        this.modify("yzw",yzw);
    }

    /**
     * 设置 [履历说明]
     */
    public void setRecord(String record){
        this.record = record ;
        this.modify("record",record);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [工作地区]
     */
    public void setGzdq(String gzdq){
        this.gzdq = gzdq ;
        this.modify("gzdq",gzdq);
    }

    /**
     * 设置 [履历id]
     */
    public void setPimworkhistoryid(String pimworkhistoryid){
        this.pimworkhistoryid = pimworkhistoryid ;
        this.modify("pimworkhistoryid",pimworkhistoryid);
    }

    /**
     * 设置 [外单位履历]
     */
    public void setIsoutrecord(Integer isoutrecord){
        this.isoutrecord = isoutrecord ;
        this.modify("isoutrecord",isoutrecord);
    }

    /**
     * 设置 [分配信息名称]
     */
    public void setPimdistirbutionname(String pimdistirbutionname){
        this.pimdistirbutionname = pimdistirbutionname ;
        this.modify("pimdistirbutionname",pimdistirbutionname);
    }

    /**
     * 设置 [分配]
     */
    public void setFplx(String fplx){
        this.fplx = fplx ;
        this.modify("fplx",fplx);
    }

    /**
     * 设置 [是否主要经历]
     */
    public void setExperience(Integer experience){
        this.experience = experience ;
        this.modify("experience",experience);
    }

    /**
     * 设置 [异动明细id]
     */
    public void setYdmxid(String ydmxid){
        this.ydmxid = ydmxid ;
        this.modify("ydmxid",ydmxid);
    }

    /**
     * 设置 [工作地点]
     */
    public void setGzdd(String gzdd){
        this.gzdd = gzdd ;
        this.modify("gzdd",gzdd);
    }

    /**
     * 设置 [原岗位]
     */
    public void setYgw(String ygw){
        this.ygw = ygw ;
        this.modify("ygw",ygw);
    }

    /**
     * 设置 [类型]
     */
    public void setCfplx(String cfplx){
        this.cfplx = cfplx ;
        this.modify("cfplx",cfplx);
    }

    /**
     * 设置 [职级]
     */
    public void setRank(String rank){
        this.rank = rank ;
        this.modify("rank",rank);
    }

    /**
     * 设置 [岗位]
     */
    public void setOrmpostname(String ormpostname){
        this.ormpostname = ormpostname ;
        this.modify("ormpostname",ormpostname);
    }

    /**
     * 设置 [原组织]
     */
    public void setYzz(String yzz){
        this.yzz = yzz ;
        this.modify("yzz",yzz);
    }

    /**
     * 设置 [组织]
     */
    public void setOrmorgname(String ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [部门]
     */
    public void setOrmorgsectorname(String ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
    }

    /**
     * 设置 [职务]
     */
    public void setOrmdutyname(String ormdutyname){
        this.ormdutyname = ormdutyname ;
        this.modify("ormdutyname",ormdutyname);
    }

    /**
     * 设置 [原部门]
     */
    public void setYbm(String ybm){
        this.ybm = ybm ;
        this.modify("ybm",ybm);
    }

    /**
     * 设置 [部门标识]
     */
    public void setYbmid(String ybmid){
        this.ybmid = ybmid ;
        this.modify("ybmid",ybmid);
    }

    /**
     * 设置 [部门标识]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [岗位管理标识]
     */
    public void setOrmpostid1(String ormpostid1){
        this.ormpostid1 = ormpostid1 ;
        this.modify("ormpostid1",ormpostid1);
    }

    /**
     * 设置 [岗位管理标识]
     */
    public void setOrmpostid(String ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [职务管理标识]
     */
    public void setOrmdutyid(String ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setYzzid(String yzzid){
        this.yzzid = yzzid ;
        this.modify("yzzid",yzzid);
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


}


