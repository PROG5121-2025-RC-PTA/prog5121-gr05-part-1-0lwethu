/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package messages;

import Assignment_POE_plus_part3.Message;
import Assignment_POE_plus_part3.MessageManager;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.junit.Test;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
/**
 *
 * @author RC_Student_lab
 */
public class TestMessageManager {
    @Test
    public void testMessage1(){
        Message msg = new Message("+27834557896", "Did you get the cake?", "Sent");
        assertEquals("+27834557896", msg.getRecipient());
        assertEquals("Did you get the cake?", msg.getMessage());
        assertEquals("Sent", msg.getFlag());
    }
    @Test
    public void testMessage2(){
        Message msg = new Message("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        assertEquals("+27838884567", msg.getRecipient());
        assertEquals("Where are you? You are late! I have asked you to be on time.", msg.getMessage());
        assertEquals("Stored", msg.getFlag());
    }
    @Test
    public void testMessage3(){
        Message msg = new Message("+27834484567", "Yohoooo, I am at your gate.", "Disregard");
        assertEquals("++27834484567", msg.getRecipient());
        assertEquals("Yohoooo, I am at your gate.", msg.getMessage());
        assertEquals("Disredard", msg.getFlag());
    }
    @Test
    public void testMessage4(){
        Message msg = new Message("0838884567", "It is dinner time!", "Sent");
        assertEquals("0838884567", msg.getRecipient());
        assertEquals("It is dinner time", msg.getMessage());
        assertEquals("Sent", msg.getFlag());
    }
    @Test
    public void testMessage5(){
        Message msg = new Message("+27838884567", "Ok, I am leaving without you.", "Stored");
        assertEquals("27838884567", msg.getRecipient());
        assertEquals("Ok, I am leaving without you", msg.getMessage());
        assertEquals("Stored", msg.getFlag());
    }
    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        MessageManager manager = new MessageManager();
        manager.addMessage("0838884567", "Did you get the cake?");
        manager.addMessage("0838884567", "It is dinner time!");

        List<String> messages = manager.getAllMessages();

        assertTrue(messages.contains("Did you get the cake?"));
        assertTrue(messages.contains("It is dinner time!"));
    }

    @Test
    public void testDisplayLongestMessage() {
        MessageManager manager = new MessageManager();
        manager.addMessage("0838884567", "Where are you? You are late! I have asked you to be on time.");

        String longest = manager.getLongestMessage();

        assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
    }

    @Test
    public void testSearchByMessageID() {
        MessageManager manager = new MessageManager();
        manager.addMessage("0838884567", "It is dinner time!");

        String foundMessage = manager.getMessageById("0838884567");
        assertEquals("It is dinner time!", foundMessage);
    }

    @Test
    public void testSearchMessagesByRecipient() {
        MessageManager manager = new MessageManager();
        manager.addMessage("+27838884567", "Where are you? You are late! I have asked you to be on time.");
        manager.addMessage("+27838884567", "Ok, I am leaving without you.");

        List<String> results = manager.getMessagesByRecipient("+27838884567");

        assertEquals(2, results.size());
        assertTrue(results.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(results.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDeleteMessageUsingHash() {
        MessageManager manager = new MessageManager();
        String hash = manager.addMessage("0838884567", "Where are you? You are late! I have asked you to be on time.");

        boolean deleted = manager.deleteMessageByHash(hash);

        assertTrue(deleted);
        assertNull(manager.getMessageById(hash));
    }

    @Test
    public void testDisplayReport() {
        MessageManager manager = new MessageManager();
        String hash = manager.addMessage("0838884567", "It is dinner time!");

        String report = manager.generateReport();

        assertTrue(report.contains("Message Hash"));
        assertTrue(report.contains("Recipient"));
        assertTrue(report.contains("Message"));
        assertTrue(report.contains("It is dinner time!"));
    }

    public static void main(String[] args){
        MessageManager manager = new MessageManager();
        MessageManager mm = new MessageManager();
        mm.loadFromJson("messages.json");
        
        mm.displayAllSentMessages();
        mm.displayLongestMesssage();
        String[] options = {"Send Message", "View Sent Messages"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "Message System",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
                        );     
        
        if (choice == 0){
            manager.loadFromJson("messages.json");
            
            String recipient = JOptionPane.showInputDialog("Enter recipient name:");
            String message =JOptionPane.showInputDialog("Enter message text:");
            
            
            manager.saveToJson("message.json");
            
            JOptionPane.showMessageDialog(null, "Message sent and saved!");
            
        }else if (choice == 1){
            
            manager.loadFromJson("message.json");
            
            StringBuilder output = new StringBuilder();
            for (Iterator<Message> it = manager.getMessage().values().iterator(); it.hasNext();) {
                var msg = it.next();
                output.append("To: ").append(msg.getRecipient()).append("\n")
                        .append("Message: ").append(msg.getMessage()).append("\n")
                        .append("Status: ").append(msg.getFlag()).append("\n");
            }
            if (output.length() == 0){
                output.append("No messages found.");
            }
            
            JOptionPane.showMessageDialog(null, output.toString());
        }
    }
    
}
