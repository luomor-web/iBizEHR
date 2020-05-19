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
 * 服务DTO对象[MsgAccountDetailDTO]
 */
@Data
public class MsgAccountDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MSGACCOUNTDETAILNAME]
     *
     */
    @JSONField(name = "msgaccountdetailname")
    @JsonProperty("msgaccountdetailname")
    private String msgaccountdetailname;

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
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [MSGACCOUNTDETAILID]
     *
     */
    @JSONField(name = "msgaccountdetailid")
    @JsonProperty("msgaccountdetailid")
    private String msgaccountdetailid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [MAJORMSGACCOUNTNAME]
     *
     */
    @JSONField(name = "majormsgaccountname")
    @JsonProperty("majormsgaccountname")
    private String majormsgaccountname;

    /**
     * 属性 [MINORMSGACCOUNTNAME]
     *
     */
    @JSONField(name = "minormsgaccountname")
    @JsonProperty("minormsgaccountname")
    private String minormsgaccountname;

    /**
     * 属性 [MAJORMSGACCOUNTID]
     *
     */
    @JSONField(name = "majormsgaccountid")
    @JsonProperty("majormsgaccountid")
    private String majormsgaccountid;

    /**
     * 属性 [MINORMSGACCOUNTID]
     *
     */
    @JSONField(name = "minormsgaccountid")
    @JsonProperty("minormsgaccountid")
    private String minormsgaccountid;


    /**
     * 设置 [MSGACCOUNTDETAILNAME]
     */
    public void setMsgaccountdetailname(String  msgaccountdetailname){
        this.msgaccountdetailname = msgaccountdetailname ;
        this.modify("msgaccountdetailname",msgaccountdetailname);
    }

    /**
     * 设置 [MAJORMSGACCOUNTID]
     */
    public void setMajormsgaccountid(String  majormsgaccountid){
        this.majormsgaccountid = majormsgaccountid ;
        this.modify("majormsgaccountid",majormsgaccountid);
    }

    /**
     * 设置 [MINORMSGACCOUNTID]
     */
    public void setMinormsgaccountid(String  minormsgaccountid){
        this.minormsgaccountid = minormsgaccountid ;
        this.modify("minormsgaccountid",minormsgaccountid);
    }


}

