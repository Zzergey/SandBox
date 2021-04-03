package second_semester.socialNetwork.entities;

import java.util.HashMap;
import java.util.HashSet;

public class Account {

    private final Person person;
    private String id;

    private final HashSet<String> blockList = new HashSet<>();
    private final HashMap<String, Chat> myChats = new HashMap<>();

    public Account(Person person) {
        this.person = person;
    }

    public boolean isBlocked(String id){
        return blockList.contains(id);
    }

    public void addInBlockList(String personId){
       blockList.add(personId);

       if(myChats.get(personId)!=null){
           myChats.get(personId).addMessage(new Message("Система", personId, "--------Вы ограничили получение сообщений от "+Network.getNetwork().getAccountById(personId).getPerson().getFirstName()), false, false);
       }
    }

    public Person getPerson() {
        return person;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Chat getChat(String personId) {
        if ( myChats.get(personId) == null ){
             Chat chat = new Chat();
             myChats.put(personId, chat);
            return chat;
        } else {
            return myChats.get(personId);
        }
    }

    public HashMap<String, Chat> getMyChat() {
        return myChats;
    }

    public int getChatCount() {
        return myChats.size();
    }
}
