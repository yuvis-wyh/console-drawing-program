import entity.panel.Grid;
import service.DrawSvc;

import java.util.Scanner;

public class DrawingProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter command: ");
        String input = scanner.nextLine().trim();

        Grid[][] canvas = null;
        while(!(input.equals("Q")||input.equals("q"))) {
            canvas = DrawSvc.processDrawingCommand(canvas, input);
            System.out.print("enter command: ");
            input = scanner.nextLine().trim();
        }
        scanner.close();
    }
}
