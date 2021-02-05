package main.java.testjavafound.annotation;

import java.util.List;

public class TestAnnotation {
    public void execute(){
        System.out.println("Executing,,,");
    }

    @Test01 void testExecute(){
        execute();
    }


    @UserCase(id = 22,description = "cc")
    public boolean validatePassword(String password){
        return (password.matches("jjjj"));
    }

    @UserCase(id = 7)
    public String encryptPassword(String password){
        return new StringBuffer(password).reverse().toString();
    }

    @UserCase(id = 9)
    public boolean checkForNewPassword(List<String> prevPasswords,String password){
        return !prevPasswords.contains(password);
    }

}
