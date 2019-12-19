package com.example.helenkellercompute.guokun.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLParsingMethods {
    /**【SAX解析XML文件】**/
    public static List<Person> readXmlBySAX(InputStream inputStream) {
        try {
            /**【创建解析器】**/
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();
            SAXXMLContentHandler handler = new SAXXMLContentHandler();
            saxParser.parse(inputStream, handler);
            inputStream.close();
            return handler.getPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**【DOM解析XML文件】**/
    public static List<Person> readXmlByDOM(InputStream inputStream){
        List<Person> persons = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(inputStream);

            Element root = dom.getDocumentElement();
            /**【查找所有person节点】**/
            NodeList items = root.getElementsByTagName("person");
            for (int i = 0; i < items.getLength(); i++) {
                Person person = new Person();

                /**【得到第一个person的节点】**/
                Element personNode = (Element) items.item(i);

                /**【获取person节点的id属性】**/
                person.setId(new Integer(personNode.getAttribute("id")));

                /**【获取person节点下的所有子节点（标签之间的空白节点和name/age节点）】**/
                NodeList childsNodes = personNode.getChildNodes();

                /**【遍历所有子节点】**/
                for (int j = 0; j < childsNodes.getLength(); j++) {
                    Node node = (Node) childsNodes.item(j);

                    /**【判断是否为元素类型】**/
                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        Element childNode = (Element) node;
                        /**【判断是否是name元素】**/
                        if ("name".equals(childNode.getNodeName())) {
                            /**【获取name元素下的text节点，然后从text节点获取数据】**/
                            person.setName(childNode.getFirstChild().getNodeValue());
                            /**【判断是否是age元素】**/
                        }else if("age".equals(childNode.getNodeName())){
                            /**【获取age元素下的text节点，然后从text节点获取数据】**/
                            person.setAge(new Short(childNode.getFirstChild().getNodeValue()));
                        }
                    }
                }
                persons.add(person);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }
}
