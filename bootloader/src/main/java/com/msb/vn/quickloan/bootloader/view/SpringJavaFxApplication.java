package com.msb.vn.quickloan.bootloader.view;

import com.msb.vn.quickloan.bootloader.QuickLoanDesktopApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringJavaFxApplication extends Application {
  private ConfigurableApplicationContext context;

  @Override
  public void init() throws Exception {
    this.context =
        new SpringApplicationBuilder()
            .sources(QuickLoanDesktopApplication.class)
            .run(getParameters().getRaw().toArray(new String[0]));
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    context.publishEvent(new StageReadyEvent(primaryStage));
  }

  @Override
  public void stop() throws Exception {
    this.context.close();
    Platform.exit();
  }
}
