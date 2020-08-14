/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake2;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;
/**
 *
 * @author Bhaskar Sengupta
 */
public abstract class Snake2 implements ActionListener,KeyListener
{

    /**
     * @param args the command line arguments
     */
    static MyPanel p;static int x=1;
    static int size=3,sum=10;static JTextField tf,tf1;
    public static void main(String[] args) {
        // TODO code application logic here
   MyFrame frame=new  MyFrame();
         frame.setBounds(600,100,500,610);
         frame.setVisible(true);
         frame.setResizable(true);
         frame.setTitle("Snake Game");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         p=new MyPanel();
         p.setBackground(Color.WHITE);
         frame.add(p);
         p.setLayout(null);
        Snake2 s=new Snake2() {
       @Override
       public void keyTyped(KeyEvent e) {
           if(e.getKeyChar()==e.VK_DOWN){
           p.repaint();
               System.out.println("str");
           //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }}

       @Override
       public void keyPressed(KeyEvent e) {
           //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void keyReleased(KeyEvent e) {
           //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }
   };
        s.buttons(p);
        p.size_1(3);
        p.length();
        //size=p.size(1)-1;
        //for(int i=1;i<5;i++)
        p.apple();
       move(300);
       //p.apple();
    }
    public void  buttons(JPanel p)
     {Font f=new Font("Times New Roman",Font.BOLD,30);
         JLabel l=new JLabel("POINTS");
         tf=new JTextField("0");
         l.setBounds(10,480,100,20);
         tf.setBounds(10,500,100,20);
         l.setForeground(Color.RED);
         p.add(l);p.add(tf);
         JLabel l1=new JLabel("SIZE OF SNAKE");
         tf1=new JTextField("3");
         l1.setBounds(370,480,100,20);
         tf1.setBounds(370,500,100,20);
          p.add(l1);p.add(tf1);l1.setForeground(Color.RED);
         JButton left=new  JButton("A");
         left.setBounds(10,530,150,30);
         left.setBackground(Color.BLACK);
         p.add(left);
         left.addActionListener(this);
         JButton bottom=new  JButton("S");
         bottom.setBounds(170,530,150,30);
         bottom.setBackground(Color.BLACK);
         p.add(bottom);
         bottom.addActionListener(this);
         JButton up=new  JButton("W");
         up.setBounds(170,480,150,30);
         up.setBackground(Color.BLACK);
         p.add(up);
         up.addActionListener(this);
         JButton right=new  JButton("D");
         right.setBounds(330,530,150,30);
         right.setBackground(Color.BLACK);
         p.add(right);
         right.addActionListener(this);
         left.setFont(f);left.setForeground(Color.WHITE);
         right.setFont(f);right.setForeground(Color.WHITE);
          up.setFont(f);up.setForeground(Color.WHITE);
         bottom.setFont(f);bottom.setForeground(Color.WHITE);
         tf.addKeyListener(this);
      }
public static  void move(int speed)
      { try{
              while(true){
              if(p.end()==true)
              {break;
                }
               else
                {
                if(p.eat()==true){
                p.size_1(++size);p.new_length();
                System.out.println("doen" );
                tf1.setText(""+Integer.toString(size));
                tf.setText(""+Integer.toString(sum));
                p.apple();
                sum+=10;
                }
                else
                if(x==1)
                { 
                 p.direction(1);
                 TimeUnit.MILLISECONDS.sleep(speed); 
            }
            if(x==2){
                p.direction2();
                TimeUnit.MILLISECONDS.sleep(speed);  
            }
             if(x==3){
                p.direction1();
                TimeUnit.MILLISECONDS.sleep(speed);  
            }
             if(x==4){
                p.direction3();
                TimeUnit.MILLISECONDS.sleep(speed);  
            }
            
           }}}catch(Exception e){}
      }
     public void actionPerformed(ActionEvent e)
          {String com=e.getActionCommand();
             if(com.charAt(0)=='W')
             {
               x=1;
            }else
               if(com.charAt(0)=='S')
             {
             
               x=3;
            }else
               if(com.charAt(0)=='D')
             {
             
              x=2;
            }else
               if(com.charAt(0)=='A')
             {
              
              x=4;
             }
}
     public void KeyPressed(keyEvent ev)
     {
         
     }
}
class MyFrame extends JFrame
{  
}
     class MyPanel extends JPanel 
     {
         static int i,y=5,l=30,x=1,n,x1=0,y1=0,initial=0,num=n;
         static int counter=1,z=15,x_axis,y_axis; 
         JPanel jp=new JPanel();
         static int a[],b[];//up
        public  void direction(int x){
        
        x1=a[n-1];//head
        y1=b[n-1];
            for(i=0;i<n-1;i++)
        {
            a[i]=a[i+1];
            b[i]=b[i+1];
        }
        b[n-1]=y1-10;a[n-1]=x1;
        repaint();
    } 
       ///down
        public  void direction1()
        {
        x1=a[n-1];
        y1=b[n-1];
        
        for(i=0;i<n-1;i++)
        {
            a[i]=a[i+1];
            b[i]=b[i+1];
        }
         b[n-1]=y1+10;a[n-1]=x1;
    
        repaint(); 
       }
       //right
       public  void direction2(){
        y1=b[n-1];
        x1=a[n-1];
        
        for(i=0;i<n-1;i++)
        {   a[i]=a[i+1];
            b[i]=b[i+1];
        }
        a[n-1]=x1+10;b[n-1]=y1;
        repaint();
         
       }
       //left
        public  void direction3(){
        y1=b[n-1];
        x1=a[n-1];
        
        for(i=0;i<n-1;i++)
        {   a[i]=a[i+1];
            b[i]=b[i+1];
        }
        a[n-1]=x1-10;b[n-1]=y1;
        repaint();
        
       }
         public  static void size_1(int x_size)
         {
             n=x_size;
             
         }
        public static void length()
        {a=new int[500];b=new int[500];
         for(i=initial;i<n;i++,y+=5)
         {a[i]=(l+(10*i));//+y);
          b[i]=220;
         }
        }
        public static void new_length()
        {
        
          a[n-1]=x_axis;
          b[n-1]=y_axis;
         }
        
         public static boolean end()
        {y1=b[n-1];
        x1=a[n-1];
         if((x1>455 || x1<20 || y1>430 || y1<25))
          return true;  
          else
          return false;
        }
        public static boolean eat()//eat  
        {y1=b[n-1];int y2=b[0];
         x1=a[n-1];int x2=a[0];
            
            if((y1)==y_axis && (x1==x_axis))
            return true;
            else
            return false;
        }
        public static void random_gen()
        { int max1=425,min1=30;
          int max2=405,min2=35;
          x_axis=(int)((int)(Math.random()*max1+min1)/10)*10;
          y_axis=(int)((int)(Math.random()*max2+min2)/10)*10;
       
        }
        public void apple()
        {
            random_gen();
        }
        public void paint(Graphics g)
         {  
             y=5;
             super.paint(g);
             //g.fill
             g.setColor(Color.DARK_GRAY);
             g.fillRect(0,451,490,10);
            
             g.fillRect(0,0,10,480);
              
             g.fillRect(0,0,480,10);
             
             g.fillRect(474,0,10,480);
             for(i=initial;i<n;i++,y+=5){
             g.setColor(Color.YELLOW);
             g.fillRect(a[i],b[i],10,10);}
            
            g.setColor(Color.RED);
            g.fillRect(x_axis,y_axis,10,10);
            }
        }
    
    
