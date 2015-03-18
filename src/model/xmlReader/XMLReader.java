package model.xmlReader;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import java.io.File;
import java.util.*;

public class XMLReader {

	/**
	* Set the path the the xml file 
	* @param name the name and path to the xml file
	*/
	public void setXmlFileName(String name) {
		m_xmlFileName = name;
	}

	/**
	 * Open the xml file and normalize it
	 */
	public void OpenXML() {
		try {
			m_fXmlFile = new File(m_xmlFileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			m_doc = dBuilder.parse(m_fXmlFile);
			m_doc.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Generates a NodeList with the nodes of the specified type and sends the list to the processNodeList function
	 * @param type The type that has to be processed
	 */
	public void ReadType(String type)
	{
		if(m_debug)System.out.println("Root element :"
				+ m_doc.getDocumentElement().getNodeName());
		
		if(m_debug)System.out.println("----------------------------");
		
		NodeList nList = m_doc.getElementsByTagName(type);
		ProcessNodeList(nList, true);
	}
	
	
	/**
	 * Processes a node list and sends the data to processNode
	 * @param tempList A nodelist
	 * @param newHashMap true if a new hashMap should be generated (this is normally true for baseNodes)
	 */
	private void ProcessNodeList(NodeList tempList, boolean newHashMap)
	{
		if (tempList == null)
			return;
		
		for(int i = 0; i < tempList.getLength(); i++){
			if (newHashMap){
				if(m_debug)System.out.println("----------------------------");
				NewNodeBuffer();
			}
			Node nNode = tempList.item(i);
			ProcessNode(nNode);
		}
	}
	
	public ArrayList<HashMap<String, String>> GetHashMapArray()
	{
		NewNodeBuffer();
		return mah_outputValues;
	}
	/******************************************************************************************************/
	
	/**
	 * same as the other processnode function but then with a default value for newHashMap (false)
	 * @param tempList A nodelist
	 */
	private void ProcessNodeList(NodeList tempList)
	{
		ProcessNodeList(tempList, false);
	}
	
	/**
	 * Processes a node
	 * @param tempNode A node
	 */
	private void ProcessNode(Node tempNode){
		if (tempNode.getNodeType() == Node.ELEMENT_NODE){
				String key = tempNode.getNodeName();
				String value = tempNode.getTextContent();
				if (value != null && !value.contains(NEW_LINE) && !value.contains("\n"))
				{
					PrintKeyValue(key, value);
					AddToBuffer(key, value);
				}
				GetChildNodes(tempNode);
		}
	}
	
	/**
	 * Gets all the cild nodes from a node
	 * @param tempNode a node
	 */
	private void GetChildNodes(Node tempNode)
	{
		if(tempNode.hasChildNodes())
			ProcessNodeList(tempNode.getChildNodes());
		return;
	}
	
	/**
	 * Prints the key and the value
	 * @param key the key
	 * @param value the value
	 */
	private void PrintKeyValue(String key, String value){
		if(m_debug)System.out.println("-" +key);
		if(m_debug)System.out.println("- - -" +value);
	}
	
	/**
	 * addes the key and the value to the buffer
	 * @param key
	 * @param value
	 */
	private void AddToBuffer(String key, String value)
	{
		if (value != null && value != "")
		{
			mh_buffer.put(key, value);
			//System.out.println("Key: " + key + " - value: " + value);
		}
	}
	
	/**
	 * adds a new hashmap to the list
	 */
	private void NewNodeBuffer()
	{
		if (!mh_buffer.isEmpty())
			mah_outputValues.add(mh_buffer);
		mh_buffer = new HashMap<String, String>();
	}
	private static final String NEW_LINE = System.getProperty("line.separator");
	private final boolean m_debug = false;
	private File m_fXmlFile;
	private Document m_doc;
	private String  m_xmlFileName;
	private HashMap<String, String> mh_buffer = new HashMap<String, String>();
	private ArrayList<HashMap<String, String>> mah_outputValues = new ArrayList<HashMap<String, String>>();
}
