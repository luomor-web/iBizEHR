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
 * 服务DTO对象[TrmTrafficDTO]
 */
@Data
public class TrmTrafficDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [TRMTRAFFICID]
     *
     */
    @JSONField(name = "trmtrafficid")
    @JsonProperty("trmtrafficid")
    private String trmtrafficid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [JTFS]
     *
     */
    @JSONField(name = "jtfs")
    @JsonProperty("jtfs")
    private String jtfs;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [ZM]
     *
     */
    @JSONField(name = "zm")
    @JsonProperty("zm")
    private String zm;

    /**
     * 属性 [TRMTRAFFICNAME]
     *
     */
    @JSONField(name = "trmtrafficname")
    @JsonProperty("trmtrafficname")
    private String trmtrafficname;

    /**
     * 属性 [XLMC]
     *
     */
    @JSONField(name = "xlmc")
    @JsonProperty("xlmc")
    private String xlmc;

    /**
     * 属性 [CK]
     *
     */
    @JSONField(name = "ck")
    @JsonProperty("ck")
    private String ck;

    /**
     * 属性 [MDD]
     *
     */
    @JSONField(name = "mdd")
    @JsonProperty("mdd")
    private String mdd;

    /**
     * 属性 [CFD]
     *
     */
    @JSONField(name = "cfd")
    @JsonProperty("cfd")
    private String cfd;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [TRMTRAINADDRESSNAME]
     *
     */
    @JSONField(name = "trmtrainaddressname")
    @JsonProperty("trmtrainaddressname")
    private String trmtrainaddressname;

    /**
     * 属性 [TRMTRAINADDRESSID]
     *
     */
    @JSONField(name = "trmtrainaddressid")
    @JsonProperty("trmtrainaddressid")
    private String trmtrainaddressid;


    /**
     * 设置 [JTFS]
     */
    public void setJtfs(String  jtfs){
        this.jtfs = jtfs ;
        this.modify("jtfs",jtfs);
    }

    /**
     * 设置 [ZM]
     */
    public void setZm(String  zm){
        this.zm = zm ;
        this.modify("zm",zm);
    }

    /**
     * 设置 [TRMTRAFFICNAME]
     */
    public void setTrmtrafficname(String  trmtrafficname){
        this.trmtrafficname = trmtrafficname ;
        this.modify("trmtrafficname",trmtrafficname);
    }

    /**
     * 设置 [XLMC]
     */
    public void setXlmc(String  xlmc){
        this.xlmc = xlmc ;
        this.modify("xlmc",xlmc);
    }

    /**
     * 设置 [CK]
     */
    public void setCk(String  ck){
        this.ck = ck ;
        this.modify("ck",ck);
    }

    /**
     * 设置 [MDD]
     */
    public void setMdd(String  mdd){
        this.mdd = mdd ;
        this.modify("mdd",mdd);
    }

    /**
     * 设置 [CFD]
     */
    public void setCfd(String  cfd){
        this.cfd = cfd ;
        this.modify("cfd",cfd);
    }

    /**
     * 设置 [TRMTRAINADDRESSID]
     */
    public void setTrmtrainaddressid(String  trmtrainaddressid){
        this.trmtrainaddressid = trmtrainaddressid ;
        this.modify("trmtrainaddressid",trmtrainaddressid);
    }


}

