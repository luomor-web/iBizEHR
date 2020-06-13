package cn.ibizlab.ehr.core.soc.domain;

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
 * 实体[个人社保福利]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SOCWELFAREINFO",resultMap = "SocWelfareInfoResultMap")
public class SocWelfareInfo extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
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
     * 失效时间
     */
    @TableField(value = "sxsj2")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxsj2" , format="yyyy-MM-dd")
    @JsonProperty("sxsj2")
    private Timestamp sxsj2;
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
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 个人公积金账号
     */
    @TableField(value = "grgjjzh")
    @JSONField(name = "grgjjzh")
    @JsonProperty("grgjjzh")
    private String grgjjzh;
    /**
     * 个人社保账号
     */
    @TableField(value = "grsbzh")
    @JSONField(name = "grsbzh")
    @JsonProperty("grsbzh")
    private String grsbzh;
    /**
     * 个人社保福利名称
     */
    @TableField(value = "socwelfareinfoname")
    @JSONField(name = "socwelfareinfoname")
    @JsonProperty("socwelfareinfoname")
    private String socwelfareinfoname;
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
     * 个人社保福利标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "socwelfareinfoid",type=IdType.UUID)
    @JSONField(name = "socwelfareinfoid")
    @JsonProperty("socwelfareinfoid")
    private String socwelfareinfoid;
    /**
     * 生效时间
     */
    @TableField(value = "sxsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxsj" , format="yyyy-MM-dd")
    @JsonProperty("sxsj")
    private Timestamp sxsj;
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
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 参保地
     */
    @TableField(exist = false)
    @JSONField(name = "socselfarebasename")
    @JsonProperty("socselfarebasename")
    private String socselfarebasename;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 单位社保账户名称
     */
    @TableField(exist = false)
    @JSONField(name = "soccompanywelname")
    @JsonProperty("soccompanywelname")
    private String soccompanywelname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 单位社保账户标识
     */
    @TableField(value = "soccompanywelid")
    @JSONField(name = "soccompanywelid")
    @JsonProperty("soccompanywelid")
    private String soccompanywelid;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 单位社保账户
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.soc.domain.SocCompanyWel soccompanywel;



    /**
     * 设置 [失效时间]
     */
    public void setSxsj2(Timestamp sxsj2){
        this.sxsj2 = sxsj2 ;
        this.modify("sxsj2",sxsj2);
    }

    /**
     * 格式化日期 [失效时间]
     */
    public String formatSxsj2(){
        if (this.sxsj2 == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sxsj2);
    }
    /**
     * 设置 [个人公积金账号]
     */
    public void setGrgjjzh(String grgjjzh){
        this.grgjjzh = grgjjzh ;
        this.modify("grgjjzh",grgjjzh);
    }

    /**
     * 设置 [个人社保账号]
     */
    public void setGrsbzh(String grsbzh){
        this.grsbzh = grsbzh ;
        this.modify("grsbzh",grsbzh);
    }

    /**
     * 设置 [个人社保福利名称]
     */
    public void setSocwelfareinfoname(String socwelfareinfoname){
        this.socwelfareinfoname = socwelfareinfoname ;
        this.modify("socwelfareinfoname",socwelfareinfoname);
    }

    /**
     * 设置 [生效时间]
     */
    public void setSxsj(Timestamp sxsj){
        this.sxsj = sxsj ;
        this.modify("sxsj",sxsj);
    }

    /**
     * 格式化日期 [生效时间]
     */
    public String formatSxsj(){
        if (this.sxsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sxsj);
    }
    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [单位社保账户标识]
     */
    public void setSoccompanywelid(String soccompanywelid){
        this.soccompanywelid = soccompanywelid ;
        this.modify("soccompanywelid",soccompanywelid);
    }


}


