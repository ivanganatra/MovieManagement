package ivan.cse.movie.constants;

public class RestAPI {

    //User API
    public static final String GET_USER = "/getAllUsers";
    public static final String REGISTER_USER = "/registerUser";

    //City API
    public static final String GET_CITIES = "/getAllCities";
    public static final String ADD_CITY = "/addCity";

    //Theatre API
    public static final String GET_THEATRES = "/getAllTheatres";
    public static final String GET_THEATRES_BY_CITY = "/getTheatresByCity/{cityId}";
    public static final String GET_THEATRES_BY_MOVIE_AND_CITY= "/getTheatresByMovieAndCity/{movieId}/{cityId}";
    public static final String GET_THEATRES_BY_MOVIE_AND_CITY_AND_DATE= "/getTheatresByMovieAndCity/{movieId}/{cityId}/{date}";
    public static final String ADD_THEATRE = "/addTheatre";

    //Movie API
    public static final String GET_MOVIES = "/getAllMovies";
    public static final String GET_MOVIES_BY_CITY= "/getMoviesByCity/{movieId}";
    public static final String GET_MOVIES_BY_THEATRE_AND_CITY= "/getMoviesByTheatreAndCity/{theatreId}/{cityId}";
    public static final String GET_MOVIES_BY_THEATRE_AND_CITY_AND_DATE= "/getMoviesByTheatreAndCity/{theatreId}/{cityId}/{date}";
    public static final String ADD_MOVIE = "/addMovie";

    //Auditorium API
    public static final String GET_AUDITORIUMS = "/getAllAuditoriums";
    public static final String GET_AUDITORIUMS_BY_THEATRE= "/getAuditoriumByTheatreName/{auditoriumId}";
    public static final String GET_AUDITORIUMS_BY_CITY= "/getAuditoriumByTheatreName/{cityId}";
    public static final String ADD_AUDITORIUM = "/addAuditorium";

    //Screening API
    public static final String GET_SCREENINGS = "/getAllScreenings";
    public static final String GET_SCREENINGS_BY_THEATRE_AND_CITY= "/getScreeningsByTheatreAndCity/{theatreId}/{cityId}";
    public static final String GET_SCREENINGS_BY_THEATRE_AND_CITY_AND_DATE= "/getScreeningsByTheatreAndCity/{theatreId}/{cityId}/{date}";
    public static final String GET_SCREENINGS_BY_MOVIE_AND_CITY= "/getScreeningsByMovieAndCity/{movieId}/{cityId}";
    public static final String GET_SCREENINGS_BY_MOVIE_AND_CITY_AND_DATE= "/getScreeningsByMovieAndCity/{movieId}/{cityId}/{date}";
    public static final String ADD_SCREENING = "/addScreening";
}
