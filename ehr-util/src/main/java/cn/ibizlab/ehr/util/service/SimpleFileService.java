package cn.ibizlab.ehr.util.service;

import cn.ibizlab.ehr.util.domain.FileItem;
import cn.ibizlab.ehr.util.errors.InternalServerErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Primary
@Slf4j
@Service
public class SimpleFileService implements FileService {

    @Value("${ibiz.filePath:/app/file/}")
    private String fileRoot;

    @Override
    public FileItem saveFile(MultipartFile multipartFile) {
        FileItem item=null;
        // 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        // 获取文件后缀
        String extname="."+getExtensionName(fileName);
        try {
            String fileid= DigestUtils.md5DigestAsHex(multipartFile.getInputStream());
            String fileFullPath = this.fileRoot+"ibizutil"+File.separator+fileid+File.separator+fileName;
            File file = new File(fileFullPath);
            File parent = new File(file.getParent());
            if(!parent.exists())
                parent.mkdirs();
            FileCopyUtils.copy(multipartFile.getInputStream(),Files.newOutputStream(file.toPath()));
            item=new FileItem(fileid,fileName,fileid,fileName,(int)multipartFile.getSize(),extname);
        } catch (IOException e) {
            throw new InternalServerErrorException("文件上传失败");
        }
        return item;
    }

    @Override
    public File getFile(String fileid) {
        String dirpath = this.fileRoot+"ibizutil"+File.separator+fileid;
        File parent = new File(dirpath);
        if (parent.exists() && parent.isDirectory() && parent.listFiles().length > 0) {
            return parent.listFiles()[0];
        }
        throw new InternalServerErrorException("文件未找到");
    }

    /**
     * 获取文件扩展名
     * @param filename
     * @return
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

}