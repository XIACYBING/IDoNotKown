package com.hk.io.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @author: wang.yubin
 * @date: 2019/11/20
 * @description: 测试使用File类和对应的FileNameFilter
 */
public class DirFile {

    private static final Logger logger = LoggerFactory.getLogger(DirFile.class);

    public static void main(String[] args) {
        File filePath = new File("F:\\codeCollections\\Dubbo\\thinkingJava");
        String[] list = filePath.list();
        if (null != list && 0 != list.length) {
            for (String dir : list) {
                logger.info("filePath.list():[{}]", dir);
            }
        }else {
            logger.info("First is null");
        }
        list = filePath.list(new DirFilter(args[0]));
        if (null != list && 0 != list.length) {
            for (String dir : list) {
                logger.info("filePath.list(DirFilter):[{}]", dir);
            }
        }else {
            logger.info("Second is null");
        }

    }

}

class DirFilter implements FilenameFilter {

    private static final Logger logger = LoggerFactory.getLogger(DirFilter.class);

    private Pattern pattern;

    DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        logger.info("dir:[{}],name:[{}]", dir.toString(), name);
        return pattern.matcher(name).matches();
    }

}
