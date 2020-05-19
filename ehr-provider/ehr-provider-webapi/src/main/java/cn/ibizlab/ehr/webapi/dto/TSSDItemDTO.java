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
 * 服务DTO对象[TSSDItemDTO]
 */
@Data
public class TSSDItemDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [HOURTYPE]
     *
     */
    @JSONField(name = "hourtype")
    @JsonProperty("hourtype")
    private String hourtype;

    /**
     * 属性 [MONTHWEEKTYPE]
     *
     */
    @JSONField(name = "monthweektype")
    @JsonProperty("monthweektype")
    private String monthweektype;

    /**
     * 属性 [SECONDVALUE]
     *
     */
    @JSONField(name = "secondvalue")
    @JsonProperty("secondvalue")
    private String secondvalue;

    /**
     * 属性 [MINUTETYPE]
     *
     */
    @JSONField(name = "minutetype")
    @JsonProperty("minutetype")
    private String minutetype;

    /**
     * 属性 [SECONDTYPE]
     *
     */
    @JSONField(name = "secondtype")
    @JsonProperty("secondtype")
    private String secondtype;

    /**
     * 属性 [TSSDITEMNAME]
     *
     */
    @JSONField(name = "tssditemname")
    @JsonProperty("tssditemname")
    private String tssditemname;

    /**
     * 属性 [MONTHDAYVALUE]
     *
     */
    @JSONField(name = "monthdayvalue")
    @JsonProperty("monthdayvalue")
    private String monthdayvalue;

    /**
     * 属性 [MONTHVALUE]
     *
     */
    @JSONField(name = "monthvalue")
    @JsonProperty("monthvalue")
    private String monthvalue;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [MONTHDAYTYPE]
     *
     */
    @JSONField(name = "monthdaytype")
    @JsonProperty("monthdaytype")
    private String monthdaytype;

    /**
     * 属性 [MONTHWEEKVALUE]
     *
     */
    @JSONField(name = "monthweekvalue")
    @JsonProperty("monthweekvalue")
    private String monthweekvalue;

    /**
     * 属性 [HOURVALUE]
     *
     */
    @JSONField(name = "hourvalue")
    @JsonProperty("hourvalue")
    private String hourvalue;

    /**
     * 属性 [MINUTEVALUE]
     *
     */
    @JSONField(name = "minutevalue")
    @JsonProperty("minutevalue")
    private String minutevalue;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [VERSION]
     *
     */
    @JSONField(name = "version")
    @JsonProperty("version")
    private Integer version;

    /**
     * 属性 [MONTHTYPE]
     *
     */
    @JSONField(name = "monthtype")
    @JsonProperty("monthtype")
    private String monthtype;

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
     * 属性 [TSSDITEMID]
     *
     */
    @JSONField(name = "tssditemid")
    @JsonProperty("tssditemid")
    private String tssditemid;


    /**
     * 设置 [HOURTYPE]
     */
    public void setHourtype(String  hourtype){
        this.hourtype = hourtype ;
        this.modify("hourtype",hourtype);
    }

    /**
     * 设置 [MONTHWEEKTYPE]
     */
    public void setMonthweektype(String  monthweektype){
        this.monthweektype = monthweektype ;
        this.modify("monthweektype",monthweektype);
    }

    /**
     * 设置 [SECONDVALUE]
     */
    public void setSecondvalue(String  secondvalue){
        this.secondvalue = secondvalue ;
        this.modify("secondvalue",secondvalue);
    }

    /**
     * 设置 [MINUTETYPE]
     */
    public void setMinutetype(String  minutetype){
        this.minutetype = minutetype ;
        this.modify("minutetype",minutetype);
    }

    /**
     * 设置 [SECONDTYPE]
     */
    public void setSecondtype(String  secondtype){
        this.secondtype = secondtype ;
        this.modify("secondtype",secondtype);
    }

    /**
     * 设置 [TSSDITEMNAME]
     */
    public void setTssditemname(String  tssditemname){
        this.tssditemname = tssditemname ;
        this.modify("tssditemname",tssditemname);
    }

    /**
     * 设置 [MONTHDAYVALUE]
     */
    public void setMonthdayvalue(String  monthdayvalue){
        this.monthdayvalue = monthdayvalue ;
        this.modify("monthdayvalue",monthdayvalue);
    }

    /**
     * 设置 [MONTHVALUE]
     */
    public void setMonthvalue(String  monthvalue){
        this.monthvalue = monthvalue ;
        this.modify("monthvalue",monthvalue);
    }

    /**
     * 设置 [MONTHDAYTYPE]
     */
    public void setMonthdaytype(String  monthdaytype){
        this.monthdaytype = monthdaytype ;
        this.modify("monthdaytype",monthdaytype);
    }

    /**
     * 设置 [MONTHWEEKVALUE]
     */
    public void setMonthweekvalue(String  monthweekvalue){
        this.monthweekvalue = monthweekvalue ;
        this.modify("monthweekvalue",monthweekvalue);
    }

    /**
     * 设置 [HOURVALUE]
     */
    public void setHourvalue(String  hourvalue){
        this.hourvalue = hourvalue ;
        this.modify("hourvalue",hourvalue);
    }

    /**
     * 设置 [MINUTEVALUE]
     */
    public void setMinutevalue(String  minutevalue){
        this.minutevalue = minutevalue ;
        this.modify("minutevalue",minutevalue);
    }

    /**
     * 设置 [VERSION]
     */
    public void setVersion(Integer  version){
        this.version = version ;
        this.modify("version",version);
    }

    /**
     * 设置 [MONTHTYPE]
     */
    public void setMonthtype(String  monthtype){
        this.monthtype = monthtype ;
        this.modify("monthtype",monthtype);
    }


}

