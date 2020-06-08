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
 * 服务DTO对象[PimContractSignOrgDTO]
 */
@Data
public class PimContractSignOrgDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CONTRACTSIGNORGNAME]
     *
     */
    @JSONField(name = "contractsignorgname")
    @JsonProperty("contractsignorgname")
    private String contractsignorgname;

    /**
     * 属性 [CONTRACTSIGNORGID]
     *
     */
    @JSONField(name = "contractsignorgid")
    @JsonProperty("contractsignorgid")
    private String contractsignorgid;

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
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [ISDEFAULTSIGNORG]
     *
     */
    @JSONField(name = "isdefaultsignorg")
    @JsonProperty("isdefaultsignorg")
    private Integer isdefaultsignorg;

    /**
     * 属性 [ORMSIGNORGNAME]
     *
     */
    @JSONField(name = "ormsignorgname")
    @JsonProperty("ormsignorgname")
    private String ormsignorgname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMSIGNORGID]
     *
     */
    @JSONField(name = "ormsignorgid")
    @JsonProperty("ormsignorgid")
    private String ormsignorgid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [CONTRACTSIGNORGNAME]
     */
    public void setContractsignorgname(String  contractsignorgname){
        this.contractsignorgname = contractsignorgname ;
        this.modify("contractsignorgname",contractsignorgname);
    }

    /**
     * 设置 [ISDEFAULTSIGNORG]
     */
    public void setIsdefaultsignorg(Integer  isdefaultsignorg){
        this.isdefaultsignorg = isdefaultsignorg ;
        this.modify("isdefaultsignorg",isdefaultsignorg);
    }

    /**
     * 设置 [ORMSIGNORGID]
     */
    public void setOrmsignorgid(String  ormsignorgid){
        this.ormsignorgid = ormsignorgid ;
        this.modify("ormsignorgid",ormsignorgid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

