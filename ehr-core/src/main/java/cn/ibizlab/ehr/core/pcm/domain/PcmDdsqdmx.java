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
 * 实体[调动申请单明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMDDSQDMX",resultMap = "PcmDdsqdmxResultMap")
public class PcmDdsqdmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 调动申请单明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmddsqdmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmddsqdmxid")
    @JsonProperty("pcmddsqdmxid")
    private String pcmddsqdmxid;
    /**
     * 完成调动
     */
    @TableField(value = "finishdd")
    @JSONField(name = "finishdd")
    @JsonProperty("finishdd")
    private Integer finishdd;
    /**
     * 审核状态
     */
    @TableField(value = "checkstatus")
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;
    /**
     * 类型
     */
    @DEField(defaultValue = "10")
    @TableField(value = "lx")
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;
    /**
     * 是否干部调动
     */
    @DEField(defaultValue = "0")
    @TableField(value = "sfgbdd")
    @JSONField(name = "sfgbdd")
    @JsonProperty("sfgbdd")
    private Integer sfgbdd;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 借调结束时间
     */
    @TableField(value = "jdjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jdjssj" , format="yyyy-MM-dd")
    @JsonProperty("jdjssj")
    private Timestamp jdjssj;
    /**
     * 生效日期
     */
    @TableField(value = "sxrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 是否局总部
     */
    @TableField(value = "sfjzb")
    @JSONField(name = "sfjzb")
    @JsonProperty("sfjzb")
    private Integer sfjzb;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 调动类型（更新、修正）
     */
    @TableField(value = "ddtype")
    @JSONField(name = "ddtype")
    @JsonProperty("ddtype")
    private String ddtype;
    /**
     * 任职文件
     */
    @TableField(value = "rzwj")
    @JSONField(name = "rzwj")
    @JsonProperty("rzwj")
    private String rzwj;
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
     * 调动申请单明细名称
     */
    @TableField(value = "pcmddsqdmxname")
    @JSONField(name = "pcmddsqdmxname")
    @JsonProperty("pcmddsqdmxname")
    private String pcmddsqdmxname;
    /**
     * 借调开始时间
     */
    @TableField(value = "jdkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jdkssj" , format="yyyy-MM-dd")
    @JsonProperty("jdkssj")
    private Timestamp jdkssj;
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
     * 原组织
     */
    @TableField(value = "ormorgname")
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 原岗位
     */
    @TableField(value = "ormygw")
    @JSONField(name = "ormygw")
    @JsonProperty("ormygw")
    private String ormygw;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimdistirbutionname")
    @JsonProperty("pimdistirbutionname")
    private String pimdistirbutionname;
    /**
     * 标题
     */
    @TableField(exist = false)
    @JSONField(name = "pcmddsqdname")
    @JsonProperty("pcmddsqdname")
    private String pcmddsqdname;
    /**
     * 原职务
     */
    @TableField(value = "ormyzw")
    @JSONField(name = "ormyzw")
    @JsonProperty("ormyzw")
    private String ormyzw;
    /**
     * 新部门/项目
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorname")
    @JsonProperty("orgsectorname")
    private String orgsectorname;
    /**
     * 新职务
     */
    @TableField(exist = false)
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;
    /**
     * 岗位
     */
    @TableField(exist = false)
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;
    /**
     * 原部门/项目
     */
    @TableField(value = "ormorgsectorname")
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 岗位ID
     */
    @TableField(value = "ormpostid")
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;
    /**
     * 职务ID
     */
    @TableField(value = "ormdutyid")
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;
    /**
     * 组织机构标识
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 调动申请单标识
     */
    @TableField(value = "pcmddsqdid")
    @JSONField(name = "pcmddsqdid")
    @JsonProperty("pcmddsqdid")
    private String pcmddsqdid;
    /**
     * 分配信息标识
     */
    @TableField(value = "pimdistirbutionid")
    @JSONField(name = "pimdistirbutionid")
    @JsonProperty("pimdistirbutionid")
    private String pimdistirbutionid;
    /**
     * 部门标识
     */
    @DEField(preType = DEPredefinedFieldType.ORGSECTORID)
    @TableField(value = "orgsectorid")
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

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
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 岗位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost;

    /**
     * 调动申请单
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmDdsqd pcmddsqd;

    /**
     * 任职分配
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimDistirbution pimdistirbution;



    /**
     * 设置 [完成调动]
     */
    public void setFinishdd(Integer finishdd){
        this.finishdd = finishdd ;
        this.modify("finishdd",finishdd);
    }

    /**
     * 设置 [审核状态]
     */
    public void setCheckstatus(String checkstatus){
        this.checkstatus = checkstatus ;
        this.modify("checkstatus",checkstatus);
    }

    /**
     * 设置 [类型]
     */
    public void setLx(String lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [是否干部调动]
     */
    public void setSfgbdd(Integer sfgbdd){
        this.sfgbdd = sfgbdd ;
        this.modify("sfgbdd",sfgbdd);
    }

    /**
     * 设置 [借调结束时间]
     */
    public void setJdjssj(Timestamp jdjssj){
        this.jdjssj = jdjssj ;
        this.modify("jdjssj",jdjssj);
    }

    /**
     * 格式化日期 [借调结束时间]
     */
    public String formatJdjssj(){
        if (this.jdjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jdjssj);
    }
    /**
     * 设置 [生效日期]
     */
    public void setSxrq(Timestamp sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 格式化日期 [生效日期]
     */
    public String formatSxrq(){
        if (this.sxrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sxrq);
    }
    /**
     * 设置 [是否局总部]
     */
    public void setSfjzb(Integer sfjzb){
        this.sfjzb = sfjzb ;
        this.modify("sfjzb",sfjzb);
    }

    /**
     * 设置 [调动类型（更新、修正）]
     */
    public void setDdtype(String ddtype){
        this.ddtype = ddtype ;
        this.modify("ddtype",ddtype);
    }

    /**
     * 设置 [任职文件]
     */
    public void setRzwj(String rzwj){
        this.rzwj = rzwj ;
        this.modify("rzwj",rzwj);
    }

    /**
     * 设置 [调动申请单明细名称]
     */
    public void setPcmddsqdmxname(String pcmddsqdmxname){
        this.pcmddsqdmxname = pcmddsqdmxname ;
        this.modify("pcmddsqdmxname",pcmddsqdmxname);
    }

    /**
     * 设置 [借调开始时间]
     */
    public void setJdkssj(Timestamp jdkssj){
        this.jdkssj = jdkssj ;
        this.modify("jdkssj",jdkssj);
    }

    /**
     * 格式化日期 [借调开始时间]
     */
    public String formatJdkssj(){
        if (this.jdkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jdkssj);
    }
    /**
     * 设置 [原组织]
     */
    public void setOrmorgname(String ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [原岗位]
     */
    public void setOrmygw(String ormygw){
        this.ormygw = ormygw ;
        this.modify("ormygw",ormygw);
    }

    /**
     * 设置 [原职务]
     */
    public void setOrmyzw(String ormyzw){
        this.ormyzw = ormyzw ;
        this.modify("ormyzw",ormyzw);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [原部门/项目]
     */
    public void setOrmorgsectorname(String ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
    }

    /**
     * 设置 [岗位ID]
     */
    public void setOrmpostid(String ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [职务ID]
     */
    public void setOrmdutyid(String ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [调动申请单标识]
     */
    public void setPcmddsqdid(String pcmddsqdid){
        this.pcmddsqdid = pcmddsqdid ;
        this.modify("pcmddsqdid",pcmddsqdid);
    }

    /**
     * 设置 [分配信息标识]
     */
    public void setPimdistirbutionid(String pimdistirbutionid){
        this.pimdistirbutionid = pimdistirbutionid ;
        this.modify("pimdistirbutionid",pimdistirbutionid);
    }


}


