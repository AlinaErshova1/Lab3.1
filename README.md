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



### 2. Выбор структуры данных.


### 2. Алгоритм



### 4. Программа

```
import java.io.PrintStream;
import java.util.Scanner;
class Check{
    double []set;

    public Check(double []s){
        for(int i = 0; i<s.length; i++){
            for(int j = i+1; j<s.length; j++){
                double []s1 = new double[s.length-1];
                if(s[i]==s[j]){
                    for(int k = 0; k<j; k++)
                        s1[k] = s[k];
                    for(int k = j; k<s.length-1; k++)
                        s1[k] = s[k+1];
                    s = s1;
                }
            }
        }
        set = s;
    }


    public Check(MySet sss){
        double []t = new double[sss.count()];
        for(int i = 0; i<sss.count(); i++){
            t[i] = sss.value(i);
        }
        set = t;
    }

    public int length(){
        int l = 0;
        for(int i = 0; i< set.length; i++)
            l++;
        return l;
    }

    public double Value(int x){
        double value = 0;
        for(int i =0; i< set.length; i++){
            if (x==i)
                value = set[i];
        }
        return value;
    }

    public boolean in(double x){
        int yes = 0;
        for (int i = 0; i< set.length; i++)
            if (x == set[i])
                yes++;
        return yes==1;
    }

}
class MySet{
    public static Scanner in = new Scanner(System.in);
    double []st = new double[0];
    Check set = new Check(st);

    //Вспомогательный метод
    public double value(int x){
        return set.Value(x);
    }

    //Создание множества из чисел, вводимых с клавиатуры
    public MySet(int n){
        double []s = new double[n];
        for (int i = 0; i<n; i++)
            s[i] = in.nextInt();
        set = new Check(s);
    }

    //создание множества из пустого списка
    public MySet(){
        double []st = new double[0];
        Check set = new Check(st);
    }

    //создание мн-ва из массива
    public MySet(double []m){
        double []s = new double[m.length];
        for (int i = 0; i< m.length; i++)
            s[i] = m[i];
        set = new Check(s);
    }


    //Добавление элемента
    public void add(double x){
        double []s = new double[set.length()+1];
        for (int i = 0; i< set.length(); i++)
            s[i] = set.Value(i);
        s[set.length()] = x;
        set = new Check(s);
    }

    //Удаление эл-та
    public void remove(double x){
        int ind = 0;
        for(int i = 0; i< set.length(); i++)
            if (set.Value(i) == x)
                ind = i;
        double []s = new double[set.length()-1];
        for(int i = 0; i<ind; i++)
            s[i] = set.Value(i);
        for(int i = ind; i<set.length()-1; i++)
            s[i] = set.Value(i+1);
        set = new Check(s);
    }

    //Подсчёт количества элементов
    public int count(){
        return set.length();

    }

    //Проверка принадлежности элемента
    public boolean belong(double x){
        return set.in(x);

    }

    //Объединение множеств
    public MySet Union(MySet ll){
        Check l1 = new Check(ll); //превращаем в список, чтобы затем переделать в Check
        double []u = new double[l1.length() + set.length()];
        for(int i = 0; i<l1.length(); i++) {
            u[i] = l1.Value(i);
        }
        for (int i = 0 ; i < set.length(); i++) {
            u[i + l1.length()] = set.Value(i);
        }
        return new MySet(u);
    }

    public MySet Union(Check ll){ //превращаем в список, чтобы затем переделать в Check
        double []u = new double[ll.length() + set.length()];
        for(int i = 0; i<ll.length(); i++) {
            u[i] = ll.Value(i);
        }
        for (int i = 0 ; i < set.length(); i++) {
            u[i + ll.length()] = set.Value(i);
        }
        return new MySet(u);
    }

    //Пересечение мн-тв
    public MySet Intersection(MySet ll){
        Check l1 = new Check(ll);
        double []u = new double[0];
        if (l1.length() < set.length()){
            for(int i = 0; i< l1.length(); i++) {
                for(int k = 0; k<set.length(); k++){
                    if(l1.Value(i)==set.Value(k)){
                        double[] newu = new double[u.length + 1];
                        for(int j = 0; j<u.length; j++)
                            newu[j]=u[j];
                        newu[u.length] = l1.Value(i);
                        u = newu;
                    }
                }
            }
        }
        else{
            for(int i = 0; i< set.length(); i++) {
                for(int k = 0; k<l1.length(); k++){
                    if(set.Value(i)==l1.Value(k)){
                        double[] newu = new double[u.length + 1];
                        for(int j = 0; j<u.length; j++)
                            newu[j]=u[j];
                        newu[u.length] = set.Value(i);
                        u = newu;
                    }
                }
            }
        }
        return new MySet(u);
    }

    public MySet Intersection(Check ll) {
        double[] u = new double[0];
        if (ll.length() < set.length()) {
            for (int i = 0; i < ll.length(); i++) {
                for (int k = 0; k < set.length(); k++) {
                    if (ll.Value(i) == set.Value(k)) {
                        double[] newu = new double[u.length + 1];
                        for (int j = 0; j < u.length; j++)
                            newu[j] = u[j];
                        newu[u.length] = ll.Value(i);
                        u = newu;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < set.length(); i++) {
                for (int k = 0; k < ll.length(); k++) {
                    if (set.Value(i) == ll.Value(k)) {
                        double[] newu = new double[u.length + 1];
                        for (int j = 0; j < u.length; j++)
                            newu[j] = u[j];
                        newu[u.length] = set.Value(i);
                        u = newu;
                    }
                }
            }
        }
        return new MySet(u);
    }

    //симметрическая разность
    public MySet SymmetricDifference(MySet ll){
        MySet inter = ll.Intersection(set);
        MySet un = ll.Union(set);
        double []m = new double[un.count() - inter.count()];
        int ind = 0;
        for (int i = 0; i<un.count(); i++){
            if (!inter.belong(un.value(i))){
                m[ind] = un.value(i);
                ind++;
            }
        }
        return new MySet(m);
    }

    public void Difference(MySet ll){
        MySet inter = ll.Intersection(set);
        double []m = new double[set.length() - inter.count()];
        int ind = 0;
        for(int i = 0; i<set.length(); i++){
            if (!inter.belong(set.Value(i))){
                m[ind] = set.Value(i);
                ind++;
            }
        }
        set = new Check(m);
    }

    public boolean equalQ(MySet ll){
        Check l1 = new Check(ll);
        if (l1.length() != set.length())
            return false;
        else{
            int c = 0;
            for (int i = 0; i<set.length(); i++) {
                if (ll.belong(set.Value(i))) {
                    c++;
                }
            }
            return c == set.length();
        }
    }

    public String nested(MySet ll){
        Check l1 = new Check(ll);
        if (l1.length()>set.length()){
            int c = 0;
            for (int i = 0; i < set.length(); i++){
                if (l1.in(set.Value(i)))
                    c++;
            }
            if (c == set.length())
                return "Текущее мн-во содержится в переданном";
            else
                return "Ни одно множество не содержится в другом";
        }
        else{
            int c = 0;
            for (int i = 0; i < l1.length(); i++){
                if (set.in(l1.Value(i)))
                    c++;
            }
            if (c == l1.length())
                return "Переданное мн-во содержится в текущем";
            else
                return "Ни одно множество не содержится в другом";
        }
    }

    @Override
    public String toString(){
        String output = "";
        if (set.length()>0) {
            output = String.format("%.2f",set.Value(0)) ;
            for (int i = 1; i < set.length(); i++)
                output += ", " + String.format("%.2f", set.Value(i)) ;
        }
        return "{" + output + "}";
    }

}
```

### 5. Анализ правильности решения

