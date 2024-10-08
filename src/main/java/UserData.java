public class UserData {
    public static User defaultUserData() {
        return new User("test", "test@test.ru", "123qqq");
    }
    public static User defaultUserLogin() {
        return new User("test@test.ru","123qqq");
    }
    public static User userDataIncorrectPassword() {
        return new User("test", "test@test.ru", "000");
    }
    public static User userDataNullName() {
        return new User(null, "test.ru", "1123qqq");
    }
    public static User userDataNullEmail() {
        return new User("test", null, "123qqq");
    }
    public static User userDataNullPassword() {
        return new User("test", "test@test.ru", null);
    }
}
