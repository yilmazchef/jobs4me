package be.intec.views;


import be.intec.services.flow.AnswersService;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route("")
@PWA(name = "Jobs Portal which does not hide salary information.", shortName = "jobs4me" )
@CssImport("./styles/shared-styles.css")
public class MainView extends VerticalLayout {

    private final AnswersService service;

    public MainView() {

        this.service = new AnswersService();

        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");

    }
}
