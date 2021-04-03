package second_semester.socialNetwork.entities;

import java.util.*;

public class Chat{

    private final ArrayList<Message> chatWith = new ArrayList<>();

    public void showAllMessages(){
        for (Message m: chatWith) {
            System.out.println(m.toString());
        }
    }

    public int getMessageCount(){
        return chatWith.size();
    }

    public void addMessage(Message message, boolean myChat, boolean admin){
        String id = new Date() + Arrays.toString(message.getMessageText().getBytes());
        message.setId(id);

        if (!message.getSenderId().equals("Система") &
             Network.getNetwork().isInBlockList(message.getSenderId(), message.getReceiverId())){
             message.setMessageText("-------Сообщение не доставлено, по скольку вы в черном списке у получателя-------");
             chatWith.add(message);

             if(!admin){
                System.out.println("Вы не можете посылать сообщения этому человеку, по скольку он ограничил список отправителей");
             }
            return;
        }

        chatWith.add(message);

        if (myChat) {
            Network.getNetwork().
                    getAccountById(message.getReceiverId()).
                    getChat(message.getSenderId()).
                    addMessage(message, false, admin);
        }

    }

}
