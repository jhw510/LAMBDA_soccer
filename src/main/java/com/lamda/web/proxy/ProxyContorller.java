package com.lamda.web.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
public class ProxyContorller  {
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired FileUploader uploader;
    @Autowired Proxy pxy;
//    @Autowired FileUploader loader;

    @PostMapping("/bugsmusic")
    public HashMap<String,Object> bugsMusic(@RequestBody String searchWord){
        pxy.print("넘어온 키워드 : "+searchWord);
        box.clear();
        ArrayList<HashMap<String,String>> list = crawler.bugsMusic();
        box.put("list",list);
        pxy.print("*************");
        pxy.print("조회한 수 :" + list.size());
        box.put("count",String.valueOf(list.size()));
        pxy.print("박스에 담긴 카운트: "+box.get("count"));
        return box.get();
    }
    @GetMapping("/soccer/{searchWord}")
    public HashMap<String,String> soccer(@PathVariable String searchWord){
        pxy.print("넘어온 키워드:"+ searchWord);
        uploader.upload();
        return null;
    }
}