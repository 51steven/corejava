package com.xml.parser.sax;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserTest {

	public static void main(String[] args) throws Exception {
		//I����Ҫxml�Ĵ��·��
		String path  = "src/com/xml/parser/sax/web.xml";
		parserXML(path);

	}

	private static void parserXML(String path) throws Exception {
		//II����������������࣬�õ������ģʽ���ǲ��ù���ģʽ
		//1���õ���������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2��ͨ������������Ʒ  SAXParser  ������
		SAXParser parser = factory.newSAXParser();
		
		//DefaultHandler ==>listener
		parser.parse(path, new DefaultHandler(){
		//3�������ļ�
			//������xml�ĵ���ͷ����ִ��һ�·���
			@Override
			public void startDocument() throws SAXException {
				System.out.println("<?xml version='1.0' encoding='utf-8'?>");
				
			}

			//������xml�ĵ���β����ִ��һ�·���
			@Override
			public void endDocument() throws SAXException {
				super.endDocument();
			}

			/*������xml��ʼ��ǩ����ִ��һ�·���
			 *uri:�����ռ����ַ
			 *localName:�����������ռ�ı�ǩ�� 
			 *qName:���������ռ�ı�ǩ�� 
			 *attributes:������map�Ľṹ ,��ŵ���һ������������Ҫͨ�������������ֵ�ó���
			 * */
			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {

				System.out.print("<"+qName+" ");
				for(int i=0;i<attributes.getLength();i++){
					//���������
					String attname = attributes.getQName(i);
					///�������ֵ
					String attvalue = attributes.getValue(attname);  //ͨ�����������±궼�ܹ��õ�����ֵ
					System.out.print(attname+"="+attvalue+" ");
				}
				System.out.println(">");
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				System.out.print("<"+qName+">");
			}
			
			//�������ַ�ִ�����淽��
			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				System.out.println(new String(ch, start, length));
				
			}
		});
	}
}
