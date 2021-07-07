package com.ejava.item;


/**
 * 태그달린 클래스는 작성하지 말아라 -> 사실상 실무에서 본 적이 없음.
 * 클래스 계층구조로 생성자 사용해라
 */
public class Item23 {

    class Circle extends Figure {
        final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * (radius * radius);
        }
    }

    class Rectangle extends Figure {
        final double length;
        final double width;

        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        double area() {
            return length * width;
        }
    }
    // 클래스형 계층구조면 쉽게 새로운 모양을 추가할 수 있음
    class Square extends Rectangle {
        Square(double side) {
            super(side, side);
        }
    }


}

abstract class Figure {
    abstract double area();
}


/**
 * not used
 */
class NotusedFigure {
    // 모양은 사각형과 원형이 있음.
    enum Shape {RECTANGLE, CIRCLE}

    final Shape shape; // 태그 필드 : 현재 모양을 나타내는 데 쓰임

    // 다음 필드들은 모양이 사각형(RECTANGLE)일 때만 쓰인다.
    double length;
    double width;

    // 다음 필드느 모양이 원(CIRCLE)일 때만 쓰인다.
    double radius;

    // 원
    NotusedFigure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형
    NotusedFigure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}