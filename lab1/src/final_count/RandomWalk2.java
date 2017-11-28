package final_count;

import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

public class RandomWalk2 {
	private static LinkedList<String> strslist=new LinkedList<String>();
    private static LinkedList<Node> nodeslist=new LinkedList<Node>();
    private static String InfofGraph="";
    private static String BridgeWords="";
    private static String FilePath="";
    private static String RandomPath="";
    private static String ValidInf="";
    public static String randomWalk(){
    	String result="";
    	RandomPath="";
    	Vector<Integer> Isvisited[]=new Vector[nodeslist.size()];
    	int max=nodeslist.size()-1;
        int min=0;
        long t1=System.currentTimeMillis();
        Random random1=new Random(t1);
        int RandomNode1Index=0;
        for(int i=0;i<nodeslist.size();i++){
        	Isvisited[i]=new Vector();
        }
        if(max-min+1>0)
        	RandomNode1Index=random1.nextInt(max-min+1)+min;
        //else
        	//RandomNode1Index=min;
        if(RandomNode1Index<strslist.size()){
        	 result+=strslist.get(RandomNode1Index)+" ";
        	 RandomPath+=strslist.get(RandomNode1Index)+" ";
        }
        //System.out.println(result);
        while(true){
        	Edge e=null;
        	if(RandomNode1Index<strslist.size()){
           	 e=nodeslist.get(RandomNode1Index).GetAdj();
            }
            if(e==null){
            	return result;
            }
            else{
                max=nodeslist.get(RandomNode1Index).GetNumOfEdge();
            	min=0;
            	int flag=0;
            	while(flag==0){
            		try   
            		{   
            		    Thread.currentThread().sleep(1000);//ºÁÃë   
            		}   
            		catch(Exception e2){
            			JOptionPane.showMessageDialog(null,"Thread Error!");
            		}  
            		long t2=System.currentTimeMillis();
                	Random random2=new Random(t2);
                	int index=random2.nextInt(max-min+1)+min;
                	for(int i=0;i<index-1;i++){
                		e=e.GetAdj();
                	}
                	int RandomNode2Index=0;
					if(e!=null&&e.GetTail()!=null&&e.GetTail()!="")
                	   RandomNode2Index=strslist.indexOf(e.GetTail());
					result=result+strslist.get(RandomNode2Index)+" ";
            		RandomPath=RandomPath+strslist.get(RandomNode2Index)+" ";
                	if(Isvisited[RandomNode1Index].indexOf(RandomNode2Index)==-1){
                		Isvisited[RandomNode1Index].addElement(RandomNode2Index);
                		RandomNode1Index=RandomNode2Index;
                		//System.out.println(strslist.get(RandomNode1Index));
                		flag=1;
                		break; 
                	}
                	else{
                		return result;
                	}
            	}
            }
        }
    }
	public static LinkedList<String> getStrslist() {
		return strslist;
	}
	public static void setStrslist(LinkedList<String> strslist) {
		RandomWalk2.strslist = strslist;
	}
	public static LinkedList<Node> getNodeslist() {
		return nodeslist;
	}
	public static void setNodeslist(LinkedList<Node> nodeslist) {
		RandomWalk2.nodeslist = nodeslist;
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
