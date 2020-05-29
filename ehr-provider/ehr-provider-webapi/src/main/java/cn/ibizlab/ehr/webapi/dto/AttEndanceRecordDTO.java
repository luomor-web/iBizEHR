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
 * 服务DTO对象[AttEndanceRecordDTO]
 */
@Data
public class AttEndanceRecordDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ATTENDDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "attenddate" , format="yyyy-MM-dd")
    @JsonProperty("attenddate")
    private Timestamp attenddate;

    /**
     * 属性 [DKSJQT]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dksjqt" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dksjqt")
    private Timestamp dksjqt;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ISOUTOFFICE]
     *
     */
    @JSONField(name = "isoutoffice")
    @JsonProperty("isoutoffice")
    private Integer isoutoffice;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [DKFS]
     *
     */
    @JSONField(name = "dkfs")
    @JsonProperty("dkfs")
    private String dkfs;

    /**
     * 属性 [ISOUTLEAVE]
     *
     */
    @JSONField(name = "isoutleave")
    @JsonProperty("isoutleave")
    private Integer isoutleave;

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
     * 属性 [ATTENDANCERECORDID]
     *
     */
    @JSONField(name = "attendancerecordid")
    @JsonProperty("attendancerecordid")
    private String attendancerecordid;

    /**
     * 属性 [DKSJQD]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dksjqd" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dksjqd")
    private Timestamp dksjqd;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [ATTENDANCERECORDNAME]
     *
     */
    @JSONField(name = "attendancerecordname")
    @JsonProperty("attendancerecordname")
    private String attendancerecordname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [TRMTRAINPLANTERMNAME]
     *
     */
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;

    /**
     * 属性 [ORMBMKQDZNAME]
     *
     */
    @JSONField(name = "ormbmkqdzname")
    @JsonProperty("ormbmkqdzname")
    private String ormbmkqdzname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ATTENDANCEMREPORTMXNAME]
     *
     */
    @JSONField(name = "attendancemreportmxname")
    @JsonProperty("attendancemreportmxname")
    private String attendancemreportmxname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ORMBMKQDZID]
     *
     */
    @JSONField(name = "ormbmkqdzid")
    @JsonProperty("ormbmkqdzid")
    private String ormbmkqdzid;

    /**
     * 属性 [ATTENDANCEMREPORTMXID]
     *
     */
    @JSONField(name = "attendancemreportid")
    @JsonProperty("attendancemreportid")
    private String attendancemreportid;

    /**
     * 属性 [TRMTRAINPLANTERMID]
     *
     */
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;


    /**
     * 设置 [ATTENDDATE]
     */
    public void setAttenddate(Timestamp  attenddate){
        this.attenddate = attenddate ;
        this.modify("attenddate",attenddate);
    }

    /**
     * 设置 [DKSJQT]
     */
    public void setDksjqt(Timestamp  dksjqt){
        this.dksjqt = dksjqt ;
        this.modify("dksjqt",dksjqt);
    }

    /**
     * 设置 [ISOUTOFFICE]
     */
    public void setIsoutoffice(Integer  isoutoffice){
        this.isoutoffice = isoutoffice ;
        this.modify("isoutoffice",isoutoffice);
    }

    /**
     * 设置 [DKFS]
     */
    public void setDkfs(String  dkfs){
        this.dkfs = dkfs ;
        this.modify("dkfs",dkfs);
    }

    /**
     * 设置 [ISOUTLEAVE]
     */
    public void setIsoutleave(Integer  isoutleave){
        this.isoutleave = isoutleave ;
        this.modify("isoutleave",isoutleave);
    }

    /**
     * 设置 [DKSJQD]
     */
    public void setDksjqd(Timestamp  dksjqd){
        this.dksjqd = dksjqd ;
        this.modify("dksjqd",dksjqd);
    }

    /**
     * 设置 [ATTENDANCERECORDNAME]
     */
    public void setAttendancerecordname(String  attendancerecordname){
        this.attendancerecordname = attendancerecordname ;
        this.modify("attendancerecordname",attendancerecordname);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [ORMBMKQDZID]
     */
    public void setOrmbmkqdzid(String  ormbmkqdzid){
        this.ormbmkqdzid = ormbmkqdzid ;
        this.modify("ormbmkqdzid",ormbmkqdzid);
    }

    /**
     * 设置 [ATTENDANCEMREPORTMXID]
     */
    public void setAttendancemreportid(String  attendancemreportid){
        this.attendancemreportid = attendancemreportid ;
        this.modify("attendancemreportmxid",attendancemreportid);
    }

    /**
     * 设置 [TRMTRAINPLANTERMID]
     */
    public void setTrmtrainplantermid(String  trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }


}

