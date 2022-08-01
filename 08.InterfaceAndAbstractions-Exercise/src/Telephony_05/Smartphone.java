package Telephony_05;

import java.util.List;

public class Smartphone implements Browsable, Callable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        if (urls.size() == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for (String url : urls) {

            boolean hasDigit = false;
            char [] urlCharArray = url.toCharArray();

            for (char c : urlCharArray) {
                if(Character.isDigit(c)) {
                    hasDigit = true;
                }
            }

            if (hasDigit) {
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append("Browsing: " + url + "!").append(System.lineSeparator());
            }

        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        if (numbers.size() == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for (String number : numbers) {
        boolean isNotDigit = false;
        char [] numberCharArray = number.toCharArray();

            for (char c : numberCharArray) {
                if(!Character.isDigit(c)) {
                    isNotDigit = true;
                }
            }

            if (isNotDigit) {
                sb.append("Invalid number!").append(System.lineSeparator());
            } else {
            sb.append("Calling... " + number).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
