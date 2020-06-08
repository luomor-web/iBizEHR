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
 * 服务DTO对象[SalSalaryDTO]
 */
@Data
public class SalSalaryDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SALSALARYID]
     *
     */
    @JSONField(name = "salsalaryid")
    @JsonProperty("salsalaryid")
    private String salsalaryid;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [STATE]
     *
     */
    @JSONField(name = "state")
    @JsonProperty("state")
    private String state;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [XC]
     *
     */
    @JSONField(name = "xc")
    @JsonProperty("xc")
    private Double xc;

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
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SALSALARYBILLNAME]
     *
     */
    @JSONField(name = "salsalarybillname")
    @JsonProperty("salsalarybillname")
    private String salsalarybillname;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [NYEAR]
     *
     */
    @JSONField(name = "nyear")
    @JsonProperty("nyear")
    private Integer nyear;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [NMONTH]
     *
     */
    @JSONField(name = "nmonth")
    @JsonProperty("nmonth")
    private Integer nmonth;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [SALPLANNAME]
     *
     */
    @JSONField(name = "salplanname")
    @JsonProperty("salplanname")
    private String salplanname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [SALSALARYBILLID]
     *
     */
    @JSONField(name = "salsalarybillid")
    @JsonProperty("salsalarybillid")
    private String salsalarybillid;

    /**
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 属性 [SALPLANID]
     *
     */
    @JSONField(name = "salplanid")
    @JsonProperty("salplanid")
    private String salplanid;


    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [STATE]
     */
    public void setState(String  state){
        this.state = state ;
        this.modify("state",state);
    }

    /**
     * 设置 [XC]
     */
    public void setXc(Double  xc){
        this.xc = xc ;
        this.modify("xc",xc);
    }

    /**
     * 设置 [SALSALARYNAME]
     */
    public void setSalsalaryname(String  salsalaryname){
        this.salsalaryname = salsalaryname ;
        this.modify("salsalaryname",salsalaryname);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [SALSALARYBILLID]
     */
    public void setSalsalarybillid(String  salsalarybillid){
        this.salsalarybillid = salsalarybillid ;
        this.modify("salsalarybillid",salsalarybillid);
    }

    /**
     * 设置 [ORMDUTYID]
     */
    public void setOrmdutyid(String  ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [ORMPOSTID]
     */
    public void setOrmpostid(String  ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [SALPLANID]
     */
    public void setSalplanid(String  salplanid){
        this.salplanid = salplanid ;
        this.modify("salplanid",salplanid);
    }


}

