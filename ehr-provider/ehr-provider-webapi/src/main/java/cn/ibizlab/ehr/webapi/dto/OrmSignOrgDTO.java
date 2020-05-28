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
 * 服务DTO对象[OrmSignOrgDTO]
 */
@Data
public class OrmSignOrgDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;

    /**
     * 属性 [ORMSIGNORGID]
     *
     */
    @JSONField(name = "ormsignorgid")
    @JsonProperty("ormsignorgid")
    private String ormsignorgid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ZZJC]
     *
     */
    @JSONField(name = "zzjc")
    @JsonProperty("zzjc")
    private String zzjc;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ORMSIGNORGNAME]
     *
     */
    @JSONField(name = "ormsignorgname")
    @JsonProperty("ormsignorgname")
    private String ormsignorgname;


    /**
     * 设置 [ORGCODE]
     */
    public void setOrgcode(String  orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [ZZJC]
     */
    public void setZzjc(String  zzjc){
        this.zzjc = zzjc ;
        this.modify("zzjc",zzjc);
    }

    /**
     * 设置 [ORMSIGNORGNAME]
     */
    public void setOrmsignorgname(String  ormsignorgname){
        this.ormsignorgname = ormsignorgname ;
        this.modify("ormsignorgname",ormsignorgname);
    }


}

