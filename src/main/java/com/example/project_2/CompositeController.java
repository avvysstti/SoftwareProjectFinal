package com.example.project_2;

import java.util.ArrayList;
import java.util.List;

public class CompositeController implements BaseController {
    private List<BaseController> controllers = new ArrayList<>();

    public void addController(BaseController controller) {
        controllers.add(controller);
    }

    @Override
    public void setHomeButtonAction() {
        for (BaseController controller : controllers) {
            controller.setHomeButtonAction();
        }
    }
}
