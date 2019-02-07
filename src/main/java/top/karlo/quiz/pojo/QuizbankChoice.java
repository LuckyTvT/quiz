package top.karlo.quiz.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class QuizbankChoice {
    private Integer id;

    private Integer type;

    private String question;

    private String a;

    private String b;

    private String c;

    private String d;

    private String answer;

    private Date inTime;

    private String extra1;

    private String extra2;

    private String extra3;


}