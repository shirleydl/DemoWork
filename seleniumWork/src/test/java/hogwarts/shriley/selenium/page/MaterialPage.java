package hogwarts.shriley.selenium.page;

import org.openqa.selenium.By;

/**
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 371683941@qq.com
* @date 2019年12月12日 下午1:10:15
*/
public class MaterialPage extends Base {
	public void addMpnews(String title,String content,String filePath) throws InterruptedException {
		findElement(By.partialLinkText("图文")).click();
		findElement(By.linkText("添加图文")).click();

		driver.switchTo().frame(findElement(By.xpath("//*[contains(@class,'edui-editor-iframeholder')]/iframe")));
		findElement(By.cssSelector(".msg_mpNewsEditor_frameBody")).sendKeys(content);
        driver.switchTo().defaultContent();
        
		findElements(By.cssSelector(".ww_editorTitle")).get(0).sendKeys(title);
//        ((JavascriptExecutor)(driver)).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        findElement(By.cssSelector(".msg_infoItem_coverPlaceHolder_add")).click();

        findElement(By.xpath("//*[contains(@class,'cropper_noImage')]//input"),0).sendKeys(filePath);
        findElement(By.linkText("确定")).click();
		waitInvisibility(By.cssSelector(".js_dialog_mask"),5);

		findElements(By.linkText("完成")).get(0).click();
//		findElement(By.xpath("//*[contains(@class,'js_mpNews_editor_wrap')]/div[7]/a")).click();

	}

}
