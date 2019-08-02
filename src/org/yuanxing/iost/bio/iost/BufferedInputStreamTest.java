package org.yuanxing.iost.bio.iost;

import java.io.*;

/**
 * @author yuanxing
 * @create 2019-08-02 13:59
 * @see  (1) 缓冲流  输入流  字节流
 *
 *      (2) 提高流的读取、写入的速度  提高读写速度的原因：内部提供了一个缓冲区
 */
public class BufferedInputStreamTest {

    public static void main(String[] args){
        test1();
    }


    public static void test1() {

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("爱情与友情.jpg")));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("爱情与友情4.jpg")))) {

            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
