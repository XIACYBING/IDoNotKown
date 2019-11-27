package com.hk.io.file;

import com.sun.xml.internal.ws.util.StringUtils;
import net.mindview.util.Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: wang.yubin
 * @date: 2019/11/27
 * @description: ThinkingInJava上代码的变种，使其能匹配正则表达式
 */
public class ProcessFiles {

    private static final Logger logger = LoggerFactory.getLogger(ProcessFiles.class);

    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;

    private String ext;

    private String regex;

    private ProcessFiles(Strategy strategy, String ext, String regex) {
        this.strategy = strategy;
        this.ext = ext;
        this.regex = regex;
    }

    private void  processDirectoryTree(File root) {
        Directory.TreeInfo treeInfo;
        if (null == regex) {
            treeInfo = Directory.walk(root.getAbsolutePath(), ".*\\." + ext);
        }else {
            treeInfo = Directory.walk(root.getAbsolutePath(), regex);
        }
        treeInfo.forEach( file -> {
            try {
                strategy.process(file.getCanonicalFile());
            } catch (IOException ioeException) {
                logger.info("发生异常!", ioeException);
            }
        });
    }

    private void start(String[] args) {
        try {
            if (0 == args.length) {
                this.processDirectoryTree(new File("."));
            }else {
                for (String arg : args) {
                    File file = new File(arg);
                    if (file.isDirectory()) {
                        this.processDirectoryTree(file);
                    }else if (arg.endsWith("." + ext)) {
                        arg += "." + ext;
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        }catch (IOException ioeException) {
            logger.info("发生异常!", ioeException);
        }
    }

    public static void main(String[] args) {
        String[] pathArray = Arrays.copyOf(args, 1);
        pathArray[0] = "F:\\codeCollections\\Dubbo\\thinkingJava\\src\\main\\java\\com\\hk\\io\\file\\";
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                /*可以在这里比较文件最后修改时间，从而筛选文件*/
                logger.info("Strategy File:[{}]", file);
            }
        }, "java", "Dir\\w+.*").start(pathArray);
    }

}
