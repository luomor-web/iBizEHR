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
 * 服务DTO对象[OrmUnitedPersonDTO]
 */
@Data
public class OrmUnitedPersonDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [USERNAME]
     *
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;

    /**
     * 属性 [UNITEDPERSONNAME]
     *
     */
    @JSONField(name = "unitedpersonname")
    @JsonProperty("unitedpersonname")
    private String unitedpersonname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ISEMPLOYEE]
     *
     */
    @JSONField(name = "isemployee")
    @JsonProperty("isemployee")
    private String isemployee;

    /**
     * 属性 [REFERMARK]
     *
     */
    @JSONField(name = "refermark")
    @JsonProperty("refermark")
    private String refermark;

    /**
     * 属性 [SEX]
     *
     */
    @JSONField(name = "sex")
    @JsonProperty("sex")
    private String sex;

    /**
     * 属性 [EMPLOYEENAME]
     *
     */
    @JSONField(name = "employeename")
    @JsonProperty("employeename")
    private String employeename;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [UNITEDPERSONID]
     *
     */
    @JSONField(name = "unitedpersonid")
    @JsonProperty("unitedpersonid")
    private String unitedpersonid;

    /**
     * 属性 [FULLNAME]
     *
     */
    @JSONField(name = "fullname")
    @JsonProperty("fullname")
    private String fullname;

    /**
     * 属性 [EMPID]
     *
     */
    @JSONField(name = "empid")
    @JsonProperty("empid")
    private String empid;

    /**
     * 属性 [EHREMPID]
     *
     */
    @JSONField(name = "ehrempid")
    @JsonProperty("ehrempid")
    private String ehrempid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [IDNUMBER]
     *
     */
    @JSONField(name = "idnumber")
    @JsonProperty("idnumber")
    private String idnumber;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [EMPLOYEENUMBER]
     *
     */
    @JSONField(name = "employeenumber")
    @JsonProperty("employeenumber")
    private String employeenumber;


    /**
     * 设置 [USERNAME]
     */
    public void setUsername(String  username){
        this.username = username ;
        this.modify("username",username);
    }

    /**
     * 设置 [UNITEDPERSONNAME]
     */
    public void setUnitedpersonname(String  unitedpersonname){
        this.unitedpersonname = unitedpersonname ;
        this.modify("unitedpersonname",unitedpersonname);
    }

    /**
     * 设置 [ISEMPLOYEE]
     */
    public void setIsemployee(String  isemployee){
        this.isemployee = isemployee ;
        this.modify("isemployee",isemployee);
    }

    /**
     * 设置 [REFERMARK]
     */
    public void setRefermark(String  refermark){
        this.refermark = refermark ;
        this.modify("refermark",refermark);
    }

    /**
     * 设置 [SEX]
     */
    public void setSex(String  sex){
        this.sex = sex ;
        this.modify("sex",sex);
    }

    /**
     * 设置 [EMPLOYEENAME]
     */
    public void setEmployeename(String  employeename){
        this.employeename = employeename ;
        this.modify("employeename",employeename);
    }

    /**
     * 设置 [FULLNAME]
     */
    public void setFullname(String  fullname){
        this.fullname = fullname ;
        this.modify("fullname",fullname);
    }

    /**
     * 设置 [EMPID]
     */
    public void setEmpid(String  empid){
        this.empid = empid ;
        this.modify("empid",empid);
    }

    /**
     * 设置 [EHREMPID]
     */
    public void setEhrempid(String  ehrempid){
        this.ehrempid = ehrempid ;
        this.modify("ehrempid",ehrempid);
    }

    /**
     * 设置 [IDNUMBER]
     */
    public void setIdnumber(String  idnumber){
        this.idnumber = idnumber ;
        this.modify("idnumber",idnumber);
    }

    /**
     * 设置 [EMPLOYEENUMBER]
     */
    public void setEmployeenumber(String  employeenumber){
        this.employeenumber = employeenumber ;
        this.modify("employeenumber",employeenumber);
    }


}

