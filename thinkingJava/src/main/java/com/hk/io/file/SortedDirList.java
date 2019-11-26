package com.hk.io.file;

import com.alibaba.fastjson.JSON;
import net.mindview.util.TextFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URI;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author: wang.yubin
 * @date: 2019/11/26
 * @description: 接受文件路径信息，并创建文件排序目录
 */
@SuppressWarnings("unused")
public class SortedDirList extends File {

    private static final Logger logger = LoggerFactory.getLogger(SortedDirList.class);

    private SortedDirList(String pathname) {
        super(pathname);
        String[] pathArray = this.list();
        assert null != pathArray;
        logger.info("unOrderPathArray:[{}]", JSON.toJSONString(pathArray));
        Arrays.sort(pathArray, String.CASE_INSENSITIVE_ORDER);
        logger.info("orderedPathArray:[{}]", JSON.toJSONString(pathArray));
    }

    public SortedDirList(String parent, String child) {
        super(parent, child);
    }

    public SortedDirList(File parent, String child) {
        super(parent, child);
    }

    public SortedDirList(URI uri) {
        super(uri);
    }

    @Override
    public String[] list() {
        return super.list();
    }

    private String[] list(String regex) {
        String[] pathArray = this.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        assert null != pathArray;
        for (String path : pathArray) {
            logger.info("[{}]", path);
        }
        return pathArray;
    }

    public static void main(String[] args) {
        String pathString = "F:\\codeCollections\\Dubbo\\thinkingJava\\src\\main\\java\\com\\hk\\io\\file\\";
        SortedDirList sortedDirList = new SortedDirList(pathString);
        String[] seizePathArray = sortedDirList.list(".*\\.java");
        for (String seizePath : seizePathArray) {
            int lineNumber = 0;
            int fileCharNumber = 0;
            for (String fileLine : new TextFile(pathString.concat(seizePath))) {
                lineNumber++;
                fileCharNumber += fileLine.length();
            }
            logger.info("[{}]文件的行数为：[{}]，文件字符长度为：[{}]", seizePath, lineNumber, fileCharNumber);

        }

    }

}
