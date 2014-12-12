package weiskopf.paint.message;

public class PaintMessageFactory {

	public PaintMessage getMessage(String message) {

		PaintMessage paintMessage = null;

		String[] messageElements = message.split("\\s");

		switch (messageElements[0]) {

		case "LINE":
			int x1 = Integer.valueOf(messageElements[1]);
			int y1 = Integer.valueOf(messageElements[2]);
			int x2 = Integer.valueOf(messageElements[3]);
			int y2 = Integer.valueOf(messageElements[4]);
			int strokeSize1 = Integer.valueOf(messageElements[5]);
			int color1 = Integer.valueOf(messageElements[6]);
			paintMessage = new LineMessage(x1, y1, x2, y2, strokeSize1, color1);
			break;

		case "SHAPE":
			Type type = Type.valueOf(messageElements[1]);
			int x = Integer.valueOf(messageElements[2]);
			int y = Integer.valueOf(messageElements[3]);
			int w = Integer.valueOf(messageElements[4]);
			int h = Integer.valueOf(messageElements[5]);
			int color2 = Integer.valueOf(messageElements[6]);
			int strokeSize2 = Integer.valueOf(messageElements[7]);
			boolean fill = Boolean.valueOf(messageElements[8]);
			paintMessage = new ShapeMessage(type, x, y, w, h, color2, strokeSize2, fill);
			break;

		case "CLEAR":
			paintMessage = new ClearMessage();
			break;

		case "BUCKET_FILL":
			int x3 = Integer.valueOf(messageElements[1]);
			int y3 = Integer.valueOf(messageElements[2]);
			int color3 = Integer.valueOf(messageElements[3]);
			paintMessage = new BucketFillMessage(x3, y3, color3);
			break;
		}

		return paintMessage;

	}

}
