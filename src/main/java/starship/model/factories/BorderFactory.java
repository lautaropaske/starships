package starship.model.factories;

import starship.base.main.ObjectManager;
import starship.view.Border;

public class BorderFactory {

    private ObjectManager om;

    public BorderFactory(ObjectManager om){
        this.om = om;
    }

    public Border createBorder(){
        Border border = new Border(om.getScreenX(), om.getScreenY());
        om.addDrawable(border);
        return border;
    }
}
