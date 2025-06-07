import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {       
        Time t_video_len = new Time(video_len);
        Time t_pos = new Time(pos);
        Time t_op_start = new Time(op_start);
        Time t_op_end = new Time(op_end);
        
        for(String command: commands) {
            // System.out.println("Command: "+command + ", cur: " + t_pos.getTime());
            // 오프닝 체크
            if(t_op_start.compareTo(t_pos) <= 0 && t_pos.compareTo(t_op_end) <= 0) {
                // System.out.println("jump opening");
                t_pos = new Time(op_end);
            }
            
            switch(command) {
                case "prev":
                    t_pos.add(-10, t_video_len);
                    break;
                case "next":
                    t_pos.add(10, t_video_len);
                    break;
                default:
                    break;
            }
        }
        
        if(t_op_start.compareTo(t_pos) <= 0 && t_pos.compareTo(t_op_end) <= 0) {
                t_pos = new Time(op_end);
        }
        
        return t_pos.getTime();
    }
}

class Time implements Comparable<Time>{
    int hour;
    int min;
    
    public Time(String format) {
        String[] args = format.split(":");
        this.hour = Integer.parseInt(args[0]);
        this.min = Integer.parseInt(args[1]);
    }
    
    public String getTime() {
        StringBuilder sb = new StringBuilder();
        if(String.valueOf(hour).length() != 2) {
            sb.append(0);
        }
        sb.append(hour).append(":");
        
        if(String.valueOf(min).length() != 2) {
            sb.append(0);
        }
        sb.append(min);
        return sb.toString();
    }
    
    public void add(int amount, Time t_video_len) {
        int result = this.min + amount;
        
        if(result >= 60) {
            this.hour += 1;
            this.min = result % 60;
        } else if(result < 0) {
            if(this.hour == 0) {
                this.min = 0;
            } else {
                this.hour -= 1;
                this.min = 60 + result;
            }
        } else {
            this.min = result;
        }
        
        if(t_video_len.compareTo(this) <= 0) {
            this.hour = t_video_len.hour;
            this.min = t_video_len.min;
        }
    }
    
    @Override
    public int compareTo(Time other) {
        if(this.hour != other.hour) {
            return this.hour - other.hour;
        } else {
            return this.min - other.min;
        }
    }
}