/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140956.ChatApplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class ChatUsersStorage implements Serializable{

    private static HashMap<String, ChatUser> chatUsersList;

    public ChatUsersStorage() {
        this.chatUsersList = new HashMap<>();
    }

    public ChatUsersStorage(HashMap<String, ChatUser> chatUsersList) {
        this.chatUsersList = chatUsersList;
    }

    public void addUser(ChatUser chatUser) {
        this.chatUsersList.put(chatUser.getIp(), chatUser);
    }

    public ChatUser getUserByIP(String ip) {
        return this.chatUsersList.get(ip);
    }

    public ChatUser getUserByNickname(String nick) {
        for (ChatUser cUser : this.chatUsersList.values()) {
            if (cUser.getNickname().equals(nick)) {
                return cUser;
            }
        }
        return null;
    }

    public ChatUser getUserByMachineName(String nick) {
        for (ChatUser cUser : this.chatUsersList.values()) {
            if (cUser.getMachineName().equals(nick)) {
                return cUser;
            }
        }
        return null;
    }

    public HashMap<String, ChatUser> getUserList() {
        return this.chatUsersList;
    }

    public List<ChatUser> getAllUsers() {
        List<ChatUser> users = new ArrayList< ChatUser>();
        for (ChatUser cUser : this.chatUsersList.values()) {
            users.add(cUser);
        }
        return users;
    }
}
