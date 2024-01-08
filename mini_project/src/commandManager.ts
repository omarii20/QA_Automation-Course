import * as readlineSync from 'readline-sync';
import { CheckNationalityApi } from './checkNationalityApi';

export class CommandManager {
    checkPalindrome() {
        const input = readlineSync.question('Enter a string: ');
        let start = 0;
        let end = input.length - 1;
        let isPalindrome: Boolean  = true;
        while(start < end){
            if(input[start] !== input[end]){
                isPalindrome = false;
            }
            start++;
            end--; 
        }
        console.log(`Is Palindrome: ${isPalindrome}\n`);
    }

    checkLowercase() {
        const input = readlineSync.question('Enter a string: ');
        if (this.isLettersOnly(input)) {
            const isLowercase = input === input.toLowerCase();
            console.log(`Is Lowercase: ${isLowercase}\n`);
        } else {
            console.log('The input contains characters other than letters.\n');
        }
    }

    isLettersOnly(input: string) {                          // check if the checkLowercase function string enterted is only letters.
        const onlyLetters = /^[A-Za-z]+$/;
        return onlyLetters.test(input);
    }
    
    checkDigits() {
        const input = readlineSync.question('Enter a string: ');
        let counter: number = 0;
        let isDigits: Boolean = true;
        while (counter < input.length) {
            if (isNaN(parseInt(input[counter]))) {          // If the character is not a digit, parseInt will return NaN (Not a Number).
                isDigits = false;
            }
            counter++;
        }
        console.log(`Are all characters digits: ${isDigits}\n`);
    }

    checkArmstrong() {
        const input = readlineSync.question('Enter a number: ');
        const num = parseInt(input, 10);
        const isArmstrong = this.isArmstrongNumber(num);
        console.log(`Is Armstrong Number: ${isArmstrong}\n`);
    }

    isArmstrongNumber(num: number): boolean {
        const numStr: string = num.toString();
        let sum: number = 0;

        for (let i = 0; i < numStr.length; i++) {                   
            const digitValue: number = parseInt(numStr[i], 10);     //digitValue is the numerical value of the current digit
            sum += Math.pow(digitValue, numStr.length);             //calculates the power of the digitValue using the Math.pow function
                                                                    //numStr.length is the total number of digits in the number.
        }
        return num === sum;
    }

    async checkNationality() {
        const firstName = readlineSync.question('Enter a first name: ');
        const newApi = new CheckNationalityApi();
        const result = await newApi.checkNationality(firstName);
        if(result){
            console.log(`${result?.country } ${result?.probability}`);
        }else{
            console.log(`No country data found for ${firstName} name.`)
        }
    }    
}