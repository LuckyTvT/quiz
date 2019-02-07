package top.karlo.quiz.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 功能描述：
 *
 * @author KARLO
 * @date 2019/2/6 14:59
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String source = "G:\\source";
        String target = "G:\\target";
        File sourceFile = new File(source);
        File targetFile = new File(target);
        File[] files = sourceFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].isDirectory()){
                File[] listFiles = files[i].listFiles();
                for (int j = 0; j < listFiles.length; j++) {
                    if(listFiles[j].isFile()){
                        FileInputStream inputStream = new FileInputStream(listFiles[j]);
                        String targetFileName = listFiles[j].getName();
                        File targetFile1 = new File(target + "\\" + targetFileName);
                        FileOutputStream outputStream = new FileOutputStream(targetFile1);
                        byte[] bytes = new byte[1024];
                        int read = 0;
                        while ( (read = inputStream.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, read);
                        }
                    }
                }

            }
        }

    }
}
