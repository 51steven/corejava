package com.xml.parser.dom4j;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jTest {

	public static void main(String[] args) throws Exception {
		//ָ��xml�ļ�����·��
		String path = "src/com/xml/parser/dom4j/test2.xml";
//		createXML(path);
		readXML(path);
	}

	private static void createXML(String path) throws Exception{
		//1���������νṹ
		//dom4j���ô���document�ڵ�(��dom�Ĳ�֮ͬ��)
		//dom4j�ڴ����ڵ��ͬʱ�Ͱѽڵ�����ϵ��������
		//�����ĵ������ø�Ԫ�ؽڵ�ķ�ʽ
		Element root = DocumentHelper.createElement("student");
		Document document = DocumentHelper.createDocument(root);
		//�����ڵ��������
		root.addAttribute("school", "������").addAttribute("position", "����");
		//�����ڵ�����ӽڵ�
		//����ֵ�����ӽڵ�
		Element element1 = root.addElement("student");
		element1.addElement("name").addAttribute("gender", "male").addText("����");
		element1.addElement("age").addText("22");
		
		//2��ת����xml�ļ�
		//�����ɵ�xml�ļ������Ӳ����,true�����Ƿ���
		OutputFormat format = new OutputFormat("        ", true);
		//���ñ���
		format.setEncoding("utf-8");
		
		XMLWriter xmlwriter = new XMLWriter(new FileOutputStream(path), format);
		xmlwriter.write(document);
		xmlwriter.close();
		
	}
	
	@SuppressWarnings("unchecked")
	private static void readXML(String path) throws Exception {
		//1���õ���������ֱ��new,Ϊ�������ں�(��dom�Ĳ�֮ͬ��)
		SAXReader reader = new SAXReader();
		//2�������ļ�
		Document document = reader.read(path);
		//3���õ����ڵ�
		Element root = document.getRootElement();
		System.out.println("���ڵ�����"+root.getName());
		
		//4��������и��ڵ��µ��ӽڵ�
		List<Element> childern = root.elements();
		for(Element child:childern){
			System.out.println("�ӽڵ�����"+child.getName());
			//�õ�name age �����ӽڵ�
			List<Element> sanOfSans = child.elements();
			
			//��һ��ѭ���õ�����name�ӽڵ�
			//����name�ӽڵ������
			for(Element sanOfSan: sanOfSans){ 
				
				System.out.println("�μ����ڵ��У�"+sanOfSan.getName());
				System.out.println("�ı�����Ϊ:"+sanOfSan.getText());
				List<Attribute> attributes = sanOfSan.attributes();
				//�ڶ����Ǳ���name�ڵ����������ֵ
				for(Attribute att:attributes){
					System.out.println("������"+att.getName());
					System.out.println("����ֵ"+att.getValue());
				}
			}
	     }
		
		/*dom4jҲ���Ը��ݱ�ǩ��ֱ���õ�ĳ���ڵ�
		 * root.element("student");
		 * Ĭ�Ϲ��˵��հ׵��ı��ڵ�
		 * */
    }
}
