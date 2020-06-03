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
 * 服务DTO对象[PcmBdsqdmxDTO]
 */
@Data
public class PcmBdsqdmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

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
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [SFMZ]
     *
     */
    @JSONField(name = "sfmz")
    @JsonProperty("sfmz")
    private Integer sfmz;

    /**
     * 属性 [GZKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzkssj" , format="yyyy-MM-dd")
    @JsonProperty("gzkssj")
    private Timestamp gzkssj;

    /**
     * 属性 [LZFJ]
     *
     */
    @JSONField(name = "lzfj")
    @JsonProperty("lzfj")
    private String lzfj;

    /**
     * 属性 [PCMBDSQDMXID]
     *
     */
    @JSONField(name = "pcmbdsqdmxid")
    @JsonProperty("pcmbdsqdmxid")
    private String pcmbdsqdmxid;

    /**
     * 属性 [FINISHED]
     *
     */
    @JSONField(name = "finished")
    @JsonProperty("finished")
    private Integer finished;

    /**
     * 属性 [PCJE]
     *
     */
    @JSONField(name = "pcje")
    @JsonProperty("pcje")
    private Double pcje;

    /**
     * 属性 [LZYY]
     *
     */
    @JSONField(name = "lzyy")
    @JsonProperty("lzyy")
    private String lzyy;

    /**
     * 属性 [WFRESULT]
     *
     */
    @JSONField(name = "wfresult")
    @JsonProperty("wfresult")
    private String wfresult;

    /**
     * 属性 [LDZYTYPE]
     *
     */
    @JSONField(name = "ldzytype")
    @JsonProperty("ldzytype")
    private String ldzytype;

    /**
     * 属性 [LZQX]
     *
     */
    @JSONField(name = "lzqx")
    @JsonProperty("lzqx")
    private String lzqx;

    /**
     * 属性 [SXRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;

    /**
     * 属性 [LZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "lzsj" , format="yyyy-MM-dd")
    @JsonProperty("lzsj")
    private Timestamp lzsj;

    /**
     * 属性 [RZWH]
     *
     */
    @JSONField(name = "rzwh")
    @JsonProperty("rzwh")
    private String rzwh;

    /**
     * 属性 [GZZT]
     *
     */
    @JSONField(name = "gzzt")
    @JsonProperty("gzzt")
    private String gzzt;

    /**
     * 属性 [SFJRHMD]
     *
     */
    @JSONField(name = "sfjrhmd")
    @JsonProperty("sfjrhmd")
    private String sfjrhmd;

    /**
     * 属性 [CHECKSTATUS]
     *
     */
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;

    /**
     * 属性 [SFTSDD]
     *
     */
    @JSONField(name = "sftsdd")
    @JsonProperty("sftsdd")
    private Integer sftsdd;

    /**
     * 属性 [LX]
     *
     */
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SFZFLZBCJ]
     *
     */
    @JSONField(name = "sfzflzbcj")
    @JsonProperty("sfzflzbcj")
    private Integer sfzflzbcj;

    /**
     * 属性 [PCMBDSQDMXNAME]
     *
     */
    @JSONField(name = "pcmbdsqdmxname")
    @JsonProperty("pcmbdsqdmxname")
    private String pcmbdsqdmxname;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [SFLDZY]
     *
     */
    @JSONField(name = "sfldzy")
    @JsonProperty("sfldzy")
    private Integer sfldzy;

    /**
     * 属性 [BCJSE]
     *
     */
    @JSONField(name = "bcjse")
    @JsonProperty("bcjse")
    private Double bcjse;

    /**
     * 属性 [XRANK]
     *
     */
    @JSONField(name = "xrank")
    @JsonProperty("xrank")
    private String xrank;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [GZJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzjssj" , format="yyyy-MM-dd")
    @JsonProperty("gzjssj")
    private Timestamp gzjssj;

    /**
     * 属性 [DGLX]
     *
     */
    @JSONField(name = "dglx")
    @JsonProperty("dglx")
    private String dglx;

    /**
     * 属性 [ORMORGSECTORNAME2]
     *
     */
    @JSONField(name = "ormorgsectorname2")
    @JsonProperty("ormorgsectorname2")
    private String ormorgsectorname2;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [LZMTR]
     *
     */
    @JSONField(name = "lzmtr")
    @JsonProperty("lzmtr")
    private String lzmtr;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [ZZID]
     *
     */
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;

    /**
     * 属性 [RANK]
     *
     */
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;

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
     * 属性 [BMID]
     *
     */
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [YZW]
     *
     */
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;

    /**
     * 属性 [YWG]
     *
     */
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;

    /**
     * 属性 [NL]
     *
     */
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [ORMORGSECTORID2]
     *
     */
    @JSONField(name = "ormorgsectorid2")
    @JsonProperty("ormorgsectorid2")
    private String ormorgsectorid2;

    /**
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;

    /**
     * 属性 [PCMBDSQDID]
     *
     */
    @JSONField(name = "pcmbdsqdid")
    @JsonProperty("pcmbdsqdid")
    private String pcmbdsqdid;

    /**
     * 属性 [LZMTRID]
     *
     */
    @JSONField(name = "lzmtrid")
    @JsonProperty("lzmtrid")
    private String lzmtrid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;


    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [SFMZ]
     */
    public void setSfmz(Integer  sfmz){
        this.sfmz = sfmz ;
        this.modify("sfmz",sfmz);
    }

    /**
     * 设置 [GZKSSJ]
     */
    public void setGzkssj(Timestamp  gzkssj){
        this.gzkssj = gzkssj ;
        this.modify("gzkssj",gzkssj);
    }

    /**
     * 设置 [LZFJ]
     */
    public void setLzfj(String  lzfj){
        this.lzfj = lzfj ;
        this.modify("lzfj",lzfj);
    }

    /**
     * 设置 [FINISHED]
     */
    public void setFinished(Integer  finished){
        this.finished = finished ;
        this.modify("finished",finished);
    }

    /**
     * 设置 [PCJE]
     */
    public void setPcje(Double  pcje){
        this.pcje = pcje ;
        this.modify("pcje",pcje);
    }

    /**
     * 设置 [LZYY]
     */
    public void setLzyy(String  lzyy){
        this.lzyy = lzyy ;
        this.modify("lzyy",lzyy);
    }

    /**
     * 设置 [WFRESULT]
     */
    public void setWfresult(String  wfresult){
        this.wfresult = wfresult ;
        this.modify("wfresult",wfresult);
    }

    /**
     * 设置 [LDZYTYPE]
     */
    public void setLdzytype(String  ldzytype){
        this.ldzytype = ldzytype ;
        this.modify("ldzytype",ldzytype);
    }

    /**
     * 设置 [LZQX]
     */
    public void setLzqx(String  lzqx){
        this.lzqx = lzqx ;
        this.modify("lzqx",lzqx);
    }

    /**
     * 设置 [SXRQ]
     */
    public void setSxrq(Timestamp  sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 设置 [LZSJ]
     */
    public void setLzsj(Timestamp  lzsj){
        this.lzsj = lzsj ;
        this.modify("lzsj",lzsj);
    }

    /**
     * 设置 [RZWH]
     */
    public void setRzwh(String  rzwh){
        this.rzwh = rzwh ;
        this.modify("rzwh",rzwh);
    }

    /**
     * 设置 [GZZT]
     */
    public void setGzzt(String  gzzt){
        this.gzzt = gzzt ;
        this.modify("gzzt",gzzt);
    }

    /**
     * 设置 [SFJRHMD]
     */
    public void setSfjrhmd(String  sfjrhmd){
        this.sfjrhmd = sfjrhmd ;
        this.modify("sfjrhmd",sfjrhmd);
    }

    /**
     * 设置 [CHECKSTATUS]
     */
    public void setCheckstatus(String  checkstatus){
        this.checkstatus = checkstatus ;
        this.modify("checkstatus",checkstatus);
    }

    /**
     * 设置 [SFTSDD]
     */
    public void setSftsdd(Integer  sftsdd){
        this.sftsdd = sftsdd ;
        this.modify("sftsdd",sftsdd);
    }

    /**
     * 设置 [LX]
     */
    public void setLx(String  lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [SFZFLZBCJ]
     */
    public void setSfzflzbcj(Integer  sfzflzbcj){
        this.sfzflzbcj = sfzflzbcj ;
        this.modify("sfzflzbcj",sfzflzbcj);
    }

    /**
     * 设置 [PCMBDSQDMXNAME]
     */
    public void setPcmbdsqdmxname(String  pcmbdsqdmxname){
        this.pcmbdsqdmxname = pcmbdsqdmxname ;
        this.modify("pcmbdsqdmxname",pcmbdsqdmxname);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [SFLDZY]
     */
    public void setSfldzy(Integer  sfldzy){
        this.sfldzy = sfldzy ;
        this.modify("sfldzy",sfldzy);
    }

    /**
     * 设置 [BCJSE]
     */
    public void setBcjse(Double  bcjse){
        this.bcjse = bcjse ;
        this.modify("bcjse",bcjse);
    }

    /**
     * 设置 [XRANK]
     */
    public void setXrank(String  xrank){
        this.xrank = xrank ;
        this.modify("xrank",xrank);
    }

    /**
     * 设置 [GZJSSJ]
     */
    public void setGzjssj(Timestamp  gzjssj){
        this.gzjssj = gzjssj ;
        this.modify("gzjssj",gzjssj);
    }

    /**
     * 设置 [DGLX]
     */
    public void setDglx(String  dglx){
        this.dglx = dglx ;
        this.modify("dglx",dglx);
    }

    /**
     * 设置 [ZJHM]
     */
    public void setZjhm(String  zjhm){
        this.zjhm = zjhm ;
        this.modify("zjhm",zjhm);
    }

    /**
     * 设置 [ORMORGSECTORNAME]
     */
    public void setOrmorgsectorname(String  ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
    }

    /**
     * 设置 [LZMTR]
     */
    public void setLzmtr(String  lzmtr){
        this.lzmtr = lzmtr ;
        this.modify("lzmtr",lzmtr);
    }

    /**
     * 设置 [LXDH]
     */
    public void setLxdh(String  lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [ORMPOSTNAME]
     */
    public void setOrmpostname(String  ormpostname){
        this.ormpostname = ormpostname ;
        this.modify("ormpostname",ormpostname);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [ZZID]
     */
    public void setZzid(String  zzid){
        this.zzid = zzid ;
        this.modify("zzid",zzid);
    }

    /**
     * 设置 [RANK]
     */
    public void setRank(String  rank){
        this.rank = rank ;
        this.modify("rank",rank);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [BMID]
     */
    public void setBmid(String  bmid){
        this.bmid = bmid ;
        this.modify("bmid",bmid);
    }

    /**
     * 设置 [ORMORGNAME]
     */
    public void setOrmorgname(String  ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [YZW]
     */
    public void setYzw(String  yzw){
        this.yzw = yzw ;
        this.modify("yzw",yzw);
    }

    /**
     * 设置 [YWG]
     */
    public void setYgw(String  ygw){
        this.ygw = ygw ;
        this.modify("ywg",ygw);
    }

    /**
     * 设置 [NL]
     */
    public void setNl(Integer  nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [ORMORGSECTORID2]
     */
    public void setOrmorgsectorid2(String  ormorgsectorid2){
        this.ormorgsectorid2 = ormorgsectorid2 ;
        this.modify("ormorgsectorid2",ormorgsectorid2);
    }

    /**
     * 设置 [ORMDUTYID]
     */
    public void setOrmdutyid(String  ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [PCMBDSQDID]
     */
    public void setPcmbdsqdid(String  pcmbdsqdid){
        this.pcmbdsqdid = pcmbdsqdid ;
        this.modify("pcmbdsqdid",pcmbdsqdid);
    }

    /**
     * 设置 [LZMTRID]
     */
    public void setLzmtrid(String  lzmtrid){
        this.lzmtrid = lzmtrid ;
        this.modify("lzmtrid",lzmtrid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [ORMPOSTID]
     */
    public void setOrmpostid(String  ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}

