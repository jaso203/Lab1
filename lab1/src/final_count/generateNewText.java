package final_count;

import java.util.LinkedList;
import java.util.Random;
import java.util.regex.Pattern;

public class generateNewText {
	private static LinkedList<String> strslist=new LinkedList<String>();
    private static LinkedList<Node> nodeslist=new LinkedList<Node>();
    private static String InfofGraph="";
    private static String BridgeWords="";
    private static String FilePath="";
    private static String RandomPath="";
    private static String ValidInf="";
    public static String generateNewText(String inputText){
		Pattern p=Pattern.compile("\\s+"); 
		String[] words=p.split(inputText);
		String bridge=null;
		String result=words[0]+" ";
		for(int i=0;i<words.length-1;i++){
			String bridges=queryAddWords(words[i],words[i+1]);
			bridges.trim();
			if(!bridges.equals(" ")){
				Pattern p2=Pattern.compile(",");   
				String[] BridgesWords=p2.split(bridges);
				int max=BridgesWords.length-1;
		        int min=0;
		        Random random = new Random();
		        int RandomIndex=random.nextInt(max-min+1)+min;
				result=result+BridgesWords[RandomIndex].trim()+" ";
			}
			result=result+words[i+1]+" ";
		}
		return result;
	}
	
	public static String queryAddWords(String Word1,String Word2){
		String result=" ";
		int index1=strslist.indexOf(Word1);
		int index2=strslist.indexOf(Word2);
		if(index1==-1 || index2==-1){
			result=" ";
		}
		else{
			Edge edge=nodeslist.get(index1).GetAdj();
			if (edge==null){
			    result=" ";
			}
			else if(edge.GetTail().equals(Word2)){
				result=" ";
			}
			else{
				while(edge!=null){
					int index3=strslist.indexOf(edge.GetTail());
					Edge edge2=nodeslist.get(index3).GetAdj();
					if (edge2==null)
						break;
					else{
						while(edge2!=null){
							if(edge2.GetTail().equals(Word2)){
								result=result+edge2.GetHead()+",";
								break;
							}
							edge2=edge2.GetAdj();
						}
					}
	    			edge=edge.GetAdj();
				}
			}
		}
		return result;
	}
	
	public static LinkedList<String> getStrslist() {
		return strslist;
	}
	public static void setStrslist(LinkedList<String> strslist) {
		generateNewText.strslist = strslist;
	}
	public static LinkedList<Node> getNodeslist() {
		return nodeslist;
	}
	public static void setNodeslist(LinkedList<Node> nodeslist) {
		generateNewText.nodeslist = nodeslist;
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
