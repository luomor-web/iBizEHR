package cn.ibizlab.ehr.util.rest;


import cn.ibizlab.ehr.util.domain.FileItem;
import cn.ibizlab.ehr.util.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@Slf4j
@RestController
@RequestMapping("/")
public class FileController
{

	@Autowired
	private FileService fileService;

	@PostMapping(value = "${ibiz.file.uploadpath:ibizutil/upload}")
	public ResponseEntity<FileItem> upload(@RequestParam("file") MultipartFile multipartFile){
		return ResponseEntity.ok().body(fileService.saveFile(multipartFile));
	}

	private final String defaultdownloadpath="ibizutil/download/{id}";

	@GetMapping(value = "${ibiz.file.downloadpath:"+defaultdownloadpath+"}")
	@ResponseStatus(HttpStatus.OK)
	public void download(@PathVariable String id, HttpServletResponse response){
		File file= fileService.getFile(id);
		response.setHeader("Content-Disposition", "attachment;filename="+getFileName(file.getName()));
		this.sendRespose(response, file);
	}


	protected void sendRespose(HttpServletResponse response, File file){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		}
		catch (Exception e) {
			//throw e;
		}
		finally {
			if (bis != null) {
				try {
					bis.close();
				}
				catch (IOException e) {

				}
			}
			if (bos != null) {
				try {
					bos.close();
				}
				catch (IOException e) {

				}
			}
		}
	}

	protected String getFileName(String fileName){
		try {
			return new String(fileName.getBytes("utf-8"),"iso8859-1");//防止中文乱码
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fileName;
	}
}