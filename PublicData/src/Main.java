import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Main {
    public static void main(String[] args) {
        try {
            // DOM(HTML 객체) Document 객체 생성
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // xml 파일을 파싱(해석)하는 객체
            DocumentBuilder parser = dbf.newDocumentBuilder();

            Document xmlDoc = null;
            String url = "xml\\book.xml";
            xmlDoc = parser.parse(url);

            // <booklist> : 루트 엘리먼트 접근
            Element root = xmlDoc.getDocumentElement();

            Node bookNode = root.getElementsByTagName("book").item(0);
            bookNode.getTextContent();

            // <book> : 첫번째 book 엘리먼트 접근
            // <book>의 자식 엘리먼트 접근
            Node author = ((Element) bookNode).getElementsByTagName("author").item(0);
            author.getTextContent();
            System.out.println(author.getTextContent());

            Node price = ((Element) bookNode).getElementsByTagName("price").item(0);

            int length = root.getElementsByTagName("book").getLength();

            for(int i = 0; i < length; i++) {
                Node book = root.getElementsByTagName("book").item(i);
                String kind = ((Element) book).getAttribute("kind");
                Node author1 = ((Element) book).getElementsByTagName("author").item(0);
                Node price1 = ((Element) book).getElementsByTagName("price").item(0);
                System.out.println("kind"+i+kind);
                System.out.println("atuhor"+i+author1.getTextContent());
                System.out.println("price"+i+price1.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

