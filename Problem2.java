// Time Complexity : O(m*n) where m is the number of users and n is the number of songs
// Space Complexity : O(n where n is the total number of songs)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
1. Create a mapping between each song and the genre it belongs to.
2. For each user, calculate the frequency of genres that the songs they listened belong to.
3. Return the top frequently listened genres of the users.
*/

public class Main {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        Map<String, String> songToGenreMapping = new HashMap<>();

        for (String genre : songGenres.keySet()) {
            List<String> songs = songGenres.get(genre);

            for (String song : songs) {
                songToGenreMapping.put(song, genre);
            }
        }

        Map<String, List<String>> result = new HashMap<>();

        for (String user : userSongs.keySet()) {

            List<String> songsListenedByUser = userSongs.get(user);

            Map<String, Integer> genreFrequencyMap = new HashMap<>();

            result.put(user, new ArrayList<>());

            int maxFrequency = 0;

            for (String song : songsListenedByUser) {

                String genre = songToGenreMapping.get(song);

                genreFrequencyMap.put(
                    genre,
                    genreFrequencyMap.getOrDefault(genre, 0) + 1
                );

                maxFrequency = Math.max(
                    maxFrequency,
                    genreFrequencyMap.get(genre)
                );
            }

            for (String genre : genreFrequencyMap.keySet()) {

                if (genreFrequencyMap.get(genre) == maxFrequency) {
                    result.get(user).add(genre);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
            HashMap<String, List<String>> userSongs = new HashMap<>();

            userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));

            userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

            HashMap<String, List<String>> songGenres = new HashMap<>();

            songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));

            songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));

            songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));

            songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));

            songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

            Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

            System.out.println(res);
    }

}
