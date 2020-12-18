
package pkg2019298_michaelgiacomolli;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;


public class signup extends JFrame implements ActionListener, WindowListener{
    
    Color bg = new Color(241,106,100);
        
    public signup(){
        
        this.setVisible(true);
        this.setSize(350, 200);
        this.setTitle("ME.barber - SIGN UP");
        this.addWindowListener(this);
                
        
        //BASE LAYER
        JPanel panel = new JPanel();
        FlowLayout base = new FlowLayout(FlowLayout.CENTER, 4, 1);
        panel.setLayout(base);
        
        EmptyBorder k = new EmptyBorder(10,10,10,10);
                      
        //p1
        JLabel a = new JLabel("Are you:");
        panel.add(a);
        a.setPreferredSize(new Dimension(300,30));
        a.setBorder(k);
        
        a.setFont(new Font("Verdana", Font.BOLD, 14));
        a.setForeground(Color.WHITE);
        
        a.setAlignmentX(CENTER_ALIGNMENT);
        a.setAlignmentY(CENTER_ALIGNMENT);
        
        panel.setBackground(bg);
        
        //p2
        JButton client = new JButton("CUSTOMER");
        panel.add(client);
        buttonStyller(client);
        
        client.addActionListener(this);
        client.setActionCommand("cust");
        
        client.setAlignmentX(CENTER_ALIGNMENT);
        client.setAlignmentY(CENTER_ALIGNMENT);
        
        JLabel s1 = new JLabel("");
        
        //p3
        JSeparator line = new JSeparator();
        line.setPreferredSize(new Dimension(300,4));
        line.setBackground(Color.white);
        
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(line);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        //p4
        JButton pro = new JButton("PROFESSIONAL");
        panel.add(pro);
        buttonStyller(pro);
        
        pro.addActionListener(this);
        pro.setActionCommand("prof");
        
        pro.setAlignmentX(CENTER_ALIGNMENT);
        pro.setAlignmentY(CENTER_ALIGNMENT);
        
        this.add(panel);
        
        this.validate();
        this.repaint();
    
    
}

    private void buttonStyller(JButton J){
        J.setForeground(bg);
        J.setBackground(Color.WHITE);
        Insets m = new Insets(5,5,5,5);
        J.setMargin(m);
        J.setBorderPainted(false);
        J.setFocusPainted(false);
        J.setOpaque(true);
        J.setPreferredSize(new Dimension(150, 50));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         // signup() action commands
        if(e.getActionCommand().equals("cust")){
            String u = "customer";
            new FormController(u);
            this.dispose();
        }
        if(e.getActionCommand().equals("prof")){
            String u = "pro";
            new FormController(u);
            this.dispose();
            
            
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}
