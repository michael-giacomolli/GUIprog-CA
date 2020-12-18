
package pkg2019298_michaelgiacomolli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Controller implements ActionListener{

    View view;
    Model model;
    
    String myNull = null;
      
    String option = null;
    
    public Controller(){
        this.view = new View(this);
        this.model = new Model();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //RADIO BUTTON OPTION COMMANDS
        if(e.getActionCommand().equals("customer")){
            option = "customer";            
        }
        if(e.getActionCommand().equals("pro")){
            option = "pro";
        }
        //SIGNING BUTTONS ACTION COMMANDS
        if(e.getActionCommand().equals("signin")){
            //Jradio buttons have to be clicked!
            if(option == null){
                JOptionPane.showMessageDialog(new JFrame(),"Please, choose an option at the top!","User Specification Not Found",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String email = view.getEmail();
                String pass = view.getPassword();

                User user = new User(email, pass, myNull, myNull, myNull);

                boolean result = model.login(user, option);

                if(result){
                    new dashController(user, option);
                    view.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(),"Incorrect Username/Password, try again. ","Invalid Credential",JOptionPane.WARNING_MESSAGE);
                    view.clearFields();
                }
            }            
        }
        if(e.getActionCommand().equals("signup")){
            new signup();
        }
            
           

        
    }
}
