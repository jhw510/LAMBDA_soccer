package com.lamda.web.proxy;

import com.lamda.web.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Service("uploaderM") @Lazy
public class FileUploderMusic {
@Autowired Inventory<String> inventory;
@Autowired
    MusicRepository musicRepository;

public void upload(){
    inventory.clear();
    try{
        BufferedReader reader=new BufferedReader(new FileReader(new File("")));
        String music = "";
        while ((music = reader.readLine()) != null){
            inventory.add(music);
        }

    }catch (Exception e){
        print("파일 리딩 에러");
        e.printStackTrace();
    }
    print("--------------------------------------\n");
    print(inventory.get().get(0).toString());
    String[] arr = inventory.get().get(0).split(",");
    musicRepository.save();

}

}
