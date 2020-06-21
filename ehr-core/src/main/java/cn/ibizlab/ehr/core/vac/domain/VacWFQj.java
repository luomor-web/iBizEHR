package cn.ibizlab.ehr.core.vac.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[请假（WF）]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_WFQJ",resultMap = "VacWFQjResultMap")
public class VacWFQj extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门领导
     */
    @TableField(value = "deptleader")
    @JSONField(name = "deptleader")
    @JsonProperty("deptleader")
    private String deptleader;
    /**
     * 请假（WF）标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfqjid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "wfqjid")
    @JsonProperty("wfqjid")
    private String wfqjid;
    /**
     * 请销假状态
     */
    @TableField(value = "qjstate")
    @JSONField(name = "qjstate")
    @JsonProperty("qjstate")
    private String qjstate;
    /**
     * 请假（WF）名称
     */
    @TableField(value = "wfqjname")
    @JSONField(name = "wfqjname")
    @JsonProperty("wfqjname")
    private String wfqjname;
    /**
     * 回填结果
     */
    @TableField(value = "wfresult")
    @JSONField(name = "wfresult")
    @JsonProperty("wfresult")
    private String wfresult;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 设置 [部门领导]
     */
    public void setDeptleader(String deptleader){
        this.deptleader = deptleader ;
        this.modify("deptleader",deptleader);
    }

    /**
     * 设置 [请销假状态]
     */
    public void setQjstate(String qjstate){
        this.qjstate = qjstate ;
        this.modify("qjstate",qjstate);
    }

    /**
     * 设置 [请假（WF）名称]
     */
    public void setWfqjname(String wfqjname){
        this.wfqjname = wfqjname ;
        this.modify("wfqjname",wfqjname);
    }

    /**
     * 设置 [回填结果]
     */
    public void setWfresult(String wfresult){
        this.wfresult = wfresult ;
        this.modify("wfresult",wfresult);
    }


}


