function Vowels(arrVowels){

    var count = 0;
    var str = prompt ('Введите текст');

    for (var char of str.toLowerCase()){
        if (arrVowels.includes(char)){
            count += 1;
        }
    }
    alert (count);
}

Vowels(['а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е']);