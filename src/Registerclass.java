
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class Registerclass {
    private String storedUsername, storedPassword, storedcellnumber;
    private String storedCellnumber;
    
    public String registerUser(String username,String password,String cellnumber){
        String messages = "";
        boolean allGreat = true;
        
        if (checkUserName(username)){
            messages += "Username captured successfully\n";
            
        }else{
            messages += "username is incorrect, please fix it";
            allGreat = false;
            
        }
        
        if (checkPasswordComplexity(password)){
            messages += "Password captured successfully]\n";
            
        }else{
            messages += "Password incorrect, please fix it";
            allGreat = false;
        }            
                    
         if (checkCellnumber(cellnumber)){
             messages += "Cellnumber captured successfully\n";
         }else{
             allGreat = false;
         }
         
         if (allGreat){
             storedUsername = username;
             storedPassword = password;
             storedCellnumber =cellnumber;
             messages += "Successfully registered";
         }else{
             messages += "Unsuccessful registration";
         }
         
         return messages;
    }
         
         public String getUsername()
         {
             return storedUsername;
         }
         
         private boolean checkPasswordComplexity(String password){
             if (password == null || password.length() < 8) return false;
             return password.matches(".*[A-Z].*")&&
                     password.matches(".*[0-9].*")&&
                     password.matches(".*[!@#$%^&*()].*");
         }
         
         private boolean checklCellNumber(String cellnumber) {
             return cellnumber != null && Pattern.matches("\\+27[0-9]{9}$", cellnumber);
         }

    private boolean checkCellnumber(String cellnumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean checkUserName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        }
