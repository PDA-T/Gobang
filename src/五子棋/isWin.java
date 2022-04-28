package 五子棋;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class isWin  implements Config{
	private JFrame frame;  
    private int x,y;  
    private int count;  
    private Color c;
    String cc;
	public isWin(int x,int y,Color c) {
		this.x = x;  
        this.y = y;  
        this.c = c;
        count = 1;  
        frame = new JFrame();  
        frame.setTitle("结果");  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        frame.setSize(200,100);  
        frame.setLayout(new FlowLayout());  
	}
	
	public void iswin() {
		if(c==Color.BLACK)
			cc="黑棋";
		else if(c==Color.WHITE)
			cc="白棋";
		count=0;
		for(int i=x+1;i<chesses.length;i++) {//右寻找
			if(chesses[i][y]==chesses[x][y]) {
				count++;
			System.out.println(count);}
			else
				break;
		}
		for(int i=x;i>=0;i--) {//左寻找
			if(chesses[i][y]==chesses[x][y])
				count++;
			else
				break;
		}
		if(count==6) {
			System.out.println("横向游戏结束！"); 
			JLabel textLabel = new JLabel("恭喜"+cc+"赢啦");
			//添加标签到窗体上
			frame.add(textLabel);
			frame.setVisible(true);  
			count=0;
		}
		for(int i=y+1;i<chesses.length;i++) {//下寻找
			if(chesses[x][i]==chesses[x][y])
				count++;
			else
				break;
		}
		for(int i=y;i>=0;i--) {//上寻找
			if(chesses[x][i]==chesses[x][y])
				count++;
			else
				break;
		}
		if(count==6) {
			System.out.println("纵向游戏结束！");
			System.out.println("恭喜"+cc+"赢啦");
			JLabel textLabel = new JLabel("恭喜"+cc+"赢啦");
			//添加标签到窗体上
			frame.add(textLabel);
			frame.setVisible(true);  
			count=0;
		}
		for(int i=x+1,j=y+1;j<=chesses.length&&i<=chesses.length;i++,j++){//右下寻找  
            if(chesses[i][j]==chesses[x][y]){  
                count++;  
            }else  
                break;  
        }  
        for(int i=x-1,j=y-1;i>=0&&j>=0;i--,j--){//左上寻找  
        	 if(chesses[i][j]==chesses[x][y]){  
                 count++;  
             }else  
                 break;  
        }  
        if(count==6) {
			System.out.println("西北游戏结束！");
			System.out.println("恭喜"+cc+"赢啦");
			JLabel textLabel = new JLabel("恭喜"+cc+"赢啦");
			//添加标签到窗体上
			frame.add(textLabel);
			frame.setVisible(true);   
            count=0;
		}
        for(int i=x+1,j=y-1;j>=0&&i<=chesses.length;i++,j--){//右上寻找  
            if(chesses[i][j]==chesses[x][y]){  
                count++;  
            }else  
                break;  
        }  
        for(int i=x-1,j=y+1;i>=0&&j<=chesses.length;i--,j++){//左下寻找  
        	 if(chesses[i][j]==chesses[x][y]){  
                 count++;  
             }else  
                 break;  
        }  
        if(count==6) {
			System.out.println("西南游戏结束！");
			System.out.println("恭喜"+cc+"赢啦");
			JLabel textLabel = new JLabel("恭喜"+cc+"赢啦");
			//添加标签到窗体上
			frame.add(textLabel);
			frame.setVisible(true);   
            count=0;
		}
        
	}
}