import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==명언 앱==");
        System.out.print("명령)");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int number = 1;
        Proverbs[] proverbs = new Proverbs[100]; // MAXSIZE = 100
        while(!command.equals("종료")) {
            if(command.equals("등록")){
                System.out.print("명언 : ");
                String proverb = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
                System.out.println(number + "번 명언이 등록되었습니다.");
//                AddFile(number,proverbs);
                proverbs[number-1] = new Proverbs(number, proverb, author);
                number++;
            }
            else if(command.equals("목록")){
                System.out.println("번호 / 작가 / 명언\n----------------------");
                for(int i=number-1;i>=0;i--){
                    if(proverbs[i] == null)
                        continue;
                    System.out.println(proverbs[i].getNumber() + " / " + proverbs[i].getAuthor() + " / " + proverbs[i].getProverb());
                }
            }
            else if(command.contains("삭제")){
                String numbersOnly = command.replaceAll("[^0-9]", "");
                int num = Integer.parseInt(numbersOnly);
                // OOB or not exist or already deleted
                if(num<1 || proverbs[num-1]==null){
                    System.out.println(num + "번 명언은 존재하지 않습니다");
                }
                else{
                    proverbs[num-1]=null;
                    System.out.println(num + "번 명언이 삭제되었습니다");
                }
            }
            else if(command.contains("수정")){
                String numbersOnly = command.replaceAll("[^0-9]", "");
                int num = Integer.parseInt(numbersOnly);
                if(num<1 || proverbs[num-1]==null){
                    System.out.println(num + "번 명언은 존재하지 않습니다");
                }
                else{
                    System.out.println("명언(기존) " + proverbs[num-1].getProverb());
                    System.out.print("명언 : ");
                    String proverb = scanner.nextLine();
                    proverbs[num-1].setProverb(proverb);

                    System.out.println("작가(기존) " + proverbs[num-1].getAuthor());
                    System.out.print("작가 : ");
                    String author = scanner.nextLine();
                    proverbs[num-1].setAuthor(author);
                }
            }
            System.out.print("명령)");
            command = scanner.nextLine();
        }
    }
//    // 파일 수정
//    public void FileEdit(int number, Proverbs[] proverbs) {
//        try {
//            OutputStream output = new FileOutputStream("./db/wiseSaying/"+number+".json");
//        } catch (Exception e) {
//
//        }
//    }
//
//    // 파일 삭제
//    public void FileDelete(int number, Proverbs[] proverbs) {
//        try{
//
//        }catch(Exception e){
//
//        }
//    }
//    // 파일 추가
//    public static void AddFile(int number, Proverbs[] proverbs) {
//        try {
//            OutputStream output = new FileOutputStream("./db/wiseSaying/"+number+".json");
//            String proverb = proverbs[number-1].getProverb();
//            String author = proverbs[number-1].getAuthor();
//            String outputString = "{\n\t\"id\" : " + number + ",\n\t\"proverb\":\""+proverb+"\",\n\t\"author\":\""+author+"\"}";
//            output.write(outputString.getBytes());
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//    }
}

class Proverbs{
    int number;
    String proverb;
    String author;

    public Proverbs(){
        number = 0;
        proverb = "";
        author = "작자미상";
    }

    public Proverbs(int number, String proverb, String author){
        this.number = number;
        this.proverb = proverb;
        this.author = author;
    }

    public int getNumber(){
        return number;
    }
    public String getProverb(){
        return proverb;
    }
    public String getAuthor(){
        return author;
    }

    public void setNumber(int number){
        this.number = number;
    }
    public void setProverb(String proverb){
        this.proverb = proverb;
    }
    public void setAuthor(String author){
        this.author = author;
    }
}
