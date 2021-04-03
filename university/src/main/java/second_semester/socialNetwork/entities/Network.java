package second_semester.socialNetwork.entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Network {

    public static HashMap<String, Account> couchWarriors = new HashMap<>();
    private static final Network network = new Network();

    public Network() {
    }

    public static Network getNetwork() {
        return network;
    }

    public String regAccount(Account newAccount){
        String id = String.valueOf(couchWarriors.size()+1);
        newAccount.setId(id);
        couchWarriors.put(id, newAccount);

        return id;
    }

    public void deleteAccount(String id){
        couchWarriors.remove(id);
        System.out.println("Аккаунт "+ id + " удален.");
    }

    public Account getAccountById(String id){
        return couchWarriors.get(id);
    }

    public ArrayList<String> getIdList(){
        return new ArrayList<>(couchWarriors.keySet());
    }

    //основной метод проверки блокировки находится тут, потому что
    // по сути, аккаунт - это не нечто отдельное, живущее само по себе, а часть сети, сервиса.
    // и именно соцсеть, а точнее ее сервисы проверяют настройку аккаунта перед каким-то действием
    public boolean isInBlockList(String sender, String receiver){
        return couchWarriors.get(receiver).isBlocked(sender);
    }


}
