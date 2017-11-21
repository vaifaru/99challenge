package br.com.faru.a99challenge.presentation.person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import br.com.faru.a99challenge.model.Person;
import br.com.faru.a99challenge.repository.PersonRepository;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by faru on 05/04/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonsPresenterTest {

    @Mock
    PersonsContract.View viewMock;

    @Mock
    PersonRepository repositoryMock;

    PersonsPresenter presenter;

    @Before
    public void setup() {
        presenter = new PersonsPresenter(repositoryMock);
        presenter.setView(viewMock);
    }

    @Test
    public void shouldShowProgressOnCreate() {
        presenter.onActivityCreated();
        verify(viewMock).setProgressIndicator(true);
    }

    @Test
    public void shouldGetPersonsOnCreate() {
        presenter.onActivityCreated();
        verify(repositoryMock).getPersons(presenter);
    }

    @Test
    public void shouldGoToPersonOnClick() {
        Person person = mock(Person.class);
        presenter.onClick(person);
        verify(viewMock).goToPerson(person);
    }

    @Test
    public void shouldHideProgressWhenGetPersonsSuccess() {
        presenter.onGetPersonsSuccess(createPersonList());
        verify(viewMock).setProgressIndicator(false);
    }

    @Test
    public void shouldShowResultsWhenGetPersonsSuccess() {
        presenter.onGetPersonsSuccess(createPersonList());
        verify(viewMock).showResults(anyListOf(Person.class));
    }

    @Test
    public void shouldHideProgressWhenGetPersonsFailure() {
        presenter.onGetPersonsFailure(anyString());
        verify(viewMock).setProgressIndicator(false);
    }

    @Test
    public void shouldShowMessageWhenGetPersonsFailure() {
        presenter.onGetPersonsFailure(anyString());
        verify(viewMock).showMessage(anyString());
    }

    private List<Person> createPersonList() {
        final List<Person> persons = new ArrayList<>();
        persons.add(mock(Person.class));
        return persons;
    }
}
