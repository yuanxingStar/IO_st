package org.yuanxing.iost.bio.filest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author yuanxing
 * @create 2019-07-29 16:26
 * @see (1) 测试File类
 */
public class FileTest {

    public static void main(String[] args) {
        FileTest ft = new FileTest();
        ft.test7();
    }

    /**
     *  测试File类的构造方法
     */
    public void test1() {

        File file1 = new File("file1.txt");
        File file2 =  new File("D:\\workspace_test\\file2.txt");

        System.out.println("file1-" + file1);
        System.out.println("file2-" + file2);

        File file3 = new File("D:\\workspace_test","file3");
        System.out.println("file3-" + file3);

        File file4 = new File(file3,"file4.txt");
        System.out.println("file4-" + file4);
    }


    /**
     *  测试File的一些常用方法
     */
    public void test2() {
        File file1 = new File("test2File1.txt");
        File file2 = new File("d:\\io\\test2File2.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));


        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    public void test3() {
        File file = new File("D:\\workspace_idea1\\JavaSenior");

        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }

        System.out.println();
        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }
    }

    public void test4() {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");

        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);
    }

    public void test5() {
        File file1 = new File("hello.txt");
        file1 = new File("hello1.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("d:\\io");
        file2 = new File("d:\\io1");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    public void test6() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            //文件的创建
            file1.createNewFile();
            System.out.println("创建成功");
        }else{//文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }

    public void test7() {
        //文件目录的创建
        File file1 = new File("d:\\io\\io1\\io3");

        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");
        }

        File file2 = new File("d:\\io\\io1\\io4");

        boolean mkdir1 = file2.mkdirs();
        if(mkdir1){
            System.out.println("创建成功2");
        }
        //要想删除成功，io4文件目录下不能有子目录或文件
        File file3 = new File("D:\\io\\io1\\io4");
        file3 = new File("D:\\io\\io1");
        System.out.println(file3.delete());
    }
}
