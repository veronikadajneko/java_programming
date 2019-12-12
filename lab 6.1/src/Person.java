import org.json.JSONObject;

import java.util.List;
import java.util.Scanner;

class Person {
    private String guid;
    private String email;
    private String birthday;
    private String firstN;
    private String lastN;
    private String gender;
    private String city;
    private String state;

    void readJSON(String input) {
        JSONObject json = new JSONObject(input);
        birthday = json.getString("birthday");
        lastN = json.getString("last");
        gender = json.getString("gender");
        city = json.getString("city");
        guid = json.getString("guid");
        state = json.getString("state");
        email = json.getString("email");
        firstN = json.getString("first");
    }

    void readCSV(List<String> list){
        var iterator = list.iterator();
        guid = iterator.next();
        email = iterator.next();
        birthday = iterator.next();
        firstN = iterator.next();
        lastN = iterator.next();
        gender = iterator.next();
        city = iterator.next();
        state = iterator.next();
    }
    public String toString(){
        return this.guid + " " +  this.email + "\t" + this.birthday + "\t" + this.firstN + "\t" + this.lastN + "\t" + this.gender + "\t" + this.city + "\t" + this.state;
    }

    String getState(){
        return this.state;
    }

    public Integer GetAge() {
        int ageYear = 0;
        String ageYearStr = birthday.substring(birthday.length()-4);
        if (!ageYearStr.equalsIgnoreCase("hday")) {
            ageYear = Integer.parseInt(ageYearStr);
        }
        int age = 2019 - ageYear;

        return age;
    }
}
