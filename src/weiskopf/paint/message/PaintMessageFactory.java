package weiskopf.paint.message;

public class PaintMessageFactory {

	public PaintMessage getMessage(String message) {

		PaintMessage paintMessage = null;

		String[] messageElements = message.split(" ");

		switch (messageElements[0]) {

		case "LINE":
			int x1 = Integer.valueOf(messageElements[1]);
			int y1 = Integer.valueOf(messageElements[2]);
			int x2 = Integer.valueOf(messageElements[3]);
			int y2 = Integer.valueOf(messageElements[4]);
			int strokeSize = Integer.valueOf(messageElements[5]);
			int color = Integer.valueOf(messageElements[6]);
			paintMessage = new LineMessage(x1, y1, x2, y2, strokeSize, color);
			break;

		case "SHAPE":

			break;

		case "CLEAR":

			break;

		case "BUCKET_FILL":

			break;
		}

		return paintMessage;

	}

}
