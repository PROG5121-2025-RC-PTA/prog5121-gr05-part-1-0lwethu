/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.HashMap;
/**
 *
 * @author RC_Student_lab
 */
public class UserStore {
    private static final HashMap<String, String> users = new HashMap<>();
    
    public static boolean register1(String username, String password, String cellphone){
        if (users.containsKey(username)){
            return false;
        }
        users.put(username, password);
        return true;
    }
    
    public static boolean login(String username, String password){
        if (users.containsKey(username))return false;
        users.put(username, password);
        return true;
    }

    static class login {

        public login() {
        }
    }
    }

    

