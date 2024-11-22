package Utils;

import static Utils.Message.MessageType.PRIVATE;
import static Utils.Message.MessageType.PUBLIC;
import java.io.Serializable;

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
    
    public Message(String sender) {
        this.senderID = sender;
    }
    
    public void SetMSG(String str){
        this.message = str;
    }
    
    public void isPrivate(boolean Conditioin){
        if(Conditioin){this.type = PRIVATE;}
        else {this.type = PUBLIC;}
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