package cn.ibizlab.ehr.core.wf.domain;

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
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
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
 * 实体[工作流预定义处理]
 */
@Data
@TableName(value = "T_WFCUSTOMPROCESS",resultMap = "WFCustomProcessResultMap")
public class WFCustomProcess extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 处理版本
     */
    @TableField(value = "version")
    @JSONField(name = "version")
    @JsonProperty("version")
    private String version;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
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
     * 工作流预定义处理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfcustomprocessid",type=IdType.UUID)
    @JSONField(name = "wfcustomprocessid")
    @JsonProperty("wfcustomprocessid")
    private String wfcustomprocessid;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 处理对象
     */
    @TableField(value = "processobject")
    @JSONField(name = "processobject")
    @JsonProperty("processobject")
    private String processobject;
    /**
     * 工作流预定义处理名称
     */
    @TableField(value = "wfcustomprocessname")
    @JSONField(name = "wfcustomprocessname")
    @JsonProperty("wfcustomprocessname")
    private String wfcustomprocessname;



    /**
     * 设置 [处理版本]
     */
    public void setVersion(String version){
        this.version = version ;
        this.modify("version",version);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [处理对象]
     */
    public void setProcessobject(String processobject){
        this.processobject = processobject ;
        this.modify("processobject",processobject);
    }
    /**
     * 设置 [工作流预定义处理名称]
     */
    public void setWfcustomprocessname(String wfcustomprocessname){
        this.wfcustomprocessname = wfcustomprocessname ;
        this.modify("wfcustomprocessname",wfcustomprocessname);
    }

}


