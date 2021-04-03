package second_semester.diving.models;
import second_semester.diving.models.participant.Judge;
import second_semester.diving.models.participant.Jumper;

import java.util.*;

public class Competition {

    private final HashMap<Jumper, String> jumpers = new HashMap<>();
    private final ArrayList<Judge> judges = new ArrayList<>();
    private int maxRate;
    private int minRate;
    private int jumpCount=3;
    private final Competition competition = this;

    public HashMap<Jumper, String> getJumpers() {
        return jumpers;
    }

    public ArrayList<Judge> getJudges() {
        return judges;
    }

    public Competition(int jumpersNum, int judgesNum) {
        registrationOfRepresentatives(jumpersNum, judgesNum);
    }

    private void registrationOfRepresentatives(int jumpersNum, int judgesNum){

        for (int i = 0; i < judgesNum; i++) {
            judges.add(new Judge(getName()));
        }

        for (int i = 0; i < jumpersNum; i++) {
            jumpers.put(new Jumper(getName(), i), null);
        }
    }

    private String getName(){
        String[] mNames = {"Августин", "Авраам","Аристарх", "Аркадий", "Арсен", "Арсений", "Артем", "Артемий", "Артур", "Архип",            "Болеслав", "Борис", "Борислав", "Бронислав", "Бронислава", "Булат", "Вадим", "Валентин", "Валентина",            "Валерий", "Викентий", "Виктор", "Бенедикт", "Виталий", "Влад", "Владимир", "Владислав", "Владлен",            "Вольдемар", "Всеволод", "Вячеслав", "Евгений", "Евдоким", "Ефим", "Ефрем", "Даниил", "Демьян", "Денис",            "Джеймс", "Джек",  "Дмитрий", "Добрыня",  "Игнатий", "Игорь", "Иннокентий", "Иосиф", "Касьян", "Ким","Кир", "Клим", "Климент", "Кондрат", "Константин", "Лев", "Леон", "Леонид", "Леонтий", "Макар", "Максим","Марат", "Дмитрий","Михаил","Альберт","Сергей","Афонасий","Петр","Зиновий","Павел","Карл","Максим","Альфред","Александр","Валерий","Вячеслав","Константин","Анатолий","Егор","Кащей","Иван","Добрыня","Никита"};
        String[] mLast = {"Смирнов","Иванов","Кузнецов","Соколов","Попов","Лебедев","Козлов","Новиков","Морозов","Петров","Волков","Соловьёв","Васильев",            "Зайцев","Павлов","Семёнов","Голубев","Виноградов","Богданов","Воробьёв","Фёдоров","Михайлов",            "Беляев","Тарасов","Белов","Комаров","Орлов","Киселёв","Макаров","Андреев","Ковалёв","Ильин",            "Гусев","Титов","Кузьмин","Кудрявцев","Баранов","Куликов","Алексеев","Степанов","Яковлев","Сорокин",            "Сергеев","Романов","Захаров","Борисов","Королёв","Герасимов","Пономарёв","Григорьев","Лазарев",            "Медведев","Ершов","Никитин","Соболев","Рябов","Поляков","Цветков","Данилов","Жуков","Фролов",            "Журавлёв","Николаев","Крылов","Максимов","Сидоров","Осипов","Белоусов","Федотов","Дорофеев",            "Егоров","Матвеев","Бобров","Дмитриев","Калинин","Анисимов","Петухов","Антонов","Тимофеев",            "Никифоров","Веселов","Филиппов","Марков","Большаков","Суханов","Миронов","Ширяев","Александров",            "Коновалов","Шестаков","Казаков","Ефимов","Денисов","Громов","Фомин","Давыдов","Мельников",            "Щербаков","Блинов","Колесников","Карпов","Афанасьев","Власов","Маслов","Исаков","Тихонов",            "Аксёнов","Гаврилов","Родионов","Котов","Горбунов","Кудряшов","Быков","Зуев"};
        String[] fNames = {"Аврора", "Агата", "Агафон", "Агнесса", "Агния", "Ада", "Аделаида", "Аделина", "Акайо", "Акулина", "Алан",            "Алевтина", "Александр", "Александра", "Алена", "Алина", "Алиса", "Алла", "Алсу", "Альберт", "Альбина",            "Альфия", "Амалия", "Амелия", "Анастасия", "Ангелина", "Андрей", "Анжела", "Анжелика", "Анисий", "Анна",            "Антонина", "Анфиса", "Аполлинарий", "Ариадна", "Арина", "Ася", "Белла", "Берта", "Богдан", "Божена",            "Валерия", "Ванда", "Варвара", "Василий", "Василиса", "Венера", "Вера", "Вероника",  "Виктория", "Виолетта",            "Елена","Светлана","Роза","Людмила","Мария","Кристина","Фекла","Александра","Наталья","Татьяна","Соня",            "Екатерина","Ангелина","Любава","Прокофья","Валерьяна","Сара","Джессика","Авдотья","Агафья","Роза"};
        String[] fLast = {"Смирновa","Ивановa","Кузнецовa","Соколовa","Поповa","Лебедевa","Козловa","Новиковa","Морозовa","Петровa","Волковa","Соловьёвa","Васильевa",            "Зайцевa","Павловa","Семёновa","Голубевa","Виноградовa","Богдановa","Воробьёвa","Фёдоровa","Михайловa",            "Беляевa","Тарасовa","Беловa","Комаровa","Орловa","Киселёвa","Макаровa","Андреевa","Ковалёвa","Ильинa",            "Гусевa","Титовa","Кузьминa","Кудрявцевa","Барановa","Куликовa","Алексеевa","Степановa","Яковлевa","Сорокинa",            "Сергеевa","Романовa","Захаровa","Борисовa","Королёвa","Герасимовa","Пономарёвa","Григорьевa","Лазаревa",            "Медведевa","Ершовa","Никитинa","Соболевa","Рябовa","Поляковa","Цветковa","Даниловa","Жуковa","Фроловa",            "Журавлёвa","Николаевa","Крыловa","Максимовa","Сидоровa","Осиповa","Белоусовa","Федотовa","Дорофеевa", "Егоровa","Матвеевa","Бобровa","Дмитриевa","Калининa","Анисимовa","Петуховa","Антоновa","Тимофеевa",            "Никифоровa","Веселовa","Филипповa","Марковa","Большаковa","Сухановa","Мироновa","Ширяевa","Александровa",            "Коноваловa","Шестаковa","Казаковa","Ефимовa","Денисовa","Громовa","Фоминa","Давыдовa","Мельниковa",            "Щербаковa","Блиновa","Колесниковa","Карповa","Афанасьевa","Власовa","Масловa","Исаковa","Тихоновa",            "Аксёновa","Гавриловa","Родионовa","Котовa","Горбуновa","Кудряшовa"};

        StringBuilder newName = new StringBuilder();

         if ( new Random().nextInt(100) < 50){
                newName.append(mNames[new Random().nextInt(mNames.length)]).append(" ").append(mLast[new Random().nextInt(mLast.length)]);
            } else {
                newName.append(fNames[new Random().nextInt(fNames.length)]).append(" ").append(fLast[new Random().nextInt(fLast.length)]);
            }

        return newName.toString();
    }

