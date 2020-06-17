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
 * 服务DTO对象[SocRuleDetailDTO]
 */
@Data
public class SocRuleDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SOCRULEDETAILID]
     *
     */
    @JSONField(name = "socruledetailid")
    @JsonProperty("socruledetailid")
    private String socruledetailid;

    /**
     * 属性 [SOCRULEDETAILNAME]
     *
     */
    @JSONField(name = "socruledetailname")
    @JsonProperty("socruledetailname")
    private String socruledetailname;

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
     * 属性 [SOCRULEID]
     *
     */
    @JSONField(name = "socruleid")
    @JsonProperty("socruleid")
    private String socruleid;

    /**
     * 属性 [SOCRULENAME]
     *
     */
    @JSONField(name = "socrulename")
    @JsonProperty("socrulename")
    private String socrulename;

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
     * 属性 [COMPANYNUM]
     *
     */
    @JSONField(name = "companynum")
    @JsonProperty("companynum")
    private Double companynum;

    /**
     * 属性 [PERSONNUM]
     *
     */
    @JSONField(name = "personnum")
    @JsonProperty("personnum")
    private Double personnum;

    /**
     * 属性 [COMPANYRATE]
     *
     */
    @JSONField(name = "companyrate")
    @JsonProperty("companyrate")
    private Double companyrate;

    /**
     * 属性 [PERSONRATE]
     *
     */
    @JSONField(name = "personrate")
    @JsonProperty("personrate")
    private Double personrate;

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
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [ORDERVALUE]
     *
     */
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;


    /**
     * 设置 [SOCRULEDETAILNAME]
     */
    public void setSocruledetailname(String  socruledetailname){
        this.socruledetailname = socruledetailname ;
        this.modify("socruledetailname",socruledetailname);
    }

    /**
     * 设置 [SOCTYPEID]
     */
    public void setSoctypeid(String  soctypeid){
        this.soctypeid = soctypeid ;
        this.modify("soctypeid",soctypeid);
    }

    /**
     * 设置 [SOCRULEID]
     */
    public void setSocruleid(String  socruleid){
        this.socruleid = socruleid ;
        this.modify("socruleid",socruleid);
    }

    /**
     * 设置 [HIGHNUM]
     */
    public void setHighnum(Double  highnum){
        this.highnum = highnum ;
        this.modify("highnum",highnum);
    }

    /**
     * 设置 [LOWNUM]
     */
    public void setLownum(Double  lownum){
        this.lownum = lownum ;
        this.modify("lownum",lownum);
    }

    /**
     * 设置 [COMPANYNUM]
     */
    public void setCompanynum(Double  companynum){
        this.companynum = companynum ;
        this.modify("companynum",companynum);
    }

    /**
     * 设置 [PERSONNUM]
     */
    public void setPersonnum(Double  personnum){
        this.personnum = personnum ;
        this.modify("personnum",personnum);
    }

    /**
     * 设置 [COMPANYRATE]
     */
    public void setCompanyrate(Double  companyrate){
        this.companyrate = companyrate ;
        this.modify("companyrate",companyrate);
    }

    /**
     * 设置 [PERSONRATE]
     */
    public void setPersonrate(Double  personrate){
        this.personrate = personrate ;
        this.modify("personrate",personrate);
    }

    /**
     * 设置 [PERSONAMOUNT]
     */
    public void setPersonamount(Double  personamount){
        this.personamount = personamount ;
        this.modify("personamount",personamount);
    }

    /**
     * 设置 [COMPANYAMOUNT]
     */
    public void setCompanyamount(Double  companyamount){
        this.companyamount = companyamount ;
        this.modify("companyamount",companyamount);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }


}

