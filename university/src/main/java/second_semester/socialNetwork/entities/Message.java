package second_semester.socialNetwork.entities;

public class Message {

    private String id;
    private final String senderId;     // от кого
    private final String receiverId;   // кому
    private String messageText;        // текст сообщения

    public Message(String senderId, String receiverId, String messageText) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageText = messageText;
    }

    public String getMessageText() {
        return messageText;
    }

    //изменить текст сообщения ( исправление сообщения возможно в соцсетях )
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    @Override
    public String toString() {
        String from, to;
        if (senderId.equals("Система")) {
            from = "Система";
        } else {
            from = Network.getNetwork().getAccountById(senderId).getPerson().getFirstName();
        }

        if (Network.getNetwork().getAccountById(receiverId) == null){
            to = "-аккаунт уже не существует-";
        } else {
            to = Network.getNetwork().getAccountById(receiverId).getPerson().getFirstName();
        }

        return "Message{" +
                "От: " + from +
                " к " + to +
                ": " + messageText + '\'' +
                '}';
    }
}
