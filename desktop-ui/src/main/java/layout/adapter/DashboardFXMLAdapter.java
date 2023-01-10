package layout.adapter;

import layout.port.DashboardFXMLPort;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView
@Slf4j
public class DashboardFXMLAdapter implements DashboardFXMLPort {
  final FxWeaver fxWeaver;
  private Stage stage;
  @FXML private AnchorPane anchorPane;

  public DashboardFXMLAdapter(FxWeaver fxWeaver) {
    this.fxWeaver = fxWeaver;
  }

  @FXML
  public void initialize() {
    log.info("initialize dashboard !!!!");
    this.stage = new Stage();
    stage.setScene(new Scene(anchorPane));
  }

  public void show() {
    log.info("show dashboard screen !!!");
    stage.show();
  }
}
