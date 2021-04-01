package com.healer.user.controller;

import com.healer.common.utils.IdWorker;
import com.healer.user.domain.DriverLicense;
import com.healer.user.domain.FileResult;
import com.healer.user.domain.RealName;
import com.healer.user.service.DriverLicenseService;
import com.healer.user.service.RealNameService;
import com.healer.user.utils.UpPhotoNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.tokens.Token;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

/**
 * @author 李泽炜
 * @package com.healer.user.controller
 * @time 2021/3/1 13:06
 * @Description TODO
 */
@CrossOrigin()
@RestController
@RequestMapping("/user/realName")
public class RealNameController {
    private String license;
    @Autowired
    private DriverLicenseService driverLicenseService;
    @Autowired
    private RealNameService realNameService;
    @Autowired
    private IdWorker idWorker;

    @GetMapping ("/driver")
    public DriverLicense dirverLicense(){
        return driverLicenseService.getDriveLicense(license);
    }

    @PostMapping ("/isRealName")
    public RealName idRealName(String userName, String phone, String num, String userId) throws IOException {
        return realNameService.isRealName(userName, phone, num, userId);
    }

    /**
     * 文件上传
     * @param picture
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public FileResult upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        System.out.println("您已进入图片上传服务");
        //获取文件在服务器的储存位置
        String path = "D:\\Healer_Rental_Car\\healer-rental\\rental-user\\src\\main\\resources\\driverLicense";
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        String fileName = idWorker.nextId()+name + "." + type;
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);
        System.out.println("图片地址："+path+"/"+fileName);
        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");
            license = path+"/"+fileName;
            //将文件在服务器的存储路径返回
            return new FileResult(true,fileName,path+"/"+fileName);
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            return new FileResult(false, "上传失败","");
        }
    }

}
