import cn.org.rapid_framework.generator.GeneratorFacade;
public class Main {
    /**
     * luj
     *  基于开源rapid-generator项目做了如下修改：
     * (1)修改GeneratorControl.isOverride默认属性为true 覆盖旧文件
     * (2)修改cn.org.rapid_framework.generator.provider.db.table.model.ForeignKeys类，新增listMapToList方法 便于FreeMarker模板处理
     * (3)修改Entity模板文件: template\*\${className}.java  实现Entity一对多支持
     * (4)修改cn.org.rapid_framework.generator.provider.db.table.TableFactory类以及src\generator.xml文件  支持配置生成Entity时忽略部分表
     *
     *  运行提示：
     *  修改src\generator.xml文件 配置数据库连接参数，表前缀参数  映射类型参数
     *  如果需要修改Entity类代码格式，修改template\*\${className}.java文件 配置生成的Entity实体类代码格式
     */
    public static void main(String[] args) throws Exception{
	// write your code here

        GeneratorFacade g = new GeneratorFacade();
        g.deleteOutRootDir();
        //删除生成器的输出目录//
        g.generateByAllTable("template");
    }
}
