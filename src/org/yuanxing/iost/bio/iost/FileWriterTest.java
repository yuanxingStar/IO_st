package org.yuanxing.iost.bio.iost;

import java.io.File;
import java.io.FileWriter;

/**
 * @author yuanxing
 * @create 2019-08-01 17:02
 * @see  (1) 向指定文件输出文件
 *
 * File 对应的硬盘中的文件如果不存在 在输出的过程中 会自动创建此文件
 * File 对应的硬盘中的文件如果存在
 *      如果流使用的构造器是  FileWriter(file,false) /
 *                            FileWriter(file)对原有的文件覆盖
 *
 *      如果流使用的构造器是  FileWriter(file true) 不会对原有的文件覆盖 ，
 *                                                  而是在原有的文件基础上追加内容
 *
 *  创建文件
 *  创建流
 *  输出内容
 *  关闭流
 */
public class FileWriterTest {

    public static void main(String[] args){
        test1();
    }


    /**
     * @see (1) 输出一个全新的文件
     */
    public static void test(){
        FileWriter fw = null;
        try {
            File file = new File("D:\\Git\\st\\IO_st\\io1.txt");
            fw = new FileWriter(file);
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream !");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(fw != null) {
                try{
                    fw.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * @see (1) 向原有的文件追加输出
     */

    public static void test1() {
        FileWriter fw = null;

        try{
            File file = new File("io.txt");
            fw = new FileWriter(file,true);
            fw.write("/n测试  --向文件输出测试信息");
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            if(fw != null) {
                try{
                    fw.close();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
