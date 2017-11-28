package final_count;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class queryBridgeWords {
	private static LinkedList<String> strslist=new LinkedList<String>();
    private static LinkedList<Node> nodeslist=new LinkedList<Node>();
    private static String InfofGraph="";
    private static String BridgeWords="";
    private static String FilePath="";
    private static String RandomPath="";
    private static String ValidInf="";
    public String queryBridgeWords(String Word1,String Word2){
		String OriginWord1=Word1;
		String OriginWord2=Word2;
		Word1=Word1.toLowerCase();
		Word2=Word2.toLowerCase();
		String result=" ";
		int flag1=0,flag2=0;
		if(!Word1.equals("") && !Word2.equals("")) {
			for(int i=0;i<Word1.length();i++) {
				if(!(Word1.charAt(i)<='z' && Word1.charAt(i)>='a') && !(Word1.charAt(i)<='Z' && Word1.charAt(i)>='A')) {
					flag1=1;
				}
			}
			for(int i=0;i<Word2.length();i++) {
				if(!(Word2.charAt(i)<='z' && Word2.charAt(i)>='a') && !(Word2.charAt(i)<='Z' && Word2.charAt(i)>='A')) {
					flag2=1;
				}
			}
			if(flag1==1 || flag2==1) {
				result="Invalid input!(blank or include illegal character)";
			    return result;
			}
		
		}
		else {
			result="Invalid input!(blank or include illegal character)";
		    return result;
		}
		int index1=strslist.indexOf(Word1);
		int index2=strslist.indexOf(Word2);
		if(index1==-1 && index2!=-1){
			result="No "+"\""+OriginWord1+"\""+" in the graph!";
		    return result;
		}
		else if(index1!=-1 && index2==-1){
		    result="No "+"\""+OriginWord2+"\""+" in the graph!";
		    return result;
		}
		else if(index1==-1 && index2==-1){
			result="No "+"\""+OriginWord1+"\""+" or "+"\""+OriginWord2+"\""+" in the graph!";
			return result;
		}
		else{
			Edge edge=nodeslist.get(index1).GetAdj();
			if (edge==null){
			   result="No bridge words from "+"\""+OriginWord1+"\""+" to "+"\""+OriginWord2+"\""+"!";
			   return result;
			}
			else if(edge.GetTail().equals(Word2)){
				result="No bridge words from "+"\""+OriginWord1+"\""+" to "+"\""+OriginWord2+"\""+"!";
				return result;
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
		result=result.trim();
		if(result.equals("")){
			result="No bridge words from "+"\""+OriginWord1+"\""+" to "+"\""+OriginWord2+"\""+"!";
		}
		else{
			Pattern p=Pattern.compile(",");   
			String[] answers=p.split(result);
			if (answers.length==1){
				result="The bridge words from "+"\""+OriginWord1+"\""+" to "+"\""+OriginWord2+"\""+" is: "+answers[0]+".";
			}
			else{
				result="The bridge words from "+"\""+OriginWord1+"\""+" to "+"\""+OriginWord2+"\""+" are: "+answers[0];
				for(int i=1;i<answers.length;i++){
					if(i==answers.length-1){
						result=result+" and "+answers[i]+".\"";
					}
					else{
						result=result+", "+answers[i];
					}
				}
			}
		}
		return result;
	}
	public static LinkedList<String> getStrslist() {
		return strslist;
	}
	public static void setStrslist(LinkedList<String> strslist) {
		queryBridgeWords.strslist = strslist;
	}
	public static LinkedList<Node> getNodeslist() {
		return nodeslist;
	}
	public static void setNodeslist(LinkedList<Node> nodeslist) {
		queryBridgeWords.nodeslist = nodeslist;
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
