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
 * 服务DTO对象[SocArchivesDetailDTO]
 */
@Data
public class SocArchivesDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SOCARCHIVESDETAILID]
     *
     */
    @JSONField(name = "socarchivesdetailid")
    @JsonProperty("socarchivesdetailid")
    private String socarchivesdetailid;

    /**
     * 属性 [SOCARCHIVESDETAILNAME]
     *
     */
    @JSONField(name = "socarchivesdetailname")
    @JsonProperty("socarchivesdetailname")
    private String socarchivesdetailname;

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
     * 属性 [SOCARCHIVESID]
     *
     */
    @JSONField(name = "socarchivesid")
    @JsonProperty("socarchivesid")
    private String socarchivesid;

    /**
     * 属性 [SOCARCHIVESNAME]
     *
     */
    @JSONField(name = "socarchivesname")
    @JsonProperty("socarchivesname")
    private String socarchivesname;

    /**
     * 属性 [SOCRULEDETAILID]
     *
     */
    @JSONField(name = "socruledetailid")
    @JsonProperty("socruledetailid")
    private String socruledetailid;

    /**
     * 属性 [PERSONNUM]
     *
     */
    @JSONField(name = "personnum")
    @JsonProperty("personnum")
    private Double personnum;

    /**
     * 属性 [COMPANYNUM]
     *
     */
    @JSONField(name = "companynum")
    @JsonProperty("companynum")
    private Double companynum;

    /**
     * 属性 [HIGHNUM]
     *
     */
    @JSONField(name = "highnum")
    @JsonProperty("highnum")
    private Double highnum;

    /**
     * 属性 [LOWNUM]
     *
     */
    @JSONField(name = "lownum")
    @JsonProperty("lownum")
    private Double lownum;

    /**
     * 属性 [ORDERVALUE]
     *
     */
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;

    /**
     * 属性 [SOCTYPEID]
     *
     */
    @JSONField(name = "soctypeid")
    @JsonProperty("soctypeid")
    private String soctypeid;

    /**
     * 属性 [SOCTYPENAME]
     *
     */
    @JSONField(name = "soctypename")
    @JsonProperty("soctypename")
    private String soctypename;

    /**
     * 属性 [PERSONRATE]
     *
     */
    @JSONField(name = "personrate")
    @JsonProperty("personrate")
    private Double personrate;

    /**
     * 属性 [COMPANYRATE]
     *
     */
    @JSONField(name = "companyrate")
    @JsonProperty("companyrate")
    private Double companyrate;

    /**
     * 属性 [PERSONAMOUNT]
     *
     */
    @JSONField(name = "personamount")
    @JsonProperty("personamount")
    private Double personamount;

    /**
     * 属性 [COMPANYAMOUNT]
     *
     */
    @JSONField(name = "companyamount")
    @JsonProperty("companyamount")
    private Double companyamount;

    /**
     * 属性 [SOCRULEDETAILNAME]
     *
     */
    @JSONField(name = "socruledetailname")
    @JsonProperty("socruledetailname")
    private String socruledetailname;


    /**
     * 设置 [SOCARCHIVESDETAILNAME]
     */
    public void setSocarchivesdetailname(String  socarchivesdetailname){
        this.socarchivesdetailname = socarchivesdetailname ;
        this.modify("socarchivesdetailname",socarchivesdetailname);
    }

    /**
     * 设置 [SOCARCHIVESID]
     */
    public void setSocarchivesid(String  socarchivesid){
        this.socarchivesid = socarchivesid ;
        this.modify("socarchivesid",socarchivesid);
    }

    /**
     * 设置 [SOCRULEDETAILID]
     */
    public void setSocruledetailid(String  socruledetailid){
        this.socruledetailid = socruledetailid ;
        this.modify("socruledetailid",socruledetailid);
    }

    /**
     * 设置 [PERSONNUM]
     */
    public void setPersonnum(Double  personnum){
        this.personnum = personnum ;
        this.modify("personnum",personnum);
    }

    /**
     * 设置 [COMPANYNUM]
     */
    public void setCompanynum(Double  companynum){
        this.companynum = companynum ;
        this.modify("companynum",companynum);
    }


}

