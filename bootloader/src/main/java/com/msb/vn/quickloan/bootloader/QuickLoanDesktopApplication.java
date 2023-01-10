package com.msb.vn.quickloan.bootloader;

import com.msb.vn.quickloan.bootloader.view.SpringJavaFxApplication;
import javafx.application.Application;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuickLoanDesktopApplication {

  public static void main(String[] args) {
    Application.launch(SpringJavaFxApplication.class, args);
  }

  @Bean(name = "fxWeaver")
  public FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext) {
    return new SpringFxWeaver(applicationContext);
  }
}
