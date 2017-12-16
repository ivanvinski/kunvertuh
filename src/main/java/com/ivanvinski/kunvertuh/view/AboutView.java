package com.ivanvinski.kunvertuh.view;

import com.ivanvinski.kunvertuh.util.Software;
import java.util.List;
import java.util.function.Consumer;

public interface AboutView extends View {

  void setAuthor(String author);

  void setAuthorWebsite(String authorWebsiteURI);

  void setRepositoryWebsite(String repositoryWebsiteURI);

  void setOnURIAction(Consumer<String> actionConsumer);

  void setUsedOpenSourceSoftware(List<Software> software);
}
