import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class app {


    public static void main(String[] args) throws IOException, TemplateException {
        File f = new File(app.class.getClass().getResource("/").getPath());
        String ftlPath = f.getPath()+"/template";

        Configuration configuration = new Configuration();
       configuration.setDirectoryForTemplateLoading(new File(ftlPath));
        configuration.setDefaultEncoding("UTF-8");
        // 获取或创建一个模版。
        Template template = configuration.getTemplate("hhh.ftl");

        Writer writer  = new OutputStreamWriter(new FileOutputStream("./src/main/resources/success11.html"),"UTF-8");

        // 将页面中要展示的数据放入一个map中
        HashMap<String,Object> map = new HashMap<String, Object>();
        List<String> names = new ArrayList<>();
        names.add("qwe");
        names.add("123");
        map.put("names",names);
        map.put("name", "newsMap");

        //将map中的数据输入到index.ftl这个模板文件中并遍历出来，最后再将整个模板的数据写入到index.html中。
        template.process(map, writer);
        writer.close();

    }

}
