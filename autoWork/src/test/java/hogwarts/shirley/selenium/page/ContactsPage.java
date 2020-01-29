package hogwarts.shirley.selenium.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 371683941@qq.com
 * @date 2019年12月11日 下午5:12:26
 */
public class ContactsPage extends Base {
	private void beforeWait(){
		waitInvisibility(By.cssSelector(".js_dialog_mask"),5);
	}

	private void scrollIntoView(WebElement findElement){
		((JavascriptExecutor)(driver)).executeScript("arguments[0].scrollIntoView();",findElement);
	}

	private void scrollIntoViewClick(WebElement findElement){
		try {
			scrollIntoView(findElement);
			Thread.sleep(1000);//放弃挣扎的我，滚动条刚好挡住按钮！！！
			findElement.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void scrollIntoViewSendKeys(WebElement findElement,String str){
		scrollIntoView(findElement);
		findElement.sendKeys(str);
	}

	public ContactsPage addDepartment(String depName, String belongDep) {
		beforeWait();
		findElement(By.cssSelector(".member_colLeft_top_addBtn")).click();
		findElement(By.linkText("添加部门")).click();
		findElement(By.name("name")).sendKeys(depName);
		findElement(By.linkText("选择所属部门")).click();
		findElements(By.linkText(belongDep)).get(1).click();
		findElement(By.linkText("确定")).click();
		return this;
	}

	public ContactsPage searchDep(String depName) {
		beforeWait();
		scrollIntoViewSendKeys(findElement(By.cssSelector(".ww_searchInput_text")),depName);
		findElement(By.linkText(depName)).click();
		return this;
	}
	public ContactsPage searchClear() {
		beforeWait();
		scrollIntoView(findElement(By.cssSelector(".ww_searchInput_text")));
		findElement(By.cssSelector(".ww_searchInput_text")).clear();
		return this;
	}
	public ContactsPage moveDepartment(String depName) {
		beforeWait();
		findElement(By.linkText(depName)).click();
		scrollIntoViewClick(findElement(By.xpath("//*[contains(@class,'jstree-clicked')]/span")));
		findElement(By.linkText("上移")).click();
		return this;
	}

	public ContactsPage delDepartmentNotChild(String depName) {
		beforeWait();
		findElement(By.linkText(depName)).click();
		scrollIntoViewClick(findElement(By.xpath("//*[text()='"+depName+"']/span")));
		findElement(By.linkText("删除")).click();
		findElement(By.linkText("确定")).click();
		return this;

	}

	public ContactsPage editDepartment(String depName, String newDepName){
		beforeWait();
		findElement(By.linkText(depName)).click();
		scrollIntoViewClick(findElement(By.xpath("//*[contains(@class,'jstree-clicked')]/span")));
		findElement(By.linkText("修改名称")).click();
		findElement(By.cssSelector(".js_rename_input")).clear();
		findElement(By.cssSelector(".js_rename_input")).sendKeys(newDepName);
		findElement(By.linkText("保存")).click();
		return this;
	}

	public List<String> getDepartmentList(){
		List<String> departmentList=new ArrayList<>();
//		findElements(By.xpath("//*[contains(@class,'ww_searchResult_item_Curr')]/a")).forEach(element-> departmentList.add(element.getText()));
		findElements(By.cssSelector(".ww_searchResult_item_Curr")).forEach(element-> departmentList.add(element.getText()));
	    return departmentList;
    }

}
