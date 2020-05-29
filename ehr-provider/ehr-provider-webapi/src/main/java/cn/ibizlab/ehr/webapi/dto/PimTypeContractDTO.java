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
 * 服务DTO对象[PimTypeContractDTO]
 */
@Data
public class PimTypeContractDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ISORNO]
     *
     */
    @JSONField(name = "isorno")
    @JsonProperty("isorno")
    private Integer isorno;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SORTNO]
     *
     */
    @JSONField(name = "sortno")
    @JsonProperty("sortno")
    private Integer sortno;

    /**
     * 属性 [PIMTYPECONTRACTID]
     *
     */
    @JSONField(name = "pimtypecontractid")
    @JsonProperty("pimtypecontractid")
    private String pimtypecontractid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CONTRACTLIFE]
     *
     */
    @JSONField(name = "contractlife")
    @JsonProperty("contractlife")
    private Integer contractlife;

    /**
     * 属性 [TYPECODE]
     *
     */
    @JSONField(name = "typecode")
    @JsonProperty("typecode")
    private String typecode;

    /**
     * 属性 [PIMTYPECONTRACTNAME]
     *
     */
    @JSONField(name = "pimtypecontractname")
    @JsonProperty("pimtypecontractname")
    private String pimtypecontractname;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;


    /**
     * 设置 [ISORNO]
     */
    public void setIsorno(Integer  isorno){
        this.isorno = isorno ;
        this.modify("isorno",isorno);
    }

    /**
     * 设置 [SORTNO]
     */
    public void setSortno(Integer  sortno){
        this.sortno = sortno ;
        this.modify("sortno",sortno);
    }

    /**
     * 设置 [CONTRACTLIFE]
     */
    public void setContractlife(Integer  contractlife){
        this.contractlife = contractlife ;
        this.modify("contractlife",contractlife);
    }

    /**
     * 设置 [TYPECODE]
     */
    public void setTypecode(String  typecode){
        this.typecode = typecode ;
        this.modify("typecode",typecode);
    }

    /**
     * 设置 [PIMTYPECONTRACTNAME]
     */
    public void setPimtypecontractname(String  pimtypecontractname){
        this.pimtypecontractname = pimtypecontractname ;
        this.modify("pimtypecontractname",pimtypecontractname);
    }


}

