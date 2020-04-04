package org.java.shopping.web;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.java.shopping.ov.FileOV;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UpLoadController {

    @Value("${file.upload}")
    private String path;//该变量，用于获得文件上传的路径

//    @RequestMapping("/img")
////    public ResponseEntity<FileOV> upload(MultipartFile file){
////
////        String fname=file.getOriginalFilename();//获取文件名称
////
////        File newfile=new File(path,fname);
////
////        if(!newfile.getParentFile().exists()){
////             newfile.getParentFile().mkdirs();
////        }
////
////        FileOV fileOV=new FileOV();
////
////        try {
////
////            file.transferTo(newfile);//将上传文件数据写入到新文件中
////            fileOV.setCode(1);//上传成功
////            fileOV.setMsg("上传成功");
////            fileOV.setData(newfile.getAbsolutePath());//获得上传的路径
////
////            return ResponseEntity.status(HttpStatus.OK).body(fileOV);
////        } catch (IOException e) {
////
////            e.printStackTrace();;
////            fileOV.setCode(0);//上传失败
////            fileOV.setMsg("上传失败");
////
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fileOV);
////        }
////
////    }


    @RequestMapping("/img")
    public ResponseEntity<FileOV> path(MultipartFile file) throws IOException {
           System.out.println(path);
           String fname=file.getOriginalFilename();

           String fname2=fname.substring(fname.indexOf(".")+1);
        System.out.println(fname);
        System.out.println(fname2);

           String fname3= UUID.randomUUID()+"."+fname2;
        System.out.println(fname3);

           File newfile=new File(path,fname3);

           file.transferTo(newfile);

        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);

            NameValuePair[] metaList = new NameValuePair[1];
            metaList[0] = new NameValuePair("fileName", fname3);
            String fileId = client.upload_file1(newfile.getAbsolutePath(), fname2, metaList);
            System.out.println("upload success. file id is: " + fileId);

            FileOV fileOV=new FileOV( );
            fileOV.setCode(1);
            fileOV.setMsg("上传成功");
            fileOV.setData("http://img.shopping.com/"+fileId);
            System.out.println("文件的位置是:"+fileOV.getData());
            return ResponseEntity.status(HttpStatus.OK).body(fileOV);
        } catch (Exception ex) {
            FileOV fileVO = new FileOV();
            fileVO.setCode(0);//上传失败
            fileVO.setMsg("上传失败");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fileVO);
        }
    }

}
