package top.karlo.quiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class QuizApplicationTests {

//    @Test
//    public void contextLoads() {
//
//
//    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);
    }


}

