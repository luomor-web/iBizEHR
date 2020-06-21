package cn.ibizlab.ehr.core.vac.domain;

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
 * 实体[年休假查询]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_VACSYNJCX",resultMap = "VacSynjcxResultMap")
public class VacSynjcx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 年休假查询标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "vacsynjcxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "vacsynjcxid")
    @JsonProperty("vacsynjcxid")
    private String vacsynjcxid;
    /**
     * 已用天数
     */
    @TableField(value = "yynj")
    @JSONField(name = "yynj")
    @JsonProperty("yynj")
    private Double yynj;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 剩余天数
     */
    @TableField(value = "synjts")
    @JSONField(name = "synjts")
    @JsonProperty("synjts")
    private Double synjts;
    /**
     * 应休天数
     */
    @TableField(value = "bnts")
    @JSONField(name = "bnts")
    @JsonProperty("bnts")
    private Double bnts;
    /**
     * 开始有效时间
     */
    @TableField(value = "ksyxsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ksyxsj" , format="yyyy-MM-dd")
    @JsonProperty("ksyxsj")
    private Timestamp ksyxsj;
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
     * 年休假查询名称
     */
    @TableField(value = "vacsynjcxname")
    @JSONField(name = "vacsynjcxname")
    @JsonProperty("vacsynjcxname")
    private String vacsynjcxname;
    /**
     * 实休天数
     */
    @TableField(value = "sjbnts")
    @JSONField(name = "sjbnts")
    @JsonProperty("sjbnts")
    private Double sjbnts;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 结束有效时间
     */
    @TableField(value = "jsyxsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsyxsj" , format="yyyy-MM-dd")
    @JsonProperty("jsyxsj")
    private Timestamp jsyxsj;
    /**
     * 补偿天数（停用）
     */
    @TableField(value = "bcts")
    @JSONField(name = "bcts")
    @JsonProperty("bcts")
    private Double bcts;
    /**
     * 组织id
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 工龄（年）
     */
    @TableField(exist = false)
    @JSONField(name = "gly")
    @JsonProperty("gly")
    private Integer gly;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 员工信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [已用天数]
     */
    public void setYynj(Double yynj){
        this.yynj = yynj ;
        this.modify("yynj",yynj);
    }

    /**
     * 设置 [剩余天数]
     */
    public void setSynjts(Double synjts){
        this.synjts = synjts ;
        this.modify("synjts",synjts);
    }

    /**
     * 设置 [应休天数]
     */
    public void setBnts(Double bnts){
        this.bnts = bnts ;
        this.modify("bnts",bnts);
    }

    /**
     * 设置 [开始有效时间]
     */
    public void setKsyxsj(Timestamp ksyxsj){
        this.ksyxsj = ksyxsj ;
        this.modify("ksyxsj",ksyxsj);
    }

    /**
     * 格式化日期 [开始有效时间]
     */
    public String formatKsyxsj(){
        if (this.ksyxsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(ksyxsj);
    }
    /**
     * 设置 [年休假查询名称]
     */
    public void setVacsynjcxname(String vacsynjcxname){
        this.vacsynjcxname = vacsynjcxname ;
        this.modify("vacsynjcxname",vacsynjcxname);
    }

    /**
     * 设置 [实休天数]
     */
    public void setSjbnts(Double sjbnts){
        this.sjbnts = sjbnts ;
        this.modify("sjbnts",sjbnts);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [结束有效时间]
     */
    public void setJsyxsj(Timestamp jsyxsj){
        this.jsyxsj = jsyxsj ;
        this.modify("jsyxsj",jsyxsj);
    }

    /**
     * 格式化日期 [结束有效时间]
     */
    public String formatJsyxsj(){
        if (this.jsyxsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jsyxsj);
    }
    /**
     * 设置 [补偿天数（停用）]
     */
    public void setBcts(Double bcts){
        this.bcts = bcts ;
        this.modify("bcts",bcts);
    }

    /**
     * 设置 [员工信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


