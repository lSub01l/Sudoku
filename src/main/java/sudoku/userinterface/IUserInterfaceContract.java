package sudoku.userinterface;

import sudoku.problemdomain.SudokuGame;

public class IUserInterfaceContract {
    public interface EventListener {
        void onSudokuInput(int x, int y, int input);
        void onDialogClick();
    }
    public interface View {
        void setListener(IUserInterfaceContract.EventListener listener);
        void updateSquare(int x, int y, int input);
        void updateBoard(SudokuGame game);
        void showDialog(String Message);
        void showError(String message);
    }
}
