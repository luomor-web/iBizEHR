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
 * 实体[门户页面模型]
 */
@Data
@TableName(value = "T_SRFPPMODEL",resultMap = "PPModelResultMap")
public class PPModel extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 页面布局
     */
    @TableField(value = "ppmodel")
    @JSONField(name = "ppmodel")
    @JsonProperty("ppmodel")
    private String ppmodel;
    /**
     * 用户频道页名称
     */
    @DEField(defaultValue = "门户视图用户自定义")
    @TableField(value = "ppmodelname")
    @JSONField(name = "ppmodelname")
    @JsonProperty("ppmodelname")
    private String ppmodelname;
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
     * 模型明细
     */
    @TableField(value = "ppmodeldetail")
    @JSONField(name = "ppmodeldetail")
    @JsonProperty("ppmodeldetail")
    private String ppmodeldetail;
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
     * 所有者
     */
    @TableField(value = "ownerid")
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;
    /**
     * 版本
     */
    @DEField(defaultValue = "1")
    @TableField(value = "ppmversion")
    @JSONField(name = "ppmversion")
    @JsonProperty("ppmversion")
    private Integer ppmversion;
    /**
     * 用户频道页标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ppmodelid",type=IdType.UUID)
    @JSONField(name = "ppmodelid")
    @JsonProperty("ppmodelid")
    private String ppmodelid;
    /**
     * 系统数据
     */
    @DEField(defaultValue = "0")
    @TableField(value = "issystem")
    @JSONField(name = "issystem")
    @JsonProperty("issystem")
    private Integer issystem;
    /**
     * 右侧部件3
     */
    @TableField(value = "r3pvpartctrlid")
    @JSONField(name = "r3pvpartctrlid")
    @JsonProperty("r3pvpartctrlid")
    private String r3pvpartctrlid;
    /**
     * 右侧部件1
     */
    @TableField(value = "r1pvpartname")
    @JSONField(name = "r1pvpartname")
    @JsonProperty("r1pvpartname")
    private String r1pvpartname;
    /**
     * 中间部件3
     */
    @TableField(value = "c3pvpartname")
    @JSONField(name = "c3pvpartname")
    @JsonProperty("c3pvpartname")
    private String c3pvpartname;
    /**
     * 中间部件4
     */
    @TableField(value = "c4pvpartctrlid")
    @JSONField(name = "c4pvpartctrlid")
    @JsonProperty("c4pvpartctrlid")
    private String c4pvpartctrlid;
    /**
     * 右侧部件2
     */
    @TableField(value = "r2pvpartctrlid")
    @JSONField(name = "r2pvpartctrlid")
    @JsonProperty("r2pvpartctrlid")
    private String r2pvpartctrlid;
    /**
     * 左侧部件1
     */
    @TableField(value = "l1pvpartctrlid")
    @JSONField(name = "l1pvpartctrlid")
    @JsonProperty("l1pvpartctrlid")
    private String l1pvpartctrlid;
    /**
     * 中间部件3
     */
    @TableField(value = "c3pvpartctrlid")
    @JSONField(name = "c3pvpartctrlid")
    @JsonProperty("c3pvpartctrlid")
    private String c3pvpartctrlid;
    /**
     * 中间部件2
     */
    @TableField(value = "c2pvpartctrlid")
    @JSONField(name = "c2pvpartctrlid")
    @JsonProperty("c2pvpartctrlid")
    private String c2pvpartctrlid;
    /**
     * 左侧部件3
     */
    @TableField(value = "l3pvpartname")
    @JSONField(name = "l3pvpartname")
    @JsonProperty("l3pvpartname")
    private String l3pvpartname;
    /**
     * 右侧部件3
     */
    @TableField(value = "r3pvpartname")
    @JSONField(name = "r3pvpartname")
    @JsonProperty("r3pvpartname")
    private String r3pvpartname;
    /**
     * 中间部件1
     */
    @TableField(value = "c1pvpartname")
    @JSONField(name = "c1pvpartname")
    @JsonProperty("c1pvpartname")
    private String c1pvpartname;
    /**
     * 右侧部件4
     */
    @TableField(value = "r4pvpartname")
    @JSONField(name = "r4pvpartname")
    @JsonProperty("r4pvpartname")
    private String r4pvpartname;
    /**
     * 左侧部件4
     */
    @TableField(value = "l4pvpartctrlid")
    @JSONField(name = "l4pvpartctrlid")
    @JsonProperty("l4pvpartctrlid")
    private String l4pvpartctrlid;
    /**
     * 右侧部件1
     */
    @TableField(value = "r1pvpartctrlid")
    @JSONField(name = "r1pvpartctrlid")
    @JsonProperty("r1pvpartctrlid")
    private String r1pvpartctrlid;
    /**
     * 左侧部件2
     */
    @TableField(value = "l2pvpartname")
    @JSONField(name = "l2pvpartname")
    @JsonProperty("l2pvpartname")
    private String l2pvpartname;
    /**
     * 左侧部件4
     */
    @TableField(value = "l4pvpartname")
    @JSONField(name = "l4pvpartname")
    @JsonProperty("l4pvpartname")
    private String l4pvpartname;
    /**
     * 左侧部件2
     */
    @TableField(value = "l2pvpartctrlid")
    @JSONField(name = "l2pvpartctrlid")
    @JsonProperty("l2pvpartctrlid")
    private String l2pvpartctrlid;
    /**
     * 右侧部件4
     */
    @TableField(value = "r4pvpartctrlid")
    @JSONField(name = "r4pvpartctrlid")
    @JsonProperty("r4pvpartctrlid")
    private String r4pvpartctrlid;
    /**
     * 左侧部件1
     */
    @TableField(value = "l1pvpartname")
    @JSONField(name = "l1pvpartname")
    @JsonProperty("l1pvpartname")
    private String l1pvpartname;
    /**
     * 频道页
     */
    @TableField(value = "portalpagename")
    @JSONField(name = "portalpagename")
    @JsonProperty("portalpagename")
    private String portalpagename;
    /**
     * 中间部件4
     */
    @TableField(value = "c4pvpartname")
    @JSONField(name = "c4pvpartname")
    @JsonProperty("c4pvpartname")
    private String c4pvpartname;
    /**
     * 左侧部件3
     */
    @TableField(value = "l3pvpartctrlid")
    @JSONField(name = "l3pvpartctrlid")
    @JsonProperty("l3pvpartctrlid")
    private String l3pvpartctrlid;
    /**
     * 中间部件2
     */
    @TableField(value = "c2pvpartname")
    @JSONField(name = "c2pvpartname")
    @JsonProperty("c2pvpartname")
    private String c2pvpartname;
    /**
     * 右侧部件2
     */
    @TableField(value = "r2pvpartname")
    @JSONField(name = "r2pvpartname")
    @JsonProperty("r2pvpartname")
    private String r2pvpartname;
    /**
     * 中间部件1
     */
    @TableField(value = "c1pvpartctrlid")
    @JSONField(name = "c1pvpartctrlid")
    @JsonProperty("c1pvpartctrlid")
    private String c1pvpartctrlid;
    /**
     * 右侧部件1
     */
    @TableField(value = "r1pvpartid")
    @JSONField(name = "r1pvpartid")
    @JsonProperty("r1pvpartid")
    private String r1pvpartid;
    /**
     * 中间部件3
     */
    @TableField(value = "c3pvpartid")
    @JSONField(name = "c3pvpartid")
    @JsonProperty("c3pvpartid")
    private String c3pvpartid;
    /**
     * 中间部件1
     */
    @TableField(value = "c1pvpartid")
    @JSONField(name = "c1pvpartid")
    @JsonProperty("c1pvpartid")
    private String c1pvpartid;
    /**
     * 左侧部件1
     */
    @TableField(value = "l1pvpartid")
    @JSONField(name = "l1pvpartid")
    @JsonProperty("l1pvpartid")
    private String l1pvpartid;
    /**
     * 右侧部件4
     */
    @TableField(value = "r4pvpartid")
    @JSONField(name = "r4pvpartid")
    @JsonProperty("r4pvpartid")
    private String r4pvpartid;
    /**
     * 左侧部件4
     */
    @TableField(value = "l4pvpartid")
    @JSONField(name = "l4pvpartid")
    @JsonProperty("l4pvpartid")
    private String l4pvpartid;
    /**
     * 左侧部件2
     */
    @TableField(value = "l2pvpartid")
    @JSONField(name = "l2pvpartid")
    @JsonProperty("l2pvpartid")
    private String l2pvpartid;
    /**
     * 中间部件4
     */
    @TableField(value = "c4pvpartid")
    @JSONField(name = "c4pvpartid")
    @JsonProperty("c4pvpartid")
    private String c4pvpartid;
    /**
     * 左侧部件3
     */
    @TableField(value = "l3pvpartid")
    @JSONField(name = "l3pvpartid")
    @JsonProperty("l3pvpartid")
    private String l3pvpartid;
    /**
     * 门户页面
     */
    @TableField(value = "portalpageid")
    @JSONField(name = "portalpageid")
    @JsonProperty("portalpageid")
    private String portalpageid;
    /**
     * 右侧部件3
     */
    @TableField(value = "r3pvpartid")
    @JSONField(name = "r3pvpartid")
    @JsonProperty("r3pvpartid")
    private String r3pvpartid;
    /**
     * 右侧部件2
     */
    @TableField(value = "r2pvpartid")
    @JSONField(name = "r2pvpartid")
    @JsonProperty("r2pvpartid")
    private String r2pvpartid;
    /**
     * 中间部件2
     */
    @TableField(value = "c2pvpartid")
    @JSONField(name = "c2pvpartid")
    @JsonProperty("c2pvpartid")
    private String c2pvpartid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PortalPage portalpage;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart c1pvpart;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart c2pvpart;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart c3pvpart;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart c4pvpart;

    /**
     * 左侧部件1
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart l1pvpart;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart l2pvpart;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart l3pvpart;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart l4pvpart;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart r1pvpart;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart r2pvpart;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart r3pvpart;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.PVPart r4pvpart;



    /**
     * 设置 [页面布局]
     */
    public void setPpmodel(String ppmodel){
        this.ppmodel = ppmodel ;
        this.modify("ppmodel",ppmodel);
    }
    /**
     * 设置 [用户频道页名称]
     */
    public void setPpmodelname(String ppmodelname){
        this.ppmodelname = ppmodelname ;
        this.modify("ppmodelname",ppmodelname);
    }
    /**
     * 设置 [模型明细]
     */
    public void setPpmodeldetail(String ppmodeldetail){
        this.ppmodeldetail = ppmodeldetail ;
        this.modify("ppmodeldetail",ppmodeldetail);
    }
    /**
     * 设置 [所有者]
     */
    public void setOwnerid(String ownerid){
        this.ownerid = ownerid ;
        this.modify("ownerid",ownerid);
    }
    /**
     * 设置 [版本]
     */
    public void setPpmversion(Integer ppmversion){
        this.ppmversion = ppmversion ;
        this.modify("ppmversion",ppmversion);
    }
    /**
     * 设置 [系统数据]
     */
    public void setIssystem(Integer issystem){
        this.issystem = issystem ;
        this.modify("issystem",issystem);
    }
    /**
     * 设置 [右侧部件3]
     */
    public void setR3pvpartctrlid(String r3pvpartctrlid){
        this.r3pvpartctrlid = r3pvpartctrlid ;
        this.modify("r3pvpartctrlid",r3pvpartctrlid);
    }
    /**
     * 设置 [右侧部件1]
     */
    public void setR1pvpartname(String r1pvpartname){
        this.r1pvpartname = r1pvpartname ;
        this.modify("r1pvpartname",r1pvpartname);
    }
    /**
     * 设置 [中间部件3]
     */
    public void setC3pvpartname(String c3pvpartname){
        this.c3pvpartname = c3pvpartname ;
        this.modify("c3pvpartname",c3pvpartname);
    }
    /**
     * 设置 [中间部件4]
     */
    public void setC4pvpartctrlid(String c4pvpartctrlid){
        this.c4pvpartctrlid = c4pvpartctrlid ;
        this.modify("c4pvpartctrlid",c4pvpartctrlid);
    }
    /**
     * 设置 [右侧部件2]
     */
    public void setR2pvpartctrlid(String r2pvpartctrlid){
        this.r2pvpartctrlid = r2pvpartctrlid ;
        this.modify("r2pvpartctrlid",r2pvpartctrlid);
    }
    /**
     * 设置 [左侧部件1]
     */
    public void setL1pvpartctrlid(String l1pvpartctrlid){
        this.l1pvpartctrlid = l1pvpartctrlid ;
        this.modify("l1pvpartctrlid",l1pvpartctrlid);
    }
    /**
     * 设置 [中间部件3]
     */
    public void setC3pvpartctrlid(String c3pvpartctrlid){
        this.c3pvpartctrlid = c3pvpartctrlid ;
        this.modify("c3pvpartctrlid",c3pvpartctrlid);
    }
    /**
     * 设置 [中间部件2]
     */
    public void setC2pvpartctrlid(String c2pvpartctrlid){
        this.c2pvpartctrlid = c2pvpartctrlid ;
        this.modify("c2pvpartctrlid",c2pvpartctrlid);
    }
    /**
     * 设置 [左侧部件3]
     */
    public void setL3pvpartname(String l3pvpartname){
        this.l3pvpartname = l3pvpartname ;
        this.modify("l3pvpartname",l3pvpartname);
    }
    /**
     * 设置 [右侧部件3]
     */
    public void setR3pvpartname(String r3pvpartname){
        this.r3pvpartname = r3pvpartname ;
        this.modify("r3pvpartname",r3pvpartname);
    }
    /**
     * 设置 [中间部件1]
     */
    public void setC1pvpartname(String c1pvpartname){
        this.c1pvpartname = c1pvpartname ;
        this.modify("c1pvpartname",c1pvpartname);
    }
    /**
     * 设置 [右侧部件4]
     */
    public void setR4pvpartname(String r4pvpartname){
        this.r4pvpartname = r4pvpartname ;
        this.modify("r4pvpartname",r4pvpartname);
    }
    /**
     * 设置 [左侧部件4]
     */
    public void setL4pvpartctrlid(String l4pvpartctrlid){
        this.l4pvpartctrlid = l4pvpartctrlid ;
        this.modify("l4pvpartctrlid",l4pvpartctrlid);
    }
    /**
     * 设置 [右侧部件1]
     */
    public void setR1pvpartctrlid(String r1pvpartctrlid){
        this.r1pvpartctrlid = r1pvpartctrlid ;
        this.modify("r1pvpartctrlid",r1pvpartctrlid);
    }
    /**
     * 设置 [左侧部件2]
     */
    public void setL2pvpartname(String l2pvpartname){
        this.l2pvpartname = l2pvpartname ;
        this.modify("l2pvpartname",l2pvpartname);
    }
    /**
     * 设置 [左侧部件4]
     */
    public void setL4pvpartname(String l4pvpartname){
        this.l4pvpartname = l4pvpartname ;
        this.modify("l4pvpartname",l4pvpartname);
    }
    /**
     * 设置 [左侧部件2]
     */
    public void setL2pvpartctrlid(String l2pvpartctrlid){
        this.l2pvpartctrlid = l2pvpartctrlid ;
        this.modify("l2pvpartctrlid",l2pvpartctrlid);
    }
    /**
     * 设置 [右侧部件4]
     */
    public void setR4pvpartctrlid(String r4pvpartctrlid){
        this.r4pvpartctrlid = r4pvpartctrlid ;
        this.modify("r4pvpartctrlid",r4pvpartctrlid);
    }
    /**
     * 设置 [左侧部件1]
     */
    public void setL1pvpartname(String l1pvpartname){
        this.l1pvpartname = l1pvpartname ;
        this.modify("l1pvpartname",l1pvpartname);
    }
    /**
     * 设置 [频道页]
     */
    public void setPortalpagename(String portalpagename){
        this.portalpagename = portalpagename ;
        this.modify("portalpagename",portalpagename);
    }
    /**
     * 设置 [中间部件4]
     */
    public void setC4pvpartname(String c4pvpartname){
        this.c4pvpartname = c4pvpartname ;
        this.modify("c4pvpartname",c4pvpartname);
    }
    /**
     * 设置 [左侧部件3]
     */
    public void setL3pvpartctrlid(String l3pvpartctrlid){
        this.l3pvpartctrlid = l3pvpartctrlid ;
        this.modify("l3pvpartctrlid",l3pvpartctrlid);
    }
    /**
     * 设置 [中间部件2]
     */
    public void setC2pvpartname(String c2pvpartname){
        this.c2pvpartname = c2pvpartname ;
        this.modify("c2pvpartname",c2pvpartname);
    }
    /**
     * 设置 [右侧部件2]
     */
    public void setR2pvpartname(String r2pvpartname){
        this.r2pvpartname = r2pvpartname ;
        this.modify("r2pvpartname",r2pvpartname);
    }
    /**
     * 设置 [中间部件1]
     */
    public void setC1pvpartctrlid(String c1pvpartctrlid){
        this.c1pvpartctrlid = c1pvpartctrlid ;
        this.modify("c1pvpartctrlid",c1pvpartctrlid);
    }
    /**
     * 设置 [右侧部件1]
     */
    public void setR1pvpartid(String r1pvpartid){
        this.r1pvpartid = r1pvpartid ;
        this.modify("r1pvpartid",r1pvpartid);
    }
    /**
     * 设置 [中间部件3]
     */
    public void setC3pvpartid(String c3pvpartid){
        this.c3pvpartid = c3pvpartid ;
        this.modify("c3pvpartid",c3pvpartid);
    }
    /**
     * 设置 [中间部件1]
     */
    public void setC1pvpartid(String c1pvpartid){
        this.c1pvpartid = c1pvpartid ;
        this.modify("c1pvpartid",c1pvpartid);
    }
    /**
     * 设置 [左侧部件1]
     */
    public void setL1pvpartid(String l1pvpartid){
        this.l1pvpartid = l1pvpartid ;
        this.modify("l1pvpartid",l1pvpartid);
    }
    /**
     * 设置 [右侧部件4]
     */
    public void setR4pvpartid(String r4pvpartid){
        this.r4pvpartid = r4pvpartid ;
        this.modify("r4pvpartid",r4pvpartid);
    }
    /**
     * 设置 [左侧部件4]
     */
    public void setL4pvpartid(String l4pvpartid){
        this.l4pvpartid = l4pvpartid ;
        this.modify("l4pvpartid",l4pvpartid);
    }
    /**
     * 设置 [左侧部件2]
     */
    public void setL2pvpartid(String l2pvpartid){
        this.l2pvpartid = l2pvpartid ;
        this.modify("l2pvpartid",l2pvpartid);
    }
    /**
     * 设置 [中间部件4]
     */
    public void setC4pvpartid(String c4pvpartid){
        this.c4pvpartid = c4pvpartid ;
        this.modify("c4pvpartid",c4pvpartid);
    }
    /**
     * 设置 [左侧部件3]
     */
    public void setL3pvpartid(String l3pvpartid){
        this.l3pvpartid = l3pvpartid ;
        this.modify("l3pvpartid",l3pvpartid);
    }
    /**
     * 设置 [门户页面]
     */
    public void setPortalpageid(String portalpageid){
        this.portalpageid = portalpageid ;
        this.modify("portalpageid",portalpageid);
    }
    /**
     * 设置 [右侧部件3]
     */
    public void setR3pvpartid(String r3pvpartid){
        this.r3pvpartid = r3pvpartid ;
        this.modify("r3pvpartid",r3pvpartid);
    }
    /**
     * 设置 [右侧部件2]
     */
    public void setR2pvpartid(String r2pvpartid){
        this.r2pvpartid = r2pvpartid ;
        this.modify("r2pvpartid",r2pvpartid);
    }
    /**
     * 设置 [中间部件2]
     */
    public void setC2pvpartid(String c2pvpartid){
        this.c2pvpartid = c2pvpartid ;
        this.modify("c2pvpartid",c2pvpartid);
    }

    /**
     * 获取 [用户频道页标识]
     */
    public String getPpmodelid(){
        if(ObjectUtils.isEmpty(ppmodelid)){
            ppmodelid=(String)getDefaultKey(true);
        }
        return ppmodelid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getPortalpageid()))&&(!ObjectUtils.isEmpty(this.getOwnerid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getPortalpageid(),this.getOwnerid()).getBytes());
        return null;
    }
}


