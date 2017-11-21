package com.hualuo.master.profile;

import com.hualuo.master.config.PictureUploadProperties;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 图片上传控制器
 *
 * @author Joseph
 * @create 2017/11/21 21:24
 */
@Controller
@SessionAttributes("picturePath")
public class PictureUploadController {

    private final Resource pictureDir;

    private final Resource anonymousPicture;

    @Autowired
    public PictureUploadController(PictureUploadProperties uploadProperties) {
        this.pictureDir = uploadProperties.getUploadPath();
        this.anonymousPicture = uploadProperties.getAnonymousPicture();
    }

    public static final Resource PICTURES_DIR = new FileSystemResource("./pictures");

    @RequestMapping("/upload")
    public String uploadPage() {
        return "/profile/uploadPage";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String onUpload(MultipartFile file, RedirectAttributes redirectAttributes, Model model) throws IOException {
        if (file.isEmpty() || !isImage(file)) {
            redirectAttributes.addFlashAttribute("error", "Incorrect file. Please upload a picture.");
            return "redirect:/upload";
        }
        Resource picturePath = copyFileToPictures(file);
        model.addAttribute("picturePath", picturePath);
        return "profile/uploadPage";
    }

    @RequestMapping(value = "/uploadedPicture")
    public void getUploadedPicture(HttpServletResponse response, @ModelAttribute("picturePath") Resource picturePath) throws IOException {
        response.setHeader("Content-Type", URLConnection.guessContentTypeFromName(picturePath.toString()));
        Path path = Paths.get(picturePath.getURI());
        Files.copy(path, response.getOutputStream());
    }

    private Resource copyFileToPictures(MultipartFile file) throws IOException {
        String fileExtension = getFileExtension(file.getOriginalFilename());
        File tempFile = File.createTempFile("pic", fileExtension, this.pictureDir.getFile());
        try (InputStream in = file.getInputStream();
             OutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        return new FileSystemResource(tempFile);
    }

    private boolean isImage(MultipartFile file) {
        return file.getContentType().startsWith("image");
    }

    private static String getFileExtension(String name) {
        return name.substring(name.lastIndexOf("."));
    }

    @ModelAttribute("picturePath")
    public Resource picturePath() {
        return anonymousPicture;
    }

}
