package org.yuanxing.iost.bio.iost;

import java.io.*;

/**
 * @author yuanxing
 * @create 2019-08-02 14:00
 * @see  (1) 缓冲流  输入流  字符流
 */
public class BufferedReaderTest {

    public static void main(String[] args){
        test1();
    }



    public static void test1() {

        try(BufferedReader bis = new BufferedReader(new FileReader(new File("io.txt")));
            BufferedWriter bos = new BufferedWriter(new FileWriter(new File("io4.txt")))) {

            char[] chars = new char[1024];
            int len;
            while((len = bis.read(chars)) != -1){
                bos.write(chars,0,len);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     *  第二种方式 读取字符文件
     */
    public  static void test2() {

        try(BufferedReader bis = new BufferedReader(new FileReader(new File("io.txt")));
            BufferedWriter bos = new BufferedWriter(new FileWriter(new File("io4.txt")))) {
            String data;
            while((data = bis.readLine()) !=  null){
                bos.write(data);
                /**
                 * 增加换行操作
                 */
                bos.newLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
