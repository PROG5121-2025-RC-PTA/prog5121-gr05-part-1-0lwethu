/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class LoginClass {
    
    private final RegistrationClass registrationclass = null;
    private boolean isLoggedIn;
    private final RegistrationClass registerclass;
    
    public LoginClass(RegistrationClass reg){
     
        this.registerclass = reg;
        this.isLoggedIn =false;
    }

    LoginClass(RegisterClass LoginClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public boolean loginUser(String username, String password){
        
        isLoggedIn = username != null && password != null &&
                     username.equals(registrationclass.getUsername()) &&
                     password.equals(registrationclass.getPassword());
        return isLoggedIn;
    
    }
    
    public String returnLoginStatus(){
        if (isLoggedIn) {
            return "Welcome back" + registerclass.getUsername() + ",\ngreat to see you again.";
        }else{
            return "Username or Password incorrect";
        }
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
            

    private static class RegistrationClass {

        public RegistrationClass() {
        }

        private Object getUsername() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private Object getPassword() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    static class RegisterClass {

        public RegisterClass() {
        }
    }
    
}
