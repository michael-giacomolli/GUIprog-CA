
package pkg2019298_michaelgiacomolli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class dashController implements ActionListener{

    dashView view;
    dashModel model;
    String status, s;
    User user;
        
    String searchParameter;
    
    public dashController(User user, String u){
        
        status = u;
        this.user = user;
        this.view = new dashView(this, status);
        this.model = new dashModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //====================================  CUSTOMER    ==================================================
        //SEARCH RADIO BUTTONS OPTION COMMANDS
        if(e.getActionCommand().equals("search name")){
            searchParameter = "name";            
        }
        if(e.getActionCommand().equals("search address")){
            searchParameter = "address";
        }
        //SEARCH BUTTON ACTION COMMAND
        if(e.getActionCommand().equals("search")){
            //Jradio buttons have to be clicked!
            if(searchParameter == null){
                JOptionPane.showMessageDialog(new JFrame(),"Please, choose a search filter!","Search Parameter Not Found",JOptionPane.WARNING_MESSAGE);
            }
            else{
                    new customerBooker(this);                
                }
        }
        //BOOKING BUTTON
        if(e.getActionCommand().equals("booking")){
            new customerAppointments(this);
        }
        //FEEDBACK BUTTON
        if(e.getActionCommand().equals("feedback")){
            new customerFeedback(this);
        }//=======================================  LOGOUT  ====================================================
        //LOG OUT BUTTON
        if(e.getActionCommand().equals("logout")){
                        
        }
        //=====================================     PRO     ====================================================
        //BOOKING BUTTON
        if(e.getActionCommand().equals("events")){
            new proAppointments(this);
        }
        //FEEDBACK BUTTON
        if(e.getActionCommand().equals("set time")){
            new proTimeSetter(user);
        }
        //==================================    PRO-TIME.SETTER     ============================================
        
    }
    
        
}


