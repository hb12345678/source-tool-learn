package com.huangbei.testproject.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangbei.testproject.Entity.Person;
import com.huangbei.testproject.Service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@RequestMapping("/abc")
@RestController
public class TestController {
    //    protected static Logger logger= LoggerFactory.getLogger(TestController.class);
    @Autowired
    TestService testService;

    @GetMapping("/hhh")
    public PageInfo<Person> getName(int pageNum,int pageSize) {
        String name ="hhhhh";
        PageHelper.startPage(pageNum,pageSize);
        List<Person> persons = testService.getCount();
        PageInfo<Person> person = new PageInfo(persons);
        return person;
    }

    @RequestMapping(value = "/downExcel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String downExcel(HttpServletResponse response) throws UnsupportedEncodingException {
        String filepath = "D:\\log\\sys.2021-08-10.0.log";
        // 如果文件名不为空，则进行下载
        File file = new File(filepath);
        String filename = file.getName();
        // 如果文件存在，则进行下载
        if (file.exists()) {
            // 配置文件下载
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 实现文件下载
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("Download  successfully!");
                return "successfully";

            } catch (Exception e) {
                System.out.println("Download  failed!");
                return "failed";

            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "";
    }
}