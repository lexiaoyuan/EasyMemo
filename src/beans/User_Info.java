package beans;

public class User_Info {
	private String userAccount;
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public User_Info(){};
	public User_Info(String uAccount) {
		userAccount=uAccount;
	}
}
