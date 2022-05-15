package me.whiteship.chapter01.item02.builder;

import lombok.Builder;

@Builder
class NutritionFactsBuilderTest {

    private final int servingSize;
    private final int servings;

    public static void main(String[] args) {
        // TODO : 모든 매개변수를 받는 생성자가 생겨버린다!
        // TODO : 필수값 지정할 수 없게 된다!
        // TODO : 만약 필수적인 값을 꼭 받아야 한다면 직접 빌더를 구현해야 한다.
        NutritionFactsBuilderTest nutritionFactsBuilderTest = new NutritionFactsBuilderTestBuilder()
                .servings(1)
                .build();
    }
}
