package 五子棋;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

public class quanzhi implements Config{
	public HashMap<String,Integer> map = new HashMap<>();
    public int[][] weightArr=new int[14][14];
    public int p=0,q=0;
    
	public Point zifu(int x,int y,Color color,Graphics g,int index) {
		
		map.put("0",0);
		map.put("0-1",10);
		map.put("0-1-1",30);
		map.put("0-1-1-1",100);
		map.put("0-1-1-1-1",1000);
		map.put("01",5);
		map.put("011",15);
		map.put("0111",300);
		map.put("01111",500);
		//map放置数据要在前面
		for(int i=0;i<13;i++) {
	    	for(int j=0;j<13;j++)
	    		weightArr[i][j]=0;
	    }
	for(int m=0;m<14;m++){
		for(int n=0;n<14;n++) {
			//找空位
			if(chesses[m][n]==0) {
			//起始位为0向左判断
				String str1="0";
				int i=m,j=n;
				if(i>=0) {
					while(i>=0&&chesses[i][j]==1) {
						str1+=1;
						i--;
						System.out.println(i);
					}
					weightArr[m][n]=map.get(str1);
				}
				i=m-1;
				if(i>=0) {
					while(i>=0&&chesses[i][j]==-1) {
						str1+=-1;
						i--;
					}
					weightArr[m][n]=map.get(str1);
				}
					
				//向右判断
				 str1 = "0";
                 i = m+1;
                 j = n;
                 if(i<=chesses.length) {
                     while (i < chesses.length && chesses[i][j] == 1) {
                         str1 += "1";
                         i++;
                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 i=m+1;
                 str1="0";
                 if(i<=chesses.length) {
                     while (i < chesses.length && chesses[i][j] == -1) {
                         str1 += "-1";
                         i++;
                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                
                 
                 //向下判断
                 str1 = "0";
                 i = m;
                 j = n+1;
                 if(j<chesses.length) {
                     while (j < chesses.length && chesses[i][j] == 1) {
                         str1 += "1";
                         j++;
                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 j=n+1;
                 str1="0";
                 if(j<chesses.length) {
                     while (j < chesses.length && chesses[i][j] == -1) {
                         str1 += "-1";
                         j++;

                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 
                 
                 //向上判断
                 str1 = "0";
                 j = n-1;
                 if(j>=0) {
                     while (j >=0 && chesses[i][j] == 1) {
                         str1 += "1";
                         j--;
                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 j=n-1;
                 str1="0";
                 if(j>=0) {
                     while (j >=0 && chesses[i][j] == -1) {
                         str1 += "-1";
                         j--;

                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 
                 //向左上判断
                 str1 = "0";
                 i = m-1;
                 j = n-1;
                 if(j>=0&&i>=0) {
                     while (j >=0 && i>=0 && chesses[i][j] == 1) {
                         str1 += "1";
                         j--;
                         i--;
                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 i=m-1;
                 j=n-1;
                 str1="0";
                 if(j>=0&&i>=0) {
                     while (j >=0&& i>=0 && chesses[i][j] == -1) {
                         str1 += "-1";
                         i--;
                         j--;

                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 //向右下方向判断
                 str1 = "0";
                 i = m+1;
                 j = n+1;
                 if(j<chesses.length&&i<chesses.length) {
                     while (j <chesses.length && i<chesses.length && chesses[i][j] == 1) {
                         str1 += "1";
                         j++;
                         i++;
                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 i=m+1;
                 j=n+1;
                 str1="0";
                 if(j<chesses.length&&i<chesses.length) {
                     while (j <chesses.length && i<chesses.length && chesses[i][j] == -1) {
                         str1 += "-1";
                         j++;
                         i++;
                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 
                 
                 //向左下方向判断
                 str1 = "0";
                 i = m-1;
                 j = n+1;
                 if(j<chesses.length&&i>=0) {
                     while (j <chesses.length && i>=0 && chesses[i][j] == 1) {
                         str1 += "1";
                         j++;
                         i--;
                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 i=m-1;
                 j=n+1;
                 str1="0";
                 if(j<chesses.length&&i>=0) {
                     while (j <chesses.length && i>=0 && chesses[i][j] == -1) {
                         str1 += "-1";
                         j++;
                         i--;
                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 
                 
                 //向右上方向判断
                 str1 = "0";
                 i = m+1;
                 j = n-1;
                 if(i<chesses.length&&j>=0) {
                     while (i <chesses.length && j>=0 && chesses[i][j] == 1) {
                         str1 += "1";
                         i++;
                         j--;
                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
                 str1 = "0";
                 i = m+1;
                 j = n-1;
                 if(i<chesses.length&&j>=0) {
                     while (i <chesses.length && j>=0 && chesses[i][j] == -1) {
                         str1 += "-1";
                         i++;
                         j--;
                     }
                     weightArr[m][n] = map.get(str1)+weightArr[m][n];
                 }
			}
		}
	}
	int temp=weightArr[0][0];
	for(int i=0;i<weightArr.length;i++) {
		for(int j=0;j<weightArr.length;j++) {
			if(weightArr[i][j]>temp) {
				temp=weightArr[i][j];
				p=i;q=j;
			}
		}
	}
	Point ch=new Point(p,q,Color.white);  
	 ChessList[index++]=ch;
	 return ch;
	}
}
