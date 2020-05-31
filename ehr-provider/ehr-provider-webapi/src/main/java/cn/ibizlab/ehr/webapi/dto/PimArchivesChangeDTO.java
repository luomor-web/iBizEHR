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
 * 服务DTO对象[PimArchivesChangeDTO]
 */
@Data
public class PimArchivesChangeDTO extends DTOBase implements Serializable {

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
     * 属性 [PIMARCHIVESCHANGENAME]
     *
     */
    @JSONField(name = "pimarchiveschangename")
    @JsonProperty("pimarchiveschangename")
    private String pimarchiveschangename;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [DAZT]
     *
     */
    @JSONField(name = "dazt")
    @JsonProperty("dazt")
    private String dazt;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DCDW]
     *
     */
    @JSONField(name = "dcdw")
    @JsonProperty("dcdw")
    private String dcdw;

    /**
     * 属性 [DDJLTYPE]
     *
     */
    @JSONField(name = "ddjltype")
    @JsonProperty("ddjltype")
    private String ddjltype;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [PIMARCHIVESCHANGEID]
     *
     */
    @JSONField(name = "pimarchiveschangeid")
    @JsonProperty("pimarchiveschangeid")
    private String pimarchiveschangeid;

    /**
     * 属性 [XGDBGD]
     *
     */
    @JSONField(name = "xgdbgd")
    @JsonProperty("xgdbgd")
    private String xgdbgd;

    /**
     * 属性 [JLCSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jlcssj" , format="yyyy-MM-dd")
    @JsonProperty("jlcssj")
    private Timestamp jlcssj;

    /**
     * 属性 [DRDW]
     *
     */
    @JSONField(name = "drdw")
    @JsonProperty("drdw")
    private String drdw;

    /**
     * 属性 [DADDRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "daddrq" , format="yyyy-MM-dd")
    @JsonProperty("daddrq")
    private Timestamp daddrq;

    /**
     * 属性 [ORMORGNAME2]
     *
     */
    @JSONField(name = "ormorgname2")
    @JsonProperty("ormorgname2")
    private String ormorgname2;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PIMARCHIVESNAME]
     *
     */
    @JSONField(name = "pimarchivesname")
    @JsonProperty("pimarchivesname")
    private String pimarchivesname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ORMORGID2]
     *
     */
    @JSONField(name = "ormorgid2")
    @JsonProperty("ormorgid2")
    private String ormorgid2;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PIMARCHIVESID]
     *
     */
    @JSONField(name = "pimarchivesid")
    @JsonProperty("pimarchivesid")
    private String pimarchivesid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [PIMARCHIVESCHANGENAME]
     */
    public void setPimarchiveschangename(String  pimarchiveschangename){
        this.pimarchiveschangename = pimarchiveschangename ;
        this.modify("pimarchiveschangename",pimarchiveschangename);
    }

    /**
     * 设置 [DAZT]
     */
    public void setDazt(String  dazt){
        this.dazt = dazt ;
        this.modify("dazt",dazt);
    }

    /**
     * 设置 [DCDW]
     */
    public void setDcdw(String  dcdw){
        this.dcdw = dcdw ;
        this.modify("dcdw",dcdw);
    }

    /**
     * 设置 [DDJLTYPE]
     */
    public void setDdjltype(String  ddjltype){
        this.ddjltype = ddjltype ;
        this.modify("ddjltype",ddjltype);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [XGDBGD]
     */
    public void setXgdbgd(String  xgdbgd){
        this.xgdbgd = xgdbgd ;
        this.modify("xgdbgd",xgdbgd);
    }

    /**
     * 设置 [JLCSSJ]
     */
    public void setJlcssj(Timestamp  jlcssj){
        this.jlcssj = jlcssj ;
        this.modify("jlcssj",jlcssj);
    }

    /**
     * 设置 [DRDW]
     */
    public void setDrdw(String  drdw){
        this.drdw = drdw ;
        this.modify("drdw",drdw);
    }

    /**
     * 设置 [DADDRQ]
     */
    public void setDaddrq(Timestamp  daddrq){
        this.daddrq = daddrq ;
        this.modify("daddrq",daddrq);
    }

    /**
     * 设置 [ORMORGNAME2]
     */
    public void setOrmorgname2(String  ormorgname2){
        this.ormorgname2 = ormorgname2 ;
        this.modify("ormorgname2",ormorgname2);
    }

    /**
     * 设置 [ORMORGNAME]
     */
    public void setOrmorgname(String  ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [ORMORGID2]
     */
    public void setOrmorgid2(String  ormorgid2){
        this.ormorgid2 = ormorgid2 ;
        this.modify("ormorgid2",ormorgid2);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [PIMARCHIVESID]
     */
    public void setPimarchivesid(String  pimarchivesid){
        this.pimarchivesid = pimarchivesid ;
        this.modify("pimarchivesid",pimarchivesid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

