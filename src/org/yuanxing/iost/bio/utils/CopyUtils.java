package org.yuanxing.iost.bio.utils;

import java.io.*;

/**
 * @author yuanxing
 * @create 2019-08-01 19:49
 *
 */
public class CopyUtils {

public static void main(String[] args) {
    copy1();
}


    /**
     * @see （1） 字节流  复制一个 字符文件
     */
    public static void copy1() {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            File oldFile = new File("io.txt");
            File newFile = new File("io2.txt");

            fr = new FileReader(oldFile);
            fw = new FileWriter(newFile);

            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(fw != null){
                    fw.close();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
            try{
                if(fr != null) {
                    fr.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
}

    /**
     *
     * @param srcPath
     * @param destPath
     *
     * @  基础流操作  复制文件
     *
     */
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                //
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *
     * @param oldPath
     * @param newPath
     * @see  (1)  采用缓冲流的方式  复制文件
     */
    public void copyFileWithBuffered(String oldPath,String newPath){

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(oldPath)));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(newPath)))) {
            //复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
