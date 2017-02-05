import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public abstract class Store implements StoreCapable{
	static File inputFile = new File("result.xml");
	static String filename = "Products.xml";
	ArrayList<Product> productList = new ArrayList<>();
	
	public ArrayList<Product> getAllProducts(){
		return this.productList;
		
	}
	public void storeCDProduct(String name, int price, int size){
		Product CD = new CDProduct(name, price, size);
		store(CD);
	}
	public void storeBookProduct(String name, int price, int size){
		Product book = new BookProduct(name, price, size);
		store(book);	
	}
	
	protected abstract void storeProduct(Product product);
	
	protected Product createProduct(String type, String name, int price, int size){
		if(type == "CD"){
			CDProduct CD = new CDProduct(name,price,size);
			return CD;
			
		}else{
			BookProduct Book = new BookProduct(name,price,size);
			return Book;
			
		}
		
		
	}
	private void saveToXML(Product product)
	   {   File xmlFile = new File(filename);
       try
       {
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

           Document doc;
           Element rootElement;
           if(xmlFile.exists()) {
               doc = dBuilder.parse(xmlFile);
               rootElement = doc.getDocumentElement();
           }
           else
           {
               doc = dBuilder.newDocument();
               rootElement = doc.createElement("Products");
               doc.appendChild(rootElement);
           }


           // root element

           //  element
           Element name = doc.createElement("Product");
           rootElement.appendChild(name);

           // setting attribute to element
           Attr attr = doc.createAttribute("Name");
           attr.setValue(product.name);
           name.setAttributeNode(attr);
           Attr attr2 = doc.createAttribute("Price");
           attr2.setValue(product.price.toString());
           name.setAttributeNode(attr2);

           // write the content into xml file
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           DOMSource source = new DOMSource(doc);
           StreamResult result = new StreamResult(new File(filename));
           transformer.transform(source, result);

       } catch (Exception e) {
           e.printStackTrace();
           }
	   }
	public ArrayList<Product> loadProducts(){
        try
        {
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Product");
            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode;
                    String instanceName = eElement.getAttribute("Name");
                    int instancePrice = Integer.parseInt(eElement.getAttribute("Price"));
                    productList.add(createProduct("CD", instanceName, instancePrice, 0));
                    

                }
            }
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
		return this.productList;
	}
	public void store(Product product){
		saveToXML(product);
		storeProduct(product);
		
	}
}

