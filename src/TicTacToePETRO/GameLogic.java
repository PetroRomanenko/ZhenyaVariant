package TicTacToePETRO;

import java.util.Random;
import java.util.Scanner;
//��� ��������
//������� ������� �� �������
//��� ����������
//�������� ���� �� ����������
//�������� ��� ��������

public class GameLogic {
    private final Field field=new Field();
    private final Scanner scanner=new Scanner(System.in);
    private final Random random=new Random();
    private static int isWinner=1;
    private int count=0;

    public void start() {
        field.createField();
        do {
            //������� ����
            field.showField();
            userStep();
            count++;
            isWinner();
            generatePCStep();
            isWinner();
            count++;
            System.out.println("����� ���� "+count);

        } while (isWinner!=0);
        System.out.println("������� �� ����");
    }

    private int isWinner() {
        isWinnerX();
        isWinnerDraw();
        isWinner0();

        return isWinner;
    }

    private void userStep(){
        int value=getUserInput()-1;
        field.setValue(value, "X");
    }

    private  int getUserInput() {
        boolean isTrue = false;
        int input;
        do {
            System.out.println("������� ����� ���� ������ �������� ������� �� 1 �� 9");
            input = scanner.nextInt();
            if (input < 0 || input > 9) {
                System.out.println("������� ����������� ����� ������� ��� ���");
            } else if (!isEmpty(input-1)) {
                System.out.println("������� ��� ��� ���� ��� ������");
            }else {
                System.out.println("����� ���������� �����");
                isTrue = true;

            }
        }while (!isTrue);

        return input;
    }
    private boolean isEmpty(int i){
        return field.getValue(i).equals("\u00b7") && !field.getValue(i).equals("0") && !field.getValue(i).equals("X");

    }

    private  void generatePCStep(){
        boolean isTrue=false;
        do {
            int i= random.nextInt(9);
            if (field.getValue(i).equals("\u00b7")){
                this.field.setValue(i,"0");
                isTrue=true;
            }
        }while (!isTrue);


    }


    private void isWinnerX(){
        if (isWinVerticalX()||isWinHorizontalX()||isWinDiagonalX()){
            System.out.println("�� ��������");
            isWinner=0;
        }
    }

    private void isWinner0(){
        if (isWinVertical0()||isWinHorizontal0()||isWinDiagonal0()){
            System.out.println("�������� ��������");
            field.showField();
            isWinner=0;
        }


    }
    private void isWinnerDraw(){

        if (count==9){
            System.out.println("���� �����������, �����");
            isWinner=0;
        }
    }



    private boolean isWinHorizontalX(){
        return field.getValue(0).equals("X") && field.getValue(1).equals("X") && field.getValue(2).equals("X") ||
                field.getValue(3).equals("X") && field.getValue(4).equals("X") && field.getValue(5).equals("X") ||
                field.getValue(6).equals("X") && field.getValue(7).equals("X") && field.getValue(8).equals("X");
    }

    private  boolean  isWinVerticalX(){
        return field.getValue(0).equals("X") && field.getValue(3).equals("X") && field.getValue(6).equals("X") ||
                field.getValue(1).equals("X") && field.getValue(4).equals("X") && field.getValue(7).equals("X") ||
                field.getValue(2).equals("X") && field.getValue(5).equals("X") && field.getValue(8).equals("X");
    }
    private boolean isWinDiagonalX(){
        return field.getValue(0).equals("X") && field.getValue(4).equals("X") && field.getValue(8).equals("X") ||
                field.getValue(2).equals("X") && field.getValue(4).equals("X") && field.getValue(6).equals("X");
    }

    private boolean isWinHorizontal0(){
        return field.getValue(0).equals("0") && field.getValue(1).equals("0") && field.getValue(2).equals("0") ||
                field.getValue(3).equals("0") && field.getValue(4).equals("0") && field.getValue(5).equals("0") ||
                field.getValue(6).equals("0") && field.getValue(7).equals("0") && field.getValue(8).equals("0");
    }

    private  boolean  isWinVertical0(){
        return field.getValue(0).equals("0") && field.getValue(3).equals("0") && field.getValue(6).equals("0") ||
                field.getValue(1).equals("0") && field.getValue(4).equals("0") && field.getValue(7).equals("0") ||
                field.getValue(2).equals("0") && field.getValue(5).equals("0") && field.getValue(8).equals("0");
    }
    private boolean isWinDiagonal0(){
        return field.getValue(0).equals("0") && field.getValue(4).equals("0") && field.getValue(8).equals("0") ||
                field.getValue(2).equals("0") && field.getValue(4).equals("0") && field.getValue(6).equals("0");
    }

}
