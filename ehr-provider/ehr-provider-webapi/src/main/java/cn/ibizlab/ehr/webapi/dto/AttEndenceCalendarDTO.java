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
 * 服务DTO对象[AttEndenceCalendarDTO]
 */
@Data
public class AttEndenceCalendarDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ATTENDENCECALENDARID]
     *
     */
    @JSONField(name = "attendencecalendarid")
    @JsonProperty("attendencecalendarid")
    private String attendencecalendarid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [ATTENDENCECALENDARNAME]
     *
     */
    @JSONField(name = "attendencecalendarname")
    @JsonProperty("attendencecalendarname")
    private String attendencecalendarname;

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
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [LX1]
     *
     */
    @JSONField(name = "lx1")
    @JsonProperty("lx1")
    private String lx1;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [RQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rq" , format="yyyy-MM-dd")
    @JsonProperty("rq")
    private Timestamp rq;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [JJRLX]
     *
     */
    @JSONField(name = "jjrlx")
    @JsonProperty("jjrlx")
    private String jjrlx;

    /**
     * 属性 [VACHOLIDAYNAME]
     *
     */
    @JSONField(name = "vacholidayname")
    @JsonProperty("vacholidayname")
    private String vacholidayname;

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
     * 属性 [VACHOLIDAYID]
     *
     */
    @JSONField(name = "vacholidayid")
    @JsonProperty("vacholidayid")
    private String vacholidayid;


    /**
     * 设置 [ATTENDENCECALENDARNAME]
     */
    public void setAttendencecalendarname(String  attendencecalendarname){
        this.attendencecalendarname = attendencecalendarname ;
        this.modify("attendencecalendarname",attendencecalendarname);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [LX1]
     */
    public void setLx1(String  lx1){
        this.lx1 = lx1 ;
        this.modify("lx1",lx1);
    }

    /**
     * 设置 [RQ]
     */
    public void setRq(Timestamp  rq){
        this.rq = rq ;
        this.modify("rq",rq);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [VACHOLIDAYID]
     */
    public void setVacholidayid(String  vacholidayid){
        this.vacholidayid = vacholidayid ;
        this.modify("vacholidayid",vacholidayid);
    }


}

