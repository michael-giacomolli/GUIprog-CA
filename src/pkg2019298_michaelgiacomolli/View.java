
package pkg2019298_michaelgiacomolli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class View extends JFrame implements WindowListener{
    
    // Text fields must be class members so all methods can access them
    private JTextField email;
    private JPasswordField pass;
    Controller controller;
    
    Color bg = new Color(241,106,100);
    
    
    
    public View(Controller controller){
        
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
        this.setTitle("ME.barber - Login");
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
        
        //LOGO IN P1
        BufferedImage logo;
                
        try {
            logo = ImageIO.read(new File("logo.jpg"));
            ImageIcon icon = new ImageIcon(logo);
            JLabel picLabel = new JLabel(new ImageIcon(logo));
            p1.add(picLabel);
        } catch (IOException e) {
            System.out.println("Logo Image not found");
        }
        
        p1.setBackground(bg);
        p2.setBackground(bg);
        p4.setBackground(bg);
        p5.setBackground(bg); 
        
        //--MAIN AREA (P3 - CENTER)--//
        BoxLayout main = new BoxLayout(p3, BoxLayout.Y_AXIS);
        
        p3.setLayout(main);
        p3.setBackground(bg);
        
        //MAIN PANELS
        JPanel m1 = new JPanel();
        JPanel m2 = new JPanel();
        JPanel m3 = new JPanel();
        JPanel m4 = new JPanel();
        JPanel m5 = new JPanel();
        JPanel m6 = new JPanel();
        JPanel m7 = new JPanel();
        JPanel m8 = new JPanel();
        JPanel m9 = new JPanel();
        JPanel m10 = new JPanel();
        JPanel m11 = new JPanel();
        
        
        //m1 - 
        JLabel m01 = new JLabel("SIGN IN");
        m01.setFont(new Font("Verdana", Font.BOLD, 14));
        m01.setForeground(Color.WHITE);
               
        m1.add(m01);
        m1.setBackground(bg);
        
        //m0 User choice
        JLabel m00 = new JLabel("Are you a:");
        m00.setFont(new Font("Verdana", Font.BOLD, 12));
        m00.setForeground(Color.WHITE);
        
        JPanel tbut = new JPanel();
        tbut.add(m00);
        tbut.setBackground(bg);
        
        JRadioButton customer = new JRadioButton("Customer");
        customer.setBackground(bg);
        customer.setForeground(Color.white);
        customer.setFont(new Font("Arial", Font.PLAIN, 10));
        //Customer EVENT LISTENER
        customer.addActionListener(controller);
        customer.setActionCommand("customer");
        
        JRadioButton pro = new JRadioButton("Professional");
        pro.setBackground(bg);
        pro.setForeground(Color.white);
        pro.setFont(new Font("Arial", Font.PLAIN, 10));
        //pro EVENT LISTENER
        pro.addActionListener(controller);
        pro.setActionCommand("pro");
        
        JPanel but = new JPanel();
        but.add(customer);
        but.add(pro);
        but.setBackground(bg);
        
        //Group the radio buttons.
        ButtonGroup rb = new ButtonGroup();
        rb.add(customer);
        rb.add(pro);
        
        //m2 - EMAIL
        JLabel m02 = new JLabel("E-mail:");
        m02.setFont(new Font("Arial", Font.BOLD, 14));
        m02.setForeground(Color.WHITE);
        
        m2.add(m02);
        m2.setBackground(bg);
        
        //m3 - 
        email = new JTextField(45);
        email.setColumns(25);
        email.setPreferredSize(new Dimension(50,30));
                
        m3.add(email);
        m3.setBackground(bg);
        
        //m4 - PASSWORD
        JLabel m04 = new JLabel("Password:");
        m04.setFont(new Font("Arial", Font.BOLD, 14));
        m04.setForeground(Color.WHITE);
        
        m4.add(m04);
        m4.setBackground(bg);
        
        //m5 - 
        pass = new JPasswordField(30);
        pass.setColumns(25);
        pass.setPreferredSize(new Dimension(50,30));
                
        m5.add(pass);
        m5.setBackground(bg);
        
        //m6 - SIGN IN BUTTTOM
        JButton signin = new JButton("ENTER");
        m6.add(signin);
        buttonStyller(signin);
        
        signin.addActionListener(controller);
        signin.setActionCommand("signin");
                
        m6.setBackground(bg);
        
        //m7 - 
        JLabel m07 = new JLabel();
        m7.add(m07);
        m7.setBackground(bg);
        
        //m8 - 
        JSeparator line = new JSeparator();
        line.setPreferredSize(new Dimension(300,4));
        line.setBackground(Color.white);
        
        m8.add(line);
        m8.setBackground(bg);
       
        //m9 - 
        JLabel m09 = new JLabel("New User:");
        m09.setFont(new Font("Verdana", Font.BOLD, 14));
        m09.setForeground(Color.WHITE);
        
        m9.add(m09);
        m9.setBackground(bg);
        
        //m10 - 
        JButton signup = new JButton("SIGN UP");
        m10.add(signup);
        m10.setBackground(bg);
        buttonStyller(signup);
        
        signup.addActionListener(controller);
        signup.setActionCommand("signup");
        
        //m11        
        m11.add(tbut);
        m11.add(but);
        m11.setBackground(bg);
        
        
        //Adding Panels to P3
        p3.add(m1);
        p3.add(m11);
        p3.add(m2);
        p3.add(m3);
        p3.add(m4);
        p3.add(m5);
        p3.add(m6);
        p3.add(m7);
        p3.add(m8);
        p3.add(m9);
        p3.add(m10);
        
        
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
    
    // Getters 
    public String getEmail(){
        return email.getText();
    }
    public String getPassword(){
        return pass.getText();
    }
    
    //Jtexfield setters
    public void clearFields(){
        email.setText(null);
        pass.setText(null);
    }
    
    //Button Stylizer
    private void buttonStyller(JButton J){
        J.setForeground(bg);
        J.setBackground(Color.WHITE);
        Insets m = new Insets(5,5,5,5);
        J.setMargin(m);
        J.setBorderPainted(false);
        J.setFocusPainted(false);
        J.setOpaque(true);
        J.setPreferredSize(new Dimension(100, 50));
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
