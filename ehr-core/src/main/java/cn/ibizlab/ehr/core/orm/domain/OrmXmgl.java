package cn.ibizlab.ehr.core.orm.domain;

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
 * 实体[项目管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMXMGL",resultMap = "OrmXmglResultMap")
public class OrmXmgl extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * EHR组织ID
     */
    @DEField(name = "ehr_org_id")
    @TableField(value = "ehr_org_id")
    @JSONField(name = "ehr_org_id")
    @JsonProperty("ehr_org_id")
    private String ehrOrgId;
    /**
     * 项目结束时间
     */
    @DEField(name = "target_finish_date")
    @TableField(value = "target_finish_date")
    @JSONField(name = "target_finish_date")
    @JsonProperty("target_finish_date")
    private String targetFinishDate;
    /**
     * 是否局直管
     */
    @TableField(value = "isdirectlymanage")
    @JSONField(name = "isdirectlymanage")
    @JsonProperty("isdirectlymanage")
    private String isdirectlymanage;
    /**
     * 项目名称
     */
    @DEField(name = "project_name")
    @TableField(value = "project_name")
    @JSONField(name = "project_name")
    @JsonProperty("project_name")
    private String projectName;
    /**
     * 项目名称
     */
    @TableField(value = "ormxmglname")
    @JSONField(name = "ormxmglname")
    @JsonProperty("ormxmglname")
    private String ormxmglname;
    /**
     * 工程业务类型
     */
    @TableField(value = "engineeringbustype")
    @JSONField(name = "engineeringbustype")
    @JsonProperty("engineeringbustype")
    private String engineeringbustype;
    /**
     * 项目类型
     */
    @DEField(name = "project_type")
    @TableField(value = "project_type")
    @JSONField(name = "project_type")
    @JsonProperty("project_type")
    private String projectType;
    /**
     * 项目状态
     */
    @DEField(name = "project_status_code")
    @TableField(value = "project_status_code")
    @JSONField(name = "project_status_code")
    @JsonProperty("project_status_code")
    private String projectStatusCode;
    /**
     * 项目状态释义
     */
    @DEField(name = "project_status_name")
    @TableField(value = "project_status_name")
    @JSONField(name = "project_status_name")
    @JsonProperty("project_status_name")
    private String projectStatusName;
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
     * 工程规模
     */
    @TableField(value = "engineeringscale")
    @JSONField(name = "engineeringscale")
    @JsonProperty("engineeringscale")
    private String engineeringscale;
    /**
     * 工程用途
     */
    @TableField(value = "engineeringpurpose")
    @JSONField(name = "engineeringpurpose")
    @JsonProperty("engineeringpurpose")
    private String engineeringpurpose;
    /**
     * 项目规模
     */
    @DEField(name = "project_size")
    @TableField(value = "project_size")
    @JSONField(name = "project_size")
    @JsonProperty("project_size")
    private String projectSize;
    /**
     * 项目管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormxmglid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormxmglid")
    @JsonProperty("ormxmglid")
    private String ormxmglid;
    /**
     * 项目备用属性
     */
    @TableField(value = "xmbh")
    @JSONField(name = "xmbh")
    @JsonProperty("xmbh")
    private String xmbh;
    /**
     * 项目全称
     */
    @DEField(name = "project_full_name")
    @TableField(value = "project_full_name")
    @JSONField(name = "project_full_name")
    @JsonProperty("project_full_name")
    private String projectFullName;
    /**
     * ERP组织ID
     */
    @DEField(name = "org_id")
    @TableField(value = "org_id")
    @JSONField(name = "org_id")
    @JsonProperty("org_id")
    private String orgId;
    /**
     * 项目资金属性
     */
    @TableField(value = "procapitalatt")
    @JSONField(name = "procapitalatt")
    @JsonProperty("procapitalatt")
    private String procapitalatt;
    /**
     * 项目编号
     */
    @DEField(name = "project_number")
    @TableField(value = "project_number")
    @JSONField(name = "project_number")
    @JsonProperty("project_number")
    private String projectNumber;
    /**
     * 项目开始时间
     */
    @DEField(name = "target_start_date")
    @TableField(value = "target_start_date")
    @JSONField(name = "target_start_date")
    @JsonProperty("target_start_date")
    private String targetStartDate;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 设置 [EHR组织ID]
     */
    public void setEhrOrgId(String ehrOrgId){
        this.ehrOrgId = ehrOrgId ;
        this.modify("ehr_org_id",ehrOrgId);
    }

    /**
     * 设置 [项目结束时间]
     */
    public void setTargetFinishDate(String targetFinishDate){
        this.targetFinishDate = targetFinishDate ;
        this.modify("target_finish_date",targetFinishDate);
    }

    /**
     * 设置 [是否局直管]
     */
    public void setIsdirectlymanage(String isdirectlymanage){
        this.isdirectlymanage = isdirectlymanage ;
        this.modify("isdirectlymanage",isdirectlymanage);
    }

    /**
     * 设置 [项目名称]
     */
    public void setProjectName(String projectName){
        this.projectName = projectName ;
        this.modify("project_name",projectName);
    }

    /**
     * 设置 [项目名称]
     */
    public void setOrmxmglname(String ormxmglname){
        this.ormxmglname = ormxmglname ;
        this.modify("ormxmglname",ormxmglname);
    }

    /**
     * 设置 [工程业务类型]
     */
    public void setEngineeringbustype(String engineeringbustype){
        this.engineeringbustype = engineeringbustype ;
        this.modify("engineeringbustype",engineeringbustype);
    }

    /**
     * 设置 [项目类型]
     */
    public void setProjectType(String projectType){
        this.projectType = projectType ;
        this.modify("project_type",projectType);
    }

    /**
     * 设置 [项目状态]
     */
    public void setProjectStatusCode(String projectStatusCode){
        this.projectStatusCode = projectStatusCode ;
        this.modify("project_status_code",projectStatusCode);
    }

    /**
     * 设置 [项目状态释义]
     */
    public void setProjectStatusName(String projectStatusName){
        this.projectStatusName = projectStatusName ;
        this.modify("project_status_name",projectStatusName);
    }

    /**
     * 设置 [工程规模]
     */
    public void setEngineeringscale(String engineeringscale){
        this.engineeringscale = engineeringscale ;
        this.modify("engineeringscale",engineeringscale);
    }

    /**
     * 设置 [工程用途]
     */
    public void setEngineeringpurpose(String engineeringpurpose){
        this.engineeringpurpose = engineeringpurpose ;
        this.modify("engineeringpurpose",engineeringpurpose);
    }

    /**
     * 设置 [项目规模]
     */
    public void setProjectSize(String projectSize){
        this.projectSize = projectSize ;
        this.modify("project_size",projectSize);
    }

    /**
     * 设置 [项目备用属性]
     */
    public void setXmbh(String xmbh){
        this.xmbh = xmbh ;
        this.modify("xmbh",xmbh);
    }

    /**
     * 设置 [项目全称]
     */
    public void setProjectFullName(String projectFullName){
        this.projectFullName = projectFullName ;
        this.modify("project_full_name",projectFullName);
    }

    /**
     * 设置 [ERP组织ID]
     */
    public void setOrgId(String orgId){
        this.orgId = orgId ;
        this.modify("org_id",orgId);
    }

    /**
     * 设置 [项目资金属性]
     */
    public void setProcapitalatt(String procapitalatt){
        this.procapitalatt = procapitalatt ;
        this.modify("procapitalatt",procapitalatt);
    }

    /**
     * 设置 [项目编号]
     */
    public void setProjectNumber(String projectNumber){
        this.projectNumber = projectNumber ;
        this.modify("project_number",projectNumber);
    }

    /**
     * 设置 [项目开始时间]
     */
    public void setTargetStartDate(String targetStartDate){
        this.targetStartDate = targetStartDate ;
        this.modify("target_start_date",targetStartDate);
    }


}


