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
 * 实体[出入境管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMEXITANDENTRY",resultMap = "PimExitandentryResultMap")
public class PimExitandentry extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型
     */
    @TableField(value = "lx")
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 出（国）境时间
     */
    @TableField(value = "cjsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cjsj" , format="yyyy-MM-dd")
    @JsonProperty("cjsj")
    private Timestamp cjsj;
    /**
     * 记录所属
     */
    @TableField(value = "jlss")
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
    /**
     * 部门
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 流程状态
     */
    @TableField(value = "workflowstate")
    @JSONField(name = "workflowstate")
    @JsonProperty("workflowstate")
    private String workflowstate;
    /**
     * 出入境管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimexitandentryid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimexitandentryid")
    @JsonProperty("pimexitandentryid")
    private String pimexitandentryid;
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
     * 出入境管理名称
     */
    @TableField(value = "pimexitandentryname")
    @JSONField(name = "pimexitandentryname")
    @JsonProperty("pimexitandentryname")
    private String pimexitandentryname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 事由
     */
    @TableField(value = "sy")
    @JSONField(name = "sy")
    @JsonProperty("sy")
    private String sy;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 入（国）境时间
     */
    @TableField(value = "rjsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rjsj" , format="yyyy-MM-dd")
    @JsonProperty("rjsj")
    private Timestamp rjsj;
    /**
     * 目的国家/地区
     */
    @TableField(value = "qwfhgj")
    @JSONField(name = "qwfhgj")
    @JsonProperty("qwfhgj")
    private String qwfhgj;
    /**
     * 回填结果
     */
    @TableField(value = "wfresult")
    @JSONField(name = "wfresult")
    @JsonProperty("wfresult")
    private String wfresult;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 职务
     */
    @TableField(exist = false)
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 职级
     */
    @TableField(exist = false)
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [类型]
     */
    public void setLx(String lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [出（国）境时间]
     */
    public void setCjsj(Timestamp cjsj){
        this.cjsj = cjsj ;
        this.modify("cjsj",cjsj);
    }

    /**
     * 格式化日期 [出（国）境时间]
     */
    public String formatCjsj(){
        if (this.cjsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cjsj);
    }
    /**
     * 设置 [记录所属]
     */
    public void setJlss(String jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [流程状态]
     */
    public void setWorkflowstate(String workflowstate){
        this.workflowstate = workflowstate ;
        this.modify("workflowstate",workflowstate);
    }

    /**
     * 设置 [出入境管理名称]
     */
    public void setPimexitandentryname(String pimexitandentryname){
        this.pimexitandentryname = pimexitandentryname ;
        this.modify("pimexitandentryname",pimexitandentryname);
    }

    /**
     * 设置 [事由]
     */
    public void setSy(String sy){
        this.sy = sy ;
        this.modify("sy",sy);
    }

    /**
     * 设置 [入（国）境时间]
     */
    public void setRjsj(Timestamp rjsj){
        this.rjsj = rjsj ;
        this.modify("rjsj",rjsj);
    }

    /**
     * 格式化日期 [入（国）境时间]
     */
    public String formatRjsj(){
        if (this.rjsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(rjsj);
    }
    /**
     * 设置 [目的国家/地区]
     */
    public void setQwfhgj(String qwfhgj){
        this.qwfhgj = qwfhgj ;
        this.modify("qwfhgj",qwfhgj);
    }

    /**
     * 设置 [回填结果]
     */
    public void setWfresult(String wfresult){
        this.wfresult = wfresult ;
        this.modify("wfresult",wfresult);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


