package hogwarts.shirley.appium.testcase.entity;
/**
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 371683941@qq.com
* @date 2019年12月24日 下午4:56:19
*/
public class LoginTestEntity {
	private String account;
	private String pwd;
	private String content;
	private String[] contents;
	private String phone;
	private String code;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = (null!=account)?account:"";
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String[] getContents() {
		return contents;
	}

	public void setContents(String[] contents) {
		this.contents = contents;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
