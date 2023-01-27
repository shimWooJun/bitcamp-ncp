package bitcamp.util;

//

public abstract class AbstractList<E> implements List<E> {

  protected int size;

  @Override
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("인덱스가 무효합니다.");
    }
    return null;
  }

  @Override
  public int size() {
    return this.size;
  }


  // iterator() 클래스에서만 사용하는 클래스라면
  // 이 클래스 안에 두는 것이 유지보수에 좋다.
  // - 인스턴스를 한 개만 만들어  사용하고, 클래스의 크기도 작다면
  // 익명 클래스로 만드는 것이 코드를 간결하게 만든다.
  // => anonymous class = 클래스 정의 + 객체 생성 코드

  @Override
  public Iterator<E> iterator(){

    // => return 문 + anonymous class
    return new Iterator<E>(){
      int cursor;
      @Override
      public boolean hasNext() {
        return cursor >= 0 && cursor < AbstractList.this.size();
      }
      @Override
      public E next() {
        return AbstractList.this.get(cursor++);
      }

    };

  }

}
