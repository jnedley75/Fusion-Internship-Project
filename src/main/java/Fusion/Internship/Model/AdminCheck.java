package Fusion.Internship.Model;

public class AdminCheck {

    private boolean check;
    private int loginID;

    public void setAdminCheck(boolean adminCheck) {
        this.check = adminCheck;
    }

    public boolean getAdminCheck() {
        return check;
    }

    public void setLoginID(int loginID) { this.loginID = loginID; }

    public int getLoginID() { return loginID; }

}
