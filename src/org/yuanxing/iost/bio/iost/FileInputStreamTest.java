package org.yuanxing.iost.bio.iost;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author yuanxing
 * @create 2019-07-31 10:04
 * @see  (1) 对FileInputStream进行测试
 *          对于文本文件(.txt , .java , .c , .cpp) 使用字符流处理
 *          对于非文本文件 (.jpg , .mp3 , .mp4 , .avi , .doc , .ppt...)  使用字节流处理
 */
public class FileInputStreamTest {


    public static void main(String[] args) {
            test2();
    }


    public static void test1() {

        FileInputStream fis = null;
        try{
            //1.读文件
            File file = new File("hello.txt");
            //2.创建流
            fis = new FileInputStream(file);
            //3.读取文件数据
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str  = new String(buffer,0,len);
                System.out.println(str);
            }
        }catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                //4.读取完毕 关闭流
                try {
                    fis.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *  JDK 1.7之后 采用 try-with-resource语法  关闭资源
     *  只要资源实现了AutoCloseable或者Closeable接口，try-with-resources能帮其自动关闭
     */
    public static void test2() {

        try(FileInputStream fis = new FileInputStream(new File("io.txt"))) {
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str  = new String(buffer,0,len);
                System.out.println(str);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }




}
