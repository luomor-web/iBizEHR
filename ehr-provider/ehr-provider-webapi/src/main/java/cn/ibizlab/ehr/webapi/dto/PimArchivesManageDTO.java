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
 * 服务DTO对象[PimArchivesManageDTO]
 */
@Data
public class PimArchivesManageDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ARCHIVESMANAGENAME]
     *
     */
    @JSONField(name = "archivesmanagename")
    @JsonProperty("archivesmanagename")
    private String archivesmanagename;

    /**
     * 属性 [ARCHIVESNO]
     *
     */
    @JSONField(name = "archivesno")
    @JsonProperty("archivesno")
    private String archivesno;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ARCHIVESMANAGEID]
     *
     */
    @JSONField(name = "archivesmanageid")
    @JsonProperty("archivesmanageid")
    private String archivesmanageid;


    /**
     * 设置 [ARCHIVESMANAGENAME]
     */
    public void setArchivesmanagename(String  archivesmanagename){
        this.archivesmanagename = archivesmanagename ;
        this.modify("archivesmanagename",archivesmanagename);
    }

    /**
     * 设置 [ARCHIVESNO]
     */
    public void setArchivesno(String  archivesno){
        this.archivesno = archivesno ;
        this.modify("archivesno",archivesno);
    }


}
