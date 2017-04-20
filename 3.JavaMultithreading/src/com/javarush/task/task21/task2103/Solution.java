package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return c;
    }

    public static void main(String[] args) {

    }
}


/*
    // посмотри про карты Карно
    Полезные формулы:

        1. ~~a == a — закон снятия двойного отрицания
        2. a & a == a — закон идемпотентности
        3. a v a == a — закон идемпотентности
        4. a & 0 == 0
        5. a & 1 == a
        6. a v 0 == a
        7. a v 1 == 1
        8. a & ~a == 0 — закон противоречия
        9. a v ~a == 1 — закон исключенного третьего
        10. ~(a & b) == ~a v ~b — закон Де Моргана
        11. ~(a v b) == ~a & ~b — закон Де Моргана
        12. a & b == ~(~a v ~b) — закон Де Моргана
        13. a v b == ~(~a & ~b) — закон Де Моргана
        14. a => b == ~a v b — выражение импликации через отрицание и дизъюнкцию
        15. a <=> b == (a => b) & (b => a)
        16. a & (b v a) == a — закон поглощения
        17. a v (b & a) == a — закон поглощения
        18. a & (~a v b) == a & b
        19. a v (~a & b) == a v b
        20. (a & b) v (a & ~b) == a — закон склеивания
        21. (a v b) & (a v ~b) == a — закон склеивания

        1. a & b == b & a — коммутативность конъюнкции
        2. a v b == b v a — коммутативность дизъюнкции
        3. a & (b & c) == (a & b) & c — ассоциативность конъюнкции
        4. a v (b v c) == (a v b) v c — ассоциативность дизъюнкции
        5. a & (b v c) == (a & b) v (a & c) — дистрибутивность конъюнкции относительно дизъюнкции
        6. a v (b & c) == (a v b) & (a v c) — дистрибутивность дизъюнкции относительно конъюнкции
*/