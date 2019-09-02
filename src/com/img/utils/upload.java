package com.img.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class upload {
   public String uploadfile(HttpServletRequest request, HttpServletResponse response,
         List<Map<String, String>> lists) {
      String saveFilename = null; // 保存的文件名字
      String filename = null;// 文件原始名
      System.out.println(request.getServletContext().getRealPath(""));
      // 得到上传文件的保存目录，将上传文件保存在tomcat服务器上
      String savePath = request.getServletContext().getRealPath("/file");
      // 上传时生成的临时文件保存目录
      String tempPath = request.getServletContext().getRealPath("/filetemp");
      System.out.println(savePath);
      File file = new File(savePath);
      // 如果目录不存在
      if (!file.exists()) {
         // 创建目录
         file.mkdirs();
      }
      File tmpFile = new File(tempPath);
      // 如果目录不存在
      if (!tmpFile.exists()) {
         // 创建目录
         tmpFile.mkdirs();
      }

      try {
         // 使用Apache文件上传组件处理文件上传步骤：
         // 1、创建一个DiskFileItemFactory工厂
         DiskFileItemFactory factory = new DiskFileItemFactory();
         // 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
         factory.setSizeThreshold(1024 * 100);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
         // 设置上传时生成的临时文件的保存目录
         factory.setRepository(tmpFile);
         // 2、创建一个文件上传解析器
         ServletFileUpload upload = new ServletFileUpload(factory);
         // 解决上传文件名的中文乱码
         upload.setHeaderEncoding("UTF-8");
         // 3、判断提交上来的数据是否是上传表单的数据
       /*  if (!ServletFileUpload.isMultipartContent(request)) {
            // 按照传统方式获取数据
            Map<String, String> map = new HashMap<>();
            map.put("message", "提交的文件不是表单上传过来的数据");
            lists.add(map);
            return "error";
         }*/
         List<FileItem> list = upload.parseRequest(request);
         for (FileItem item : list) {
            // 如果fileitem中封装的是普通输入项的数据
            if (item.isFormField()) {
               String name = item.getFieldName();
               // 解决普通输入项的数据的中文乱码问题
               String value = item.getString("UTF-8");
               //value = new String(value.getBytes("iso8859-1"), "UTF-8");
               System.out.println(name + "=" + value);
            } else {
               // 如果fileitem中封装的是上传文件,得到上传的文件名称，
               filename = item.getName();
               System.out.println(filename);
               if (filename == null || filename.trim().equals("")) {
                 continue;
               }
               // 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
               // c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
               //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
               filename = filename.substring(filename.lastIndexOf("\\") + 1);
               // 得到上传文件的扩展名
               String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
               // 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
               System.out.println("限制上传的文件类型,上传的文件的扩展名是：" + fileExtName);
               // 获取item中的上传文件的输入流
               InputStream in = item.getInputStream();
               // 得到文件保存的名称
               saveFilename = makeFileName(fileExtName);
               // 创建一个文件输出流
               FileOutputStream out = new FileOutputStream(savePath + "\\" + saveFilename);
               // 创建一个缓冲区
               byte buffer[] = new byte[1024];
               // 判断输入流中的数据是否已经读完的标识
               int len = 0;
               // 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
               while ((len = in.read(buffer)) > 0) {
                 // 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                 out.write(buffer, 0, len);
               }
               // 关闭输入流
               in.close();
               // 关闭输出流
               out.close();
               // 删除处理文件上传时生成的临时文件
               item.delete();

               Map<String, String> map = new HashMap<>();
               // 上传以后文件保存的名字
               map.put("saveFilename", saveFilename);
               // 上传前文件的名字
               map.put("filename", filename);
               // 保存的路径
               map.put("savePath", savePath);
               map.put("message", "文件上传成功");
               lists.add(map);
            }
         }
      } catch (FileUploadBase.FileSizeLimitExceededException e) {
         e.printStackTrace();
         Map<String, String> map = new HashMap<>();
         map.put("message", "单个文件超出最大值！！！");
         lists.add(map);
         return "error";
      } catch (FileUploadBase.SizeLimitExceededException e) {
         e.printStackTrace();
         Map<String, String> map = new HashMap<>();
         map.put("message", "上传文件的总的大小超出限制的最大值！！！");
         lists.add(map);
         return "error";
      } catch (Exception e) {
         Map<String, String> map = new HashMap<>();
         map.put("message", "文件上传失败！");
         lists.add(map);
         e.printStackTrace();
         return "error";
      }

      return "sucess";
   }

   // 参数为后缀名jpg
   private String makeFileName(String fileExtName) {
      // 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
      return UUID.randomUUID().toString().replace("-", "") + "." + fileExtName;
   }
}
 
