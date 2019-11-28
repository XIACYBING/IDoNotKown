package com.hk.io.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wang.yubin
 * @date: 2019/11/28
 * @description: P540页的练习，主要目的是练习Reader的使用
 */
public class ReaderExam {

    private static final Logger logger = LoggerFactory.getLogger(ReaderExam.class);

    /**
     * 练习原型
     * @param fileName 文件绝对路径
     * @return 返回文件内容，包括换行
     */
    private static String readFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String lineString = null;
            StringBuilder fileStringBuilder = new StringBuilder();
            while (null != (lineString = bufferedReader.readLine())) {
                fileStringBuilder.append(lineString).append("\n");
            }
            bufferedReader.close();
            logger.info("FileContent:[{}]", fileStringBuilder.toString());
            return fileStringBuilder.toString();
        }catch (Exception exception) {
            logger.error("读取文件发生异常!", exception);
            return null;
        }
    }

    /**
     * 将每行内容放入LinkedList中，并反序输出
     * @param fileName 文件名
     * @return 返回含有文件内容的LinkedList
     */
    private static LinkedList<String> readFileByLinkedListPrint(String fileName) {
        String fileContentString = readFile(fileName);
        assert null != fileContentString;
        String[] contentSplitArray = fileContentString.split("\n");
        LinkedList<String> lineContentList = new LinkedList<>(Arrays.asList(contentSplitArray));
        LinkedList<String> returnList = new LinkedList<>(lineContentList);
        for (int i = lineContentList.size(); i > 0; i--) {
            logger.info(lineContentList.removeLast());
        }
        return returnList;
    }

    /**
     * 将内容转化为大写
     * @param fileName 文件名
     */
    private static void readLineToUpperCase(String fileName) {
        LinkedList<String> lineContentList = readFileByLinkedListPrint(fileName);
        LinkedList<String> upperLineList = new LinkedList<>();
        lineContentList.forEach(lineContent -> {
            upperLineList.add(lineContent.toUpperCase());

        });
        upperLineList.forEach(lineContent -> logger.info("upperContent:[{}]", lineContent));
    }

    public static void main(String[] args) {
        String filePath = "F:\\codeCollections\\Dubbo\\thinkingJava\\src\\main\\java\\com\\hk\\io\\file\\DisturbFile";
        readFileByLinkedListPrint(filePath);
        readLineToUpperCase(filePath);
    }

}
