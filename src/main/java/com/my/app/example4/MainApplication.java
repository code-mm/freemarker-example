package com.my.app.example4;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.*;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) throws Exception {
        genJava();
    }

    public static void genJava() throws Exception {
        Configuration config = new Configuration();
        config.setObjectWrapper(new DefaultObjectWrapper());
        Template template = config.getTemplate("flt/java.flt", "UTF-8");
        JavaModel javaModel = new JavaModel("com.my.app.test.gen", "TestGen", List.of(new JavaPropertiesModel("String", "testName", false)));
        String outPath = "gen";
        File file = new File(outPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath + "/TestGen.java"), "UTF-8"));
        template.process(javaModel, out);
        out.flush();
        out.close();
    }
}
