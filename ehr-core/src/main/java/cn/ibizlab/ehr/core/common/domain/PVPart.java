package cn.ibizlab.ehr.core.common.domain;

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
 * 实体[门户视图部件]
 */
@Data
@TableName(value = "T_PVPART",resultMap = "PVPartResultMap")
public class PVPart extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 门户视图部件标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pvpartid",type=IdType.UUID)
    @JSONField(name = "pvpartid")
    @JsonProperty("pvpartid")
    private String pvpartid;
    /**
     * 部件类型
     */
    @TableField(value = "pvparttype")
    @JSONField(name = "pvparttype")
    @JsonProperty("pvparttype")
    private String pvparttype;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 控件标识
     */
    @TableField(value = "ctrlid")
    @JSONField(name = "ctrlid")
    @JsonProperty("ctrlid")
    private String ctrlid;
    /**
     * 门户视图部件名称
     */
    @TableField(value = "pvpartname")
    @JSONField(name = "pvpartname")
    @JsonProperty("pvpartname")
    private String pvpartname;
    /**
     * 门户视图
     */
    @TableField(exist = false)
    @JSONField(name = "portalpagename")
    @JsonProperty("portalpagename")
    private String portalpagename;
    /**
     * 门户视图
     */
    @TableField(value = "portalpageid")
    @JSONField(name = "portalpageid")
    @JsonProperty("portalpageid")
    private String portalpageid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PortalPage portalpage;



    /**
     * 设置 [部件类型]
     */
    public void setPvparttype(String pvparttype){
        this.pvparttype = pvparttype ;
        this.modify("pvparttype",pvparttype);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [控件标识]
     */
    public void setCtrlid(String ctrlid){
        this.ctrlid = ctrlid ;
        this.modify("ctrlid",ctrlid);
    }
    /**
     * 设置 [门户视图部件名称]
     */
    public void setPvpartname(String pvpartname){
        this.pvpartname = pvpartname ;
        this.modify("pvpartname",pvpartname);
    }
    /**
     * 设置 [门户视图]
     */
    public void setPortalpageid(String portalpageid){
        this.portalpageid = portalpageid ;
        this.modify("portalpageid",portalpageid);
    }

    /**
     * 获取 [门户视图部件标识]
     */
    public String getPvpartid(){
        if(ObjectUtils.isEmpty(pvpartid)){
            pvpartid=(String)getDefaultKey(true);
        }
        return pvpartid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getPortalpageid()))&&(!ObjectUtils.isEmpty(this.getCtrlid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getPortalpageid(),this.getCtrlid()).getBytes());
        return null;
    }
}


