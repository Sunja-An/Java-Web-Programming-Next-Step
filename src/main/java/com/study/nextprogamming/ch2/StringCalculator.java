package com.study.nextprogamming.ch2;

public class StringCalculator {
    // 메서드의 역할
    // 한 Method 의 한 역할만 수행해야한다.
    // 그러면 service 들이 여러 개 있잖아.
    // 예를 들어서 내가 지금 Email 전송 Service Method 를 하나 만든다고 치면,
    // 어떤게 한 Method 에서 여러 개의 역할을 수행한다는 게 어떤느낌인거지?
    // 지금은 add, sub, multi -> X (O)
    // 근데 서비스로직으로 돌아가버리면, 내가 ConfirmEmail 이라해도, 안에서 뭐 회원가입 다 진행할 수도 있었고,
    // 여러가지 있을건데 이건 판단 어케함?
    int add(String text) throws RuntimeException{
        // 요구사항 1
        // Text 아무 입력없을 시, 0 반환
        if(text.isEmpty()){
            return 0;
        }

        // 요구사항 2 + 3
        // Custom 구분자 등록된 문자열 포함
        // 쉼표 + 콜론으로 구분자가 들어왔을 시, 숫자의 합 전달
        int sum = 0;

        String newText = text;
        String separator = ",|:";
        String[] firstDivide = text.split("//");
        String[] numbers;

        if(firstDivide.length == 2){
            String[] secondDivide = firstDivide[1].split("\n");
            String customSeparator = secondDivide[0];
            separator += "|" + customSeparator;
            newText = secondDivide[1];
        }

        numbers = newText.split(separator);
        for(String number : numbers){
            sum += detactNegativeNum(number);
        }
        return sum;
    }

    int detactNegativeNum(String text) throws RuntimeException{
        int result = Integer.parseInt(text);
        if(result < 0){
            throw new RuntimeException();
        }
        return result;
    }
}
