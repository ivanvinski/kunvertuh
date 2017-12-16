package com.ivanvinski.kunvertuh.util;

import java.net.URI;
import java.util.Objects;

public class Software {

  private String name, version, license;
  private URI website;

  Software(String name, String version, String license, URI website) {
    this.name = Objects.requireNonNull(name, "Software name can't be null");
    this.version = version;
    this.license = license;
    this.website = website;
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

  public URI getWebsite() {
    return website;
  }
}
