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
 * 服务DTO对象[FileDTO]
 */
@Data
public class FileDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PICHEIGHT]
     *
     */
    @JSONField(name = "picheight")
    @JsonProperty("picheight")
    private Integer picheight;

    /**
     * 属性 [FOLDER]
     *
     */
    @JSONField(name = "folder")
    @JsonProperty("folder")
    private String folder;

    /**
     * 属性 [FILE_NAME]
     *
     */
    @JSONField(name = "filename")
    @JsonProperty("filename")
    private String filename;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [FILE_ID]
     *
     */
    @JSONField(name = "fileid")
    @JsonProperty("fileid")
    private String fileid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [OWNERID]
     *
     */
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;

    /**
     * 属性 [FILENAME2]
     *
     */
    @JSONField(name = "filename2")
    @JsonProperty("filename2")
    private String filename2;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [LOCALPATH2]
     *
     */
    @JSONField(name = "localpath2")
    @JsonProperty("localpath2")
    private String localpath2;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

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
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [LOCALPATH]
     *
     */
    @JSONField(name = "localpath")
    @JsonProperty("localpath")
    private String localpath;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [DIGESTCODE]
     *
     */
    @JSONField(name = "digestcode")
    @JsonProperty("digestcode")
    private String digestcode;

    /**
     * 属性 [OWNERTYPE]
     *
     */
    @JSONField(name = "ownertype")
    @JsonProperty("ownertype")
    private String ownertype;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [FILESIZE]
     *
     */
    @JSONField(name = "filesize")
    @JsonProperty("filesize")
    private Integer filesize;

    /**
     * 属性 [PICWIDTH]
     *
     */
    @JSONField(name = "picwidth")
    @JsonProperty("picwidth")
    private Integer picwidth;


    /**
     * 设置 [PICHEIGHT]
     */
    public void setPicheight(Integer  picheight){
        this.picheight = picheight ;
        this.modify("picheight",picheight);
    }

    /**
     * 设置 [FOLDER]
     */
    public void setFolder(String  folder){
        this.folder = folder ;
        this.modify("folder",folder);
    }

    /**
     * 设置 [FILE_NAME]
     */
    public void setFilename(String  filename){
        this.filename = filename ;
        this.modify("file_name",filename);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [OWNERID]
     */
    public void setOwnerid(String  ownerid){
        this.ownerid = ownerid ;
        this.modify("ownerid",ownerid);
    }

    /**
     * 设置 [FILENAME2]
     */
    public void setFilename2(String  filename2){
        this.filename2 = filename2 ;
        this.modify("filename2",filename2);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [LOCALPATH2]
     */
    public void setLocalpath2(String  localpath2){
        this.localpath2 = localpath2 ;
        this.modify("localpath2",localpath2);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [LOCALPATH]
     */
    public void setLocalpath(String  localpath){
        this.localpath = localpath ;
        this.modify("localpath",localpath);
    }

    /**
     * 设置 [DIGESTCODE]
     */
    public void setDigestcode(String  digestcode){
        this.digestcode = digestcode ;
        this.modify("digestcode",digestcode);
    }

    /**
     * 设置 [OWNERTYPE]
     */
    public void setOwnertype(String  ownertype){
        this.ownertype = ownertype ;
        this.modify("ownertype",ownertype);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [FILESIZE]
     */
    public void setFilesize(Integer  filesize){
        this.filesize = filesize ;
        this.modify("filesize",filesize);
    }

    /**
     * 设置 [PICWIDTH]
     */
    public void setPicwidth(Integer  picwidth){
        this.picwidth = picwidth ;
        this.modify("picwidth",picwidth);
    }


}

