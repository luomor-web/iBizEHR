package cn.ibizlab.ehr.webapi.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.ehr.util.domain.DTOBase;
import lombok.Data;

/**
 * 服务DTO对象[OrmXmglDTO]
 */
@Data
public class OrmXmglDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [EHR_ORG_ID]
     *
     */
    @JSONField(name = "ehr_org_id")
    @JsonProperty("ehr_org_id")
    private String ehrOrgId;

    /**
     * 属性 [TARGET_FINISH_DATE]
     *
     */
    @JSONField(name = "target_finish_date")
    @JsonProperty("target_finish_date")
    private String targetFinishDate;

    /**
     * 属性 [ISDIRECTLYMANAGE]
     *
     */
    @JSONField(name = "isdirectlymanage")
    @JsonProperty("isdirectlymanage")
    private String isdirectlymanage;

    /**
     * 属性 [PROJECT_NAME]
     *
     */
    @JSONField(name = "project_name")
    @JsonProperty("project_name")
    private String projectName;

    /**
     * 属性 [ORMXMGLNAME]
     *
     */
    @JSONField(name = "ormxmglname")
    @JsonProperty("ormxmglname")
    private String ormxmglname;

    /**
     * 属性 [ENGINEERINGBUSTYPE]
     *
     */
    @JSONField(name = "engineeringbustype")
    @JsonProperty("engineeringbustype")
    private String engineeringbustype;

    /**
     * 属性 [PROJECT_TYPE]
     *
     */
    @JSONField(name = "project_type")
    @JsonProperty("project_type")
    private String projectType;

    /**
     * 属性 [PROJECT_STATUS_CODE]
     *
     */
    @JSONField(name = "project_status_code")
    @JsonProperty("project_status_code")
    private String projectStatusCode;

    /**
     * 属性 [PROJECT_STATUS_NAME]
     *
     */
    @JSONField(name = "project_status_name")
    @JsonProperty("project_status_name")
    private String projectStatusName;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ENGINEERINGSCALE]
     *
     */
    @JSONField(name = "engineeringscale")
    @JsonProperty("engineeringscale")
    private String engineeringscale;

    /**
     * 属性 [ENGINEERINGPURPOSE]
     *
     */
    @JSONField(name = "engineeringpurpose")
    @JsonProperty("engineeringpurpose")
    private String engineeringpurpose;

    /**
     * 属性 [PROJECT_SIZE]
     *
     */
    @JSONField(name = "project_size")
    @JsonProperty("project_size")
    private String projectSize;

    /**
     * 属性 [ORMXMGLID]
     *
     */
    @JSONField(name = "ormxmglid")
    @JsonProperty("ormxmglid")
    private String ormxmglid;

    /**
     * 属性 [XMBH]
     *
     */
    @JSONField(name = "xmbh")
    @JsonProperty("xmbh")
    private String xmbh;

    /**
     * 属性 [PROJECT_FULL_NAME]
     *
     */
    @JSONField(name = "project_full_name")
    @JsonProperty("project_full_name")
    private String projectFullName;

    /**
     * 属性 [ORG_ID]
     *
     */
    @JSONField(name = "org_id")
    @JsonProperty("org_id")
    private String orgId;

    /**
     * 属性 [PROCAPITALATT]
     *
     */
    @JSONField(name = "procapitalatt")
    @JsonProperty("procapitalatt")
    private String procapitalatt;

    /**
     * 属性 [PROJECT_NUMBER]
     *
     */
    @JSONField(name = "project_number")
    @JsonProperty("project_number")
    private String projectNumber;

    /**
     * 属性 [TARGET_START_DATE]
     *
     */
    @JSONField(name = "target_start_date")
    @JsonProperty("target_start_date")
    private String targetStartDate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 设置 [EHR_ORG_ID]
     */
    public void setEhrOrgId(String  ehrOrgId){
        this.ehrOrgId = ehrOrgId ;
        this.modify("ehr_org_id",ehrOrgId);
    }

    /**
     * 设置 [TARGET_FINISH_DATE]
     */
    public void setTargetFinishDate(String  targetFinishDate){
        this.targetFinishDate = targetFinishDate ;
        this.modify("target_finish_date",targetFinishDate);
    }

    /**
     * 设置 [ISDIRECTLYMANAGE]
     */
    public void setIsdirectlymanage(String  isdirectlymanage){
        this.isdirectlymanage = isdirectlymanage ;
        this.modify("isdirectlymanage",isdirectlymanage);
    }

    /**
     * 设置 [PROJECT_NAME]
     */
    public void setProjectName(String  projectName){
        this.projectName = projectName ;
        this.modify("project_name",projectName);
    }

    /**
     * 设置 [ORMXMGLNAME]
     */
    public void setOrmxmglname(String  ormxmglname){
        this.ormxmglname = ormxmglname ;
        this.modify("ormxmglname",ormxmglname);
    }

    /**
     * 设置 [ENGINEERINGBUSTYPE]
     */
    public void setEngineeringbustype(String  engineeringbustype){
        this.engineeringbustype = engineeringbustype ;
        this.modify("engineeringbustype",engineeringbustype);
    }

    /**
     * 设置 [PROJECT_TYPE]
     */
    public void setProjectType(String  projectType){
        this.projectType = projectType ;
        this.modify("project_type",projectType);
    }

    /**
     * 设置 [PROJECT_STATUS_CODE]
     */
    public void setProjectStatusCode(String  projectStatusCode){
        this.projectStatusCode = projectStatusCode ;
        this.modify("project_status_code",projectStatusCode);
    }

    /**
     * 设置 [PROJECT_STATUS_NAME]
     */
    public void setProjectStatusName(String  projectStatusName){
        this.projectStatusName = projectStatusName ;
        this.modify("project_status_name",projectStatusName);
    }

    /**
     * 设置 [ENGINEERINGSCALE]
     */
    public void setEngineeringscale(String  engineeringscale){
        this.engineeringscale = engineeringscale ;
        this.modify("engineeringscale",engineeringscale);
    }

    /**
     * 设置 [ENGINEERINGPURPOSE]
     */
    public void setEngineeringpurpose(String  engineeringpurpose){
        this.engineeringpurpose = engineeringpurpose ;
        this.modify("engineeringpurpose",engineeringpurpose);
    }

    /**
     * 设置 [PROJECT_SIZE]
     */
    public void setProjectSize(String  projectSize){
        this.projectSize = projectSize ;
        this.modify("project_size",projectSize);
    }

    /**
     * 设置 [XMBH]
     */
    public void setXmbh(String  xmbh){
        this.xmbh = xmbh ;
        this.modify("xmbh",xmbh);
    }

    /**
     * 设置 [PROJECT_FULL_NAME]
     */
    public void setProjectFullName(String  projectFullName){
        this.projectFullName = projectFullName ;
        this.modify("project_full_name",projectFullName);
    }

    /**
     * 设置 [ORG_ID]
     */
    public void setOrgId(String  orgId){
        this.orgId = orgId ;
        this.modify("org_id",orgId);
    }

    /**
     * 设置 [PROCAPITALATT]
     */
    public void setProcapitalatt(String  procapitalatt){
        this.procapitalatt = procapitalatt ;
        this.modify("procapitalatt",procapitalatt);
    }

    /**
     * 设置 [PROJECT_NUMBER]
     */
    public void setProjectNumber(String  projectNumber){
        this.projectNumber = projectNumber ;
        this.modify("project_number",projectNumber);
    }

    /**
     * 设置 [TARGET_START_DATE]
     */
    public void setTargetStartDate(String  targetStartDate){
        this.targetStartDate = targetStartDate ;
        this.modify("target_start_date",targetStartDate);
    }


}

