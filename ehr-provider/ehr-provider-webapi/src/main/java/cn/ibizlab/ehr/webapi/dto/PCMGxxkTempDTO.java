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
 * 服务DTO对象[PCMGxxkTempDTO]
 */
@Data
public class PCMGxxkTempDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PCMGXXKTEMPID]
     *
     */
    @JSONField(name = "pcmgxxktempid")
    @JsonProperty("pcmgxxktempid")
    private String pcmgxxktempid;

    /**
     * 属性 [PCMGXXKTEMPNAME]
     *
     */
    @JSONField(name = "pcmgxxktempname")
    @JsonProperty("pcmgxxktempname")
    private String pcmgxxktempname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [ND2]
     *
     */
    @JSONField(name = "nd2")
    @JsonProperty("nd2")
    private String nd2;

    /**
     * 属性 [PCMGXMLNAME]
     *
     */
    @JSONField(name = "pcmgxmlname")
    @JsonProperty("pcmgxmlname")
    private String pcmgxmlname;

    /**
     * 属性 [PCMXKMLNAME]
     *
     */
    @JSONField(name = "pcmxkmlname")
    @JsonProperty("pcmxkmlname")
    private String pcmxkmlname;

    /**
     * 属性 [PCMXKMLID]
     *
     */
    @JSONField(name = "pcmxkmlid")
    @JsonProperty("pcmxkmlid")
    private String pcmxkmlid;

    /**
     * 属性 [PCMGXMLID]
     *
     */
    @JSONField(name = "pcmgxmlid")
    @JsonProperty("pcmgxmlid")
    private String pcmgxmlid;


    /**
     * 设置 [PCMGXXKTEMPNAME]
     */
    public void setPcmgxxktempname(String  pcmgxxktempname){
        this.pcmgxxktempname = pcmgxxktempname ;
        this.modify("pcmgxxktempname",pcmgxxktempname);
    }

    /**
     * 设置 [PCMXKMLID]
     */
    public void setPcmxkmlid(String  pcmxkmlid){
        this.pcmxkmlid = pcmxkmlid ;
        this.modify("pcmxkmlid",pcmxkmlid);
    }

    /**
     * 设置 [PCMGXMLID]
     */
    public void setPcmgxmlid(String  pcmgxmlid){
        this.pcmgxmlid = pcmgxmlid ;
        this.modify("pcmgxmlid",pcmgxmlid);
    }


}

