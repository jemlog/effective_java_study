package me.whiteship.chapter01.item02.builder;

// 코드 2-3 빌더 패턴 - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다. (17~18쪽)
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static void main(String[] args) {
        NutritionFacts cocaCola = new Builder(240, 8) // TODO : 필수속성은 무조건 넣고 가자.
                .calories(100)
                .sodium(35)
                .carbohydrate(27).build();
    }

    // TODO : 필수적인 필드와 필수적이지 않은 필드가 있고, 매개변수가 많아질때는 빌더 사용!
    public static class Builder {
        // 필수 매개변수
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 - 기본값으로 초기화한다.
        private int calories      = 0;
        private int fat           = 0;
        private int sodium        = 0;
        private int carbohydrate  = 0;

        public Builder(int servingSize, int servings) { // TODO : 필수로 받아야 하는 값들 빌더 생성자로 넣어줌
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int val) // TODO : 메서드 체이닝을 가능하게 해준다.
        { calories = val;      return this; }
        public Builder fat(int val)
        { fat = val;           return this; }
        public Builder sodium(int val)
        { sodium = val;        return this; }
        public Builder carbohydrate(int val)
        { carbohydrate = val;  return this; }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
