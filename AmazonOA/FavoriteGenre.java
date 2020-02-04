import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Input:
// userSongs = {  
//    "David": ["song1", "song2", "song3", "song4", "song8"],
//    "Emma":  ["song5", "song6", "song7"]
// },
// songGenres = {  
//    "Rock":    ["song1", "song3"],
//    "Dubstep": ["song7"],
//    "Techno":  ["song2", "song4"],
//    "Pop":     ["song5", "song6"],
//    "Jazz":    ["song8", "song9"]
// }

// Output: {  
//    "David": ["Rock", "Techno"],
//    "Emma":  ["Pop"]
// }

class FavoriteGenre {
    public Map<String, List<String>> favoriteGenre(Map<String, List<String>> userSongs,
            Map<String, List<String>> songGenres) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songToGenre = new HashMap<>();

        // generate songToGenre map
        for (String genre : songGenres.keySet()) {
            List<String> songs = songGenres.get(genre);
            for (String song : songs) {
                songToGenre.put(song, genre);
            }
        }
        // count for users
        for (String user : userSongs.keySet()) {
            Map<String, Integer> count = new HashMap<>();
            List<String> songs = userSongs.get(user);
            List<String> genres = new ArrayList<>();
            int max = 0;
            for (String song : songs) {
                String genre = songToGenre.get(song);
                count.put(genre, count.getOrDefault(genre, 0) + 1);
                if (count.get(genre) > max) {
                    max = count.get(genre);
                }
            }
            for (String genre : count.keySet()) {
                if (count.get(genre) == max) {
                    genres.add(genre);
                }
            }
            res.put(user, genres);
        }
        return res;
    }

    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", new ArrayList<String>(Arrays.asList("song1", "song2", "song3", "song4", "song8")));
        userSongs.put("Emma", new ArrayList<String>(Arrays.asList("song5", "song6", "song7")));
        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", new ArrayList<String>(Arrays.asList("song1", "song3")));
        songGenres.put("Dubstep", new ArrayList<String>(Arrays.asList("song7")));
        songGenres.put("Techno", new ArrayList<String>(Arrays.asList("song2", "song4")));
        songGenres.put("Pop", new ArrayList<String>(Arrays.asList("song5", "song6")));
        songGenres.put("Jazz", new ArrayList<String>(Arrays.asList("song8", "song9")));

        System.out.println(new FavoriteGenre().favoriteGenre(userSongs, songGenres));
    }
}