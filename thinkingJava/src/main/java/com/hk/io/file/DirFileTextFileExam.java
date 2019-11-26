package com.hk.io.file;

import com.alibaba.fastjson.JSON;
import net.mindview.util.TextFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @author: wang.yubin
 * @date: 2019/11/26
 * @description: 关于File的筛选练习
 */
public class DirFileTextFileExam {

    private static final Logger logger = LoggerFactory.getLogger(DirFileTextFileExam.class);

    public static void main(String[] args) {
        String regex = ".*.\\.java";
        String pathString = "F:\\codeCollections\\Dubbo\\thinkingJava\\src\\main\\java\\com\\hk\\io\\file";
        File path = new File(pathString);
        logger.info("path:[{}]", JSON.toJSONString(path.list()));
        String[] filePathArray = path.list(filter(regex));
        logger.info("seize path:[{}]", JSON.toJSONString(filePathArray));

        if (null == filePathArray) {
            return;
        }
        for (String filePath : filePathArray) {
            TextFile textFile = new TextFile(pathString.concat("\\".concat(filePath)));
            logger.info("[{}]:[{}]", filePath, JSON.toJSONString(textFile));
            /*TextFile读取文件时每一行文件为一个String数组成员，所以比较它的每一个数组成员即可*/
            for (String fileContent : textFile) {
                if (fileContent.contains("TextFile")) {
                    logger.info("[{}]:::::::::::::::::包含！", fileContent);
                }else {
                    logger.info("没有包含！");
                }
            }
        }

    }

    /**
     * 创建一个内部类，作用是筛选符合正则表达式的文件路径
     * @param regex 正则表达式
     * @return 返回一个文件名筛选类
     */
    private static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {

            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

}
