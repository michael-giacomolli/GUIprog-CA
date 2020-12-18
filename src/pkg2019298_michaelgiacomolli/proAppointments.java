
package pkg2019298_michaelgiacomolli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class proAppointments extends JFrame implements WindowListener{
    
    dashController controller;
    
    Color bg = new Color(241,106,100);
    
    
    
    public proAppointments(dashController controller){
        
        this.controller = controller;
        
        // We encapsulated the building process of the window
        attributesSetter();
        components();
        validation();
    }
    // Setting attributes
    private void attributesSetter(){
        this.setVisible(true);
        this.setSize(350, 550);
        this.setTitle("ME.barber - Appointments");
        this.addWindowListener(this);
    }
    
    // Organising components
    private void components(){
        
        //Base Layer
        BorderLayout base = new BorderLayout();
        this.setLayout(base);
        
        //BASE`S PANELS
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        
        p1.setBackground(bg);
        p2.setBackground(bg);
        p4.setBackground(bg);
        p5.setBackground(bg); 
        
        //----- p1 = TOP PANEL (title) ------------ //
        JLabel title = new JLabel("Your appointments");
        labelStyller(title);
        
        p1.add(title);
        
        //--MAIN AREA (P3 - CENTER)--//
        BoxLayout main = new BoxLayout(p3, BoxLayout.Y_AXIS);
        
        p3.setLayout(main);
        p3.setBackground(bg);
        
        
        
        //-------- p5 = BOTTOM PANEL (buttons) -------------- //
        GridLayout ld = new GridLayout(1, 3, 10, 10);
            
        JPanel buttonLine = new JPanel();
        buttonLine.setLayout(ld);
        buttonLine.setBackground(bg);
        
        JButton cancel = new JButton(" Cancel Appointment ");
        buttonStyller(cancel);
        cancel.setForeground(Color.red);
        cancel.addActionListener(controller);
        
        JButton done = new JButton(" Done ");
        buttonStyller(done);
        done.addActionListener(controller);
        
        
        JButton select = new JButton(" Confirm ");
        buttonStyller(select);
        select.setForeground(Color.green);
        select.addActionListener(controller);
        
        buttonLine.add(cancel);
        buttonLine.add(Box.createRigidArea(new Dimension(15,0)));
        buttonLine.add(select);
        buttonLine.add(Box.createRigidArea(new Dimension(15,0)));
        buttonLine.add(done);
        
        p5.add(buttonLine);
        
        // BASE FRAMES SETUP
        this.add(p1, BorderLayout.PAGE_START);
        this.add(p2, BorderLayout.LINE_START);
        this.add(p3, BorderLayout.CENTER);
        this.add(p4, BorderLayout.LINE_END);
        this.add(p5, BorderLayout.PAGE_END);
        
        
        
    }
    // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
    //Button Stylizer
    private void buttonStyller(JButton J){
        J.setForeground(bg);
        J.setBackground(Color.WHITE);
        Insets m = new Insets(5,5,5,5);
        J.setMargin(m);
        J.setFont(new Font("Arial", Font.BOLD, 14));
        J.setBorderPainted(false);
        J.setFocusPainted(false);
        J.setOpaque(true);
        J.setPreferredSize(new Dimension(100, 50));
    }
    private void labelStyller(JLabel J){
        J.setFont(new Font("Arial", Font.BOLD, 20));
        J.setForeground(Color.WHITE);
    }

     @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
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