/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

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
    
    public String senderID;
    public String receptorID;
    public String message;
    public MessageType type;

    public Message(String sender, String receptorID,String message, MessageType type) {
        this.senderID = sender;
        this.receptorID=receptorID;
        this.message = message;
        this.type = type;
    }

    public String getSender() {
        return senderID;
    }

    public String getMessage() {
        return message;
    }

    public MessageType getType() {
        return type;
    }

    @Override
    public String toString() {
        if(type == MessageType.PUBLIC)
            return senderID + " said: " + message;
        else 
            return senderID + " sent you a private message: " + message;
    }
    
}