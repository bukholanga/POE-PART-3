package poe;

import java.util.*;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MessageManager {
    public static List<String> sentMessages = new ArrayList<>();
    public static List<String> disregardedMessages = new ArrayList<>();
    public static List<String> storedMessages = new ArrayList<>();
    public static List<String> messageHashes = new ArrayList<>();
    public static List<String> messageIDs = new ArrayList<>();
    public static List<String> recipients = new ArrayList<>();

    public static void populateSampleData() {
        sentMessages.add("Did you get the cake?");
        recipients.add("+27834557896");
        messageHashes.add("hash1");
        messageIDs.add("1");

        sentMessages.add("It is dinner time!");
        recipients.add("0838884567");
        messageHashes.add("hash2");
        messageIDs.add("2");

        sentMessages.add("Where are you? You are late! I have asked you to be on time.");
        recipients.add("+27838884567");
        messageHashes.add("hash3");
        messageIDs.add("3");

        disregardedMessages.add("Yohoooo, I am at your gate.");
    }

    public static void storeMessageToJSON(String recipient, String message) {
        JSONObject obj = new JSONObject();
        obj.put("Recipient", recipient);
        obj.put("Message", message);
        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(obj.toJSONString());
            file.write("\n");
        } catch (IOException e) {
            System.out.println("Error writing to JSON: " + e.getMessage());
        }
    }

    public static void loadStoredMessagesFromJSON() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("messages.json")) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                JSONObject obj = (JSONObject) parser.parse(line);
                storedMessages.add(obj.get("Message").toString());
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
    }

    public static void displayAllSentMessages() {
        System.out.println("All Sent Messages:");
        for (int i = 0; i < sentMessages.size(); i++) {
            System.out.println("Sender: System | Recipient: " + recipients.get(i) + " | Message: " + sentMessages.get(i));
        }
    }

    public static void displayLongestMessage() {
        String longest = "";
        for (String msg : sentMessages) {
            if (msg.length() > longest.length()) {
                longest = msg;
            }
        }
        System.out.println("Longest Sent Message: " + longest);
    }

    public static void searchByMessageID(String id) {
        int index = messageIDs.indexOf(id);
        if (index != -1) {
            System.out.println("Message ID Found: " + id);
            System.out.println("Recipient: " + recipients.get(index));
            System.out.println("Message: " + sentMessages.get(index));
        } else {
            System.out.println("Message ID not found: " + id);
        }
    }

    public static void searchByRecipient(String recipient) {
        System.out.println("Messages to recipient " + recipient + ":");
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).equals(recipient)) {
                System.out.println(sentMessages.get(i));
            }
        }
        for (String msg : storedMessages) {
            if (msg.contains(recipient)) {
                System.out.println(msg);
            }
        }
    }

    public static void deleteMessageByHash(String hash) {
        int index = messageHashes.indexOf(hash);
        if (index != -1) {
            System.out.println("Message '" + sentMessages.get(index) + "' successfully deleted.");
            sentMessages.remove(index);
            messageIDs.remove(index);
            messageHashes.remove(index);
            recipients.remove(index);
        } else {
            System.out.println("Message hash not found: " + hash);
        }
    }

    public static void displayReport() {
        System.out.println("Sent Messages Report:");
        for (int i = 0; i < sentMessages.size(); i++) {
            System.out.println("Hash: " + messageHashes.get(i));
            System.out.println("Recipient: " + recipients.get(i));
            System.out.println("Message: " + sentMessages.get(i));
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        populateSampleData();
        storeMessageToJSON("+27838884567", "Ok, I am leaving without you.");
        loadStoredMessagesFromJSON();

        displayAllSentMessages();
        displayLongestMessage();
        searchByMessageID("3");
        searchByRecipient("+27838884567");
        deleteMessageByHash("hash3");
        displayReport();
    }

    static void saveMessagesToJSON(String test_outputjson) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}