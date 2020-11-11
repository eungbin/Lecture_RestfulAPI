import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

class SAXTest
{
   public static void main(String[] args) throws Exception
   {
	if (args.length != 1)
   	{
		System.out.println("usage : >java SAXTest <input-file name>");
	 	System.exit(1);
    	}
      	//SAX를 준비한다
      	SAXParserFactory spf = SAXParserFactory.newInstance();
      	SAXParser sp = spf.newSAXParser();

      	//핸들러를 준비한다
     	OEventHandler oeh = new OEventHandler();

      	//문서를 읽어들인다
      	sp.parse(new FileInputStream(args[0]), oeh);
   }
}

//핸들러 클래스
class OEventHandler extends DefaultHandler
{
   //문서의 시작
   public void startDocument() 
   {
	  System.out.println("startDocument 메소드 호출됨");
      	  System.out.println("XML문서가 시작되었음.");
   }
   // 요소 개수 변수 선언
   int ScountElement = 0;
   int EcountElement = 0;

   public void startElement(String namespaceURI, String name, String qName, Attributes atts) 
   {
      ScountElement +=1;
      System.out.println("startElement 메소드 호출됨");
      System.out.println( ScountElement + "번째 시작 요소.");
   }
  
   public void endElement(String namespaceURI, String name, String qName) 
   {
      EcountElement +=1;
      System.out.println("endElement 메소드 호출됨");
      System.out.println( EcountElement + "번째 종료 요소.");
   }
  
   //문서의 종료
   public void endDocument() 
   {
      System.out.println("endDocument 메소드 호출됨");
      System.out.println("XML문서가 종료되었음.");
   }
}