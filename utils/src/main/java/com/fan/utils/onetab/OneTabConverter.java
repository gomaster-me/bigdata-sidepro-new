package com.fan.utils.onetab;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author TonyFeng(itdamo)
 */
public class OneTabConverter {
    public static void main(String[] args) throws IOException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("./utils/src/main/resources/onetab-2021-0315.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        // 结果文件保存
        FileWriter fileWriter = new FileWriter("new-onetab-20210315.md");

        // 读取 调换位置调整为[]()格式
        String str;
        int count = 0;
        int emptyLine = 0;
        List<Integer> duplicated_lines = new ArrayList<>();
        int duplicatedSize = 0;
        while ((str = bufferedReader.readLine()) != null) {
            if ("".equals(str.trim())) {
                emptyLine++;
                continue;
            }

            String[] split = str.trim().split("\\|");
            if (split.length == 1) {
                split = Arrays.copyOf(split, 2);
                split[1] = "none 程序补充";
            }

            System.out.println(split[0] + " | " + split[1]);
            String newLine = String.format("[%s](%s)", split[1], split[0]);
            System.out.println("替换修改后: " + newLine);

            count++;
            int hcode = newLine.hashCode();
            if (duplicated_lines.contains(hcode)) {
                System.out.println("重复文件不再写入: " + newLine);
                duplicatedSize++;
                continue;
            }
            duplicated_lines.add(hcode);
            fileWriter.write(newLine + "\n");
        }

        //close
        inputStream.close();
        bufferedReader.close();
        fileWriter.flush();
        fileWriter.close();
        System.out.println("重复文件数为: " + duplicatedSize);
        System.out.println("文件数: " + count + " emptyLine: " + emptyLine);
        System.out.println("文件总数: " + (count + emptyLine));
    }

    public void fileWriter(String fileName, TreeSet<String> clist) throws IOException {
        FileWriter fw = new FileWriter(fileName);        //遍历clist集合写入到fileName中
        for (String str : clist) {
            fw.write(str);
            fw.write("\n");
        }        //刷新缓冲区
        fw.flush();        //关闭文件流对象
        fw.close();
    }
}
