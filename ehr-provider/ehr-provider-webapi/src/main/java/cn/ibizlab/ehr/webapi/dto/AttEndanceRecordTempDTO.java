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
 * 服务DTO对象[AttEndanceRecordTempDTO]
 */
@Data
public class AttEndanceRecordTempDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [KQLX]
     *
     */
    @JSONField(name = "kqlx")
    @JsonProperty("kqlx")
    private String kqlx;

    /**
     * 属性 [DKSJQT]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dksjqt" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dksjqt")
    private Timestamp dksjqt;

    /**
     * 属性 [ZTF]
     *
     */
    @JSONField(name = "ztf")
    @JsonProperty("ztf")
    private Double ztf;

    /**
     * 属性 [ATTENDANCERECORDTEMPID]
     *
     */
    @JSONField(name = "attendancerecordtempid")
    @JsonProperty("attendancerecordtempid")
    private String attendancerecordtempid;

    /**
     * 属性 [CDF]
     *
     */
    @JSONField(name = "cdf")
    @JsonProperty("cdf")
    private Double cdf;

    /**
     * 属性 [SBSJ]
     *
     */
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sbsj" , format="HH:mm")
    @JsonProperty("sbsj")
    private Timestamp sbsj;

    /**
     * 属性 [ORMBMKQDZID]
     *
     */
    @JSONField(name = "ormbmkqdzid")
    @JsonProperty("ormbmkqdzid")
    private String ormbmkqdzid;

    /**
     * 属性 [YF]
     *
     */
    @JSONField(name = "yf")
    @JsonProperty("yf")
    private String yf;

    /**
     * 属性 [XBSJ]
     *
     */
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xbsj" , format="HH:mm")
    @JsonProperty("xbsj")
    private Timestamp xbsj;

    /**
     * 属性 [DAY]
     *
     */
    @JSONField(name = "day")
    @JsonProperty("day")
    private String day;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [ATTENDANCERECORDTEMPNAME]
     *
     */
    @JSONField(name = "attendancerecordtempname")
    @JsonProperty("attendancerecordtempname")
    private String attendancerecordtempname;

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
     * 属性 [ISWEEKEND]
     *
     */
    @JSONField(name = "isweekend")
    @JsonProperty("isweekend")
    private String isweekend;

    /**
     * 属性 [ISOUTLEAVE]
     *
     */
    @JSONField(name = "isoutleave")
    @JsonProperty("isoutleave")
    private Integer isoutleave;

    /**
     * 属性 [DKSJQD]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dksjqd" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dksjqd")
    private Timestamp dksjqd;

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
     * 属性 [ISOUTOFFICE]
     *
     */
    @JSONField(name = "isoutoffice")
    @JsonProperty("isoutoffice")
    private Integer isoutoffice;

    /**
     * 属性 [RSHD]
     *
     */
    @JSONField(name = "rshd")
    @JsonProperty("rshd")
    private String rshd;

    /**
     * 属性 [KQRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqrq" , format="yyyy-MM-dd")
    @JsonProperty("kqrq")
    private Timestamp kqrq;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

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
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;


    /**
     * 设置 [KQLX]
     */
    public void setKqlx(String  kqlx){
        this.kqlx = kqlx ;
        this.modify("kqlx",kqlx);
    }

    /**
     * 设置 [DKSJQT]
     */
    public void setDksjqt(Timestamp  dksjqt){
        this.dksjqt = dksjqt ;
        this.modify("dksjqt",dksjqt);
    }

    /**
     * 设置 [ZTF]
     */
    public void setZtf(Double  ztf){
        this.ztf = ztf ;
        this.modify("ztf",ztf);
    }

    /**
     * 设置 [CDF]
     */
    public void setCdf(Double  cdf){
        this.cdf = cdf ;
        this.modify("cdf",cdf);
    }

    /**
     * 设置 [SBSJ]
     */
    public void setSbsj(Timestamp  sbsj){
        this.sbsj = sbsj ;
        this.modify("sbsj",sbsj);
    }

    /**
     * 设置 [ORMBMKQDZID]
     */
    public void setOrmbmkqdzid(String  ormbmkqdzid){
        this.ormbmkqdzid = ormbmkqdzid ;
        this.modify("ormbmkqdzid",ormbmkqdzid);
    }

    /**
     * 设置 [YF]
     */
    public void setYf(String  yf){
        this.yf = yf ;
        this.modify("yf",yf);
    }

    /**
     * 设置 [XBSJ]
     */
    public void setXbsj(Timestamp  xbsj){
        this.xbsj = xbsj ;
        this.modify("xbsj",xbsj);
    }

    /**
     * 设置 [DAY]
     */
    public void setDay(String  day){
        this.day = day ;
        this.modify("day",day);
    }

    /**
     * 设置 [ATTENDANCERECORDTEMPNAME]
     */
    public void setAttendancerecordtempname(String  attendancerecordtempname){
        this.attendancerecordtempname = attendancerecordtempname ;
        this.modify("attendancerecordtempname",attendancerecordtempname);
    }

    /**
     * 设置 [ISWEEKEND]
     */
    public void setIsweekend(String  isweekend){
        this.isweekend = isweekend ;
        this.modify("isweekend",isweekend);
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
     * 设置 [ISOUTOFFICE]
     */
    public void setIsoutoffice(Integer  isoutoffice){
        this.isoutoffice = isoutoffice ;
        this.modify("isoutoffice",isoutoffice);
    }

    /**
     * 设置 [RSHD]
     */
    public void setRshd(String  rshd){
        this.rshd = rshd ;
        this.modify("rshd",rshd);
    }

    /**
     * 设置 [KQRQ]
     */
    public void setKqrq(Timestamp  kqrq){
        this.kqrq = kqrq ;
        this.modify("kqrq",kqrq);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [PIMPERSONNAME]
     */
    public void setPimpersonname(String  pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
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
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}

