package com.my.app.example3;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) throws Exception {
        List<Entity> entities = new ArrayList<>();
        entities.add(new Entity("UNKNOWN_ERROR", "Unknown Error", -1));
        entities.add(new Entity("SYSTEM_ERROR", "Systen Error", 500));
        entities.add(new Entity("UNAUTHORIZED", "Unauthorized", 401));
        Map<String, Object> params = new HashMap<>();
        params.put("infos", entities);
        genJava(params);
    }

    public static void genJava(Map<String, Object> params) throws Exception {
        Configuration config = new Configuration();
        config.setObjectWrapper(new DefaultObjectWrapper());
        Template template = config.getTemplate("flt/exception.flt", "UTF-8");
        boolean windows = File.separatorChar == '\\';
        if (windows) {

        } else {
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("gen/ErrorInfo.java"), "UTF-8"));
            template.process(params, out);
            out.flush();
            out.close();
        }
    }
}
