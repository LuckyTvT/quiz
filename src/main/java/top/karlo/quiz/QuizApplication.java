package top.karlo.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.karlo.quiz.annotation.EnableMyDataSourceAutoConfiguration;


/**
 * author:karlo
 * 图形文字地址：http://patorjk.com/software/taag/#p=display&f=Slant&t=KARLO
 */

@SpringBootApplication
@EnableMyDataSourceAutoConfiguration
public class QuizApplication {


    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }

}

