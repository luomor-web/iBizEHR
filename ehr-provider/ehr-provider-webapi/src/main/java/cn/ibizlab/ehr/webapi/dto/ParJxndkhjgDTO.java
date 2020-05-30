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
 * 服务DTO对象[ParJxndkhjgDTO]
 */
@Data
public class ParJxndkhjgDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [KHND]
     *
     */
    @JSONField(name = "khnd")
    @JsonProperty("khnd")
    private String khnd;

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
     * 属性 [KHZQ]
     *
     */
    @JSONField(name = "khzq")
    @JsonProperty("khzq")
    private String khzq;

    /**
     * 属性 [KHPGDJ]
     *
     */
    @JSONField(name = "khpgdj")
    @JsonProperty("khpgdj")
    private String khpgdj;

    /**
     * 属性 [PM]
     *
     */
    @JSONField(name = "pm")
    @JsonProperty("pm")
    private Integer pm;

    /**
     * 属性 [PARJXNDKHJGNAME]
     *
     */
    @JSONField(name = "parjxndkhjgname")
    @JsonProperty("parjxndkhjgname")
    private String parjxndkhjgname;

    /**
     * 属性 [SFTX]
     *
     */
    @JSONField(name = "sftx")
    @JsonProperty("sftx")
    private Integer sftx;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PARJXNDKHJGID]
     *
     */
    @JSONField(name = "parjxndkhjgid")
    @JsonProperty("parjxndkhjgid")
    private String parjxndkhjgid;

    /**
     * 属性 [ZF]
     *
     */
    @JSONField(name = "zf")
    @JsonProperty("zf")
    private Double zf;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [KHND]
     */
    public void setKhnd(String  khnd){
        this.khnd = khnd ;
        this.modify("khnd",khnd);
    }

    /**
     * 设置 [KHZQ]
     */
    public void setKhzq(String  khzq){
        this.khzq = khzq ;
        this.modify("khzq",khzq);
    }

    /**
     * 设置 [KHPGDJ]
     */
    public void setKhpgdj(String  khpgdj){
        this.khpgdj = khpgdj ;
        this.modify("khpgdj",khpgdj);
    }

    /**
     * 设置 [PM]
     */
    public void setPm(Integer  pm){
        this.pm = pm ;
        this.modify("pm",pm);
    }

    /**
     * 设置 [PARJXNDKHJGNAME]
     */
    public void setParjxndkhjgname(String  parjxndkhjgname){
        this.parjxndkhjgname = parjxndkhjgname ;
        this.modify("parjxndkhjgname",parjxndkhjgname);
    }

    /**
     * 设置 [SFTX]
     */
    public void setSftx(Integer  sftx){
        this.sftx = sftx ;
        this.modify("sftx",sftx);
    }

    /**
     * 设置 [ZF]
     */
    public void setZf(Double  zf){
        this.zf = zf ;
        this.modify("zf",zf);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

