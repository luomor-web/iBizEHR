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
 * 服务DTO对象[OrmErporgDTO]
 */
@Data
public class OrmErporgDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGTYPE]
     *
     */
    @JSONField(name = "orgtype")
    @JsonProperty("orgtype")
    private String orgtype;

    /**
     * 属性 [TOWNCITY]
     *
     */
    @JSONField(name = "towncity")
    @JsonProperty("towncity")
    private String towncity;

    /**
     * 属性 [ISENABLE]
     *
     */
    @JSONField(name = "isenable")
    @JsonProperty("isenable")
    private String isenable;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [DATETO]
     *
     */
    @JSONField(name = "dateto")
    @JsonProperty("dateto")
    private String dateto;

    /**
     * 属性 [ORGADDRESSLINE1]
     *
     */
    @JSONField(name = "orgaddressline1")
    @JsonProperty("orgaddressline1")
    private String orgaddressline1;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ORGTYPENAME]
     *
     */
    @JSONField(name = "orgtypename")
    @JsonProperty("orgtypename")
    private String orgtypename;

    /**
     * 属性 [ORGADDRESSLINE3]
     *
     */
    @JSONField(name = "orgaddressline3")
    @JsonProperty("orgaddressline3")
    private String orgaddressline3;

    /**
     * 属性 [ORGADDRESSLINE2]
     *
     */
    @JSONField(name = "orgaddressline2")
    @JsonProperty("orgaddressline2")
    private String orgaddressline2;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ORMERPORGID]
     *
     */
    @JSONField(name = "ormerporgid")
    @JsonProperty("ormerporgid")
    private String ormerporgid;

    /**
     * 属性 [OUCODE]
     *
     */
    @JSONField(name = "oucode")
    @JsonProperty("oucode")
    private String oucode;

    /**
     * 属性 [BELONGOU]
     *
     */
    @JSONField(name = "belongou")
    @JsonProperty("belongou")
    private String belongou;

    /**
     * 属性 [LASTUPDATEDATE]
     *
     */
    @JSONField(name = "lastupdatedate")
    @JsonProperty("lastupdatedate")
    private String lastupdatedate;

    /**
     * 属性 [DATEFROM]
     *
     */
    @JSONField(name = "datefrom")
    @JsonProperty("datefrom")
    private String datefrom;

    /**
     * 属性 [ADMCODING]
     *
     */
    @JSONField(name = "admcoding")
    @JsonProperty("admcoding")
    private String admcoding;

    /**
     * 属性 [YYFLAG]
     *
     */
    @JSONField(name = "yyflag")
    @JsonProperty("yyflag")
    private String yyflag;

    /**
     * 属性 [ORGSHORTNAME]
     *
     */
    @JSONField(name = "orgshortname")
    @JsonProperty("orgshortname")
    private String orgshortname;

    /**
     * 属性 [ORMERPORGNAME]
     *
     */
    @JSONField(name = "ormerporgname")
    @JsonProperty("ormerporgname")
    private String ormerporgname;

    /**
     * 属性 [ORGCREATEDATE]
     *
     */
    @JSONField(name = "orgcreatedate")
    @JsonProperty("orgcreatedate")
    private String orgcreatedate;

    /**
     * 属性 [PARENTORGID]
     *
     */
    @JSONField(name = "parentorgid")
    @JsonProperty("parentorgid")
    private String parentorgid;

    /**
     * 属性 [ORDERNUM]
     *
     */
    @JSONField(name = "ordernum")
    @JsonProperty("ordernum")
    private String ordernum;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ORGZIPCODE]
     *
     */
    @JSONField(name = "orgzipcode")
    @JsonProperty("orgzipcode")
    private String orgzipcode;

    /**
     * 属性 [OUID]
     *
     */
    @JSONField(name = "ouid")
    @JsonProperty("ouid")
    private String ouid;

    /**
     * 属性 [NUMCOMP]
     *
     */
    @JSONField(name = "numcomp")
    @JsonProperty("numcomp")
    private Integer numcomp;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;


    /**
     * 设置 [ORGTYPE]
     */
    public void setOrgtype(String  orgtype){
        this.orgtype = orgtype ;
        this.modify("orgtype",orgtype);
    }

    /**
     * 设置 [TOWNCITY]
     */
    public void setTowncity(String  towncity){
        this.towncity = towncity ;
        this.modify("towncity",towncity);
    }

    /**
     * 设置 [ISENABLE]
     */
    public void setIsenable(String  isenable){
        this.isenable = isenable ;
        this.modify("isenable",isenable);
    }

    /**
     * 设置 [DATETO]
     */
    public void setDateto(String  dateto){
        this.dateto = dateto ;
        this.modify("dateto",dateto);
    }

    /**
     * 设置 [ORGADDRESSLINE1]
     */
    public void setOrgaddressline1(String  orgaddressline1){
        this.orgaddressline1 = orgaddressline1 ;
        this.modify("orgaddressline1",orgaddressline1);
    }

    /**
     * 设置 [ORGTYPENAME]
     */
    public void setOrgtypename(String  orgtypename){
        this.orgtypename = orgtypename ;
        this.modify("orgtypename",orgtypename);
    }

    /**
     * 设置 [ORGADDRESSLINE3]
     */
    public void setOrgaddressline3(String  orgaddressline3){
        this.orgaddressline3 = orgaddressline3 ;
        this.modify("orgaddressline3",orgaddressline3);
    }

    /**
     * 设置 [ORGADDRESSLINE2]
     */
    public void setOrgaddressline2(String  orgaddressline2){
        this.orgaddressline2 = orgaddressline2 ;
        this.modify("orgaddressline2",orgaddressline2);
    }

    /**
     * 设置 [OUCODE]
     */
    public void setOucode(String  oucode){
        this.oucode = oucode ;
        this.modify("oucode",oucode);
    }

    /**
     * 设置 [LASTUPDATEDATE]
     */
    public void setLastupdatedate(String  lastupdatedate){
        this.lastupdatedate = lastupdatedate ;
        this.modify("lastupdatedate",lastupdatedate);
    }

    /**
     * 设置 [DATEFROM]
     */
    public void setDatefrom(String  datefrom){
        this.datefrom = datefrom ;
        this.modify("datefrom",datefrom);
    }

    /**
     * 设置 [YYFLAG]
     */
    public void setYyflag(String  yyflag){
        this.yyflag = yyflag ;
        this.modify("yyflag",yyflag);
    }

    /**
     * 设置 [ORGSHORTNAME]
     */
    public void setOrgshortname(String  orgshortname){
        this.orgshortname = orgshortname ;
        this.modify("orgshortname",orgshortname);
    }

    /**
     * 设置 [ORMERPORGNAME]
     */
    public void setOrmerporgname(String  ormerporgname){
        this.ormerporgname = ormerporgname ;
        this.modify("ormerporgname",ormerporgname);
    }

    /**
     * 设置 [ORGCREATEDATE]
     */
    public void setOrgcreatedate(String  orgcreatedate){
        this.orgcreatedate = orgcreatedate ;
        this.modify("orgcreatedate",orgcreatedate);
    }

    /**
     * 设置 [PARENTORGID]
     */
    public void setParentorgid(String  parentorgid){
        this.parentorgid = parentorgid ;
        this.modify("parentorgid",parentorgid);
    }

    /**
     * 设置 [ORDERNUM]
     */
    public void setOrdernum(String  ordernum){
        this.ordernum = ordernum ;
        this.modify("ordernum",ordernum);
    }

    /**
     * 设置 [ORGZIPCODE]
     */
    public void setOrgzipcode(String  orgzipcode){
        this.orgzipcode = orgzipcode ;
        this.modify("orgzipcode",orgzipcode);
    }

    /**
     * 设置 [OUID]
     */
    public void setOuid(String  ouid){
        this.ouid = ouid ;
        this.modify("ouid",ouid);
    }

    /**
     * 设置 [NUMCOMP]
     */
    public void setNumcomp(Integer  numcomp){
        this.numcomp = numcomp ;
        this.modify("numcomp",numcomp);
    }

    /**
     * 设置 [ORGCODE]
     */
    public void setOrgcode(String  orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }


}

