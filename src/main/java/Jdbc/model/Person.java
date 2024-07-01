package Jdbc.model;

public class Person {
    private int User_id;
    private String User_name;
    private String User_email;
        public Person(){}
        public Person(String user_name, String user_email) {
            this.User_name = user_name;
            this.User_email = user_email;
        }
    // Getters
    public int getUser_id() {return User_id;}
    public String getUser_name() {return User_name;}
    public String getUser_email() {return User_email;}
    // Setters
    public void setUser_id(int User_id_parametro) {User_id = User_id_parametro;}
    public void setUser_name(String user_name_parametro) {User_name = user_name_parametro;}
    public void setUser_email(String user_email_parametro) {User_email = user_email_parametro;}
    // To String
    @Override
    public String toString(){ return
            "Nome de usuario" + " " + getUser_name() + "\n" +
            "Endereco de E-mail" + " " + getUser_email();}
}
