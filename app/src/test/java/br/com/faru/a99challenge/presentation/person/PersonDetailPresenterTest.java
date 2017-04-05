package br.com.faru.a99challenge.presentation.person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.faru.a99challenge.model.Person;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by faru on 05/04/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonDetailPresenterTest {

    @Mock
    PersonDetailContract.View viewMock;

    PersonDetailPresenter presenter;

    @Before
    public void setup() {
        presenter = new PersonDetailPresenter();
        presenter.setView(viewMock);
    }

    @Test
    public void shouldShowInfoWhenOnCreate() {
        Person person = mock(Person.class);
        presenter.onCreate(person);
        verify(viewMock).showInfo(person);
    }
}
