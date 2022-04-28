package 五子棋;

import javax.swing.*;
import java.awt.*;

public class FiveChessUI extends JFrame implements Config{
	public void showUI() {
		this.setTitle("五子棋");
		this.setSize(800,800);
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());	
		this.setBackground(Color.WHITE);
		
		
		ChessListener drawL = new ChessListener(this,chesses, ChessList);
		//给窗体添加监听器
		this.addMouseListener(drawL);
		String name[]= {"悔棋","重新开始"};
		for(int i=0;i<name.length;i++) {
			JButton btn=new JButton(name[i]);
			this.add(btn);
			btn.addActionListener(drawL);
		}
		
		this.setVisible(true);
		Graphics g=this.getGraphics();
		drawL.setG(g);
	}
	public void drawChessTable(Graphics g) {
		for(int i=0;i<Config.ROWS;i++) {
			g.drawLine(Config.X0, Config.Y0+i*Config.SIZE, Config.X0+(Config.COLUMNS-1)*Config.SIZE, Config.Y0+i*Config.SIZE);
		}
		for(int j=0;j<Config.COLUMNS;j++) {
			g.drawLine(Config.X0+j*Config.SIZE, Config.Y0, Config.X0+j*Config.SIZE, Config.Y0+(Config.ROWS-1)*Config.SIZE);
		}
	}
	public void paint(Graphics g) {
		super.paint(g);
		drawChessTable(g);
		drawchess(g);
	}
	public void drawchess(Graphics g) {
		for(int j=0;j<Config.ROWS;j++) {
			for(int i=0;i<Config.COLUMNS;i++) {
				int x=50+i*50;
				int y=60+j*50;
				if(chesses[i][j]==1) {
					g.setColor(Color.BLACK);
					g.fillOval(x-Config.CHESS_SIZE/2, y-Config.CHESS_SIZE/2, Config.CHESS_SIZE, Config.CHESS_SIZE);
				}
				else if(chesses[i][j]==-1){
					g.setColor(Color.white);
					g.fillOval(x-Config.CHESS_SIZE/2, y-Config.CHESS_SIZE/2, Config.CHESS_SIZE, Config.CHESS_SIZE);
				}
				}
			}
		}
	public static void main(String args[]) {
		FiveChessUI sd=new FiveChessUI();
		sd.showUI();
	}
		
}