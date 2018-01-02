package cn.ucaner.mongo.asm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;


/**
* @Package：com.sunshine.asm   
* @ClassName：GeneratorClass   
* @Description：   <p> 生成class类文件</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月2日 下午2:35:49   
* @Modify By：   
* @ModifyTime：  2018年1月2日
* @Modify marker：   
* @version    V1.0
 */
public class GeneratorClass {
	
	
	 public static void main(String[] args) throws IOException {
	        //生成一个类只需要ClassWriter组件即可
	        ClassWriter cw = new ClassWriter(0);
	        //通过visit方法确定类的头部信息
	        cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT+Opcodes.ACC_INTERFACE,
	                "com/asm3/Comparable", null, "java/lang/Object", new String[]{"com/asm3/Mesurable"});
	        //定义类的属性
	        cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC,
	                "LESS", "I", null, new Integer(-1)).visitEnd();
	        cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC,
	                "EQUAL", "I", null, new Integer(0)).visitEnd();
	        cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC,
	                "GREATER", "I", null, new Integer(1)).visitEnd();
	        //定义类的方法
	        cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT, "compareTo",
	                "(Ljava/lang/Object;)I", null, null).visitEnd();
	        cw.visitEnd(); //使cw类已经完成
	        //将cw转换成字节数组写到文件里面去
	        byte[] data = cw.toByteArray();
	        File file = new File("D://Comparable.class");
	        FileOutputStream fout = new FileOutputStream(file);
	        fout.write(data);
	        fout.close();
	    }

}
