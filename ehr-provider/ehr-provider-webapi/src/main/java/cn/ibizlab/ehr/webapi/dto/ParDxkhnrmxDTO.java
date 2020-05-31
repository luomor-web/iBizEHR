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
 * 服务DTO对象[ParDxkhnrmxDTO]
 */
@Data
public class ParDxkhnrmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PARDXKHNRMXID]
     *
     */
    @JSONField(name = "pardxkhnrmxid")
    @JsonProperty("pardxkhnrmxid")
    private String pardxkhnrmxid;

    /**
     * 属性 [ZQ]
     *
     */
    @JSONField(name = "zq")
    @JsonProperty("zq")
    private String zq;

    /**
     * 属性 [PARDXKHNRMXNAME]
     *
     */
    @JSONField(name = "pardxkhnrmxname")
    @JsonProperty("pardxkhnrmxname")
    private String pardxkhnrmxname;

    /**
     * 属性 [KHDF]
     *
     */
    @JSONField(name = "khdf")
    @JsonProperty("khdf")
    private Double khdf;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PFZT]
     *
     */
    @JSONField(name = "pfzt")
    @JsonProperty("pfzt")
    private String pfzt;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

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
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [PARKHZCMXNAME]
     *
     */
    @JSONField(name = "parkhzcmxname")
    @JsonProperty("parkhzcmxname")
    private String parkhzcmxname;

    /**
     * 属性 [KHDX]
     *
     */
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;

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
     * 属性 [PARKHZCMXID]
     *
     */
    @JSONField(name = "parkhzcmxid")
    @JsonProperty("parkhzcmxid")
    private String parkhzcmxid;


    /**
     * 设置 [ZQ]
     */
    public void setZq(String  zq){
        this.zq = zq ;
        this.modify("zq",zq);
    }

    /**
     * 设置 [PARDXKHNRMXNAME]
     */
    public void setPardxkhnrmxname(String  pardxkhnrmxname){
        this.pardxkhnrmxname = pardxkhnrmxname ;
        this.modify("pardxkhnrmxname",pardxkhnrmxname);
    }

    /**
     * 设置 [KHDF]
     */
    public void setKhdf(Double  khdf){
        this.khdf = khdf ;
        this.modify("khdf",khdf);
    }

    /**
     * 设置 [PFZT]
     */
    public void setPfzt(String  pfzt){
        this.pfzt = pfzt ;
        this.modify("pfzt",pfzt);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [PARKHZCMXID]
     */
    public void setParkhzcmxid(String  parkhzcmxid){
        this.parkhzcmxid = parkhzcmxid ;
        this.modify("parkhzcmxid",parkhzcmxid);
    }


}

