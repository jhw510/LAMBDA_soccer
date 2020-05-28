package com.lamda.web.proxy;


import com.lamda.web.music.MusicRepository;
import com.lamda.web.soccer.Player;
import com.lamda.web.soccer.PlayerDTO;
import com.lamda.web.soccer.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service("uploader") @Lazy
public class FileUploader extends Proxy{

    @Autowired Inventory<String> inventory;
    @Autowired
    PlayerRepository playerRepository;


    public void upload(){
        inventory.clear();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\bit\\lamda\\src\\main\\resources\\static\\files\\player.csv")));
            String player = "";
            while((player = reader.readLine()) != null){
                inventory.add(player);
            }
        }catch(Exception e){
            print("파일 리딩 에러");
            e.printStackTrace();
        }
        print("--------------------------------------\n");
        print(inventory.get().get(0).toString());
        String[] arr=inventory.get().get(0).split(",");
        //"player_id","player_name","team_id","e_player_name","nickname","join_yyyy","POSITION","back_no","nation","birth_date","solar","height","weight"
        Player p = new Player();
        p.setPlayerId(arr[0]);
        p.setPlayerName(arr[1]);
        p.setePlayerName(arr[3]);
        p.setNickname(arr[4]);
        p.setJoinYyyy(arr[5]);
        p.setPosition(arr[6]);
        p.setBackNo(arr[7]);
        p.setNation(arr[8]);
        p.setBirthDate(arr[9]);
        p.setSolar(arr[10]);
        p.setHeight(arr[11]);
        p.setWeight(arr[12]);
        print("****************\n");
        print(p.toString());

        playerRepository.save(p);

    }

}