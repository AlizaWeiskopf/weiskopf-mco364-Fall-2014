package weiskopf.paint.message;

public class Main {

	public static void main(String[] args) {

		LineMessage m = new LineMessage(1, 1, 5, 6, 6, 5);
		System.out.println(m.toString());

		PaintMessageFactory factory = new PaintMessageFactory();

	}

}
