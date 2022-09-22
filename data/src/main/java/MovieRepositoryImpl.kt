import com.junwooyeom.composeapplication.domain.Movie
import com.junwooyeom.composeapplication.domain.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */
class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieLocalDataSource,
) : MovieRepository {
    override val favoriteListFlow: Flow<List<Movie>>
        get() = localDataSource.getMoviesByFlow().map { it.map { data -> data.toMovie() } }

    override suspend fun getMovie(): List<Movie> = remoteDataSource.getMovie().map { it.toMovie() }

    override suspend fun getMovieById(id: String): Movie = remoteDataSource.getMovieById(id).toMovie()

    override suspend fun insertMovie(movie: Movie) = localDataSource.insertMovie(movie.toMovieEntity())

    override suspend fun deleteMovie(movie: Movie) = localDataSource.deleteMovie(movie.id)
}