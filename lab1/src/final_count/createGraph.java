package final_count;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class createGraph {
	private static LinkedList<String> strslist=new LinkedList<String>();
    private static LinkedList<Node> nodeslist=new LinkedList<Node>();
    private static String InfofGraph="";
    private static String BridgeWords="";
    private static String FilePath="";
    private static String RandomPath="";
    private static String ValidInf="";
    public static void CreateDirectedGraph(){
    	int flag=0;
		int i,j;
		String[] nodes=null;
		Pattern p;
		nodeslist.clear();
		strslist.clear();
		if(ValidInf!=null){
			ValidInf=ValidInf.toLowerCase();   //处理文本文件
			ValidInf=ValidInf.replaceAll("[,.!?]"," "); 
			ValidInf=ValidInf.replaceAll("[\\pP‘’“”]",""); 
			ValidInf=ValidInf.replaceAll("[\\pN‘’“”]","");
			ValidInf=ValidInf.replaceAll("\\s+"," ");
			ValidInf=ValidInf.trim();
		}
		
		if(ValidInf!=null){
			p=Pattern.compile("\\s+");   //生成图
			nodes=p.split(ValidInf); 
		    for(i=0;i<nodes.length;i++){
		    	if(!strslist.contains(nodes[i])){
		    		strslist.add(nodes[i]);
		    	}
		    }
		}

	    for(Iterator iter1=strslist.iterator();iter1.hasNext();) {
	    	Node temp=new Node((String) iter1.next());
	    	nodeslist.add(temp);
	    }
    if(nodes!=null){
	    	for (i=0; i<nodes.length-1; i++) {  
		    	Edge edge=new Edge();
		    	edge.SetHead(nodes[i]);
		    	edge.SetTail(nodes[i+1]);
		    	edge.SetWeight();
		    	int index=strslist.indexOf(nodes[i]);
		    	Edge e=nodeslist.get(index).GetAdj();
		    	if(e==null){
		    		nodeslist.get(index).SetAdj(edge);
		    		nodeslist.get(index).SetNumOfEdge();
		    	}
		    	else{
		    		while(e!=null){
		    			if(e.GetTail().equals(edge.GetTail())){
		    				e.SetWeight();
		    				flag=1;
		    				break;
		    			}
		    			if(e.GetAdj()!=null)
		    				e=e.GetAdj();
		    			else
		    				break;
		    		}
		    		if(flag==0){
		    		   e.SetAdj(edge);
		    		   nodeslist.get(index).SetNumOfEdge();
		    		}
		    		flag=0;
		    	}
		    }   
	    }
    }
	public static LinkedList<String> getStrslist() {
		return strslist;
	}
	public static void setStrslist(LinkedList<String> strslist) {
		createGraph.strslist = strslist;
	}
	public static LinkedList<Node> getNodeslist() {
		return nodeslist;
	}
	public static void setNodeslist(LinkedList<Node> nodeslist) {
		createGraph.nodeslist = nodeslist;
	}
	public static String getInfofGraph() {
		return InfofGraph;
	}
	public static void setInfofGraph(String infofGraph) {
		InfofGraph = infofGraph;
	}
	public static String getBridgeWords() {
		return BridgeWords;
	}
	public static void setBridgeWords(String bridgeWords) {
		BridgeWords = bridgeWords;
	}
	public static String getFilePath() {
		return FilePath;
	}
	public static void setFilePath(String filePath) {
		FilePath = filePath;
	}
	public static String getRandomPath() {
		return RandomPath;
	}
	public static void setRandomPath(String randomPath) {
		RandomPath = randomPath;
	}
	public static String getValidInf() {
		return ValidInf;
	}
	public static void setValidInf(String validInf) {
		ValidInf = validInf;
	}
}
