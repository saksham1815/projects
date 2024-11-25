function checkNumberProperties() {
    var number = document.getElementById('number').value;

    // Convert the input string to a number
    number = parseInt(number);

    var isPalindrome = isPalindrome(number);
    var isArmstrong = isArmstrong(number);
    var isPerfect = isPerfect(number);
    var isStrong = isStrong(number);
    var isInFibonacci = isInFibonacci(number);
    var isPrime = isPrime(number);
    var isComposite = isComposite(number);
    var factorial = factorial(number);
    var evenOrOdd = (number % 2 === 0) ? "Even" : "Odd";

    var result = "<h3>Number Properties for " + number + "</h3>";
    result += "<p>Palindrome: " + isPalindrome + "</p>";
    result += "<p>Armstrong: " + isArmstrong + "</p>";
    result += "<p>Perfect: " + isPerfect + "</p>";
    result += "<p>Strong: " + isStrong + "</p>";
    result += "<p>In Fibonacci series: " + isInFibonacci + "</p>";
    result += "<p>Prime: " + isPrime + "</p>";
    result += "<p>Composite: " + isComposite + "</p>";
    result += "<p>Factorial: " + factorial + "</p>";
    result += "<p>Even/Odd: " + evenOrOdd + "</p>";

    document.getElementById('result').innerHTML = result;
}

function isPalindrome(number) {
    var reversedNumber = parseInt(number.toString().split('').reverse().join(''));
    return number === reversedNumber;
}

function isArmstrong(number) {
    var strNumber = number.toString();
    var power = strNumber.length;
    var sum = 0;
    for (var i = 0; i < strNumber.length; i++) {
        sum += Math.pow(parseInt(strNumber[i]), power);
    }
    return sum === number;
}

function isPerfect(number) {
    var sum = 0;
    for (var i = 1; i <= number / 2; i++) {
        if (number % i === 0) sum += i;
    }
    return sum === number;
}

function isStrong(number) {
    var sum = 0;
    var strNumber = number.toString();
    for (var i = 0; i < strNumber.length; i++) {
        sum += factorial(parseInt(strNumber[i]));
    }
    return sum === number;
}

function isInFibonacci(number) {
    var a = 0, b = 1;
    while (a <= number) {
        if (a === number) return true;
        var temp = a + b;
        a = b;
        b = temp;
    }
    return false;
}

function isPrime(number) {
    if (number <= 1) return false;
    for (var i = 2; i <= Math.sqrt(number); i++) {
        if (number % i === 0) return false;
    }
    return true;
}

function isComposite(number) {
    return !isPrime(number);
}

function factorial(number) {
    var factorial = 1;
    for (var i = 1; i <= number; i++) {
        factorial *= i;
    }
    return factorial;
}
