package com.ivanvinski.kunvertuh.view.mock;

import com.ivanvinski.kunvertuh.util.Software;
import com.ivanvinski.kunvertuh.view.AboutView;
import java.util.List;
import java.util.function.Consumer;

public class AboutViewMock implements AboutView {

  private String author, authorWebsite, repositoryWebsite;
  private Consumer<String> uriActionConsumer;

  public String getAuthor() {
    return author;
  }

  @Override
  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthorWebsite() {
    return authorWebsite;
  }

  @Override
  public void setAuthorWebsite(String authorWebsiteURI) {
    authorWebsite = authorWebsiteURI;
  }

  public void fireAuthorWebsiteAction() {
    uriActionConsumer.accept(getAuthorWebsite());
  }

  public String getRepositoryWebsite() {
    return repositoryWebsite;
  }

  @Override
  public void setRepositoryWebsite(String repositoryWebsiteURI) {
    this.repositoryWebsite = repositoryWebsiteURI;
  }

  public void fireRepositoryWebsiteAction() {
    uriActionConsumer.accept(getRepositoryWebsite());
  }

  @Override
  public void setOnURIAction(Consumer<String> actionConsumer) {
    uriActionConsumer = actionConsumer;
  }

  @Override
  public void setUsedOpenSourceSoftware(List<Software> software) {
  }
}
