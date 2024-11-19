/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package player.serverConnection;

import java.io.Serializable;

/**
 *
 * @author Brian Ramirez
 */
public class Message implements Serializable {
    public enum MessageType { 
        PUBLIC, 
        PRIVATE 
    }
    
    private String sender;
    private String message;
    private MessageType type;

    public Message(String sender, String message, MessageType type) {
        this.sender = sender;
        this.message = message;
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public MessageType getType() {
        return type;
    }

    @Override
    public String toString() {
        String visibility = (type == MessageType.PUBLIC) ? "public" : "private";
        return sender + " said " + visibility + ": " + message;
    }
}