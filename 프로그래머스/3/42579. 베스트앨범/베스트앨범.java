import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreCounter = new HashMap<>();
        HashMap<String, List<List<Integer>>> genreSongs = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++)
        {
            genreCounter.put(genres[i], genreCounter.getOrDefault(genres[i],0) + plays[i]);
        }
        for(int i = 0; i < genres.length; i++) {
            genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreSongs.get(genres[i]).add(Arrays.asList(i, plays[i]));
        }
        
        List<String> sortedGenres = new ArrayList<>(genreCounter.keySet());
        sortedGenres.sort((g1, g2) -> genreCounter.get(g2) - genreCounter.get(g1));
        
        List<Integer> bestAlbum = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<List<Integer>> songs = genreSongs.get(genre);
            songs.sort((s1, s2) -> s2.get(1).equals(s1.get(1)) ? s1.get(0) - s2.get(0) : s2.get(1) - s1.get(1));
            
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                bestAlbum.add(songs.get(i).get(0));
            }
        }
    
        
        return bestAlbum.stream().mapToInt(i -> i).toArray();
        }
    }