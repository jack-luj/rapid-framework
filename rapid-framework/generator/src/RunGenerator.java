import cn.org.rapid_framework.generator.GeneratorFacade;
public class RunGenerator {
    /**
     * luj
     *  ���ڿ�Դrapid-generator��Ŀ���������޸ģ�
     * (1)�޸�GeneratorControl.isOverrideĬ������Ϊtrue ���Ǿ��ļ�
     * (2)�޸�cn.org.rapid_framework.generator.provider.db.table.model.ForeignKeys�࣬����listMapToList���� ����FreeMarkerģ�崦��
     * (3)�޸�Entityģ���ļ�: template\*\${className}.java  ʵ��Entityһ�Զ�֧��
     * (4)�޸�cn.org.rapid_framework.generator.provider.db.table.TableFactory���Լ�src\generator.xml�ļ�  ֧����������Entityʱ���Բ��ֱ�
     *
     *  ������ʾ��
     *  �޸�src\generator.xml�ļ� �������ݿ����Ӳ�������ǰ׺����  ӳ�����Ͳ���
     *  �����Ҫ�޸�Entity������ʽ���޸�template\*\${className}.java�ļ� �������ɵ�Entityʵ��������ʽ
     */
    public static void main(String[]args)throws Exception{
        GeneratorFacade g = new GeneratorFacade();
        // g.deleteOutRootDir();
        //ɾ�������������Ŀ¼//
        g.generateByAllTable("template");
    }

}
