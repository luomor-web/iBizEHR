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
 * 服务DTO对象[PimWorkHistoryDTO]
 */
@Data
public class PimWorkHistoryDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [EXPERIENCE]
     *
     */
    @JSONField(name = "experience")
    @JsonProperty("experience")
    private Integer experience;

    /**
     * 属性 [JLGLBH]
     *
     */
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;

    /**
     * 属性 [PIMWORKHISTORYNAME]
     *
     */
    @JSONField(name = "pimworkhistoryname")
    @JsonProperty("pimworkhistoryname")
    private String pimworkhistoryname;

    /**
     * 属性 [RZKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzkssj" , format="yyyy-MM-dd")
    @JsonProperty("rzkssj")
    private Timestamp rzkssj;

    /**
     * 属性 [JSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;

    /**
     * 属性 [JLSS]
     *
     */
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;

    /**
     * 属性 [RZJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzjssj" , format="yyyy-MM-dd")
    @JsonProperty("rzjssj")
    private Timestamp rzjssj;

    /**
     * 属性 [QSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qssj" , format="yyyy-MM-dd")
    @JsonProperty("qssj")
    private Timestamp qssj;

    /**
     * 属性 [SPSTATE]
     *
     */
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;

    /**
     * 属性 [CFPLX]
     *
     */
    @JSONField(name = "cfplx")
    @JsonProperty("cfplx")
    private String cfplx;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ISOUTRECORD]
     *
     */
    @JSONField(name = "isoutrecord")
    @JsonProperty("isoutrecord")
    private Integer isoutrecord;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PIMWORKHISTORYID]
     *
     */
    @JSONField(name = "pimworkhistoryid")
    @JsonProperty("pimworkhistoryid")
    private String pimworkhistoryid;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [JLCZZ]
     *
     */
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;

    /**
     * 属性 [RECORD]
     *
     */
    @JSONField(name = "record")
    @JsonProperty("record")
    private String record;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [JLSPZT]
     *
     */
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;

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
     * 属性 [ORMRANKNAME]
     *
     */
    @JSONField(name = "ormrankname")
    @JsonProperty("ormrankname")
    private String ormrankname;

    /**
     * 属性 [ORMRANKID]
     *
     */
    @JSONField(name = "ormrankid")
    @JsonProperty("ormrankid")
    private String ormrankid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [ORMPOSTNAME]
     */
    public void setOrmpostname(String  ormpostname){
        this.ormpostname = ormpostname ;
        this.modify("ormpostname",ormpostname);
    }

    /**
     * 设置 [ORMDUTYNAME]
     */
    public void setOrmdutyname(String  ormdutyname){
        this.ormdutyname = ormdutyname ;
        this.modify("ormdutyname",ormdutyname);
    }

    /**
     * 设置 [EXPERIENCE]
     */
    public void setExperience(Integer  experience){
        this.experience = experience ;
        this.modify("experience",experience);
    }

    /**
     * 设置 [JLGLBH]
     */
    public void setJlglbh(String  jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [PIMWORKHISTORYNAME]
     */
    public void setPimworkhistoryname(String  pimworkhistoryname){
        this.pimworkhistoryname = pimworkhistoryname ;
        this.modify("pimworkhistoryname",pimworkhistoryname);
    }

    /**
     * 设置 [RZKSSJ]
     */
    public void setRzkssj(Timestamp  rzkssj){
        this.rzkssj = rzkssj ;
        this.modify("rzkssj",rzkssj);
    }

    /**
     * 设置 [JSSJ]
     */
    public void setJssj(Timestamp  jssj){
        this.jssj = jssj ;
        this.modify("jssj",jssj);
    }

    /**
     * 设置 [JLSS]
     */
    public void setJlss(String  jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [RZJSSJ]
     */
    public void setRzjssj(Timestamp  rzjssj){
        this.rzjssj = rzjssj ;
        this.modify("rzjssj",rzjssj);
    }

    /**
     * 设置 [QSSJ]
     */
    public void setQssj(Timestamp  qssj){
        this.qssj = qssj ;
        this.modify("qssj",qssj);
    }

    /**
     * 设置 [CFPLX]
     */
    public void setCfplx(String  cfplx){
        this.cfplx = cfplx ;
        this.modify("cfplx",cfplx);
    }

    /**
     * 设置 [ORMORGSECTORNAME]
     */
    public void setOrmorgsectorname(String  ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
    }

    /**
     * 设置 [ISOUTRECORD]
     */
    public void setIsoutrecord(Integer  isoutrecord){
        this.isoutrecord = isoutrecord ;
        this.modify("isoutrecord",isoutrecord);
    }

    /**
     * 设置 [ORMORGNAME]
     */
    public void setOrmorgname(String  ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [JLCZZ]
     */
    public void setJlczz(String  jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [RECORD]
     */
    public void setRecord(String  record){
        this.record = record ;
        this.modify("record",record);
    }

    /**
     * 设置 [JLSPZT]
     */
    public void setJlspzt(String  jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [ORMRANKID]
     */
    public void setOrmrankid(String  ormrankid){
        this.ormrankid = ormrankid ;
        this.modify("ormrankid",ormrankid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

