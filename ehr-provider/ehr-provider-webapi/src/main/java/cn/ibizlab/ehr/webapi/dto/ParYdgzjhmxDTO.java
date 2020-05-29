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
 * 服务DTO对象[ParYdgzjhmxDTO]
 */
@Data
public class ParYdgzjhmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [WCBZ]
     *
     */
    @JSONField(name = "wcbz")
    @JsonProperty("wcbz")
    private String wcbz;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [QZ]
     *
     */
    @JSONField(name = "qz")
    @JsonProperty("qz")
    private Integer qz;

    /**
     * 属性 [ZPPF]
     *
     */
    @JSONField(name = "zppf")
    @JsonProperty("zppf")
    private Integer zppf;

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
     * 属性 [WCQK]
     *
     */
    @JSONField(name = "wcqk")
    @JsonProperty("wcqk")
    private String wcqk;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PARYDGZJHMXID]
     *
     */
    @JSONField(name = "parydgzjhmxid")
    @JsonProperty("parydgzjhmxid")
    private String parydgzjhmxid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [XZHTJGZJH]
     *
     */
    @JSONField(name = "xzhtjgzjh")
    @JsonProperty("xzhtjgzjh")
    private String xzhtjgzjh;

    /**
     * 属性 [ZBLX]
     *
     */
    @JSONField(name = "zblx")
    @JsonProperty("zblx")
    private String zblx;

    /**
     * 属性 [NWCRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "nwcrq" , format="yyyy-MM-dd")
    @JsonProperty("nwcrq")
    private Timestamp nwcrq;

    /**
     * 属性 [PARYDGZJHMXNAME]
     *
     */
    @JSONField(name = "parydgzjhmxname")
    @JsonProperty("parydgzjhmxname")
    private String parydgzjhmxname;

    /**
     * 属性 [PARYDGZJHNAME]
     *
     */
    @JSONField(name = "parydgzjhname")
    @JsonProperty("parydgzjhname")
    private String parydgzjhname;

    /**
     * 属性 [PARYDGZJHID]
     *
     */
    @JSONField(name = "parydgzjhid")
    @JsonProperty("parydgzjhid")
    private String parydgzjhid;


    /**
     * 设置 [WCBZ]
     */
    public void setWcbz(String  wcbz){
        this.wcbz = wcbz ;
        this.modify("wcbz",wcbz);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [QZ]
     */
    public void setQz(Integer  qz){
        this.qz = qz ;
        this.modify("qz",qz);
    }

    /**
     * 设置 [ZPPF]
     */
    public void setZppf(Integer  zppf){
        this.zppf = zppf ;
        this.modify("zppf",zppf);
    }

    /**
     * 设置 [WCQK]
     */
    public void setWcqk(String  wcqk){
        this.wcqk = wcqk ;
        this.modify("wcqk",wcqk);
    }

    /**
     * 设置 [XZHTJGZJH]
     */
    public void setXzhtjgzjh(String  xzhtjgzjh){
        this.xzhtjgzjh = xzhtjgzjh ;
        this.modify("xzhtjgzjh",xzhtjgzjh);
    }

    /**
     * 设置 [ZBLX]
     */
    public void setZblx(String  zblx){
        this.zblx = zblx ;
        this.modify("zblx",zblx);
    }

    /**
     * 设置 [NWCRQ]
     */
    public void setNwcrq(Timestamp  nwcrq){
        this.nwcrq = nwcrq ;
        this.modify("nwcrq",nwcrq);
    }

    /**
     * 设置 [PARYDGZJHMXNAME]
     */
    public void setParydgzjhmxname(String  parydgzjhmxname){
        this.parydgzjhmxname = parydgzjhmxname ;
        this.modify("parydgzjhmxname",parydgzjhmxname);
    }

    /**
     * 设置 [PARYDGZJHID]
     */
    public void setParydgzjhid(String  parydgzjhid){
        this.parydgzjhid = parydgzjhid ;
        this.modify("parydgzjhid",parydgzjhid);
    }


}

