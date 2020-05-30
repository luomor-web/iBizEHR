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
 * 服务DTO对象[SalRuleDetailDTO]
 */
@Data
public class SalRuleDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SALRULEDETAILNAME]
     *
     */
    @JSONField(name = "salruledetailname")
    @JsonProperty("salruledetailname")
    private String salruledetailname;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CHECKRULE]
     *
     */
    @JSONField(name = "checkrule")
    @JsonProperty("checkrule")
    private String checkrule;

    /**
     * 属性 [SALRULEDETAILID]
     *
     */
    @JSONField(name = "salruledetailid")
    @JsonProperty("salruledetailid")
    private String salruledetailid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SALRULENAME]
     *
     */
    @JSONField(name = "salrulename")
    @JsonProperty("salrulename")
    private String salrulename;

    /**
     * 属性 [SALPARAMNAME]
     *
     */
    @JSONField(name = "salparamname")
    @JsonProperty("salparamname")
    private String salparamname;

    /**
     * 属性 [SALPARAMNAME2]
     *
     */
    @JSONField(name = "salparamname2")
    @JsonProperty("salparamname2")
    private String salparamname2;

    /**
     * 属性 [SALPARAMID]
     *
     */
    @JSONField(name = "salparamid")
    @JsonProperty("salparamid")
    private String salparamid;

    /**
     * 属性 [SALRULEID]
     *
     */
    @JSONField(name = "salruleid")
    @JsonProperty("salruleid")
    private String salruleid;

    /**
     * 属性 [SALPARAMID2]
     *
     */
    @JSONField(name = "salparamid2")
    @JsonProperty("salparamid2")
    private String salparamid2;


    /**
     * 设置 [SALRULEDETAILNAME]
     */
    public void setSalruledetailname(String  salruledetailname){
        this.salruledetailname = salruledetailname ;
        this.modify("salruledetailname",salruledetailname);
    }

    /**
     * 设置 [CHECKRULE]
     */
    public void setCheckrule(String  checkrule){
        this.checkrule = checkrule ;
        this.modify("checkrule",checkrule);
    }

    /**
     * 设置 [SALPARAMID]
     */
    public void setSalparamid(String  salparamid){
        this.salparamid = salparamid ;
        this.modify("salparamid",salparamid);
    }

    /**
     * 设置 [SALRULEID]
     */
    public void setSalruleid(String  salruleid){
        this.salruleid = salruleid ;
        this.modify("salruleid",salruleid);
    }

    /**
     * 设置 [SALPARAMID2]
     */
    public void setSalparamid2(String  salparamid2){
        this.salparamid2 = salparamid2 ;
        this.modify("salparamid2",salparamid2);
    }


}

