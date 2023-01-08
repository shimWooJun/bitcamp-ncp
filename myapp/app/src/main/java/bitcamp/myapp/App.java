package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
    goMainMenu();
    System.out.println("안녕히 가세요!");

    // 프로그램이 사용한 자원 해제하기
    Prompt.close();
  } // main()

  private static void goMainMenu() {

    MemberHandler generalMemberHandler = new MemberHandler("컨텐츠");

    while (true) {
      System.out.println("1. 게시판 컨텐츠");
      System.out.println("9. 종료");
      int menuNo = Prompt.inputInt("메뉴> ");

      if (menuNo == 1) {
        generalMemberHandler.service();

      } else if (menuNo == 9) {
        break;
      } else {
        System.out.println("잘못된 메뉴 번호 입니다.");
      }
    }
  }
}









