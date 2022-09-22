import com.junwooyeom.composeapplication.database.MovieDao
import com.junwooyeom.composeapplication.database.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */
interface MovieLocalDataSource {
    fun getMoviesByFlow(): Flow<List<MovieEntity>>

    suspend fun getMovies(): List<MovieEntity>

    suspend fun insertMovie(movie: MovieEntity)

    suspend fun deleteMovie(id: String)
}

class MovieLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao
): MovieLocalDataSource {
    override fun getMoviesByFlow(): Flow<List<MovieEntity>> = movieDao.getAllFilmsByFlow()

    override suspend fun getMovies(): List<MovieEntity> = movieDao.getAllFilms()

    override suspend fun insertMovie(movie: MovieEntity) = movieDao.insertFilm(movie)

    override suspend fun deleteMovie(id: String) = movieDao.deleteMovieById(id)
}