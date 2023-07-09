package tools;

public class NumberTools {

    public static Integer convertStringToInt(String str){
        try{
            Integer ageInt = Integer.parseInt(str);
            if(ageInt <0){
                return  null;
            }
           return ageInt;

        } catch (NumberFormatException ignored){
            return  null;
        }

    }



}
