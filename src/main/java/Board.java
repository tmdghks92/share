import java.util.List;

public class Board {
	private String name;
	private List<Integer> scores;
	private List<Frame> frames;
	private String newLine = System.getProperty("line.separator");
	private final static String separateCharacter = "|";

	public Board(String name) {
		this.name = name;
	}

	public String create() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstLine());
		stringBuilder.append(nameSection(name));
		stringBuilder.append(secondLine(frames));
		stringBuilder.append("|      |");
		stringBuilder.append(thirdLine(scores));
		return stringBuilder.toString();
	}

	private String thirdLine(List<Integer> scores) {
		if (scores == null) {
			return "      |      |      |      |      |      |      |      |      |      |";
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(existedScoreValues(scores));
		stringBuilder.append(unExistedScoreValues(scores.size()));
		return stringBuilder.toString();
	}

	private String unExistedScoreValues(int size) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = size; i < 10; i++) {
			stringBuilder.append("      |");
		}
		return stringBuilder.toString();
	}

	private String existedScoreValues(List<Integer> scores) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Integer index : scores) {
			stringBuilder.append("  ");
			stringBuilder.append(index);
			stringBuilder.append("  |");
		}
		return stringBuilder.toString();
	}

	private String secondLine(List<Frame> frames) {
		if (frames == null) {
			return "      |      |      |      |      |      |      |      |      |      |" + newLine;
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(usefullValue(frames));
		stringBuilder.append(unUsefullValue(frames.size()));
		return stringBuilder.toString();
	}

	private String unUsefullValue(int size) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = size; i < 10; i++) {
			stringBuilder.append("      |");
		}
		stringBuilder.append(newLine);
		return stringBuilder.toString();
	}

	private String usefullValue(List<Frame> frames) {
		StringBuilder stringBuilder = new StringBuilder();

		for (Frame frame : frames) {
			stringBuilder.append(firstScorePrint(frame));
			stringBuilder.append(secondScorePrint(frame));
		}

		return stringBuilder.toString();
	}

	private String secondScorePrint(Frame frame) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(secondScoreCheck(frame));
		return stringBuilder.toString();
	}

	private String secondScoreCheck(Frame frame) {
		if (frame.count == 1) {
			return "   |";
		}
		if (frame.firstTryScore + frame.secondTryScore == 10) {
			return "|/ |";
		}
		if (frame.secondTryScore == 0) {
			return "|- |";
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(separateCharacter);
		stringBuilder.append(frame.secondTryScore);
		stringBuilder.append(" |");
		return stringBuilder.toString();
	}

	private String firstScorePrint(Frame frame) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("  ");
		if (frame.firstTryScore == 10) {
			return stringBuilder.append("X").toString();
		}
		stringBuilder.append(frame.firstTryScore);
		return stringBuilder.toString();
	}

	private String nameSection(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("|  ");
		stringBuilder.append(name);
		stringBuilder.append(" |");
		return stringBuilder.toString();
	}

	private String firstLine() {
		return "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |" + newLine;
	}

	public void framesReceiveToManager(List<Frame> frames) {
		this.frames = frames;
	}

	public void scoresReceiveToManager(List<Integer> scores) {
		this.scores = scores;

	}

}
