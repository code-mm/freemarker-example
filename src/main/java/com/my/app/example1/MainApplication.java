package com.my.app.example1;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) throws Exception {
        Configuration config = new Configuration();
        config.setObjectWrapper(new DefaultObjectWrapper());
        Template template = config.getTemplate("flt/test.flt", "UTF-8");
        String outPath = "gen";
        File file = new File(outPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath + "/TestGen.txt"), "UTF-8"));

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name1", "测试名称1");
        dataModel.put("name2", "测试名称2");

        template.process(dataModel, out);
        out.flush();
        out.close();
    }
}
