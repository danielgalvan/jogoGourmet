import javax.swing.JOptionPane;

public class JogoGourmet {

	private static String food = "Massa";
	private static Object[] options = { "Sim", "Não" };
	private static String pastaAnswer = "";
	private static String cakeAnswer = "";
	private static String oldTryPasta = "Lasanha";
	private static String oldTryCake = "Bolo de Chocolate";
	private static String pastaClue = "";
	private static String cakeClue = "";
	private static int option;

	public static void main(String[] args) {
		gameStart();
	}

	private static void gameStart() {
		showStartMessage();
		setOption(showQuestionMessage());

		if (getOption() == JOptionPane.YES_OPTION) {
			if (!getPastaClue().isEmpty()) {
				setFood(getPastaClue());
				setOption(showQuestionMessage());

				if (getOption() == JOptionPane.YES_OPTION) {
					setFood(getPastaAnswer());
					setOption(showQuestionMessage());;
					
					if (getOption() == JOptionPane.YES_OPTION) {
						winner();
					} else if (getOption() == JOptionPane.NO_OPTION) {
						quitLasagna();
					}
				} else if (getOption() == JOptionPane.NO_OPTION) {
					lasagnaTry();
				}
			} else {
				lasagnaTry();
			}
		} else if (getOption() == JOptionPane.NO_OPTION) {
			if (!getCakeClue().isEmpty()) {
				setFood(getCakeClue());
				setOption(showQuestionMessage());

				if (getOption() == JOptionPane.YES_OPTION) {
					setFood(getCakeAnswer());
					setOption(showQuestionMessage());
					
					if (getOption() == JOptionPane.YES_OPTION) {
						winner();
					} else if (getOption() == JOptionPane.NO_OPTION) {
						quitCake();
					}
				} else if (getOption() == JOptionPane.NO_OPTION) {
					cakeTry();
				}
			} else {
				cakeTry();
			}
		}
	}
	
	private static void lasagnaTry() {
		setFood("Lasanha");
		setOption(showQuestionMessage());

		if (getOption() == JOptionPane.YES_OPTION) {
			winner();
		} else if (getOption() == JOptionPane.NO_OPTION) {
			quitLasagna();
		}		
	}
	
	private static void quitLasagna() {
		setPastaAnswer(showInputMessage());
		
		if (getPastaAnswer() != null && !getPastaAnswer().isEmpty()) {
			setPastaClue(showInputClueMessage(getPastaAnswer(), getOldTryPasta()));
			setOldTryPasta(getPastaAnswer());
		} else {
			showWarningMessage();
		}
		
		setFood("Massa");
		gameStart();
	}
	
	private static void cakeTry() {
		setFood("Bolo de Chocolate");
		setOption(showQuestionMessage());

		if (getOption() == JOptionPane.YES_OPTION) {
			winner();
		} else if (getOption() == JOptionPane.NO_OPTION) {
			quitCake();
		}		
	}
	
	private static void quitCake() {
		setCakeAnswer(showInputMessage());
		
		if (getCakeAnswer() != null && !getCakeAnswer().isEmpty()) {
			setCakeClue(showInputClueMessage(getCakeAnswer(), getOldTryCake()));
			setOldTryCake(getCakeAnswer());
		} else {
			showWarningMessage();
		}
		
		setFood("Massa");
		gameStart();
	}
	
	private static void winner() {
		showFinalMessage();
		setFood("Massa");
		gameStart();
	}

	private static void showStartMessage() {
		JOptionPane.showMessageDialog(null, "Pense em um prato que gosta.", "Jogo Gourmet", JOptionPane.INFORMATION_MESSAGE);
	}

	private static int showQuestionMessage() {
		return JOptionPane.showOptionDialog(null, "O prato que você pensou é " + getFood() + " ?", "Confirm",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}

	private static void showFinalMessage() {
		JOptionPane.showMessageDialog(null, "Acertei de novo!");
	}

	private static String showInputMessage() {
		return JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto", JOptionPane.QUESTION_MESSAGE);
	}

	private static String showInputClueMessage(String answer, String lastTry) {
		return JOptionPane.showInputDialog(null, answer + " é ______ mas " + lastTry + " não.", "Complete", JOptionPane.QUESTION_MESSAGE);
	}
	
	private static void showWarningMessage() {
		JOptionPane.showMessageDialog(null, "Você deve informar um prato!!!", "Prato não informado", JOptionPane.WARNING_MESSAGE);
	}
	
	private static String getFood() {
		return food;
	}

	private static void setFood(String newFood) {
		food = newFood;
	}
	
	public static int getOption() {
		return option;
	}

	public static void setOption(int newOption) {
		option = newOption;
	}
	
	public static String getPastaAnswer() {
		return pastaAnswer;
	}

	public static void setPastaAnswer(String newAnswer) {
		pastaAnswer = newAnswer;
	}
	
	public static String getPastaClue() {
		return pastaClue;
	}

	public static void setPastaClue(String newClue) {
		pastaClue = newClue;
	}

	private static String getOldTryPasta() {
		return oldTryPasta;
	}
	
	private static void setOldTryPasta(String newTry) {
		oldTryPasta = newTry;
	}

	public static String getCakeAnswer() {
		return cakeAnswer;
	}

	public static void setCakeAnswer(String newAnswer) {
		cakeAnswer = newAnswer;
	}

	public static String getCakeClue() {
		return cakeClue;
	}

	public static void setCakeClue(String newClue) {
		cakeClue = newClue;
	}

	private static String getOldTryCake() {
		return oldTryCake;
	}
	
	private static void setOldTryCake(String newTry) {
		oldTryCake = newTry;
	}
}