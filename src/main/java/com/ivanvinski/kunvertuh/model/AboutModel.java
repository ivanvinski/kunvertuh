package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.util.Browser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

public class AboutModel {

  private final Browser browser;

  private final String name = "Kunvertuh";
  private final String version = "0.1.0";
  private final String license = "GPL v3.0";
  private final String licenseText;

  private final String developer = "Ivan Vinski";
  private final String developerWebsite = "https://ivanvinski.com/";
  private final String developerGithub = "https://github.com/ivanvinski";

  private final String repositoryUri = "https://github.com/ivanvinski/kunvertuh";
  private final String apacheLicenseUri = "https://www.apache.org/licenses/LICENSE-2.0.html";
  private final String jfoenixUri = "http://jfoenix.com/";
  private final String fontAwesomeFxUri = "https://bitbucket.org/Jerady/fontawesomefx";
  private final String guavaUri = "https://github.com/google/guava";

  public AboutModel(Browser browser) {
    this.browser = browser;
    licenseText = readLicenseFile();
  }

  public void browse(String uri) {
    browser.open(uri);
  }

  public String getName() {
    return name;
  }

  public String getVersion() {
    return version;
  }

  public String getLicense() {
    return license;
  }

  public String getLicenseText() {
    return licenseText;
  }

  public String getDeveloper() {
    return developer;
  }

  public String getDeveloperWebsite() {
    return developerWebsite;
  }

  public String getDeveloperGithub() {
    return developerGithub;
  }

  public String getRepositoryUri() {
    return repositoryUri;
  }

  public String getApacheLicenseUri() {
    return apacheLicenseUri;
  }

  public String getJfoenixUri() {
    return jfoenixUri;
  }

  public String getFontAwesomeFxUri() {
    return fontAwesomeFxUri;
  }

  public String getGuavaUri() {
    return guavaUri;
  }

  private String readLicenseFile() {
    StringBuilder license = new StringBuilder();
    InputStream projectLicense = getClass().getResourceAsStream("/kunvertuh-license.txt");
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(projectLicense))) {
      String line;
      while ((line = reader.readLine()) != null) {
        license.append(line);
        license.append(System.lineSeparator());
      }
    } catch (IOException e) {
      throw new UncheckedIOException("Reading license file error", e);
    }
    return license.toString();
  }
}
