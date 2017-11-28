package final_count;

import java.util.LinkedList;
import java.util.Vector;

public class calcShortestPath {
	private static LinkedList<String> strslist=new LinkedList<String>();
    private static LinkedList<Node> nodeslist=new LinkedList<Node>();
    private static String InfofGraph="";
    private static String BridgeWords="";
    private static String FilePath="";
    private static String RandomPath="";
    private static String ValidInf="";
    public static String calcShortestPath(String word1,String word2){
		int sta[]=new int[strslist.size()];
		Path res=new Path();
		Vector<Integer> prev[]=new Vector[strslist.size()];
		int index1=strslist.indexOf(word1);
		int index2=strslist.indexOf(word2);
		prev=Dijkstra(nodeslist.size(),index1,index2);
		SearchPath(res,prev,index1,index2,0,sta);
		return res.GetPath();
	}
	public static Vector<Integer>[] Dijkstra(int n,int index1,int index2){
		int visited[]=new int[n];
		int index=0;
		int i,j;
		int dist[]=new int[n];
		int DirectDis[][]=new int[n][n];
		Vector<Integer> prev[]=new Vector[n];
		for(i=0;i<n;i++){
			dist[i]=999;
			visited[i]=0;
			for(j=0;j<n;j++){
				DirectDis[i][j]=999;
			}
		}
		for(index=0;index<nodeslist.size();index++) {
	    	Edge edge=nodeslist.get(index).GetAdj();
	    	while(edge!=null){
	    		if(edge!=null){
	    			DirectDis[strslist.indexOf(edge.GetHead())][strslist.indexOf(edge.GetTail())]=edge.GetWeight();
	    			edge=edge.GetAdj();
	    		}
	    	}
	    }
		for(i=0;i<n;i++){
			if(i!=index1){
				dist[i]=DirectDis[index1][i];
				visited[i]=0;
			}
			else{
				visited[i]=1;
			    dist[i]=0;
			}
			prev[i]=new Vector();
			if(dist[i]<999){
				prev[i].addElement(index1);
			}
		}
		for(i=1;i<n;i++){
			int temp=999;
			int NodeNum=index1;
			for(j=0;j<n;j++){
				if(visited[j]==0 && dist[j]<temp){
					NodeNum=j;
					temp=dist[j];
				}	
			}
			visited[NodeNum]=1;
			for(j=0;j<n;j++){
				if(visited[j]==0 && DirectDis[NodeNum][j]<999){
				   int NewDist=dist[NodeNum]+DirectDis[NodeNum][j];
				   if(NewDist<=dist[j]){
					   if(NewDist<dist[j]){
						   prev[j].removeAllElements();
						   dist[j]=NewDist;
					   }
					   prev[j].addElement(NodeNum);
				   }
			}
		}
		}
		return prev;
	}
    public static void SearchPath(Path res,Vector<Integer>[] prev,int start,int end,int len,int sta[]){
    	if(start==end){
    		if(start>=0){
    			res.SetPath(strslist.get(start));	
    		}
    		return;
        }
    	sta[len]=end;
    	for(int i=0;i<prev[end].size();i++){
    		if(i>0){
    			for(int j=len-1;j>=0;j--){
    				res.SetPath("->"+strslist.get(sta[j]));	
    			}
    			res.SetPath(",");
    		}
    		SearchPath(res,prev,start,prev[end].elementAt(i),len+1,sta);
    		res.SetPath("->"+strslist.get(end));		
    	}
    }
	public static LinkedList<String> getStrslist() {
		return strslist;
	}
	public static void setStrslist(LinkedList<String> strslist) {
		calcShortestPath.strslist = strslist;
	}
	public static LinkedList<Node> getNodeslist() {
		return nodeslist;
	}
	public static void setNodeslist(LinkedList<Node> nodeslist) {
		calcShortestPath.nodeslist = nodeslist;
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
