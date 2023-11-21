package com.my.app.example2;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListExample {
    public static void main(String[] args) throws Exception {
        Configuration config = new Configuration();
        config.setObjectWrapper(new DefaultObjectWrapper());
        Template template = config.getTemplate("flt/list.flt", "UTF-8");
        String outPath = "gen";
        File file = new File(outPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath + "/list.txt"), "UTF-8"));

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("datas", List.of(
                Map.of("name", "游客1"),
                Map.of("name", "游客2"),
                Map.of("name", "游客3")
        ));
        template.process(dataModel, out);
        out.flush();
        out.close();
    }
}