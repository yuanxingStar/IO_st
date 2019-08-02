package org.yuanxing.iost.bio.iost;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;

/**
 * @author yuanxing
 * @create 2019-08-01 16:58
 * @see
 */
public class FileReaderTest {


   public static void main(String[] atgs) {
        test3();
    }

    public static void test() {

        File file = new File("io.txt");
        System.out.println("file  main " + file.getAbsolutePath());
        //file  main D:\Git\st\IO_st\io.txt
    }


    /**
     * @see (1) test测试不能使用static标注
     */
    //@Test
    public void test1() {
        File file = new File("io.txt");
        System.out.println("file  @Test" + file.getAbsolutePath());
    }


    /**
     * 采用字符流 读取txt文件
     * 创建文件
     * 创建流
     * 读取文件
     * 关闭流
     */

    public static void test2() {
        FileReader fr = null;
        try {
            File file = new File("D:\\Git\\st\\IO_st\\io.txt");
            fr = new FileReader(file);
            int data;
            while ((data = fr.read()) != -1){
             System.out.println((char)data);
            }
        }catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try{
                    fr.close();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 使用read重载方法 读取文件
     */
    public static void test3() {
        FileReader fr = null;
        try {
            File file = new File("io.txt");
            fr = new FileReader(file);
            int data;
            char[] cbuf = new char[5];
            while ((data = fr.read(cbuf)) != -1){
                String str = new String(cbuf,0,data);
                System.out.println(str);
            }
        }catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try{
                    fr.close();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
