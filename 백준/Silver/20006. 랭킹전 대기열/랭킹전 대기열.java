import java.util.*;
import java.io.*;

public class Main {

    private static List<Room> rooms = new ArrayList<>();
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int currentLevel = Integer.parseInt(st.nextToken());
            String currentNickname = st.nextToken();

            Room currentRoom = checkAvailableRoom(currentLevel);
            if (currentRoom == null) {
                rooms.add(new Room(rooms.size(), currentLevel - 10, currentLevel + 10));
                rooms.get(rooms.size() - 1).players.add(new Player(currentLevel, currentNickname));
            } else {
                currentRoom.players.add(new Player(currentLevel, currentNickname));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rooms.size(); i++) {
            Room current = rooms.get(i);
            if (current.players.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }
            Collections.sort(current.players);
            for (int j = 0; j < current.players.size(); j++) {
                sb.append(current.players.get(j).level).append(" ").append(current.players.get(j).nickName)
                        .append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static Room checkAvailableRoom(int currentLevel) {
        for (int i = 0; i < rooms.size(); i++) {
            Room current = rooms.get(i);
            if (current.players.size() < m && current.x <= currentLevel && currentLevel <= current.y) {
                return current;
            }
        }
        return null;
    }
}

class Room {
    // 방 인덱스
    int index;
    // 입장 가능 레벨
    int x, y;
    // 플레이어 모음
    List<Player> players = new ArrayList<>();

    public Room(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }
}

class Player implements Comparable<Player> {
    int level;
    String nickName;

    public Player(int level, String nickName) {
        this.level = level;
        this.nickName = nickName;
    }

    @Override
    public int compareTo(Player p) {
        return this.nickName.compareTo(p.nickName);
    }
}