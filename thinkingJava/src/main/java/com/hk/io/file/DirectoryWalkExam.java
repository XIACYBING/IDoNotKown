package com.hk.io.file;

import net.mindview.util.Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * @author: wang.yubin
 * @date: 2019/11/27
 * @description: 使用Directory.walk()方法计算所有名字和特定正则表达式匹配的文本尺寸总和
 */
public class DirectoryWalkExam {

    private static final Logger logger = LoggerFactory.getLogger(DirectoryWalkExam.class);

    public static void main(String[] args) {
        String pathString = "F:\\codeCollections\\Dubbo\\thinkingJava\\src\\main\\java\\com\\hk\\io\\file\\";
        Directory.TreeInfo treeInfo = Directory.walk(pathString, "Dis\\w+");
        List<File> fileList = treeInfo.files;
        Long size = fileList.stream().mapToLong(File::length).sum();
        logger.info("size:[{}]", size);
    }

}
