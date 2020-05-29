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
 * 服务DTO对象[PimFilebatvhuploadDTO]
 */
@Data
public class PimFilebatvhuploadDTO extends DTOBase implements Serializable {

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
     * 属性 [PIMFILEBATVHUPLOADNAME]
     *
     */
    @JSONField(name = "pimfilebatvhuploadname")
    @JsonProperty("pimfilebatvhuploadname")
    private String pimfilebatvhuploadname;

    /**
     * 属性 [FILES]
     *
     */
    @JSONField(name = "files")
    @JsonProperty("files")
    private String files;

    /**
     * 属性 [PIMFILEBATVHUPLOADID]
     *
     */
    @JSONField(name = "pimfilebatvhuploadid")
    @JsonProperty("pimfilebatvhuploadid")
    private String pimfilebatvhuploadid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;


    /**
     * 设置 [PIMFILEBATVHUPLOADNAME]
     */
    public void setPimfilebatvhuploadname(String  pimfilebatvhuploadname){
        this.pimfilebatvhuploadname = pimfilebatvhuploadname ;
        this.modify("pimfilebatvhuploadname",pimfilebatvhuploadname);
    }

    /**
     * 设置 [FILES]
     */
    public void setFiles(String  files){
        this.files = files ;
        this.modify("files",files);
    }


}

