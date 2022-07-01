import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UserData {
    String username;
    String password;
    String email;
    String description;
    String[] userdata;

    public String[] GetUserData () throws Exception
    {
        try {
            List<String> allData = Files.readAllLines(Paths.get("src/main/resources/userdata.txt"));
            username = allData.get(0).replace("username: ","");
            password = allData.get(1).replace("password: ","");
            email = allData.get(2).replace("email: ","");
            description = allData.get(3).replace("description: ","");
            userdata = new String[]{username, password, email, description};
        }
        catch (Exception e){}
        return userdata;
    }
}
