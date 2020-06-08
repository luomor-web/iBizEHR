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
 * 服务DTO对象[VacUseNxjmxDTO]
 */
@Data
public class VacUseNxjmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [VACSYNJCXID]
     *
     */
    @JSONField(name = "vacsynjcxid")
    @JsonProperty("vacsynjcxid")
    private String vacsynjcxid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [VACUSENXJMXID]
     *
     */
    @JSONField(name = "vacusenxjmxid")
    @JsonProperty("vacusenxjmxid")
    private String vacusenxjmxid;

    /**
     * 属性 [VACUSENXJMXNAME]
     *
     */
    @JSONField(name = "vacusenxjmxname")
    @JsonProperty("vacusenxjmxname")
    private String vacusenxjmxname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [BCNXJTS]
     *
     */
    @JSONField(name = "bcnxjts")
    @JsonProperty("bcnxjts")
    private Double bcnxjts;

    /**
     * 属性 [QJZL]
     *
     */
    @JSONField(name = "qjzl")
    @JsonProperty("qjzl")
    private String qjzl;

    /**
     * 属性 [VACLEAVEDETAILID]
     *
     */
    @JSONField(name = "vacleavedetailid")
    @JsonProperty("vacleavedetailid")
    private String vacleavedetailid;


    /**
     * 设置 [VACSYNJCXID]
     */
    public void setVacsynjcxid(String  vacsynjcxid){
        this.vacsynjcxid = vacsynjcxid ;
        this.modify("vacsynjcxid",vacsynjcxid);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [VACUSENXJMXNAME]
     */
    public void setVacusenxjmxname(String  vacusenxjmxname){
        this.vacusenxjmxname = vacusenxjmxname ;
        this.modify("vacusenxjmxname",vacusenxjmxname);
    }

    /**
     * 设置 [BCNXJTS]
     */
    public void setBcnxjts(Double  bcnxjts){
        this.bcnxjts = bcnxjts ;
        this.modify("bcnxjts",bcnxjts);
    }

    /**
     * 设置 [QJZL]
     */
    public void setQjzl(String  qjzl){
        this.qjzl = qjzl ;
        this.modify("qjzl",qjzl);
    }

    /**
     * 设置 [VACLEAVEDETAILID]
     */
    public void setVacleavedetailid(String  vacleavedetailid){
        this.vacleavedetailid = vacleavedetailid ;
        this.modify("vacleavedetailid",vacleavedetailid);
    }


}