    public int beginCompetition(int jc){
        if (jumpCount==0){
            System.err.println("Соревнования уже окончены");
            return -1;
        }

        jumpCount--;

        for ( Map.Entry<Jumper, String> jumper : jumpers.entrySet() ) {
            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.print("Выступает: "+ jumper.getKey().getId()+"-й участник соревнований " +jumper.getKey().getName());

            // чем больше волнение - тем хуже результаты. Хотя, как повезет :)
            String s = null, rep = null;
            int x = new Random().nextInt(9)+1;
            if (x >= 8){
                s = " сильное волнение!";
                rep = "Эх! Какой неудачный прыжок!";
            }
            if (x < 8 & x >= 4){
                s = " нервное напряжение!";
                rep = "Не плохо, но можно было и лучше!";
            }
            if (x <= 3){
                s = " абсолютное спокойствие!";
                rep = "И мы видим почти безупречный прыжок!";
            }
            System.out.print(", прыгающий в "+(jc==0?1:jc-jumpCount)+" раз! На лице видно"+s+"\n");
            System.out.println("-------------------------------------------------------");
            System.out.println(rep);
            System.out.println("-------------------------------------------------------");

            ArrayList<String> resultList = new ArrayList<>();

            for ( Judge judgeDay : judges ) {

                resultList.add(String.valueOf(judgeDay.doYourJob( jumper.getKey().doYourJob(x, competition),competition)));

                System.out.println("-- судья "+judgeDay.getName() +
                                " дает оценку прыжку: "+
                                resultList.get(resultList.size()-1));
            }

            jumpers.put(jumper.getKey(), String.valueOf(getMiddle(resultList)));
        }
        return jumpCount;
    }

    public String getMiddle(ArrayList<String> x) {
        double c = 0;
        int a=0,
            b=Integer.MAX_VALUE;

        for (String s: x) {
            c+=Integer.parseInt(s);
            a = Math.max(a, Integer.parseInt(s));
            b = Math.min(b, Integer.parseInt(s));
        }

        if(x.size()!=2){
           c = ((c-a)-b);
        }

        c=c/x.size();

        String nadoeloEtoVse = String.format("%.1f", c);
        if(x.size()!=2) {
            System.out.println("Минимальный балл: " + b + " (исключен из подсчета)");
            System.out.println("Максимальный балл: " + a + " (исключен из подсчета)");
        } else{
            System.out.println("Минимальный балл: " + b);
            System.out.println("Максимальный балл: " + a);
        }
        System.out.println("Средний балл: "+nadoeloEtoVse);

        return nadoeloEtoVse;
    }
    
    public int getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(int maxRate) {
        this.maxRate = maxRate;
    }

    public int getMinRate() {
        return minRate;
    }

    public void setMinRate(int minRate) {
        this.minRate = minRate;
    }

    public void setJumpCount(int jumpCount) {
        this.jumpCount = jumpCount;
    }

    public int getJumpCount() {
        return jumpCount;
    }
}
