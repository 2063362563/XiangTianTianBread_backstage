package com.fan.xiangtiantianbread.utils;

import cn.hutool.core.io.resource.InputStreamResource;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Common {

    public static String upload(MultipartFile file){
        String url = "";
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("file", new InputStreamResource(file.getInputStream(),file.getOriginalFilename()));
            params.put("output", "json2");
            String resp = HttpUtil.post("http://localhost:21730/group1/upload", params);
            System.out.println(resp);
            Map fastdfsData = JSON.parseObject(JSON.parseObject(resp, Map.class).get("data").toString(), Map.class);
            String domain = fastdfsData.get("domain").toString();
            String src = fastdfsData.get("src").toString();
            url = domain+src;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

}
