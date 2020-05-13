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
 * 服务DTO对象[UserDGThemeDTO]
 */
@Data
public class UserDGThemeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DATAGRIDID]
     *
     */
    @JSONField(name = "datagridid")
    @JsonProperty("datagridid")
    private String datagridid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [USERDGTHEMEID]
     *
     */
    @JSONField(name = "userdgthemeid")
    @JsonProperty("userdgthemeid")
    private String userdgthemeid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [DGTHEMEMODEL]
     *
     */
    @JSONField(name = "dgthememodel")
    @JsonProperty("dgthememodel")
    private String dgthememodel;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [PROJECTID]
     *
     */
    @JSONField(name = "projectid")
    @JsonProperty("projectid")
    private String projectid;

    /**
     * 属性 [PERSONID]
     *
     */
    @JSONField(name = "personid")
    @JsonProperty("personid")
    private String personid;

    /**
     * 属性 [USERDGTHEMENAME]
     *
     */
    @JSONField(name = "userdgthemename")
    @JsonProperty("userdgthemename")
    private String userdgthemename;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 设置 [DATAGRIDID]
     */
    public void setDatagridid(String  datagridid){
        this.datagridid = datagridid ;
        this.modify("datagridid",datagridid);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [DGTHEMEMODEL]
     */
    public void setDgthememodel(String  dgthememodel){
        this.dgthememodel = dgthememodel ;
        this.modify("dgthememodel",dgthememodel);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [PROJECTID]
     */
    public void setProjectid(String  projectid){
        this.projectid = projectid ;
        this.modify("projectid",projectid);
    }

    /**
     * 设置 [PERSONID]
     */
    public void setPersonid(String  personid){
        this.personid = personid ;
        this.modify("personid",personid);
    }

    /**
     * 设置 [USERDGTHEMENAME]
     */
    public void setUserdgthemename(String  userdgthemename){
        this.userdgthemename = userdgthemename ;
        this.modify("userdgthemename",userdgthemename);
    }


}

