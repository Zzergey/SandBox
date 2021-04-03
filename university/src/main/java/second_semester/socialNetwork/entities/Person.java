package second_semester.socialNetwork.entities;

public class Person {

    private String firstName;
    private String midName;
    private String lastName;
    private int age;
    private String sex;

    private String phoneNumber; //выбор String обоснован тем, что сложные номера со скобками и знаками "+"
                                //проще всего хранить именно в этом типе
    private String city;
    private String eMail;

    public Person() {
    }

    public void resetData(String firstName, String midName, String lastName, int age, String sex, String phoneNumber, String city, String eMail) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.eMail = eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String sity) {
        this.city = sity;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Пользователь: " +
                "имя='" + firstName + '\'' +
                ", отчество='" + midName + '\'' +
                ", фамилия='" + lastName + '\'' +
                ", возраст=" + age +
                ", пол='" + sex + '\'' +
                ", телефон='" + phoneNumber + '\'' +
                ", город='" + city + '\'' +
                ", eMail='" + eMail + '\''
                ;
    }
}
