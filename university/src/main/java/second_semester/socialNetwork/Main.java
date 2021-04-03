package second_semester.socialNetwork;

import second_semester.socialNetwork.entities.*;

import java.util.*;

public class Main {

    private static final Network network = Network.getNetwork();
    private static final Scanner scanner = new Scanner(System.in);
    private static Account account;

    public static void main(String[] args) {

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("--------------------------------- СОЦИАЛЬНАЯ СЕТЬ --------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Вы - администратор социальной сети. Выберите действие:");

        stepOne();
    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    // выбор действия с аккаунтами
    public static void stepOne(){

        do {
            System.out.println("1) Создать новый аккаунт");
            System.out.println("2) Сгенерировать аккаунты автоматически или выбрать имеющийся из списка");
            System.out.println("3) Выход");
            String temp = scanner.nextLine();
            int option;

            if (isNumber(temp)) {
                option = Integer.parseInt(temp);
            } else {
                System.err.println("Введены некоректные данные, попробуйте снова");
                System.out.println();
                continue;
            }

            switch (option) {
                case 1: {
                    createAccount();
                    break;
                }
                case 2: {
                    accountOptions();
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    System.err.println("Ошибка. Попробуйте снова");
                    System.out.println();
                }
            }

            System.out.println("---------------------");
        } while (true);

    }

    //создание аккаунта
    public static void createAccount() {
        String x;

        do {
            System.out.println("Для создания аккаунта нужно ввести данные пользователя");
            System.out.println("Введите через пробел: Имя, Отчество, Фамилию, Возраст и Пол");
            System.out.println("Например: Иван Иванович Иванов 26 мужской");
            System.out.println("----------------------------------------------------------------------------------");

            String[] userData = scanner.nextLine().split(" ");

            if (userData.length < 5) {
                System.err.println("Введено недостаточно данных. Попробуйте снова");
                System.out.println();
                continue;
            }

            if (!isNumber(userData[3])) {
                System.err.println("Введен некорректный возраст, попробуйте снова, на этот раз используя цифры :)");
                System.out.println();
                continue;
            }


            Person person = new Person();
            person.resetData(userData[0], userData[1], userData[2], Integer.parseInt(userData[3]), userData[4], "", "", "");

            account = new Account(person);
            x = network.regAccount(account);
            System.out.println("Аккаунт зарегистрирован. Id : " + x);
            break;

        } while (true);


        nextStep();
    }

    //выбор имеющегося аккаунта
    public static void accountOptions(){
        int option;
        String temp;

        do {
            System.out.println("1) Создать аккаунты автоматически");
            System.out.println("2) Выбрать один из существующих");
            temp = scanner.nextLine();

            if (isNumber(temp)) {
                option = Integer.parseInt(temp);
            } else {
                System.err.println("Введены некоректные данные, попробуйте снова");
                System.out.println();
                continue;
            }

            switch (option) {
                case 1: {
                    generateAccount();
                    break;
                }
                case 2: {
                    selectAccount();
                    break;
                }
                default: {
                    System.err.println("Ошибка. Попробуйте снова");
                    System.out.println();
                }
            }
        } while (true);
    }


    public static void generateAccount(){
        int option;
        String temp;

        do {
            System.out.println("Введите количество аккаунтов для генерации ( Рекомендуется 20 - 50 ) ");
            System.out.println("Минимальный предел: 1, максимальный: MAX_INT");
            System.out.println("----------------------------------------------------------------------------------");
            temp = scanner.nextLine();

            if (isNumber(temp)) {
                option = Integer.parseInt(temp);
            } else {
                System.err.println("Введены некоректные данные, попробуйте снова");
                System.out.println();
                continue;
            }
            break;

        } while (true);

         
        new ContentGenerator(option);
        selectAccount();
    }


    public static void selectAccount(){
        int option;
        String temp;

        ArrayList<String> accounts = network.getIdList();
        if(accounts.size()==0){
            System.out.println();
            System.out.println();
            System.err.println("Не найдено ни одного аккаунта");
            System.out.println();
            System.out.println();
            accountOptions();
            return;
        }

        if(accounts.size()==1){
            System.out.println();
            System.out.println();
            System.err.println("Найден только 1 аккаунт");
            System.out.println();
            System.out.println();
            accountOptions();
            return;
        }

        for (String s : accounts) {
            System.out.println(s + ":"
                    + " " + network.getAccountById(s).getPerson().getFirstName()
                    + " " + network.getAccountById(s).getPerson().getMidName()
                    + " " + network.getAccountById(s).getPerson().getLastName()
                    + " |  чатов: " + network.getAccountById(s).getChatCount());
        }

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Выберите один из аккаунтов и введите его ID");
        System.out.println("----------------------------------------------------------------------------------");


        do {
            temp = scanner.nextLine();

            if (isNumber(temp)) {
                option = Integer.parseInt(temp);
            } else {
                System.err.println("Введены некоректные данные, попробуйте снова");
                System.out.println();
                continue;
            }

            if (!accounts.contains(temp)) {
                System.err.println("Вы выбрали несуществующий аккаунт. Попробуйте снова");
                System.out.println();
                continue;
            }

            break;

        } while (true);

         
        account = network.getAccountById(String.valueOf(option));
        nextStep();
    }



    //выбор действий с выбранным аккаунтом
    public static void nextStep(){
        System.out.println("Выбран аккаунт :"+ account.getId()+": "+ account.getPerson().getFirstName());
        System.out.println();

        while (true) {
            System.out.println("Доступные действия: ");
            System.out.println("1) Дополнить\\ исправить данные пользователя");
            System.out.println("2) Чаты: просмотр имеющихся\\ начать новый");
            System.out.println("3) Удалить аккаунт");
            System.out.println("4) Вернуться в самое начало");
            String temp = scanner.nextLine();
            int option;

            if (isNumber(temp)) {
                option = Integer.parseInt(temp);
            } else  {
                System.err.println("Введены некоректные данные, попробуйте снова");
                System.out.println();
                continue;
            }


            switch (option) {
                case 1: { 
                    editPerson();
                    break;
                }
                case 2: { 
                    chatsOptions();
                    break;
                }
                case 3: { 
                    deleteAcc();
                    break;
                }
                case 4: { 
                    stepOne();
                    break;
                }

                default:{
                    System.err.println("Ошибка. Попробуйте снова");
                    System.out.println();
                }
            }
        }

    }



    public static void editPerson(){
        Person person = account.getPerson();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(person.toString());
        System.out.println("----------------------------------------------------------------------------------");

        do {
            System.out.println("Введите новые данные в формате: Имя, Отчество, Фамилия, Возраст, Пол, Телефон, Город, Емэйл");
            System.out.println("----------------------------------------------------------------------------------");

            String[] userData = scanner.nextLine().split(" ");

            if (userData.length < 8) {
                System.err.println("Введено недостаточно данных. Попробуйте снова");
                System.out.println();
                continue;
            }

            if (!isNumber(userData[3])) {
                System.err.println("Введен некорректный возраст, попробуйте снова, на этот раз используя цифры :)");
                System.out.println();
                continue;
            }

            person.resetData(userData[0], userData[1], userData[2], Integer.parseInt(userData[3]), userData[4], userData[5], userData[6], userData[7]);
            System.out.println("Данные изменены");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println(person.toString());
            System.out.println("----------------------------------------------------------------------------------");
            break;

        } while (true);
         
        nextStep();
        System.out.println();
    }

    public static void chatsOptions(){

        do {
            System.out.println("1) Просмотр имеющихся чатов");
            System.out.println("2) Создать новый чат с рэндомным человеком из базы");
            System.out.println("3) Назад");
            System.out.println("----------------------------------------------------------------------------------");
            String temp = scanner.nextLine();
            int option;

            if (isNumber(temp)) {
                option = Integer.parseInt(temp);
            } else {
                System.err.println("Введены некоректные данные, попробуйте снова");
                System.out.println();
                continue;
            }


            switch (option) {
                case 1: {
                    showMyChats();
                    break;
                }
                case 2: {
                    addChat();
                    break;
                }
                case 3: {
                    nextStep();
                    break;
                }
                default: {
                    System.err.println("Ошибка. Попробуйте снова");
                    System.out.println();
                }
            }

        } while (true);
    }

    public static void showMyChats(){
        System.out.println("----------------------------------------------------");
        System.out.println();
        HashMap<String, Chat> chats = account.getMyChat();
        ArrayList<Chat> chatArrayList;

        if(chats.size() ==0){
            System.err.println("Чатов нет. Выбрать другого человека");
            selectAccount();
            return;
        }

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        int x=0;
        for (Map.Entry<String, Chat> entry : chats.entrySet()) {
            System.out.println(x+ " Чат с " +
                    network.getAccountById(entry.getKey()).getPerson().getFirstName() +" "+
                    network.getAccountById(entry.getKey()).getPerson().getMidName() +" "+
                    network.getAccountById(entry.getKey()).getPerson().getLastName() +" "+
                    ": сообщений: " + entry.getValue().getMessageCount());
            x++;
        }


        do {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Введите номер чата, который хотите просмотреть");

            int option;
            String temp = scanner.nextLine();

            if (isNumber(temp)) {
                option = Integer.parseInt(temp);
            } else {
                System.err.println("Введены некоректные данные, попробуйте снова");
                System.out.println();
                continue;
            }

            if (option < 0 || option > chats.size() - 1) {
                System.err.println("Вы явно не туда нажали");
                continue;
            }

            chatArrayList = new ArrayList<>(chats.values());
            chatArrayList.get(option).showAllMessages();
            showAnotherChat(chats, chatArrayList);
            break;

        } while (true);
    }

    public static void showAnotherChat(HashMap<String, Chat> chats, ArrayList<Chat> chatArrayList){

        int x=0;
        for (Map.Entry<String, Chat> entry : chats.entrySet()) {
            System.out.println(x+ " Чат с " +
                    network.getAccountById(entry.getKey()).getPerson().getFirstName() +" "+
                    network.getAccountById(entry.getKey()).getPerson().getMidName() +" "+
                    network.getAccountById(entry.getKey()).getPerson().getLastName() +" "+
                    ": сообщений: " + entry.getValue().getMessageCount());
            x++;
        }

            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Введите:");
            System.out.println("---- номер чата, который хотите еще просмотреть");
            System.out.println("---- или ' < ' для возврата в предыдущее меню");

            int option=0;
            String temp = scanner.nextLine();

            if (isNumber(temp)) {
                option = Integer.parseInt(temp);
            } else  {
                if (temp.equals("<")) {
                    chatsOptions(); 
                    return;
                }
            }

            if (chats.get(temp) == null) {
                System.err.println("Вы явно не туда нажали");
                chatArrayList.get(option).showAllMessages();
                showAnotherChat(chats, chatArrayList);
            }
    }

    public static void addChat( ){
        Account opponent;

        if (network.getIdList().size()<2){
            System.err.println("К сожалению, разговаривать особо нескем, потому что вы - единственный человек в соцсети.");
            System.err.println("Создайте собеседников");
            generateAccount(); 
            return;
        }

        do {
            opponent = network.getAccountById(network.getIdList().get(new Random().nextInt(network.getIdList().size() - 1) + 1));

        } while (!(!(account == opponent) & !account.getId().equals(opponent.getId())));

        System.out.println("В качестве аппонента вам был выбран "+
                opponent.getId()+ " "+
                opponent.getPerson().getFirstName()+" "+
                opponent.getPerson().getMidName()+" "+
                opponent.getPerson().getLastName()+".");
        System.out.println("1) Написать сообщение");
        System.out.println("2) Заблокировать оппонента");
        System.out.println("3) Заблокировать себя у оппонента");
        System.out.println("4) Закончить составлять никому не нужные диалоги с пользователем и заняться более важными делами");

        int option;
        String temp;

        do {
            temp = scanner.nextLine();

            if (isNumber(temp)) {
                option = Integer.parseInt(temp);
            } else {
                System.err.println("Цифры. Используйте цифры.");
                continue;
            }

            switch (option) {
                case 1: {
                    sendMessage(opponent);
                    break;
                }
                case 2: {
                    //  addInBlockList(opponent.getId(), account.getId());
                    break;
                }
                case 3: {
                    //  addInBlockList(account.getId(), opponent.getId());
                    break;
                }
                case 4: {
                    System.exit(1);
                    break;
                }
                default: {
                    System.out.println("У вас почти получилось, попробуйте еще разок!");
                }
            }

        } while (true);
    }

    public static void sendMessage(Account opponent){
        System.out.println("Напечатайте сообщение");
        String temp = scanner.nextLine();

        account.getChat(opponent.getId()).addMessage(new Message(account.getId(), opponent.getId(), temp), true, false);
        System.out.println("Сообщение отправлено"); 
        showMyChats();
    }




    public static void deleteAcc(){
        System.out.println("Вы уверены, что хотите удалить аккаунт " +account.getId()+" "+ account.getPerson().getFirstName()+"?");
        System.out.println("1 - Да, 2 - Нет");
        int option;
        String temp;

        do {
            temp = scanner.nextLine();

            if (isNumber(temp)) {
                option = Integer.parseInt(temp);
            } else {
                System.err.println("Цифры. Используйте цифры.");
                continue;
            }

            switch (option) {
                case 1: {
                    network.deleteAccount(account.getId());
                    account = null;
                    stepOne();
                    break;
                }
                case 2: {
                    nextStep();
                    break;
                }
                default: {
                    System.out.println("У вас почти получилось, попробуйте еще разок!");
                }
            }
        } while (true);
    }

}
