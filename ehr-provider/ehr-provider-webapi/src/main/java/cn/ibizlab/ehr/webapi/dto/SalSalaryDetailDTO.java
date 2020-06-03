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
 * 服务DTO对象[SalSalaryDetailDTO]
 */
@Data
public class SalSalaryDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SALSALARYDETAILNAME]
     *
     */
    @JSONField(name = "salsalarydetailname")
    @JsonProperty("salsalarydetailname")
    private String salsalarydetailname;

    /**
     * 属性 [SALSALARYDETAILID]
     *
     */
    @JSONField(name = "salsalarydetailid")
    @JsonProperty("salsalarydetailid")
    private String salsalarydetailid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [YWZ]
     *
     */
    @JSONField(name = "ywz")
    @JsonProperty("ywz")
    private String ywz;

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
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [YWMS]
     *
     */
    @JSONField(name = "ywms")
    @JsonProperty("ywms")
    private String ywms;

    /**
     * 属性 [XC]
     *
     */
    @JSONField(name = "xc")
    @JsonProperty("xc")
    private Double xc;

    /**
     * 属性 [SALSALARYNAME]
     *
     */
    @JSONField(name = "salsalaryname")
    @JsonProperty("salsalaryname")
    private String salsalaryname;

    /**
     * 属性 [SALSCHEMEITEMNAME]
     *
     */
    @JSONField(name = "salschemeitemname")
    @JsonProperty("salschemeitemname")
    private String salschemeitemname;

    /**
     * 属性 [SALSCHEMEITEMID]
     *
     */
    @JSONField(name = "salschemeitemid")
    @JsonProperty("salschemeitemid")
    private String salschemeitemid;

    /**
     * 属性 [SALSALARYID]
     *
     */
    @JSONField(name = "salsalaryid")
    @JsonProperty("salsalaryid")
    private String salsalaryid;


    /**
     * 设置 [SALSALARYDETAILNAME]
     */
    public void setSalsalarydetailname(String  salsalarydetailname){
        this.salsalarydetailname = salsalarydetailname ;
        this.modify("salsalarydetailname",salsalarydetailname);
    }

    /**
     * 设置 [YWZ]
     */
    public void setYwz(String  ywz){
        this.ywz = ywz ;
        this.modify("ywz",ywz);
    }

    /**
     * 设置 [YWMS]
     */
    public void setYwms(String  ywms){
        this.ywms = ywms ;
        this.modify("ywms",ywms);
    }

    /**
     * 设置 [XC]
     */
    public void setXc(Double  xc){
        this.xc = xc ;
        this.modify("xc",xc);
    }

    /**
     * 设置 [SALSCHEMEITEMID]
     */
    public void setSalschemeitemid(String  salschemeitemid){
        this.salschemeitemid = salschemeitemid ;
        this.modify("salschemeitemid",salschemeitemid);
    }

    /**
     * 设置 [SALSALARYID]
     */
    public void setSalsalaryid(String  salsalaryid){
        this.salsalaryid = salsalaryid ;
        this.modify("salsalaryid",salsalaryid);
    }


}

