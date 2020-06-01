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
 * 服务DTO对象[PcmRzglDTO]
 */
@Data
public class PcmRzglDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [RZNX_COLOR]
     *
     */
    @JSONField(name = "rznx_color")
    @JsonProperty("rznx_color")
    private String rznxColor;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [NLDQ]
     *
     */
    @JSONField(name = "nldq")
    @JsonProperty("nldq")
    private Integer nldq;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ZJNX_COLOR]
     *
     */
    @JSONField(name = "zjnx_color")
    @JsonProperty("zjnx_color")
    private String zjnxColor;

    /**
     * 属性 [ZJ]
     *
     */
    @JSONField(name = "zj")
    @JsonProperty("zj")
    private String zj;

    /**
     * 属性 [DQZJXZW]
     *
     */
    @JSONField(name = "dqzjxzw")
    @JsonProperty("dqzjxzw")
    private String dqzjxzw;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [RZNX]
     *
     */
    @JSONField(name = "rznx")
    @JsonProperty("rznx")
    private Integer rznx;

    /**
     * 属性 [ZJNX]
     *
     */
    @JSONField(name = "zjnx")
    @JsonProperty("zjnx")
    private Integer zjnx;

    /**
     * 属性 [PCMRZGLNAME]
     *
     */
    @JSONField(name = "pcmrzglname")
    @JsonProperty("pcmrzglname")
    private String pcmrzglname;

    /**
     * 属性 [ZWRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zwrq" , format="yyyy-MM-dd")
    @JsonProperty("zwrq")
    private Timestamp zwrq;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [YGID]
     *
     */
    @JSONField(name = "ygid")
    @JsonProperty("ygid")
    private String ygid;

    /**
     * 属性 [PCMRZGLID]
     *
     */
    @JSONField(name = "pcmrzglid")
    @JsonProperty("pcmrzglid")
    private String pcmrzglid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [YGNAME]
     *
     */
    @JSONField(name = "ygname")
    @JsonProperty("ygname")
    private String ygname;

    /**
     * 属性 [SEX]
     *
     */
    @JSONField(name = "sex")
    @JsonProperty("sex")
    private String sex;

    /**
     * 属性 [ZJRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zjrq" , format="yyyy-MM-dd")
    @JsonProperty("zjrq")
    private Timestamp zjrq;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [NL]
     *
     */
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;


    /**
     * 设置 [RZNX_COLOR]
     */
    public void setRznxColor(String  rznxColor){
        this.rznxColor = rznxColor ;
        this.modify("rznx_color",rznxColor);
    }

    /**
     * 设置 [ORMORGSECTORNAME]
     */
    public void setOrmorgsectorname(String  ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
    }

    /**
     * 设置 [NLDQ]
     */
    public void setNldq(Integer  nldq){
        this.nldq = nldq ;
        this.modify("nldq",nldq);
    }

    /**
     * 设置 [ZJNX_COLOR]
     */
    public void setZjnxColor(String  zjnxColor){
        this.zjnxColor = zjnxColor ;
        this.modify("zjnx_color",zjnxColor);
    }

    /**
     * 设置 [ZJ]
     */
    public void setZj(String  zj){
        this.zj = zj ;
        this.modify("zj",zj);
    }

    /**
     * 设置 [DQZJXZW]
     */
    public void setDqzjxzw(String  dqzjxzw){
        this.dqzjxzw = dqzjxzw ;
        this.modify("dqzjxzw",dqzjxzw);
    }

    /**
     * 设置 [ORMORGNAME]
     */
    public void setOrmorgname(String  ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [RZNX]
     */
    public void setRznx(Integer  rznx){
        this.rznx = rznx ;
        this.modify("rznx",rznx);
    }

    /**
     * 设置 [ZJNX]
     */
    public void setZjnx(Integer  zjnx){
        this.zjnx = zjnx ;
        this.modify("zjnx",zjnx);
    }

    /**
     * 设置 [PCMRZGLNAME]
     */
    public void setPcmrzglname(String  pcmrzglname){
        this.pcmrzglname = pcmrzglname ;
        this.modify("pcmrzglname",pcmrzglname);
    }

    /**
     * 设置 [ZWRQ]
     */
    public void setZwrq(Timestamp  zwrq){
        this.zwrq = zwrq ;
        this.modify("zwrq",zwrq);
    }

    /**
     * 设置 [YGID]
     */
    public void setYgid(String  ygid){
        this.ygid = ygid ;
        this.modify("ygid",ygid);
    }

    /**
     * 设置 [YGNAME]
     */
    public void setYgname(String  ygname){
        this.ygname = ygname ;
        this.modify("ygname",ygname);
    }

    /**
     * 设置 [SEX]
     */
    public void setSex(String  sex){
        this.sex = sex ;
        this.modify("sex",sex);
    }

    /**
     * 设置 [ZJRQ]
     */
    public void setZjrq(Timestamp  zjrq){
        this.zjrq = zjrq ;
        this.modify("zjrq",zjrq);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [NL]
     */
    public void setNl(Integer  nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [GW]
     */
    public void setGw(String  gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }


}

