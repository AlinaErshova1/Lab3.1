# Lab3
## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2401`

#### Выполнила: `Ершова Алина Дмитриевна`

#### Вариант: `12`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Выбор структуры данных](#2-выбор-структуры-данных)
- [Алгоритм](#3-алгоритм)
- [Программа](#4-программа)
- [Анализ правильности решения](#5-анализ-правильности-решения)

### 1. Постановка задачи 

>Разработать программу для работы с множествами, представляющими списки уникальных элементов. Реализовать базовые операции, включая добавление и удаление элементов, а также сложные операции, такие как объединение, пересечение и проверка вложенности множеств .

Данную задачу можно разбить на подзадачи:

1.Создание класса Check, в котором будет проверяться является ли массив множеством. В нем, для удобства, будут написаны следующее методы:

`length` - находит и возвращает длину

``Value`` - находит и возвращает элемент множества по индексу

`in` - проверяет принадлежность объекта множеству

2.Создание класса MySet, в котором будут реализованны следующие методы:

`add` - добавление элемента в текущее множество

`remove` - удаление элемента из текущего множества

`count` - подсчёт количества элементов в текущем множестве

`belong` - проверка принадлежности элемента текущему множеству

`Union` - объединение множеств (текущего  и переданного)

`Intersection` - пересечение множеств (текущего и переданного)

`SymmetricDifference` - симметрическая разность множеств (элементы, которые есть либо в текущем, либо в переданном множествах)

`Difference` - разность множеств (из текущего множества удаляет элементы переданного)

`equalQ` - сравнение множеств

`nested` - проверка вложенности множеств

Фактически во всей программе я буду работать с массивами, из которых с помощью класса Check будут удаляться повторяющиеся элементы.


### 2. Выбор структуры данных.

В классе `Check` я использую массив вещественных чисел `set`, вспомогательны массив вещественных чисел `m` и “флаг” `yes` (тип данных `int`).

В классе `MySet` я работаю с множеством `set` (текущее множество) типа данных - `Check`.Также использую массивы `m` и `s` вещественных чисел, длины которых варьируются в зависимости от метода, в котором описаны эти массивы.  В описании некоторых методов использую переменную `s2` типа `Check`. В реализации некоторых методов использую переменные типа данных `MySet`. Кроме того использую переменную `ind` типа данных `int` для хранения индекса элемента и переменую `c` того же типа данных для подсчёта кол-ва элементов.

### 3. Алгоритм

Описание работы требуемых методов:

Так как в классе `Check` я работаю с массивом, то методы `length` и `Value` “встроенные” методы, а метод `in()` проверяет принадлежит ли элемент текущему массиву: проходит по всему массиву и меняет флаг, если элемент в массиве присутствует. Возвращает true/false в зависимости от значения флага.

Класс `MySet`:

`add` - в качестве параметра выступает число, которое необходимо добавить в текущее множество. Буду создавать вспомогательный массив, длина которого больше текущего множества на 1. Перезаписываю элементы из текущего множества, а в конец добавляю необходимое число. Обновляю текущий массив.

`remove` - в качестве параметра выступает число, которое необходимо удалить из  текущего множества. Нахожу его индекс. Создаю вспомогательный  массив длины, меньшей на единицу, чем исходный. Перезаписываю элементы с 1го и до предшествующего нужному, “пропускаю” число, которое нужно удалить и перезаписываю, продолжая со следующего элемента и до конечного. Обновляю текущий массив.

`count` - использую метод `length()` класса `Check`.

`belong` - использую метод `in()` класса `Check`.

`Union` - создаю вспомогательный массив, длина которого равна сумме текущего и переданного множеств. Записываю сначала элементы переданного множества, а затем - текущего. Возвращаю новое множество, сделанное из получившегося списка (вернёт нужной длины).

`Intersection` - с помощью двойного цикла проверяют: принадлежит ли элемент двум множествам. Если принадлежит, то добавляю этот элемент в вспомогательный список, перед этим перезаписав его и увеличив его длину на единицу. Возвращаю полученный вспомогательный список.

`SymmetricDifference` - нахожу объединение и пересечение текущего и переданного множеств. Проверяю: если элемента из объединения нет в пересечении, добавляю его во вспомогательный список. Возвращаю полученный вспомогательный список.

`Difference` - нахожу пересечение множеств. Если элемента из текущего множества нет в объединение, добавляю в вспомогательный массив. Перезаписываю текущий массив.

`equalQ` - увеличиваю счётчик, если элемент из текущего множества есть в переданном. Возвращаю: верно ли что счётчик равен длине текущего множества.

`nested` - если длина текущего множества меньше длины переданного множества, проверяю: все ли элементы есть в переданном. И наоборот, если длина переданного массива меньше текущего.

### 4. Программа

```java
import java.util.Scanner;

class MySet {
    public static Scanner in = new Scanner(System.in);
    double[] set = new double[0];

    public static double[] check(double[] set) {
        double[] m = new double[set.length];
        int ind = 0;
        for (int i = 0; i < set.length; i++) {
            for (int j = i + 1; j < set.length; j++) {
                if (set[i] != set[j]) {
                    m[ind] = set[i];
                    ind++;
                }
            }
        }
        return m;
    }


    public boolean in(double x) {
        int flag = 0;
        for (int i = 0; i < set.length; i++) {
            if (set[i] == x)
                flag++;
        }
        return flag == 1;
    }


    //Создание множества из чисел, вводимых с клавиатуры
    public MySet(int n) {
        double[] m = new double[n];
        for (int i = 0; i < n; i++)
            m[i] = in.nextInt();
        MySet.check(m);
    }

    //создание множества из пустого списка
    public MySet() {
        double[] st = new double[0];
        MySet.check(st);
    }

    //создание мн-ва из массива
    public MySet(double[] m) {
        double[] s = new double[m.length];
        for (int i = 0; i < m.length; i++)
            s[i] = m[i];
        MySet.check(s);
        ;
    }

    //Добавление элемента
    public void add(double x) {
        double[] s = new double[set.length + 1];
        for (int i = 0; i < set.length; i++)
            s[i] = set[i];
        s[set.length] = x;
        set = MySet.check(s);
        ;
    }

    //Удаление эл-та
    public void remove(double x) {
        int ind = 0;
        for (int i = 0; i < set.length; i++)
            if (set[i] == x)
                ind = i;
        double[] s = new double[set.length - 1];
        for (int i = 0; i < ind; i++)
            s[i] = set[i];
        for (int i = ind; i < set.length - 1; i++)
            s[i] = set[i + 1];
        set = MySet.check(s);
        ;
    }

    //Подсчёт количества элементов
    public int count() {
        return set.length;

    }


    //Объединение множеств
    public double[] union(double[] s1) {
        double[] s2 = MySet.check(s1);
        double[] m = new double[s2.length + set.length];
        for (int i = 0; i < s2.length; i++) {
            m[i] = s2[i];
        }
        for (int i = 0; i < set.length; i++) {
            m[i + s2.length] = set[i];
        }
        return MySet.check(m);
    }


    //Пересечение мн-тв
    public double[] intersection(double[] s1) {
        double[] s2 = MySet.check(s1);
        double[] m = new double[0];
        if (s2.length < set.length) {
            for (int i = 0; i < s2.length; i++) {
                if (new MySet(set).in(s2[i])) {
                    double[] newu = new double[m.length + 1];
                    for (int j = 0; j < m.length; j++)
                        newu[j] = m[j];
                    newu[m.length] = s2[i];
                    m = newu;
                }
            }
        } else {
            for (int i = 0; i < set.length; i++) {
                if (new MySet(s2).in(set[i])) {
                    double[] newu = new double[m.length + 1];
                    for (int j = 0; j < m.length; j++)
                        newu[j] = m[j];
                    newu[m.length] = set[i];
                    m = newu;
                }
            }
        }
        return m;
    }


    //симметрическая разность
    public MySet SymmetricDifference(MySet s1) {
        double[] inter = s1.intersection(set);
        double[] un = s1.union(set);
        double[] m = new double[un.length - inter.length];
        int ind = 0;
        for (int i = 0; i < un.length; i++) {
            if (!new MySet(inter).in(un[i])) {
                m[ind] = un[i];
                ind++;
            }
        }
        return new MySet(m);
    }

    //разность
    public void Difference(MySet s1) {
        double[] inter = s1.intersection(set);
        double[] m = new double[set.length - inter.length];
        int ind = 0;
        for (int i = 0; i < set.length; i++) {
            if (!new MySet(inter).in(set[i])) {
                m[ind] = set[i];
                ind++;
            }
        }
        set = MySet.check(m);
        ;
    }

    //сравнение
    public boolean equalQ(double[] s1) {
        double[] s2 = MySet.check(s1);
        ;
        if (s2.length != set.length)
            return false;
        else {
            int c = 0;
            for (int i = 0; i < set.length; i++) {
                if (new MySet(s1).in(set[i])) {
                    c++;
                }
            }
            return c == set.length;
        }
    }

    //проверка вложенности
    public String nested(double[] s1) {
        double[] s2 = MySet.check(s1);
        if (s2.length > set.length) {
            int c = 0;
            for (int i = 0; i < set.length; i++) {
                if (new MySet(s2).in(set[i]))
                    c++;
            }
            if (c == set.length)
                return "Текущее мн-во содержится в переданном";
            else
                return "Ни одно множество не содержится в другом";
        } else {
            int c = 0;
            for (int i = 0; i < s2.length; i++) {
                if (new MySet(set).in(s2[i]))
                    c++;
            }
            if (c == s2.length)
                return "Переданное мн-во содержится в текущем";
            else
                return "Ни одно множество не содержится в другом";
        }
    }

    @Override
    public String toString() {
        String output = "";
        if (set.length > 0) {
            output = String.format("%.2f", set[0]);
            for (int i = 1; i < set.length; i++)
                output += ", " + String.format("%.2f", set[i]);
        }
        return "{" + output + "}";
    }

}

```

### 5. Анализ правильности решения


1. Проверка на удаление повтор. элементов
    - **Input**:
        ```
        s = {0,00, 2,00, 4,00, 6,00, 8,00, 2,00, 6,00};

        out.println(new Check(s));
        ```

    - **Output**:
        ```
        {0,00, 2,00, 4,00, 6,00, 8,00}
        ```

2. Метод add()
   - **Input**:
        ```
        s = {0,00, 2,00, 4,00, 6,00, 8,00, 2,00, 6,00};

        out.println(s.add(10));
        ```

    - **Output**:
        ```
        {0,00, 2,00, 4,00, 6,00, 8,00, 10,00}
        ```

3. Метод remove()
      - **Input**:
        ```
        s = {0,00, 2,00, 4,00, 6,00, 8,00};

        out.println(s.remove(4));
        ```

    - **Output**:
        ```
        {0,00, 2,00, 6,00, 8,00}
        ```

4. Метод count()
      - **Input**:
        ```
        s = {0,00, 2,00, 4,00, 6,00, 8,00};

        out.println(s.count());
        ```

    - **Output**:
        ```
        5
        ```

5. Метод belong()
      - **Input**:
        ```
        s = {0,00, 2,00, 4,00, 6,00, 8,00};

        out.println(s.belong(6)):

        out.println(s.belong(7)):
        ```

    - **Output**:
        ```
        true

        false 
        ```

6. Метод Union()
      - **Input**:
        ```
        s = {0,00, 2,00, 4,00, 6,00, 8,00};
        
        s1={3,00, 1,00, 2,00, 6,00, 1,00, 5,00};
        
        out.println(s.Union(s1));
        ```

    - **Output**:
        ```
        {3,00, 1,00, 2,00, 6,00, 5,00, 0,00, 4,00, 8,00}
        ```

7. Метод Intersection()
      - **Input**:
        ```
        s = {0,00, 2,00, 4,00, 6,00, 8,00};
        
        s1={3,00, 1,00, 2,00, 6,00, 1,00, 5,00};
        
        out.println(s.Intersection(s1));
        ```

    - **Output**:
        ```
        {2,00, 6,00}
        ```


8. Метод SymmetricDifference()
      - **Input**:
        ```
        s = {0,00, 2,00, 4,00, 6,00, 8,00};
        
        s1={3,00, 1,00, 2,00, 6,00, 1,00, 5,00};
        
        out.println(s.SymmetricDifference(s1));
        ```

    - **Output**:
        ```
        {0,00, 4,00, 8,00, 3,00, 1,00, 5,00}
        ```

9. Метод Difference()
      - **Input**:
        ```
        s = {0,00, 2,00, 4,00, 6,00, 8,00};
        
        s1={3,00, 1,00, 2,00, 6,00, 1,00, 5,00};
        
        s.Difference(s1);
        
        out.println(s);
        ```

    - **Output**:
        ```
        {0,00, 4,00, 8,00}
        ```


10. Метод equalQ()
      - **Input**:
        ```
        s = {0,00, 2,00, 4,00, 6,00, 8,00};
        
        s1={3,00, 1,00, 2,00, 6,00, 1,00, 5,00};
        
        out.println(s.equalQ(s1));
        
        s1={8,00, 4,00, 0,00, 6,00, 2,00};
        
        out.println(s.equalQ(s1));
        ```

    - **Output**:
        ```
        false
        
        true
        ```


11. Метод nested()
      - **Input**:
        ```
        s = {0,00, 2,00, 4,00, 6,00, 8,00};
        
        s1={3,00, 1,00, 2,00, 6,00, 1,00, 5,00};
        
        out.println(s.nested(s1));
        
        s1={2,00, 8,00, 0,00};
        
        out.println(s.nested(s1));
        
        s1={10,00, 8,00, 6,00, 4,00, 2,00, 0,00};
        
        out.println(s.nested(s1));
        ```

    - **Output**:
        ```
        Ни одно множество не содержится в другом
        
        Переданное мн-во содержится в текущем
        
        Текущее мн-во содержится в переданном

        ```
