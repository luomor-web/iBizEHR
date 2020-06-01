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
 * 服务DTO对象[TrmDutyCadresDTO]
 */
@Data
public class TrmDutyCadresDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [KHCJ]
     *
     */
    @JSONField(name = "khcj")
    @JsonProperty("khcj")
    private String khcj;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CSTYPE]
     *
     */
    @JSONField(name = "cstype")
    @JsonProperty("cstype")
    private String cstype;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [JTYY]
     *
     */
    @JSONField(name = "jtyy")
    @JsonProperty("jtyy")
    private String jtyy;

    /**
     * 属性 [JSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;

    /**
     * 属性 [SJTPNUM]
     *
     */
    @JSONField(name = "sjtpnum")
    @JsonProperty("sjtpnum")
    private Integer sjtpnum;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [RS]
     *
     */
    @JSONField(name = "rs")
    @JsonProperty("rs")
    private Integer rs;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [TRMDUTYCADRESNAME]
     *
     */
    @JSONField(name = "trmdutycadresname")
    @JsonProperty("trmdutycadresname")
    private String trmdutycadresname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SYTS]
     *
     */
    @JSONField(name = "syts")
    @JsonProperty("syts")
    private Integer syts;

    /**
     * 属性 [TCYY]
     *
     */
    @JSONField(name = "tcyy")
    @JsonProperty("tcyy")
    private String tcyy;

    /**
     * 属性 [RYLB]
     *
     */
    @JSONField(name = "rylb")
    @JsonProperty("rylb")
    private String rylb;

    /**
     * 属性 [XGW]
     *
     */
    @JSONField(name = "xgw")
    @JsonProperty("xgw")
    private String xgw;

    /**
     * 属性 [YEAR]
     *
     */
    @JSONField(name = "year")
    @JsonProperty("year")
    private String year;

    /**
     * 属性 [TRMDUTYCADRESID]
     *
     */
    @JSONField(name = "trmdutycadresid")
    @JsonProperty("trmdutycadresid")
    private String trmdutycadresid;

    /**
     * 属性 [QSRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qsrq" , format="yyyy-MM-dd")
    @JsonProperty("qsrq")
    private Timestamp qsrq;

    /**
     * 属性 [STATUS]
     *
     */
    @JSONField(name = "status")
    @JsonProperty("status")
    private String status;

    /**
     * 属性 [ZWNX]
     *
     */
    @JSONField(name = "zwnx")
    @JsonProperty("zwnx")
    private Double zwnx;

    /**
     * 属性 [ZJYCJXKHCJ]
     *
     */
    @JSONField(name = "zjycjxkhcj")
    @JsonProperty("zjycjxkhcj")
    private Double zjycjxkhcj;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [TPNUM]
     *
     */
    @JSONField(name = "tpnum")
    @JsonProperty("tpnum")
    private Integer tpnum;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

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
     * 属性 [ORMORGSECTORNAME2]
     *
     */
    @JSONField(name = "ormorgsectorname2")
    @JsonProperty("ormorgsectorname2")
    private String ormorgsectorname2;

    /**
     * 属性 [RANK]
     *
     */
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;

    /**
     * 属性 [ZWRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zwrq" , format="yyyy-MM-dd")
    @JsonProperty("zwrq")
    private Timestamp zwrq;

    /**
     * 属性 [ORMRANKNAME]
     *
     */
    @JSONField(name = "ormrankname")
    @JsonProperty("ormrankname")
    private String ormrankname;

    /**
     * 属性 [ORMORGNAME2]
     *
     */
    @JSONField(name = "ormorgname2")
    @JsonProperty("ormorgname2")
    private String ormorgname2;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [PIMPERSONNAME2]
     *
     */
    @JSONField(name = "pimpersonname2")
    @JsonProperty("pimpersonname2")
    private String pimpersonname2;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

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
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 属性 [PIMPERSONID2]
     *
     */
    @JSONField(name = "pimpersonid2")
    @JsonProperty("pimpersonid2")
    private String pimpersonid2;

    /**
     * 属性 [ORMRANKID]
     *
     */
    @JSONField(name = "ormrankid")
    @JsonProperty("ormrankid")
    private String ormrankid;

    /**
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;

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
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [KHCJ]
     */
    public void setKhcj(String  khcj){
        this.khcj = khcj ;
        this.modify("khcj",khcj);
    }

    /**
     * 设置 [CSTYPE]
     */
    public void setCstype(String  cstype){
        this.cstype = cstype ;
        this.modify("cstype",cstype);
    }

    /**
     * 设置 [JTYY]
     */
    public void setJtyy(String  jtyy){
        this.jtyy = jtyy ;
        this.modify("jtyy",jtyy);
    }

    /**
     * 设置 [JSRQ]
     */
    public void setJsrq(Timestamp  jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 设置 [SJTPNUM]
     */
    public void setSjtpnum(Integer  sjtpnum){
        this.sjtpnum = sjtpnum ;
        this.modify("sjtpnum",sjtpnum);
    }

    /**
     * 设置 [RS]
     */
    public void setRs(Integer  rs){
        this.rs = rs ;
        this.modify("rs",rs);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [TRMDUTYCADRESNAME]
     */
    public void setTrmdutycadresname(String  trmdutycadresname){
        this.trmdutycadresname = trmdutycadresname ;
        this.modify("trmdutycadresname",trmdutycadresname);
    }

    /**
     * 设置 [TCYY]
     */
    public void setTcyy(String  tcyy){
        this.tcyy = tcyy ;
        this.modify("tcyy",tcyy);
    }

    /**
     * 设置 [RYLB]
     */
    public void setRylb(String  rylb){
        this.rylb = rylb ;
        this.modify("rylb",rylb);
    }

    /**
     * 设置 [XGW]
     */
    public void setXgw(String  xgw){
        this.xgw = xgw ;
        this.modify("xgw",xgw);
    }

    /**
     * 设置 [YEAR]
     */
    public void setYear(String  year){
        this.year = year ;
        this.modify("year",year);
    }

    /**
     * 设置 [QSRQ]
     */
    public void setQsrq(Timestamp  qsrq){
        this.qsrq = qsrq ;
        this.modify("qsrq",qsrq);
    }

    /**
     * 设置 [STATUS]
     */
    public void setStatus(String  status){
        this.status = status ;
        this.modify("status",status);
    }

    /**
     * 设置 [ZJYCJXKHCJ]
     */
    public void setZjycjxkhcj(Double  zjycjxkhcj){
        this.zjycjxkhcj = zjycjxkhcj ;
        this.modify("zjycjxkhcj",zjycjxkhcj);
    }

    /**
     * 设置 [TPNUM]
     */
    public void setTpnum(Integer  tpnum){
        this.tpnum = tpnum ;
        this.modify("tpnum",tpnum);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [PIMPERSONNAME2]
     */
    public void setPimpersonname2(String  pimpersonname2){
        this.pimpersonname2 = pimpersonname2 ;
        this.modify("pimpersonname2",pimpersonname2);
    }

    /**
     * 设置 [ORMPOSTID]
     */
    public void setOrmpostid(String  ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [PIMPERSONID2]
     */
    public void setPimpersonid2(String  pimpersonid2){
        this.pimpersonid2 = pimpersonid2 ;
        this.modify("pimpersonid2",pimpersonid2);
    }

    /**
     * 设置 [ORMRANKID]
     */
    public void setOrmrankid(String  ormrankid){
        this.ormrankid = ormrankid ;
        this.modify("ormrankid",ormrankid);
    }

    /**
     * 设置 [ORMDUTYID]
     */
    public void setOrmdutyid(String  ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
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

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

