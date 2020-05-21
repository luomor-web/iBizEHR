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
 * 实体[文件]
 */
@Data
@TableName(value = "T_FILE",resultMap = "FileResultMap")
public class File extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图片高度
     */
    @TableField(value = "picheight")
    @JSONField(name = "picheight")
    @JsonProperty("picheight")
    private Integer picheight;
    /**
     * 指定目录
     */
    @TableField(value = "folder")
    @JSONField(name = "folder")
    @JsonProperty("folder")
    private String folder;
    /**
     * 文件名称
     */
    @DEField(name = "file_name")
    @TableField(value = "file_name")
    @JSONField(name = "filename")
    @JsonProperty("filename")
    private String filename;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 文件标识
     */
    @DEField(name = "file_id" , isKeyField=true)
    @TableId(value= "file_id",type=IdType.UUID)
    @JSONField(name = "fileid")
    @JsonProperty("fileid")
    private String fileid;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 所有者标识
     */
    @TableField(value = "ownerid")
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;
    /**
     * 原始文件名称
     */
    @TableField(value = "filename2")
    @JSONField(name = "filename2")
    @JsonProperty("filename2")
    private String filename2;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 存储路径2
     */
    @TableField(value = "localpath2")
    @JSONField(name = "localpath2")
    @JsonProperty("localpath2")
    private String localpath2;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 存储路径
     */
    @TableField(value = "localpath")
    @JSONField(name = "localpath")
    @JsonProperty("localpath")
    private String localpath;
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
     * 摘要数据
     */
    @TableField(value = "digestcode")
    @JSONField(name = "digestcode")
    @JsonProperty("digestcode")
    private String digestcode;
    /**
     * 所有者类型
     */
    @TableField(value = "ownertype")
    @JSONField(name = "ownertype")
    @JsonProperty("ownertype")
    private String ownertype;
    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
    /**
     * 文件大小
     */
    @TableField(value = "filesize")
    @JSONField(name = "filesize")
    @JsonProperty("filesize")
    private Integer filesize;
    /**
     * 图片宽度
     */
    @TableField(value = "picwidth")
    @JSONField(name = "picwidth")
    @JsonProperty("picwidth")
    private Integer picwidth;



    /**
     * 设置 [图片高度]
     */
    public void setPicheight(Integer picheight){
        this.picheight = picheight ;
        this.modify("picheight",picheight);
    }
    /**
     * 设置 [指定目录]
     */
    public void setFolder(String folder){
        this.folder = folder ;
        this.modify("folder",folder);
    }
    /**
     * 设置 [文件名称]
     */
    public void setFilename(String filename){
        this.filename = filename ;
        this.modify("file_name",filename);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [所有者标识]
     */
    public void setOwnerid(String ownerid){
        this.ownerid = ownerid ;
        this.modify("ownerid",ownerid);
    }
    /**
     * 设置 [原始文件名称]
     */
    public void setFilename2(String filename2){
        this.filename2 = filename2 ;
        this.modify("filename2",filename2);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [存储路径2]
     */
    public void setLocalpath2(String localpath2){
        this.localpath2 = localpath2 ;
        this.modify("localpath2",localpath2);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [存储路径]
     */
    public void setLocalpath(String localpath){
        this.localpath = localpath ;
        this.modify("localpath",localpath);
    }
    /**
     * 设置 [摘要数据]
     */
    public void setDigestcode(String digestcode){
        this.digestcode = digestcode ;
        this.modify("digestcode",digestcode);
    }
    /**
     * 设置 [所有者类型]
     */
    public void setOwnertype(String ownertype){
        this.ownertype = ownertype ;
        this.modify("ownertype",ownertype);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [文件大小]
     */
    public void setFilesize(Integer filesize){
        this.filesize = filesize ;
        this.modify("filesize",filesize);
    }
    /**
     * 设置 [图片宽度]
     */
    public void setPicwidth(Integer picwidth){
        this.picwidth = picwidth ;
        this.modify("picwidth",picwidth);
    }

}


