# balance-commandline
Expectations

● Show how you work and how you think

● Demonstrate problem-solving capabilities, challenge and ask questions

● Write good and tested code

● Can we work together? (For us and for you!)


The framework of the interview:

45 min + 15min 1st checkpoint

45 min + 15min 2nd checkpoint

45 min + 15min final checkpoint


Tips

● Start simple and iterate

● Explain your work

● Relax and be yourself!



Design and implement a command-line balance calculator program that accepts expenses and incomes as data input, and calculates the balance per year, month, or day.


Balance is defined as the sum of all incomes over the period, minus all expenses over the period. Balance for 2020: (all incomes for 2020 - all expenses for 2020)





Example


>>INCOME 2020/01/01 salary 500

>>PRINT YEAR 2020

500

>>EXPENSE 2020/10/12 coffee 5

>>EXPENSE 2020/10/11 lunch 25

>>PRINT YEAR 2020

470

>>PRINT YEAR 2021

0

>>INCOME 2020/10/25 stock-dividend 40

>>PRINT MONTH 2020/11

0

>>PRINT MONTH 2020/10

10

>>PRINT DAY 2020/10/11

-25


Commands


EXPENSE <date> <description> <amount>

INCOME <date> <description> <amount>

PRINT DAY <year>/<month>/<day>

PRINT MONTH <year>/<month>

PRINT YEAR <year>

EXIT



The program must accept the above commands as plain text

Basic validation of input is enough for the exercise

Performance is not the main focus of the exercise

Try to get something working first, then we can iterate to improve and polish