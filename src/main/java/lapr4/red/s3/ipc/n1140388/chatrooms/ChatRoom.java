/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class ChatRoom implements Serializable {

    private String name;
    private ChatUser owner;
    private List<ChatUser> participants;
    private boolean online;

    /**
     * Creates a chat room.
     *
     * @param name the name of the chat room
     * @param owner the owner of the chat room
     */
    public ChatRoom(String name, ChatUser owner) {
        this.name = name;
        this.owner = owner;
        this.online = false;
        this.participants = new ArrayList<>();
        this.participants.add(owner);
    }

    /**
     * Returns the name of the chat room.
     *
     * @return the name of the chat room
     */
    public String name() {
        return name;
    }

    /**
     * Returns the owner of the chat room.
     *
     * @return the owner of the chat room
     */
    public ChatUser owner() {
        return owner;
    }

    /**
     * Returns the list of participants of the chat room.
     *
     * @return the list of participants of the chat room
     */
    public List<ChatUser> participants() {
        return participants;
    }

    /**
     * Returns if the chat room is online.
     *
     * @return true if the chat room is online, false in case the chat is
     * offline
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * Compare if the chat room is equals to other chat room.
     *
     * @param other the chat to compare
     * @return true if the same is the same, false if is not
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ChatRoom room = (ChatRoom) other;

        return this.name.equalsIgnoreCase(room.name());
    }
}