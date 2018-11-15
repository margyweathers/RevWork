import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ex.dao.DAO;
import com.ex.dao.GenreDao;
import com.ex.pojos.Genre;

public class GenreDAOTest {
	
	
	private static Logger log = Logger.getLogger(GenreDAOTest.class);
	DAO<Genre, Integer> dao;

	@Before
	public void setUp() throws Exception {
		dao = new GenreDao();
		System.out.println("Setting up instance before test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		dao = null;
		System.out.println("In tear down method");
	}


	@Test
	public void test() {
		List<Genre> genres = dao.findAll();
		for(Genre g : genres){		
			log.debug(g);
		}
		assertNotNull(genres);
		assertTrue(genres.size() > 0);
	}

}