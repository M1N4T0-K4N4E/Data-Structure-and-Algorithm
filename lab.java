import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class lab {
    private String uName;
    private String passwd;
    private String saltVal;
    private Date regisDate;
    private Type type;

    lab(String n, String pw) {
        regisDate = new Date();
        uName = n;
        passwd = hashing(passwd);
        
    }

    private String hashing(String pass) {
        setType();
        String tmp = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 

        if (getType() == Type.DATE) {
            saltVal = byteArrayToHexString(md.digest(regisDate.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8)));
            tmp = pass + saltVal;
            
        } else if (getType() == Type.UNAME) {
            saltVal = byteArrayToHexString(md.digest(uName.getBytes(java.nio.charset.StandardCharsets.UTF_8)));
            tmp = pass + byteArrayToHexString(md.digest(uName.getBytes(java.nio.charset.StandardCharsets.UTF_8)));
        }

        return  byteArrayToHexString(md.digest(tmp.getBytes(java.nio.charset.StandardCharsets.UTF_8)));
    }

    private String byteArrayToHexString(byte[] b) {
        String result = "";
        for (int i=0; i < b.length; i++) {
          result +=
                Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

    private void setType() {
        this.type = Math.random() > 0.5 ? Type.DATE : Type.UNAME;
    }

    private Type getType() {
        return type;
    }

    private String getUName() {
        return uName;
    }

    private String getPasswd() {
        return passwd;
    }

    private String getSaltVal() {
        return saltVal;
    }
    
    @Override
    public String toString() {
        return String.format("User name: %s\nSalting Pass word: %s\nsalt string: %s\n",
                             getUName(), getPasswd(), getSaltVal());
    }

    public static void main(String[] args) throws InterruptedException {
        lab u1 = new lab("boby", "thisIsPassWord");
        Thread.sleep(1000);
        lab u2 = new lab("boby", "thisIsPassWord");
        Thread.sleep(1000);
        lab u3 = new lab("boby", "thisIsPassWord");
        System.out.println(u1.toString());
        System.out.println(u2.toString());
        System.out.println(u3.toString());
    }
}   

enum Type {
    DATE, UNAME
}