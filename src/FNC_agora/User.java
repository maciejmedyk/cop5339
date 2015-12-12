package FNC_agora;

import java.io.Serializable;

/**
 *
 * @author Maciej Medyk and Caio Farias
 */
public class User implements Serializable
{
    public User(String name, String email, String username, String password, String date)
    {
        mName = name;
        mEmail = email;
        mUsername = username;
        mPassword = password;
        mDate = date;
    }
    
    public String getUsername()
    {
        return mUsername;
    }
    
    public String getPassword()
    {
        return mPassword;
    }
    
    public String getEmail()
    {
        return mEmail;
    }
    
    public String getDateOfBirth()
    {
        return mDate;
    }
    
    public String getFullName()
    {
        return mName;
    }

    public void setPassword(String pass)
    {
        mPassword = pass;
    }
    
    private String mName;
    private String mEmail;
    private String mUsername;
    private String mPassword;
    private String mDate;
}
