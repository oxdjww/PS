## Tips

```
💡 까먹지 말자
```

1. Stream API 사용법

- List, array 등 연속된 정보를 stream으로 만든다 (Stack도 가능)
  - `Arrays.stream($value)`
  - `Streams.of($value)`
  - `IntStream.range($startIndex, $endIndex+1)` -> 인덱스 기반 빠른 접근. (boxing이 생략되어 성능상 이점)
    | 특징         | 일반 `Stream<T>`                 | 원시 스트림 (`IntStream`, `LongStream`, `DoubleStream`) |
    |--------------|----------------------------------|-------------------------------------------------------|
    | 데이터 유형  | 객체                             | 원시 타입 (int, long, double)                         |
    | 박싱/언박싱  | 필요                             | 불필요                                                |
    | 특화 메서드  | `filter`, `map` 등               | `sum`, `average`, `min`, `max` 등 원시 타입에 특화된 메서드 |
    | 사용 예      | `Stream<String>`, `Stream<Integer>` | `IntStream`, `LongStream`, `DoubleStream`            |
- 중간 연산을 실행 (map, filter 등)
- 최종 연산 (forEach, reduce, sum 등)
- Iterate function
  - `IntStream is = IntStream.iterate($startValue, $endCondition, $logic)`
  - `Stream<SeedClass> ns = Stream.iterate($startValue, $endCondition, $logic)`
 
2. List

- `List.subList(start, end);`
  - start부터 end-1 인덱스까지 추출해서 새로운 인덱스로
- `Arrays.copyOfRange(originalArray, start, end);`
- Array to List
  - ```
    List<Integer> list = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
    ```
- List to Array
  - ```
    list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    ```
3. stream으로 list 조건 순회
- ```
  IntStream.range(0, num_list.length)
            .filter(idx -> num_list[idx] < 0)
            .findFirst()
            .orElse(-1);
  ```

4. 문자열 찾기
- 뒤에서부터 찾기
  - `String.lastIndexOf(찾을 문자, 시작할 위치(option))`
- 앞에서부터 찾기
  - `String.IndexOf(찾을 문자, 시작할 위치(option))`
