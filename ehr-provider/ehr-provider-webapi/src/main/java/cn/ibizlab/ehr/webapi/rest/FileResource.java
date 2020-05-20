package cn.ibizlab.ehr.webapi.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.common.domain.File;
import cn.ibizlab.ehr.core.common.service.IFileService;
import cn.ibizlab.ehr.core.common.filter.FileSearchContext;




@Slf4j
@Api(tags = {"File" })
@RestController("WebApi-file")
@RequestMapping("")
public class FileResource {

    @Autowired
    private IFileService fileService;

    @Autowired
    @Lazy
    private FileMapping fileMapping;




    @PreAuthorize("hasPermission(#file_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"File" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/files/{file_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("file_id") String file_id) {
         return ResponseEntity.status(HttpStatus.OK).body(fileService.remove(file_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"File" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/files/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        fileService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"File" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/files/getdraft")
    public ResponseEntity<FileDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(fileMapping.toDto(fileService.getDraft(new File())));
    }




    @ApiOperation(value = "Save", tags = {"File" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/files/save")
    public ResponseEntity<Boolean> save(@RequestBody FileDTO filedto) {
        return ResponseEntity.status(HttpStatus.OK).body(fileService.save(fileMapping.toDomain(filedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"File" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/files/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<FileDTO> filedtos) {
        fileService.saveBatch(fileMapping.toDomain(filedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#file_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"File" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/files/{file_id}")
    public ResponseEntity<FileDTO> get(@PathVariable("file_id") String file_id) {
        File domain = fileService.get(file_id);
        FileDTO dto = fileMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"File" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/files/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody FileDTO filedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(fileService.checkKey(fileMapping.toDomain(filedto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"File" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/files")
    @Transactional
    public ResponseEntity<FileDTO> create(@RequestBody FileDTO filedto) {
        File domain = fileMapping.toDomain(filedto);
		fileService.create(domain);
        FileDTO dto = fileMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"File" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/files/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<FileDTO> filedtos) {
        fileService.createBatch(fileMapping.toDomain(filedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#file_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"File" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/files/{file_id}")
    @Transactional
    public ResponseEntity<FileDTO> update(@PathVariable("file_id") String file_id, @RequestBody FileDTO filedto) {
		File domain = fileMapping.toDomain(filedto);
        domain.setFileid(file_id);
		fileService.update(domain);
		FileDTO dto = fileMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#file_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"File" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/files/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<FileDTO> filedtos) {
        fileService.updateBatch(fileMapping.toDomain(filedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-File-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"File" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/files/fetchdefault")
	public ResponseEntity<List<FileDTO>> fetchDefault(FileSearchContext context) {
        Page<File> domains = fileService.searchDefault(context) ;
        List<FileDTO> list = fileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-File-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"File" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/files/searchdefault")
	public ResponseEntity<Page<FileDTO>> searchDefault(@RequestBody FileSearchContext context) {
        Page<File> domains = fileService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(fileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public File getEntity(){
        return new File();
    }

}
