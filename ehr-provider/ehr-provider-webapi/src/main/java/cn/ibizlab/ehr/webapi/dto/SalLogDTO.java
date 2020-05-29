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
 * 服务DTO对象[SalLogDTO]
 */
@Data
public class SalLogDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [VAL2]
     *
     */
    @JSONField(name = "val2")
    @JsonProperty("val2")
    private String val2;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SALLOGNAME]
     *
     */
    @JSONField(name = "sallogname")
    @JsonProperty("sallogname")
    private String sallogname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SALLOGID]
     *
     */
    @JSONField(name = "sallogid")
    @JsonProperty("sallogid")
    private String sallogid;

    /**
     * 属性 [VAL1]
     *
     */
    @JSONField(name = "val1")
    @JsonProperty("val1")
    private String val1;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [SALSALARYNAME]
     *
     */
    @JSONField(name = "salsalaryname")
    @JsonProperty("salsalaryname")
    private String salsalaryname;

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
     * 属性 [SALSALARYID]
     *
     */
    @JSONField(name = "salsalaryid")
    @JsonProperty("salsalaryid")
    private String salsalaryid;


    /**
     * 设置 [VAL2]
     */
    public void setVal2(String  val2){
        this.val2 = val2 ;
        this.modify("val2",val2);
    }

    /**
     * 设置 [SALLOGNAME]
     */
    public void setSallogname(String  sallogname){
        this.sallogname = sallogname ;
        this.modify("sallogname",sallogname);
    }

    /**
     * 设置 [VAL1]
     */
    public void setVal1(String  val1){
        this.val1 = val1 ;
        this.modify("val1",val1);
    }

    /**
     * 设置 [SALSALARYDETAILID]
     */
    public void setSalsalarydetailid(String  salsalarydetailid){
        this.salsalarydetailid = salsalarydetailid ;
        this.modify("salsalarydetailid",salsalarydetailid);
    }

    /**
     * 设置 [SALSALARYID]
     */
    public void setSalsalaryid(String  salsalaryid){
        this.salsalaryid = salsalaryid ;
        this.modify("salsalaryid",salsalaryid);
    }


}

