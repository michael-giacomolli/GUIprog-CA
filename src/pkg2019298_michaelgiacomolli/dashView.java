
package pkg2019298_michaelgiacomolli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class dashView extends JFrame implements WindowListener{
    
    dashController controller;
    
    Color bg = new Color(241,106,100);
    
    public dashView(dashController controller, String u){
        
        this.controller = controller;
        
        //CUSTOMER DASHBOARD///////////////////////////////////////////////////////////////////////////////////////
        if(u.equalsIgnoreCase("customer")){
            this.setVisible(true);
            this.setSize(400, 500);
            this.setTitle("ME.barber");
            this.addWindowListener(this);


            //BASE LAYER
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
            } catch (IOException ex) {
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

            //SEARCH BAR - GRID LAYOUT
            GridLayout y = new GridLayout(0,2);
            JPanel a1 = new JPanel();
            a1.setLayout(y);
            a1.setBackground(bg);
            a1.setPreferredSize(new Dimension(100, 20));

            //a1`s components
                //search textfield
            JTextField search = new JTextField(30);
            textFStyller(search);
            search.setPreferredSize(new Dimension(100, 20));
            //search button
            JButton srch = new JButton("Search");
            srch.setForeground(bg);
            srch.setBackground(Color.WHITE);
            srch.setBorderPainted(false);
            srch.setFocusPainted(false);
            srch.setOpaque(true);
            srch.setPreferredSize(new Dimension(30, 20));
            //SEARCH LISTENER
            srch.addActionListener(controller);
            srch.setActionCommand("search");
            //search radio buttons
            JRadioButton bName = new JRadioButton("by name");
            bName.setBackground(bg);
            bName.setForeground(Color.white);
            bName.setFont(new Font("Arial", Font.PLAIN, 12));

            JRadioButton bAddress = new JRadioButton("by address");
            bAddress.setBackground(bg);
            bAddress.setForeground(Color.white);
            bAddress.setFont(new Font("Arial", Font.PLAIN, 12));
            
            //radio buttons listeners
            bName.addActionListener(controller);
            bName.setActionCommand("search name");
            
            bAddress.addActionListener(controller);
            bAddress.setActionCommand("search address");
            
            JPanel but = new JPanel();
            but.add(bName);
            but.add(bAddress);
            but.setBackground(bg);

            //Group the radio buttons.
            ButtonGroup rb = new ButtonGroup();
            rb.add(bName);
            rb.add(bAddress);

            a1.add(search);
            a1.add(srch);
            a1.add(but);
            //--------------------End a1--------------------
            p3.add(a1);
            //OTHER BUTTONS - FLOWLAYOUT

            JPanel a2 = new JPanel();

            FlowLayout b = new FlowLayout(FlowLayout.CENTER, 1, 3);
            a2.setLayout(b);
            a2.setBackground(bg);
            //BOOKING BUTTON
            JButton booking = new JButton("View Booking");
            buttonStyller(booking);
            //BOOKING LISTENER
            booking.addActionListener(controller);
            booking.setActionCommand("booking");
            //FEEDBACK BUTTONS
            JButton feedback = new JButton("Feedback");
            buttonStyller(feedback);
            //FEEDBACK LISTENER
            feedback.addActionListener(controller);
            feedback.setActionCommand("feedback");

            a2.add(booking);
            a2.add(Box.createRigidArea(new Dimension(15,0)));
            a2.add(feedback);
            p3.add(a2);

            //p5 - Log out Button
            JButton logout = new JButton("LOG OUT");
            p5.add(logout);
            buttonStyller(logout);
            //log out LISTENER
            logout.addActionListener(controller);
            logout.setActionCommand("logout");


            this.add(p1, BorderLayout.PAGE_START);
            this.add(p2, BorderLayout.LINE_START);
            this.add(p3, BorderLayout.CENTER);
            this.add(p4, BorderLayout.LINE_END);
            this.add(p5, BorderLayout.PAGE_END);

            this.validate();
            this.repaint();
        }
        //PROFESSIONAL`S DASHBOARD /////////////////////////////////////////////////////////////////
        if(u.equalsIgnoreCase("pro")){
            this.setVisible(true);
            this.setSize(300, 400);
            this.setTitle("ME.barber - Login");
            this.addWindowListener(this);


            //BASE LAYER
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
            } catch (IOException ex) {
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

            //APPOINTMENT BUTTON
            JButton events = new JButton("My Appointments");
            buttonStyller(events);
            //APPOINTMENT LISTENER
            events.addActionListener(controller);
            events.setActionCommand("events");
            
            //SET TIME BUTTON
            JButton setA = new JButton("Set Availability");
            buttonStyller(setA);
            //SET TIME LISTENER
            setA.addActionListener(controller);
            setA.setActionCommand("set time");
            
            p3.add(Box.createRigidArea(new Dimension(0,10)));
            p3.add(events);
            p3.add(Box.createRigidArea(new Dimension(0,10)));
            p3.add(setA);
            p3.add(Box.createRigidArea(new Dimension(0,15)));
            
            events.setAlignmentX(JPanel.CENTER_ALIGNMENT);
            setA.setAlignmentX(JPanel.CENTER_ALIGNMENT);
            

            //p5 - Log out Button
            JButton logout = new JButton("LOG OUT");
            p5.add(logout);
            buttonStyller(logout);
            //LOGOUT LISTENER
            logout.addActionListener(controller);
            logout.setActionCommand("logout");



            this.add(p1, BorderLayout.PAGE_START);
            this.add(p2, BorderLayout.LINE_START);
            this.add(p3, BorderLayout.CENTER);
            this.add(p4, BorderLayout.LINE_END);
            this.add(p5, BorderLayout.PAGE_END);

            this.validate();
            this.repaint();        
        }
    }
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
    private void textFStyller(JTextField J){
        J.setFont(new Font("Arial", Font.PLAIN, 18));
        J.setForeground(bg);
        J.setHorizontalAlignment(SwingConstants.LEFT);
        J.setColumns(25);
    
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
        new Controller();
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
        
    

