package com.ivanvinski.kunvertuh.util;

import java.net.URI;
import java.net.URISyntaxException;

public class SoftwareBuilder {

  private String name, version, license;
  private URI website;

  public SoftwareBuilder(String name) {
    this.name = name;
  }

  public SoftwareBuilder setVersion(String version) {
    this.version = version;
    return this;
  }

  public SoftwareBuilder setLicense(String license) {
    this.license = license;
    return this;
  }

  public SoftwareBuilder setWebsite(String websiteURI) {
    try {
      return setWebsite(new URI(websiteURI));
    } catch (URISyntaxException e) {
      return setWebsite((URI) null);
    }
  }

  public SoftwareBuilder setWebsite(URI website) {
    this.website = website;
    return this;
  }

  public Software build() {
    return new Software(name, version, license, website);
  }
}
