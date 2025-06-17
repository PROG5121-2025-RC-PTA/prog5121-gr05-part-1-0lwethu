/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment_POE_plus_part3;

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.*;
import java.io.FileWriter;
import Assignment_POE_plus_part3.Message;
import java.io.FileReader;
import java.io.BufferedReader;
import static java.util.Objects.hash;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author RC_Student_lab
 */
public class MessageManager {
    private ArrayList<Message> messages = new ArrayList<>();
    private Map<String, Message> message = new HashMap<>();
    private String hash;
    
    
      public String addMessage(String recipient, String message) {
          String (hash, new Message(hash, recipient, message));
          return hash;
      }

    public List<String> getAllMessages() {
        List<String> allMessages = new ArrayList<>();
        for(Message msg : message.values()){
            allMessages.add(msg.getMessage());
        }
        return allMessages;
    }

    public String getLongestMessage() {
        String longest ="";
        for (Message msg : message.values()){
            if (msg.getMessage().length()> longest.length()){
                longest = msg.getMessage();
            }
        }
        return longest;
    }


    public String getMessageById(String id) {
        Message msg = message.get(id);
        return (msg != null) ? msg.getMessage(): null;
    }

    public List<String> getMessagesByRecipient(String recipient) {
        List<String> results = new ArrayList<>();
        for (Message msg : message.values()){
            if (msg.getRecipient().equals(recipient)){
                results.add(msg.getMessage());
            }
        }
        return results;
    }

    public boolean deleteMessageByHash(String hash) {
        return message.remove(hash) != null;
    }

    public String generateReport() { 
        StringBuilder report = new StringBuilder("Message Hash\tRecipient\tMessage\n");
        for (Message msg : message.values()){
            report.append(msg.getHash()).append("\t")
                   .append(msg.getRecipient()).append("\t")
                   .append(msg.getMessage()).append("\n");
        }
        return report.toString();
    }

    List<Message> sent = new ArrayList<>();
    List<Message> stored = new ArrayList<>();
    List<Message> disregard = new ArrayList<>();
    
    public void loadFromJson(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/assignment_POE_plus_part3/messages.json"));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                jsonBuilder.append(line);
            }
            reader.close();
            String jsonText =jsonBuilder.toString();
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray arr = new JSONArray(content);
            JSONArray messageArray = new JSONArray(new JSONTokener(new FileReader("messages.json")));
            for (int i = 0; i < arr.length(); i++){
                JSONObject json = arr.getJSONObject(i);
                if (json.has("recipient")){
                    String recipient = json.getString("recipient");
                    System.out.println("recipient: " + recipient);
                }else{
                    System.out.println("recipient not found in: " + json);
                }
                String recipient = json.getString("recipient");
                String message = json.getString("message");
                String flag =json.getString("flag");
                this.message.put(hash, new Message(recipient, message, flag));
                Message msg = new Message(recipient, message, flag);
                
                switch (flag.toLowerCase()){
                    case "sent": sent.add(msg); break;
                    case "stored": stored.add(msg); break;
                    case "disregard": disregard.add(msg); break;
                }
        }
            System.out.println(" Load messages from JSON.");
        }catch (Exception e){
            System.out.println("Error loading JSON: " + e.getMessage());
        }
    }
        public Map<java.lang.String,Message> getMessage(){
            return message;
    }
    public void displayAllSentMessages(){
        for (Message m : sent) System.out.println(m);
    }
    
    public void displayLongestMesssage(){
        Message longest = null;
        for (Message m : sent){
            if (longest == null || m.content.length() > longest.content.length()){
                longest = m;
            }
        }
        if (longest != null){
            System.out.println("Longest Sent Message: " + longest.content);
        }
    }
    public void saveToJson(String filename){
        JSONArray arr = new JSONArray();
        for (Message msg : message.values()){
            JSONObject obj = new JSONObject();
            obj.put("recipient", msg.getRecipient());
            obj.put("message", msg.getMessage());
            obj.put("flag", msg.getFlag());
            arr.put(obj);
        }
        try (FileWriter file = new FileWriter(filename)){
            file.write(arr.toString(4));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addMessage(Message msg){
        message.put(msg.getHash(),msg);
    }

    private void String(String hash, Message message) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
