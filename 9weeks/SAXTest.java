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
      	//SAX�� �غ��Ѵ�
      	SAXParserFactory spf = SAXParserFactory.newInstance();
      	SAXParser sp = spf.newSAXParser();

      	//�ڵ鷯�� �غ��Ѵ�
     	OEventHandler oeh = new OEventHandler();

      	//������ �о���δ�
      	sp.parse(new FileInputStream(args[0]), oeh);
   }
}

//�ڵ鷯 Ŭ����
class OEventHandler extends DefaultHandler
{
   //������ ����
   public void startDocument() 
   {
	  System.out.println("startDocument �޼ҵ� ȣ���");
      	  System.out.println("XML������ ���۵Ǿ���.");
   }
   // ��� ���� ���� ����
   int ScountElement = 0;
   int EcountElement = 0;

   public void startElement(String namespaceURI, String name, String qName, Attributes atts) 
   {
      ScountElement +=1;
      System.out.println("startElement �޼ҵ� ȣ���");
      System.out.println( ScountElement + "��° ���� ���.");
   }
  
   public void endElement(String namespaceURI, String name, String qName) 
   {
      EcountElement +=1;
      System.out.println("endElement �޼ҵ� ȣ���");
      System.out.println( EcountElement + "��° ���� ���.");
   }
  
   //������ ����
   public void endDocument() 
   {
      System.out.println("endDocument �޼ҵ� ȣ���");
      System.out.println("XML������ ����Ǿ���.");
   }
}