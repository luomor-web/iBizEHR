package cn.ibizlab.ehr.core.pim.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[附件批量上传]
 */
@Data
@TableName(value = "T_PIMFILEBATVHUPLOAD",resultMap = "PIMFILEBATVHUPLOADResultMap")
public class PIMFILEBATVHUPLOAD extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 附件批量上传名称
     */
    @TableField(value = "pimfilebatvhuploadname")
    @JSONField(name = "pimfilebatvhuploadname")
    @JsonProperty("pimfilebatvhuploadname")
    private String pimfilebatvhuploadname;
    /**
     * 附件
     */
    @TableField(value = "files")
    @JSONField(name = "files")
    @JsonProperty("files")
    private String files;
    /**
     * 附件批量上传标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimfilebatvhuploadid",type=IdType.UUID)
    @JSONField(name = "pimfilebatvhuploadid")
    @JsonProperty("pimfilebatvhuploadid")
    private String pimfilebatvhuploadid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;



    /**
     * 设置 [附件批量上传名称]
     */
    public void setPimfilebatvhuploadname(String pimfilebatvhuploadname){
        this.pimfilebatvhuploadname = pimfilebatvhuploadname ;
        this.modify("pimfilebatvhuploadname",pimfilebatvhuploadname);
    }
    /**
     * 设置 [附件]
     */
    public void setFiles(String files){
        this.files = files ;
        this.modify("files",files);
    }
}





