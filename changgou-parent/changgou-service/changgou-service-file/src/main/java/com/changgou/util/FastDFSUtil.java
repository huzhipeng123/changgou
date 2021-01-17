package com.changgou.util;

import com.changgou.file.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @Author huzhpm
 * @Date 2021/1/17 16:16
 * @Version 1.0
 * @Content
 * 实现FastDFS文件管理
 * 文件上传
 * 文件移除
 * 文件下载
 * 文件信息获取
 * Storage获取
 * Tracker信息获取
 */
public class FastDFSUtil {

    /**
     * 加载Tracker连接信息
     */
    static {
        try {
            // Spring BeanFactory
            // 查找classpath下的文件路径
            String path = new ClassPathResource("fdfs_client.conf").getPath();
            ClientGlobal.init(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     * @param fastDFSFile
     * @throws IOException
     */
    public static void upload(FastDFSFile fastDFSFile) throws IOException, MyException {
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", fastDFSFile.getAuthor());

        // 创建一个Tracker访问的客户端对象 TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        // 通过TrackClient访问TrackerServer服务，获取连接信息
        TrackerServer connection = trackerClient.getConnection();
        // 通过TrackServer的连接信息可以获取Storage的连接信息，创建Storage的连接信息
        StorageClient storageClient = new StorageClient(connection, null);
        // 通过StorageClient访问Storage，实现文件上传，并且获取文件上传后的存储信息
//        storageClient.upload_file(fastDFSFile.getContent(), fastDFSFile.getExt(), null);
        storageClient.upload_file(fastDFSFile.getContent(), fastDFSFile.getExt(), meta_list);
        System.out.println("上传成功");
    }
}
