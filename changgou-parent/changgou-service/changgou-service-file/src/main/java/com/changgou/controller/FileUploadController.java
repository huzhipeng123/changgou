package com.changgou.controller;

import com.changgou.file.FastDFSFile;
import com.changgou.util.FastDFSUtil;
import entity.Result;
import entity.StatusCode;
import org.csource.common.MyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author huzhpm
 * @Date 2021/1/17 16:33
 * @Version 1.0
 * @Content
 */
@RestController
@RequestMapping("/upload")
@CrossOrigin
public class FileUploadController {

    @PostMapping
    public Result upload(@RequestParam(value = "file")MultipartFile file) throws IOException, MyException {
        FastDFSFile fastDFSFile = new FastDFSFile(file.getName(), file.getBytes(), StringUtils.getFilenameExtension(file.getName()));
        // 调用FastDFSUtil工具类将文件传入到FastDFS中
        FastDFSUtil.upload(fastDFSFile);
        return new Result(true, StatusCode.OK, "上传成功");
    }

}
