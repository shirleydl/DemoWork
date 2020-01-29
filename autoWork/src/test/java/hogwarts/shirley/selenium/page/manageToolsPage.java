package hogwarts.shirley.selenium.page;

import org.openqa.selenium.By;

/**
 * @author 371683941@qq.com
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2019年12月12日 下午1:07:55
 */
public class manageToolsPage extends Base {
    public MaterialPage toMaterial() {
        findElement(By.cssSelector(".ww_icon_AppMaterialBig")).click();
        return new MaterialPage();
    }
}
