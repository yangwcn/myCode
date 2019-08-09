package drools;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.drools.core.marshalling.impl.ProtobufMessages;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

public class Test {

    public void test(String rule) {//二进制文件书写
        InternalKnowledgeBase internalKnowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        knowledgeBuilder.add(ResourceFactory.newByteArrayResource(rule.getBytes()), ResourceType.DRL);
        KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();
        for (KnowledgeBuilderError error : errors) {
            System.out.println(error);
            throw new IllegalStateException("### errors ###");
        }
        internalKnowledgeBase.addPackages(knowledgeBuilder.getKnowledgePackages());
        KieSession kieSession = internalKnowledgeBase.newKieSession();

        Message message = new Message();
        message.setMessage("Good Bye");
        message.setStatus(Message.GOODBYE);
        kieSession.insert(message);//插入
        kieSession.fireAllRules();//执行规则
        kieSession.dispose();
    }

    public static void main(String[] args) {
        Test test = new Test();

        StringBuffer rule = new StringBuffer();
        rule.append("package drools\r\n")
                .append("import drools.Message\n")
                .append("rule \"Good Bye\"\n")
                .append("  when\n")
                .append("    Message( status == Message.GOODBYE, myMessage : message )\n")
                .append("  then\n")
                .append("    System.out.println( myMessage );\n")
                .append("end\n");
        //test.test(rule.toString());

        //test.testProducts();
        test.testProducts2();
    }

    public void testProducts() {//drools5写法

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("rules/Rules.drl",
                this.getClass()), ResourceType.DRL);
        if (kbuilder.hasErrors()) {
            System.out.println(kbuilder.getErrors().toString());
        }

        // add the package to a rulebase
        InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        // 将KnowledgePackage集合添加到KnowledgeBase当中
        kbase.addPackages(kbuilder.getKnowledgePackages());

        KieSession ksession = kbase.newKieSession();
        Product product = new Product();
        product.setType(Product.GOLD);
        ksession.insert(product);
        ksession.fireAllRules();
        ksession.dispose();

        System.out.println("The discount for the product " + product.getType()
                + " is " + product.getDiscount()+"%");
    }

    public void testProducts2(){//新写法
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("ksession-rule");
        Product product = new Product();
        product.setType(Product.GOLD);

        kieSession.insert(product);
        int count = kieSession.fireAllRules();
        System.out.println("命中了" + count + "条规则！");
        System.out.println("商品" +product.getType() + "的商品折扣为" + product.getDiscount() + "%。");
    }
}
