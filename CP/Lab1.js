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

/*
* -------------------------------------------------------------
* */

function bubbleSort(a){
    var n = a.length;
    for (var i = 0; i < n-1; i++){ // Выполняется для каждого элемента массива, кроме последнего.
        for (var j = 0; j < n-1-i; j++){ // Для всех последующих за текущим элементов
            if (a[j+1] < a[j]){ // выпоняется проверка, и если следующий элемент меньше текущего
                var t = a[j+1]; a[j+1] = a[j]; a[j] = t; // то эти элементы меняются местами.
            }
        }
    }
    return a;
};

function selectionSort(a){
    var n = a.length;
    for (var i=0; i<n-1; i++){ // Выполняется для каждого элемента массива, кроме последнего.
        var min = i; // В качестве текущего минимального устанавливается текущий элемент,
        for (var j=i+1; j<n; j++){ // а для всех последующих элементов
            if (a[j] < a[min]) min = j; // выпоняется проверка: если следующий элемент меньше текущего, он устанавливается в качестве минимального значения.
            var t = a[min]; a[min] = a[i]; a[i] = t; // Минимальный и текущий элементы меняются местами (если текущий = минимальный, то ничего страшного не случится).
        }
    }
    return a;
};

// Сортировка вставками
function insertionSort(a){
    var n = a.length;
    for (var i=0; i<n; i++){ // Выполняется для каждого элемента массива.
        var v = a[i], j = i-1; // Определяется значение текущего элемента, а также индекс предыдущего элемента.
        while(j >= 0 && a[j] > v){ // Пока индекс предыдущего элемента >= 0 и его значение больше значения текущего элемента.
            a[j+1] = a[j]; // Значением следующего за текущим элемента массива становится значение предыдущего элемента.
            j--;
        }
        a[j+1] = v; // Значением следующего за текущим элемента массива становится значение текущего элемента
    }
    return a;
};

let array = [];
let len = +prompt("Размер массива");
for (let i = 0; i < len; i++) {
    let val = prompt("Значение элемента " + (i+1));
    array.push(val);
}


console.log(bubbleSort(array));
console.log(selectionSort(array));
console.log(insertionSort(array));