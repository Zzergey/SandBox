package second_semester.diving.models;

import second_semester.diving.models.participant.Judge;
import second_semester.diving.models.participant.Jumper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompetitionManager {

    private Competition competition;
    private HashMap<Jumper, String> jumpers;
    private ArrayList<Judge> judges;
    private boolean fileExist = false;
    private int jumpCount;
    private final Scanner scanner = new Scanner(System.in);

    public CompetitionManager() {
        setEntry();
    }

    private int check(String temp){
        int x = 0;
        try {
            x = Integer.parseInt(temp);
        } catch (NumberFormatException ignored){ }
        return x;
    }

    private void setEntry(){
        int jump, jud;
        checkWD();

        printEmpty(2).printStarLine(1);
        System.out.println("Для начала соревнований необходимо зарегистрировать участников и судей");
        printStarLine(1);
        jump = setJumpers();
        jud = setJudges();

        competition = new Competition(jump, jud);
        System.out.println("-создание судей-");
        System.out.println("-создание спортсменов-");
        System.out.println();
        jumpers = competition.getJumpers();
        judges = competition.getJudges();


        int x;
        do {
            System.out.println("Минимальная оценка 1 балл, максимальная 10. Вы хотите изменить бальную систему?");
            System.out.println("1) Да");
            System.out.println("2) Нет");
            System.out.println("**С иной бальной системой результаты не будут реалестичными");
            x = check(scanner.nextLine());
        }while (x<=0 | x > 2);
        if (x==1){
            setJudgesMinMaxRate();
        }



        do {
            System.out.println("Каждый участник выступает по 3 разa, изменить количество прыжков?");
            System.out.println("1) Да");
            System.out.println("2) Нет");
            x = check(scanner.nextLine());
        }while (x<=0 | x > 2);
        if (x==1){
            changeJumpCount();
        }



        printEmpty(2).printStarLine(1);
        System.out.println("Регистрация прошла успешно! Добро пожаловать на соревнования по прыжкам в воду");
        printStarLine(1).printEmpty(2);
        letsStart();
    }

    private int setJumpers(){
        int x;

        do {
            System.out.println("Введите количество спортсменов:");
            x = check(scanner.nextLine());

            if (x == 0){
                System.err.println("Попробуйте снова");
            }
        } while (x <= 0);

        return x;
    }

    private int setJudges(){
        int x;

        do {
            System.out.println("Введите количество судей:");
            x = check(scanner.nextLine());

            if (x == 0){
                System.err.println("Попробуйте снова");
            }
        } while (x <= 0);

        return x;
    }

    private void setJudgesMinMaxRate(){
        int a,b;

        do {

            System.err.println("Минимальная оценка не может быть меньше единицы, а максимальная не может быть равна минимальной.");

            System.out.println("Введите минимальный балл:");
            a = check(scanner.nextLine());

            System.out.println("Введите максимальный балл:");
            b = check(scanner.nextLine());

            if (a <= 0 || b <= 0 || b <= a){
                System.err.println("Вы указали не корректные данные. Попробуйте снова");
            }
        } while (a <= 0 || b <= 0 || b <= a);

        competition.setMinRate(a);
        competition.setMaxRate(b);
    }

    private void changeJumpCount(){
        int x;

        do {
            System.out.println("Введите количество прыжков:");
            x = check(scanner.nextLine());

            if (x == 0){
                System.err.println("Попробуйте снова");
            }
        } while (x <= 0);

        competition.setJumpCount(x);
        this.jumpCount = x;
    }

    private void letsStart(){
        int x;

        do {
            System.out.println("Доступные действия :");
            System.out.println("1) Вывести список спортсменов");
            System.out.println("2) Вывести список судей");
            System.out.println("3) Начать соревнования");
            x = check(scanner.nextLine());

            if (x <= 0 | x > 3){
                System.err.println("Попробуйте снова");
            }
        } while (x <= 0 | x > 3);

        if (x==1){  showJumpers();  }
        if (x==2){  showJugdes();  }
        if (x==3){  startCompetition();  }

    }

    private void showJumpers(){
        String s;
        printEmpty(2).printStarLine(2);
        System.out.println("                 Состав участников сегодняшних соревнований: ");
        printStarLine(1);
        for ( Map.Entry<Jumper, String> jumper : jumpers.entrySet() ) {
            s = jumper.getValue() == null? ", пока не выступал": ", уже выступал, имеются оценки.";
            System.out.println("Участник № "
                    +jumper.getKey().getId() + ", "+
                    jumper.getKey().getName() + s);
        }

        printStarLine(1).printEmpty(2);
        letsStart();
    }

    private void showJugdes(){
        printEmpty(2).printStarLine(1);
        System.out.println("                      В судебной комиссии присутсвуют: ");
        printStarLine(1);
        for ( Judge judge : judges ) {
            System.out.println("Судья: " + judge.getName());
        }

        printStarLine(1).printEmpty(2);
        letsStart();
    }

    private void startCompetition(){
        afterCompetition(competition.beginCompetition(jumpCount));
        printEmpty(2).printStarLine(2);

    }

    private void afterCompetition(int jc){
        if (jc != -1) {
            writeResult();
        }
        printEmpty(1);
        int x;

        do {
            System.out.println("1) Посмотреть результаты этапов соревнования");
            System.out.println("2) Провести новые соревнования");
            System.out.println("3) Закончить соревнования");
            x = check(scanner.nextLine());

            if (x == 0){
                System.err.println("Попробуйте снова");
            }
        } while (x <= 0 | x > 3);

        if (x==1){  showLastResults();   }
        if (x==2){  startCompetition();  }
        if (x==3){  System.exit(0);  }

    }

    private void showLastResults() {
        if(!fileExist){
            System.out.println("Соревнований не проводилось");
            afterCompetition(0);
        }

        try {
            File file = new File("c:\\DC\\results.comp");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                System.out.println(sc.nextLine());

            }catch (FileNotFoundException ignored){}

            afterCompetition(-1);
    }

    private CompetitionManager printStarLine(int count){
        for (int i = 0; i < count; i++) {
            System.out.println("******************************************************************************");
        }
        return this;
    }
    private CompetitionManager printEmpty(int count){
        for (int i = 0; i < count; i++) {
            System.out.println();
        }
        return this;
    }

    private void checkWD(){
        File f = new File("c:\\DC\\");
        if (!f.exists()){
            if(!f.mkdir()){
                System.out.println("Невозможно создать директорию для записи результатов: "+ "c:\\DC\\");
            }
        }

        f = new File("c:\\DC\\results.comp");
        if(f.exists()){
            f.delete();
        }
    }

    private void writeResult() {
        File f = new File("c:\\DC\\results.comp");
        StringBuilder stringBuilder;
        ArrayList<String> as = new ArrayList<>();
        int x = 0;

        if (f.exists()) {
            try {
                File file = new File("c:\\DC\\results.comp");
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine())
                    as.add(sc.nextLine());

            } catch (FileNotFoundException ignored) {
            }
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f ));

            for (Map.Entry<Jumper, String> jItem : jumpers.entrySet()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Участник: ").
                        append(jItem.getKey().getName()).
                        append(", оценки: ").
                        append(jItem.getValue());

                if (as.size()>0){
                    writer.write(as.get(x)+", "+jItem.getValue()+"\n");
                    x++;
                } else
                writer.write(stringBuilder.toString()+"\n");
            }

            writer.close();
            fileExist = true;
        } catch (FileNotFoundException ignored) { }
          catch (IOException ignored) {
            System.err.println("-----НЕВОЗМОЖНО ПРОИЗВЕСТИ ЗАПИСЬ В ФАЙЛ-----");
        }

    }
}
