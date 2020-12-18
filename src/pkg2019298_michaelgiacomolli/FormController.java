
package pkg2019298_michaelgiacomolli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class FormController implements ActionListener{

    FormView view;
    Model model;
    String status;
    
    String address = null;
    User user;
    boolean cont = false;
    
    public FormController(String u){
        
        status = u;
        this.view = new FormView(this, status);
        this.model = new Model();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String email = view.getEmail();
        String pass = view.getPass();
        String cpass = view.getCpass();
        String name = view.getName();
        String mobile = view.getMobile();
        //For pros
        if(status.equalsIgnoreCase("pro")){
            String address = view.getAddress();
            
            //Checks if password and confirm-password fields are equal
            if(pass.equals(cpass)){
                //matching: the process continues
                user = new User(email, pass, name, mobile, address);
                cont = true;
            }else{
                JOptionPane.showMessageDialog(new JFrame(),"Password Fields Do Not Match","Attention!",JOptionPane.WARNING_MESSAGE);
                view.clearPassFields();
            }
        }else{                                  // If user is customer --> address value = null
            //Checks if password and confirm-password fields are equal
            if(pass.equals(cpass)){
                //matching: the process continues
                user = new User(email, pass, name, mobile, address);
                cont = true;
            }else{
                JOptionPane.showMessageDialog(new JFrame(),"Password Fields Do Not Match","Attention!",JOptionPane.WARNING_MESSAGE);
                view.clearPassFields();
            }
        }
        //
        if(cont){
            //Sends recently created user to Model.java to check if email already exists in DB
            boolean userExists = model.SignUp(user, status);

            if(userExists){ //Existing an user if the same email
                JOptionPane.showMessageDialog(new JFrame(),"E-MAIL ALREADY USED","Invalid E-mail!",JOptionPane.WARNING_MESSAGE);
                view.clearFields(status);

            }else{ //  if email written has not been used yet, PROCESS CONTINUES
                //Sends user to Model.java to create entry in DB
                model.NewUser(user, status);
                JOptionPane.showMessageDialog(new JFrame(), "Submission Complete!");
                view.dispose();

            }
        }
        
}

}
