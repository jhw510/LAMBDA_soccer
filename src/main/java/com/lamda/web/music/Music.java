package com.lamda.web.music;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="music")
public class Music {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicNo;
    @Column(length = 4)
    private String seq;
    @Column(length = 30)
    private String title;
    @Column(length = 30)
    private String artists;
    @Column(length = 200)
    private String thumbnail;
    @Builder
    public Music(String seq, String title, String artists,
                 String thumbnail) {
        this.seq = seq;
        this.title = title;
        this.artists = artists;
        this.thumbnail = thumbnail;
    }

    public Long getMusicNo() {
        return musicNo;
    }

    public void setMusicNo(Long musicNo) {
        this.musicNo = musicNo;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public Music(){

    }
}