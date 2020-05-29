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
 * 服务DTO对象[AttEnsummarymxDTO]
 */
@Data
public class AttEnsummarymxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [TS]
     *
     */
    @JSONField(name = "ts")
    @JsonProperty("ts")
    private Double ts;

    /**
     * 属性 [SJTS]
     *
     */
    @JSONField(name = "sjts")
    @JsonProperty("sjts")
    private Double sjts;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ATTENSUMMARYMXNAME]
     *
     */
    @JSONField(name = "attendancesummarymxname")
    @JsonProperty("attendancesummarymxname")
    private String attendancesummarymxname;

    /**
     * 属性 [ATTENSUMMARYMXID]
     *
     */
    @JSONField(name = "attendancesummarymxid")
    @JsonProperty("attendancesummarymxid")
    private String attendancesummarymxid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [KQLX]
     *
     */
    @JSONField(name = "kqlx")
    @JsonProperty("kqlx")
    private String kqlx;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;


    /**
     * 设置 [TS]
     */
    public void setTs(Double  ts){
        this.ts = ts ;
        this.modify("ts",ts);
    }

    /**
     * 设置 [SJTS]
     */
    public void setSjts(Double  sjts){
        this.sjts = sjts ;
        this.modify("sjts",sjts);
    }

    /**
     * 设置 [ATTENSUMMARYMXNAME]
     */
    public void setAttendancesummarymxname(String  attendancesummarymxname){
        this.attendancesummarymxname = attendancesummarymxname ;
        this.modify("attensummarymxname",attendancesummarymxname);
    }

    /**
     * 设置 [KQLX]
     */
    public void setKqlx(String  kqlx){
        this.kqlx = kqlx ;
        this.modify("kqlx",kqlx);
    }


}

