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
 * 实体[专利信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMPATENT",resultMap = "PimPatentResultMap")
public class PimPatent extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专利号(*)
     */
    @TableField(value = "zlh")
    @JSONField(name = "zlh")
    @JsonProperty("zlh")
    private String zlh;
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
     * 专利信息编码
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimpatentid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimpatentid")
    @JsonProperty("pimpatentid")
    private String pimpatentid;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 记录所属
     */
    @TableField(value = "jlss")
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 专利获取时间(*)
     */
    @TableField(value = "zlhqsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zlhqsj" , format="yyyy-MM-dd")
    @JsonProperty("zlhqsj")
    private Timestamp zlhqsj;
    /**
     * 审批状态
     */
    @TableField(value = "jlspzt")
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;
    /**
     * 记录操作者
     */
    @TableField(value = "jlczz")
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;
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
     * 专利名称(*)
     */
    @TableField(value = "pimpatentname")
    @JSONField(name = "pimpatentname")
    @JsonProperty("pimpatentname")
    private String pimpatentname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 记录管理编号
     */
    @TableField(value = "jlglbh")
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;
    /**
     * 拒绝原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 附件
     */
    @TableField(value = "enclolure")
    @JSONField(name = "enclolure")
    @JsonProperty("enclolure")
    private String enclolure;
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
     * 专利批准国别(*)
     */
    @TableField(value = "zlpzgb")
    @JSONField(name = "zlpzgb")
    @JsonProperty("zlpzgb")
    private String zlpzgb;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 组织标识
     */
    @TableField(exist = false)
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
     * 专利信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [专利号(*)]
     */
    public void setZlh(String zlh){
        this.zlh = zlh ;
        this.modify("zlh",zlh);
    }

    /**
     * 设置 [记录所属]
     */
    public void setJlss(String jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [专利获取时间(*)]
     */
    public void setZlhqsj(Timestamp zlhqsj){
        this.zlhqsj = zlhqsj ;
        this.modify("zlhqsj",zlhqsj);
    }

    /**
     * 格式化日期 [专利获取时间(*)]
     */
    public String formatZlhqsj(){
        if (this.zlhqsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(zlhqsj);
    }
    /**
     * 设置 [审批状态]
     */
    public void setJlspzt(String jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [记录操作者]
     */
    public void setJlczz(String jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [专利名称(*)]
     */
    public void setPimpatentname(String pimpatentname){
        this.pimpatentname = pimpatentname ;
        this.modify("pimpatentname",pimpatentname);
    }

    /**
     * 设置 [记录管理编号]
     */
    public void setJlglbh(String jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [拒绝原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [附件]
     */
    public void setEnclolure(String enclolure){
        this.enclolure = enclolure ;
        this.modify("enclolure",enclolure);
    }

    /**
     * 设置 [专利批准国别(*)]
     */
    public void setZlpzgb(String zlpzgb){
        this.zlpzgb = zlpzgb ;
        this.modify("zlpzgb",zlpzgb);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


