package top.karlo.quiz.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class QuizbankBlank {
    private Integer id;

    private Integer type;

    private String question;

    private String answer;

    private Date inTime;

    private String extra1;

    private String extra2;

    private String extra3;

}