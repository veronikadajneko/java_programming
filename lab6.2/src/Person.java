import org.json.JSONObject;

import java.util.List;

class Person {
    private String guid;
    private String email;
    private String birthday;
    private String first;
    private String last;
    private String gender;
    private String city;
    private String state;

    void readJSON(String input) {
        JSONObject json = new JSONObject(input);
        birthday = json.getString("birthday");
        last = json.getString("last");
        gender = json.getString("gender");
        city = json.getString("city");
        guid = json.getString("guid");
        state = json.getString("state");
        email = json.getString("email");
        first = json.getString("first");
    }

    void readCSV(List<String> list) {
        var iterator = list.iterator();
        guid = iterator.next();
        email = iterator.next();
        birthday = iterator.next();
        first = iterator.next();
        last = iterator.next();
        gender = iterator.next();
        city = iterator.next();
        state = iterator.next();
    }

    Person() {
        this.guid = null;
        this.email = null;
        this.birthday = null;
        this.first = null;
        this.last = null;
        this.gender = null;
        this.city = null;
        this.state = null;

    }

    public String toString() {
        return this.guid + " " + this.email + "\t" + this.birthday + "\t" + this.first + "\t" + this.last + "\t" + this.gender + "\t" + this.city + "\t" + this.state;
    }

    String getState() {
        return this.state;
    }
    Integer getAge(){
        int ageYear = 0;
        String ageYearStr = birthday.substring(birthday.length()-4);
        if(!ageYearStr.equalsIgnoreCase("hday")){
            ageYear = Integer.parseInt((ageYearStr));
        }
        int age;
        return (age = 2019-ageYear);
    }
}
