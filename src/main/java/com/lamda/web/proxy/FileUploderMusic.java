package com.lamda.web.proxy;

import com.lamda.web.music.Music;
import com.lamda.web.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;

@Service("uploaderM") @Lazy
public class FileUploderMusic extends Proxy {
@Autowired Inventory<String> inventory;
@Autowired
    MusicRepository musicRepository;

public void upload(){
    inventory.clear();

    try{
        URL url = new URL("https://music.bugs.co.kr/chart");
        BufferedReader reader =new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer sourceCode = new StringBuffer();

        String sourceLine = "";
        while((sourceLine=reader.readLine()) !=null){
            sourceCode.append(sourceLine +"\n");
        }


    }catch (Exception e){
      print("파일 리 딩 에러 났어요");
        e.printStackTrace();
    }
    print("--------------------------------------\n");
   print(inventory.get().get(0).toString());
    String[] arr = inventory.get().get(0).split(",");
    Music m = new Music();
  //  String seq, String title, String artists,String thumbnail
   m.setSeq(arr[0]);
   m.setTitle(arr[1]);
   m.setArtists(arr[2]);
   m.setThumbnail(arr[3]);
    musicRepository.save(m);

}

}
