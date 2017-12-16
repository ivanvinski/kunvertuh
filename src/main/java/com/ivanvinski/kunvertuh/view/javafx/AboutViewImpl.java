package com.ivanvinski.kunvertuh.view.javafx;

import com.ivanvinski.kunvertuh.util.Software;
import com.ivanvinski.kunvertuh.util.javafx.LinkableSoftwareColumnFormatter;
import com.ivanvinski.kunvertuh.util.javafx.SimpleColumnFormatter;
import com.ivanvinski.kunvertuh.view.AboutView;
import java.util.List;
import java.util.function.Consumer;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class AboutViewImpl extends StackPane implements AboutView {

  @FXML
  private Parent root;
  @FXML
  private Hyperlink author, repository;
  @FXML
  private TableView<Software> usedSoftware;
  @FXML
  private TableColumn<Software, Software> softwareName;
  @FXML
  private TableColumn<Software, String> softwareVersion, softwareLicense;

  public void initialize() {
    getChildren().setAll(root);
    setCellValueFactories();
    setCellFactories();
  }

  @Override
  public void setAuthor(String author) {
    this.author.setText(author);
  }

  @Override
  public void setAuthorWebsite(String authorWebsiteURI) {
    this.author.setUserData(authorWebsiteURI);
  }

  @Override
  public void setRepositoryWebsite(String repositoryWebsiteURI) {
    this.repository.setUserData(repositoryWebsiteURI);
  }

  @Override
  public void setOnURIAction(Consumer<String> actionConsumer) {
    author.setOnAction(event -> actionConsumer.accept((String) author.getUserData()));
    repository.setOnAction(event -> actionConsumer.accept((String) repository.getUserData()));
    softwareName.setCellFactory(new LinkableSoftwareColumnFormatter<>(actionConsumer));
    usedSoftware.refresh();
  }

  @Override
  public void setUsedOpenSourceSoftware(List<Software> software) {
    usedSoftware.getItems().setAll(software);
    usedSoftware.refresh();
  }

  private void setCellValueFactories() {
    softwareName.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue()));
    softwareVersion.setCellValueFactory(new PropertyValueFactory<>("version"));
    softwareLicense.setCellValueFactory(new PropertyValueFactory<>("license"));
  }

  private void setCellFactories() {
    softwareVersion.setCellFactory(new SimpleColumnFormatter<>());
    softwareLicense.setCellFactory(new SimpleColumnFormatter<>());
  }
}
