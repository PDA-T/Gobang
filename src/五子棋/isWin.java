package ������;

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
        frame.setTitle("���");  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        frame.setSize(200,100);  
        frame.setLayout(new FlowLayout());  
	}
	
	public void iswin() {
		if(c==Color.BLACK)
			cc="����";
		else if(c==Color.WHITE)
			cc="����";
		count=0;
		for(int i=x+1;i<chesses.length;i++) {//��Ѱ��
			if(chesses[i][y]==chesses[x][y]) {
				count++;
			System.out.println(count);}
			else
				break;
		}
		for(int i=x;i>=0;i--) {//��Ѱ��
			if(chesses[i][y]==chesses[x][y])
				count++;
			else
				break;
		}
		if(count==6) {
			System.out.println("������Ϸ������"); 
			JLabel textLabel = new JLabel("��ϲ"+cc+"Ӯ��");
			//��ӱ�ǩ��������
			frame.add(textLabel);
			frame.setVisible(true);  
			count=0;
		}
		for(int i=y+1;i<chesses.length;i++) {//��Ѱ��
			if(chesses[x][i]==chesses[x][y])
				count++;
			else
				break;
		}
		for(int i=y;i>=0;i--) {//��Ѱ��
			if(chesses[x][i]==chesses[x][y])
				count++;
			else
				break;
		}
		if(count==6) {
			System.out.println("������Ϸ������");
			System.out.println("��ϲ"+cc+"Ӯ��");
			JLabel textLabel = new JLabel("��ϲ"+cc+"Ӯ��");
			//��ӱ�ǩ��������
			frame.add(textLabel);
			frame.setVisible(true);  
			count=0;
		}
		for(int i=x+1,j=y+1;j<=chesses.length&&i<=chesses.length;i++,j++){//����Ѱ��  
            if(chesses[i][j]==chesses[x][y]){  
                count++;  
            }else  
                break;  
        }  
        for(int i=x-1,j=y-1;i>=0&&j>=0;i--,j--){//����Ѱ��  
        	 if(chesses[i][j]==chesses[x][y]){  
                 count++;  
             }else  
                 break;  
        }  
        if(count==6) {
			System.out.println("������Ϸ������");
			System.out.println("��ϲ"+cc+"Ӯ��");
			JLabel textLabel = new JLabel("��ϲ"+cc+"Ӯ��");
			//��ӱ�ǩ��������
			frame.add(textLabel);
			frame.setVisible(true);   
            count=0;
		}
        for(int i=x+1,j=y-1;j>=0&&i<=chesses.length;i++,j--){//����Ѱ��  
            if(chesses[i][j]==chesses[x][y]){  
                count++;  
            }else  
                break;  
        }  
        for(int i=x-1,j=y+1;i>=0&&j<=chesses.length;i--,j++){//����Ѱ��  
        	 if(chesses[i][j]==chesses[x][y]){  
                 count++;  
             }else  
                 break;  
        }  
        if(count==6) {
			System.out.println("������Ϸ������");
			System.out.println("��ϲ"+cc+"Ӯ��");
			JLabel textLabel = new JLabel("��ϲ"+cc+"Ӯ��");
			//��ӱ�ǩ��������
			frame.add(textLabel);
			frame.setVisible(true);   
            count=0;
		}
        
	}
}