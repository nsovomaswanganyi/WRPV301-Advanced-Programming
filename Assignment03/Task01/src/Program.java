import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    static void main() {
        new Program();
    }

    public Program() {
        loadXML();

    }

    void askPersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the persona (e.g. Hamlet, Ophelia: ");

        String persona = scanner.nextLine();
    }

    NodeList loadXML() {

        NodeList personalist = new NodeList() {
            @Override
            public Node item(int index) {
                return null;
            }

            @Override
            public int getLength() {
                return 0;
            }
        };
        try{
            //create DBF and DB
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            //Get the actual xml document from the Resources folder
            Document document = dBuilder.parse(".//Task01/Resources/hamlet.xml");

            document.getDocumentElement().normalize(); // normalize text representation

//            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

            personalist = document.getElementsByTagName("PERSONA");

            System.out.println("Printing all the personas");
            for (int i = 0; i < personalist.getLength(); i++) {
                Node node = personalist.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;

                    System.out.println(element.getTextContent());

                }
            }


//            for (int i = 0; i < nodelist.getLength(); i++) {
//                Node node = nodelist.item(i);
//
//                //This for some reason returns the entire play
//               if(node.getNodeType() == Node.ELEMENT_NODE){
//                   Element element = (Element) node;
//                   System.out.println("Element Name: " + element.getNodeName());
//                   System.out.println("Element Value: " + element.getTextContent());
//
//                   //for debugging
////                   if(element.toString().equalsIgnoreCase("Persona")){
////                       System.out.println(element.getNodeName());
////                   }
//               }
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return personalist;

    }
}
