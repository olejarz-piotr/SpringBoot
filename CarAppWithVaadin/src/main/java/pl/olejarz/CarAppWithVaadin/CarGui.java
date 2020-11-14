package pl.olejarz.CarAppWithVaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route
public class CarGui extends VerticalLayout {

    private TextField textFieldId;
    private TextField textFieldMark;
    private TextField textFieldModel;
    private TextField textFieldColor;
    private Button button;

    private CarDao carDao;

    @Autowired
    public CarGui(CarDao carDao) {
        this.textFieldId = new TextField("ID");
        this.textFieldMark = new TextField("Mark");
        this.textFieldModel = new TextField("Model");
        this.textFieldColor = new TextField("Color");
        this.button = new Button("Add");
        this.carDao = carDao;

        button.addClickListener(buttonClickEvent -> {
            Car car = new Car(Integer.parseInt(textFieldId.getValue()),textFieldMark.getValue(), textFieldModel.getValue(),textFieldColor.getValue());
       carDao.save(car);
        });
        add(textFieldId, textFieldMark, textFieldModel, textFieldColor, button);
    }
}
