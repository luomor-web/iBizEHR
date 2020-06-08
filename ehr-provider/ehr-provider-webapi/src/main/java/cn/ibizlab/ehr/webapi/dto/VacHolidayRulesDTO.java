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
 * 服务DTO对象[VacHolidayRulesDTO]
 */
@Data
public class VacHolidayRulesDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SBSJ]
     *
     */
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sbsj" , format="HH:mm")
    @JsonProperty("sbsj")
    private Timestamp sbsj;

    /**
     * 属性 [XBSJ]
     *
     */
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xbsj" , format="HH:mm")
    @JsonProperty("xbsj")
    private Timestamp xbsj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [VACHOLIDAYRULESNAME]
     *
     */
    @JSONField(name = "vacholidayrulesname")
    @JsonProperty("vacholidayrulesname")
    private String vacholidayrulesname;

    /**
     * 属性 [SFQY]
     *
     */
    @JSONField(name = "sfqy")
    @JsonProperty("sfqy")
    private String sfqy;

    /**
     * 属性 [VACHOLIDAYRULESID]
     *
     */
    @JSONField(name = "vacholidayrulesid")
    @JsonProperty("vacholidayrulesid")
    private String vacholidayrulesid;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [TSZXJZZ]
     *
     */
    @JSONField(name = "tszxjzz")
    @JsonProperty("tszxjzz")
    private String tszxjzz;

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
     * 属性 [DEFAULTRULE]
     *
     */
    @JSONField(name = "defaultrule")
    @JsonProperty("defaultrule")
    private String defaultrule;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [SBSJ]
     */
    public void setSbsj(Timestamp  sbsj){
        this.sbsj = sbsj ;
        this.modify("sbsj",sbsj);
    }

    /**
     * 设置 [XBSJ]
     */
    public void setXbsj(Timestamp  xbsj){
        this.xbsj = xbsj ;
        this.modify("xbsj",xbsj);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [VACHOLIDAYRULESNAME]
     */
    public void setVacholidayrulesname(String  vacholidayrulesname){
        this.vacholidayrulesname = vacholidayrulesname ;
        this.modify("vacholidayrulesname",vacholidayrulesname);
    }

    /**
     * 设置 [SFQY]
     */
    public void setSfqy(String  sfqy){
        this.sfqy = sfqy ;
        this.modify("sfqy",sfqy);
    }

    /**
     * 设置 [TSZXJZZ]
     */
    public void setTszxjzz(String  tszxjzz){
        this.tszxjzz = tszxjzz ;
        this.modify("tszxjzz",tszxjzz);
    }

    /**
     * 设置 [DEFAULTRULE]
     */
    public void setDefaultrule(String  defaultrule){
        this.defaultrule = defaultrule ;
        this.modify("defaultrule",defaultrule);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

