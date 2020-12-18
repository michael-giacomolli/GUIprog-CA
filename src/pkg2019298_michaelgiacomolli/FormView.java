
package pkg2019298_michaelgiacomolli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class FormView extends JFrame{
    
    // NOTE: DB WILL BE USED, THE FIELDS WILL HAVE TO BE DECLARED
    private JTextField emails;
    private JPasswordField passs;
    private JPasswordField cpasss;
    private JTextField names;
    private JTextField nums;
    private JTextField addresss;
    
    FormController controller;
    
    Color bg = new Color(241,106,100);
    
    
    
    public FormView(FormController controller, String u){
        
        this.controller = controller;
        
        //COMING FROM A LONG WAY (signup.java), HERE IT COMES OUR STRING 'u',
        // TO Diminish the quantity of work...
        
        //CUSTOMER FORM WINDOW
        if(u.equalsIgnoreCase("customer")){
            
            this.setVisible(true);
            this.setSize(350, 550);
            this.setTitle("ME.barber - Account");


            //BASE LAYER
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

            //--MAIN AREA (P3 - CENTER)--//
            BoxLayout main = new BoxLayout(p3, BoxLayout.Y_AXIS);

            JPanel pDetails = new JPanel();
            JPanel lDetails = new JPanel();

            FlowLayout pd = new FlowLayout(FlowLayout.LEFT, 1, 4);
            pDetails.setLayout(pd);

            FlowLayout ld = new FlowLayout(FlowLayout.LEFT, 1, 6);
            lDetails.setLayout(ld);

            p3.setLayout(main);
            p3.setBackground(bg);

            pDetails.setBackground(bg);
            lDetails.setBackground(bg);

            //-----P3---Components-------

            //---------------Personal details --------------
            JLabel name = new JLabel("Full Name: ");
            labelStyller(name);

            names = new JTextField(30);
            textFStyller(names);

            JLabel num = new JLabel("Mobile Number: ");
            labelStyller(num);

            nums = new JTextField(25);
            textFStyller(nums);

            pDetails.add(name);
            pDetails.add(names);
            pDetails.add(num);
            pDetails.add(nums);

            //--------------------------------------------------------
            JLabel einfo = new JLabel("ACCOUNT SETUP");
            labelStyller(einfo);
            //---------------Login Details-------------------
            JLabel email = new JLabel("E-Mail: ");
            labelStyller(email);

            emails = new JTextField(30);
            textFStyller(emails);

            JLabel pass = new JLabel("Password: ");
            labelStyller(pass);

            passs = new JPasswordField(30);
            passs.setColumns(25);
            passs.setFont(new Font("Arial", Font.PLAIN, 18));

            JLabel cpass = new JLabel("Confirm Password: ");
            labelStyller(cpass);

            cpasss = new JPasswordField(30);
            cpasss.setColumns(25);
            cpasss.setFont(new Font("Arial", Font.PLAIN, 18));

            lDetails.add(email);
            lDetails.add(emails);
            lDetails.add(pass);
            lDetails.add(passs);
            lDetails.add(cpass);
            lDetails.add(cpasss);
            //--------------------------------------------
            JButton submit = new JButton("SUBMIT");
            buttonStyller(submit);
            
            submit.addActionListener(controller);

            //---- ADDING IN P3 ----------

            p3.add(pDetails);
            p3.add(einfo);
            p3.add(lDetails);
            p3.add(submit);

            this.add(p1, BorderLayout.PAGE_START);
            this.add(p2, BorderLayout.LINE_START);
            this.add(p3, BorderLayout.CENTER);
            this.add(p4, BorderLayout.LINE_END);
            this.add(p5, BorderLayout.PAGE_END);

            this.validate();
            this.repaint();
        }
// =============================== END OF CUSTOMER FORM FRAME ===================================      
    //here it comes: PRO`S FORM  
        if(u.equalsIgnoreCase("pro")){
            
            this.setVisible(true);
            this.setSize(500, 600);
            this.setTitle("ME.barber - Account");
            

            //BASE LAYER
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

            //--MAIN AREA (P3 - CENTER)--//
            BoxLayout main = new BoxLayout(p3, BoxLayout.Y_AXIS);
            
            GridLayout pd = new GridLayout(2, 2, 5, 5);
            
            GridLayout ld = new GridLayout(3, 2, 5, 5);
            
            JPanel a1 = new JPanel();
            JPanel a2 = new JPanel();
            JPanel a3 = new JPanel();
            JPanel a4 = new JPanel();
            JPanel a5 = new JPanel();
            
            a1.setLayout(pd);
            a5.setLayout(ld);
            
            p3.setLayout(main);
            p3.setBackground(bg);

            a1.setBackground(bg);
            a3.setBackground(bg);
            a2.setBackground(bg);
            a4.setBackground(bg);
            a5.setBackground(bg);

            //---------------Personal details --------------
            JLabel name = new JLabel("Full Name: ");
            labelStyller(name);

            names = new JTextField(30);
            textFStyller(names);

            JLabel num = new JLabel("Mobile Number: ");
            labelStyller(num);

            nums = new JTextField(25);
            textFStyller(nums);

            a1.add(name);
            a1.add(names);
            a1.add(num);
            a1.add(nums);

            //--------------------------------------------------------
            JLabel binfo = new JLabel(" BUSSINESS LOCATION ");
            labelStyller(binfo);
            
            addresss = new JTextField(50);
            textFStyller(addresss);

            a2.add(binfo);
           
            a3.add(addresss);
            
            //--------------------------------------------------------
            JLabel einfo = new JLabel("  ACCOUNT SETUP  ");
            labelStyller(einfo);
            
            a4.add(einfo);
            //---------------Login Details-------------------
            JLabel email = new JLabel("E-Mail: ");
            labelStyller(email);

            emails = new JTextField(30);
            textFStyller(emails);

            JLabel pass = new JLabel("Password: ");
            labelStyller(pass);

            passs = new JPasswordField(30);
            passs.setColumns(25);
            passs.setFont(new Font("Arial", Font.PLAIN, 18));

            JLabel cpass = new JLabel("Confirm Password: ");
            labelStyller(cpass);

            cpasss = new JPasswordField(30);
            cpasss.setColumns(25);
            cpasss.setFont(new Font("Arial", Font.PLAIN, 18));

            
            a5.add(email);
            a5.add(emails);
            a5.add(pass);
            a5.add(passs);
            a5.add(cpass);
            a5.add(cpasss);
            //--------------------------------------------
            JButton submit = new JButton(" SUBMIT ");
            buttonStyller(submit);
            submit.addActionListener(controller);

            //---- ADDING IN P3 ----------

            p3.add(a1);
            p3.add(a2);
            p3.add(a3);
            p3.add(a4);
            p3.add(a5);
            
            //p5
            p5.add(submit);

            this.add(p1, BorderLayout.PAGE_START);
            this.add(p2, BorderLayout.LINE_START);
            this.add(p3, BorderLayout.CENTER);
            this.add(p4, BorderLayout.LINE_END);
            this.add(p5, BorderLayout.PAGE_END);

            this.validate();
            this.repaint();

        }
    
    
    }
    //StYlE
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
    private void labelStyller(JLabel J){
        J.setFont(new Font("Arial", Font.BOLD, 18));
        J.setForeground(Color.WHITE);
        J.setHorizontalAlignment(SwingConstants.LEFT);
    
    }
    private void textFStyller(JTextField J){
        J.setFont(new Font("Arial", Font.PLAIN, 18));
        J.setForeground(bg);
        J.setHorizontalAlignment(SwingConstants.LEFT);
        J.setColumns(25);
    
    }
    
    // GETTERS
    public String getName(){
        return names.getText();
    }
    public String getMobile(){
        return nums.getText();
    }
    public String getAddress(){
        return addresss.getText();
    }
    public String getEmail(){
        return emails.getText();
    }
    public String getPass(){
        return passs.getText();
    }
    public String getCpass(){
        return cpasss.getText();
    }
    //Jtexfield setters
    public void clearFields(String u){
        emails.setText(null);
        passs.setText(null);
        cpasss.setText(null);
        names.setText(null);
        nums.setText(null);
        if(u.equalsIgnoreCase("pro")){
            addresss.setText(null);
        }
    }
    public void clearPassFields(){
        passs.setText(null);
        cpasss.setText(null);
    }
}
