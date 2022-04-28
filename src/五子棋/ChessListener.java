package 五子棋;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class ChessListener extends MouseAdapter implements ActionListener,MouseListener{
	private Graphics g;
	private int count=0;
	Color c;
	int x,y;
	int index=0;
	public int[][] chesses;
	public Point[] ChessList;
	JFrame jf=new JFrame();
	String type;
	public ChessListener(JFrame jf,int[][] chesses,Point[] ChessList){
		//this.g=g;
		this.jf=jf;
		this.chesses=chesses;
		this.ChessList=ChessList;
	}
	public void setG(Graphics arg) {
		g=arg;
	}
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();// 默认取自符
		type=action;
		if("悔棋".equals(type)) {  
			if(index!=0) {
	        x=ChessList[index-1].getX();  
	        y=ChessList[index-1].getY();  
	        x=(x-50)/50;y=(y-60)/50;
	        ChessList[index-1]=null;
	        chesses[x][y]=0;
	        jf.repaint();
	        index--;
	        if(index%2==0)
	        	count=0;
	        else
	        	count=1;
			}
		}
		if("重新开始".equals(type)) {
			for(int i=0;i<index;i++) {
				ChessList[i]=null;
			}
			for(int i=0;i<14;i++) {
				for(int j=0;j<14;j++)
				chesses[i][j]=0;
			}
			index=0; 
			jf.repaint();
			count=0;
		}
		
	}
	public void mouseReleased(MouseEvent e) {
		int x1=e.getX();
		int y1=e.getY();
		for(int j=0;j<Config.ROWS;j++) {
			for(int i=0;i<Config.COLUMNS;i++) {
				 int x=Config.X0+Config.SIZE*i;
				 int y=Config.Y0+Config.SIZE*j;
				if(x1>x-Config.SIZE/3&&x1<x+Config.SIZE/3&&y1>y-Config.SIZE/3&&y1<y+Config.SIZE/3) {
					if(chesses[i][j]==0) {
						if(count==0) {
							chesses[i][j]=1;//黑子为1
							c=Color.black;
							g.setColor(Color.black);
							count++;
						}
						else {
							chesses[i][j]=-1;
							c=Color.WHITE;
							g.setColor(Color.WHITE);
							count--;
						}
						g.fillOval(x-Config.CHESS_SIZE/2, y-Config.CHESS_SIZE/2, Config.CHESS_SIZE, Config.CHESS_SIZE);
						Point ch=new Point(x,y,c);  
				        ChessList[index++]=ch;
						isWin kk = new isWin(i,j,c);
						kk.iswin();  
					}
				}
			}
		}
	}
	public void mouseClicked(MouseEvent e) {
	}
}