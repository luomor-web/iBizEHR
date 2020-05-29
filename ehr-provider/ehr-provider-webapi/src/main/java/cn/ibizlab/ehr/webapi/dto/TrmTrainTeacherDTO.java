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
 * 服务DTO对象[TrmTrainTeacherDTO]
 */
@Data
public class TrmTrainTeacherDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ZJKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zjkssj" , format="yyyy-MM-dd")
    @JsonProperty("zjkssj")
    private Timestamp zjkssj;

    /**
     * 属性 [TRMTRAINTEACHERID]
     *
     */
    @JSONField(name = "trmtrainteacherid")
    @JsonProperty("trmtrainteacherid")
    private String trmtrainteacherid;

    /**
     * 属性 [SFGX]
     *
     */
    @JSONField(name = "sfgx")
    @JsonProperty("sfgx")
    private Integer sfgx;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PXJSJB]
     *
     */
    @JSONField(name = "pxjsjb")
    @JsonProperty("pxjsjb")
    private String pxjsjb;

    /**
     * 属性 [ZP]
     *
     */
    @JSONField(name = "zp")
    @JsonProperty("zp")
    private String zp;

    /**
     * 属性 [JF]
     *
     */
    @JSONField(name = "jf")
    @JsonProperty("jf")
    private Double jf;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [JSLB]
     *
     */
    @JSONField(name = "jslb")
    @JsonProperty("jslb")
    private String jslb;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [JSKC]
     *
     */
    @JSONField(name = "jskc")
    @JsonProperty("jskc")
    private String jskc;

    /**
     * 属性 [TZ]
     *
     */
    @JSONField(name = "tz")
    @JsonProperty("tz")
    private String tz;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [JSBM]
     *
     */
    @JSONField(name = "jsbm")
    @JsonProperty("jsbm")
    private String jsbm;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [JSLX]
     *
     */
    @JSONField(name = "jslx")
    @JsonProperty("jslx")
    private String jslx;

    /**
     * 属性 [TRMTRAINTEACHERNAME]
     *
     */
    @JSONField(name = "trmtrainteachername")
    @JsonProperty("trmtrainteachername")
    private String trmtrainteachername;

    /**
     * 属性 [DJ]
     *
     */
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private String dj;

    /**
     * 属性 [CJGS]
     *
     */
    @JSONField(name = "cjgs")
    @JsonProperty("cjgs")
    private String cjgs;

    /**
     * 属性 [SFFC]
     *
     */
    @JSONField(name = "sffc")
    @JsonProperty("sffc")
    private Integer sffc;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PJ]
     *
     */
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [NL]
     *
     */
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;

    /**
     * 属性 [TRMTRAINAGENCYNAME]
     *
     */
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;

    /**
     * 属性 [XB]
     *
     */
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [JGLB]
     *
     */
    @JSONField(name = "jglb")
    @JsonProperty("jglb")
    private String jglb;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [AHTC]
     *
     */
    @JSONField(name = "ahtc")
    @JsonProperty("ahtc")
    private String ahtc;

    /**
     * 属性 [DZYX]
     *
     */
    @JSONField(name = "dzyx")
    @JsonProperty("dzyx")
    private String dzyx;

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
     * 属性 [TRMTRAINAGENCYID]
     *
     */
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;


    /**
     * 设置 [ZJKSSJ]
     */
    public void setZjkssj(Timestamp  zjkssj){
        this.zjkssj = zjkssj ;
        this.modify("zjkssj",zjkssj);
    }

    /**
     * 设置 [SFGX]
     */
    public void setSfgx(Integer  sfgx){
        this.sfgx = sfgx ;
        this.modify("sfgx",sfgx);
    }

    /**
     * 设置 [PXJSJB]
     */
    public void setPxjsjb(String  pxjsjb){
        this.pxjsjb = pxjsjb ;
        this.modify("pxjsjb",pxjsjb);
    }

    /**
     * 设置 [ZP]
     */
    public void setZp(String  zp){
        this.zp = zp ;
        this.modify("zp",zp);
    }

    /**
     * 设置 [JF]
     */
    public void setJf(Double  jf){
        this.jf = jf ;
        this.modify("jf",jf);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [JSLB]
     */
    public void setJslb(String  jslb){
        this.jslb = jslb ;
        this.modify("jslb",jslb);
    }

    /**
     * 设置 [JSKC]
     */
    public void setJskc(String  jskc){
        this.jskc = jskc ;
        this.modify("jskc",jskc);
    }

    /**
     * 设置 [TZ]
     */
    public void setTz(String  tz){
        this.tz = tz ;
        this.modify("tz",tz);
    }

    /**
     * 设置 [JSBM]
     */
    public void setJsbm(String  jsbm){
        this.jsbm = jsbm ;
        this.modify("jsbm",jsbm);
    }

    /**
     * 设置 [JSLX]
     */
    public void setJslx(String  jslx){
        this.jslx = jslx ;
        this.modify("jslx",jslx);
    }

    /**
     * 设置 [TRMTRAINTEACHERNAME]
     */
    public void setTrmtrainteachername(String  trmtrainteachername){
        this.trmtrainteachername = trmtrainteachername ;
        this.modify("trmtrainteachername",trmtrainteachername);
    }

    /**
     * 设置 [DJ]
     */
    public void setDj(String  dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }

    /**
     * 设置 [CJGS]
     */
    public void setCjgs(String  cjgs){
        this.cjgs = cjgs ;
        this.modify("cjgs",cjgs);
    }

    /**
     * 设置 [SFFC]
     */
    public void setSffc(Integer  sffc){
        this.sffc = sffc ;
        this.modify("sffc",sffc);
    }

    /**
     * 设置 [PJ]
     */
    public void setPj(String  pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [NL]
     */
    public void setNl(Integer  nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [XB]
     */
    public void setXb(String  xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [ZJHM]
     */
    public void setZjhm(String  zjhm){
        this.zjhm = zjhm ;
        this.modify("zjhm",zjhm);
    }

    /**
     * 设置 [PIMPERSONNAME]
     */
    public void setPimpersonname(String  pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [LXDH]
     */
    public void setLxdh(String  lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [JGLB]
     */
    public void setJglb(String  jglb){
        this.jglb = jglb ;
        this.modify("jglb",jglb);
    }

    /**
     * 设置 [AHTC]
     */
    public void setAhtc(String  ahtc){
        this.ahtc = ahtc ;
        this.modify("ahtc",ahtc);
    }

    /**
     * 设置 [DZYX]
     */
    public void setDzyx(String  dzyx){
        this.dzyx = dzyx ;
        this.modify("dzyx",dzyx);
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
     * 设置 [TRMTRAINAGENCYID]
     */
    public void setTrmtrainagencyid(String  trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}

