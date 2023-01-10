package layout.adapter;

import layout.port.AuthFXMLPort;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView
@Slf4j
public class AuthFXMLAdapter implements AuthFXMLPort {
  final FxWeaver fxWeaver;
  @FXML private TextField userName;
  @FXML private PasswordField password;
  @FXML private Button loginButton;

  public AuthFXMLAdapter(FxWeaver fxWeaver) {
    this.fxWeaver = fxWeaver;
  }

  @FXML
  public void initialize() {
    log.info("initial auth screen !!!");
    loginButton.setOnAction(
        actionEvent -> {
          log.info("actionEvent: {}", actionEvent.getEventType().getName());
          log.info("user: {}", userName.getText());
          log.info("password: {}", password.getText());
          FxControllerAndView<DashboardFXMLAdapter, AnchorPane> dashboard =
              fxWeaver.loadView(DashboardFXMLAdapter.class);
          dashboard
              .getView()
              .ifPresent(
                  anchorPane -> {
                    Label label = new Label();
                    label.setText("Dynamically added Label");
                    anchorPane.getChildren().add(label);
                  });
          dashboard.getController().show();
        });
  }
}
