package com.ivanvinski.kunvertuh.presenter;

import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.model.AboutModelMock;
import com.ivanvinski.kunvertuh.view.mock.AboutViewMock;
import org.junit.Before;
import org.junit.Test;

public class AboutPresenterTest {

  private static final String AUTHOR_WEBSITE = "https://ivanvinski.com/";
  private static final String REPOSITORY_WEBSITE = "https://github.com/ivanvinski/kunvertuh";

  private AboutViewMock view = new AboutViewMock();
  private AboutModelMock model = new AboutModelMock();

  @Before
  public void setUp() {
    new AboutPresenter(view, model).initialize();
  }

  @Test(expected = NullPointerException.class)
  public void nullViewInstantiationThrowsException() {
    new AboutPresenter(null, model);
  }

  @Test(expected = NullPointerException.class)
  public void nullModelInstantiationThrowsException() {
    new AboutPresenter(view, null);
  }

  @Test
  public void initializationSetsAuthor() {
    assertEquals("Ivan Vinski", view.getAuthor());
  }

  @Test
  public void initializationSetsAuthorWebsite() {
    assertEquals(AUTHOR_WEBSITE, view.getAuthorWebsite());
  }

  @Test
  public void initializationSetsRepositoryWebsite() {
    assertEquals(REPOSITORY_WEBSITE, view.getRepositoryWebsite());
  }

  @Test
  public void authorWebsiteActionOpensAuthorWebsite() {
    view.fireAuthorWebsiteAction();
    assertEquals(AUTHOR_WEBSITE, model.getOpenedWebsite());
  }

  @Test
  public void repositoryWebsiteActionOpensRepositoryWebsite() {
    view.fireRepositoryWebsiteAction();
    assertEquals(REPOSITORY_WEBSITE, model.getOpenedWebsite());
  }
}
