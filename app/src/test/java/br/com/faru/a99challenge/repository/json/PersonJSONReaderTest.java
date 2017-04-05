package br.com.faru.a99challenge.repository.json;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by faru on 05/04/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonJSONReaderTest {

    private static final String FILE_DATA = "./app/src/main/assets/data.json";

    PersonJSONReader personJSONReader;

    @Mock
    PersonJSONReader personJSONReaderMock;

    @Before
    public void setup() {
        personJSONReader = new PersonJSONReader();
    }

    @Test
    public void shouldReadJsonFile() throws Exception {
    }
}
