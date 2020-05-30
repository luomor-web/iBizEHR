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
 * 服务DTO对象[PimDistirbutionDTO]
 */
@Data
public class PimDistirbutionDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SSFW]
     *
     */
    @JSONField(name = "ssfw")
    @JsonProperty("ssfw")
    private String ssfw;

    /**
     * 属性 [RZJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzjssj" , format="yyyy-MM-dd")
    @JsonProperty("rzjssj")
    private Timestamp rzjssj;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [FPZT]
     *
     */
    @JSONField(name = "fpzt")
    @JsonProperty("fpzt")
    private String fpzt;

    /**
     * 属性 [LOGCONTENT]
     *
     */
    @JSONField(name = "logcontent")
    @JsonProperty("logcontent")
    private String logcontent;

    /**
     * 属性 [PIMDISTIRBUTIONID]
     *
     */
    @JSONField(name = "pimdistirbutionid")
    @JsonProperty("pimdistirbutionid")
    private String pimdistirbutionid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [RZKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rzkssj" , format="yyyy-MM-dd")
    @JsonProperty("rzkssj")
    private Timestamp rzkssj;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [YZW]
     *
     */
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;

    /**
     * 属性 [RECORD]
     *
     */
    @JSONField(name = "record")
    @JsonProperty("record")
    private String record;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [GZDQ]
     *
     */
    @JSONField(name = "gzdq")
    @JsonProperty("gzdq")
    private String gzdq;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PIMWORKHISTORYID]
     *
     */
    @JSONField(name = "pimworkhistoryid")
    @JsonProperty("pimworkhistoryid")
    private String pimworkhistoryid;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ISOUTRECORD]
     *
     */
    @JSONField(name = "isoutrecord")
    @JsonProperty("isoutrecord")
    private Integer isoutrecord;

    /**
     * 属性 [PIMDISTIRBUTIONNAME]
     *
     */
    @JSONField(name = "pimdistirbutionname")
    @JsonProperty("pimdistirbutionname")
    private String pimdistirbutionname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [FPLX]
     *
     */
    @JSONField(name = "fplx")
    @JsonProperty("fplx")
    private String fplx;

    /**
     * 属性 [EXPERIENCE]
     *
     */
    @JSONField(name = "experience")
    @JsonProperty("experience")
    private Integer experience;

    /**
     * 属性 [JDZT]
     *
     */
    @JSONField(name = "jdzt")
    @JsonProperty("jdzt")
    private String jdzt;

    /**
     * 属性 [YDMXID]
     *
     */
    @JSONField(name = "ydmxid")
    @JsonProperty("ydmxid")
    private String ydmxid;

    /**
     * 属性 [GZDD]
     *
     */
    @JSONField(name = "gzdd")
    @JsonProperty("gzdd")
    private String gzdd;

    /**
     * 属性 [YGW]
     *
     */
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [CFPLX]
     *
     */
    @JSONField(name = "cfplx")
    @JsonProperty("cfplx")
    private String cfplx;

    /**
     * 属性 [RANK]
     *
     */
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [YGZT]
     *
     */
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;

    /**
     * 属性 [XB]
     *
     */
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ZGCODE]
     *
     */
    @JSONField(name = "zgcode")
    @JsonProperty("zgcode")
    private String zgcode;

    /**
     * 属性 [YZZ]
     *
     */
    @JSONField(name = "yzz")
    @JsonProperty("yzz")
    private String yzz;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [LGNX]
     *
     */
    @JSONField(name = "lgnx")
    @JsonProperty("lgnx")
    private Integer lgnx;

    /**
     * 属性 [YBMSHORTNAME]
     *
     */
    @JSONField(name = "ybmshortname")
    @JsonProperty("ybmshortname")
    private String ybmshortname;

    /**
     * 属性 [ZZMM]
     *
     */
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [YDZT]
     *
     */
    @JSONField(name = "ydzt")
    @JsonProperty("ydzt")
    private String ydzt;

    /**
     * 属性 [NJ]
     *
     */
    @JSONField(name = "nj")
    @JsonProperty("nj")
    private Integer nj;

    /**
     * 属性 [YZZZZDZS]
     *
     */
    @JSONField(name = "yzzzzdzs")
    @JsonProperty("yzzzzdzs")
    private String yzzzzdzs;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [YBM]
     *
     */
    @JSONField(name = "ybm")
    @JsonProperty("ybm")
    private String ybm;

    /**
     * 属性 [ORMPOSTNAME1]
     *
     */
    @JSONField(name = "ormpostname1")
    @JsonProperty("ormpostname1")
    private String ormpostname1;

    /**
     * 属性 [YBMID]
     *
     */
    @JSONField(name = "ybmid")
    @JsonProperty("ybmid")
    private String ybmid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ORMPOSTID1]
     *
     */
    @JSONField(name = "ormpostid1")
    @JsonProperty("ormpostid1")
    private String ormpostid1;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;

    /**
     * 属性 [YZZID]
     *
     */
    @JSONField(name = "yzzid")
    @JsonProperty("yzzid")
    private String yzzid;

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
     * 设置 [RZJSSJ]
     */
    public void setRzjssj(Timestamp  rzjssj){
        this.rzjssj = rzjssj ;
        this.modify("rzjssj",rzjssj);
    }

    /**
     * 设置 [FPZT]
     */
    public void setFpzt(String  fpzt){
        this.fpzt = fpzt ;
        this.modify("fpzt",fpzt);
    }

    /**
     * 设置 [LOGCONTENT]
     */
    public void setLogcontent(String  logcontent){
        this.logcontent = logcontent ;
        this.modify("logcontent",logcontent);
    }

    /**
     * 设置 [RZKSSJ]
     */
    public void setRzkssj(Timestamp  rzkssj){
        this.rzkssj = rzkssj ;
        this.modify("rzkssj",rzkssj);
    }

    /**
     * 设置 [YZW]
     */
    public void setYzw(String  yzw){
        this.yzw = yzw ;
        this.modify("yzw",yzw);
    }

    /**
     * 设置 [RECORD]
     */
    public void setRecord(String  record){
        this.record = record ;
        this.modify("record",record);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [GZDQ]
     */
    public void setGzdq(String  gzdq){
        this.gzdq = gzdq ;
        this.modify("gzdq",gzdq);
    }

    /**
     * 设置 [PIMWORKHISTORYID]
     */
    public void setPimworkhistoryid(String  pimworkhistoryid){
        this.pimworkhistoryid = pimworkhistoryid ;
        this.modify("pimworkhistoryid",pimworkhistoryid);
    }

    /**
     * 设置 [ISOUTRECORD]
     */
    public void setIsoutrecord(Integer  isoutrecord){
        this.isoutrecord = isoutrecord ;
        this.modify("isoutrecord",isoutrecord);
    }

    /**
     * 设置 [PIMDISTIRBUTIONNAME]
     */
    public void setPimdistirbutionname(String  pimdistirbutionname){
        this.pimdistirbutionname = pimdistirbutionname ;
        this.modify("pimdistirbutionname",pimdistirbutionname);
    }

    /**
     * 设置 [FPLX]
     */
    public void setFplx(String  fplx){
        this.fplx = fplx ;
        this.modify("fplx",fplx);
    }

    /**
     * 设置 [EXPERIENCE]
     */
    public void setExperience(Integer  experience){
        this.experience = experience ;
        this.modify("experience",experience);
    }

    /**
     * 设置 [YDMXID]
     */
    public void setYdmxid(String  ydmxid){
        this.ydmxid = ydmxid ;
        this.modify("ydmxid",ydmxid);
    }

    /**
     * 设置 [GZDD]
     */
    public void setGzdd(String  gzdd){
        this.gzdd = gzdd ;
        this.modify("gzdd",gzdd);
    }

    /**
     * 设置 [YGW]
     */
    public void setYgw(String  ygw){
        this.ygw = ygw ;
        this.modify("ygw",ygw);
    }

    /**
     * 设置 [CFPLX]
     */
    public void setCfplx(String  cfplx){
        this.cfplx = cfplx ;
        this.modify("cfplx",cfplx);
    }

    /**
     * 设置 [RANK]
     */
    public void setRank(String  rank){
        this.rank = rank ;
        this.modify("rank",rank);
    }

    /**
     * 设置 [ORMPOSTNAME]
     */
    public void setOrmpostname(String  ormpostname){
        this.ormpostname = ormpostname ;
        this.modify("ormpostname",ormpostname);
    }

    /**
     * 设置 [YZZ]
     */
    public void setYzz(String  yzz){
        this.yzz = yzz ;
        this.modify("yzz",yzz);
    }

    /**
     * 设置 [ORMORGNAME]
     */
    public void setOrmorgname(String  ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [ORMORGSECTORNAME]
     */
    public void setOrmorgsectorname(String  ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
    }

    /**
     * 设置 [ORMDUTYNAME]
     */
    public void setOrmdutyname(String  ormdutyname){
        this.ormdutyname = ormdutyname ;
        this.modify("ormdutyname",ormdutyname);
    }

    /**
     * 设置 [YBM]
     */
    public void setYbm(String  ybm){
        this.ybm = ybm ;
        this.modify("ybm",ybm);
    }

    /**
     * 设置 [YBMID]
     */
    public void setYbmid(String  ybmid){
        this.ybmid = ybmid ;
        this.modify("ybmid",ybmid);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [ORMPOSTID1]
     */
    public void setOrmpostid1(String  ormpostid1){
        this.ormpostid1 = ormpostid1 ;
        this.modify("ormpostid1",ormpostid1);
    }

    /**
     * 设置 [ORMPOSTID]
     */
    public void setOrmpostid(String  ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [ORMDUTYID]
     */
    public void setOrmdutyid(String  ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [YZZID]
     */
    public void setYzzid(String  yzzid){
        this.yzzid = yzzid ;
        this.modify("yzzid",yzzid);
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


}

