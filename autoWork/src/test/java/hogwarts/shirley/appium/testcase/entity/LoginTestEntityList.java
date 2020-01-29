package hogwarts.shirley.appium.testcase.entity;

import java.util.List;

/**
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 371683941@qq.com
* @date 2019年12月24日 下午4:28:43
*/
public class LoginTestEntityList {
	private List<LoginTestEntity> loginByPwdData;
	private List<LoginTestEntity> loginByCodeData;

	public List<LoginTestEntity> getLoginByPwdData() {
		return loginByPwdData;
	}

	public void setLoginByPwdData(List<LoginTestEntity> loginByPwdData) {
		this.loginByPwdData = loginByPwdData;
	}

	public List<LoginTestEntity> getLoginByCodeData() {
		return loginByCodeData;
	}

	public void setLoginByCodeData(List<LoginTestEntity> loginByCodeData) {
		this.loginByCodeData = loginByCodeData;
	}
}
