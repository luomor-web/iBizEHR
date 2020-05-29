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
 * 服务DTO对象[AttEndenceSetupDTO]
 */
@Data
public class AttEndenceSetupDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [XBSJ]
     *
     */
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xbsj" , format="HH:mm")
    @JsonProperty("xbsj")
    private Timestamp xbsj;

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
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ATTENDENCESETUPNAME]
     *
     */
    @JSONField(name = "attendencesetupname")
    @JsonProperty("attendencesetupname")
    private String attendencesetupname;

    /**
     * 属性 [ALLOWOUTWORK]
     *
     */
    @JSONField(name = "allowoutwork")
    @JsonProperty("allowoutwork")
    private String allowoutwork;

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
     * 属性 [ATTENDENCESETUPID]
     *
     */
    @JSONField(name = "attendencesetupid")
    @JsonProperty("attendencesetupid")
    private String attendencesetupid;

    /**
     * 属性 [SBSJ]
     *
     */
    @JsonFormat(pattern="HH:mm", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sbsj" , format="HH:mm")
    @JsonProperty("sbsj")
    private Timestamp sbsj;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [VACHOLIDAYRULESNAME]
     *
     */
    @JSONField(name = "vacholidayrulesname")
    @JsonProperty("vacholidayrulesname")
    private String vacholidayrulesname;

    /**
     * 属性 [PORGID]
     *
     */
    @JSONField(name = "porgid")
    @JsonProperty("porgid")
    private String porgid;

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
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [VACHOLIDAYRULESID]
     *
     */
    @JSONField(name = "vacholidayrulesid")
    @JsonProperty("vacholidayrulesid")
    private String vacholidayrulesid;


    /**
     * 设置 [XBSJ]
     */
    public void setXbsj(Timestamp  xbsj){
        this.xbsj = xbsj ;
        this.modify("xbsj",xbsj);
    }

    /**
     * 设置 [ATTENDENCESETUPNAME]
     */
    public void setAttendencesetupname(String  attendencesetupname){
        this.attendencesetupname = attendencesetupname ;
        this.modify("attendencesetupname",attendencesetupname);
    }

    /**
     * 设置 [ALLOWOUTWORK]
     */
    public void setAllowoutwork(String  allowoutwork){
        this.allowoutwork = allowoutwork ;
        this.modify("allowoutwork",allowoutwork);
    }

    /**
     * 设置 [DKFS]
     */
    public void setDkfs(String  dkfs){
        this.dkfs = dkfs ;
        this.modify("dkfs",dkfs);
    }

    /**
     * 设置 [SBSJ]
     */
    public void setSbsj(Timestamp  sbsj){
        this.sbsj = sbsj ;
        this.modify("sbsj",sbsj);
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
     * 设置 [VACHOLIDAYRULESID]
     */
    public void setVacholidayrulesid(String  vacholidayrulesid){
        this.vacholidayrulesid = vacholidayrulesid ;
        this.modify("vacholidayrulesid",vacholidayrulesid);
    }


}

