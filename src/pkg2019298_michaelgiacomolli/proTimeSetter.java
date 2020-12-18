
package pkg2019298_michaelgiacomolli;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class proTimeSetter extends JFrame implements ActionListener, WindowListener{
    
    Color bg = new Color(241,106,100);
    
    JDateChooser set;
    java.util.Date def = null;
    JComboBox list;
    String hourToSet;
    
    public proTimeSetter(User user){
        
        // We encapsulated the building process of the window
        attributesSetter();
        components();
        validation();
    }
    // Setting attributes
    private void attributesSetter(){
        this.setVisible(true);
        this.setSize(350, 550);
        this.setTitle("ME.barber - Set Slot");
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
        JLabel title = new JLabel("Time Slot to be added:");
        labelStyller(title);
        
        p1.add(title);
        
        //--MAIN AREA (P3 - CENTER)--//
        BoxLayout main = new BoxLayout(p3, BoxLayout.Y_AXIS);
        
        p3.setLayout(main);
        p3.setBackground(bg);
        
        JPanel d = new JPanel();
        d.setPreferredSize(new Dimension(250,70));
        JLabel da = new JLabel("Date:");
        labelStyller(da);
        
        //GETTING TODAY`S DATE
        Calendar cal = Calendar.getInstance();
        java.util.Date g = cal.getTime();
                
        //DATECHOOSER
        set = new JDateChooser();
        set.setPreferredSize(new Dimension(100,40));
        set.setDateFormatString("dd/MM/yyyy");
        set.setMinSelectableDate(g);
                
        JPanel hours = new JPanel();
               
        JLabel h = new JLabel("Hours:");
        labelStyller(h);
        
        String[] listTime = { " 00:00 ", " 01:00 ", " 02:00 ", " 03:00 ", " 04:00 ", " 05:00 ",
                              " 06:00 ", " 07:00 ", " 08:00 ", " 09:00 ", " 10:00 ", " 11:00 ",
                              " 12:00 ", " 13:00 ", " 14:00 ", " 15:00 ", " 16:00 ", " 17:00 ",
                              " 18:00 ", " 19:00 ", " 20:00 ", " 21:00 ", " 22:00 ", " 23:00 "};
        
        list = new JComboBox(listTime);
  
        //adding components        
        hours.setBackground(bg);
        d.setBackground(bg);
        
        hours.add(h);
        hours.add(Box.createRigidArea(new Dimension(0,30)));
        hours.add(list);
        
        
        d.add(da);
        d.add(set);
        p3.add(Box.createRigidArea(new Dimension(0,30)));
        p3.add(d);
        p3.add(Box.createRigidArea(new Dimension(0,30)));
        p3.add(hours);
        
                
        //-------- p5 = BOTTOM PANEL (buttons) -------------- //
        GridLayout ld = new GridLayout(1, 3, 10, 10);
            
        JPanel buttonLine = new JPanel();
        buttonLine.setLayout(ld);
        buttonLine.setBackground(bg);
        
        JButton cancel = new JButton(" CANCEL ");
        buttonStyller(cancel);
        cancel.setForeground(Color.red);
        cancel.addActionListener(this);
        cancel.setActionCommand("cancel");
        
        
        JButton sety = new JButton(" SET ");
        buttonStyller(sety);
        sety.setForeground(Color.green);
        sety.addActionListener(this);
        sety.setActionCommand("set");
        
        buttonLine.add(cancel);
        buttonLine.add(Box.createRigidArea(new Dimension(15,0)));
        buttonLine.add(sety);
        
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
    //JDateChooser Getter
    public String dGetter(){
        def = set.getDate();
        if(def!=null){
            System.out.println(def);
            DateFormat td = new SimpleDateFormat("dd/MM/yyyy");
            String dateToSet = td.format(def);
            System.out.println(dateToSet);
            return dateToSet;
        }else{
            String dateToSet = null;
            return dateToSet;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("cancel")){
            
        }
        if(e.getActionCommand().equals("set")){
            String dateToSet = dGetter();
            //IF USER HASN`T CHOOSEN A DATE
            if(dateToSet==null){
                JOptionPane.showMessageDialog(new JFrame(),"Please, choose a date!!","Date field is empty!",JOptionPane.WARNING_MESSAGE);                       
            }else{
                //Get specified hour, and removes white spaces
                hourToSet = list.getSelectedItem().toString();
                hourToSet = hourToSet.trim();
                
            }
        }
        
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