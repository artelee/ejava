package com.ejava.item;

/**
 * 톱레벨 클래스는 한 파일에 하나만 담으라
 * 소스파일에 top level class를 여러개 선언해도 자바컴파일러는 체크하지 않는다.
 * 심각한 위험 (!!)이 있을 수 있다.
 *
 * 예를들면 한 파일에 클래스 2개가 정의되어있는데, 다른 파일에 똑같은 클래스명으로 클래스 2개가 정의되어 있는 경우이다. 이럴 때는 컴파일이 실패하거나, 컴파일 순서에 따라 어떻게 동작할 지 예측할 수 없게 된다.
 * 따라서 한 파일에는 하나의 톱레벨 클래스, 인터페이스만 작성하자
 * 출처: https://sjh836.tistory.com/170 [빨간색코딩]
 */
public class Item25 {


}

class 위험할수있는클래스{
    class Utensil{
        static final String NAME = "pan";
    }
    class Dessert {
        static final String NAME = "cake";
    }
    // 어떤게 먼저 컴파일 되느냐에 따라 NAME이 달라지는 위험이 있음.
    // 각각 파일로 분리하던가, 아니면 정적 멤버 클래스로 바꾸면된다.
}

class Test {
//    public static void main(String[] args) {
//        System.out.println(Utensil.NAME + Dessert.NAME);
//    }

    private static class Utensil {
        static final String NAME = "pan";
    }

    private static class Dessert {
        static final String NAME = "cake";
    }
}