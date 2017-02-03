import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public abstract class Store implements StoreCapable
{
    static String filename = "valami.xml";
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
    protected abstract void storeProduct(Product product);


    protected Product createProduct(String type, String name, int price, int size)
    {
        if(type == "CD")
        {
            Product cd = new CDProduct(name, price, size);
            return cd;
        }
        else
        {
            Product book = new BookProduct(name, price, size);
            return book;
        }
    }

    public ArrayList<Product> loadProduct()
    {
        return null;
    }
    public void store(Product product) throws Exception
    {
        saveToXML(product);
    }
    public void storeCdProduct(String name, int price, int tracks) throws Exception
    {
        Product cd = new CDProduct(name, price, tracks);
        saveToXML(cd);
    }

    public void storeBookProduct(String name, int price, int size)throws Exception
    {
        Product book = new BookProduct(name, price, size);
        saveToXML(book);
    }
    public ArrayList<Product> getAllProduct()
    {
        return null;
    }
}
