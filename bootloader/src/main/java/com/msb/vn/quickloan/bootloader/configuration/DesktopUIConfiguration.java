package com.msb.vn.quickloan.bootloader.configuration;

import layout.adapter.AuthFXMLAdapter;
import layout.adapter.DashboardFXMLAdapter;
import layout.port.AuthFXMLPort;
import layout.port.DashboardFXMLPort;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DesktopUIConfiguration {
  @Bean(name = "authFXML")
  AuthFXMLPort initAuthFXML(@Qualifier(value = "fxWeaver") FxWeaver fxWeaver) {
    return new AuthFXMLAdapter(fxWeaver);
  }

  @Bean(name = "dashboardFXML")
  DashboardFXMLPort initDashboardFXML(@Qualifier(value = "fxWeaver") FxWeaver fxWeaver) {
    return new DashboardFXMLAdapter(fxWeaver);
  }
}
