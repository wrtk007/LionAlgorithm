# 3. 완전 BP 문제

## 1. 완전 BP 문제란
- 완전 탐색 (브루트 포스)
- 모든 경우의 수를 탐색. 시간은 최대
- Solution : Brute Force(for 문), 순열과 조합, 재귀함수. 비트마스크, 백트래킹, BFS/DFS

<u> <br> </u>
<hr/>
<u> <br> </u>

## 2. 순열과 조합
### 2.1. 순열
n 개의 값 중에서 r 개의 숫자를 모든 순서대로 뽑는 경우 (DFS 활용)
- 원리 : 3개의 원소 중 2개를 뽑는다고 가정하면 1개의 원소만 뽑고 나머지 2개 중에 1개 뽑기

  ex) {a,b,c} : a 뽑고 나머지 b,c 중에 하나 뽑기
- java code

```
//재귀로 구현
/**
	 * 순열 구하기
	 * 
	 * @param arr    : 기준 리스트
	 * @param result : 결과를 담아줄 리스트
	 * @param n      : 전체 갯수
	 * @param r      : 뽑을 갯수
	 */
	private static void reculsion(List<String> arr, List<String> result, int n, int r) {

		if (r == 0) { //1개 중 0개를 뽑는 경우는 탈출!

			System.out.println(result.toString());
			return;
		}

		for (int i = 0; i < n; i++) {
            //하나를 뽑아서 결과에 넣는다 {a,b,c} 중 {a} 추출
			result.add(arr.remove(i));
            //나머지 중에 하나를 뽑는다. {b,c} 중 하나 추출
			reculsion(arr, result, n - 1, r - 1);
            //재귀가 완료되면 결과 리스트에 있던 것을 다시 원본 리스트에 옮겨 줌. a를 기준으로 b,c 중 b를 뽑았다면 {a,b}/{,c} 만들어짐. 이후 b를 다시 {a,}/{b,c}에 넣어줌 
			arr.add(i, result.remove(result.size() - 1));
		}
	}
```

### 2.2. 조합
n개의 숫자 중에서 r개의 수를 순서 없이 뽑는 경우

- java code

```
// 재귀 사용
// 사용 예시 : comb(arr, visited, 0, n, r)

//depth = 현재 인덱스
static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
    if (r == 0) {
        print(arr, visited, n);
        return;
    }

    if (depth == n) { //인덱스 다 봤기 때문에 종료
        return;
    }

    //아래의 두 경우 모두 이전에 본 값들은 고려 대상이 아니기 때문에 반드시 depth는 1씩 증가
    visited[depth] = true; //현재 인덱스를 뽑는 경우
    comb(arr, visited, depth + 1, n, r - 1);

    visited[depth] = false; //현재 인덱스를 뽑지 않는 경우
    comb(arr, visited, depth + 1, n, r);
}

static void print(int[] arr, boolean[] visited, int n) {
    for (int i = 0; i < n; i++) {
        if (visited[i]) {
            System.out.print(arr[i] + " ");
        }
    }
    System.out.println();
}

```

<u> <br> </u>
<hr/>
<u> <br> </u>

### 3. 재귀 알고리즘
- 자기 자신을 다시 호출하여 작업을 수행
- 조건
    - 재귀의 호출은 같은 문제 내에서 더 범위가 작은 값, 즉, 하위 문제에 대해 이루어져야 한다.
    - 재귀함수 호출은 더 이상 반복되지 않는 base case에 도달해야 한다.
- ex) 팩토리얼


<u> <br> </u>
<hr/>
<u> <br> </u>

### 4. 백트래킹
- DFS(깊이 우선 탐색 기반)
- 노드의 유망성을 점검하고 유망하지 않으면 그 노드의 부모 노드로 돌아간 후 다른 자손의 노드를 검색하는 것
- 가지치기가 발생하기 때문에 원싲거인 방법으로 모든 경우의 수를 확인하는 알고리즘은 아니다
- 4-Queens 문제



<u> <br> </u><u> <br> </u>
<hr/>
<u> <br> </u><u> <br> </u>

### [Optional] 비트마스크
정수의 이진수 표현을 활용한 기법
- 비트 연산 : &(AND), |(OR), ^(XOR/모두 0=0, 그 외 1), -(NOT), <<(비트의 자리 왼쪽으로 한 칸 이동, 오른쪽 끝 비트에 0 삽입, 2를 곱하는 효과), >>(왼쪽 끝의 최상위 비트에는 시프트 이전의 최상위 비트가 그대로 삽입, 2를 나누는 효과),>>>(논리적 오른쪽 시프트, 비트의 자리를 오른쪽으로 한 칸 이동, 왼쪽 끝에는 항상 비트 0이 삽입)

- java의 비트 마스크

```
Integer.bitCount() 활용

//0 1 2 중 두 개를 뽑는 방법

//000부터 1000전 까지의 조건을 따져서 0~7까지 출력
for(int i=0;i<(1<<3);i++) {
    //이 중 1인 비트 2개 뽑기
    if(Integer.bitCount(i)==2) {
        System.out.println(i);
    }
}
//-> 결과로 110 101 011 = 6 5 3

//더 공부해서 이해해올게요,,,,
for(int i=0;i<(1<<3);i++) {
    if(Integer.bitCount(i)==2) {
        for(int j=0;j<3;j++) {
            if(((1<<j)&i)>0) {
                System.out.print(j+"       ");
            }
        }
        System.out.println();
    }
}
```

<u> <br> </u>
<hr />
<u> <br> </u>

참고 사이트

https://developer-mac.tistory.com/81

https://velog.io/@sungjun-jin/%EC%99%84%EC%A0%84%ED%83%90%EC%83%89

https://bcp0109.tistory.com/15

https://heekim0719.tistory.com/284

https://ko.khanacademy.org/computing/computer-science/algorithms/recursive-algorithms/a/properties-of-recursive-algorithms

https://codevang.tistory.com/297

https://whereisusb.tistory.com/214

<u> <br> </u>
<hr />
<u> <br> </u>

### 노트

-비트마스크 왜 쓰지 : 섬이 n개일때 지나갈 수 있는 다리 수. true/false로 나눌 수 있는 것처럼!
                    특정 문제에서 빠른 효과