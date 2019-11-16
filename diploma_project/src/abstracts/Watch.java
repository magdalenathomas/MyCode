package abstracts;

public abstract class Watch {
	
	public static long start;
	public static long stop;
	public static long time;
	
	public static void start() {
		setStart(System.currentTimeMillis());
		System.out.println("Clock is active " + start);
	}
	
	public static void stop() {
		setStop(System.currentTimeMillis());
		System.out.println("Clock is disactive " + stop);
	}
	
	public static void time() {
		System.out.println(getStart()); 
		System.out.println(getStop());
		//setTime(getStop() - getStart());
		//System.out.println("Time: " + time);
	}
	
	public static long getStart() {
		return start;
	}

	public static void setStart(long start) {
		Watch.start = start;
	}

	public static long getStop() {
		return stop;
	}

	public static void setStop(long stop) {
		Watch.stop = stop;
	}

	public static long getTime() {
		return time;
	}

	public static void setTime(long time) {
		Watch.time = time;
	}

}
