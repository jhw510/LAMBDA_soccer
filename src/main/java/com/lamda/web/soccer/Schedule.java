package com.lamda.web.soccer;
import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
@Data

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "schedule")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleNo;

    @NotNull @Column(length = 10)
    private String  scheDate;
    @Column(length = 10)
    private String gudun;
    @NotNull @Column(length = 10)
    private String hometeamId;
    @NotNull  @Column(length = 10)
    private String awayteamId;
    @Column(length = 10)
    private String homeScore;
    @Column(length = 10)
    private String awayScore;

    @ManyToOne
    @JoinColumn(name = "stadium_id")@NotNull
    private Stadium stadium;

    @Builder
    public Schedule(  String scheDate ,String gudun
            ,String hometeamId,String awayteamId,String homeScore,String awayScore  ){

        this.scheDate=scheDate;
        this.gudun=gudun;
        this.hometeamId=hometeamId;
        this.awayteamId=awayteamId;
        this.homeScore=homeScore;
        this.awayScore=awayScore;



    }
}
