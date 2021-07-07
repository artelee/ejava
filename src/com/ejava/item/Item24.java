package com.ejava.item;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * 멤버클래스는 웬만하면 static이 낫다.
 * 단, 외부에서 쓰이지 않는 순수한 멤버 클래스여야한다.
 */
public class Item24 {
    /**
     * 중첩클래스 : 클래스들의 논리적 그룹을 나타낼 떄 사용
     * 주로 모델 객체에서 상-하위 모델이 있을 때
     * 가독성, 유지보수성, 캡슐화 up
     * - 종류
     * 1. 내부클래스
     * 2. 정적중첩클래스
     * 3. 지역클래스
     * 4. 익명클래스
     */

    // 1. 내부클래스 = 비정적 멤버클래스
    내부클래스Outer 내부클래스Outer1 = new 내부클래스Outer();
    내부클래스Outer.내부클래스Inner 내부클래스Outer2 = 내부클래스Outer1.new 내부클래스Inner();

    // 2. 정적중첩클래스
    정적중첩클래스Outer.정적중첩클래스Inner 정적중첩클래스Inner1 = new 정적중첩클래스Outer.정적중첩클래스Inner();

}

/**
 * 일반클래스 내부에 생성됨.
 * 바깥 클래스가 내부 클래스를 멤버변수처럼 사용 가능. new 로 선언
 */
class 내부클래스Outer {
    public class 내부클래스Inner {

    }
}

/**
 * 내부클래스(비정적 멤버클래스)는 어댑터에 많이사용된다.
 * 어떤 클래스의 인스턴스를 감싸
 * 마치 다른 클래스의 인스턴스처럼 보이게.
 */
class MySet<E> extends AbstractSet<E> {
    @Override
    public Iterator<E> iterator(){
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    private class MyIterator implements Iterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}


/**
 * 정적중첩클래스는 내부클래스와 비슷하지만 static으로 사용한다.
 * 바깥에 선언된 것들 중에서 static으로 선언된 것들만 사용할 수 있다.
 */
class 정적중첩클래스Outer {
    public static class 정적중첩클래스Inner {

    }
}

/**
 * 지역클래스
 */
class 지역클래스Outer {
    void getInner() {
        class 지역클래스Inner {

        }
        // 메소드 안에 있는 클래스는 지역변수처럼 쓰이며, new 선언을 해서 사용해야한다.
        지역클래스Inner 지역Inner = new 지역클래스Inner();
    }
}

/**
 * 익명클래스는 new와 동시에 부모클래스를 상속받아 내부에서 오버라이딩해서 사용.
 * 미리 클래스가 선언이 되어있어야한다.
 * 익명클래스 내부에 생성자가 없다.
 * 익명클래스는 외부 final 만 사용할 수 있다.
 * 람다가 대신하고 있음
 */
class 익명클래스Inner{

}

class 익명클래스Outer{
    void getInner(){
        new 익명클래스Inner(){
            // override
        };
    }
}