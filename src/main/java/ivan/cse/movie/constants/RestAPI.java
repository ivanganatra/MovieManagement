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
    public static final String GET_THEATRES_BY_CITY_NAME = "/getTheatresByCityName/{cityName}";
    public static final String ADD_THEATRE = "/addTheatre";

    //Movie API
    public static final String GET_MOVIE = "/getAllMovies";
    public static final String GET_MOVIES_BY_CITY_NAME = "/getMoviesByTheatreName/{theatreName}";
    public static final String ADD_MOVIE = "/addMovie";
}
