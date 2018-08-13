package com.xml.parser.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class MyFirstDom {

	public static void main(String[] args) throws Exception {
		
		//ָ��xml�ļ�����·��
		String path = "src/com/xml/parser/dom/test1.xml";
		createXML(path);
//		readXML(path);
	}
	
	//����xml�ļ�
	private static void createXML(String path) throws Exception {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		//����һ�����νṹ
		//����һ��document���͵Ľڵ����
		Document document = db.newDocument();
		
		//I�����ڴ��д��������νṹ
		createTree(document);
		
		//II�������Խṹת�����ļ�
		//ʹ��ת����
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer transformer = tff.newTransformer();
		//����transform()����������
		//1�����νṹ��Source����
		  DOMSource source = new DOMSource(document);
		//2����������xml�ĵ���Result����
		 StreamResult result = new StreamResult(path);
		
		//���԰�������xml��ʽ�����˿հ׵��ı��ڵ�
		//Ϊtransformer�������ò���
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);
		
	}
	
	//��װ�����ڵ�Ĺ���
	private static void createTree(Document document) {
		//dom�����������νṹ�Ĳ��裺
		//1�����������νṹ�еĽڵ㴴������
		//������Ԫ��
		Element root = document.createElement("employees");
		//��Ԫ��
		Element childElement = document.createElement("employee");
		//����
		Attr attr = document.createAttribute("age");
		//�ı�
		Text text = document.createTextNode("lisi");
		
		//2���ѽڵ�ͽڵ�֮�����ϵ��������(���µ���,����һ��˳����û�����⣿)
		//��appendChild()Ϊ�ڵ�����ӽڵ�
		childElement.appendChild(text);
		//Ϊ��������ӽڵ�
		//dom�����������Խڵ��ͬʱ���ᴴ������ֵ
		childElement.setAttributeNode(attr);
		//
		root.appendChild(childElement);
		//�Ѱ������ڵ��������Խṹ����document�ڵ���
		document.appendChild(root);
		
	}
	
	//��������������xml�ĵ�
	private static void readXML(String path) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(path);
		//�鿴��Ӧ�ڵ�Ԫ�ص�����
		//��ȡ���ڵ�
		//Ҫ�õ�ĳһ���ڵ�����õ�ͬһ��ε����нڵ㣬�ٱ���(�鷳)
		NodeList nodes = document.getChildNodes();
		//���ڵ�ֻ��һ����ͨ���±���
		Node root = nodes.item(0);
		//getLocalName():���пո���ʾ null
		//getNodeName():..........#Text
		System.out.println("���ڵ�����ƣ�"+root.getNodeName());
		//�õ����ڵ��µ��ӽڵ㣬����
		NodeList childNodes = root.getChildNodes();
		for(int i=0;i<childNodes.getLength();i++){
			Node node = childNodes.item(i);
			System.out.println("�ӽڵ������"+node.getNodeName());
			//����ӽڵ������,����ж��ҲҪ�����ó���������map
			NamedNodeMap attributes = node.getAttributes();
			//�жϽڵ�������Ƿ�Ϊ��
			if(attributes!=null){
				Node attri = attributes.item(0);
				System.out.println("������"+attri.getNodeName());
				System.out.println("����ֵ"+attri.getNodeValue());
			}
			//�жϽڵ���ı��Ƿ�Ϊ��N
			if(!(node.getNodeName().equals("#text"))){
				NodeList childNodes2 = node.getChildNodes();
				Node text = childNodes2.item(0);
				System.out.println("�ı�����"+text.getTextContent());
			}
		}
	}
}
